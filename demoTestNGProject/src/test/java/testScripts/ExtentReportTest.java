package testScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportTest {
	WebDriver driver;
	ExtentTest logger;
	ExtentReports extent;

	
	@BeforeTest
	public void setup() {
		
	       System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		    driver= new ChromeDriver();
			driver.manage().window().maximize();
//			driver.get("https://www.google.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			ExtentHtmlReporter report= new ExtentHtmlReporter("F:\\Selenium_Handson\\ExtentReports\\SampleReport.html");
			extent = new ExtentReports();
			extent.attachReporter(report);
	}	

	 @Test
	  public void searchTest() {
		 logger= extent.createTest("Google Serach for Selenium search");
		  driver.get("https://www.google.com");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  Assert.assertEquals(driver.getTitle(), "Google");
		  
			WebElement element= driver.findElement(By.name("q"));
			element.sendKeys("selenium");
			element.submit();
			Assert.assertEquals(driver.getTitle(), "selenium - Google Search");
//			driver.close();
		  
	  }
	  
	  @Test
	  public void javasearchTest() {
		  logger= extent.createTest("Google Serach for Java Tutorial search");
		  driver.get("https://www.google.com");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  Assert.assertEquals(driver.getTitle(), "Google");
		  
			WebElement element= driver.findElement(By.name("q"));
			element.sendKeys("java tutorial");
			element.submit();
		    Assert.assertEquals(driver.getTitle(), "java tutoria - Google Search");
//			driver.close();		
	  } 
	  
	  @AfterMethod
	 public void teardown(ITestResult result) throws IOException { 
		  if(result.getStatus()==ITestResult.FAILURE) {
			  String tempPath= Utility.getScreenshot(driver);
			  logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(tempPath).build());
		  }
	  extent.flush();
     }
}

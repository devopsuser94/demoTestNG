package testScripts;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GooglePageTest {
	WebDriver driver;
//	@BeforeMethod
	@BeforeTest
	public void setup() {
		
	      System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		    driver= new ChromeDriver();
			driver.manage().window().maximize();
//			driver.get("https://www.google.com");		
	}
  @Test(retryAnalyzer= RetryAnalyzerTest.class)
  public void searchTest() {
	  driver.get("https://www.google.com");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  Assert.assertEquals(driver.getTitle(), "Google");
	  
		WebElement element= driver.findElement(By.name("q"));
		element.sendKeys("selenium");
		element.submit();
		Assert.assertEquals(driver.getTitle(), "selenium - Google Search");
//		driver.close();
	  
  }
  
  @Test(alwaysRun=true, dependsOnMethods= {"searchTest"} )
  public void javasearchTest() {
	  driver.get("https://www.google.com");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  Assert.assertEquals(driver.getTitle(), "Google");
	  
		WebElement element= driver.findElement(By.name("q"));
		element.sendKeys("java tutorial");
		element.submit();
	    Assert.assertEquals(driver.getTitle(), "java tutorial - Google Search");
//		driver.close();		
  } 
  
  @Test(enabled=true)
  public void cucumbersearchTest() {
	  driver.get("https://www.google.com");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  	WebElement element= driver.findElement(By.name("q"));
		element.sendKeys("cucumber tutorial");
		element.submit();
	    Assert.assertEquals(driver.getTitle(), "cucumber tutorial - Google Search");
//		driver.close();		
  } 
  
  @Test(enabled=true)
  public void cypresssearchTest() {
	  driver.get("https://www.google.com");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement element= driver.findElement(By.name("q"));
		element.sendKeys("cypress tutorial");
		element.submit();
	    Assert.assertEquals(driver.getTitle(), "cypress tutorial - Google Search");
//		driver.close();		
  } 
//@AfterMethod  
  @AfterTest
  public void teardown() {
	  driver.close();
  }
 
}

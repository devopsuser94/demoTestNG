package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataParam {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		
	      System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		    driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("file:///F:/Selenium_Handson/Sample/LoginPageSample.html");	
	}
	
	@Parameters({"username", "password"})
	
	
	
	
  @Test
  public void loginTest(String uid, String pwd) throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys(uid);
		driver.findElement(By.name("password")).sendKeys(pwd);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='continue' or @type='submit']")).click();
		
  }
	
	@AfterClass
	
	public void teardown() {
		driver.close();
	}
}

package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
	
	WebDriver driver;

	@BeforeClass
	public void setup() {
		
	      System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		    driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("file:///F:/Selenium_Handson/Sample/LoginPageSample.html");	
	}
	
	
	
	 @Test(dataProvider="login_data")
	  public void loginTest(String uid, String pwd) throws InterruptedException {
			driver.findElement(By.name("username")).sendKeys(uid);
			driver.findElement(By.name("password")).sendKeys(pwd);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@name='continue' or @type='submit']")).click();
			
	  }
	 
	 @DataProvider(name="login_data")
	 public Object [][] getdata(){
		 return new Object[][] {
		 new Object[] {"testuser1", "password1"},
		 new Object[] {"testuser2", "password2"},
		 new Object[] {"testuser3", "password3"}
		 };
	 }
	 
		
	@AfterClass
		
		public void teardown() {
			driver.close();
		}	

}

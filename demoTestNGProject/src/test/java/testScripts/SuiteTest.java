package testScripts;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SuiteTest {
	String testname="";
	
	@BeforeTest
	@Parameters({"test-name"})
	public void beforetest(String testname1){
		this.testname = testname1;
		long id = Thread.currentThread().getId();
		System.out.println("Before Test:" + testname + "Thread id:"+id);
	}
	
  @Test
  public void testMethodOne() {
		long id = Thread.currentThread().getId();
		System.out.println("Test MethodOne:" + testname + "Thread id:"+id);
	  
  }
  @Test
  public void testMethodTwo() {
		long id = Thread.currentThread().getId();
		System.out.println("Test MethodTwo:" + testname + "Thread id:"+id);
	  
  }
  
  @AfterTest
  
  public void afterTest() {
		long id = Thread.currentThread().getId();
		System.out.println("After Test" + testname + "Thread id:"+id);

  }
}
package testScripts;

import org.testng.annotations.Test;

public class GroupTwoSampleThread {
	 @Test(groups= "featureOne")
	  public void testAdd() {
		  long id= Thread.currentThread().getId();
		  System.out.println("Testing Add()"+ "Thread two id is:"+id);
	  }
	  
	  @Test(groups= "featureTwo")
	  public void testSubtract() {
		  long id= Thread.currentThread().getId();
		  System.out.println("Testing Subtract()"+"Thread two id is:"+id);
	  }
	  
	  @Test(groups= "featureOne")
	  public void testMultiply() {
		  long id= Thread.currentThread().getId();
		  System.out.println("Testing Multiply()"+"Thread two id is:"+id);
	  }
	  
	  @Test(groups= "featureTwo")
	  public void testDivide() {
		  long id= Thread.currentThread().getId();
		  System.out.println("Testing Divide()"+"Thread two id is:"+id);
	  }
}

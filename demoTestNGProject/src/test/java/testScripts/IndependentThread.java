package testScripts;

import org.testng.annotations.Test;

public class IndependentThread {
  @Test(threadPoolSize=2, invocationCount=6, timeOut=1000)
  public void testMethod() {
	  long id= Thread.currentThread().getId();
	  System.out.println("Executing method on:"+id);
  }
}

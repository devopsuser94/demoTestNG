package testScripts;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class FactorySample {
	@Factory
	public Object[] factoryMethod() {
		return new Object[] {new SimpleTest(), new SimpleTest()};
	}
	
public class SimpleTest{
  @Test
  public void testone() {
	  System.out.println("Test Method one");
  }
  @Test
  public void testtwo() {
	  System.out.println("Test Method two");
  }
}
}

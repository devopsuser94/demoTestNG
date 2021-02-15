package testScripts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerTest implements IRetryAnalyzer {
	
	int retryAttemptCounter= 0;
	int maxRetryCounter= 3;
	
	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if(retryAttemptCounter < maxRetryCounter) {
				retryAttemptCounter++;
				return true;
			}
		}
		return false;
		
	}
	
}

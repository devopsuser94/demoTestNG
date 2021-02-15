package testScripts;

import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class CustomReport implements IReporter{

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		
		for(ISuite suite : suites) {
			String suitename= suite.getName();
			Map<String, ISuiteResult> suiteresult= suite.getResults();
			for(ISuiteResult result: suiteresult.values()) {
				ITestContext tc = result.getTestContext();
				System.out.println("Passed Test Cases:" + suitename + tc.getPassedTests().getAllResults().size());
				System.out.println("Failed Test Cases:" + suitename + tc.getFailedTests().getAllResults().size());
				System.out.println("Skipped Test Cases:" + suitename + tc.getSkippedTests().getAllResults().size());
			}
		}
		
	}

}

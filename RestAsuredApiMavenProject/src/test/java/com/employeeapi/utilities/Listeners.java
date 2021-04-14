package com.employeeapi.utilities;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public abstract class Listeners implements ITestListener{
	public ExtentHtmlReporter htmlreport;
	public ExtentReports extent;
	public ExtentTest test;
	

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		//create new entry in report
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "TestCase passed is :-"+result.getName());
		
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "TestCase failed is:-"+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		
		// TODO Auto-generated method stub
		
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "TestCase skipped is"+result.getName());
	
		
	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		//html wiil be saved in myReport.html directory
				htmlreport=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
				htmlreport.config().setDocumentTitle("Automation Report");
				htmlreport.config().setReportName("Rest Assured Api Testing Report");
				htmlreport.config().setTheme(Theme.DARK);
				
				
				extent =new ExtentReports();
				extent.attachReporter(htmlreport);
				extent.setSystemInfo("projectname", "Employee Api project");
				extent.setSystemInfo("Host name", "Localhost");
				extent.setSystemInfo("Environment", "QA");
				extent.setSystemInfo("User", "Soumya");

		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}

}

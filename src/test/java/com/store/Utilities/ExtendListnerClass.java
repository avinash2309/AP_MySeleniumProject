package com.store.Utilities;



import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.compress.harmony.pack200.NewAttribute;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.reporters.jq.ResultsByClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import net.bytebuddy.asm.MemberSubstitution.Current;

public class ExtendListnerClass implements ITestListener {

	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	public void configureReport() {
		
		ReadConfig readConfig = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.ss.mm").format(new Date());
		String reportName = "MyStoreTestReport - "+timestamp+ ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//Add System Information Into Report
		reports.setSystemInfo("Machine:", "Avinash");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("browser:", readConfig.getBrowser());
		reports.setSystemInfo("user name:", "Avinash Pol");
		
		//Configuratio to change the look and feel the report 
		htmlReporter.config().setDocumentTitle("Extent Sparks Reporter");
		htmlReporter.config().setReportName("This is my First report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
	}
	
	//On Start Method is called when any test starts
	public void onStart(ITestContext result) {
		configureReport();
		System.out.println("OnStart Method is Invoked..");
	}
	
	//OnFinish Method is called after all tests are finished 
	public void onFinish(ITestContext result) {
		System.out.println("OnFinish Method is Invoked..");
		reports.flush();// it is mandatory to called flush method to ensure information is written to the started reporter
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Name of the test Method Failed:"+result.getName());
		test = reports.createTest(result.getName());// Create Entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is:"+result.getName(), ExtentColor.RED));
		
		//If we add Screenshot of Failure test case into report then follow below step
		String screenShotPath = System.getProperty("user.dir")+"\\Screenshots\\"+ result.getName()+ ".png";
		File screenShotFile = new File(screenShotPath);
		if(screenShotFile.exists()) {
			test.fail("Captured Screenshot is Below:"+ test.addScreenCaptureFromPath(screenShotPath));
		}
		
	}
	
	public void OnTestSkipped(ITestResult result) {
		System.out.println("Name of the Skipped Test Method:"+result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is:"+result.getName(), ExtentColor.YELLOW));
		
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Name of the Test Method Started:"+result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of the Test Method Successully Executed:"+result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the Pass test case is:"+result.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	
}




























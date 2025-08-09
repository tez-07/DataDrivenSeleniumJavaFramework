package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import util.ExtentReport;

public class MyListeners implements ITestListener{

	ExtentReports extnetReport = ExtentReport.getExtentReports();
	ExtentTest extentTest;
	
	public void onTestStart(ITestResult result) {
		extentTest = extnetReport.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test got passed");
	}

	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "Test got Failed");
		extentTest.fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extnetReport.flush();
	}

	

}

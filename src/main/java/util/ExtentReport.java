package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	public static ExtentReports getExtentReports() {
		
		String extentReportFilePath = System.getProperty("user.dir")+"\\Reports\\extentreport.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFilePath);
		
		sparkReporter.config().setReportName("TutorialsNinja Test Results");
		sparkReporter.config().setDocumentTitle("TutorialsNinja Test Automation Results");
		
		ExtentReports extentreport = new ExtentReports();
		extentreport.attachReporter(sparkReporter);
		extentreport.setSystemInfo("Selenium Version", "4.4.0");
		extentreport.setSystemInfo("Operating System", "Windows 11");
		extentreport.setSystemInfo("Executed By", "Tez Borgohain");
		
		return extentreport;
	}
}

package genericUtility;

import java.util.Random;
import static genericUtility.BaseClassH.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
      ExtentTest test;
      ExtentReports reports;
	public void onTestStart(ITestResult result) {
         	test = reports.createTest(result.getMethod().getMethodName());	
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+ " got passed");
	}

	public void onTestFailure(ITestResult result) {
		String path = null;
		path = takeScreenShot(result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getMethod().getMethodName()+ " got failed");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(path);
		
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+ " got skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
     
     
	public void onStart(ITestContext context) {
		Random random = new Random();
		int n=random.nextInt(100);
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./ExtentReport/zoo"+n+".html");
		extentSparkReporter.config().setDocumentTitle("Zoo Management");
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		reports = new ExtentReports();
		reports.attachReporter(extentSparkReporter);
		reports.setSystemInfo("Browser", "chrome");
		reports.setSystemInfo("build", "build-123");
		reports.setSystemInfo("environment", "testing");
		reports.setSystemInfo("Reporter Name", "Venkat");
		
		
	}

	public void onFinish(ITestContext context) {
		reports.flush();
	}

}

package amp.api.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter
{
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
		System.out.println("test1");
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		System.out.println("test2");
		htmlReporter.config().setDocumentTitle("AMP Test Report");
		htmlReporter.config().setReportName("API Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Kosala");
		System.out.println("test3");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("test4");
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "test case pass is "+result.getName());
		System.out.println("test5");
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("test6");
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "test case fail is "+result.getName());
		test.log(Status.FAIL, "test case fail is "+result.getThrowable());
		System.out.println("test7");
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("test8");
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "test case skip is "+result.getName());
		System.out.println("test9");
	}
	
	public void onFinish(ITestContext testContext) {
		System.out.println("test10");
		extent.flush();
		System.out.println("test11");
	}
}

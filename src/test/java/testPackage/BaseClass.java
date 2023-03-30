package testPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pomUtility.Elementwait;
import testUtility.Screenshots;
import testUtility.StaticBrowser;

public class BaseClass //baseclass will be inherited in all testclasses used in project for connection
{
	public static ExtentReports report;
	public static ExtentHtmlReporter extent;
	public static ExtentTest logger; //is a listener that listens to the testcase execution
	static WebDriver driver;
	@Parameters({"browser"})
	@BeforeTest
	public void beforeTest(String browser)
	{	
		WebDriver driver =StaticBrowser.openBrowser(browser, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    this.driver = driver;
	    
	    report = new ExtentReports();
		extent = new ExtentHtmlReporter("test-output"+File.separator+"Report"+File.separator+System.currentTimeMillis()+".html");
		report.attachReporter(extent); //attactReporter is nonstatic method of ExtentReports Class
	//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}
	
	@AfterMethod  //after method for failed Test in loginpageTestcases, for taking screen shot after every failed test
	public void afterMethod(ITestResult result) throws IOException //ITestResult() is an interface in TestNG for Listening the testlog(i.e whether testcase is fail/pass)
, InterruptedException
	{
		Thread.sleep(1000);
		if(result.getStatus()==ITestResult.FAILURE) //getStatus() is in ITestResult,which  will return the Testcase status(pass/fail), if failure then take screenshot 
		{   
			String path = Screenshots.capturePageScreenShot(driver);
			logger.fail("Test failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());			
		}	
		
		report.flush();
	} 
	
/*Only sometimes, to close the browser*/
	@AfterTest
	public void afterTest()
	{
		driver.quit();
	}
	
}

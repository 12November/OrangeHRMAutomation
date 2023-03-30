package testPackage;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomPackage.LoginPage;
import testUtility.ReadFileData;

public class TestNG1 
{
	WebDriver driver;
	LoginPage login;
	ReadFileData rfile;
/*	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("BeforeSuiteTestNG1 of LoginPageTC");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("BeforeTestTestNG1 of LoginPageTC");
	}
*/	
/*	@BeforeClass
	public void beforeClass()
	{
		//System.out.println("BeforeClass of LoginPageTC");
		login=new LoginPage(driver); //WE can initialised all object which will be used in this page in beforeClass()
	}
     
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("BeforeMethodTestNG1 of LoginPageTC ");
	}
	
	@Test(priority=1)

	public void verifyURL()
	{
	String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String fetchCurrentPageURL = login.fetchCurrentURL();
  		Assert.assertEquals(fetchCurrentPageURL,expectedURL);
//		Assert.assertNotEquals(fetchCurrentPageURL,expectedURL);
		
		System.out.println("URL is successful for NG1");	
	}
	
	 @Test
	    public void verifyEnteredUsername() throws EncryptedDocumentException, IOException
	    {
	    	//login.enterUsername("Admin");
		   login.enterUsername(rfile.fetchDataFromExcel(2, 1));
	       System.out.println("Adminvalues Success");  
	    }
	     
	    @Test
	    public void verifyEnteredPassword() throws EncryptedDocumentException, IOException
	    {
	    	login.enterPassword(rfile.fetchDataFromExcel(2, 2));
	    }
	    
	    @Test
	    public void verifyClickOnLoginButton()
	    {
	    	login.clickOnLoginButton();
	    }
	   
	   
	
	@Test
	public void VerifyLoginPageWithInvalidUsername_ValidPassword()
	{
		login.clickOnLoginButton("Admin123", "admin123");
		//As we Don't pass hard coded data we can use data from excel sheet
		//by create class in testUtility package.
				
	}
*/	
/*	@Test

	public void VerifyLoginPageWithValidUsername_InvalidPassword()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		
		login.clickOnLoginButton("Admin", "admin12345");
	}
*/	
/*	@Test
	public void VerifyLoginPageWithInvalidUsername_InvalidPassword()
	{
		login.clickOnLoginButton("Admin34", "admin1234");
	}
	
	@Test(dependsOnMethods="verifyValidURL")
	public void VerifyLoginPageWithValidData()
	{
		login.clickOnLoginButton("Admin", "admin123");
	}

	
	@AfterMethod
	public void AfterMethod()
	{
		System.out.println("AfterMethodTestNG1 of LoginPageTC");
	}
	
	@AfterClass
	public void AfterClass()
	{
		System.out.println("AfterClassTestNG1 of LoginPageTC");
	}
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("AfterTest_TestNG1 of LoginPageTC");
	}
	
	@AfterSuite
	public void AfterSuite()
	{
		System.out.println("AfterSuiteTestNG1 of LoginPageTC");
	}
*/
}

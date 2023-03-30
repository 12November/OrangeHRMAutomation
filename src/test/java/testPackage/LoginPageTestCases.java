package testPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pomPackage.LoginPage;
/*
 **Hard Assert****
//Assertion Class methods  stops the execution of the Test in which its written and then move to next test execution
 Assert.assertEquals(string1,string2); Compare two string values, condition true continue, else stop execution move to next	
 Assert.assertNotEquals(String1,String2); if condition is false continue else for true, stop test execution and move to next test exe
 Assert.assertTrue(true); returns boolean true, if false stop
 Assert.assertFalse(false); returns boolean false, if true then stop
 Assert.fails(); to fail particular test method and move to next test
 
	
**Soft Assert***
//SoftAssert Class methods lets you continue with the execution and gives summary of fail/pass only at end
 SoftAssert s = new SoftAssert();
 s.assertEquals(String1,String2); compare two string value,   false then continue give result at end
 s.assertNOTEquals(String1,String2);condition is true doesnt stop but continue execu give result at end
 s.assertTrue(true); false, doesnt stop but continues
 s.assertFalse(false); true, doesnt stop  but result at end
 s.aasertAll; We must write assertAll() at the end of using SoftAssertion on methods.		
 */
import testUtility.ReadFileData;

//reading excel data cell in java will always start from 0. 
//so data cell(1,0) for username pwd =cell(1,1)
public class LoginPageTestCases extends BaseClass
{
	LoginPage login;
	ReadFileData r;	
//
	@BeforeClass
	public void beforeClass() //we write code for alert, create object of class used in below testcase here, etc
	{
	    login = new LoginPage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		
	}
	
/*	@Test
	public void verifyValidURL()
	{
		boolean result= login.compareDomainURL();
		Assert.assertTrue(result);
*/
	 /*	String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String fetchCurrentPageURL = login.fetchCurrentURL();
  	    Assert.assertEquals(fetchCurrentPageURL,expectedURL);
		Assert.assertNotEquals(fetchCurrentPageURL,expectedURL);
	*/	
//	}
	
/*	 @Test
	    public void verifyLoginPageWithValidData() throws InterruptedException,EncryptedDocumentException, IOException 
	    {
		   login.enterUsername(r.fetchDataFromExcel(1, 0));
	       login.enterPassword(r.fetchDataFromExcel(1, 1));
		   login.clickOnLoginButton();
	    	
	    	boolean result=login.compareCurrentURL();
	    	Assert.assertTrue(result);
	    }
*/	     
	
/*	@Test
	public void VerifyLoginPageWithInvalidUsername_ValidPassword() throws EncryptedDocumentException, IOException
	{
		   login.enterUsername(r.fetchDataFromExcel(2, 0));
	       login.enterPassword(r.fetchDataFromExcel(2, 1));
		   login.clickOnLoginButton();
     
		//As we Don't pass hard coded data we can use data from excel sheet
		//by create class in testUtility package.
		
	}
	
	@Test
	public void VerifyLoginPageWithValidUsername_InvalidPassword() throws EncryptedDocumentException, IOException
	{
		   login.enterUsername(r.fetchDataFromExcel(3, 0));
	       login.enterPassword(r.fetchDataFromExcel(3, 1));
		   login.clickOnLoginButton();
	}
*/	
	@Test
	public void VerifyLoginPageWithInvalidUsername_InvalidPassword() throws EncryptedDocumentException, IOException
	{
		logger=report.createTest("Verify Login functionality with incorrect data");
		   login.enterUsername(r.fetchDataFromExcel(4, 0));
	       login.enterPassword(r.fetchDataFromExcel(4, 1));
		   login.clickOnLoginButton();
		   Assert.fail();
	}
	


	@Test
	public void VerifyLoginPageWithValidData() throws EncryptedDocumentException, IOException
	{
		logger = report.createTest("Verify Login functionality with correct data");
		   login.enterUsername(r.fetchDataFromExcel(1, 0));
	       login.enterPassword(r.fetchDataFromExcel(1, 1));
		   login.clickOnLoginButton();
	    	
	    	boolean result=login.compareCurrentURL();
	    	Assert.assertTrue(result);
	    	
	    	logger.pass("Test case pass");
	  //Note screenshot: will be taken at a point from where functionality fails.  	
	}
	
	@Test
	public void verifyAdminPage()
	{
		System.out.println("Failed testcase");
		//Assert.fail();	
	}
	
	@AfterClass
	public void AfterClass()
	{
		System.out.println("AfterClassTestNG1 of LoginPageTC");
	}
	

}

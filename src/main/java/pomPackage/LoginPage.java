package pomPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pomUtility.Elementwait;

public class LoginPage 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;
	@FindBy(xpath = "//input[@type = 'password']")
	private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginbutton;
		
/*To initialse object using paramaterised constructor*/	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		//this.wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		
/*initilase page object/locators using static initElements method of PageFactory class*/	  
		PageFactory.initElements(driver,this);		
	}	

/*Method to send username to login form*/	
	public void enterUsername(String uname)
	{
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("username")));
		Elementwait.waitForElement("//input[@name='username']", 3, driver);//call method from pomutility
		username.sendKeys(uname);
	}
	
/*Method to send password to login form*/
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
/*Method to click login button*/	
	public void clickOnLoginButton()
	{
		loginbutton.click();
	}
	
/*Method to send username and password and click on login button*/		
	public void clickOnLoginButton(String uname, String pass)
	{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		Elementwait.waitForElement("//input[@name='username']", 2, driver);
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginbutton.click();				
	}

/*Method to compare homepage url*/
	public boolean compareCurrentURL()
	{
		String ExpectedURL ="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String url = driver.getCurrentUrl();
		boolean result = ExpectedURL.equals(url);
		return result;
	}
	
/*Method to compare domain url*/	
	public boolean compareDomainURL()
	{
		String ExpectedURL ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String url = driver.getCurrentUrl();
		boolean result = ExpectedURL.equals(url);
		return result;
	}

    
}

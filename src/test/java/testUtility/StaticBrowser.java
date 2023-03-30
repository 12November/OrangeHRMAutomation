package testUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticBrowser 
{
	static WebDriver driver;

	public  static WebDriver openBrowser(String browserName, String URL)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
		   WebDriverManager.chromedriver().setup();
		   ChromeOptions options = new ChromeOptions(); //there is failure 403 status code with new chrome version,so we use options
		   options.addArguments("--remote-allow-origins=*");
	//	   options.addArguments("--disable-gpu");
		   driver=new ChromeDriver(options);		   
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
		   WebDriverManager.edgedriver().setup();
		   driver=new EdgeDriver();		   
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();		   
		}
		
		driver.manage().window().maximize();
		driver.get(URL);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		return driver;
		
	}

}

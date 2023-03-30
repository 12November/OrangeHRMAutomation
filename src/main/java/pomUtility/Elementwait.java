package pomUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elementwait 
{
  public static void waitForElement(String webElementLocator ,int waitTime, WebDriver driver)
  {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElementLocator)));
  }

}

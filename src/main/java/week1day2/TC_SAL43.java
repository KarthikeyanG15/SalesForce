package week1day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_SAL43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		RemoteWebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://login.salesforce.com");
		driver.findElementById("username").sendKeys("mercury.bootcamp@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp$123");
		driver.findElementById("Login").click();
		
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		driver.findElementByXPath("//button[@class='slds-button' and text()='View All']").click();
		
	
		WebElement webe1 = driver.findElementByXPath("//p[text()='Tasks']");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", webe1);
		
		WebElement webe2 = driver.findElementByXPath("//span[text()='Select List View' and @class='slds-assistive-text']");
		js.executeScript("arguments[0].click()", webe2);
		
		
		driver.findElementByXPath("//span[text()='Recently Viewed' and @class=' virtualAutocompleteOptionText']").click();
		driver.findElementByXPath("//span[text()='Bootcamp' and @class='uiOutputText']").click();
		
		WebElement webe3 = driver.findElementByXPath("//span[text()='Edit Due Date' and @class='slds-assistive-text']");
		js.executeScript("arguments[0].click()", webe3);
		
		driver.findElementByXPath("//a[ @class='datePicker-openIcon display']").click();
		driver.findElementByXPath("//button[text()='Today']").click();
		////button[@title='Edit Subject']/preceding::span
		driver.findElementByXPath("//a[@class='select' and text()='Normal']").click();
		driver.findElementByXPath("//a[@title='Low']").click();
		driver.findElementByXPath("//span[text() ='Save']").click();
		
	}

}

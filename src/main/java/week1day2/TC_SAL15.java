package week1day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_SAL15 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		RemoteWebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		driver.findElementById("username").sendKeys("mercury.bootcamp@testleaf.com");
		driver.findElementById("password").sendKeys("Bootcamp$123");
		driver.findElementById("Login").click();
		
		//2. Click on the toggle menu button from the left corner
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		
		//3. Click View All and click Legal Entities from App Launcher
		driver.findElementByXPath("//button[@class='slds-button' and text()='View All']").click();
		Thread.sleep(10000);
	
		WebElement webe1 = driver.findElementByXPath("//p[text()='Legal Entities']");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", webe1);
		Thread.sleep(10000);
		
		//4. Click on the Dropdown icon in the legal Entities tab
		
		WebElement webe2 = driver.findElementByXPath("//span[text()='Select List View']");
		
		
		js.executeScript("arguments[0].click()", webe2);
		Thread.sleep(10000);
		driver.findElementByXPath("(//*[@class='slds-icon slds-icon-text-default slds-icon_xx-small' and @data-key='chevrondown'])[14]").click();
		
		//5. Click on New Legal Entity
		WebElement webe3 = driver.findElementByXPath("//span[text()='New Legal Entity']");
		js.executeScript("arguments[0].click()", webe3);
		
		//6. Enter the Company name as 'Tetsleaf'.
		driver.findElementByXPath("(//input[@class=' input'])[1]").sendKeys("TestLeaf Karthik");
		
		//7. Enter Description as 'SalesForce'.
		driver.findElementByXPath("//textarea[@class=' textarea']").sendKeys("Salesforce by karthik");
		
		//8. Select Status as 'Active'
		driver.findElementByXPath("//a[@class='select']").click();
		driver.findElementByXPath("//a[text()='Active']").click();
		
			//9. Click on Save
		driver.findElementByXPath("//textarea[@class=' textarea']").click();
		WebElement webe4 = driver.findElementByXPath("//span[text()='Save']");
		js.executeScript("arguments[0].click()", webe4);
			//10. Verify the Alert message (Complete this field) displayed for Name"
		

	}

}

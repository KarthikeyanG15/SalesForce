package week1day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_SAL5 {

	public static void main(String[] args) throws InterruptedException {
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
		//Click on the toggle menu button from the left corner
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		//Click View All and click Sales from App Launcher
		driver.findElementByXPath("//button[@class='slds-button' and text()='View All']").click();
		driver.findElementByXPath("//p[@class='slds-truncate' and text()='Sales']").click();
		//Click on the Opportunity tab 
		driver.findElementByXPath("//*[@class='slds-icon slds-icon-text-default slds-icon_xx-small' and @data-key='chevrondown']").click();
		//Click on the New button
		WebElement element = driver.findElementByXPath("//span[text()='New Opportunity']");
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		//driver.findElementByXPath("//lightning-icon[contains(@class,'slds-icon-utility-add slds-icon-text-default')]/following-sibling::span").click();
		//Choose Close date as Tomorrow Date
		driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
		driver.findElementByXPath("//button[@class='today slds-button slds-align_absolute-center slds-text-link']").click();
		Thread.sleep(3000);
		String text = driver.findElementByXPath("(//input[@class=' input'])[1]").getAttribute("value");
		System.out.println("value"+text);
		String str[] = text.split("/");
		int day = Integer.parseInt(str[1])+1;
		text=str[0]+"/"+day+"/"+str[2];
		driver.findElementByXPath("(//input[@class=' input'])[1]").clear();
		driver.findElementByXPath("(//input[@class=' input'])[1]").sendKeys(text);
		driver.findElementByXPath("(//input[@class=' input'])[2]").sendKeys("Karthikeyan Bootcamp");
		driver.findElementByXPath("//a[@class='select']").click();
		driver.findElementByXPath("//a[@title='Needs Analysis']").click();
		driver.findElementByXPath("//span[@class=' label bBody' and text()='Save']").click();
		Alert alert = driver.switchTo().alert();
		String text2 = alert.getText();
		System.out.println(text2);
			
	}

}

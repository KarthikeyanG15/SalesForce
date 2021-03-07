package week1day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01_AddName {
	
	public static void main(String[] args) {
		
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
		driver.findElementByXPath("//button[text()='View All']").click();
		driver.findElementByXPath("(//p[text()='Sales'])").click();
		
		WebElement opp = driver.findElementByXPath("//span[text()='Opportunities']");
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", opp);
		String inpText = "Karthikeyan G";
		driver.findElementByXPath("//div[text()='New']").click();
		driver.findElementByXPath("(//input[@class=' input'])[2]").sendKeys(inpText);
		driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();
		driver.findElementByXPath("//button[@class='today slds-button slds-align_absolute-center slds-text-link']").click();
		driver.findElementByXPath("//a[@class='select']").click();
		driver.findElementByXPath("//a[@title ='Needs Analysis']").click();
		driver.findElementByXPath("//button[@title='Save']").click();
		String scrtext = driver.findElementByXPath("(//lightning-formatted-text)[1]").getText();
		boolean verify = scrtext.equalsIgnoreCase(inpText);
		if (verify==true) {
			System.out.println("Verified and looks good"+scrtext);	
		} else System.out.println("doesn't looks good"+scrtext);	

		}
}
	

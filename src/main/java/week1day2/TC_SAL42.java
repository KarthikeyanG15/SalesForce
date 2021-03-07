package week1day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_SAL42 {

	public static void main(String[] args) throws InterruptedException  {
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
		
		Thread.sleep(10000);
		Actions run = new Actions(driver);
		run.click(driver.findElementByXPath("//*[@data-key='add']"));
		driver.findElementByXPath("//*[@data-key='add']").click();
		
		//driver.findElementByXPath("//*[@data-key='add']").sendKeys(Keys.);
		
		//driver.findElementByXPath("//lightning-icon[@class='slds-button slds-button--icon slds-button--icon-small slds-button--icon-container slds-button--icon-x-small slds-global-header__button--icon-actions globalCreateButton slds-icon-utility-add slds-icon_container']//*[@class='slds-icon slds-icon_x-small']").click();
		
	/*	WebElement op = driver.findElementByXPath("//lightning-primitive-icon//*[@class='slds-icon slds-icon_x-small']");
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click()", op);*/
		
		driver.findElementByXPath("//span[text()='New Task']").click();
		driver.findElementByXPath("//input[@class='slds-input slds-combobox__input']").sendKeys("Bootcamp by Karthik");
		driver.findElementByXPath("(//lightning-primitive-icon//*[@data-key ='down' and @class='slds-icon slds-icon-text-default slds-icon_xx-small'])[1]").click();
		driver.findElementByXPath("//span[@title='Contacts' and text()='Contacts']").click();
		driver.findElementByXPath("//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']").sendKeys("karthik");
		//driver.findElementByXPath("(//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup'])[1]").click();
		driver.findElementByXPath("//div[@title ='Karthikeyan G']").click();
		driver.findElementByXPath("//a[@class='select']").click();
		//driver.findElementByXPath("//div[@class ='select-options popupTargetContainer uiPopupTarget uiMenuList uiMenuList--default uiMenuList--left uiMenuList--short ']").click();
		driver.findElementByXPath("//a[@title='Waiting on someone else']").click();
		driver.findElementByXPath("(//span[@class=' label bBody' and text()='Save'])[2]").click();
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		driver.findElementByXPath("//p[text()='Service']").click();
		driver.findElementByXPath("(//span[@class='viewAllLabel'])[3]").click();
		driver.findElementByXPath("//input[@name='Task-search-input']").sendKeys("Bootcamp by Karthik");
		driver.findElementByXPath("//input[@name='Task-search-input']").sendKeys(Keys.ENTER);
		String text = driver.findElementByXPath("//span[@class='countSortedByFilteredBy']").getText();
		System.out.println(text);
		

		
	}

}

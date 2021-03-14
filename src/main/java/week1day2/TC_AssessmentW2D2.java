package week1day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_AssessmentW2D2 {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Assessment TestCase
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
		
		//2. Click on toggle menu button from the left corner
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		
		//3. Click view All 
		driver.findElementByXPath("//button[@class='slds-button' and text()='View All']").click();
		
		//4. Click Service Console from App Launcher
		driver.findElementByXPath("//p[text()='Service Console']").click();
		
		//5. Select Home from the DropDown
		Thread.sleep(10000);
		driver.findElementByXPath("//button[@aria-label='Show Navigation Menu']").click();
		driver.findElementByXPath("//span[@class='menuLabel slds-listbox__option-text slds-listbox__option-text_entity' and text()='Home']").click();
		
		//6. Add CLOSED + OPEN values and result should set as the GOAL (If the result is less than 10000 then set the goal as 10000)
		String s1,s2 = "";
		s1 = driver.findElementByXPath("(//span[@class='metricAmount uiOutputText'])[1]").getText();
		s2 = driver.findElementByXPath("(//span[@class='metricAmount uiOutputText'])[2]").getText();
		System.out.println("value: "+s1.replaceAll("[$,]",""));
		System.out.println("value: "+s2.replaceAll("[$,]",""));
		Integer i1 = Integer.parseInt(s1.replaceAll("[$,]","")) + Integer.parseInt(s2.replaceAll("[$,]",""));
		System.out.println(i1);
		driver.findElementByXPath("//*[@class='slds-button__icon' and @data-key='edit']").click();
		driver.findElementByXPath("//input[@class='input uiInputSmartNumber uiInput uiInput--default uiInput--input']").clear();
		if(i1 >= 10000)
			driver.findElementByXPath("//input[@class='input uiInputSmartNumber uiInput uiInput--default uiInput--input']").sendKeys(i1.toString());
		else
			driver.findElementByXPath("//input[@class='input uiInputSmartNumber uiInput uiInput--default uiInput--input']").sendKeys("10001");
		
		WebElement element = driver.findElementByXPath("//span[text()='Save']");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		
		//7. Select Dashboards from DropDown
		
		driver.findElementByXPath("//button[@title='Show Navigation Menu']").click();
		driver.findElementByXPath("//span[text()='Dashboards']").click();
		
		
		//8. Click on New Dashboard
		driver.findElementByXPath("//div[text()='New Dashboard']").click();
		
		//9. Enter the Dashboard name as "YourName_Workout"
		Thread.sleep(10000);
		WebElement element2 = driver.findElementById("dashboardNameInput");
		executor.executeScript("arguments[0].;", element2);
		
		//driver.findElementByXPath("//input[@id='dashboardNameInput']") .sendKeys("Karthikeyan_workout");
		
		//10. Enter Description as Testing and Click on Create
		driver.findElementByXPath("//input[@id='dashboardDescriptionInput']").sendKeys("Karthikeyan_testing");
		
		//11. Click on Done
		driver.findElementByXPath("//button[@id='submitBtn']").click();
		
		//12. Verify the Dashboard is Created
		//13. Click on Subscribe
		//14. Select Frequency as "Daily"
		//15. Time as 10:00 AM
		//16. Click on Save
		//17. Verify "You started Dashboard Subscription" message displayed or not
		//18. Close the "YourName_Workout" tab
		//19. Click on Private Dashboards
		//20. Verify the newly created Dashboard available
		//21. Click on dropdown for the item
		//22. Select Delete
		//23. Confirm the Delete
		//24. Verify the item is not available under Private Dashboard folder
	}

}

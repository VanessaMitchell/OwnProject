package dev.Allagi.testCases;

/*This test case is to test the functionality for starting the maintenance request*/

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC_002 {

	public static WebDriver driver;
	
	String pageTitle = "OWN Housing Co-operative";
	String workSpaceUrl = "https://white-bay-0cf53f60f.azurestaticapps.net/workspace/profile";
	
	@Test
	public void tc_002() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vanes\\eclipse-workspace\\OwnProject\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		 String baseUrl = "https://white-bay-0cf53f60f.azurestaticapps.net/landing";
		 driver.get(baseUrl);
		 driver.manage().window().maximize();
		

		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 System.out.println("Test has at started");
		 
		 assertTrue(driver.getTitle().contains(pageTitle));
		 System.out.println("Webpage title is displayed");
		 
		 //initializing web element for login
		 WebElement login = driver.findElement(By.xpath("//a[@class='header__login']"));
		 login.click();
		 System.out.println("Clicked on login");
		 
		 //initializing web element for email
		 WebElement email = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
		
		 //initializing web element for password
		 WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		 
		 //initializing web element for clicking sign in
		 WebElement signin = driver.findElement(By.xpath("//span[normalize-space()='Sign In']"));

		 //entered email
		 email.sendKeys("quinntynebrown@gmail.com");
		 System.out.println("Email entered");
		 
		 //Entered password
		 password.sendKeys("P@ssw0rd");
		 System.out.println("Password entered");
		 
		 //clicked signin
		 signin.click();
		 System.out.println("Clicked signin");
		 
		 Thread.sleep(5000);
		 
		 //assert if profile page is displayed after login
		 assertTrue(driver.getCurrentUrl().equals(workSpaceUrl));
		 System.out.println("Profile page is diplayed");
		 
		 //click on Maintenance Requests
		 WebElement requests = driver.findElement(By.xpath("//a[normalize-space()='Maintenance Requests']"));
		 requests.click();
		 System.out.println("Clicked on Maintenance Requests");
		 
		 //Click on Receive in request
		 WebElement receiveRequest = driver.findElement(By.xpath("//tbody/tr[2]/td[5]/a[1]"));
		 receiveRequest.click();
		 System.out.println("Clicked on Receive");
		 
		 //Click Save in pop-up
		 WebElement save = driver.findElement(By.xpath("//span[normalize-space()='Save']"));
		 save.click();
		 System.out.println("Clicked on save button in pop-up");
		 
		 //initializing web element for start link
		 WebElement start = driver.findElement(By.xpath("//tbody/tr[2]/td[5]/a[1]"));
		 
		 //create instance of js executor to click on radio button
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 //Clicked start link
		 js.executeScript("arguments[0].click()",start);
		 System.out.println("Clicked start");
		 
		 Thread.sleep(5000);
		 
		 //initializing web element for radio button
		 WebElement memberAtHome = driver.findElement(By.xpath("(//span[@class='mat-radio-outer-circle'])[1]"));
		 
		 //create object of actions class
		 Actions actions = new Actions(driver);
		 
		 //click on radio  button
		 actions.moveToElement(memberAtHome);
		 actions.click();
		 actions.build().perform();
		 System.out.println("Clicked Member at Home radio buttton");
		 
		 //initializing web element for calendar icon
		 WebElement calendar = driver.findElement(By.xpath("(//*[name()='path'])[3]"));
		 
		 //click in calendar
		 actions.moveToElement(calendar);
		 actions.click();
		 actions.build().perform();
		 System.out.println("Clicked on calendar");
		 
		 //click on start date
		 WebElement startDate = driver.findElement(By.xpath("//div[normalize-space()='14']"));
		 startDate.click();
		 System.out.println("Clicked on Start");
		 
		 //initializing web element for save button
		 WebElement saveButton = driver.findElement(By.xpath("//span[normalize-space()='Save']"));
		 //click on save button
		 actions.moveToElement(saveButton);
		 actions.click();
		 actions.build().perform();
		 System.out.println("Clicked on save button");
		 
		 driver.quit();
		 
		 
		 
	
		 
		 
		 
		 
	}
}

package dev.Allagi.testCases;

/*This test case is to test the login feature as well as create a new maintenance request form for a rental unit*/

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TC_001 {
	public static WebDriver driver;
	
	
	String pageTitle = "OWN Housing Co-operative";
	String workSpaceUrl = "https://white-bay-0cf53f60f.azurestaticapps.net/workspace/profile";
	
	
	
	@Test
	public void tc_001() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vanes\\eclipse-workspace\\OwnProject\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 
		 String baseUrl = "https://white-bay-0cf53f60f.azurestaticapps.net/landing";
		 driver.get(baseUrl);
		 driver.manage().window().maximize();
		

		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 System.out.println("Test has at started");
		 
		
		 
		 assertTrue(driver.getTitle().contains(pageTitle));
		 System.out.println("Webpage title is displayed");
		 
		 //initializing web element for login button
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
		 
		 //clicked sign in
		 signin.click();
		 System.out.println("Clicked signin");
		 
		 Thread.sleep(5000);
		 
		 //assert if profile page is displayed after login
		 assertTrue(driver.getCurrentUrl().equals(workSpaceUrl));
		 System.out.println("Profile page is diplayed");
		 
		 //initializing web element for create link
		 WebElement create = driver.findElement(By.xpath("//span[normalize-space()='Create']"));
		 create.click();
		 System.out.println("Clicked Create");
		 
		 //initializing web element for address
		 WebElement street = driver.findElement(By.xpath("//input[@formcontrolname='street']"));
		 street.sendKeys("1221 Kos Blvd");
		 System.out.println("Entered Address");
		 
		 //initializing web element for unit
		 WebElement unit = driver.findElement(By.xpath("//input[@formcontrolname='unit']"));
		 unit.sendKeys("55");
		 System.out.println("Entered Unit");
		 
		 //initializing web element for city
		 WebElement city = driver.findElement(By.xpath("//input[@formcontrolname='city']"));
		 city.sendKeys("London");
		 System.out.println("Entered City");
		 
		 //initializing web element for province
		 WebElement province = driver.findElement(By.xpath("//input[@formcontrolname='province']"));
		 province.sendKeys("Ontario");
		 System.out.println("Entered Province");
		 
		 //initializing web element for postal code
		 WebElement postalCode = driver.findElement(By.xpath("//input[@formcontrolname='postalCode']"));
		 postalCode.sendKeys("L5T 4R6");
		 System.out.println("Entered Postal Code");
		 
		 //initializing web element for text box
		 WebElement textBox = driver.findElement(By.xpath("//div[@role='textbox']"));
		 textBox.sendKeys("Need new door handle in washroom, please fix asap!");
		 System.out.println("Entered Text in text area");
		 
		 //initializing web element for phone number
		 WebElement daytimePhone = driver.findElement(By.xpath("//input[@formcontrolname='phone']")); 
		 daytimePhone.sendKeys("4169999999");
		 System.out.println("Entered phone number");
		 
		 //initializing web element for radio button
		 WebElement enterUnitOption = driver.findElement(By.xpath("(//span)[67]"));
		 
		 
		 //create instance of js executor to click on radio button
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()",enterUnitOption );
		 System.out.println("Chose option to enter unit");
		 
		 //initializing web element for save button
		 WebElement saveButton = driver.findElement(By.xpath("//span[normalize-space()='Save']"));
		 saveButton.click();
		 System.out.println("Clicked Save");
		 
		 Thread.sleep(5000);
		 
		 //assert if new maintenance request shows up on profile page
		 assertTrue(driver.getPageSource().contains("Need new door handle in washroom, please fix asap!"));
		 System.out.println("New maintenance request is displayed on profile page");
		 
		 driver.quit();
		 
		 
		 
		 

	
		 
		 
		 
		 
		 
		 
		 
		
		
		 
		
		
	
	}

}

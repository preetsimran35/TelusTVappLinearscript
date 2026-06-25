package TVapp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*public class Guide {
	public void guide(WebDriver driver)throws InterruptedException{
		
		// Navigate to Guide	
		driver.findElement(By.linkText("Guide")).click();
		
		//Closing the filter channel pop-up
		driver.findElement(By.xpath("//*[@class='sc-bZHSRq kfpRPv']/img")).click();
		driver.findElement(By.xpath("//*[@class='sc-bZHSRq kfpRPv']/img")).click();
		
	}

}*/


public class GuidePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Constructor
	public GuidePage (WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Adjust timeout as necessary
	}
	
	//Locators
	private	By Guidelink=By.linkText("Guide");
	private By popup= By.xpath("//*[@class='sc-eAKtBH gUOlpS']/img");
		
	//Method to click the Guide link
	public void clickGuidelink()
	{
		WebElement guideLinkElement = wait.until(ExpectedConditions.elementToBeClickable(Guidelink));
		guideLinkElement.click();
		
	}
	
	//Method to close pop-ups
	public void closepopup() 
	{
		
		   int maxAttempts = 2; // Set a maximum number of attempts
		    int attempts = 0; // Counter for attempts

		    while (attempts < maxAttempts) {
		        if (!clickPopup()) {
		            // If clickPopup returns false, it means no more popups were found
		            break; // Exit the loop
		        }
		        attempts++; // Increment the attempts counter
		    }

		    if (attempts == maxAttempts) {
		        System.out.println("Reached maximum attempts to close popups.");
		    } else {
		        System.out.println("No more popups found.");
		    }
		}	
		
	//Method to click on a popup
	private boolean clickPopup() 
	{
		try
	{
	  WebElement clickpopup = wait.until(ExpectedConditions.elementToBeClickable(popup));
	  clickpopup.click();
	  System.out.println("Popup clicked.");
	   return true; //pop up was found and clicked
	}catch (Exception e) 
	{
		System.out.println("Popup not found");
		return false;//No more popups found
	}
	   
	}

}

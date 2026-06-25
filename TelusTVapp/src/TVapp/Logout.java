package TVapp;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    // Locators
    private By userProfileIcon = By.xpath("//*[@class='avatar-button profile-menu-avatar ']");
    private By logoutButton = By.xpath("//*[@class='logout-button']");

    // Constructor
    public Logout(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait here
      }
    
 // Method to perform logout
    public void logout() throws InterruptedException {
    	try {
        // Hover over the user profile icon
        WebElement profileIcon = wait.until(ExpectedConditions.elementToBeClickable(userProfileIcon));
    	Actions actions = new Actions(driver);
        actions.moveToElement(profileIcon).perform();
        // Click on the logout button
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutBtn.click();
        System.out.println("Logout successfull");
    	}catch(Exception e) {
    		System.out.println("Error during logout: "+e.getMessage());
    		e.printStackTrace();
    	}
    }
	
}

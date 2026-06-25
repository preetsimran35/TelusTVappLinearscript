package TVapp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	private WebDriver driver;
	
	  //Locators
	  private By tutorialCloseButton = By.xpath("//*[@id='onboardingModal']/div/div/div[1]/span/button/img");
      private By loginButton = By.className("login-button");
      private By userIDField = By.id("IDToken1");
      private By passwordField = By.id("IDToken2");
      private By submitButton = By.id("Submit");
      private By profileSelectionButton = By.xpath("//*[@id='root']/div[2]/div/div[1]/button[1]/img");
      
      //Constructor
      public Login(WebDriver driver)
      {
    	  this.driver=driver;
      }
      
      //Method to perform login
      public void login(String loginID, String loginPassword)throws InterruptedException{
    	  //Launch Website
    	  driver.get("https://telustvplus.com/#/");
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
    	  
    	// Close the tutorial message
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
          wait.until(ExpectedConditions.elementToBeClickable(tutorialCloseButton)).click();
          
       // Login flow
          wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click(); // Click on Login button
          wait.until(ExpectedConditions.visibilityOfElementLocated(userIDField)).sendKeys(loginID); // Input UserID
          wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(loginPassword); // Input Password
          wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click(); // Click on Submit button

          // Profile Selection
          wait.until(ExpectedConditions.elementToBeClickable(profileSelectionButton)).click();
          Thread.sleep(3000);
      }
 
}


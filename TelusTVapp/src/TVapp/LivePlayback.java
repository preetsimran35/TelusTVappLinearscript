package TVapp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LivePlayback {
	
	private WebDriver driver;
    private WebDriverWait wait;
    
    // Locators
       private By searchChannel= By.xpath("(//input)[2]");
       private By channelLogo = By.xpath("//*[@class='cell channel-cell']//*[@class='logo']/img");
       private By videoLocator = By.xpath("//*[@class='player-with-sidebar']");
       private By closeButton = By.xpath("//*[@class='imageButton playbackClose']//img[@src='/images/playback-close.svg']");

    // Constructor
       public LivePlayback(WebDriver driver) {
       this.driver = driver;
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as necessary
    }
       
    // Method to perform live playback
       public void startLivePlayback(String channelNumber) throws InterruptedException {
    	   
    	   //Search for the channel
    	    WebElement searchchannel=wait.until(ExpectedConditions.elementToBeClickable(searchChannel));
    	   	searchchannel.click();
    	   	Thread.sleep(1000);
    	   	searchchannel.sendKeys(channelNumber + Keys.ENTER);
			
           // Click on the channel logo
           WebElement channelLogoElement = wait.until(ExpectedConditions.elementToBeClickable(channelLogo));
           channelLogoElement.click();
           System.out.println("Clicked on the channel logo.");

           // Wait for a few seconds to allow the user to view the video
           waitForPlayback();
           closePlayback();
           Thread.sleep(3000);
       }  
       
       
   // Method to wait for playback
       private void waitForPlayback() throws InterruptedException {
    	   try {
    	   boolean isVideoPlayed = wait.until(ExpectedConditions.presenceOfElementLocated(videoLocator)).isDisplayed();
    	     if (isVideoPlayed) 
    	     {
              System.out.println("Live Playback is successfull");
             } else 
                  {
                     System.out.println("Live Playback is failed");
                  }
             	 }catch (Exception e) {
    		 System.out.println("Error waiting for video playback: " + e.getMessage());
    	 }
    	   Thread.sleep(5000);
}   
 
    // Method to close the playback
       private void closePlayback(){
    	   try 
    	   {
    		 driver.findElement(closeButton).click();
    	    
    	   System.out.println("Closed the playback.");
           driver.navigate().back(); // Go back to the previous page
    	   } catch (Exception e) 
    	   {
    	        System.out.println("Error closing playback: " + e.getMessage());
    	    } 
    	   
    	   
       }     

}
package TVapp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VODPlayback {
    
	private WebDriver driver;
    private WebDriverWait wait;
    
 // Locators
    private By searchIcon = By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[1]/div/button/img");
    private By searchInput = By.className("search-input");
    private By firstResultImage = By.xpath("((//*[@class='slick-track'])[1]//img)");
    private By detailPageCTA = By.className("detail-page-cta");
    private By videoLocator = By.xpath("//*[@class=\"player-with-sidebar\"]");
    private By closeButton = By.xpath("//*[@id=\"videoWrapper\"]/div[3]/div[1]/div[2]/button");
    private By movieImage = By.xpath("//*[@id=\"915306997\"]/a/div[1]/img");
    private By rentConfirmationCTA = By.xpath("//*[@class=\"purchase-cta\"]//span");
    
 // Constructor
    public VODPlayback(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // You can adjust the timeout as needed
    }
   
        // Method to search and play a TV series
           public void playTVSeries(String seriesName) throws InterruptedException {
        // Click on search icon
           wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
        // Enter keyword in Search input field
           WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
           searchField.sendKeys(seriesName + Keys.ENTER);
        // Click on the first result in Search field
           wait.until(ExpectedConditions.elementToBeClickable(firstResultImage)).click();
           
        // Start playback
           wait.until(ExpectedConditions.elementToBeClickable(detailPageCTA)).click();
           Thread.sleep(10000); // Adjust as necessary

        // Check if video playback initiated
           boolean isVideoPlayed = wait.until(ExpectedConditions.visibilityOfElementLocated(videoLocator)).isDisplayed();
           if (isVideoPlayed) {
            System.out.println("TV Series video is displayed");
        } else {
            System.out.println("TV series video is not displayed");
        }
        // Close the playback
          // wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
           driver.findElement(closeButton).click();// Closing the playback
           }
        
           
           
           // Method to play a movie
           public void playMovie(String movieName) throws InterruptedException {
               // Search for the movie
              // WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        	   WebElement searchField=driver.findElement(searchInput);
              // searchField.clear();
        	   searchField.sendKeys(movieName + Keys.ENTER);
               
       // Click on the movie result
               wait.until(ExpectedConditions.elementToBeClickable(movieImage)).click();
       // Identify the primary CTA
               WebElement primaryCTA = wait.until(ExpectedConditions.visibilityOfElementLocated(detailPageCTA));
               String primaryButtonText = primaryCTA.getText();
               if (primaryButtonText.contains("Order")) {
                   primaryCTA.click(); // Click on the Primary CTA to start renting
                   wait.until(ExpectedConditions.elementToBeClickable(rentConfirmationCTA)).click(); // Confirm rent
               } else {
                   primaryCTA.click(); // Click to initiate playback
                   Thread.sleep(5000); // Adjust as necessary
                  // wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click(); // Closing the playback
                   driver.findElement(closeButton).click();// Closing the playback
               }
}
}
package TVapp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search {
	private WebDriver driver;
	
	//Locators
	private By searchIcon= By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[1]/div/button/img");
	private By searchInput= By.className("search-input");
	 private By searchResults = By.xpath("((//*[@class='slick-track'])[2]//img)");
	 
	 //Constructor
	 public Search(WebDriver driver) {
		 this.driver=driver;
	 }
	 
	 //Method to perform search
	 public void search(String keyword) throws InterruptedException {
	 // Click on search icon
	        driver.findElement(searchIcon).click(); 
	 // Enter keyword in search input field
	        WebElement searchField = driver.findElement(searchInput);
	        searchField.sendKeys(keyword + Keys.ENTER);
		 
	// Wait for search results to load
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults));
	        
	// click on the first result in the search field
	        List <WebElement> Images=driver.findElements(By.xpath("((//*[@class='slick-track'])[2]//img)"));
			
	        if (!Images.isEmpty()) 
	        {
	            WebElement firstImage = Images.get(0);
	            firstImage.click(); // Selects the first asset from search results and opens the details page
	        } else {
	            System.out.println("No images found.");
	        }
	        Thread.sleep(5000);
	 }

}


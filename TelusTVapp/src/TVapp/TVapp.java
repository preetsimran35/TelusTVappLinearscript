package TVapp;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TVapp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Create an instance of ChromeDriver (launch the Chrome browser)
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\T943216\\Downloads\\Selenium\\chromedriver-win32\\chromedriver.exe");
		driver= new ChromeDriver();
		// Maximize the window
		driver.manage().window().maximize();
		
		String URL="https://telustvplus.com/#/";
		String LoginID="optik.trial+8@gmail.com";
		String LoginPassword="TSQA!@34";
		
		//Launch Website
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
				
		//Close the tutorial message
		driver.findElement(By.xpath("//*[@id=\"onboardingModal\"]/div/div/div[1]/span/button/img")).click();
		
		//Login flow
		driver.findElement(By.className("login-button")).click(); //To click on Login button
		WebElement Login=driver.findElement(By.id("IDToken1"));
		Login.sendKeys(LoginID); //Input UserID
		
		WebElement Password=driver.findElement(By.id("IDToken2"));
		Password.sendKeys(LoginPassword); //Input Password
		driver.findElement(By.id("Submit")).click(); //Click on Submit button*/
		
		//Select profile
		WebElement profileSelection=driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[1]/button[1]/img"));
		profileSelection.click();
		Thread.sleep(3000);
		
		//Click on search icon
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[2]/div/div[1]/div/button/img")).click();
		
		//Enter keyword in Search input field
		WebElement Search=driver.findElement(By.className("search-input"));
		Search.sendKeys("Big Bang Theory"+Keys.ENTER);
		
		//Click on the first result in Search field
		List <WebElement> Images=driver.findElements(By.xpath("((//*[@class='slick-track'])//img)"));
		
        if (!Images.isEmpty()) 
        {
            WebElement firstImage = Images.get(0);
            firstImage.click(); // Selects the first asset from search results and opens the details page
        } else {
            System.out.println("No images found.");
        }
        
      //VOD TV Series Playback
		driver.findElement(By.className("detail-page-cta")).click();
		Thread.sleep(10000);
		By videoLocator=By.xpath("//*[@class=\"player-with-sidebar\"]");
		boolean isVideoPlayed=driver.findElement(videoLocator).isDisplayed(); //To check if playback initiated	
		 if (isVideoPlayed) 
		 {
			 System.out.println("Tv series video is displayed");
		 }
			 else
			 {
				 System.out.println("TV series video is not displayed");
			 }
		WebElement CloseButton=driver.findElement(By.xpath("//*[@id=\"videoWrapper\"]/div[3]/div[1]/div[2]/button"));
		CloseButton.click();//Closing the playback	
			
		//VOD Movie Playback
		//WebElement Search2=driver.findElement(By.className("search-input"));
		Search.sendKeys("Float"+Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"915306997\"]/a/div[1]/img")).click();
		
		//Identify the primary CTA to find it is available to Rent or playable
				WebElement PrimaryCTA=driver.findElement(By.className("detail-page-cta"));
				String PrimaryButton=PrimaryCTA.getText();
				if(PrimaryButton.contains("Order"))
				{
					PrimaryCTA.click();//clickon the Primary CTA to start renting
					WebElement rentCTA=driver.findElement(By.xpath("//*[@class=\"purchase-cta\"]//span"));//Rent confirmation
					rentCTA.click();
				}else {
					PrimaryCTA.click();//Click on the Primary CTA to initiate the playback
					Thread.sleep(10000);
					driver.findElement(By.xpath("//*[@id=\"videoWrapper\"]/div[3]/div[1]/div[2]/button/img")).click();//Closing the playback
                      }
		
			// Navigate to Guide	
			driver.findElement(By.linkText("Guide")).click();
			
			//Closing the filter channel pop-up
			driver.findElement(By.xpath("//*[@class='sc-eAKtBH gUOlpS']/img")).click();
			driver.findElement(By.xpath("//*[@class='sc-eAKtBH gUOlpS']/img")).click();
			
			//Live Playback
			WebElement searchchannel=driver.findElement(By.xpath("(//input)[2]")); 
			searchchannel.click();
			searchchannel.sendKeys("317" + Keys.ENTER);
			Thread.sleep(3000);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20000));
			WebElement Channel = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='cell channel-cell']//*[@class='logo']/img")));
			Channel.click();
			
			isVideoPlayed=driver.findElement(videoLocator).isDisplayed(); //To check if playback initiated	
			 if (isVideoPlayed) 
			 {
				 System.out.println("Live video is displayed");
			 }
				 else
				 {
					 System.out.println("Live video is not displayed");
				 }
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@class='imageButton playbackClose']//img[@src='/images/playback-close.svg']")).click();
			driver.navigate().back();
			
			//Logout
			WebElement UserProfileIcon=driver.findElement(By.xpath("//*[@class='avatar-button profile-menu-avatar ']"));
			Actions actions=new Actions(driver);
			actions.moveToElement(UserProfileIcon).perform();//Perform the mouse hover action on the user profileicon
			WebElement LogoutButton=driver.findElement(By.xpath("//*[@class='logout-button']"));
			LogoutButton.click();				
			
			driver.quit();
		
	}
	
}

package Test_Scenarios;

import TVapp.Login;
import TVapp.GuidePage;
import TVapp.LivePlayback;
import TVapp.Logout;
import TVapp.Search;
import TVapp.VODPlayback;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		
		//Launch the chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\T943216\\Downloads\\Selenium\\chromedriver-win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
		// Maximize the window
		driver.manage().window().maximize();
	    
        //Login
        Login NavigateToLogin=new Login(driver); //Create an instance of Login page
        NavigateToLogin.login("optik.trial+8@gmail.com", "TSQA!@34");
	   
        
       //Search   
       Search NavigateToSearch=new Search(driver);
       NavigateToSearch.search("40-Love");
      
       //VOD TV series Playback   
       VODPlayback NavigateToVodplayback=new VODPlayback(driver);
       NavigateToVodplayback.playTVSeries("Big bang Theory");
       
       //VOD Movie Playback
       NavigateToVodplayback.playMovie("Float");
     
      
       //Guide
       GuidePage navigatetoguide=new GuidePage(driver);
       navigatetoguide.clickGuidelink();
       navigatetoguide.closepopup();
       
       //LivePlayback
       LivePlayback NavigateToLiveplayback=new LivePlayback(driver);
       NavigateToLiveplayback.startLivePlayback(String.valueOf(317)); 
     
       //Logout
       Logout NavigateToLogout=new Logout(driver);
       NavigateToLogout.logout();
          
       driver.quit();
       
 	}
}

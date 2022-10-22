package test01;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class web {

	public static void main(String[] args) {
		 // Try-Catch Block For Implementing Sleep Method
        try {
            // String Where Home Page URL Is Stored
            String baseUrl = "https://www.google.com/";
            
            // For Firefox	
//            System.setProperty(
//                "webdriver.gecko.driver",
//                "C:\\geckodriver-v0.31.0-win64/geckodriver.exe");
//            WebDriver driver = new FirefoxDriver();
            
            // For Chrome 
            System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32/chromedriver.exe");
            ChromeDriver driver = new ChromeDriver();
            
            
            // Calling the Home Page By Using Get() Method
            driver.get(baseUrl);
            
            // Delaying The Output
            Thread.sleep(2000);
            
            // Closing The Opened Window
            driver.quit();
        }
        catch (Exception e) {
            // Catching The Exception
            System.out.println(e);
        }

	}

}

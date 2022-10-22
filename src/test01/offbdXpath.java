package test01;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class offbdXpath {


	public static void main(String[] args) {
		 
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.offbd.com");
        wait10Sec();
        driver.findElement(By.xpath("//a[contains(@href, '/Offer/All')]")).click();
        wait10Sec();   
        System.out.println("Click Successfully"); 
        wait10Sec(); 
        driver.quit();

	}

	
	 private static void wait10Sec() {
		 ChromeDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	 }
}

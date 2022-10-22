package test01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class offbdList {

	public static void main(String[] args) throws InterruptedException {

		// String driverName = "webdriver.chrome.driver";
		// String driverLocation = "C:\\chromedriver_win32/chromedriver.exe";
		String driverName = "webdriver.gecko.driver";
		String driverLocation = "C:\\geckodriver-v0.31.0-win64/geckodriver.exe";
		System.setProperty(driverName, driverLocation);
		// ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		//driver.get("http://www.offbd.com");
		driver.get("http://www.offbd.com/Offer/All");
		waitSecond(1);
		driver.manage().window().maximize();
		waitSecond(2);

		 //findElementByXpathClick("(//a[@href='/Offer/All'])[1]");
		 //findElementByXpathClick("(//a[@class='link'][contains(.,'View all')]");
		//driver.findElement(By.cssSelector("a[href*='.view_offer_link > a:nth-child(1)']")).click();
		//showMessage("Click on View All");
		//waitSecond(5);

		for (int i = 1; i <= 4; i++) {
			waitSecond(3);
			List<WebElement> elements = findListByXpath("(//a[contains(@class,'btn sublink link')])");
			//WebElement elements =  driver.findElement(By.xpath("(//a[contains(@class,'btn sublink link')])"));
			waitSecond(3);
			int s = elements.size();
			showMessage(String.valueOf(s));
			for (int j = 1; j <= 2; j++) {
				if(i <= s) {
					findElementByXpathClick("(//a[contains(@class,'btn sublink link')])[" + j + "]");
					waitSecond(5);			
					String heading = findElementByXpathGetText("//*[@id=\"details_container\"]/div[2]/div[1]/h3");
					String old_price = findElementByXpathGetText("//*[@id=\"details_container\"]/div[2]/div[4]");
					String discount = findElementByXpathGetText("//*[@id=\"details_container\"]/div[2]/div[5]");
					String new_price = findElementByXpathGetText("//div[contains(@class,'new_p_text bold_font')]");
					showMessage(heading + "\n" + old_price + "\n" + discount + "\n" + new_price + "\n" );

					waitSecond(3);
					driver.navigate().back();
					waitSecond(2);			
				}

			}
			findElementByXpathClick("(//span[contains(@class,'next')])[1]");
			showMessage("Click on Next Button");
			waitSecond(1);
		}


		// driver.quit();

		// WebElement elm = driver.findElement(By.cssSelector("a[href*='.view_offer_link
		// > a:nth-child(1)']"));
		//String s = elm.getText();
		//System.out.println("Text is: " + s);
		//driver.quit();

	}

	private static void waitSecond(int sec) throws InterruptedException {
		Thread.sleep(sec * 1000);
	}

	private static void showMessage(String msg) {
		System.out.println(msg);
	}

	@SuppressWarnings("unchecked")
	private static List<WebElement> findListByXpath(String xpl)  {
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		return (List<WebElement>) driver.findElement(By.xpath(xpl));

	}

	private static String findElementByXpathGetText(String xp) throws InterruptedException  {
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.findElement(By.xpath(xp)).getText();
		waitSecond(2);
		return xp;
	}
	private static void findElementByXpathClick(String xpc) {
		// ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.findElement(By.xpath(xpc)).click();
		showMessage("Clicked Successfully");
		try {
			waitSecond(3);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}

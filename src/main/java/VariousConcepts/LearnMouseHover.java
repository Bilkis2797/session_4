package VariousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnMouseHover {

	WebDriver driver;
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.dell.com/en-us");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void mouseHoverTest() {
		
		By PRODUCT_MENU_FIELD = By.xpath("//span[text()='Products']");
		By MONITOR_MENU_FIELD = By.xpath("//button[text()='Monitors']");
		By ALL_MONITOR_MENU_FIELD = By.xpath("//a[text()='View All Monitors']");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(PRODUCT_MENU_FIELD)).build().perform();
		action.moveToElement(driver.findElement(MONITOR_MENU_FIELD)).build().perform();
		driver.findElement(ALL_MONITOR_MENU_FIELD).click();
	}
	
}

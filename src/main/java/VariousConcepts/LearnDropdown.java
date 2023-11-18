package VariousConcepts;


import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropdown {

	WebDriver driver;
	//Element list
	By USER_NAME_FIELD = By.xpath("//*[@id=\"username\"]");
	By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
	By SIGNIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	By CUSTOMER_MENU_FIELD = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
	By ADD_CUSTOMER_MENU_FIELD = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a");
	By ADD_CONTRACT_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5");
	By FULL_NAME_FIELD = By.xpath("//*[@id=\"account\"]");
	By COMPANY_DROPDOWN_FIELD = By.xpath("//select[@id = 'cid']");
	
	
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://www.techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() {
		
		
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();
		
		String dashboardHeaderText = driver.findElement(DASHBOARD_HEADER_FIELD).getText();
		String dashboardPageTitle = driver.getTitle();
		System.out.println(dashboardPageTitle);
		
		
		//Assert.assertTrue("Dashboard page not found", driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
	   // Assert.assertEquals("Dashboard page not found","Dashboard", dashboardHeaderText);
	    Assert.assertEquals("Dashboard page not found", "Dashboard- iBilling", dashboardPageTitle);
	}
	
	@Test
	public void addCustomerTest() throws InterruptedException {
		loginTest();
		
		driver.findElement(CUSTOMER_MENU_FIELD).click();
		driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
		Assert.assertEquals("Add customer page not found", "Add Contact", driver.findElement(ADD_CONTRACT_HEADER_FIELD).getText());
	    Thread.sleep(2000);
	    driver.findElement(FULL_NAME_FIELD).sendKeys("Selenium");
	    Select sel= new Select(driver.findElement(COMPANY_DROPDOWN_FIELD));
	    sel.selectByVisibleText("Techfios");
	    
	    sel.getOptions();
	  
	}

}

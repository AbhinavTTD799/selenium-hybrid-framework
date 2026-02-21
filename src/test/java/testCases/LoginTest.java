package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;


public class LoginTest extends BaseClass {
	
	public Logger logger;
	
	@BeforeClass
	public void login()
	{	
		logger= LogManager.getLogger(this.getClass());
		logger.debug("************* Launching Browser *****************");
		System.out.println("This is Login Step");
		System.setProperty("webdriver.chrome.driver","./Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void openapp()
	{
		logger.debug("************* Launching Application *****************");
		System.out.println("This is Open Application Step");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		lp.clickLogin();
	}
	
	@AfterClass
	public void logout()
	{
		logger.debug("************* Closing Browser *****************");
		System.out.println("This is Logout Step");
		driver.quit();
	}

}
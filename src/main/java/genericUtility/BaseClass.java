package genericUtility;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;

import static genericUtility.PropertyFile.*;

import java.io.File;
import java.io.IOException;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePageClass;
import objectRepository.LoginPageClass;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	WebDriverUtility webDriverUtility;
	
	@BeforeSuite
	public void connectToDataBase() {
		System.out.println("===> connect to DataBase ===>");
	}
	@AfterSuite
	public void disconnectToDataBase() {
		System.out.println("===> Disconnect to DataBase===>");
	}
	
	@BeforeClass
	public void launchTheBrowser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(readDataFromPropertyFile("url"));
		webDriverUtility = new WebDriverUtility(driver);
		webDriverUtility.maximize();
		webDriverUtility.implicitlyWait();
	}
	@AfterClass
	public void closeTheBrowser() {
		driver.close();
	}
	@BeforeMethod
	public void loginIntoAppllication() throws Throwable {
		LoginPageClass loginPageClass = new LoginPageClass(driver);
		loginPageClass.getUserNameTf().sendKeys(readDataFromPropertyFile("username"));
		loginPageClass.getPassWordTf().sendKeys(readDataFromPropertyFile("password"));
		loginPageClass.getLoginBtn().click();
	}
	@AfterMethod
	public void logOutFromApplication() {
		HomePageClass homePageClass = new HomePageClass(driver);
		homePageClass.getHomeBtn().click();
		homePageClass.getAdminBtn().click();
		homePageClass.getLogOutBtn().click();
	}
	public static String screenShot(String name) {
		TakesScreenshot takesScreenshot = (TakesScreenshot)BaseClass.sdriver;
		File src=(File) takesScreenshot.getScreenshotAs(OutputType.FILE);
		String path = "./ScreenShot/"+name+".PNG"; 
		File dest = new File(path);
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}

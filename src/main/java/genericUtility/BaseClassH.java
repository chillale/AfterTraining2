package genericUtility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import static genericUtility.PropertyFile.*;

import java.io.File;
import java.io.IOException;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePageClass;
import objectRepository.LoginPageClass;

public class BaseClassH {
	public WebDriver driver;
	public static WebDriver sdriver;
	WebDriverUtility webDriverUtility;
	
	@BeforeSuite
	public void connecttoDB() {
		System.out.println("===> connecting to Database===>");
	}
	
	@AfterSuite
	public void disconnectToDB() {
		System.out.println("===> disconnecting to Database===>");
	}
	
	@org.testng.annotations.BeforeClass
	public void launchTheBrowser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(readDataFromPropertyFile("url"));
		webDriverUtility = new WebDriverUtility(driver);
		webDriverUtility.maximize();
		webDriverUtility.implicitlyWait();	
	}
	
	@org.testng.annotations.AfterClass
	public void closeTheBrowser() {
		driver.close();
	}
	
	@BeforeMethod
	public void loginToApplication() throws Throwable {
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
	
	public static String takeScreenShot(String name) {
		TakesScreenshot takeScrenShot = (TakesScreenshot)BaseClass.sdriver;
		File src = takeScrenShot.getScreenshotAs(OutputType.FILE);
		String path = "./ScreenShot1/"+name+".PNG";
		File dest = new File(path);
		try {
		FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
 
}

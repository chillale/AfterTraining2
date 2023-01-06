package zooManagement;

import java.util.concurrent.TimeUnit;
import static genericUtility.PropertyFile.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPageClass;

public class AddVisitor1Test {
	@Test
	public void addVisitor() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		driver.get(readDataFromPropertyFile("url"));
		 
		driver.manage().window().maximize();
		LoginPageClass loginPageClass = new LoginPageClass(driver);
		loginPageClass.getUserNameTf().sendKeys(readDataFromPropertyFile("username"));
		loginPageClass.getPassWordTf().sendKeys(readDataFromPropertyFile("password"));
		loginPageClass.getLoginBtn().click();
		
		
	}

}

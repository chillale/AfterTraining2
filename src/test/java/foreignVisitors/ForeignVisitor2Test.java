package foreignVisitors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.JavaFaker;
import genericUtility.WebDriverUtility;

import static genericUtility.PropertyFile.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AddForeignClass;
import objectRepository.HomePageClass;
import objectRepository.LoginPageClass;

public class ForeignVisitor2Test {
	@Test
	public void foreignVisitor() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(readDataFromPropertyFile("url"));
		WebDriverUtility webDriverUtility = new WebDriverUtility(driver);
		webDriverUtility.maximize();
		webDriverUtility.implicitlyWait();
		LoginPageClass loginPageClass = new LoginPageClass(driver);
		loginPageClass.getUserNameTf().sendKeys(readDataFromPropertyFile("username"));
		loginPageClass.getPassWordTf().sendKeys(readDataFromPropertyFile("password"));
		loginPageClass.getLoginBtn().click();
		HomePageClass homePageClass = new HomePageClass(driver);
		homePageClass.getForeignersTicketBtn().click();
		AddForeignClass addForeignClass = new AddForeignClass(driver);
		addForeignClass.getAddTicket().click();
		JavaFaker jf = new JavaFaker();
		addForeignClass.getVisitorName().sendKeys(jf.foreignerName());
		addForeignClass.getNoOfAdult().sendKeys(jf.noOfAdult());
		addForeignClass.getNoOfChildren().sendKeys(jf.noOfChildren());
		addForeignClass.getSubmitBtn().click();
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
		homePageClass.getHomeBtn().click();
		homePageClass.getAdminBtn().click();
		homePageClass.getLogOutBtn().click();
		driver.close();
		
		
	}

}

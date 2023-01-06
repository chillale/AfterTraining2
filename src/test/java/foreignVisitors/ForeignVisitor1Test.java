package foreignVisitors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.JavaFaker;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AddForeignClass;
import objectRepository.HomePageClass;
import objectRepository.LoginPageClass;
import static genericUtility.JavaFaker.*;
import static genericUtility.PropertyFile.*;
public class ForeignVisitor1Test {
	@Test
	public void addForeignVisitor() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		LoginPageClass loginPageClass = new LoginPageClass(driver);
		driver.get(readDataFromPropertyFile("url"));
		WebDriverUtility webDriverUtility = new WebDriverUtility(driver);
		webDriverUtility.maximize();
		webDriverUtility.implicitlyWait();
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
		Alert alert = driver.switchTo().alert();
				alert.accept();
		homePageClass.getHomeBtn().click();
		homePageClass.getAdminBtn().click();
		homePageClass.getLogOutBtn().click();
	}

}

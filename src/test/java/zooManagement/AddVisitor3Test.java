package zooManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.WebDriverUtility;

import static genericUtility.PropertyFile.*;
import static genericUtility.ExcelfileUtils.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AddTicketClass;
import objectRepository.HomePageClass;
import objectRepository.LoginPageClass;

public class AddVisitor3Test {
	
	@Test(dataProvider = "provideData")
	public void addVisitor(String visitorName, String noOfAdult, String noOfChildren) throws Throwable {
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
		homePageClass.getNormalTicketBtn().click();
		AddTicketClass addTicketClass = new AddTicketClass(driver);
		addTicketClass.getAddTicketBtn().click();
		addTicketClass.getVisitorNameTf().sendKeys(visitorName);
		addTicketClass.getNoOfAdultTf().sendKeys(noOfAdult);
		addTicketClass.getNoOfChildrenTf().sendKeys(noOfChildren);
		addTicketClass.getSubmitBtn().click();
		webDriverUtility.alert();
		addTicketClass.getHomeBtn().click();
		homePageClass.getAdminBtn().click();
		homePageClass.getLogOutBtn().click();
		}
	@DataProvider
	public Object[][] provideData() throws Throwable {
		Object[][] objArray = new Object[2][3];
		objArray[0][0]=readDataFromExcel("sheet1", 4, 0);
		objArray[0][1]=readDataFromExcel("sheet1", 4, 1);
		objArray[0][2]=readDataFromExcel("sheet1", 4, 2);
		
		objArray[1][0]=readDataFromExcel("sheet1", 3, 0);
		objArray[1][1]=readDataFromExcel("sheet1", 3, 1);
		objArray[1][2]=readDataFromExcel("sheet1", 3, 2);
		return objArray;
	}
	

}

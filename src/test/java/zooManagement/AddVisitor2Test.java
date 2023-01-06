package zooManagement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static genericUtility.PropertyFile.*;
import static genericUtility.ExcelfileUtils.*;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.AddTicketClass;
import objectRepository.HomePageClass;
import objectRepository.LoginPageClass;

public class AddVisitor2Test {
     @Test
     public void addVisitor() throws Throwable {
    	 WebDriverManager.chromedriver().setup();
    	 WebDriver driver =new ChromeDriver();
    	 driver.get(readDataFromPropertyFile("url"));
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
    	 LoginPageClass loginPageClass = new LoginPageClass(driver);
    	 loginPageClass.getUserNameTf().sendKeys(readDataFromPropertyFile("username"));
    	 loginPageClass.getPassWordTf().sendKeys(readDataFromPropertyFile("password"));
    	 loginPageClass.getLoginBtn().click();
    	 HomePageClass homePageClass = new HomePageClass(driver);
    	 homePageClass.getNormalTicketBtn().click();
    	 AddTicketClass addTicketClass = new AddTicketClass(driver);
    	 addTicketClass.getAddTicketBtn().click();
    	 addTicketClass.getVisitorNameTf().sendKeys(readDataFromExcel("sheet1", 0, 0));
    	 addTicketClass.getNoOfAdultTf().sendKeys(readDataFromExcel("sheet1", 0, 1));
    	 addTicketClass.getNoOfChildrenTf().sendKeys(readDataFromExcel("sheet1", 0, 2));
    	 addTicketClass.getSubmitBtn().click();
    	 Alert alert = driver.switchTo().alert();
    	 System.out.println(alert.getText());
    	 alert.accept();
    	 addTicketClass.getHomeBtn().click();
    	 homePageClass.getAdminBtn().click();
    	 homePageClass.getLogOutBtn().click(); 
    	 
    	 
     }
}

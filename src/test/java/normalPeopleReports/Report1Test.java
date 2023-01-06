package normalPeopleReports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.WebDriverUtility;

import static genericUtility.PropertyFile.*;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePageClass;
import objectRepository.LoginPageClass;
import objectRepository.NormalPeopleReportClass;

public class Report1Test {
	@Test
	public void report() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get(readDataFromPropertyFile("url"));
		WebDriverUtility webDriverUtility = new WebDriverUtility(driver);
		webDriverUtility.maximize();
		webDriverUtility.implicitlyWait();
		LoginPageClass loginPageClass = new LoginPageClass(driver);
		loginPageClass.getUserNameTf().sendKeys(readDataFromPropertyFile("username"));
		loginPageClass.getPassWordTf().sendKeys(readDataFromPropertyFile("password"));
		loginPageClass.getLoginBtn().click();
		HomePageClass homePageClass = new HomePageClass(driver);
		homePageClass.getReportsBtn().click();
		NormalPeopleReportClass normalPeopleReportClass = new NormalPeopleReportClass(driver);
		normalPeopleReportClass.getNormalPeopleReportBtn().click();
		normalPeopleReportClass.getFromDateTf().sendKeys("01"+Keys.ENTER+"09"+Keys.ENTER+"2022");
		normalPeopleReportClass.getToDateTf().sendKeys("01"+Keys.ENTER+"01"+Keys.ENTER+"2023");
		normalPeopleReportClass.getSubmitBtn().click();
		List<WebElement> tablecontent = driver.findElements(By.xpath("//table[@class='table text-center']/tbody/tr"));
		System.out.println(tablecontent.size());
		for(int i=1;i<=tablecontent.size();i++) {
			//String s=driver.findElement(By.xpath("//table[@class='table text-center']/tbody/tr")).getText();
			for(int j=1;j<=5;j++) {
				System.out.println(driver.findElement(By.xpath("//table[@class='table text-center']/tbody["+i+"]/tr/td[3]")).getText());
				break;
			}
		}
		
	}

}

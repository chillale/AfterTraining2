package foreignVisitors;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import genericUtility.BaseClassH;

import static genericUtility.ExcelfileUtils.*;
import objectRepository.AddForeignClass;
import objectRepository.HomePageClass;

public class ForeignVisitor5Test extends BaseClassH{
	@Test
	public void addvisitor() throws Throwable {
		HomePageClass homePageClass = new HomePageClass(driver);
		homePageClass.getForeignersTicketBtn().click();
		AddForeignClass addForeignClass = new AddForeignClass(driver);
		addForeignClass.getAddTicket().click();
		addForeignClass.getVisitorName().sendKeys(readDataFromExcel("sheet1", 17, 0));
		addForeignClass.getNoOfAdult().sendKeys(readDataFromExcel("sheet1", 17, 1));
		addForeignClass.getNoOfChildren().sendKeys(readDataFromExcel("sheet1", 17, 2));
		addForeignClass.getSubmitBtn().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}

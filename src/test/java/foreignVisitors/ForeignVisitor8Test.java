package foreignVisitors;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import static genericUtility.ExcelfileUtils.*;
import genericUtility.BaseClassH;
import objectRepository.AddForeignClass;
import objectRepository.HomePageClass;

public class ForeignVisitor8Test extends BaseClassH{
	@Test
	public void addVisitor() throws Throwable {
		HomePageClass homePageClass = new HomePageClass(driver);
		homePageClass.getForeignersTicketBtn().click();
		AddForeignClass addForeignClass = new AddForeignClass(driver);
		addForeignClass.getAddTicket().click();
		addForeignClass.getVisitorName().sendKeys(readDataFromExcel("sheet1", 11, 0));
		addForeignClass.getNoOfAdult().sendKeys(readDataFromExcel("sheet1", 11, 1));
		addForeignClass.getNoOfChildren().sendKeys(readDataFromExcel("sheet1", 11, 2));
		addForeignClass.getSubmitBtn().click();
		Alert alert =  driver.switchTo().alert();
		alert.accept();
	}

}

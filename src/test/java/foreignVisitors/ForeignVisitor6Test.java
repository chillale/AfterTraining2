package foreignVisitors;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import static genericUtility.ExcelfileUtils.*;
import genericUtility.BaseClassH;
import objectRepository.AddForeignClass;
import objectRepository.HomePageClass;

public class ForeignVisitor6Test extends BaseClassH{
	@Test
	public void addVisitor() throws Throwable {
		HomePageClass homePageClass = new HomePageClass(driver);
		homePageClass.getForeignersTicketBtn().click();
		AddForeignClass addForeignClass = new AddForeignClass(driver);
		addForeignClass.getAddTicket().click();
		addForeignClass.getVisitorName().sendKeys(readDataFromExcel("sheet1", 18, 0));
		addForeignClass.getNoOfAdult().sendKeys(readDataFromExcel("sheet1", 18, 1));
		addForeignClass.getNoOfChildren().sendKeys(readDataFromExcel("sheet1", 18, 2));
		addForeignClass.getSubmitBtn().click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}

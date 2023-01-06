package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NormalPeopleReportClass {
	WebDriver driver;
	
	@FindBy(linkText = "Normal People Report")
	private WebElement normalPeopleReportBtn;
	
	@FindBy(id = "fromdate")
	private WebElement fromDateTf;
	
	@FindBy(id = "todate")
	private WebElement toDateTf;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	public NormalPeopleReportClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getNormalPeopleReportBtn() {
		return normalPeopleReportBtn;
	}

	public WebElement getFromDateTf() {
		return fromDateTf;
	}

	public WebElement getToDateTf() {
		return toDateTf;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	

}

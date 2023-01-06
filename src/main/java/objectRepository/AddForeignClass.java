package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddForeignClass {
	WebDriver driver;
	@FindBy(linkText = "Add Ticket")
	private WebElement addTicket;
	
	@FindBy(id = "visitorname")
	private WebElement visitorName;
	
	
	
	@FindBy(id = "noadult")
	private WebElement noOfAdult;
	
	@FindBy(id = "nochildren")
	private WebElement noOfChildren;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	public AddForeignClass(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public WebElement getVisitorName() {
		return visitorName;
	}



	public WebElement getAddTicket() {
		return addTicket;
	}

	public WebElement getNoOfAdult() {
		return noOfAdult;
	}

	public WebElement getNoOfChildren() {
		return noOfChildren;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	

}

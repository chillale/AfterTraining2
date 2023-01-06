package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTicketClass {
	WebDriver driver;
	
	@FindBy(linkText = "Add Ticket")
	private WebElement addTicketBtn;
	
	@FindBy(id = "visitorname")
	private WebElement visitorNameTf;
	
	@FindBy(id = "noadult")
	private WebElement noOfAdultTf;
	
	@FindBy(id = "nochildren")
	private WebElement noOfChildrenTf;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;
	
	@FindBy(linkText = "Home")
	private WebElement homeBtn;
	
	public AddTicketClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddTicketBtn() {
		return addTicketBtn;
	}

	public WebElement getVisitorNameTf() {
		return visitorNameTf;
	}

	public WebElement getNoOfAdultTf() {
		return noOfAdultTf;
	}

	public WebElement getNoOfChildrenTf() {
		return noOfChildrenTf;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}
	
	
	
}

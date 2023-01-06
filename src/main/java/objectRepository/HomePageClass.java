package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageClass {
	WebDriver driver;
	@FindBy(className = "ti-dashboard")
	private WebElement dashBoardBtn;
	
	@FindBy(xpath = "//span[text()='Animals Details']")
	private WebElement animalDetailsBtn;
	
	@FindBy(xpath = "//span[text()='Normal Ticket']")
	private WebElement normalTicketBtn;
	
	@FindBy(xpath = "//span[text()='Foreigners Ticket']")
	private WebElement foreignersTicketBtn;
	
	@FindBy(xpath = "//span[text()='Page']")
	private WebElement pageBtn;
	
	@FindBy(xpath = "//span[text()='Reports']")
	private WebElement reportsBtn;
	
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement searchBtn;
	
	@FindBy(linkText = "Home")
	private WebElement homeBtn;
	
	@FindBy(xpath = "//h4[text()='Admin ']")
	private WebElement adminBtn;
	
	@FindBy(linkText = "Log Out")
	private WebElement logOutBtn;
	
	public HomePageClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDashBoardBtn() {
		return dashBoardBtn;
	}

	public WebElement getAnimalDetailsBtn() {
		return animalDetailsBtn;
	}

	public WebElement getNormalTicketBtn() {
		return normalTicketBtn;
	}

	public WebElement getForeignersTicketBtn() {
		return foreignersTicketBtn;
	}

	public WebElement getPageBtn() {
		return pageBtn;
	}

	public WebElement getReportsBtn() {
		return reportsBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getAdminBtn() {
		return adminBtn;
	}

	public WebElement getLogOutBtn() {
		return logOutBtn;
	}
	

}

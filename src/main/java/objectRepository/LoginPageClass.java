package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {
    WebDriver driver;
    @FindBy(id = "username")
    private WebElement userNameTf;
    
    @FindBy(id = "password")
    private WebElement passWordTf;
    
    @FindBy(id = "form_submit")
    private WebElement loginBtn;
    
    public LoginPageClass(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }

	public WebElement getUserNameTf() {
		return userNameTf;
	}

	public WebElement getPassWordTf() {
		return passWordTf;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
    
}

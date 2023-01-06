package genericUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
     WebDriver driver;
     public WebDriverUtility(WebDriver driver) {
    	 this.driver = driver;
     }
	public  void maximize() {
		driver.manage().window().maximize();
	}
	public  void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
	}
	public  void alert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}

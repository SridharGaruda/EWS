package ewsPom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "inputName")
	WebElement userName;

	@FindBy(id = "inputPassword")
	WebElement Password;

	@FindBy(id = "submitForm")
	WebElement LoginBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String login(String UserName, String password) {
		userName.sendKeys(UserName);
		Password.sendKeys(password);
		LoginBtn.click();
		return driver.getTitle();
	}

	public boolean Invalidlogin(String UserName, String password) {
		userName.sendKeys(UserName);
		Password.sendKeys(password);
		LoginBtn.click();
		boolean errorMsgDisplayed = driver.findElement(By.className("error")).getText()
				.contains("Invalid credentials!!");
		System.out.println(errorMsgDisplayed);
		return errorMsgDisplayed;
	}

}

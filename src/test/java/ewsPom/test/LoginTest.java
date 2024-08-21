package ewsPom.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import ewsPom.pages.LoginPage;

public class LoginTest {

	WebDriver driver;
	LoginPage login;

	@BeforeMethod
	public void BrowserSetup() {
		driver = new ChromeDriver();
		login = new LoginPage(driver);
		driver.get("http://192.168.10.101:8101/ews/");
		driver.manage().window().maximize();
	}

	public void CheckError(boolean Error) {
		SoftAssert SoftAssert = new SoftAssert();
		SoftAssert.assertTrue(Error);
		SoftAssert.assertAll();
	}

	@Test
	public void logintest_ValidCredentials() throws InterruptedException {
		String Title = login.login("Super", "Aipl@2024");
		System.out.println(Title);
		SoftAssert SoftAssert = new SoftAssert();
		SoftAssert.assertEquals(Title, "EWS | Dashboard");
		SoftAssert.assertAll();
	}

	@Test
	public void logintest_InValidUserID() {
		Boolean Error = login.Invalidlogin("Sup", "Aipl@2024**");
		CheckError(Error);
	}

	@Test
	public void logintest_InValidPassword() {
		Boolean Error = login.Invalidlogin("Super", "Aipl@2024**");
		CheckError(Error);
	}

	@Test
	public void logintest_InValidCredentials() {
		Boolean Error = login.Invalidlogin("Super1", "Aipl@2024");
		CheckError(Error);
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}

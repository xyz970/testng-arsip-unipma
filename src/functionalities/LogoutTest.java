package functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class LogoutTest {

	@Test(priority = 109, dependsOnGroups = { "login_group" })
	public void logoutTestPage() throws InterruptedException {
		Thread.sleep(2000);
		WebDriver driver = Setup.getDriver();
		Reporter.log("Pengguna keluar dari aplikasi dengan mengklik logout dan akan diarahkan ke halaman login");
		driver.findElement(By.cssSelector("#navbarDropdownUserImage > img")).click();
		driver.findElement(By.cssSelector("#sidenavAccordion > ul > li > div > form > button")).click();

	}
}

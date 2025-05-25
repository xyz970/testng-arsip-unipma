package functionalities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class ProfileTest {
	@Test(priority = 100, dependsOnGroups = { "login_group" })
	public void accessProfilePage() {
		Reporter.log("Halaman menampilkan ubah data profil yang sedang login");
		WebDriver driver = Setup.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(By.cssSelector("#navbarDropdownUserImage > img")).click();
		driver.findElement(By.cssSelector("#sidenavAccordion > ul > li > div > a")).click();

	}

	@Test(priority = 101, dependsOnGroups = { "login_group" })
	public void updateWithEmptyInput() {
		Reporter.log("Tampilkan pesan peringatan ketika input kosong");
		WebDriver driver = Setup.getDriver();
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.cssSelector(
				"#layoutSidenav_content > main > div > div:nth-child(4) > div.col-xl-8 > div > div.card-body > form > button"))
				.click();
	}

	@Test(priority = 102, dependsOnGroups = { "login_group" })
	public void updateWithFalseInput() {
		Reporter.log("Tampilkan pesan error ketika input tidak valid (cth. input email diisi tanpa karakter '@')");
		WebDriver driver = Setup.getDriver();
		driver.findElement(By.name("name")).sendKeys("Admin@#!");
		driver.findElement(By.name("email")).sendKeys("admin#*&@gmail.com");
		driver.findElement(By.cssSelector(
				"#layoutSidenav_content > main > div > div:nth-child(4) > div.col-xl-8 > div > div.card-body > form > button"))
				.click();
	}
	
	@Test(priority = 103, dependsOnGroups = { "login_group" })
	public void updateWithValidInput() throws InterruptedException {
		Reporter.log("User bisa melakukan ubah profil(nama, email, dan foto profil) ketika input valid");
		WebDriver driver = Setup.getDriver();
		Thread.sleep(2500);
		driver.findElement(By.cssSelector("#navbarDropdownUserImage > img")).click();
		driver.findElement(By.cssSelector("#sidenavAccordion > ul > li > div > a")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("email")).clear();
		
		driver.findElement(By.name("name")).sendKeys("Admin");
		driver.findElement(By.name("email")).sendKeys("admin@gmail.com");
		driver.findElement(By.cssSelector(
				"#layoutSidenav_content > main > div > div:nth-child(4) > div.col-xl-8 > div > div.card-body > form > button"))
		.click();
	}
}

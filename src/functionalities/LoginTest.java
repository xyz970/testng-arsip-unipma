package functionalities;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helpers.Setup;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class LoginTest {

	
	@Test(priority = 1,groups = {"login_group"})
	public void accessWeb() throws InterruptedException {
		Reporter.log("Access web");
		System.out.println("Access Web");
		Setup.getDriver().get(Setup.getWebUrl());
	}
	
	@Test(priority=2,dependsOnMethods = "accessWeb")
	public void loginEmpty() {
		WebDriver driver =Setup.getDriver();
		Reporter.log("Login dengan email dan password kosong");
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		assertWhenNotRedirected();
		
	}
	@Test(priority=2,dependsOnMethods = "loginEmpty")
	public void loginWithoutEmail() {
		WebDriver driver =Setup.getDriver();
		Reporter.log("Login dengan field email kosong");
		driver.findElement(By.id("password")).sendKeys("1234");
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		assertWhenNotRedirected();
		
	}
	@Test(priority=2,dependsOnMethods = "loginWithoutEmail")
	public void loginWithoutPassword() {
		WebDriver driver =Setup.getDriver();
		resetInputForm();
		Reporter.log("Login dengan field email kosong");
		driver.findElement(By.id("email")).sendKeys("admin@gmail.com");
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		assertWhenNotRedirected();
		
	}
	
	@Test(priority=2,dependsOnMethods = "loginWithoutPassword")
	public void loginInvalidEmailWithoutPass() {
		WebDriver driver =Setup.getDriver();
		Reporter.log("Login tanpa password dan dengan email yang tidak valid");
		resetInputForm();
		driver.findElement(By.id("email")).sendKeys("emailtest");
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		assertWhenNotRedirected();
	}
	
	@Test(priority=2,dependsOnMethods = "loginInvalidEmailWithoutPass")
	public void loginInvalidEmailWithPass() {
		WebDriver driver =Setup.getDriver();
		Reporter.log("Login dengan email tidak valid dan dengan password");
		resetInputForm();
		driver.findElement(By.id("email")).sendKeys("emailtest");
		driver.findElement(By.id("password")).sendKeys("1234");
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		assertWhenNotRedirected();
	}
	
	
	@Test(priority = 2, dependsOnMethods = "loginInvalidEmailWithPass")
	public void loginFunction() throws InterruptedException, IOException {
		WebDriver driver =Setup.getDriver();
		Reporter.log("Login dengan username dan password valid");
		System.out.println("Login");
		for (int i = 0; i < getEmailsCreds().size(); i++) {
			resetInputForm();
			driver.findElement(By.id("email")).sendKeys(getEmailsCreds().get(i));
			driver.findElement(By.id("password")).sendKeys(getPasswordsCreds().get(i));
			WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
			button.click();
			Thread.sleep(500);
		}
	}
	
	
	private List<String> getEmailsCreds() throws IOException {
		String path = Setup.getParentDirectory()+"credentials\\email.txt";
		List<String> allLines = Files.readAllLines(Paths.get(path));
		   return allLines;
	}
	
	private List<String> getPasswordsCreds() throws IOException {
		String path = Setup.getParentDirectory()+"credentials\\password.txt";
		List<String> allLines = Files.readAllLines(Paths.get(path));
		   return allLines;
	}
	
	protected void assertWhenNotRedirected() {
		WebDriver driver;
		driver = Setup.getDriver();
		assertTrue(driver.getCurrentUrl().replaceAll("(?)https", "http").equals(Setup.getWebUrl()));
	}
	
	protected void resetInputForm() {
		WebDriver driver;
		driver = Setup.getDriver();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
	}
	
	
}


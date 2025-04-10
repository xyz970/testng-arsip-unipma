package functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class UserDataTest {
	@Test(priority = 3, dependsOnGroups = { "login_group" })
	public void UserDataTestPage() throws InterruptedException {
		
		Reporter.log("user data");
		WebDriver driver = Setup.getDriver();
		driver.get(Setup.getWebUrl() + "admin/user");
		Thread.sleep(500);
		String password = "123";
		driver.findElement(By.xpath("//a[@class='btn btn-sm btn-primary']")).click();

		boolean alertShow = false;
		while (alertShow == false) {
			Thread.sleep(500);
			WebElement nameInput = driver.findElement(By.name("name"));
			WebElement emailInput = driver.findElement(By.name("email"));
			WebElement passwordInput = driver.findElement(By.name("password"));
			nameInput.clear(); //Kosongkan kolom input
			emailInput.clear(); //Kosongkan kolom input
			passwordInput.clear(); //Kosongkan kolom input
			if (driver.findElements(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show']"))
					.size() != 0) {
				password = "12345";
				alertShow = true; // Ketika ada error password maka akan mengubah karakter yang diinputkan
			}

			nameInput.sendKeys("TestUser");

			emailInput.sendKeys("testemail@mail.com");

			passwordInput.sendKeys(password);

			WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
			button.click();
			

		}
	}
}

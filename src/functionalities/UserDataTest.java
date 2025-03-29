package functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class UserDataTest {
	@Test(priority = 3, dependsOnGroups = { "login_group" })
	public void UserDataTestPage() throws InterruptedException {
		Reporter.log("user data");
		WebDriver driver = Setup.getDriver();
		driver.get(Setup.getWebUrl() + "admin/user");
		String password = "123";
		driver.findElement(By.xpath("//a[@class='btn btn-sm btn-primary']")).click();

		boolean alertShow = false;
		while (alertShow == false) {
			driver.findElement(By.name("name")).clear(); //Kosongkan kolom input
			driver.findElement(By.name("email")).clear(); //Kosongkan kolom input
			driver.findElement(By.name("password")).clear(); //Kosongkan kolom input
			if (driver.findElements(By.xpath("//div[@class='alert alert-danger alert-dismissible fade show']"))
					.size() != 0) {
				password = "12345";
				alertShow = true; // Ketika ada error password maka akan mengubah karakter yang diinputkan
			}

			driver.findElement(By.name("name")).sendKeys("TestUser");

			driver.findElement(By.name("email")).sendKeys("testemail@mail.com");

			driver.findElement(By.name("password")).sendKeys(password);

			driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			
			

		}
	}
}

package functionalities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class ProfileResetPassword {
	@Test(priority = 105, dependsOnGroups = { "login_group" })
	public void accessResetProfilePage() {
		WebDriver driver = Setup.getDriver();
		Reporter.log("Halaman menampilkan ubah password profil yang sedang login");
		driver.get(Setup.getWebUrl() + "admin/setting/password");
	}
	
	@Test(priority = 106, dependsOnGroups = { "login_group" })
	public void resetPasswordWithEmptyInput() {
		WebDriver driver = Setup.getDriver();
		Reporter.log("Tampilkan pesan peringatan ketika input kosong");
		driver.findElement(By.name("current_password")).sendKeys("");
		driver.findElement(By.name("new_password")).sendKeys("");
		driver.findElement(By.name("new_confirm_password")).sendKeys("");
		driver.findElement(By.cssSelector("#layoutSidenav_content > main > div > div:nth-child(4) > div > div > div.card-body > form > button")).click();
	
	}
	
	@Test(priority = 107, dependsOnGroups = { "login_group" })
	public void resetPasswordWithInvalidInput() {
		WebDriver driver = Setup.getDriver();
		String passwordLama = "123456";
		String passwordBaru = "admin1234";
		Reporter.log("Tampilkan pesan error ketika input tidak valid (cth. password lama tidak sama)");
		driver.findElement(By.name("current_password")).sendKeys(passwordLama);
		driver.findElement(By.name("new_password")).sendKeys(passwordBaru);
		driver.findElement(By.name("new_confirm_password")).sendKeys(passwordBaru);
		driver.findElement(By.cssSelector("#layoutSidenav_content > main > div > div:nth-child(4) > div > div > div.card-body > form > button")).click();
		WebElement alert = driver.findElement(By.cssSelector("#layoutSidenav_content > main > div > div:nth-child(3) > div > div"));
		assertTrue(alert.isDisplayed());
	}
	
	@Test(priority = 108, dependsOnGroups = { "login_group" })
	public void resetPasswordWithValidInput() throws InterruptedException {
		WebDriver driver = Setup.getDriver();
		resetForm();
		Thread.sleep(1500);
		String passwordLama = "admin123";
		String passwordBaru = "admin123";
		Reporter.log("User bisa melakukan ubah password(dengan mengisi data password lama,password baru dan konfirmasi password dengan valid) ");
		driver.findElement(By.name("current_password")).sendKeys(passwordLama);
		driver.findElement(By.name("new_password")).sendKeys(passwordBaru);
		driver.findElement(By.name("new_confirm_password")).sendKeys(passwordBaru);
		driver.findElement(By.cssSelector("#layoutSidenav_content > main > div > div:nth-child(4) > div > div > div.card-body > form > button")).click();
		
	}
	
	
	protected void resetForm() {
		WebDriver driver = Setup.getDriver();
		driver.findElement(By.name("current_password")).clear();
		driver.findElement(By.name("new_password")).clear();
		driver.findElement(By.name("new_confirm_password")).clear();
	}
	
	
}

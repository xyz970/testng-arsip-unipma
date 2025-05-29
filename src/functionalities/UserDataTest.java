package functionalities;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class UserDataTest {
	@Test(priority = 70, dependsOnGroups = { "login_group" })
	public void accessUserDataPage() throws InterruptedException{
		WebDriver driver = Setup.getDriver();
		Reporter.log("Halaman Data Pengguna dapat diakses dengan baik dan menampilkan table yang bisa di sortir");
		driver.get(Setup.getWebUrl() + "admin/user");
		driver.findElement(By.cssSelector("#crudTable > thead > tr > th:nth-child(2)")).click();
		
	}
	@Test(priority = 71, dependsOnGroups = { "login_group" })
	public void searchUserData() throws InterruptedException{
		WebDriver driver = Setup.getDriver();
		String query = "Test"; // Ganti variabel sesuai dengan nama/email yang dicari
		Reporter.log("Pencarian pengguna berdasarkan nama/email");
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("#crudTable_filter > label > input")).sendKeys(query);
		Thread.sleep(3000);
		
	}
	
	@Test(priority = 72, dependsOnGroups = { "login_group" })
	public void insertPageWithEmptyInput() throws InterruptedException{
		WebDriver driver = Setup.getDriver();
		Reporter.log("Fitur tambah pengguna bisa diakses dan tampilkan pesan peringatan ketika input kosong");
		driver.findElement(By.xpath("//a[@class='btn btn-sm btn-primary']")).click();
		Thread.sleep(1500);
		WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		button.click();
		assertTrue(driver.getCurrentUrl().replaceAll("(?)https", "http").equals(Setup.getWebUrl()+"admin/user/create"));
	}
	
	@Test(priority = 73, dependsOnGroups = { "login_group" })
	public void insertUserDataWithFalseInput() throws InterruptedException{
		Thread.sleep(500);
		Reporter.log("Tampilkan pesan gagal ketika input tidak valid saat tambah data");
		WebDriver driver = Setup.getDriver();
		WebElement nameInput = driver.findElement(By.name("name"));
		WebElement emailInput = driver.findElement(By.name("email"));
		WebElement passwordInput = driver.findElement(By.name("password"));
		nameInput.sendKeys("Test#$%!@$#!341");
		emailInput.sendKeys("testemail");
		passwordInput.sendKeys("123");
		WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		button.click();
		assertTrue(!driver.getCurrentUrl().replaceAll("(?)https", "http").equals(Setup.getWebUrl()+"admin/user/create"));
	}
	
	@Test(priority = 74, dependsOnGroups = { "login_group" })
	public void UserDataTestPage() throws InterruptedException {
		Reporter.log("Arahkan user ke data pengguna dan menampilkan pesan success ketika input valid");
		WebDriver driver = Setup.getDriver();
		Random r = new Random();
		Thread.sleep(500);
		WebElement nameInput = driver.findElement(By.name("name"));
		WebElement emailInput = driver.findElement(By.name("email"));
		WebElement passwordInput = driver.findElement(By.name("password"));
		nameInput.clear();
		emailInput.clear();
		passwordInput.clear();
		Thread.sleep(500);
		
		nameInput.sendKeys("Test Email");
		emailInput.sendKeys("testemail"+r.nextInt(999)+"@mail.com");
		passwordInput.sendKeys("123456");
		WebElement button = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		button.click();
	}
	
	@Test(priority = 75, dependsOnGroups = { "login_group" })
	public void userDataBtnNext() throws InterruptedException {
		Reporter.log("Fungsi \"Next\" tabel daftar pengguna pada halaman Data Pengguna dapat berfungsi dengan baik");
		WebDriver driver = Setup.getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1500);
		WebElement nextBtn = driver.findElement(By.cssSelector("#crudTable_next > a"));
		Thread.sleep(1500);
		js.executeScript("arguments[0].scrollIntoView();", nextBtn);
		Thread.sleep(1500);
		nextBtn.click();
	}
}

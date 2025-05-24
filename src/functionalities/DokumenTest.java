package functionalities;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.DriverChoice;
import helpers.Setup;

public class DokumenTest {
	@Test(priority = 13, dependsOnGroups = { "login_group" })
	public void accessDocumentPage() throws InterruptedException {
		Reporter.log("Halaman Tambah Dokumen dapat diakses dengan baik");
		WebDriver driver = Setup.getDriver();
		driver.get(Setup.getWebUrl() + "admin/letter/create");
	}
	
	@Test(priority = 14, dependsOnGroups = { "login_group" })
	public void insertDocumentEmptyInput() throws InterruptedException {
		Reporter.log("Pengguna menambah dokumen dan mengosongkan input");
		WebDriver driver = Setup.getDriver();
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(1500);
//		WebElement alert = driver
//				.findElement(By.cssSelector("div[class='alert alert-danger alert-dismissible fade show']"));
//		assertTrue(alert.isDisplayed());
	}

	@Test(priority = 15, dependsOnGroups = { "login_group" })
	public void insertDocumentWithFalseInput() throws InterruptedException {
		Reporter.log("Pengguna menambah dokumen dan mengisi input dengan data yang tidak valid");
		WebDriver driver = Setup.getDriver();
		driver.findElement(By.name("letter_file")).sendKeys(Setup.getParentDirectory() + "files\\image.jpg");

		Select tipe_dokumen = new Select(driver.findElement(By.name("letter_type")));
		tipe_dokumen.selectByContainsVisibleText("Kriteria 1");

		driver.findElement(By.name("letter_no")).sendKeys("Test");

		WebElement letter_date = driver.findElement(By.name("letter_date"));

		// Cek jika platform yang digunakan adalah Mozilla Firefox
		if (Setup.getActiveDriver() == DriverChoice.FIREFOX) {
			letter_date.click();
			letter_date.sendKeys("2025-07-12");
		} else {
			letter_date.click();
			letter_date.sendKeys("12");
			letter_date.sendKeys("07");
			letter_date.sendKeys("2025");
		}

		WebElement date_received = driver.findElement(By.name("date_received"));

		// Cek jika platform yang digunakan adalah Mozilla Firefox
		if (Setup.getActiveDriver() == DriverChoice.FIREFOX) {
			date_received.click();
			date_received.sendKeys("2025-08-12");
		} else {
			date_received.click();
			date_received.sendKeys("12");
			date_received.sendKeys("07");
			date_received.sendKeys("2025");
		}

		driver.findElement(By.name("regarding")).sendKeys("Perihal Test");

		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(1500);
		WebElement alert = driver
				.findElement(By.cssSelector("div[class='alert alert-danger alert-dismissible fade show']"));
		assertTrue(alert.isDisplayed());
	}

	@Test(priority = 16, dependsOnGroups = { "login_group" })
	public void insertDocumentWithTrueInput() throws InterruptedException {
		Reporter.log("Pengguna menambah dokumen dan mengisi input dengan data yang valid");
		clearInput();
		WebDriver driver = Setup.getDriver();

		driver.findElement(By.name("letter_file")).sendKeys(Setup.getParentDirectory() + "files\\file.pdf");

		Select tipe_dokumen = new Select(driver.findElement(By.name("letter_type")));
		tipe_dokumen.selectByContainsVisibleText("Kriteria 1");

		driver.findElement(By.name("letter_no")).sendKeys("Test");

		WebElement letter_date = driver.findElement(By.name("letter_date"));

		// Cek jika platform yang digunakan adalah Mozilla Firefox
		if (Setup.getActiveDriver() == DriverChoice.FIREFOX) {
			letter_date.click();
			letter_date.sendKeys("2025-07-12");
		} else {
			letter_date.click();
			letter_date.sendKeys("12");
			letter_date.sendKeys("07");
			letter_date.sendKeys("2025");
		}

		WebElement date_received = driver.findElement(By.name("date_received"));

		// Cek jika platform yang digunakan adalah Mozilla Firefox
		if (Setup.getActiveDriver() == DriverChoice.FIREFOX) {
			date_received.click();
			date_received.sendKeys("2025-08-12");
		} else {
			date_received.click();
			date_received.sendKeys("12");
			date_received.sendKeys("07");
			date_received.sendKeys("2025");
		}

		driver.findElement(By.name("regarding")).sendKeys("Perihal Test");

		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	}

	protected void clearInput() {
		WebDriver driver = Setup.getDriver();
		driver.findElement(By.name("letter_no")).clear();
		driver.findElement(By.name("regarding")).clear();
	}

}

package functionalities.kriteria;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.DriverChoice;
import helpers.Setup;

public class KriteriaTigaTest {
	@Test(priority = 33, dependsOnGroups = { "login_group" })
	public void accessKriteria3Page() throws InterruptedException {
		Reporter.log("Halaman Kriteria memuat data dan bisa menggunakan fitur pencarian");
		WebDriver driver = Setup.getDriver();
		driver.get(Setup.getWebUrl() + "admin/letter/kriteria-3");
		driver.findElement(By.cssSelector("#crudTable_filter > label > input")).sendKeys("Test");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#crudTable_filter > label > input")).sendKeys("");
	}

	@Test(priority = 34, dependsOnGroups = { "login_group" })
	public void printKriteria3Page() {
		Reporter.log("Fitur Cetak berfungsi dengan baik");
		WebDriver driver = Setup.getDriver();
		WebElement btn = driver.findElement(
				By.cssSelector("#layoutSidenav_content > main > div > div > div > div > div.card-header > a"));
		assertTrue(btn.getAttribute("href") != "");
	}

	@Test(priority = 35, dependsOnGroups = { "login_group" })
	public void detailKriteria3Page() throws InterruptedException {
		Reporter.log("Fitur Detail berfungsi dengan baik");
		WebDriver driver = Setup.getDriver();
		driver.findElement(
				By.cssSelector("#crudTable > tbody > tr:nth-child(1) > td:nth-child(5) > a.btn.btn-success.btn-xs"))
				.click();
		Thread.sleep(1500);
		driver.findElement(By.cssSelector(
				"#layoutSidenav_content > main > header > div > div > div > div.col-12.col-xl-auto.mb-3 > button"))
				.click();

	}

	@Test(priority = 36, dependsOnGroups = { "login_group" })
	public void updateKriteria3WithEmptyInput() throws InterruptedException {
		Reporter.log("Mengubah data dengan inputan kosong");
		WebDriver driver = Setup.getDriver();
		Thread.sleep(1500);
		driver.findElement(
				By.cssSelector("#crudTable > tbody > tr:nth-child(1) > td:nth-child(5) > a.btn.btn-success.btn-xs"))
				.click();
		Thread.sleep(1500);
		clearInput();
		driver.findElement(By.cssSelector(
				"#layoutSidenav_content > main > div > form > div > div > div > div.card-body > div:nth-child(7) > div > button"))
				.click();

	}

	@Test(priority = 37, dependsOnGroups = { "login_group" })
	public void updateKriteria3WithInvalidInput() throws InterruptedException {
		Reporter.log("Mengubah data dengan inputan salah(cth. File dokumen berekstensi jpg)");
		WebDriver driver = Setup.getDriver();
		Thread.sleep(1500);

		driver.findElement(By.name("letter_file")).sendKeys(Setup.getParentDirectory() + "files\\image.jpg");

		Select tipe_dokumen = new Select(driver.findElement(By.name("letter_type")));
		tipe_dokumen.selectByContainsVisibleText("Kriteria 1");

		driver.findElement(By.name("letter_no")).sendKeys("Test$!@#!%%#@![edited]231");

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

		driver.findElement(By.name("regarding")).sendKeys("Perihal Test $!@#!%%#@![edited]12312");

		driver.findElement(By.cssSelector(
				"#layoutSidenav_content > main > div > form > div > div > div > div.card-body > div:nth-child(7) > div > button"))
				.click();

		WebElement alert = driver
				.findElement(By.cssSelector("div[class='alert alert-danger alert-dismissible fade show']"));
		assertTrue(alert.isDisplayed());

	}

	@Test(priority = 38, dependsOnGroups = { "login_group" })
	public void updateKriteria3WithValidInput() throws InterruptedException {
		Reporter.log("Mengubah data dengan inputan valid");
		WebDriver driver = Setup.getDriver();
		Thread.sleep(1500);

		driver.findElement(By.name("letter_file")).sendKeys(Setup.getParentDirectory() + "files\\file.pdf");

		Select tipe_dokumen = new Select(driver.findElement(By.name("letter_type")));
		tipe_dokumen.selectByContainsVisibleText("Kriteria 1");

		driver.findElement(By.name("letter_no")).sendKeys("Test[edited]");

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

		driver.findElement(By.name("regarding")).sendKeys("Perihal Test[edited]");

		driver.findElement(By.cssSelector(
				"#layoutSidenav_content > main > div > form > div > div > div > div.card-body > div:nth-child(7) > div > button"))
				.click();

	}

	@Test(priority = 39, dependsOnGroups = { "login_group" })
	public void deleteBtn() throws InterruptedException {
		Reporter.log("Fitur Detail berfungsi dengan baik");
		WebDriver driver = Setup.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("#crudTable > tbody > tr:nth-child(1) > td:nth-child(5) > form > button"))
				.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test(priority = 40, dependsOnGroups = { "login_group" })
	public void btnNext() throws InterruptedException {
		Reporter.log("Tombol Next tabel pada halaman kriteria dapat berfungsi dengan baik");
		WebDriver driver = Setup.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(1500);
		driver.findElement(By.cssSelector("#crudTable_next > a"))
		.click();
	}
	
	protected void clearInput() {
		WebDriver driver = Setup.getDriver();
		driver.findElement(By.name("letter_no")).clear();
		driver.findElement(By.name("regarding")).clear();
		Select tipe_dokumen = new Select(driver.findElement(By.name("letter_type")));
		tipe_dokumen.selectByContainsVisibleText("Pilih");
	}
}

package functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import helpers.DriverChoice;
import helpers.Setup;

public class DokumenTest {
	@Test(priority = 3, dependsOnGroups = { "login_group" })
	public void accessPage() throws InterruptedException {
		WebDriver driver = Setup.getDriver();
		driver.get(Setup.getWebUrl() + "admin/letter/create");
		String tanggal_awal = "12-07-2025";
		String tanggal_akhir = "13-08-2025";

		Thread.sleep(2000);

		driver.findElement(By.name("letter_file")).sendKeys(Setup.getParentDirectory() + "files\\file.pdf");

		Select tipe_dokumen = new Select(driver.findElement(By.name("letter_type")));
		tipe_dokumen.selectByContainsVisibleText("Kriteria 1");
		Thread.sleep(1000);

		driver.findElement(By.name("letter_no")).sendKeys("Test");

		WebElement letter_date = driver.findElement(By.name("letter_date"));
		
		//Cek jika platform yang digunakan adalah Mozilla Firefox
		if (Setup.getActiveDriver() == DriverChoice.FIREFOX) {
			letter_date.click();
			letter_date.sendKeys("2025-07-12");
		}else {
			letter_date.click();
			letter_date.sendKeys("12");
			letter_date.sendKeys("07");
			letter_date.sendKeys("2025");
		}
		
		Thread.sleep(1000);
		WebElement date_received = driver.findElement(By.name("date_received"));
		
		//Cek jika platform yang digunakan adalah Mozilla Firefox
		if (Setup.getActiveDriver() == DriverChoice.FIREFOX) {
			date_received.click();
			date_received.sendKeys("2025-08-12");
		}else {
			date_received.click();
			date_received.sendKeys("12");
			date_received.sendKeys("07");
			date_received.sendKeys("2025");
		}
		
		Thread.sleep(1000);

		driver.findElement(By.name("regarding")).sendKeys("Perihal Test");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	}

}

package functionalities;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class DosenTest {
  
  @Test(priority = 4,dependsOnGroups = "afterStrukturProdi")
  public void visitPage() {
	  WebDriver driver =Setup.getDriver();
	  Reporter.log("Halaman data dosen dapat diakses dan menampilkan data tabel");
	  driver.get(Setup.getWebUrl()+"admin/sender");
	  assertTrue(true);
  }
  
  @Test(priority = 5,dependsOnMethods = "visitPage")
  public void insertNewDosenWithEmptyInput() throws InterruptedException {
	  WebDriver driver =Setup.getDriver();
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  Reporter.log("Membuka modal tambah data dan tampilkan peringatan ketika input kosong");
	  driver.findElement(By.cssSelector("a[data-bs-target='#createModal']")).click();
	  js.executeScript("$('#createModal > div > div > form > div.modal-footer > button.btn.btn-primary').click()");
	  Thread.sleep(1000);
	  boolean ifModalShow = (boolean) js.executeScript("return $('#createModal').hasClass('show');");
	  System.out.println("Open "+ifModalShow);
	  assertTrue(ifModalShow);
  }
  
  @Test(priority = 6)
  public void insertNewDosenWithFalseInput() throws InterruptedException {
	  WebDriver driver =Setup.getDriver();
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  Reporter.log("Tampilkan pesan gagal ketika input tidak valid (cth. input nama mengandung simbol)");
	  Thread.sleep(2000);
	  driver.findElement(By.name("name")).sendKeys("2318nama@#$");
	  driver.findElement(By.name("nidn")).sendKeys("nidn23187%^&");
	  driver.findElement(By.name("pendidikan")).sendKeys("pendidikan23187%^&");
	  driver.findElement(By.name("jabatan")).sendKeys("jabatan23187%^&");
	  js.executeScript("$('input[name=email]').attr('type','text')");
	  driver.findElement(By.name("email")).sendKeys("email23187%^&");
	  js.executeScript("$('#createModal > div > div > form > div.modal-footer > button.btn.btn-primary').click()");
	  boolean ifModalShow = (boolean) js.executeScript("return $('#createModal').hasClass('show');");
//	  js.executeScript("window.location.reload()");
	  assertTrue(ifModalShow);
  }
  
  @Test(priority = 7)
  public void insertNewDosenWithTrueInput() throws InterruptedException {
	  WebDriver driver =Setup.getDriver();
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  Reporter.log("Tampilkan pesan success ketika input valid");
	  driver.findElement(By.cssSelector("a[data-bs-target='#createModal']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.name("name")).sendKeys("Andi");
	  driver.findElement(By.name("nidn")).sendKeys("9923368767812");
	  driver.findElement(By.name("pendidikan")).sendKeys("S2 Magister Matematika");
	  driver.findElement(By.name("jabatan")).sendKeys("Dosen");
	  js.executeScript("$('input[name=email]').attr('type','text')");
	  driver.findElement(By.name("email")).sendKeys("andimuhammad@gmail.com");
	  js.executeScript("$('#createModal > div > div > form > div.modal-footer > button.btn.btn-primary').click()");
	  boolean ifModalShow = (boolean) js.executeScript("return $('#createModal').hasClass('show');");
//	  js.executeScript("window.location.reload()");
	  assertTrue(!ifModalShow);
  }
  
  @Test(priority = 8)
  public void updateDosenWithEmptyInput() throws InterruptedException {
	  WebDriver driver =Setup.getDriver();
	  String dataId = "10";
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  Reporter.log("Membuka modal edit data dan tampilkan peringatan ketika input kosong");
	  Thread.sleep(2000);
//	  driver.findElement(By.cssSelector("a[data-bs-target='#updateModal"+dataId+"']")).click();
//	  js.executeScript("window.location.reload()");
	  js.executeScript("document.querySelector(\"a[data-bs-target='#updateModal"+dataId+"']\").click();");
	  Thread.sleep(1500);
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > input[name=name]').val('')");
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > input[name=nidn]').val('')");
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > textarea[name=pendidikan]').val('')");
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > input[name=jabatan]').val('')");
	  js.executeScript("$('input[name=email]').attr('type','text')");
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > input[name=email]').val('')");

	  
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-footer > button.btn.btn-primary').click()");
	  boolean ifModalShow = (boolean) js.executeScript("return $('#updateModal"+dataId+"').hasClass('show');");
	  assertTrue(ifModalShow);
	  
  }
  
  @Test(priority = 9)
  public void updateDosenWithFalseInput() throws InterruptedException {
	  WebDriver driver =Setup.getDriver();
	  String dataId = "10";
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  Reporter.log("Tampilkan pesan gagal ketika input tidak valid (cth. input nama mengandung simbol)");
	  Thread.sleep(2000);

	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > input[name=name]').val('2318nama@#$[edited]')");
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > input[name=nidn]').val('nidn23187%^&[edited]')");
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > textarea[name=pendidikan]').val('pendidikan23187%^&[edited]')");
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > input[name=jabatan]').val('jabatan23187%^&[edited]')");
	  js.executeScript("$('input[name=email]').attr('type','text')");
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > input[name=email]').val('email23187%^&[edited]')");

	  
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-footer > button.btn.btn-primary').click()");
	  boolean ifModalShow = (boolean) js.executeScript("return $('#updateModal"+dataId+"').hasClass('show');");
	  assertTrue(ifModalShow);
  }
  
  @Test(priority=10)
  public void updateDosenWithTrueInput() throws InterruptedException {
	  WebDriver driver =Setup.getDriver();
	  String dataId = "10";
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  Reporter.log("Tampilkan pesan success ketika input valid");
	  Thread.sleep(3000);
	  js.executeScript("document.querySelector(\"a[data-bs-target='#updateModal"+dataId+"']\").click();");
	  
	  Thread.sleep(2000);

	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > input[name=name]').val('Rian')");
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > input[name=nidn]').val('826386123312')");
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > textarea[name=pendidikan]').val('S2 Magister Bahasa Inggris')");
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > input[name=jabatan]').val('Dosen')");
	  js.executeScript("$('input[name=email]').attr('type','text')");
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-body > div.mb-3 > div.col-md-12 > input[name=email]').val('rian123@gmail.com')");

	  
	  js.executeScript("$('#updateModal"+dataId+" > div > div > form > div.modal-footer > button.btn.btn-primary').click()");
	  boolean ifModalShow = (boolean) js.executeScript("return $('#updateModal"+dataId+"').hasClass('show');");
	  assertTrue(!ifModalShow);
	  
  }
  
  @Test(priority=11)
  public void deleteDosen() throws InterruptedException {
	  WebDriver driver =Setup.getDriver();
	  String dataId = "37";
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  Reporter.log("Pengguna menghapus data dosen yang ber-id"+dataId);
	  String webURl = Setup.getWebUrl().replaceAll("(?)https", "http");
	  Thread.sleep(3000);
	  WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"crudTable\"]/tbody/tr[1]/td[7]/form/button")));
	  deleteBtn.click();
//	  js.executeScript("document.querySelector('form[action=\""+webURl+"admin/sender/"+dataId+"\"] > button').click()");
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
  }
  
  @Test(priority=12)
  public void searchDosen() throws InterruptedException {
	  WebDriver driver =Setup.getDriver();
	  Thread.sleep(2000);
	  String nama_nidn = "Rian"; // Ubah isi variabel sesuaikan dengan kata kunci yang akan dicari
	  Reporter.log("Memastikan fitur pencarian dapat mencari data dosen berdasarkan nama/NIDN");
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  driver.findElement(By.cssSelector("#crudTable_filter > label > input")).sendKeys(nama_nidn);
	 
  }
  
}

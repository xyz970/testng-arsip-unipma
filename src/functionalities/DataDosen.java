package functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import helpers.Setup;

public class DataDosen {
  
  @Test
  public void accessPage() throws InterruptedException {
	  WebDriver driver =  Setup.getDriver();
	  String name = "Test Dosen";
	  String nidn = "123";
	  String pendidikan = "pendidikan";
	  String jabatan = "jabatan";
	  String email = "email";
	  
	  
	  driver.get(Setup.getWebUrl()+"admin/sender");
	  Thread.sleep(1000);
	  
	  //tekan tombol tambah
	  driver.findElement(By.cssSelector("a[class='btn btn-sm btn-primary'")).click();
	  Thread.sleep(400);
	  
	  driver.findElement(By.name("name")).sendKeys(name);
	  Thread.sleep(200);

	  driver.findElement(By.name("nidn")).sendKeys(nidn);
	  Thread.sleep(200);

	  driver.findElement(By.name("pendidikan")).sendKeys(pendidikan);
	  Thread.sleep(200);

	  driver.findElement(By.name("jabatan")).sendKeys(jabatan);
	  Thread.sleep(200);

	  driver.findElement(By.name("email")).sendKeys(email);
	  Thread.sleep(200);

	  driver.findElement(By.xpath("//button[@class=''btn btn-primary")).click();
	  Thread.sleep(200);
	  
	  Reporter.log("Tambah Data Dosen");
	  
	  
	  
	  
	  
	  
	  
  }
}

package Java;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.bouncycastle.asn1.dvcs.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.github.dockerjava.api.model.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;

public class Datadriven {
	String username,password,message;
	void call() throws IOException {
		WebDriver driver = new ChromeDriver();
		String uname,pass;
		message="Data passed successfully";
		String path = System.getProperty("user.dir") + "/Excel/Login.xls";
		FileInputStream fin=new FileInputStream(path);
		HSSFWorkbook wb = new HSSFWorkbook(fin);
		HSSFSheet sheet = wb.getSheetAt(0);
		System.out.println(sheet.getLastRowNum());
		driver.get("https://opensource-demo.orangehrmlive.com/");
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			uname=sheet.getRow(i).getCell(0).getStringCellValue();
			driver.findElement(By.name("txtUsername")).sendKeys(uname);
			pass=sheet.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.id("txtPassword")).sendKeys(pass);
			FileOutputStream Fout= new FileOutputStream(path);
		
			sheet.getRow(i).createCell(2).setCellValue(message);
			wb.write(Fout);
			Fout.close();
			driver.findElement(By.id("btnLogin")).click();
		}
	}

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		Datadriven D = new Datadriven();
		D.call();
	}
}


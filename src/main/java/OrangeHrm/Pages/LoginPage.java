package OrangeHrm.Pages;

import com.PageFactory.ObjFactory;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;//commenting
import java.time.Duration;

import static Base.TestBase.driver;

public class LoginPage extends ObjFactory {
    @FindBy(id="txtUsername")
    WebElement username;

    @FindBy(id="txtPassword")
    WebElement password;

    @FindBy(id="btnLogin")
    WebElement loginbutton;

    @FindBy(id="forgotPasswordLink")
    WebElement forgetpassword;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    public String verify_title(){
        return  driver.getTitle();
    }
    public void login() throws IOException, InterruptedException {
        String path = System.getProperty("user.dir") + "//src//main//resources//TestData.xls";
        FileInputStream filo = new FileInputStream(path);

        HSSFWorkbook wb = new HSSFWorkbook(filo);
        HSSFSheet sheet = wb.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            String uname = sheet.getRow(i).getCell(0).getStringCellValue();
            username.sendKeys(uname);
            Thread.sleep(5000);
            String passw = sheet.getRow(i).getCell(1).getStringCellValue();
            password.sendKeys(passw);
            Thread.sleep(3000);
            loginbutton.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        }
    }
        public void forget_password() {
            forgetpassword.click();
            driver.navigate().back();
        }
    }

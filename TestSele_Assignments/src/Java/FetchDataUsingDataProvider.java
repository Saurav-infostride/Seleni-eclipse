package Java;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class FetchDataUsingDataProvider {
    static String path;
    static WebDriver driver;
    FileInputStream fis;
    HSSFWorkbook wb;
    HSSFSheet sheet;

    @DataProvider(name="Login_Details")
    public Object[][] Data() throws IOException {
        path = System.getProperty("user.dir")+"//TestData.xls";
        System.out.println(path);
        fis = new FileInputStream(path);	//Give path in FileInputstream class from where you want to run
        wb = new HSSFWorkbook(fis);		 //Move to workbook
        sheet =wb.getSheetAt(0);		//To move specific sheet
        int num = sheet.getLastRowNum();
        Object[][] arr= new Object[num][2];
        int ci=0;
        for(int i=1;i<=num;i++,ci++) {
            String uname=sheet.getRow(i).getCell(0).getStringCellValue();
            String pass=sheet.getRow(i).getCell(1).getStringCellValue();

            arr[ci][0]=uname;   //to set username in an arr
            arr[ci][1]=pass;	//to set password in an arr
        }

        return arr;
    }

    @Test(dataProvider = "Login_Details")
    public void signIn(String uname, String pass) {
        System.out.println(uname+"\t"+pass);
    }
}


package Base;

import com.PageFactory.ObjFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {
        public static WebDriver driver;
        public static Properties prop;
        protected static ObjFactory obj;
        @BeforeSuite
        public void launch_browser() throws Exception {
            obj = new ObjFactory();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            //Environment specific properties file loading
            InputStream ip = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\OrangeHrm\\Config\\Configure.properties");

            prop  = new Properties();
            prop.load(ip);
        }
        @BeforeMethod()
        public void loadBaseUrl(Method method) {
            obj = new ObjFactory();
            driver.get(prop .getProperty("url"));
        }
    @AfterMethod
    public void screenshotAndDeleteCookies(ITestResult testResult) throws IOException {
        obj = new ObjFactory();
        //Taking screenshot in case of failure
        if(testResult.getStatus() == ITestResult.FAILURE){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("errorScreenshots\\" + testResult.getName() + "-"
                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
        }
        //Deleting cookies
        driver.manage().deleteAllCookies();
    }
        @AfterSuite
        public void suiteTearDown() {
            driver.quit();
        }
}

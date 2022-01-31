package demo.test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestingTestNg {
public String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

WebDriver driver = null ;
@BeforeTest
public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(baseUrl);
}
@Test
public void verifyHomepageTitle() {
String expectedTitle = "OrangeHRM";
String actualTitle = driver.getTitle();
Assert.assertEquals(actualTitle, expectedTitle);
}
@AfterTest
public void terminateBrowser(){
	driver.close();
	driver.quit();
	System.out.println("okay");
}
}

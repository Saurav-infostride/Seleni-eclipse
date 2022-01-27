package demo.test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
public class Test {
	String firstName = RandomStringUtils.randomAlphabetic(8);
	String lastName = RandomStringUtils.randomAlphabetic(8);
	String address = RandomStringUtils.randomAlphanumeric(20);
	String email = RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
	String phone = RandomStringUtils.randomNumeric(8);
	String languages = ("English"+"Hindi");
	
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://demo.automationtesting.in/Register.html");
        driver.findElement(By.xpath("//input[@value='Male']")).click();
        driver.findElement(By.xpath("//input[@value='Movies']")).click();
       // Select skills = (Select) driver.findElements(By.id("Skills"));
        //skills.selectByValue("Java");
        WebElement Skills;
        Select s=new Select(driver.findElement(By.id("Skills")));
        s.selectByValue("Java");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 50)", "");


        Thread.sleep(2000);

        //driver.quit();
    }
}


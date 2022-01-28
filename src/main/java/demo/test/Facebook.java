package demo.test;

import java.time.Duration;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String firstName = RandomStringUtils.randomAlphabetic(8);
        String mobileNo = RandomStringUtils.randomNumeric(10);
        String userPassword = RandomStringUtils.randomAlphanumeric(8);

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Create New Account")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        //second question
        driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']/parent::div[@class='_1lch']"
        		+ "/preceding-sibling::div[@id='fullname_field']//child::input[@name='firstname']")).sendKeys(firstName);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        //fourth question
        driver.findElement(By.xpath("//input[@name='reg_passwd__']//preceding::input[@name='reg_email__']"))
        .sendKeys(mobileNo);
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        //third question
        driver.findElement(By.xpath("//input[@name='reg_email__']//following::input[@name='reg_passwd__']"))
        .sendKeys(userPassword);
        //first question
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.findElement(By.xpath("//div[@class='_1lch']//button[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.quit();
	}

}

package demo.test;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String firstName = RandomStringUtils.randomAlphabetic(8);

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']/parent::div[@class='_1lch']"
        		+ "/preceding-sibling::div[@id='fullname_field']//child::input[@name='firstname']")).sendKeys(firstName);

        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("8788783939");
        
        driver.findElement(By.xpath("//div[@class='_1lch']//button[@type='submit']")).click();
        Thread.sleep(5000);
       
	}

}

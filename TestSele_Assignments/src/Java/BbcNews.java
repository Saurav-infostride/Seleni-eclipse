package Java;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BbcNews {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.bbc.com/");
        List<WebElement> linktext = driver.findElements(By.tagName("a"));
        System.out.println(linktext.size());
        for(int i = 0;i<linktext.size();i++){
           String linktxt = linktext.get(i).getText();

           System.out.println(linktxt);
        }
	}
}

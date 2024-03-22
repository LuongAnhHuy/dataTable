package Training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class getOTPGG {
    WebDriver driver;
    String projecPath = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", projecPath + "\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();// Khởi tạo giá trị cho Browser
        driver.manage().window().maximize();

    }

    @Test
    public void  TC_01 () {
        driver.get("https://mail.google.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void TC_02 () {
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("luonganhhuy20@gmail.com");
        driver.findElement(By.xpath("//button[@type='button']//span[text()='Next']")).click();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Huy123456.");
        driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']//following-sibling::span[text()='Next']")).click();

    }

    @AfterClass
    public void afterClass (){

    }
}

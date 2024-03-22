package Training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[] args) {

        WebDriver driver;
        String projecPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projecPath + "\\browserDrivers\\chromedriver.exe");
        //WebDriverManager.chromedriver().setup(); // Gọi phiên bản browser
        driver = new ChromeDriver(); // Khởi tạo giá trị cho Browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();


        //driver.quit();

    }
}

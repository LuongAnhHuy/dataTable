package huyTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class test_01 {
    WebDriver driver;
    String projecPath = System.getProperty("user.dir");
    WebDriverWait explicit;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", projecPath + "\\browserDrivers\\chromedriver.exe");
        //WebDriverManager.chromedriver().setup(); // Gọi phiên bản browser
        driver = new ChromeDriver();// Khởi tạo giá trị cho Browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_Open_Home_Page()  {
        driver.get("https://dev.dlancer.io/");
        driver.findElement(By.xpath("//button[text()='Login']")).click();

    }

    @Test
    public void TC_02() {
        //driver.findElement(By.xpath("//div[@class='nsm7Bb-HzV7m-LgbsSe-bN97Pc-sM5MNb ']")).click();
        driver.findElement(By.xpath("//input[@id='email-address']")).clear();
        driver.findElement(By.xpath("//input[@id='email-address']")).sendKeys("huy.luong@icetea.io");
        //driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d' and text()='Next']")).click();
        explicit = new WebDriverWait(driver, 30);
        explicit.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        explicit.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='flex w-full gap-2 font-medium text-2xl']//input[1]")));
        driver.findElement(By.xpath("//div[@class='flex w-full gap-2 font-medium text-2xl']//input[1]")).sendKeys("1");
        driver.findElement(By.xpath("//div[@class='flex w-full gap-2 font-medium text-2xl']//input[2]")).sendKeys("2");
        driver.findElement(By.xpath("//div[@class='flex w-full gap-2 font-medium text-2xl']//input[3]")).sendKeys("3");
        driver.findElement(By.xpath("//div[@class='flex w-full gap-2 font-medium text-2xl']//input[4]")).sendKeys("4");
        driver.findElement(By.xpath("//div[@class='flex w-full gap-2 font-medium text-2xl']//input[5]")).sendKeys("5");
        driver.findElement(By.xpath("//div[@class='flex w-full gap-2 font-medium text-2xl']//input[6]")).sendKeys("6");
        driver.findElement(By.xpath("//button[@type='button' and text()='Verify']")).click();
        boolean erorrMessage = driver.findElement(By.xpath("//div[@role='status' and text()='Unable to verify email: incorrect code']")).isDisplayed();
        System.out.println("Error message hien thi la: " + erorrMessage);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

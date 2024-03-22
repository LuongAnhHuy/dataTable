package Training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class dataTable_part2 {
    WebDriver driver;
    String projecPath = System.getProperty("user.dir");
    @BeforeMethod
    public void beforeMethod () {
        System.setProperty("webdriver.chrome.driver", projecPath + "\\browserDrivers\\chromedriver.exe");
        
        // Khởi tạo giá trị cho Browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01_get_data () {
        driver.get("https://demo.guru99.com/test/web-table-element.php");
        //driver.get("https://demo.guru99.com/test/write-xpath-table.html");
        WebElement table = driver.findElement(By.xpath("//table[@class='dataTable']//tbody"));
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        for (int row = 0; row < rows_count; row++) {

            List <WebElement> columns_row = rows_table.get(row).findElements(By.tagName("td"));
            int column_count = columns_row.size();
            for (int column = 0; column < column_count; column++) {
                String cell_text = columns_row.get(column).getText();
                System.out.println("Giá trị của dòng: " + row + " Cột: " + column + " là: " + cell_text);
            }
        }
    }

    @AfterMethod
    public void afterMethod () {
        driver.quit();

    }
}

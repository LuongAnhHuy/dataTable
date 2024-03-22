package Training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class dataTable {
    WebDriver driver;
    String projecPath = System.getProperty("user.dir");

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", projecPath + "\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();// Khởi tạo giá trị cho Browser
        driver.manage().window().maximize();

    }

    @Test
    public void Testcase_01_Get_Data_Table() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // Xác định bảng
        WebElement table = driver.findElement(By.xpath("//table[@id='customers']//tbody"));

        // Xác định số dòng trong bảng
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();

        // Sử dụng vòng lặp for cho số dòng trên để lấy ra vị trí số cột của dòng đó, rồi lấy ra giá trị của ô tương ứng với số cột và dòng
        // Đếm số cột
        // sử dụng for cho dòng để đếm cột
        for (int row = 0; row < rows_count; row++) {

            List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName("td"));
            int column_count = columns_row.size();

            // Đã có thông tin dòng, cột => lấy ra đc giá trị của các ô
            // Sử dụng for cho cột
            for (int column = 0; column < column_count; column++) {
                String cell_text = columns_row.get(column).getText();
                System.out.println("Giá trị của dòng: " + row + " Cột: " + column + " là: " + cell_text);
            }
        }
        List <WebElement> tableValue =  table.findElements(By.tagName("td"));
        for (WebElement item : tableValue) {
            if (item.getText().equals("Roland Mendel")) {
                String text = item.getText();
                System.out.println("Gia tri duoc lay: " + text);
            }
        }
    }



    public void Testcase_02() {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        //List <WebElement> table = driver.findElements(By.xpath("//table[@id='customers']//tbody//td"));
        WebElement table = driver.findElement(By.xpath("//table[@id='customers']//tbody"));
        List <WebElement> row = table.findElements(By.tagName("tr"));
        int rowsize = row.size();
        System.out.println(rowsize);
        List <WebElement> column = table.findElements(By.tagName("td"));
        int columnsize = column.size();
        System.out.println(columnsize);
        int total = rowsize + columnsize;
        System.out.println("Tong gia tri: " + total);

        List <WebElement> table1 = table.findElements(By.tagName("td"));
        for (WebElement item : table1) {
            if (item.getText().equals("Roland Mendel")) {
                String text = item.getText();
                System.out.println("Gia tri duoc lay: " + text);
            }
        }

    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}

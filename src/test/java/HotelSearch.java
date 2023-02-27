import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HotelSearch {

    public WebDriver driver;

    public String URL = "http://www.kurs-selenium.pl/demo/";


    @Test
    public void searchHotel() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        WebElement cityName = driver.findElement(By.xpath("//span[@class='select2-chosen' and text()='Search by Hotel or City Name']"));
        cityName.click();
        WebElement cityNameInput = driver.findElement(By.xpath("//div[@id='select2-drop']//input"));
        cityNameInput.sendKeys("Dubai");
        WebElement cityChoose = driver.findElement(By.xpath("//span[@class='select2-match' and text()='Dubai']"));
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(cityChoose));
        cityChoose.click();
    }
}

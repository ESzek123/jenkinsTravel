package strony;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

    public WebDriver driver;

    public void openBrowser(String pageURL) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(pageURL);
    }
}

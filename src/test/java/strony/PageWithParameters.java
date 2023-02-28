package strony;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageWithParameters {

    public WebDriver driver;

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    public WebElement searchByHotelClick;

    @FindBy(xpath = "//div[@id ='select2-drop']//input")
    public WebElement hotelInput;

    @FindBy(xpath = "//span[@class='select2-match' and text()='Dubai']")
    public WebElement chooseCity;

    @FindBy(xpath = "//input[@name='checkin']")
    public WebElement checkInInput;

    @FindBy(xpath = "//input[@name='checkout']")
    public WebElement checkOutInput;



    public PageWithParameters(WebDriver driver) {
        this.driver = driver;
    }


    public void parametersToChooseFrom() {
        searchByHotelClick.click();
        hotelInput.sendKeys("Dubai");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(chooseCity));
        chooseCity.click();
        checkInInput.sendKeys("01/03/2023");
        checkOutInput.sendKeys("04/03/2023");
    }
}

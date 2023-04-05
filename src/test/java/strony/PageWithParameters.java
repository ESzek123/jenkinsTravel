package strony;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumHelperWait;

import java.time.Duration;

public class PageWithParameters {

    public WebDriver driver;

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    public WebElement searchByHotelClick;

    @FindBy(xpath = "//div[@id ='select2-drop']//input")
    public WebElement hotelInput;

    @FindBy(xpath = "//input[@name='checkin']")
    public WebElement checkInInput;

    @FindBy(xpath = "//input[@name='checkout']")
    public WebElement checkOutInput;

    @FindBy(xpath = "//td[@class='day ' and text()='30']")
    public WebElement checkOutCalendar;

    @FindBy(id = "travellersInput")
    public WebElement adultAndChild;

    @FindBy(id = "adultMinusBtn")
    public WebElement removeAdult;

    @FindBy(id = "adultPlusBtn")
    public WebElement addAdult;

    @FindBy(id = "childPlusBtn")
    public WebElement addChild;

    @FindBy(xpath = "//button[@type='submit' and @class='btn btn-lg btn-block btn-primary pfb0 loader']")
    public WebElement searchButton;

    @FindBy(xpath = "/html/body/nav/div/div[2]/ul[2]/ul/li[1]/a")
    public WebElement dropdownNewAccount;

    @FindBy(xpath = "/html/body/nav/div/div[2]/ul[2]/ul/li[1]/ul/li[2]/a")
    public WebElement signUpClick;

    public PageWithParameters(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static final Logger logger = LogManager.getLogger();

    public PageWithParameters setCity(String cityName) {
        logger.info("Setting city " + cityName);
        searchByHotelClick.click();
        hotelInput.sendKeys(cityName);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".select2-result-sub")));
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityName);
        WebElement city = driver.findElement(By.xpath(xpath));
        SeleniumHelperWait.waitForElementToBeClickable(driver, city);
        city.click();
//        WebElement chooseCity = driver.findElement(By.xpath(xpath));
//        SeleniumHelperWait.waitForElementToBeVisible(driver, chooseCity);
//        chooseCity.click();
        logger.info("Setting city done");
        return this;
    }

    public PageWithParameters setDates(String checkin, String checkout) {
        checkInInput.sendKeys(checkin);
        checkOutInput.sendKeys(checkout);
//        checkOutCalendar.stream()
//            .filter(el -> el.isDisplayed())
        //można zapisać w ten sposób .filter(WebElement::isDisplayed)
//                .findFirst()
//                .ifPresent(el -> el.click());
        //można zapisać w ten sposób .ifPresent(WebElement::click)
        return this;
    }

    public PageWithParameters setPeople() {
        adultAndChild.click();
        SeleniumHelperWait.waitForElementToBeVisible(driver, removeAdult);
        removeAdult.click();
        addAdult.click();
        addChild.click();
        return this;
    }

    public PageWithResults performSearch() {
        searchButton.click();
        return new PageWithResults(driver);
    }


    public PageRegister userCreatesNewAccount() {
        SeleniumHelperWait.waitForElementToBeVisible(driver, dropdownNewAccount);
        dropdownNewAccount.click();
        signUpClick.click();
        return new PageRegister(driver) ;
    }
}

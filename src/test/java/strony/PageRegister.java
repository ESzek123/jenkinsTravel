package strony;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PageRegister extends Base{

    @FindBy(xpath = "//input[@name = 'firstname']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@name = 'lastname']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@name = 'phone']")
    public WebElement phoneInput;

    @FindBy(xpath = "//input[@name = 'email']")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@name = 'password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@name = 'confirmpassword']")
    public WebElement confirmPasswordInput;

    @FindBy(xpath = "//div[@class = 'form-group']/button[@type = 'submit']")
    public WebElement submitButton;

    public PageRegister(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public PageRegister userSignUp(String name, String familyName, String phoneNumber, String addressEmail, String password){
        firstNameInput.click();
        firstNameInput.sendKeys(name);
        lastNameInput.click();
        lastNameInput.sendKeys(familyName);
        phoneInput.click();
        phoneInput.sendKeys(phoneNumber);
        emailInput.click();
        emailInput.sendKeys(addressEmail);
        passwordInput.click();
        passwordInput.sendKeys(password);
        confirmPasswordInput.click();
        confirmPasswordInput.sendKeys(password);
        submitButton.click();
        return this;
    }

    public void userSignUpDataTest(PageRegisterData pageRegisterData) {
        firstNameInput.click();
        firstNameInput.sendKeys(pageRegisterData.getName());
        lastNameInput.click();
        lastNameInput.sendKeys(pageRegisterData.getLastName());
        phoneInput.click();
        phoneInput.sendKeys(pageRegisterData.getMobileNumber());
        emailInput.click();
        emailInput.sendKeys(pageRegisterData.getEmail());
        passwordInput.click();
        passwordInput.sendKeys(pageRegisterData.getPassword());
        confirmPasswordInput.click();
        confirmPasswordInput.sendKeys(pageRegisterData.getPassword());
        submitButton.click();

    }
}

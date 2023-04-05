package strony;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class PageWithResults {

    private WebDriver driver;

    @FindBy(xpath = "//h4[contains(@class,'list_title')]//b")
    public List<WebElement> listOfTitle;

    public PageWithResults(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public PageWithResults getTitle() {
        List<String> hotelNames = listOfTitle.stream()
                .map(WebElement::getText).toList();
        System.out.println(hotelNames.size());
        hotelNames.forEach(System.out::println);


        Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");
//        for (WebElement title : listOfTitle) {
//            System.out.println(title.getText());
//        }
//        SoftAssert softAssert = new SoftAssert();
//        softAssert.assertEquals("Jumeirah Beach Hotel", hotelNames.get(0));
//        softAssert.assertEquals("Oasis Beach Tower", hotelNames.get(1));
//        softAssert.assertEquals("Rose Rayhaan Rotana", hotelNames.get(2));
//        softAssert.assertEquals("Hyatt Regency Perth", hotelNames.get(3));
//        softAssert.assertAll();
        return new PageWithResults(driver);
    }

}

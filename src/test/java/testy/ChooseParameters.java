package testy;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import strony.Base;
import strony.PageWithParameters;

public class ChooseParameters extends Base {

    @Test
    public void userChooseParameters() {
        openBrowser("http://www.kurs-selenium.pl/demo/");
        PageWithParameters pageWithParameters = new PageWithParameters(driver);
        PageFactory.initElements(driver, pageWithParameters);
        pageWithParameters.parametersToChooseFrom();
    }
}

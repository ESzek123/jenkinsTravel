package testy;

import org.testng.annotations.Test;
import strony.Base;
import strony.PageRegister;
import strony.PageRegisterData;
import strony.PageWithParameters;

public class RegisterTest extends Base {


    @Test
    public void signUpForm() {
        openBrowser("http://www.kurs-selenium.pl/demo/");
        PageWithParameters pageWithParameters = new PageWithParameters(driver);
        pageWithParameters.userCreatesNewAccount();
        PageRegister pageRegister = new PageRegister(driver);
        pageRegister.userSignUp("Anna", "Nowacka", "432522333", "n.anna@op.pl", "GEVUQYTGUEGI");
    }

    @Test
    public void signUpFormWithDifferentEmail() {
        int randomemail = (int) (Math.random()*1000);
        String email = "tester" + randomemail + "@oop.pl";
        System.out.println(email);
        openBrowser("http://www.kurs-selenium.pl/demo/");
        PageWithParameters pageWithParameters = new PageWithParameters(driver);
        pageWithParameters.userCreatesNewAccount();
        PageRegister pageRegister = new PageRegister(driver);
        pageRegister.userSignUp("Anna", "Nowacka", "432522333", email, "GEVUQYTGUEGI");
    }

    @Test
    public void signUpFormDataTest() {
        openBrowser("http://www.kurs-selenium.pl/demo/");
        PageWithParameters pageWithParameters = new PageWithParameters(driver);
        pageWithParameters.userCreatesNewAccount();
        PageRegisterData pageRegisterData = new PageRegisterData();
        pageRegisterData.setName("Anna");
        pageRegisterData.setLastName("Nowacka");
        pageRegisterData.setMobileNumber("888676744");
        pageRegisterData.setEmail("a.nowacka@op.pl");
        pageRegisterData.setPassword("fewfewef");
        PageRegister pageRegister = new PageRegister(driver);
        pageRegister.userSignUpDataTest(pageRegisterData);
    }
}

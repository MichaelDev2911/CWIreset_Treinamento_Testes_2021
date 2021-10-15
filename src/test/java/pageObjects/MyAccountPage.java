package pageObjects;

import elementMapper.MyAccountPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

import java.util.Random;

public class MyAccountPage extends MyAccountPageElementMapper {
    public MyAccountPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Escrever email")
    public void fillEmailCreate() {
        Random random = new Random();
        String email = "Michael" + random.nextInt() + "@CwiReset.com";
        emailCreate.sendKeys(email);
    }

    @Step("Clicar Create an account")
    public void clickCreateAnAccount() {
        SubmitCreate.click();
    }

    @Step("Buscar nome Authentication")
    public String getNameAuthentication() {
        return nameAuthentication.getText();
    }

    @Step("Buscar nome Michael Silveira")
    public String getNameMyAccount() {
        return myAccountName.getText();
    }

}



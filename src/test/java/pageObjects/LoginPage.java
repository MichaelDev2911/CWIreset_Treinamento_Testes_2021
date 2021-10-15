package pageObjects;

import elementMapper.LoginPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage(){
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    @Step("Escrever email")
    public void fillEmail() {
        email.sendKeys("michaelsilveira.castilho@yahoo.com.br");
    }

    @Step("Escrever senha")
    public void fillPassword(){
        passwd.sendKeys("CWI123");
    }

    @Step("clicar no botão de login")
    public void clickBtnSubmitLogin(){
        SubmitLogin.click();
    }

}

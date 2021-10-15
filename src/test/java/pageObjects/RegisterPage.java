package pageObjects;

import elementMapper.RegisterPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class RegisterPage extends RegisterPageElementMapper {

    public RegisterPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Clicar em Mrs.")
    public void clickLabelMrs() {
        buttonMrs.click();
    }

    @Step("Escrever nome")
    public void fillFirstName() {
        customer_firstname.sendKeys("Michael");
    }

    @Step("Escrever sobrenome")
    public void fillLastName() {
        customer_lastname.sendKeys("Silveira");
    }

    @Step("Escrever senha")
    public void fillPassword() {
        passwd.sendKeys("CWI123");
    }

    @Step("Escrever dia aniversário")
    public void clickDayBirth() {
        labelDay.click();
    }

    @Step("Escrever mês aniversário")
    public void clickMonthBirth() {
        months.click();
    }

    @Step("Escrever ano aniversário")
    public void clickYearBirth() {
        uniform_years.click();
    }

    @Step("Escrever nome de endereço")
    public void fillNameAddress() {
        firstname.sendKeys("Michael");
    }

    @Step("Escrever sobrenome de endereço")
    public void fillLastNameAddress() {
        lastname.sendKeys("Vargas da Silveira");
    }

    @Step("Escrever rua de endereço")
    public void fillStreetAddress() {
        address1.sendKeys("Rua Angra dos Reis");
    }

    @Step("Escrever nome cidade")
    public void fillCity() {
        city.sendKeys("Bettles");
    }

    @Step("Selecionar estado")
    public void ClickState() {
        optionState.click();
    }

    @Step("Escrever codigo postal")
    public void fillPostalCode() {
        postcode.sendKeys("99726");
    }

    @Step("Escrever telefone um")
    public void fillHomePhone() {
        phone.sendKeys("40722222");
    }

    @Step("Escrever telefone dois")
    public void fillMobilePhone() {
        phone_mobile.sendKeys("991452395");
    }

    @Step("Escrevee endereço alternativo")
    public void fillAddressAlias() {
        alias.sendKeys("Rua guaiba");
    }

    @Step("Selecionar para registrar cadastro")
    public void clickRegister() {
        buttonSubmit.click();
    }

}

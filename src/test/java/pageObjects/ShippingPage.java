package pageObjects;

import elementMapper.ShippingPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ShippingPage extends ShippingPageElementMapper {


    public ShippingPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Buscar nome SHIPPING")
    public String getNameShippingPage() {
        return shipping_page.getText();
    }

    @Step("Clicar para aceitar os termos e serviços")
    public void clickIAgree() {
        checkerTermsAndService.click();
    }

    @Step("Clicar para confirmar envio")
    public void clickProceedToCheckoutShipping() {
        buttonProccedShipping.click();
    }


}

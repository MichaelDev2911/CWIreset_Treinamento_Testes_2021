package pageObjects;

import elementMapper.PaymentPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class PaymentPage extends PaymentPageElementMapper {

    public PaymentPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Buscar nome PLEASE CHOOSE YOUR PAYMENT METHOD")
    public String getNameYourPaymentMethod() {
        return textNameInPaymentMethod.getText();
    }

    @Step("Clicar em Pay by bank wire")
    public void clickInPayByBankWire() {
        buttonPay_by_bank_wire.click();
    }

    @Step("Buscar nome Bank-wire payment")
    public String getNameBank_wirePayment() {
        return textNameInBank_wire_payment.getText();
    }

    @Step("Clicar em I confirm my order")
    public void clickInConfirmMyOrder() {
        buttonI_confirm_my_order.click();
    }

    @Step("Buscar nome Your order on My Store is complete.")
    public String getNameOrdemConfirmation() {
        return textNameInOrderConfirmation.getText();
    }


}

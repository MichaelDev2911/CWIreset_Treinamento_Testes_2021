package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPageElementMapper {

    @FindBy(css = ".page-heading")
    public WebElement textNameInPaymentMethod;

    @FindBy(css = ".bankwire")
    public WebElement buttonPay_by_bank_wire;

    @FindBy(css = ".navigation_page")
    public WebElement textNameInBank_wire_payment;

    @FindBy(xpath = "//span[text()=\"I confirm my order\"]")
    public WebElement buttonI_confirm_my_order;

    @FindBy(xpath = "//strong[text()=\"Your order on My Store is complete.\"]")
    public WebElement textNameInOrderConfirmation;


}

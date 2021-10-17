package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPageElementMapper {

    @FindBy(xpath = "//h1//span[@id]")
    public WebElement valueInCart;

    @FindBy(className = "navigation_page")
    public WebElement your_shopping_cart;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    public WebElement button_exclusive_checkout;
    //#center_column > p.cart_navigation.clearfix >
    // a.button.btn.btn-default.standard-checkout.button-medium > span
    @FindBy(css = ".header_user_info a[title='View my customer account']")
    public WebElement account;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span ")
    public WebElement button_address_checkout;
     //#center_column > form > p > button > span

}

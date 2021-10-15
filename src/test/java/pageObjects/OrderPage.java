package pageObjects;

import elementMapper.OrderPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class OrderPage extends OrderPageElementMapper {

    public OrderPage() {
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    @Step("Buscar valor no carrinho")
    public String getValueInCart(){
        return valueInCart.getText();
    }

    @Step("Buscar nome Your Shopping cart")
    public String getNameYourShoppingCart(){
        return your_shopping_cart.getText();
    }

    @Step("Clicar para confirmar carrinho de compras")
    public void clickProccedToCheckoutCart(){
        button_exclusive_checkout.click();
    }

    @Step("Buscar nome Michael Silveira")
    public String getNameAccount(){
        return account.getText();
    }

    @Step("Clicar para confirmar endereço de entrega e pagamento")
    public void clickProccedToCheckoutAddress(){
        button_address_checkout.click();
    }

}

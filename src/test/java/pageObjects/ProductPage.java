package pageObjects;

import elementMapper.ProductPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ProductPage extends ProductPageElementMapper {

    public ProductPage() {
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    @Step("Buscar nome produto antes de enviar para o carrinho")
    public String getProductNamePDP(){
      return  productNamePDP.getText();
    }

    @Step("Adicionar ao carrinho")
    public void clickButtonAddCart() {
        buttonAddToCart.click();
    }
    @Step("Clicar para checar os dados")
    public void clickButtonModalProceedToCheckout(){
        buttonModalProceedToCheckout.click();
    }
}

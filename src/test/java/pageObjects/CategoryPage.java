package pageObjects;

import elementMapper.CategoryPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class CategoryPage extends CategoryPageElementMapper {
    public CategoryPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Pegar nome para autenticar página")
    public String getAuthenticationPageTShirts() {
        return cat_name.getText();
    }

    @Step("Verificar conteúdo na página")
    public boolean isPageTshirts() {
        return getAuthenticationPageTShirts().contains("T-SHIRTS");
    }

    @Step("Clicar para adicionar a página de produtos")
    public void clickProductAddToProductPage() {
        BasePage.mouseOver(productNameCategory);
        buttonMoreAddToProductPage.click();
    }

    @Step("Buscar nome produto")
    public String getProductNameCategory() {
        return productNameCategory.getText();
    }
}

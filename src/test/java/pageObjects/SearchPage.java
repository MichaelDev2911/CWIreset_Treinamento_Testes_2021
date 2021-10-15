package pageObjects;

import elementMapper.SearchPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class SearchPage extends SearchPageElementMapper {

    public SearchPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Buscar texto na página")
    public String getTextNavigation_page() {
        return navigation_page.getText();
    }

    @Step("Buscar texto escrito para pesquisa")
    public String getTextLighter() {
        return lighter.getText();
    }

    @Step("Buscar texto na página categorias")
    public String getTextHeading_counter() {
        return heading_counter.getText();
    }

    @Step("Verificar se é a página de categorias correta")
    public boolean isSearchPage() {
        return getTextNavigation_page().equals("Search");
    }
}

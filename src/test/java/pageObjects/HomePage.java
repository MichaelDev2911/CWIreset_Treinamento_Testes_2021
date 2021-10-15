package pageObjects;

import elementMapper.HomePageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class HomePage extends HomePageElementMapper {

    public HomePage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Clicar botão login")
    public void clickBtnLogin() {
        login.click();
    }

    @Step("Clicar em categoria T-SHIRTS")
    public void clickCategoryTShirts() {
        //Browser.getCurrentDriver().findElement(By.linkText("")).click();
        menuTShirts.click();
    }

    @Step("Clicar no pesquisar")
    public void clickSearchQueryTop() {
        search_query_top.click();
    }

    @Step("Escrever pesquisa")
    public void sendKeysSearchQueryTop(String keys) {
        search_query_top.sendKeys(keys);
    }

    @Step("Clicar para pesquisar")
    public void submitSubmitSearch() {
        submit_search.click();
    }

    @Step("Todo o processo de pesquisar por vestido(DRESS)")
    public void doSearch(String quest) {
        clickSearchQueryTop();
        sendKeysSearchQueryTop(quest);
        submitSubmitSearch();
    }
}

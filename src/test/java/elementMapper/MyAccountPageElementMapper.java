package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageElementMapper {


    @FindBy(css = "#email_create")
    public WebElement emailCreate;


    public WebElement SubmitCreate;

    @FindBy(className = "navigation_page")
    public WebElement nameAuthentication;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(1) > a > span")
    public WebElement myAccountName;


}

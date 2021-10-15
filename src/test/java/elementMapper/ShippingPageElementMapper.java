package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPageElementMapper {

    @FindBy(className = "navigation_page")
    public WebElement shipping_page;

    @FindBy(id = "cgv")
    public WebElement checkerTermsAndService;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    public WebElement buttonProccedShipping;


}

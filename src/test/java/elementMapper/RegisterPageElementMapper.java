package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageElementMapper {

    @FindBy(css = "#account-creation_form > div:nth-child(1) > div.clearfix > div:nth-child(4) > label")
    public WebElement buttonMrs;

    public WebElement customer_firstname;

    public WebElement customer_lastname;

    public WebElement passwd;

    @FindBy(css = "#days > option:nth-child(30)")
    public WebElement labelDay;

    @FindBy(css = "#months > option:nth-child(12)")
    public WebElement months;

    @FindBy(css = "#years > option:nth-child(36)")
    public WebElement uniform_years;

    public WebElement firstname;

    public WebElement lastname;

    public WebElement address1;

    public WebElement city;

    @FindBy(css = "#id_state > option:nth-child(2)")
    public WebElement optionState;

    public WebElement postcode;

    public WebElement phone;

    public WebElement phone_mobile;

    public WebElement alias;

    @FindBy(css = "#submitAccount > span")
    public WebElement buttonSubmit;


}

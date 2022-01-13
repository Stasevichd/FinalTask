package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocalisationSettingsPage extends BasePage{
    public LocalisationSettingsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//input[@value='de_DE']" )
    private WebElement radioDeLanguage;

    @FindBy(xpath = "//input[@value='en_US']")
    private WebElement radioUsLanguage;

    @FindBy(xpath = "//input[@class='a-button-input']" )
    private WebElement saveChangesButton;

    @FindBy(xpath = "//span[@data-action='a-dropdown-button']")
    private WebElement curencyDropdownList;

    @FindBy(xpath = "//a[contains(text(),'€ - EUR - Euro')]")
    private WebElement curencyTypeEuro;

    @FindBy(xpath = "//a[contains(text(),'$ - USD - U.S. Dollar']")
    private WebElement curencyTypeUSD;


}

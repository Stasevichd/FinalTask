package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='Email'']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='personalaccount-radio']")
    private WebElement personalAccountRadioButton;

    @FindBy(xpath = "//input[@id='businessaccount-radio']")
    private WebElement businessAccountRadioButton;

    @FindBy (xpath = "//button[@name='EMAIL_REG_FORM_SUBMIT']")
    private WebElement confirmCreateButton;
}

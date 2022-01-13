package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmSignInPage extends BasePage{
    public ConfirmSignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='pass']")
    private WebElement passwordInputField;

    @FindBy(xpath = "//button[@id='sgnBt']")
    private WebElement signInButton;

    @FindBy (xpath = "//p[@id='errormsg']")
    private WebElement errorMessage;

    public boolean isPasswordInputFieldVisible(){
        return passwordInputField.isDisplayed();
    }
    public void enterPassword(String password){
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }
    public boolean isSignInButtonVisible(){
        return signInButton.isDisplayed();
    }

    public void signInButtonClick(){
        signInButton.click();
    }
    public boolean isErrorMassageVisible(){
        return errorMessage.isDisplayed();
    }


}

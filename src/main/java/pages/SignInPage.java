package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@autocomplete='username']")
    private WebElement userNameInput;

    @FindBy(xpath="//button[@id='signin-continue-btn']")
    private WebElement continueSignInButton;

    @FindBy (xpath = "//button[@id='signin_fb_btn']" )
    private WebElement signInWithFacebookButton;

    @FindBy (xpath = "//button[@id='signin_ggl_btn']")
    private WebElement signInWithGoogleButton;

    @FindBy (xpath = "id='signin_appl_btn'")
    private WebElement signInWithAppleButton;

    @FindBy (xpath = "//input[@id='kmsi-checkbox']")
    private WebElement staySignedInCheckBox;

    public boolean isUsernameInputVisible() throws InterruptedException {

        Thread.sleep(15000);
        return userNameInput.isDisplayed();
    }
    public void enterUsernameToInput(String username){
        userNameInput.clear();
        userNameInput.sendKeys(username);
    }

    public boolean isSignInWithFacebookVisible(){
        return signInWithFacebookButton.isDisplayed();
    }

    public boolean isSignInWithGoogleVisible(){
        return signInWithGoogleButton.isDisplayed();
    }

    public boolean isSignInWithAppleVisible(){
        return signInWithAppleButton.isDisplayed();
    }

    public boolean isContinueButtonVisible(){
        return continueSignInButton.isDisplayed();
    }

    public void clickContinuebutton(){
        continueSignInButton.click();
    }



}

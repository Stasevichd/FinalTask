package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@data-test-id='CONFIRM_AND_PAY_BUTTON']")
    private WebElement confirmAndPayButton;

    @FindBy (xpath = "//section[@data-test-id='SHIPPING']")
    private WebElement clientDataForm;

    @FindBy(xpath = "//section[@data-test-id='PAYMENT_METHODS']")
    private WebElement payMethodsForm;

    @FindBy(xpath = "//section[@data-test-id='INCENTIVES']")
    private WebElement addCouponsForm;

    @FindBy(xpath = "//p[@aria-live='polite']")
    private WebElement addShipDetailsError;



    public boolean isAddShipDetailsError(){return addShipDetailsError.isDisplayed();}
    public boolean isConfirmAndPayButtonVisible(){return confirmAndPayButton.isDisplayed();}
    public boolean isClientDataFormVisible(){return clientDataForm.isDisplayed();}
    public boolean isPayMethodsFormVisible(){return payMethodsForm.isDisplayed();}
    public boolean isAddCouponsFormVisible(){return addCouponsForm.isDisplayed();}
    public void clickConfirmAndPayButton(){confirmAndPayButton.click();}








}


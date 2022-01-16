package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//a[@id='isCartBtn_btn']")
    private WebElement addToCartButton;

    @FindBy (xpath = "//a[@id='binBtn_btn']")
    private WebElement buyNowButton;

    @FindBy (xpath = "//a[@n='Watch list']")
    private WebElement addToWishlistButton;

    @FindBy (xpath = "//input[@class='qtyInput']")
    private WebElement quantityInput;

    @FindBy (xpath = "//a[contains(text(),'Description')]")
    private WebElement descriptionTab;

    @FindBy (xpath = "//div[@id='w1-13-_errMsg']")
    private WebElement errorQuntityMessage;

    public void clickAddToCartButton(){addToCartButton.click();}

    public void clickBuyNowButton(){buyNowButton.click();}

    public void clickAddToWishListButton(){
        addToWishlistButton.click();}

    public void enterValueToQuantityInput(String count){
        quantityInput.clear();
        quantityInput.sendKeys(count);
    }
    public boolean isDescriptionTabVisible(){
        waitVisibilityOfElement( 10, descriptionTab);
        return descriptionTab.isDisplayed();}

    public boolean isAddToCartButtonVisible(){
        String temp  = driver.getTitle();
        return addToCartButton.isDisplayed();}
    public boolean isAddToWishListButtonVisible(){return addToWishlistButton.isDisplayed();}

    public boolean isBuyNowButtonVisible(){
        return buyNowButton.isDisplayed();}

    public boolean isquantityInputVisible(){return quantityInput.isDisplayed();}

    public boolean isErrorQuantityMessageVisible(){return errorQuntityMessage.isDisplayed();}






}

package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='cart-bucket']")
    private List<WebElement> productList;

    @FindBy(xpath = "//button[text()='Go to checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
    private WebElement removeButton;

    @FindBy (xpath = "//h1[@class='main-title']")
    private WebElement shoppingCartHeader;

    @FindBy (xpath = "//div[@class='empty-cart']")
    private WebElement emptyCart;

    @FindBy (xpath = "//button[@class='btn btn--secondary btn--large btn--fluid']")
    private WebElement continueCheckoutAsGuestButton;

    public boolean isCartEmpty(){
        waitVisibilityOfElement(10,emptyCart);
        return emptyCart.isDisplayed();}

    public boolean isCheckOutButtonVisible(){return checkoutButton.isDisplayed();}

    public boolean isCartContainsCountProducts(String count){return shoppingCartHeader.getText().contains(count);}

    public boolean isHeaderVisible(){return shoppingCartHeader.isDisplayed();}

    public boolean isRemoveButtonVisible(){return removeButton.isDisplayed();}

    public boolean isContinueAsGuestButtonVisible(){return continueCheckoutAsGuestButton.isDisplayed();}

    public void clickRemoveProductButton(){removeButton.click();}

    public void clickChecOutButton(){checkoutButton.click();}

    public void clickContinueCheckoutAsGuestButton(){
       waitVisibilityOfElement(100,continueCheckoutAsGuestButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueCheckoutAsGuestButton);}


}

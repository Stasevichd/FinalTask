package pages;

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

    @FindBy (xpath = "//span[text()='You don't have any items in your cart.']")
    private WebElement emptyCart;

    @FindBy (xpath = "//button[text()='Continue as guest']")
    private WebElement continueCheckoutAsGuestButton;

    public boolean isCartEmpty(){return emptyCart.isDisplayed();}

    public boolean isCheckOutButtonVisible(){return checkoutButton.isDisplayed();}

    public boolean isCartContainsProduct(){return shoppingCartHeader.getText().equalsIgnoreCase("item");}
    public boolean isHeaderVisible(){return shoppingCartHeader.isDisplayed();}

    public boolean isRemoveButtonVisible(){return removeButton.isDisplayed();}

    public boolean isContinueAsGuestButtonVisible(){return continueCheckoutAsGuestButton.isDisplayed();}

    public void clickRemoveProductButton(){removeButton.click();}

    public void clickChecOutButton(){checkoutButton.click();}

    public void clickContinueCheckoutAsGuestButton(){continueCheckoutAsGuestButton.click();}


}

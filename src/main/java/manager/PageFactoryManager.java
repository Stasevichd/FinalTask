package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SignInPage getSignInPage() {return new SignInPage(driver);}

    public ConfirmSignInPage getConfirmSignInPage() {return new ConfirmSignInPage(driver);}

    public SearchResultPage getSearchResultPage() { return new SearchResultPage(driver);}

    public ProductPage getProductPage() {return new ProductPage(driver);}

    public ShoppingCartPage getShoppingCartPage(){return new ShoppingCartPage(driver);}

    public CheckoutPage getCheckoutPage(){return new CheckoutPage(driver);}

    public ShipToPopup getShipToPopup(){return new ShipToPopup(driver);}



}



package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    ConfirmSignInPage confirmSignInPage;
    SearchResultpage searchResultpage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
   // SearchResultsPage searchResultsPage;

   CheckoutPage checkoutPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);   }




    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }
    @And("User checks search field visibility")
    public void checksSearchFieldVisibility() {
        assertTrue(homePage.isSearchFieldVisible());
    }

    @And("User checks Sign in button visibility")
    public void checkSignInButtonVisibility() {homePage.isSignInButtonVisible();}

    @When("User click Sign in button")
    public void clickSignInButton() {homePage.clickToSignInButton();}


    @When("User check username input field visibility")
    public void checkUsernameInputFieldVisibility() throws InterruptedException {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.isUsernameInputVisible();}

    @And("User fill in username filed with {string}")
    public void enterUsername(String username) {signInPage.enterUsernameToInput(username);}


    @When("User check Continue button visibility")
    public void checkContinueButtonVisibility() {signInPage.isContinueButtonVisible();}

    @And("User click Continue button")
    public void clickContinueButton() {signInPage.clickContinuebutton();}

    @When("User check password input field visibility")
    public void checkPasswordInputField() {
        confirmSignInPage = pageFactoryManager.getConfirmSignInPage();
        confirmSignInPage.isPasswordInputFieldVisible();}

    @And("User fill in password input field with text {string}")
    public void enterPassword(String password) { confirmSignInPage.enterPassword(password);}


    @When("User check Sign in button visibility")
    public void checkSignInVisibility() {confirmSignInPage.isSignInButtonVisible();}


    @And("User click Sign in")
    public void clickSignIn() {confirmSignInPage.signInButtonClick();}


    @Then("User checks that error message displayed")
    public void checkErrorMessageDisplayed() {confirmSignInPage.isErrorMassageVisible();}

    @And("User makes search by keyword {string}")
    public void searchWithKeyword(String keyword) {
        homePage.eterTextToSearchField(keyword);
        homePage.clickToSearchButton();
    }



    @When("User change min price to {string}")
    public void changeMinPriceToMinValue(String minValue) {
        searchResultpage.setMinPriceFilter(minValue);}

    @And("User change max price to {string}")
    public void userChangeMaxPriceToMaxValue(String maxValue){
        searchResultpage.setMaxPriceFilter(maxValue);
    }


    @When("User submit price range")
    public void submitPriceRange() {
        searchResultpage.submitPriceRange();
        searchResultpage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @When("User check that search results contains {string}")
    public void checkSearchResultsContainsKeyword(String keyword) {
        searchResultpage = pageFactoryManager.getSearchResultPage();
        searchResultpage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultpage.checkSearchResultContainsKeyword(keyword);

    }

    @After
    public void tearDown() {driver.close();
    }

    @When("User select product with {string} from result list")
    public void selectProductWithIndexFromSearchResultList(String index) {
        searchResultpage.selectProductByIndexFromResultList(index);

    }

    @When("User checks that description of product is visible")
    public void checkProductDescriptionVisible() {
        productPage.isDescriptionTabVisible();
    }


    @And("User checks  addToCart button visibility")
    public void checkAddToCartButtonVisibility() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.isAddToCartButtonVisible();
    }

    @And("User checks  buyNow button visibility")
    public void checksBuyNowButtonVisibility() {
        productPage.isBuyNowButtonVisible();
    }

    @And("User checks quantity field visibility")
    public void checkQuantityFieldVisibility() {
        productPage.isquantityInputVisible();
    }





    @When("User checks  opened shopping cart")
    public void CheckOpenedShoppingCart() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.isHeaderVisible();
    }

    @When("User clicks 'add to cart'")
    public void clickAddToCart() {
        productPage.clickAddToCartButton();
    }

    @And("User checks 'Go to checkout' button visibility")
    public void checkToCheckoutButtonVisibility() {
        shoppingCartPage.isCheckOutButtonVisible();
    }


    @And("User clicks 'Go to checkout' button")
    public void clicksGoToCheckoutButton() {
        shoppingCartPage.clickChecOutButton();
    }

    @When("User clicks Continue as Guest button")
    public void clickContinueAsGuestButton() {
        shoppingCartPage.clickContinueCheckoutAsGuestButton();

    }

    @When("User checks Pay methods form visibility")
    public void checkPayMethodsFormVisibility() {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        checkoutPage.isPayMethodsFormVisible();

    }

    @And("User checks Ship to form visibility")
    public void checkShipToFormVisibility() {
        checkoutPage.isClientDataFormVisible();
    }

    @And("User checks Confirm and pay button visibility")
    public void checksConfirmAndPayButtonVisibility() {
        checkoutPage.isConfirmAndPayButtonVisible();
    }
}


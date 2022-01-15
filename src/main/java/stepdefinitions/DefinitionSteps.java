package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 90;

    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    ConfirmSignInPage confirmSignInPage;
    SearchResultPage searchResultpage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
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
    public void checkSignInButtonVisibility() {
     assertTrue(homePage.isSignInButtonVisible());}

    @When("User click Sign in button")
    public void clickSignInButton() {homePage.clickToSignInButton();}


    @When("User check username input field visibility")
    public void checkUsernameInputFieldVisibility() throws InterruptedException {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
      assertTrue(signInPage.isUsernameInputVisible());}

    @And("User fill in username filed with {string}")
    public void enterUsername(String username) {
      signInPage.enterUsernameToInput(username);}


    @When("User check Continue button visibility")
    public void checkContinueButtonVisibility() {
      assertTrue(signInPage.isContinueButtonVisible());}

    @And("User click Continue button")
    public void clickContinueButton() {signInPage.clickContinuebutton();}

    @When("User check password input field visibility")
    public void checkPasswordInputField() {
        confirmSignInPage = pageFactoryManager.getConfirmSignInPage();
       assertTrue(confirmSignInPage.isPasswordInputFieldVisible());}

    @And("User fill in password input field with text {string}")
    public void enterPassword(String password) { confirmSignInPage.enterPassword(password);}


    @When("User check Sign in button visibility")
    public void checkSignInVisibility() {assertTrue(homePage.isSignInButtonVisible());}


    @And("User click Sign in")
    public void clickSignIn() {confirmSignInPage.signInButtonClick();}


    @Then("User checks that error message displayed")
    public void checkErrorMessageDisplayed() {
     assertTrue(confirmSignInPage.isErrorMassageVisible());}

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
       assertTrue(searchResultpage.checkSearchResultContainsKeyword(keyword));

    }

    @After
   public void tearDown() {driver.close();}

    @When("User select product with {string} from result list")
    public void selectProductWithIndexFromSearchResultList(String index) {
        searchResultpage.selectProductByIndexFromResultList(index);

    }

    @When("User checks that description of product is visible")
    public void checkProductDescriptionVisible() {
       assertTrue(productPage.isDescriptionTabVisible());
    }


    @And("User checks  addToCart button visibility")
    public void checkAddToCartButtonVisibility() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
      assertTrue(productPage.isAddToCartButtonVisible());
    }

    @And("User checks  buyNow button visibility")
    public void checksBuyNowButtonVisibility() {
      productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
       assertTrue(productPage.isBuyNowButtonVisible());
    }

    @And("User checks quantity field visibility")
    public void checkQuantityFieldVisibility() {
       assertTrue(productPage.isquantityInputVisible());
    }

    @When("User checks  opened shopping cart")
    public void CheckOpenedShoppingCart() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
       assertTrue(shoppingCartPage.isHeaderVisible());
    }

    @When("User clicks 'add to cart'")
    public void clickAddToCart() {
        productPage.clickAddToCartButton();
    }

    @And("User checks 'Go to checkout' button visibility")
    public void checkToCheckoutButtonVisibility() {
      assertTrue(shoppingCartPage.isCheckOutButtonVisible());
    }


    @And("User clicks 'Go to checkout' button")
    public void clicksGoToCheckoutButton() {
        shoppingCartPage.clickChecOutButton();
    }

    @When("User clicks Continue as Guest button")
    public void clickContinueAsGuestButton() {
      shoppingCartPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingCartPage.clickContinueCheckoutAsGuestButton();
    }

    @When("User checks Pay methods form visibility")
    public void checkPayMethodsFormVisibility() {
        checkoutPage = pageFactoryManager.getCheckoutPage();
        checkoutPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
       assertTrue(checkoutPage.isPayMethodsFormVisible());

    }

    @And("User checks Ship to form visibility")
    public void checkShipToFormVisibility() {
       assertTrue(checkoutPage.isClientDataFormVisible());
    }

    @And("User checks Confirm and pay button visibility")
    public void checksConfirmAndPayButtonVisibility() {
      assertTrue(checkoutPage.isConfirmAndPayButtonVisible());
    }


  @When("User selects 'new condition'  filter")
  public void selectsNewConditionFilter() {
      searchResultpage.selectOnlyNewFilter();
  }

  @When("User checks products only 'new condition' status")
  public void checkProductsOnlyNewStatus() {
      searchResultpage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
     assertTrue(searchResultpage.isAllProductsNewCondition());
  }



  @When("User checks that products price is beetwen {string} and {string}")
  public void checkThatProductsPriceIsBeetwenMinValueAndMaxValue(String minValue, String maxValue) {
     assertTrue(searchResultpage.isPriceFilterTrue(minValue,maxValue));
  }

  @When("User check Remove button visibility")
  public void checkREMOVEButtonVisibility() {assertTrue(shoppingCartPage.isRemoveButtonVisible());}


  @And("User removes products from shopping cart")
  public void removeProductFromShoppingCart() {shoppingCartPage.clickRemoveProductButton();}


  @And("User checks that  shopping cart is empty")
  public void checkThatShoppingCartIsEmpty() {assertTrue(shoppingCartPage.isCartEmpty());}

  @When("User back to homepage")
  public void backToHomepage() {shoppingCartPage.goHomePage();}

  @When("User checks that opened shopping cart contains {string} products")
  public void checkcCartContainsCountProducts(String count) {assertTrue(shoppingCartPage.isCartContainsCountProducts(count));
  }

  @And("User checks shopping cart visibility")
  public void checkShoppingCartVisibility() {assertTrue(homePage.isshoppingCartButtonVisible());}

  @And("User checks register button visibility")
  public void checkRegisterButtonVisibility() {assertTrue(homePage.isRegisterButtonVisible());}


  @And("User checks main logo visibility")
  public void checksMainLogoVisibility() {assertTrue(homePage.isMainLogoVisible());
  }


  @And("User checks Header visibility")
  public void checkHeaderVisibility() {assertTrue(homePage.isHeaderVisible());
  }

  @And("User checks Footer visibility")
  public void checkFooterVisibility() {assertTrue( homePage.isFooterVisible());
  }


  @And("User checks ship To button")
  public void checkShipToButton() {assertTrue(homePage.isShipToButtonvisible());
  }

  @When("User enters {string} to quantity field")
  public void userEntersToQuantityField(String value) {productPage.enterValueToQuantityInput(value);
  }

  @When("User checks error message visibility")
  public void checkErrorMessageVisibility() {
    assertTrue(productPage.isErrorQuantityMessageVisible()) ;
  }

  @When("User selects Only Auction  filter")
  public void selectsAuctionFilter() {searchResultpage.selectAuctionFilter();
  }

  @When("User checks products only Auction status")
  public void checkProductsOnlyAuctionStatus() {
      assertTrue(searchResultpage.isBidFieldVisible());
  }
}



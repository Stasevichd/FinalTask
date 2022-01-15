package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    @FindBy(xpath ="//li[@id='gh-minicart-hover']" )
    private WebElement shoppingCartButton;

    @FindBy(xpath ="//input[@type='text']" )
    private WebElement searchField;

    @FindBy(xpath = "//input[@type='submit']" )
    private WebElement searchButton;

    @FindBy(xpath = "//a[@title='My eBay']" )
    private WebElement accountMenuButton;

    @FindBy(xpath ="//button[@title='Ship to']" )
    private WebElement shipToButton;

    @FindBy(xpath = "//img[@alt='eBay Logo']" )
    private WebElement mainLogoIcon;

    @FindBy (xpath = "//span[text()='Hi! ']/a[text()='Sign in']")
    private WebElement signInButton;

    @FindBy (xpath = "//a[text()='register']")
    private WebElement registerButton;

    private String title = driver.getTitle();

    @FindBy (xpath ="//header" )
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;



    public boolean isMainLogoVisible(){
        return mainLogoIcon.isDisplayed();
    }

    public boolean isSearchFieldVisible(){
        return searchField.isDisplayed();
    }

    public boolean isFooterVisible(){
        return footer.isDisplayed();
    }

    public boolean isHeaderVisible(){
        return header.isDisplayed();
    }

    public boolean  isSignInButtonVisible(){
        return signInButton.isDisplayed();
    }

    public boolean isRegisterButtonVisible(){
        return registerButton.isDisplayed();
    }

    public boolean isshoppingCartButtonVisible(){
        return shoppingCartButton.isDisplayed();
    }

    public void eterTextToSearchField(String keyword){
        searchField.clear();
        searchField.sendKeys(keyword);
    }



    public void clickToSearchButton(){
        searchButton.click();
    }

    public void clickToSignInButton(){
        signInButton.click();
    }

    public void cliclShipToButton(){
        shipToButton.click();
    }

    public void clickRegisterButton(){
        registerButton.click();
    }

    public void clickCartButton(){
        shoppingCartButton.click();
    }

    public boolean isShipToButtonvisible() {return shipToButton.isDisplayed();
    }




   /* @FindBy(xpath = )
    private WebElement

    @FindBy(xpath = )
    private WebElement

    @FindBy(xpath = )
    private WebElement

    @FindBy(xpath = )
    private WebElement */
}

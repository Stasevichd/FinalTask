package manager;

import org.openqa.selenium.WebDriver;
import pages.ConfirmSignInPage;
import pages.HomePage;
import pages.SearchResultpage;
import pages.SignInPage;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }
    public SignInPage getSignInPage(){return new SignInPage(driver);}
    public ConfirmSignInPage getConfirmSignInPage(){return new ConfirmSignInPage(driver);}

    public SearchResultpage getSearchResultPage() {return new SearchResultpage(driver);}
}

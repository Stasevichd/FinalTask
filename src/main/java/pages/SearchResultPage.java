package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;
import java.util.Set;

public class SearchResultPage extends BasePage{




    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//h1[text()='Bad Request']")
    WebElement inputScriptError;

    @FindBy (xpath = "//input[@aria-label='Buy It Now']")
    private WebElement buyItNowfilterRadio;

    @FindBy (xpath ="//div[@id='srp-river-results']//li[contains(@class,'s-item__pl-on-bottom')]" )
    private List<WebElement> resultList;

    @FindBy(xpath = "//input[contains(@aria-label, 'Maximum Value')]")
    private WebElement maxPriceInput;

    @FindBy(xpath = "//input[contains(@aria-label, 'Minimum Value')]")
    private WebElement minPriceInput;

    @FindBy(xpath = "//button[@aria-label='Submit price range']")
    private WebElement submitPriceRange;

    @FindBy(xpath = "//input[@aria-label='New']")
    private WebElement onlyNewFilterRadio;

    @FindBy(xpath = "//span[@class='SECONDARY_INFO']")
    private   List<WebElement>   productsConditionStatusList;

    @FindBy(xpath = "//h3[@class='s-item__title']")
    private List<WebElement> productsNameList;

    @FindBy(xpath = "//span[@class='s-item__price']")
    private List<WebElement> productsPriceList;

    @FindBy(xpath = "//input[@aria-label='Auction']")
    private WebElement auctionOnlyRadio;

    @FindBy(xpath = "//span[@class='s-item__bids s-item__bidCount']")
    private List<WebElement> bidsCount;

    @FindBy(xpath = "//span[@id='nid-OpL-1']")
    private WebElement openSortList;

    @FindBy(xpath = "//span[contains(text(),'lowest;)]")
    private WebElement selectLowerstPrice;

    public void openSortMenu(){openSortList.click();}

    public boolean isInputScriptErrorVisible(){
       return inputScriptError.isDisplayed();
    }

    public boolean isBidFieldVisible(){
        for (WebElement result : bidsCount) {
            if(!result.getText().contains("bid")) return false;
        }
        return true;
    }


    public void selectAuctionFilter(){
        auctionOnlyRadio.click();
    }

    public boolean isAuctionRadioVisible(){ return  auctionOnlyRadio.isDisplayed();}

    public void selectFirstProductFromList(){
        List<WebElement> resultList = this.resultList;
        resultList.get(1).findElement(By.xpath("//div[@class='s-item__image-section']")).click();
    }

    public void selectProductByIndexFromResultList(String index){
        List<WebElement> resultList = this.resultList;
        String tab1 = driver.getWindowHandle();
        resultList.get(Integer.parseInt(index)).findElement(By.xpath("//div[@class='s-item__image-section']")).click();
        Set<String> currentTabs = driver.getWindowHandles();
        String tab2 = null;
        for (String tab : currentTabs) {
            if (!tab.equals(tab1)){
                tab2 = tab;
            }
        }
        driver.close();
        driver.switchTo().window(tab2);
        waitForPageLoadComplete(100);
    }



    public void selectBuyNowFilter(){
       buyItNowfilterRadio.click();
    }

    public void selectOnlyNewFilter(){onlyNewFilterRadio.click();}

    public void submitPriceRange(){
        submitPriceRange.click();
    }

    public void setMaxPriceFilter(String maxValue){
        maxPriceInput.clear();
        maxPriceInput.sendKeys(maxValue);

    }

    public void setMinPriceFilter(String minValue){
        minPriceInput.clear();
        minPriceInput.sendKeys(minValue);
    }

    public void setPriceRange(String minValue, String maxValue){
        setMinPriceFilter(minValue);
        setMaxPriceFilter(maxValue);
        submitPriceRange();
    }

    public boolean checkSearchResultContainsKeyword(String keyword){
        boolean temp = false;
        for (WebElement result: productsNameList) {
            if(!result.getText().
                    toLowerCase(Locale.ROOT).
                    contains(keyword)) return false;
        }
    return true;
    }

    public boolean isAllProductsNewCondition() {

        for (WebElement status : productsConditionStatusList) {
            String temp =status.getText();
            boolean temp1 = temp.toLowerCase(Locale.ROOT).contains("new");
             if (!temp1) return false;
        }
        return true ;
    }


    public boolean isPriceFilterTrue(String minValue, String maxValue){

        for (WebElement productPrice : productsPriceList) {
           String price = productPrice.getText().replaceAll("[$]", "");
          if (price.contains("to")){
            price =   price.substring(0, price.indexOf(' '));          }
            double  priceValue = Double.parseDouble(price);
           if (priceValue < Double.parseDouble(minValue) || priceValue > Double.parseDouble(maxValue)) return false;
        }
        return true;
    }
}

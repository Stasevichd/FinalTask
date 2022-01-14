package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultpage extends BasePage{


    public SearchResultpage(WebDriver driver) {
        super(driver);
    }
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


    public void selectFirstProductFromList(){
        List<WebElement> resultList = this.resultList;
        resultList.get(1).findElement(By.xpath("//div[@class='s-item__image-section']")).click();
    }

    public void selectProductByIndexFromResultList(String index){
        List<WebElement> resultList = this.resultList;
        resultList.get(Integer.parseInt(index)).findElement(By.xpath("//div[@class='s-item__image-section']")).click();
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
        for (WebElement result: resultList) {
            if(result.findElement(By.xpath("//h3")).getText().equalsIgnoreCase(keyword)) temp =  true; else{
                        return false;

            }

        }
    return true;
    }



}

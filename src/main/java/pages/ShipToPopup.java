package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class ShipToPopup extends BasePage{
  public ShipToPopup(WebDriver driver) {
    super(driver);
  }
  @FindBy(xpath = "//button[@class='menu-button__button expand-btn expand-btn--icon-only']")
  private WebElement openCountriesist;

  @FindBy(xpath = "//span[contains(text(),'Ukraine')]")
  private WebElement selectUkraine;

  @FindBy(xpath = "//button[@class='shipto__close-btn']")
  private WebElement doneButton;


  public void clickDoneButton(){doneButton.click();}

  public void changeToUkraine(){selectUkraine.click();}
}

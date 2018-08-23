package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import generic.BasePage;

public class AccessoriesTab extends BasePage{

public AccessoriesTab (WebDriver driver){
      super (driver);
}

@FindBy(xpath="//a[Contains(text(),'Product Category')]")
private WebElement prodCategory;

@FindBy(xpath="//a[text()='Accessories']")
private WebElement accessories;

@FindBy(xpath="//a[Contains(text(),'Magic Mouse')]//..//..//input[@value='Add To Cart']")
private WebElement addToCartMagicMouse;

@FindBy(xpath="//a[Contains(text(),'Magic Mouse')]//..//..//img[@title='Loading']")
private WebElement loadingElement;

public void moveToElement(){
Actions action = new Actions(driver);
action.moveToElement(prodCategory).build().perform();
}

public void clickAccessoriesTab(){
try{
moveToElement();
wait.until(ExpectedConditions.invisibilityOf(loadingElement));
accessories.click();
}
catch (Exception e) {
	System.out.println("Element is not Visible");
}
}

public void waitUntilPageLoad(){

wait.until(ExpectedConditions.invisibilityOf(loadingElement));
}
public void selectItem(String item){
if(item.equals("MagicMouse")){
addToCartMagicMouse.click();
}

waitUntilPageLoad();
}

}
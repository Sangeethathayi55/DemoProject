package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import generic.BasePage;

public class CheckoutTab extends BasePage {

@FindBy (xpath="//a[@title='Checkout']")
private WebElement checkOut;

public CheckoutTab(WebDriver driver) {
super(driver);
checkOut.click();
}

@FindBy(xpath = "//span[text()='Continue']")
private WebElement contnue;

@FindBy(xpath="//table[@class='wpsc_checkout_table table-1']//input[@placeholder='First Name']")
private WebElement fstName;

@FindBy(xpath="//table[@class='wpsc_checkout_table table-1']//input[@placeholder='Last Name']")
private WebElement lstName;


@FindBy(xpath="//table[@class='wpsc_checkout_table table-1']//textarea[@placeholder='Address']")
private WebElement address;

@FindBy(xpath="//table[@class='wpsc_checkout_table table-1']//input[@placeholder='City']")
private WebElement city;

@FindBy(xpath="//table[@class='wpsc_checkout_table table-1']//input[@placeholder='State/Province']")
private WebElement state;

@FindBy(id="wpsc_checkout_form_7")
private WebElement country;


@FindBy(xpath="//table[@class='wpsc_checkout_table table-1']//input[@placeholder='Postal Code']")
private WebElement postalCode;

@FindBy(xpath="//table[@class='wpsc_checkout_table table-1']//input[@placeholder='Phone']")
private WebElement phone;

@FindBy(xpath="//input[@placeholder='Email']")
private WebElement email;

@FindBy(xpath="//input[@value ='Purchase']")
private WebElement purchaseBTN;

@FindBy(xpath="//input[@id ='shippingSameBilling']")
private WebElement sameBilling;

@FindBy(xpath="//div[@class='wpsc-trasaction-results-wrap']")
private WebElement resPage;

@FindBy(xpath="//em[@class='count']")
private WebElement getCount;

@FindBy(xpath="//h2[contains(text(),'Calculate Shipping Price')]")
private WebElement calshippingPrice;

@FindBy(xpath="//table[@class='checkout_cart']//a[contains(text(),'Magic Mouse')]")
private WebElement magicMouse;

@FindBy(xpath="//table[@class='wpsc-purchase-log-transaction-results']//td")
private WebElement itemShipped;

public boolean isMagicMousePresent(){
  return driver.findElements(By.xpath("//table[@class='checkout_cart']//a[contains(text(),'Magic Mouse')]")).size()!= 0;
}



public int verifyOnlyOneMagicMousePresentInTheCart(){
String count = getCount.getText();
int countint = Integer.parseInt(count);
return countint;
}

public boolean verifyItemAddedToCart(){
boolean count = getCount.getText().equals("1");
checkOut.click();
wait.until(ExpectedConditions.invisibilityOf(magicMouse));
boolean present = isMagicMousePresent();
return (count && present);
}

public void clickContinueBTN() {
wait.until(ExpectedConditions.invisibilityOf(contnue));
contnue.click();
}

public boolean verifyCalculateShippingPriceHeadingIsPresent(){
return driver.findElements(By.xpath("//h2[contains(text(),'Calculate Shipping Price']")).size() != 0;
}

public void selectCountry(String cntry){
//Select sel = new Select(country);
Select sel= new Select(country);
sel.selectByVisibleText(cntry);
}

public void waitUntilPageLoad(){
while(driver.findElement(By.xpath("//a[contains(text(),'Magic Mouse')]//..//..//img[@title=''Loading]")).getAttribute("style")=="visibility: hidden;");
}

public void fillForm(String fname,String lname,String addr,String cityinput,String pro,String cntry,String phNo){
email.sendKeys("abc@xyz.com");
fstName.sendKeys(fname);
lstName.sendKeys(lname);
address.sendKeys(addr);
city.sendKeys(cityinput);
state.sendKeys(pro);
selectCountry(cntry);
phone.sendKeys(phNo);
}

public void clickPurchase(){
purchaseBTN.click();
}

public void clickSameAsBillingAddress() {
sameBilling.click();
}

public String verifyTransactionResults() {
wait.until(ExpectedConditions.invisibilityOf(resPage));
String res = resPage.getText();
return res;
}
}



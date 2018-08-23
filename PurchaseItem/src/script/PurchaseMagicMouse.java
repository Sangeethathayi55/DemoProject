package script;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import page.AccessoriesTab;
import page.CheckoutTab;

public class PurchaseMagicMouse extends BaseTest {

String item = "MagicMouse";
SoftAssert sa = new SoftAssert();
String fstName = "fName";
String lstName = "lName";
String address = "This is my Address";
String City = "city";
String province = "pro";
String phNo = "1234567890";
String Country = "Germany";
String expRes1 = " Thank you, your purchase is pending. You will be sent an email once the order clears.";
String expRes2 = " Thank you for purchasing with ONLINE STORE"
		+ ", any items to be shipped will be processed as soon as possible,"
		+ " any items that can be downloaded can be downloaded using the links on this page. "
		+ "All prices include tax and postage and packaging where applicable.";


@Test(priority=1)
public void buyMagicMouse() {

//step1 : Click on ProductCategory and select Accessories
AccessoriesTab accessoriesTab= new AccessoriesTab(driver);
accessoriesTab.clickAccessoriesTab();

//step 2 : Add magic Mouse to cart

accessoriesTab.selectItem(item);

//step 3: verify Item is added to cart and there is only one magic Mouse

CheckoutTab chTab = new CheckoutTab(driver);
int count = chTab.verifyOnlyOneMagicMousePresentInTheCart();
Assert.assertEquals(count,1);

//click on continue and enter dummy values

chTab.clickContinueBTN();
boolean elementPresent = chTab.verifyCalculateShippingPriceHeadingIsPresent();
sa.assertEquals(elementPresent,true);

chTab.fillForm(fstName,lstName,address,City,province,Country,phNo);
chTab.clickSameAsBillingAddress();
chTab.clickPurchase();
String result = chTab.verifyTransactionResults();
boolean res1Present = result.contains(expRes1);
boolean res2Present = result.contains(expRes2);
boolean itemName = result.contains("Magic Mouse");
boolean itemPrice = result.contains("$150.00");
boolean qty = result.contains("1");
boolean itmTotal = result.contains("$150.00");


sa.assertEquals(res1Present,true,"Result1 does not match");
sa.assertEquals(res2Present,true,"Result2 does not match");
sa.assertEquals(itemName,true,"itemName does not match");
sa.assertEquals(itemPrice,true,"itemPrice does not match");
sa.assertEquals(qty,true,"qty does not match");
sa.assertEquals(itmTotal,true,"itmTotal does not match");

sa.assertAll();
}
}
 

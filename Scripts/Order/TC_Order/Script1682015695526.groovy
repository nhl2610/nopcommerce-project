import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import org.openqa.selenium.WebElement
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement as Keys

CustomKeywords.'OpenBrowser.initBrowser'()

WebUI.click(findTestObject('Object Repository/Page_HomePage/a_Log in'))

CustomKeywords.'Keyword_Helper.login'('arthur_holmes@nopCommerce.com', '123456')

WebUI.click(findTestObject('Page_HomePage/a_Shopping cart'))

List<WebElement> listPriceObj = WebUI.findWebElements(findTestObject('Page_Cart/span_listPrice'), 5)
def listPrice = [];

List<WebElement> listQuantityObj = WebUI.findWebElements(findTestObject('Page_Cart/span_listQuantity'), 5)
def listQuantity = [];

for (int i = 0;  i < listPriceObj.size(); ++i) {
	listPrice.add(listPriceObj.get(i).getText());
	listQuantity.add(listQuantityObj.get(i).getAttribute('value'));
}

WebUI.click(findTestObject('Page_Shopping Cart/input_You will earn_termsofservice'))

WebUI.click(findTestObject('Page_Shopping Cart/button_Checkout'))

//CustomKeywords.'Keyword_Helper.addAddress'('Luyen', 'Nguyen', 'nhl@gmail.com', 'Viet Nam', 'Ha Noi', 'Dong Anh', '111', 
//    '032648445')

WebUI.click(findTestObject('Page_Checkout/button_ContinueAddress'))

shippingoption = CustomKeywords.'Keyword_Helper.randomNumber'(0, 3)

WebUI.click(findTestObject('Page_Checkout/input_shippingoption', [('index') : shippingoption + '']))

WebUI.click(findTestObject('Page_Checkout/button_ContinueShippingMethod'))

paymentmethod = CustomKeywords.'Keyword_Helper.randomNumber'(0, 2)

WebUI.click(findTestObject('Page_Checkout/input_paymentmethod', [('index') : paymentmethod + '']))

WebUI.click(findTestObject('Page_Checkout/button_ContinuePaymentMethod'))

if (paymentmethod == 1) {
    WebUI.sendKeys(findTestObject('Page_Checkout/input_Cardholder name'), 'Jame')

    WebUI.sendKeys(findTestObject('Page_Checkout/input_Card number'), '4263982640269299')

    WebUI.selectOptionByValue(findTestObject('Page_Checkout/select_month'), '2', false)

    WebUI.selectOptionByValue(findTestObject('Page_Checkout/select_year'), '2026', false)

    WebUI.sendKeys(findTestObject('Page_Checkout/input_Card code'), '837')
}

WebUI.click(findTestObject('Page_Checkout/button_ContinuePaymentInfo'))

WebUI.click(findTestObject('Page_Checkout/button_Confirm'))

WebUI.click(findTestObject('Page_Checkout/a_Click view order'))

expected = WebUI.getText(findTestObject('Page_Order Details/span_Payment Method'))

if (paymentmethod == 0) {
    assert expected.contains('Check / Money Order') == true
} else {
    assert expected.contains('Credit Card') == true
}

expected = WebUI.getText(findTestObject('Page_Order Details/span_Shipping Method'))

if (shippingoption == 0) {
    assert expected.contains('Ground') == true
} else if (shippingoption == 1) {
    assert expected.contains('Next Day Air') == true
} else {
    assert expected.contains('2nd Day Air') == true
}

List<WebElement> listPriceObj2 = WebUI.findWebElements(findTestObject('Page_Order Details/span_listPrice'), 5)

List<WebElement> listQuantityObj2 = WebUI.findWebElements(findTestObject('Page_Order Details/span_listQuantity'), 5)

def listPrice2 = [];

def listQuantity2 = [];

for (int i = 0;  i < listPriceObj.size(); ++i) {
	listPrice2.add(listPriceObj2.get(i).getText());
	listQuantity2.add(listQuantityObj2.get(i).getText());
}

for (int i = 0;  i < listPrice.size(); ++i) {
	if(!listPrice[i].equals(listPrice2[i]) || !listQuantity[i].equals(listQuantity2[i]) )
		assert false;
}

WebUI.closeBrowser()


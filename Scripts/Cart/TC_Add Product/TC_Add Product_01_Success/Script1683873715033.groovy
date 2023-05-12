import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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
import org.openqa.selenium.Keys as Keys

CustomKeywords.'OpenBrowser.initBrowser'()

WebUI.click(findTestObject('Page_HomePage/a_Log in'))

CustomKeywords.'Keyword_Helper.login'('arthur_holmes@nopCommerce.com', '123456')

WebUI.click(findTestObject('Page_HomePage/a_HTC One M8 Android L 5.0 Lollipop'))

name1 = WebUI.getText(findTestObject('Page_ProductDetail/lbl_ProductName'))

WebUI.clearText(findTestObject('Page_ProductDetail/input_Quantity'))

WebUI.setText(findTestObject('Page_ProductDetail/input_Quantity'), quantity)

WebUI.click(findTestObject('Page_ProductDetail/button_Add to cart'))

WebUI.click(findTestObject('Page_HomePage/button_shopping cart_close'))

WebUI.click(findTestObject('Page_HomePage/a_Shopping cart'))

name2 = WebUI.getText(findTestObject('Page_Shopping Cart/Page_Products In Cart/a_ProductName', [('index') : '1']))

quantity2 = WebUI.getAttribute(findTestObject('Page_Shopping Cart/Page_Products In Cart/input_quantity', [('i') : '1']), 'value') 

WebUI.verifyMatch(name1, name2, false)

WebUI.verifyMatch(quantity, quantity2, false)



//=============================================//
/*
WebUI.navigateToUrl(GlobalVariable.url)

WebUI.click(findTestObject('Page_HomePage/a_Build your own computer'))

WebUI.selectOptionByValue(findTestObject('Page_ProductDetail/Page_nopCommerce demo store. Build your own_e6927f/select_Please select2.2 GHz Intel Pentium D_04da08'), 
    '1', true)

WebUI.selectOptionByValue(findTestObject('Page_ProductDetail/Page_nopCommerce demo store. Build your own_e6927f/select_Please select2 GB4GB 20.008GB 60.00'), 
    '4', true)

WebUI.click(findTestObject('Page_ProductDetail/Page_nopCommerce demo store. Build your own_e6927f/input__product_attribute_3'))

WebUI.click(findTestObject('Page_ProductDetail/Page_nopCommerce demo store. Build your own_e6927f/input_Vista Home 50.00_product_attribute_4'))

WebUI.click(findTestObject('Page_ProductDetail/Page_nopCommerce demo store. Build your own_e6927f/input_Microsoft Office 50.00_product_attribute_5'))

WebUI.click(findTestObject('Page_ProductDetail/button_Add to cart'))

WebUI.click(findTestObject('Page_HomePage/button_shopping cart_close'))

WebUI.click(findTestObject('Page_HomePage/a_Shopping cart'))

WebUI.verifyElementVisible(findTestObject('Page_Shopping Cart/Page_Products In Cart/a_Build your own computer'))

WebUI.verifyElementVisible(findTestObject('Page_Shopping Cart/Page_Products In Cart/div_Processor 2.2 GHz Intel Pentium Dual-Co_65063c'))

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.click(findTestObject('Page_HomePage/a_25 Virtual Gift Card'))

WebUI.setText(findTestObject('Page_ProductDetail/Page_nopCommerce demo store. 25 Virtual Gift Card/input_concat(Recipient, , s Name)_giftcard__3edfaa'), 
    'Nguyen Hai Luyen')

WebUI.setText(findTestObject('Page_ProductDetail/Page_nopCommerce demo store. 25 Virtual Gift Card/input_concat(Recipient, , s Email)_giftcard_7eddd1'), 
    'nhl@gmail.com')

WebUI.setText(findTestObject('Page_ProductDetail/Page_nopCommerce demo store. 25 Virtual Gift Card/input_Your Name_giftcard_43.SenderName'), 
    'Luyen')

WebUI.doubleClick(findTestObject('Page_ProductDetail/Page_nopCommerce demo store. 25 Virtual Gift Card/label_Recipients Name'))

WebUI.setText(findTestObject('Page_ProductDetail/Page_nopCommerce demo store. 25 Virtual Gift Card/input_Your Email_giftcard_43.SenderEmail'), 
    'luyen@gmail.com')

WebUI.setText(findTestObject('Page_ProductDetail/Page_nopCommerce demo store. 25 Virtual Gift Card/textarea_Message_giftcard_43.Message'), 
    'message of product')

WebUI.click(findTestObject('Page_ProductDetail/button_Add to cart'))

WebUI.click(findTestObject('Page_HomePage/button_shopping cart_close'))

WebUI.click(findTestObject('Page_HomePage/a_Shopping cart'))

WebUI.verifyElementVisible(findTestObject('Page_Shopping Cart/Page_Products In Cart/div_From Luyen luyengmail.comFor Nguyen Hai_1efad2'))

WebUI.verifyElementVisible(findTestObject('Page_Shopping Cart/Page_Products In Cart/a_25 Virtual Gift Card'))
*/
WebUI.closeBrowser()


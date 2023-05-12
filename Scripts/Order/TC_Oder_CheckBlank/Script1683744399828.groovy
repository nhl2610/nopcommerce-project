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

CustomKeywords.'Keyword_Helper.login'('james_pan@nopCommerce.com', '123456')

//WebUI.click(findTestObject('Page_HomePage/a_HTC One M8 Android L 5.0 Lollipop'))
//
//WebUI.click(findTestObject('Page_ProductDetail/button_Add to cart'))
WebUI.click(findTestObject('Page_HomePage/a_Shopping cart'))

WebUI.click(findTestObject('Page_Shopping Cart/button_Checkout'))

WebUI.verifyElementText(findTestObject('Page_Shopping Cart/p_Terms of service Error Message'), 'Please accept the terms of service before the next step.')

WebUI.click(findTestObject('Page_Shopping Cart/button_CloseMessage'))

WebUI.click(findTestObject('Page_Shopping Cart/input_termsofservice'))

WebUI.click(findTestObject('Page_Shopping Cart/button_Checkout'))

WebUI.click(findTestObject('Page_Checkout/Address/button_ContinueAddress'))

WebUI.verifyElementText(findTestObject('Page_Checkout/Address/span_First name is required'), 'First name is required.')

WebUI.verifyElementText(findTestObject('Page_Checkout/Address/span_Last name is required'), 'Last name is required.')

//WebUI.verifyElementText(findTestObject('Page_Checkout/Address/span_Email is required'), 'Email is required.')

WebUI.verifyElementText(findTestObject('Page_Checkout/Address/span_Country is required'), 'Country is required.')

WebUI.verifyElementText(findTestObject('Page_Checkout/Address/span_City is required'), 'City is required')

WebUI.verifyElementText(findTestObject('Page_Checkout/Address/span_Street address is required'), 'Street address is required')

WebUI.verifyElementText(findTestObject('Page_Checkout/Address/span_Zip  postal code is required'), 'Zip / postal code is required')

WebUI.verifyElementText(findTestObject('Page_Checkout/Address/span_Phone is required'), 'Phone is required')

CustomKeywords.'Keyword_Helper.addAddress'('Luyen', 'Nguyen', 'nhl@gmail.com', 'Viet Nam', 'Ha Noi', 'Dong Anh', '111', 
    '032648445')

WebUI.click(findTestObject('Page_Checkout/Address/button_ContinueAddress'))

//WebUI.click(findTestObject('Page_Checkout/Shipping Method/input_shippingoption', [('index') : '1']))
WebUI.click(findTestObject('Page_Checkout/Shipping Method/button_ContinueShippingMethod'))

WebUI.click(findTestObject('Page_Checkout/Payment Method/input_paymentmethod', [('index') : '1']))

WebUI.click(findTestObject('Page_Checkout/Payment Method/button_ContinuePaymentMethod'))

WebUI.setText(findTestObject('Page_Checkout/Payment Info/input_Card number'), '4263982640269299')

WebUI.selectOptionByValue(findTestObject('Page_Checkout/Payment Info/select_year'), '2024', true)

WebUI.selectOptionByValue(findTestObject('Page_Checkout/Payment Info/select_month'), '4', true)

WebUI.setText(findTestObject('Page_Checkout/Payment Info/input_Card code'), '123')

WebUI.click(findTestObject('Page_Checkout/Payment Info/button_ContinuePaymentInfo'))

WebUI.verifyElementText(findTestObject('Page_Checkout/Payment Info/li_Enter cardholder name'), 'Enter cardholder name')

WebUI.setText(findTestObject('Page_Checkout/Payment Info/input_Cardholder name'), 'Jame')

WebUI.setText(findTestObject('Page_Checkout/Payment Info/input_Card number'), '4')

WebUI.click(findTestObject('Page_Checkout/Payment Info/button_ContinuePaymentInfo'))

WebUI.verifyElementText(findTestObject('Page_Checkout/Payment Info/li_Wrong card number'), 'Wrong card number')

WebUI.setText(findTestObject('Page_Checkout/Payment Info/input_Card number'), '4263982640269299')

WebUI.selectOptionByValue(findTestObject('Page_Checkout/Payment Info/select_year'), '2023', true)

WebUI.click(findTestObject('Page_Checkout/Payment Info/button_ContinuePaymentInfo'))

WebUI.verifyElementText(findTestObject('Page_Checkout/Payment Info/li_Card is expired'), 'Card is expired')

WebUI.setText(findTestObject('Page_Checkout/Payment Info/input_Card code'), '')

WebUI.selectOptionByValue(findTestObject('Page_Checkout/Payment Info/select_year'), '2024', true)

WebUI.click(findTestObject('Page_Checkout/Payment Info/button_ContinuePaymentInfo'))

WebUI.verifyElementText(findTestObject('Page_Checkout/Payment Info/li_Wrong card code'), 'Wrong card code')

WebUI.setText(findTestObject('Page_Checkout/Payment Info/input_Card code'), '1')

WebUI.click(findTestObject('Page_Checkout/Payment Info/button_ContinuePaymentInfo'))

WebUI.verifyElementText(findTestObject('Page_Checkout/Payment Info/li_Wrong card code'), 'Wrong card code')

WebUI.setText(findTestObject('Page_Checkout/Payment Info/input_Card code'), '123')

WebUI.click(findTestObject('Page_Checkout/Payment Info/button_ContinuePaymentInfo'))

WebUI.verifyElementVisible(findTestObject('Page_Checkout/button_Confirm'))

WebUI.closeBrowser()


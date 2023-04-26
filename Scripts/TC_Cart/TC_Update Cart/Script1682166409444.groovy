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
import org.assertj.core.api.StringAssert as StringAssert
import org.openqa.selenium.Keys as Keys

CustomKeywords.'OpenBrowser.initBrowser'()

WebUI.click(findTestObject('Page_HomePage/a_Log in'))

CustomKeywords.'Keyword_Helper.login'('nhl@gmail.com', '123456')

WebUI.click(findTestObject('Page_HomePage/a_HTC One M8 Android L 5.0 Lollipop'))

WebUI.click(findTestObject('Page_ProductDetail/button_Add to cart'))

WebUI.click(findTestObject('Page_HomePage/button_shopping cart_close'))

WebUI.click(findTestObject('Page_HomePage/a_Shopping cart'))

originalQuantity = WebUI.getAttribute(findTestObject('Page_Cart/input_quantity', [('i') : '1']), 'value')

newQuantity = ((Integer.parseInt(originalQuantity) + 1) + '')

CustomKeywords.'Keyword_Helper.clearsendKeys'(findTestObject('Page_Cart/input_quantity', [('i') : '1']), newQuantity)

WebUI.click(findTestObject('Page_Cart/button_Update cart'))

//if (WebUI.verifyElementVisible(findTestObject('Page_Cart/lbl_message quantity error'))) {
//    assert WebUI.getText(findTestObject('Page_Cart/lbl_message quantity error')).contains('The maximum quantity allowed for purchase is ') == 
//    true
//} else {
assert WebUI.getAttribute(findTestObject('Page_Cart/input_quantity', [('i') : '1']), 'value') == newQuantity

//}
WebUI.closeBrowser()


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

CustomKeywords.'Keyword_Helper.login'('nhl@gmail.com', '123456')

WebUI.click(findTestObject('Page_HomePage/a_HTC One M8 Android L 5.0 Lollipop'))

WebUI.setText(findTestObject('Page_ProductDetail/input_Quantity'), '-1')

WebUI.click(findTestObject('Page_ProductDetail/button_Add to cart'))

WebUI.verifyElementText(findTestObject('Page_ProductDetail/div_bar-notification error'), 'Quantity should be positive')

WebUI.setText(findTestObject('Page_ProductDetail/input_Quantity'), '1000000')

WebUI.click(findTestObject('Page_ProductDetail/button_Add to cart'))

WebUI.verifyElementText(findTestObject('Page_ProductDetail/div_bar-notification error'), 'The maximum quantity allowed for purchase is 10000.')

WebUI.setText(findTestObject('Page_ProductDetail/input_Quantity'), 'hjh')

WebUI.click(findTestObject('Page_ProductDetail/button_Add to cart'))

WebUI.verifyElementText(findTestObject('Page_ProductDetail/div_bar-notification error'), 'Quantity should be positive')

WebUI.closeBrowser()


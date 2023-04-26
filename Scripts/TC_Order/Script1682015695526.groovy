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

WebUI.click(findTestObject('Object Repository/Page_HomePage/a_Log in'))

CustomKeywords.'Keyword_Helper.login'('nhl@gmail.com', '123456')

CustomKeywords.'Keyword_Helper.addAddress'("Luyen", "Nguyen", "nhl@gmail.com", "Viet Nam", "Ha Noi", "Dong Anh", "111", "032648445")


WebUI.click(findTestObject('Page_HomePage/a_Shopping cart'))

WebUI.click(findTestObject('Page_Shopping Cart/input_You will earn_termsofservice'))

WebUI.click(findTestObject('Page_Shopping Cart/button_Checkout'))

WebUI.click(findTestObject('Page_Checkout/button_ContinueAddress'))

WebUI.click(findTestObject('Page_Checkout/input_shippingoption', [('index') : '1']))

WebUI.click(findTestObject('Page_Checkout/button_ContinueShippingMethod'))

WebUI.click(findTestObject('Page_Checkout/input_paymentmethod', [('index') : '0']))

WebUI.click(findTestObject('Page_Checkout/button_ContinuePaymentMethod'))

WebUI.click(findTestObject('Page_Checkout/button_ContinuePaymentInfo'))

WebUI.click(findTestObject('Page_Checkout/button_Confirm'))

WebUI.click(findTestObject('Page_Checkout/a_Click view order'))

WebUI.closeBrowser()


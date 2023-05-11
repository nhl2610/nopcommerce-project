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

CustomKeywords.'Keyword_Helper.login'('james_pan@nopCommerce.com', '123456')

WebUI.click(findTestObject('Page_HomePage/a_My account'))

WebUI.click(findTestObject('Page_Account/a_menu Address'))

WebUI.click(findTestObject('Page_Account Address/button_Edit'))

CustomKeywords.'Keyword_Helper.addAddress'('', '', '', '', '', '', '', '')

WebUI.click(findTestObject('Page_Account Address/button_Save'))

WebUI.delay(2)

expected = WebUI.getText(findTestObject('Object Repository/Page_Account Address/span_First name is required'))

assert expected.contains("First name is required.") == true

expected = WebUI.getText(findTestObject('Object Repository/Page_Account Address/span_Last name is required'))

assert expected.contains("Last name is required.") == true

expected = WebUI.getText(findTestObject('Object Repository/Page_Account Address/span_Email is required'))

assert expected.contains("Email is required.") == true

expected = WebUI.getText(findTestObject('Object Repository/Page_Account Address/span_City is required'))

assert expected.contains("City is required") == true

expected = WebUI.getText(findTestObject('Object Repository/Page_Account Address/span_Street address is required'))

assert expected.contains("Street address is required") == true

expected = WebUI.getText(findTestObject('Object Repository/Page_Account Address/span_Zip  postal code is required'))

assert expected.contains("Zip / postal code is required") == true

expected = WebUI.getText(findTestObject('Object Repository/Page_Account Address/span_Phone is required'))

assert expected.contains("Phone is required") == true

WebUI.closeBrowser()

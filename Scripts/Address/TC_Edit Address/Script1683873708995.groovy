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

WebUI.click(findTestObject('Page_HomePage/a_My account'))

WebUI.click(findTestObject('Page_Account/a_menu Address'))

WebUI.click(findTestObject('Page_Account Address/button_Edit'))

CustomKeywords.'Keyword_Helper.addAddress'(firstname, lastname, email, country, city, address, zipcode, phone)

WebUI.click(findTestObject('Page_Account Address/button_Save'))

WebUI.delay(2)

WebUI.click(findTestObject('Page_Account Address/span_My account_close'))

expected = WebUI.getText(findTestObject('Page_Account Address/li_InfoEmail'))

assert expected.contains(email) == true

expected = WebUI.getText(findTestObject('Page_Account Address/li_InfoPhone'))

assert expected.contains(phone) == true

expected = WebUI.getText(findTestObject('Page_Account Address/li_InfoAddress1'))

assert expected.contains(address) == true

expected = WebUI.getText(findTestObject('Page_Account Address/li_InfoCityZipcode'))

assert expected.contains(zipcode) == true

assert WebUI.getText(findTestObject('Page_Account Address/li_InfoCountry')).contains(country) == true

WebUI.closeBrowser()


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
//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

CustomKeywords.'OpenBrowser.initBrowser'()

WebUI.click(findTestObject('Page_HomePage/a_Log in'))

WebUI.verifyElementVisible(findTestObject('Page_Login/strong_LoginTitle'))

WebUI.setText(findTestObject('Page_Login/input_Email'), email)

WebUI.setText(findTestObject('Page_Login/input_Password'), password)

WebUI.click(findTestObject('Page_Login/button_Login'))

if(id.equals("1"))
{
	expected = WebUI.getText(findTestObject('Page_Login/lbl_emailError'))
	WebUI.verifyMatch(expected, 'Please enter your email', false)
}

if(id.equals("2"))
	{
		expected = WebUI.getText(findTestObject('Page_Login/lbl_Login was unsuccessful'))
		assert expected.contains('Please enter your password') == true
	}

if(id.equals("3"))
{
	expected = WebUI.getText(findTestObject('Page_Login/lbl_emailError'))
	WebUI.verifyMatch(expected, 'Wrong email', false)
}

if(id.equals("4"))
{
	expected = WebUI.getText(findTestObject('Page_Login/lbl_Login was unsuccessful'))
	assert expected.contains('Login was unsuccessful. Please correct the errors and try again.') == true
	assert expected.contains('The credentials provided are incorrect') == true
}

if(id.equals("5"))
{
	expected = WebUI.getText(findTestObject('Page_Login/lbl_Login was unsuccessful'))
	assert expected.contains('Login was unsuccessful. Please correct the errors and try again.') == true
	assert expected.contains('No customer account found') == true
//	WebUI.verifyMatch(expected, 'No customer account found', false)
}
			
if(id.equals("6"))
{
	WebUI.click(findTestObject('Page_HomePage/a_My account'))
	expected = WebUI.getAttribute(findTestObject('Page_Account/input_Email'), 'value')
	WebUI.verifyMatch(expected, email, false)
}

WebUI.closeBrowser()


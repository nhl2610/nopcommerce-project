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

WebUI.click(findTestObject('Page_HomePage/a_Register'))

CustomKeywords.'Keyword_Helper.register'(firstname, lastname, email, password, confirmpassword)

if (id.equals('1')) {
    expected = WebUI.getText(findTestObject('Page_Register/span_FirstNameError'))

    WebUI.verifyMatch(expected, 'First name is required.', false)
}

if (id.equals('2')) {
    expected = WebUI.getText(findTestObject('Page_Register/span_LastNameError'))

    WebUI.verifyMatch(expected, 'Last name is required.', false)
}

if (id.equals('3')) {
    expected = WebUI.getText(findTestObject('Page_Register/span_EmailError'))

    assert expected.contains('Email is required.') == true
}

if (id.equals('4')) {
    expected = WebUI.getText(findTestObject('Page_Register/span_PasswordError'))

    assert expected.contains('Password is required.') == true
}

if (id.equals('5')) {
    expected = WebUI.getText(findTestObject('Page_Register/span_ConfirmPasswordError'))

    assert expected.contains('Password is required.') == true
}

if (id.equals('6')) {
    expected = WebUI.getText(findTestObject('Page_Register/span_EmailExistError'))

    WebUI.verifyMatch(expected, 'The specified email already exists', false)
}

if (id.equals('7')) {
    expected = WebUI.getText(findTestObject('Page_Register/span_EmailError'))

    WebUI.verifyMatch(expected, 'Wrong email', false)
}

if (id.equals('8')) {
    expected = WebUI.getText(findTestObject('Page_Register/span_PasswordError'))

    assert expected.contains('Password must meet the following rules:') == true

    assert expected.contains('must have at least 6 characters') == true
}

if (id.equals('9')) {
    expected = WebUI.getText(findTestObject('Page_Register/span_ConfirmPasswordError'))

    assert expected.contains('The password and confirmation password do not match.') == true
}

if (id.equals('10')) {
    expected = WebUI.getText(findTestObject('Page_Register/lbl_RegisterResult'))

    WebUI.verifyMatch(expected, 'Your registration completed', false)

    WebUI.click(findTestObject('Page_Register/a_Continue'))
}

WebUI.closeBrowser()


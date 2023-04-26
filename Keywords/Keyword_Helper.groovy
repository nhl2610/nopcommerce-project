import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import java.util.Random;

public class Keyword_Helper {
	@Keyword
	def login(String email, String password) {
		WebUI.setText(findTestObject('Object Repository/Page_Login/input_Email'), email)

		WebUI.setText(findTestObject('Object Repository/Page_Login/input_Password'), password)

		WebUI.click(findTestObject('Object Repository/Page_Login/button_Login'))
	}

	@Keyword
	def register(String firstname, String lastname, String email, String password, String confirmpassword) {
		WebUI.setText(findTestObject('Object Repository/Page_Register/input_FirstName'), firstname)

		WebUI.setText(findTestObject('Object Repository/Page_Register/input_LastName'), lastname)

		WebUI.setText(findTestObject('Page_Register/input_Email'), email)

		WebUI.setText(findTestObject('Page_Register/input_Password'), password)

		WebUI.setText(findTestObject('Page_Register/input_ConfirmPassword'), confirmpassword)

		WebUI.click(findTestObject('Object Repository/Page_Register/button_Register'))
	}

	@Keyword
	def clearsendKeys(TestObject obj, String value) {
		WebUI.clearText(obj)
		WebUI.sendKeys(obj, value)
	}

	@Keyword
	def addAddress(String firstname, String lastname, String email, String country, String city, String address, String zipcode, String phone) {

		WebUI.clearText(findTestObject('Page_Account Address/input_Address.First name'))

		WebUI.sendKeys(findTestObject('Page_Account Address/input_Address.First name'), firstname)


		WebUI.clearText(findTestObject('Page_Account Address/input_Address.Last name'))

		WebUI.sendKeys(findTestObject('Page_Account Address/input_Address.Last name'), lastname)


		WebUI.clearText(findTestObject('Page_Account Address/input_Address.Email'))

		WebUI.sendKeys(findTestObject('Page_Account Address/input_Address.Email'), email)

		if(country != "") WebUI.selectOptionByLabel(findTestObject('Page_Account Address/select_Select country'), country, true)


		WebUI.clearText(findTestObject('Page_Account Address/input_Address.City'))

		WebUI.sendKeys(findTestObject('Page_Account Address/input_Address.City'), city)


		WebUI.clearText(findTestObject('Page_Account Address/input_Address.Address1'))

		WebUI.sendKeys(findTestObject('Page_Account Address/input_Address.Address1'), address)


		WebUI.clearText(findTestObject('Page_Account Address/input_Address.ZipPostalCode'))

		WebUI.sendKeys(findTestObject('Page_Account Address/input_Address.ZipPostalCode'), zipcode)


		WebUI.clearText(findTestObject('Page_Account Address/input_Address.PhoneNumber'))

		WebUI.sendKeys(findTestObject('Page_Account Address/input_Address.PhoneNumber'), phone)

		WebUI.click(findTestObject('Page_Account Address/button_Save'))
	}

	@Keyword
	def randomNumber(int low, int high) {
		Random rand = new Random();
		return rand.nextInt(high-low) + low;
	}
}

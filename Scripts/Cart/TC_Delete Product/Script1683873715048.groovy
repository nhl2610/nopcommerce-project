import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import org.openqa.selenium.WebElement
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
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement as Keys


CustomKeywords.'OpenBrowser.initBrowser'()

WebUI.click(findTestObject('Page_HomePage/a_Log in'))

CustomKeywords.'Keyword_Helper.login'('arthur_holmes@nopCommerce.com', '123456')

WebUI.click(findTestObject('Page_HomePage/a_Shopping cart'))

productRemoveName = WebUI.getText(findTestObject('Page_Shopping Cart/Page_Products In Cart/a_ProductName', [('index') : '1']))

WebUI.click(findTestObject('Page_Shopping Cart/Page_Products In Cart/button_remove', [('index') : '1']))

List<WebElement> listNameObj = WebUI.findWebElements(findTestObject('Page_Shopping Cart/Page_Products In Cart/span_listName'), 5)

for (int i = 0;  i < listNameObj.size(); ++i) {
	if(listNameObj.get(i).getText().equals(productRemoveName)) assert false;
}

WebUI.closeBrowser()


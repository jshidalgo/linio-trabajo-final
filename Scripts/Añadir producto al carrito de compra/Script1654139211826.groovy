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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.linio.com.co/p/celular-apple-iphone-13-128gb-4gb-a15-bionic-ca-mara-12mpx-negro-s2dmf1')

WebUI.click(findTestObject('Object Repository/Page_Celular Apple iPhone 13 128gb 4gb A15 _b1f679/button_Aadir al carrito'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Celular Apple iPhone 13 128gb 4gb A15 _b1f679/div_Tu producto se agreg al carrito        _eccef0'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Celular Apple iPhone 13 128gb 4gb A15 _b1f679/h2_Tu producto se agreg al carrito'), 
    'Tu producto se agregó al carrito')


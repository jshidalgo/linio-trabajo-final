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

WebUI.navigateToUrl('https://www.linio.com.co/p/producto-portatil-asus-x543ua-gq3521-core-i5-8250u-ram-8gb-512gb-ssd-endless-lg4yae?qid=113946787a4dfeeff86059d2c3d3cd4d&oid=AS005EL1DX7JPLCO&position=1&sku=AS005EL1DX7JPLCO')

WebUI.click(findTestObject('Object Repository/Page_Celular Apple iPhone 13 128gb 4gb A15 _b1f679/button_Aadir al carrito'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Celular Apple iPhone 13 128gb 4gb A15 _b1f679/div_Tu producto se agreg al carrito        _eccef0'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Celular Apple iPhone 13 128gb 4gb A15 _b1f679/h2_Tu producto se agreg al carrito'), 
    'Tu producto se agregó al carrito')

WebUI.navigateToUrl('https://www.linio.com.co/p/cafetera-nespresso-inissia-negra-ld6mjg?qid=19a7a166b883689dcfff4433c4bd85ad&oid=NE295HL1GO5F5LCO&position=2&sku=NE295HL1GO5F5LCO')

WebUI.click(findTestObject('Object Repository/Page_Celular Apple iPhone 13 128gb 4gb A15 _b1f679/button_Aadir al carrito'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Celular Apple iPhone 13 128gb 4gb A15 _b1f679/div_Tu producto se agreg al carrito        _eccef0'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Celular Apple iPhone 13 128gb 4gb A15 _b1f679/h2_Tu producto se agreg al carrito'), 
    'Tu producto se agregó al carrito')


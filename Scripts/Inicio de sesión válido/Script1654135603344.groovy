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

WebUI.navigateToUrl(GlobalVariable.url)

WebUI.callTestCase(findTestCase('sucripción oferta'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/span_Iniciar Sesin'))

WebUI.click(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/a_Iniciar sesin'))

WebUI.setText(findTestObject('Object Repository/Page_Compra Online los mejores productos al_df3ae1/input_Email_login_formemail'), 
    GlobalVariable.user)

WebUI.setText(findTestObject('Object Repository/Page_Compra Online los mejores productos al_df3ae1/input_Contrasea_login_formpassword'), 
    GlobalVariable.pwd)

WebUI.click(findTestObject('Object Repository/Page_Compra Online los mejores productos al_df3ae1/button_Iniciar sesin segura'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/span_Jon steven'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/span_Jon steven'), 
    GlobalVariable.user_name)


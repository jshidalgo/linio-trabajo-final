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

'Se hace uso de este caso de prueba como pre-requisto '
WebUI.callTestCase(findTestCase('Añadir producto al carrito de compra'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://www.linio.com.co/cart')

WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/a_Aplicar cupn'))

WebUI.setText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/input_Aplicar cupn_form-control form-contro_0c466b'), 
    'micuponn invalido 564')

WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/button_Aplicar'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Colombia - Carrito de compras/div_Lo sentimos, no reconocemos el cupn, re_c9088c'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/div_Lo sentimos, no reconocemos el cupn, re_e75d3e'), 
    'Lo sentimos, no reconocemos el cupón, revisa de nuevo el código introducido.')

WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/button_Cerrar'))


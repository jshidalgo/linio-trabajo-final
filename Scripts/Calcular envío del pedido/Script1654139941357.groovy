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

WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/a_Calcular envo'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Colombia - Carrito de compras/select_Seleccione un DepartamentoAmazonasAn_208eca'), 
    'Quindio', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Colombia - Carrito de compras/select_Seleccione un MunicpioArmeniaBuenavi_7ca3fc'), 
    'Armenia', true)

WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/button_Calcular'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/span_Envo gratis'), 'Envío gratis')


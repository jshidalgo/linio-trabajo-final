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

//precio del producto a eliminar
product_price_txt = WebUI.getText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/div_4.089.900')).substring(1).replace('.','')
product_price_int = product_price_txt.toInteger()

//precio total en el carrito de compras antes de eliminar el producto
cart_current_amount_txt = WebUI.getText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/span_4.089.900')).substring(1).replace('.','')
cart_current_amount_int = cart_current_amount_txt.toInteger()

WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/a_Eliminar'))

//precio total en el carrito de compras
cart_amount_txt = WebUI.getText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/span_4.089.900')).substring(1).replace('.','')
cart_amount_int = cart_amount_txt.toInteger()


//verificar el descuento del producto
if (product_price_int - cart_current_amount_int == cart_amount_int) {
	assert true
}else {
	assert false
}


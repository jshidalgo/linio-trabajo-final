package scripts

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

public class Product {
	
	/**
	 * Permite agregar un producto al carrito de compras
	 * se espera estar en la detalle del producto
	 * @param product_name - nombre completo del producto
	 * @return
	 */
	@Keyword
	def addToCart(String product_name) {
		WebUI.waitForPageLoad(40)
		
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/product_detail_title'), product_name)
		
		WebUI.click(findTestObject('Object Repository/Page_Celular Apple iPhone 13 128gb 4gb A15 _b1f679/button_Aadir al carrito'))
		
		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Celular Apple iPhone 13 128gb 4gb A15 _b1f679/div_Tu producto se agreg al carrito        _eccef0'),
			0)
		
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Celular Apple iPhone 13 128gb 4gb A15 _b1f679/h2_Tu producto se agreg al carrito'),
			'Tu producto se agregó al carrito')
		
	}
}

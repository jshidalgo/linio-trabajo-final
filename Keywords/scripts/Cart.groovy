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

public class Cart {
	
	/**
	 * Permite eliminar el primer producto de un carrito de compras
	 * @return
	 */
	@Keyword
	def removeFisrtProduct() {
		//precio del carrito sin eliminar el producto
		Integer cart_current_amount = getTotalCartAmount()
		
		//precio del producto a eliminar
		String product_price_str = WebUI.getText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/first_cart_item_price')).substring(1).replace('.','')
		Integer product_price = product_price_str.toInteger()
		
		WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/a_Eliminar'))
	
		//verificar el descuento del producto
		assert (cart_current_amount - product_price) == getTotalCartAmount()
		
	}
	
	/**
	 * Permite guardar para despues el primer producto de un carrito de compras
	 * @return
	 */
	@Keyword
	def saveFirstProductForLater() {
		//texto del producto a mover
		String producto_title = WebUI.getText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/first_cart_item_title'))
		
		//precio del producto a mover
		String product_price_str = WebUI.getText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/first_cart_item_price')).substring(1).replace('.','')
		Integer product_price = product_price_str.toInteger()
		
		//precio total en el carrito de compras antes de eliminar el producto
		Integer cart_current_amount = getTotalCartAmount()
		
		WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/a_Guardar para despus'))
		
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/first_later_product_title'),
			producto_title)
		
		
		//verificar el descuento del producto
		assert (cart_current_amount - product_price) == getTotalCartAmount()
	}
	
	/**
	 * Permite verificar que un cupon invalido no es aplicado
	 * @param invalid_cupon
	 * @return
	 */
	@Keyword
	def applyInvalidCoupon(String invalid_cupon) {
		//precio del carrito sin aplicar cupon
		Integer cart_current_amount = getTotalCartAmount()
		
		WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/a_Aplicar cupn'))
		
		WebUI.setText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/input_Aplicar cupn_form-control form-contro_0c466b'),
			invalid_cupon)
		
		WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/button_Aplicar'))
		
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Colombia - Carrito de compras/div_Lo sentimos, no reconocemos el cupn, re_c9088c'),
			0)
		
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/div_Lo sentimos, no reconocemos el cupn, re_e75d3e'),
			'Lo sentimos, no reconocemos el cupón, revisa de nuevo el código introducido.')
		
		WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/button_Cerrar'))
		
		//verificar valor total del carrito
		assert cart_current_amount == getTotalCartAmount()
	}
	
	def calculateFreeShipping(String department, String city) {
		WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/a_Calcular envo'))
		
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Colombia - Carrito de compras/select_Seleccione un DepartamentoAmazonasAn_208eca'),
			department, true)
		
		WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Colombia - Carrito de compras/select_Seleccione un MunicpioArmeniaBuenavi_7ca3fc'),
			city, true)
		
		WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/button_Calcular'))
		
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/span_Envo gratis'), 'Envío gratis')
	}
	
	/**
	 * Permite obtener el precio total de los productos del carrito
	 * @return Integer
	 */
	def private getTotalCartAmount() {
		String cart_current_amount = WebUI.getText(findTestObject('Object Repository/Page_Colombia - Carrito de compras/span_4.089.900')).substring(1).replace('.','')
		return cart_current_amount.toInteger()	
	}
}

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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Search {
	
	/**
	 * Permite realiza la busqueda de un producto por la barra de busqueda de la pagina
	 * la validacion se realiza en la primera pagina de resultados
	 * @param search_text - texto de busqueda
	 * @param product_title - texto completo del nombre del producto (con este texto se realiza la validacion de la busqueda)
	 * @return
	 */
	@Keyword
	def barSearch(String search_text, String product_title) {
		WebUI.setText(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/input_Iniciar sesin_q'),
			search_text)
		
		WebUI.click(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/span_Iniciar sesin_icon icon-inverse icon-search'))
		
		isProductPresent(product_title)
	}
	
	/**
	 * Permite verificar que haya una navegacion correcta hacia una categoria
	 * @param categorie
	 * @param expected_title
	 * @return
	 */
	@Keyword
	def searchByCategory(String categorie, String expected_title) {
		WebUI.mouseOver(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/div_Iniciar sesin_icon icon-hamburger'))
		
		////div[@id='main-menu']//span[(text() = 'Belleza' )]
		//instancia del objeto
		TestObject tObj = new TestObject()
		//se busca el objeto por su xpath donde es ubicado por su nombre completo
		tObj.addProperty("xpath", ConditionType.EQUALS, "//div[@id='main-menu']//span[(text() = '"+categorie+"' )]")
		
		WebUI.click(tObj)
		
		WebUI.waitForPageLoad(60)
		
		WebUI.scrollToElement(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/result_categorie_title'), 0)
		
		WebUI.verifyElementText(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/result_categorie_title'), expected_title)
		
	}
	
	/**
	 * Pemite verificar su un producto esta en la lista de productos
	 * @param product_title - texto completo del nombre del producto (con este texto se realiza la validacion de la busqueda)
	 * @return
	 */
	@Keyword
	def isProductPresent(String product_title) {
		//instancia del objeto
		TestObject tObj = new TestObject()
		//se busca el objeto por su xpath donde es ubicado por su nombre completo
		tObj.addProperty("xpath", ConditionType.EQUALS, "//div[@id='catalogue-product-container']/div/a/div[2]/p/span[(text() = '" + product_title + "')]")
		
		WebUI.verifyElementPresent(tObj, 30)
	}
}

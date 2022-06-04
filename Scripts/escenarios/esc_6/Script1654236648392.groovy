import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.stream.Collectors

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String folder = CustomKeywords.'scripts.Utils.getFolderName'('escenario-6')

CustomKeywords.'scripts.Utils.openHomaPage'()

CustomKeywords.'scripts.Utils.takeScreenshot'('step_1', folder)


//quitar alerta que no permite continuar con el flujo
WebUI.delay(15)
WebUI.click(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/button_Por ahora no'), FailureHandling.OPTIONAL)


//data driven de busqueda de 15 productos
//listado de productos
TestData product = findTestData('productos')
List<String> productList = product.getAllData().stream()
	.map{data -> data}
	.collect(Collectors.toList())
	
//recorrido de los productos
int i = 0


for(def productName : productList){
	
	String product_name = productName[1].length() <= 30 ? productName[1] :  productName[1].substring(0, 30)

	String product_search = productName[0]
	
	CustomKeywords.'scripts.Search.barSearch'(product_search, product_name)
	
	CustomKeywords.'scripts.Utils.takeScreenshot'('step_2.' + i , folder)
	
	//instancia del objeto
	TestObject tObj = new TestObject()
	//se busca el objeto por su xpath donde es ubicado por su nombre completo
	tObj.addProperty("xpath", ConditionType.EQUALS, "//div[@id='catalogue-product-container']/div/a/div[2]/p/span[(contains(text() , '" + product_name + "'))]")
	
	WebUI.click(tObj)
	
	CustomKeywords.'scripts.Utils.takeScreenshot'('step_3.' + i, folder)
	
	CustomKeywords.'scripts.Product.addToCartUnverifiedTitle'()
	
	CustomKeywords.'scripts.Utils.takeScreenshot'('step_4.' + i, folder)
	
	WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/button_Seguir comprando'))
	
	i++
}


WebUI.closeBrowser()
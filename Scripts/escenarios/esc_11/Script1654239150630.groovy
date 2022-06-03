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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String folder = CustomKeywords.'scripts.Utils.getFolderName'('escenario-11')

CustomKeywords.'scripts.Utils.openHomaPage'()

CustomKeywords.'scripts.Utils.takeScreenshot'('step_10', folder)

String product_title = 'iPhone 11 128GB Negro Desbloqueado'

CustomKeywords.'scripts.Search.barSearch'('iphone 11', product_title)

CustomKeywords.'scripts.Utils.takeScreenshot'('step_2', folder)

//instancia del objeto
TestObject tObj = new TestObject()
//se busca el objeto por su xpath donde es ubicado por su nombre completo
tObj.addProperty("xpath", ConditionType.EQUALS, "//div[@id='catalogue-product-container']/div/a/div[2]/p/span[(text() = '" + product_title + "')]")

WebUI.click(tObj)

CustomKeywords.'scripts.Utils.takeScreenshot'('step_3', folder)

CustomKeywords.'scripts.Product.addToCart'(product_title)

CustomKeywords.'scripts.Utils.takeScreenshot'('step_4', folder)

WebUI.navigateToUrl('https://www.linio.com.co/cart')

CustomKeywords.'scripts.Utils.takeScreenshot'('step_5', folder)

CustomKeywords.'scripts.Cart.calculateFreeShipping'('Quindio', 'Armenia')

WebUI.click(findTestObject('Object Repository/Page_Colombia - Carrito de compras/a_Calcular envo'))

CustomKeywords.'scripts.Utils.takeScreenshot'('step_6', folder)

WebUI.closeBrowser()
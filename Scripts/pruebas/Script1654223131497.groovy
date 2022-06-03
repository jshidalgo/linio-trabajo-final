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

CustomKeywords.'scripts.Utils.openHomaPage'()

//CustomKeywords.'scripts.Login.invalidLogin'('lasda@mail.com', 'miconta321')
//CustomKeywords.'scripts.Search.barSearch'('iphone 11', 'iPhone 11 128GB Negro Desbloqueado')
//CustomKeywords.'scripts.Search.searchByCategory'('Belleza', 'BELLEZA Y CUIDADO PERSONAL')

WebUI.navigateToUrl('https://www.linio.com.co/p/cafetera-nespresso-inissia-negra-ld6mjg?qid=19a7a166b883689dcfff4433c4bd85ad&oid=NE295HL1GO5F5LCO&position=2&sku=NE295HL1GO5F5LCO')
CustomKeywords.'scripts.Product.addToCart'('Cafetera Nespresso Inissia Negra')

WebUI.navigateToUrl('https://www.linio.com.co/p/porta-til-asus-m415da-r3-12g-ram-256ssd-14-hd-gris-yku88i?qid=b8024b44b6b007f56ce19a97fe26daab&oid=AS005EL05N2CLLCO&position=4&sku=AS005EL05N2CLLCO')
CustomKeywords.'scripts.Product.addToCart'('Portátil Asus M415DA R3 12G Ram 256SSD 14 HD Gris')

WebUI.navigateToUrl('https://www.linio.com.co/cart')

//CustomKeywords.'scripts.Cart.removeFisrtProduct'()
CustomKeywords.'scripts.Cart.calculateFreeShipping'('Quindio', 'Armenia')

WebUI.closeBrowser()


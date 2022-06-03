package scripts
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class Utils {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	/**
	 * Permite abrir la pagina de inicio
	 * @return
	 */
	@Keyword
	def openHomaPage() {
		WebUI.openBrowser(GlobalVariable.url)
		WebUI.maximizeWindow()
		WebUI.waitForPageLoad(40)

		closeSubscribeModal()

		//		WebUI.verifyAllLinksOnCurrentPageAccessible(false, null)
	}

	/**
	 * Permite cerrar el modal de suscripcion a ofertas
	 * @return
	 */
	@Keyword
	def private closeSubscribeModal() {
		WebUI.click(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/subscribe_modal_close_btn'))
	}

	/**
	 * Permite tomar una captura de pantalla
	 * @param file_name - nombre del archivo
	 * @param folder - ubicacion de la captura
	 * @return
	 */
	def takeScreenshot(String file_name, String folder) {
		String temp = 'Tests Screenshots/' + folder + '/' + file_name +'.png'
		WebUI.takeScreenshot(temp)
	}
	
	/**
	 * Permite obtener el nombre de una carpeta con la fecha y hora 
	 * @param name - nombre de la capeta
	 * @return
	 */
	def getFolderName(String name) {
		Date date = new Date()
		String datePart = date.format("yyyy-MM-dd")
		String timePart = date.format("HH-mm-ss")
		
		return name+ '_' + datePart + '_' + timePart
	}
}
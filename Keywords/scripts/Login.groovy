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

public class Login {

	/**
	 * Permite realizar un inicio de sesion valido 
	 * @return
	 */
	@Keyword
	def successfulLogin() {

		WebUI.mouseOver(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/span_Iniciar Sesin'))

		WebUI.click(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/a_Iniciar sesin'))

		WebUI.setText(findTestObject('Object Repository/Page_Compra Online los mejores productos al_df3ae1/input_Email_login_formemail'),
				GlobalVariable.user)

		WebUI.setText(findTestObject('Object Repository/Page_Compra Online los mejores productos al_df3ae1/input_Contrasea_login_formpassword'),
				GlobalVariable.pwd)

		WebUI.click(findTestObject('Object Repository/Page_Compra Online los mejores productos al_df3ae1/button_Iniciar sesin segura'))

		WebUI.delay(1)

		veryLoggedUserName()
	}

	/**
	 * Permite verifica un intento de inicio de sesion con usaurio correcto y clave invalida
	 * @param user
	 * @param password
	 * @return
	 */
	@Keyword
	def invalidLogin(String user, String password) {
		WebUI.mouseOver(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/span_Iniciar Sesin'))

		WebUI.click(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/a_Iniciar sesin'))

		WebUI.setText(findTestObject('Object Repository/Page_Compra Online los mejores productos al_df3ae1/input_Email_login_formemail'),
				user)

		WebUI.setText(findTestObject('Object Repository/Page_Compra Online los mejores productos al_df3ae1/input_Contrasea_login_formpassword'),
				password)

		WebUI.click(findTestObject('Object Repository/Page_Compra Online los mejores productos al_df3ae1/button_Iniciar sesin segura'))

		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Compra Online los mejores productos al_df3ae1/div_El correo electrnico o la contrasea son_99a33d'),
				10)

		WebUI.verifyElementText(findTestObject('Object Repository/Page_Compra Online los mejores productos al_df3ae1/div_El correo electrnico o la contrasea son_330e50'),
				'El correo electrónico o la contraseña son incorrectas. Vuelve a intentarlo.')
	}

	/**
	 * Permite verificar que el primer nombre del usuario este presente en la barra superior 
	 * @return
	 */
	@Keyword
	def veryLoggedUserName() {

		WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/span_Jon steven'),
				10)

		WebUI.verifyElementText(findTestObject('Object Repository/Page_Linio Colombia - Compra Online con Ofertas/span_Jon steven'),
				GlobalVariable.user_name)
	}
}

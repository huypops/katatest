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
import com.kms.katalon.core.testdata.InternalData as InternalData
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('POPS App/CommonTestCases/OpenForgotPasswordPage'), [:], FailureHandling.STOP_ON_FAILURE)

TestData data = findTestData('Data Files/WrongFormatEmails')

for (def index : (1..data.getRowNumbers())) {
    WebUI.setText(findTestObject('POPS App UI/ForgotPassword_QuenMatKhau/input_Email'), findTestData('WrongFormatEmails').getValue(
            1, index))

    WebUI.click(findTestObject('POPS App UI/ForgotPassword_QuenMatKhau/button_Send'))

    WebUI.verifyElementText(findTestObject('POPS App UI/ForgotPassword_QuenMatKhau/label_ErrorMessage'), 'Email không đúng định dạng. Vui lòng kiểm tra lại.')
}


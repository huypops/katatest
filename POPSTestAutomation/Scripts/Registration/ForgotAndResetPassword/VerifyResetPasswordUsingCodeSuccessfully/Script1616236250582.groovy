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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.StringEscapeUtils as StringEscapeUtils
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Registration/ForgotAndResetPassword/VerifyOpenResetPasswordPageSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('ForgotPassword_QuenMatKhau/input_Email'), GlobalVariable.EMAIL_TO_RESET_PASSWORD + '@mailinator.com')

WebUI.click(findTestObject('ForgotPassword_QuenMatKhau/button_Send'))

WebUI.verifyElementVisible(findTestObject('ToastMessage/ToastMessage_Sucessfull'))

WebUI.verifyElementText(findTestObject('ToastMessage/ToastMessage_Content'), 'Một email đã được gửi đến tài khoản email của bạn! Vui lòng kiểm tra email')

code = CustomKeywords.'commonActions.Mailinator.OpenMailinatorMailboxAndGetCode'(GlobalVariable.EMAIL_TO_RESET_PASSWORD, 
    'Thay đổi mật khẩu tài khoản POPS')

String resetPasswordURL = ('https://pops.vn/auth/forgot-password/reset-password?account=' + GlobalVariable.EMAIL_TO_RESET_PASSWORD) + 
'@mailinator.com'

WebUI.navigateToUrl(resetPasswordURL)

WebUI.sendKeys(findTestObject('ResetPasswordPageUI/input_Code'), code)

WebUI.sendKeys(findTestObject('ResetPasswordPageUI/input_NewPassword'), '12345678')

WebUI.sendKeys(findTestObject('ResetPasswordPageUI/input_ConfirmPassword'), '12345678')

WebUI.click(findTestObject('ResetPasswordPageUI/button_Save'))

WebUI.navigateToUrl(GlobalVariable.SourceURL)

WebUI.click(findTestObject('TopMenu/button_DangNhap'))

WebUI.sendKeys(findTestObject('SignIn_DangNhap/input_Email'), GlobalVariable.EMAIL_TO_RESET_PASSWORD + '@mailinator.com')

WebUI.sendKeys(findTestObject('SignIn_DangNhap/input_Password'), '12345678')

WebUI.click(findTestObject('SignIn_DangNhap/button_DangNhap'))

WebUI.comment('Chỗ này chưa biết checkpoint verify Login successful')


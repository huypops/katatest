import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.SourceURL)

WebUI.click(findTestObject('POPS App UI/TopMenu/menu_5_Them'))

CustomKeywords.'commonActions.CMS_APIs.getCMSPageLayout'('more', 'VN')


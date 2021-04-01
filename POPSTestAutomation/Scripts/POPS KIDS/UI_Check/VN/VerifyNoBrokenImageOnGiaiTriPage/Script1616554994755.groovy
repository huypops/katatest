import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.SourceURL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('POPS KIDS UI/TopMenu/Menu_GiaiTri'))

CustomKeywords.'commonActions.PageActions.verifyURLContains'(GlobalVariable.SourceURL)

CustomKeywords.'commonActions.BaseActions.ScrollToFooter'()

CustomKeywords.'commonActions.PageActions.verifyLinksOnPage'()


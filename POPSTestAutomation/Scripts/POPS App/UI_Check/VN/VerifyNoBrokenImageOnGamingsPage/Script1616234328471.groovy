import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.SourceURL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('POPS App UI/TopMenu/menu_3_Gaming'))

CustomKeywords.'commonActions.BaseActions.ScrollToFooter'()

CustomKeywords.'commonActions.PageActions.verifyLinksOnPage'()


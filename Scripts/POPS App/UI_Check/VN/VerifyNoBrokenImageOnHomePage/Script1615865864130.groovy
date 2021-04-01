import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.SourceURL)

WebUI.maximizeWindow()

CustomKeywords.'commonActions.BaseActions.ScrollToFooter'()

//CustomKeywords.'commonActions.BaseActions.ScrollToEndOfPage'('home', 'home', '100', GlobalVariable.USER_AdultProfileID)
CustomKeywords.'commonActions.PageActions.verifyLinksOnPage'()


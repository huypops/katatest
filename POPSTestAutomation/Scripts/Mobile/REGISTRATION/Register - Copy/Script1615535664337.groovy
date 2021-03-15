import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.internal.PathUtil as PathUtil
import internal.GlobalVariable as GlobalVariable

'Get full directory\'s path of android application'
def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AndroidApp, RunConfiguration.getProjectDir())

LocalDateTime now = LocalDateTime.now()

DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

String nowString = formatter.format(now)

Mobile.startApplication(appPath, true)

CustomKeywords.'pops.comonactions.Registration.registrationByValidEmail'()

Mobile.closeApplication()


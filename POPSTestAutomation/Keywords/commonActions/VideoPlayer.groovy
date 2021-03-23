package commonActions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.image.BufferedImage
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import org.apache.commons.io.FileUtils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class VideoPlayer {
	public ScreenshotDriver screenshotdriver = new ScreenshotDriver()
	
	@Keyword
	public void videoPlayerCheck(TestObject videoframe, int duration) {
		screenshotdriver.setForceSnapshots(true)
		Path projectdir = Paths.get(RunConfiguration.getProjectDir())
		Path datadir = projectdir.resolve('Data Files')
		Path workdir = projectdir.resolve('Data Files/tmp/tc1')
		if (Files.exists(workdir)) {
			FileUtils.deleteDirectory(workdir.toFile())
		}
		Files.createDirectories(workdir)		
		TestObject videosection = videoframe;
		File file = workdir.resolve('videosection.png').toFile()		
		screenshotdriver.saveElementImage(videosection, file);
		WebUI.delay(duration);	
		TestObject videosection1 = videoframe;
		File file1 = workdir.resolve('videosection1.png').toFile()	
		screenshotdriver.saveElementImage(videosection1, file1)
		WebUI.delay(2)
		screenshotdriver.verifyImagesAreDifferent(
			file,
			videosection1,
			50.0,
			workdir.resolve('d').toFile(),
			FailureHandling.CONTINUE_ON_FAILURE)
	}
	
//	@Keyword
//	public void nextVideoByClicking(TestObject nextbutton) {
//		mouseHover(VideoDetailPageUI.VIDEO_FRAME,VideoDetailPageUI.NEXT_BUTTON);
//		scrollElementIntoView(VideoDetailPageUI.NEXT_VIDEO_SECTION,0);
//		String nextvideotext = getTextElemenetsNo(VideoDetailPageUI.NEXT_VIDEO_TITLE,0);
//		clickToElement(VideoDetailPageUI.NEXT_VIDEO_TITLE,0);
//		String currentvideotext=getText(VideoDetailPageUI.CURRENT_VIDEO_TITLE);
//		if(nextvideotext.equalsIgnoreCase(currentvideotext)){
//			return true;
//		}
//	}
	
	@Keyword
	public void nextVideoAutomatic(TestObject nextbutton) {
		
	}
}

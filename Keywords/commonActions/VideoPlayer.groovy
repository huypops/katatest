package commonActions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.image.BufferedImage
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

import org.apache.commons.io.FileUtils
import org.openqa.selenium.By

import com.github.romankh3.image.comparison.ImageComparison
import com.github.romankh3.image.comparison.ImageComparisonUtil
import com.github.romankh3.image.comparison.model.ImageComparisonResult
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import ru.yandex.qatools.ashot.comparison.ImageDiff
import ru.yandex.qatools.ashot.comparison.ImageDiffer


public class VideoPlayer {

	@Keyword
	public void videoPlayerCheck(TestObject videoframe, int duration) {
		ScreenshotDriver.setForceSnapshots(true)
		Path projectdir = Paths.get(RunConfiguration.getProjectDir())
		Path datadir = projectdir.resolve('Data Files')
		Path workdir = projectdir.resolve('Data Files/tmp/tc1')
		if (Files.exists(workdir)) {
			FileUtils.deleteDirectory(workdir.toFile())
		}
		Files.createDirectories(workdir)
		TestObject videosection = videoframe;
		File file = workdir.resolve('videosection.png').toFile()
		ScreenshotDriver.saveElementImage(videosection, file);
		WebUI.delay(duration);
		TestObject videosection1 = videoframe;
		File file1 = workdir.resolve('videosection1.png').toFile()
		ScreenshotDriver.saveElementImage(videosection1, file1)
		WebUI.delay(2)
		ScreenshotDriver.verifyImagesAreDifferent(
				file,
				file1,
				50.0,
				workdir.resolve('d').toFile(),
				FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	public Boolean verifyPlayer(int duration) {
		Path projectdir = Paths.get(RunConfiguration.getProjectDir())
		Path datadir = projectdir.resolve('Data Files')
		Path workdir = projectdir.resolve('Data Files/tmp/tc1')
		if (Files.exists(workdir)) {
			FileUtils.deleteDirectory(workdir.toFile())
		}
		Files.createDirectories(workdir)
		File file = workdir.resolve('ActualmyScreenshot.png').toFile();
		TestObject myWebElement = findTestObject('VideoDetailPageUI/video_frame');
		WebUI.takeElementScreenshot("Data Files/tmp/tc1/ActualmyScreenshot.png",findTestObject('VideoDetailPageUI/video_frame'));

		WebUI.delay(duration);
		File file1 = workdir.resolve('ActualanotherScreenshot.png').toFile();
		WebUI.takeElementScreenshot("Data Files/tmp/tc1/ActualanotherScreenshot.png",findTestObject('VideoDetailPageUI/video_frame'));

		BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources("Data Files/tmp/tc1/ActualmyScreenshot.png");
		BufferedImage actualImage = ImageComparisonUtil.readImageFromResources("Data Files/tmp/tc1/ActualanotherScreenshot.png");
		//Create ImageComparison object and compare the images.
		ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage).compareImages();
		ImageDiff diff = new ImageDiffer().makeDiff(actualImage, expectedImage);
		if (diff.hasDiff() == true) {
			System.out.println("Images are different");
			return true;
		}
		return false;
	}

	@Keyword
	public static Boolean nextVideoByClicking(TestObject object) {
		WebUI.waitForElementPresent(object, 1)
		String currentvideotext = findTestObject('VideoDetailPageUI/CURRENT_VIDEO_TITLE_TEXT');
		WebUI.scrollToElement(findTestObject('VideoDetailPageUI/NEXT_VIDEO_TITLE_TEXT'),0);
		String nextvideotitle = BaseActions.getTextFirstElement(findTestObject('Object Repository/VideoDetailPageUI/NEXT_VIDEO_TITLE_TEXT'), 0)
		WebUI.delay(25);
		WebUI.click(object)
		BaseActions.ClickByJS(findTestObject('Object Repository/VideoDetailPageUI/button_next'),3);
		if(currentvideotext.equalsIgnoreCase(nextvideotitle)){
			return true;
		}
		return false;
	}

	@Keyword
	public void nextVideoAutomatic(TestObject nextbutton) {
	}
}

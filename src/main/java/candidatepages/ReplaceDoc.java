package candidatepages;


import java.awt.Robot;
import testbase.TestBase;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import candidatepages.Login;

public class ReplaceDoc extends TestBase { // code done

	public static void load() throws Exception {
		
		logger = Logger.getLogger(ReplaceDoc.class.getName());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("contentframe");

		getWebElement("uploadIcon").click();

		logger.info("clicking replace doc icon");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("replacedoccontentframe");
		WebDriverWait wait = new WebDriverWait(driver, 30);

		getWebElement("resumeUpload").click();
		logger.info("clicking resume upload icon");
		
		
		// file upload

		Robot robot = new Robot();

		robot.setAutoDelay(2000);

		StringSelection selection = new StringSelection(OR.getProperty("path"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		logger.info("performing resume upload");

		wait = new WebDriverWait(driver, 30);

		getWebElement("iconSave").click();
		logger.info("clicking on save button");
		wait = new WebDriverWait(driver, 30);

		getWebElement("btnClose").click();
		logger.info("closing resume update window");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(5000);
	}

	public static void main(String[] args) throws Exception {
		TestBase.loadPropertiesFile();
		TestBase.getBrowser("chrome");
		Login.run();
		ReplaceDoc.load();
		Logout.out();

	}

}

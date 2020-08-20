package com.framework.qa.uicore.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import static com.framework.qa.uicore.util.Constant.*;
import static com.framework.qa.utils.util.Constant.SCREENSHOT_DESKTOP_PATH;
import static com.framework.qa.utils.util.CoreUtil.captureDesktopScreenshot;

public class CoreUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CoreUtil.class);

    public static void logVerificationError(WebDriver driver, String message, String fileName) {
        LOGGER.error("verification failure: " + message);
        captureDesktopScreenshot("target/" + SCREENSHOT_DESKTOP_PATH + fileName);
        captureHTMLFile(driver, "target/" + HTML_PATH + fileName);
        captureScreenshot(driver, "target/" + SCREENSHOT_BROWSER_PATH + fileName);
        

        Reporter.log("<td>verification failure: " + message + "</td><td>Failed</td><td><a href=\"../" + SCREENSHOT_BROWSER_PATH + fileName + "-browser.png\" target=\"_blank\">browser</a></td><td><a href=\"../" + SCREENSHOT_DESKTOP_PATH + fileName + "-desktop.png\" target=\"_blank\">desktop</a></td><td><a href=\"../" + HTML_PATH + fileName + "-page.html\" target=\"_blank\">page</a></td>");
    }

    public static void captureScreenshot(WebDriver driver, String fileName, WebElement ele) throws IOException {
        new File("target/" + SCREENSHOT_ELEMENT_PATH).mkdirs(); // Insure directory is there
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        //Get the location of element on the page
        org.openqa.selenium.Point point = ele.getLocation();
        //Get width and height of the element
        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();
        //Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
        //Copy the element screenshot to disk
        FileUtils.copyFile(screenshot, new File(fileName + "-element.png"));
    }

    private static void captureHTMLFile(WebDriver driver, String fileName) {
        new File("target/" + HTML_PATH).mkdirs(); // Insure directory is there
        String stored_report = driver.getPageSource();

        File f = new File(fileName + "-page.html");
        FileWriter writer = null;
        try {
            writer = new FileWriter(f, true);
            writer.write(stored_report);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

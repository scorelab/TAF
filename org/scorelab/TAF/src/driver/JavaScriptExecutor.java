package driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptExecutor {

    private final WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaScriptExecutor.class);
    

    public JavaScriptExecutor(WebDriver driver) {
        this.driver = driver;
    }
    
      public static void scrollToView(WebDriver driver, WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        LOGGER.info("[NOTE]: Move Scroll");
    }
     public Object javascriptExecuteAsyncScript(String script, Object args) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        LOGGER.info("[NOTE]: Return AsyncScript With Args");
        return js.executeAsyncScript(script, args);

    }
 
    public Object javascriptExecuteScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        LOGGER.info("[NOTE]: Return Executable External Js Object");
        return js.executeScript(script);
    }

    public Object javascriptExecuteScript(String script, Object args) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            LOGGER.info("[NOTE]: Execute External Js Scripts");
            return js.executeScript(script, args);
        } catch (Throwable e) {
            LOGGER.warn("[NOTE]: Oops ! Some Error.");
            return e;
        }
    }
    
    public Object javascriptExecuteAsyncScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        LOGGER.info("[NOTE]: Return AsyncScript");
        return js.executeAsyncScript(script);
    }

    public static void doMouseScroll(WebDriver driver) {
        JavascriptExecutor jsExecutorScroll = (JavascriptExecutor) driver;
        jsExecutorScroll.executeScript("window.scrollTo(0,document.body.scrollHeight);");
        LOGGER.info("[NOTE]: Mouse Scroll Up");
    }

  
    public static void doMouseScrollUp(WebDriver driver) {
        JavascriptExecutor jsExecutorScrollUp = (JavascriptExecutor) driver;
        jsExecutorScrollUp.executeScript("window.scrollTo(0,document.documentElement.scrollTop);");
        LOGGER.info("[NOTE]: Mouse Scroll Up");
    }
  
  

}
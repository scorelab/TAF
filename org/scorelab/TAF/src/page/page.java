package page;

import org.framework.qa.utils.exception.FrameworkException;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.framework.qa.uicore.verification.Actual;
import static org.framework.qa.uicore.util.CoreUtil.logVerificationError;
import static org.framework.qa.uicore.util.StringUtil.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import static org.framework.qa.uicore.util.Constant.*;
import static org.framework.qa.utils.util.Constant.CONTEXT_MISSING_EXCEPTION;
import static org.framework.qa.utils.util.Constant.NETWORK_FAILURE_EXCEPTION;
import static org.framework.qa.utils.util.CoreUtil.getFileName;
import org.framework.qa.uicore.verification.Expected;
import org.framework.qa.utils.util.FrameworkProperties;
import org.framework.qa.webelementcore.elementbase.core.BaseElement;
import org.relevantcodes.extentreports.ExtentReports;
import org.relevantcodes.extentreports.ExtentTest;
import org.relevantcodes.extentreports.LogStatus;


public class page {

    protected final String FIND_BY = "findBy";
    protected final String VALUE = "value";
    protected final String DEFAULT = "default";
    protected RemoteWebDriver driver;
    protected Actual actual;
    protected Expected expected;
    protected StringBuffer verificationErrors = new StringBuffer();
    protected StringBuffer errorMessage = new StringBuffer();
  
    public PageBase(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public PageBase() {
    }

     public void verifyEquals(boolean actual, boolean expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError var4) {
            logVerificationError(driver, message, getFileName());
            this.errorMessage.append(createVerificationFailMessage(var4.getMessage()));
            this.verificationErrors.append(throwableToString(var4));
        }
    }
    
    public void verifyTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message);
        } catch (AssertionError var3) {
            logVerificationError(driver, message, getFileName());
            this.errorMessage.append(createVerificationFailMessage(var3.getMessage()));
            this.verificationErrors.append(throwableToString(var3));
        }
    }

     public void verifyNotEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError var4) {
            logVerificationError(driver, message, getFileName());
            this.errorMessage.append(createVerificationFailMessage(var4.getMessage()));
            this.verificationErrors.append(throwableToString(var4));
        }
    }

    public void verifyNotEquals(String actual, String expected, String message) {
        try {
            Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError var4) {
            logVerificationError(driver, message, getFileName());
            this.errorMessage.append(createVerificationFailMessage(var4.getMessage()));
            this.verificationErrors.append(throwableToString(var4));
        }
    }

    public void verifyNotEquals(boolean actual, boolean expected, String message) {
        try {
            Assert.assertNotEquals(actual, expected, message);
        } catch (AssertionError var4) {
            logVerificationError(driver, message, getFileName());
            this.errorMessage.append(createVerificationFailMessage(var4.getMessage()));
            this.verificationErrors.append(throwableToString(var4));
        }
    }

    public void verifyFalse(boolean condition, String message) {
        try {
            Assert.assertFalse(condition, message);
        } catch (AssertionError var3) {
            logVerificationError(driver, message, getFileName());
            this.errorMessage.append(createVerificationFailMessage(var3.getMessage()));
            this.verificationErrors.append(throwableToString(var3));
        }
    }

    public void verifyEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError var4) {
            logVerificationError(driver, message, getFileName());
            this.errorMessage.append(createVerificationFailMessage(var4.getMessage()));
            this.verificationErrors.append(throwableToString(var4));
        }
    }

    public void verifyEquals(String actual, String expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError var4) {
            logVerificationError(driver, message, getFileName());
            this.errorMessage.append(createVerificationFailMessage(var4.getMessage()));
            this.verificationErrors.append(throwableToString(var4));
        }
    }

    public void verifyEquals(Collection<?> actual, Collection<?> expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError var4) {
            logVerificationError(driver, message, getFileName());
            this.errorMessage.append(createVerificationFailMessage(var4.getMessage()));
            this.verificationErrors.append(throwableToString(var4));
        }
    }

   
    


}

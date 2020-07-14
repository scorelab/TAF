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

    public void test_step_initiation() {
        Reporter.log("<td> "+Thread.currentThread().getStackTrace()[2].getMethodName()+"</td><td>Started</td><td></td><td></td><td></td>");
    }

    public void check_For_Verification_Errors(){
        checkForVerificationErrors();
    }

    public void clearVerificationErrors() {
        this.verificationErrors = new StringBuffer();
        this.errorMessage = new StringBuffer();
    }

    public void checkForVerificationErrors() {
        String verificationErrorString = this.errorMessage.toString() + "\n" + this.verificationErrors.toString();
        this.clearVerificationErrors();
        if (!"\n".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
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

       protected void initializeElements(BasicPage sourcePage) throws FrameworkException {
        String strDefault = "";
        String strFindBy = "";
        String strValue = "";
        FrameworkProperties loadProperties = new FrameworkProperties();
        LinkedHashMap<String, LinkedHashMap<String, String>> loadDataFromXml = new LinkedHashMap<String, LinkedHashMap<String, String>>();
                     
        for (Field field : sourcePage.getClass().getDeclaredFields()) {
            if (BaseElement.class.isAssignableFrom(field.getType())) {
                loadDataFromXml = (LinkedHashMap<String, LinkedHashMap<String, String>>) loadProperties.readElementsForTagFromFile(ELEMENT_PATH + getSubDirPath(sourcePage.getClass().getPackage().getName().toString()) + "elements.xml", sourcePage.getClass().getSimpleName(), field.getName());

                strFindBy = ((LinkedHashMap<String, String>) loadDataFromXml.get(field.getName())).get(FIND_BY);
                strValue = ((LinkedHashMap<String, String>) loadDataFromXml.get(field.getName())).get(VALUE);
                if (loadDataFromXml.size() == 4) {
                    strDefault = ((LinkedHashMap<String, String>) loadDataFromXml.get(field.getName())).get(DEFAULT);
                }

                field.setAccessible(true);
                BaseElement element = null;

                Constructor constructor = null;
                try {
                    constructor = field.getType().getConstructor(new Class[]{RemoteWebDriver.class, By.class});
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
                    element = (BaseElement) constructor.newInstance(driver, ((By) By.class.getMethod(strFindBy, String.class).invoke(null, strValue)));
                    field.set(sourcePage, element);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }

        public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (!type.getSuperclass().getSimpleName().equalsIgnoreCase("BasicPage")) {
            fields = getAllFields(fields, type.getSuperclass());
        }

        return fields;
    }
        

    }
    


}

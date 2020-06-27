package listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

public class listeners implements ITestListener, ISuiteListener{
    private String strLoggerMsg;
    private String strClassName;
    private static final Logger LOGGER = LoggerFactory.getLogger(TestNGListener.class);
    
     @Override
    public void onStart(ISuite arg0) {
        LOGGER.info("About To Begin Executing Suite : " + arg0.getName());
    }

    @Override
    public void onFinish(ISuite arg0) {
        LOGGER.info("About To End Executing Suite : " + arg0.getName());

    }

     @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("Test '" + result.getName() + "' --- FAILED" + "\n\n\n");
    }

     @Override
    public void onTestStart(ITestResult result) {
        strLoggerMsg = ("Test Started Running: " + "---- " + result.getMethod().getMethodName() + " ---- at:" + result.getStartMillis());
        LOGGER.info(strLoggerMsg);

    }

     @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Test '" + result.getName() + "' --- PASSED" + "\n\n\n");
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.info("Test '" + result.getName() + "' --- SKIPPED" + "\n\n\n");

    }
}

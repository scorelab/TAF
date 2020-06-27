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
}

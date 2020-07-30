package test;

public class test {
    private RemoteWebDriver driver;
    final static Logger log = Logger.getLogger(TestBase.class);

    @BeforeSuite
    public void suiteInitialize(){

    }

    @BeforeMethod(alwaysRun = true)
    public void initializeBaseSetup() throws FrameworkException {
        driver = DriverConnection.getDeriverInstance();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws FrameworkException {
        DriverConnection.closeDriver();
    }

    @AfterSuite
    public void suiteTerminate(){

    }
    public RemoteWebDriver getDriver() {
        return driver;
    }    
}

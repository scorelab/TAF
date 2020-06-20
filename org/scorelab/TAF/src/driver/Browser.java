package driver;

/**
 * Browser.java -  Collection of web browsers enum class
*/

public enum Browser {
    FIREFOX("firefox"), CHROME("chrome"), SAFARI("safari"), EXPLORE("ie"), EDGE("edge");

    private String statusCode;

    private Browser(String s) {
        statusCode = s;
    }

    public String getStatusCode() {
        return statusCode;
    }
}

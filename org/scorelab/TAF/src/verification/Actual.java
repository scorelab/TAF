package verification;

public class Actual {
    private static final Logger LOGGER = LoggerFactory.getLogger(Actual.class);

    private HashMap<String, Object> results = null;

    public Actual() {
        results = new HashMap<String, Object>();
    }

    public void setActualResult(String key, Object value) {

        results.put(key, value);
    }

    public void clearAndSetActualResult(String key, Object value) {
        results.clear();
        results.put(key, value);
    }

    public Map<String, Object> getResults() {

        return results;
    }
}

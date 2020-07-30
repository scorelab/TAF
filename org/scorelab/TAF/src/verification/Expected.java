package com.framework.qa.uicore.verification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Expected {
    private static final Logger LOGGER = LoggerFactory.getLogger(Expected.class);

    private HashMap<String, Object> results = null;

    public Expected() {
        results = new HashMap<String, Object>();
    }

    public void setExpectedResult(String key, Object value) {
        results.put(key, value);
    }

    public void clearAndSetExpectedResult(String key, Object value) {
        results.clear();
        results.put(key, value);
    }

    public Map<String, Object> getResults() {
        return results;
    }

}



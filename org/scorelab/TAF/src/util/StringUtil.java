package util;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

public class StringUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtil.class);

    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int RANDOM_STRING_LENGTH = 10;

    public static String getSubDirPath(String path) {
        String subDirPath = "";

        String[] pkgSize = path.split("\\.");
        for (int i = 0; (pkgSize.length - 6) > i; i++) {
            subDirPath = subDirPath + pkgSize[6 + i] + "/";
        }

        return subDirPath;
    }

    public static String throwableToString(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

    public static String createVerificationFailMessage(String errorMsg) {
        String verificationMsg = null;
        if (errorMsg.contains("expected")) {
            verificationMsg = "\n" + "expected" + errorMsg.split("expected")[1] + " ; message: " + errorMsg.split("expected")[0];
        } else {
            verificationMsg = "\n" + errorMsg;
        }

        return verificationMsg;
    }

    public static String generateRandomStringOnly() {
        String strRandom = RandomStringUtils.randomAlphabetic(6);
        return strRandom;
    }

    public static String generateRandomString() {
        StringBuffer strBfrRandom = new StringBuffer();
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            int intNumber = getRandomNumber();
            char character = CHAR_LIST.charAt(intNumber);
            strBfrRandom.append(character);
        }
        return strBfrRandom.toString();
    }

    public static int getRandomNumber() {
        int intRandom = 0;
        Random rdmGenerator = new Random();
        intRandom = rdmGenerator.nextInt(CHAR_LIST.length());
        if (intRandom - 1 == -1) {
            return intRandom;
        } else {
            return intRandom - 1;
        }
    }
}
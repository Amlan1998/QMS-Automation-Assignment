package utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    // ✅ SAFE LOGGING (THIS IS THE KEY)
    public static void logInfo(String message) {
        try {
            if (test.get() != null) {
                test.get().info(message);
            }
        } catch (Exception e) {
            // DO NOTHING – reporting must never fail a test
        }
    }

    public static void removeTest() {
        test.remove();
    }
}

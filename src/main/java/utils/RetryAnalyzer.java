package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private final int maxRetryCount = 3;

    @Override
    public boolean retry(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE && retryCount < maxRetryCount + 1) {
            retryCount++;
            System.out.println("Retrying test ==> " + result.getName()
                    + "| Attempt ==> " + retryCount + 1);
        }

        return false;
    }
}

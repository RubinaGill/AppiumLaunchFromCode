package testNGListeners;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 3;
    final static Logger logger = Logger.getLogger(Retry.class);

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            logger.info("***********************Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).************************");
            retryCount++;
            return true;
        }
        return false;
    }

    public String getResultStatusName(int status) {
        String resultName = null;
        if (status == 1)
            resultName = "SUCCESS";
        if (status == 2)
            resultName = "FAILURE";
        if (status == 3)
            resultName = "SKIP";
        return resultName;
    }
}

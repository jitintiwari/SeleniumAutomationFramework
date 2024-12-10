package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class CustomListener extends ExtentManager implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("on Test Start - " + iTestResult.getName());
        extentReports.createTest(iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("Taking screenshot at success");
//        try {
//            UtilLibrary.captureScreenshot(iTestResult.getName());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("Taking screenshot at failure");
//        try {
//            UtilLibrary.captureScreenshot(iTestResult.getName());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("on Test Failed But With in Success Percentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("on Start");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("on Finish");
        extentReports.flush();
    }
}

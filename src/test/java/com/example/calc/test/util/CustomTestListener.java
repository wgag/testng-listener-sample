package com.example.calc.test.util;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

public class CustomTestListener implements ITestListener {
    private static final Logger LOGGER = Logger.getLogger(CustomTestListener.class);

    public void onTestStart(ITestResult result) {
        LOGGER.info(String.format(
            "Running: %s#%s(%s)",
            result.getMethod().getTestClass().getName(),
            result.getMethod().getMethodName(),
            Arrays.stream(result.getParameters()).map(x -> x.toString()).collect(Collectors.joining(", "))));
    }

    public void onTestSuccess(ITestResult result) { }
    public void onTestFailure(ITestResult result) { }
    public void onTestSkipped(ITestResult result) { }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }
    public void onStart(ITestContext context) { }
    public void onFinish(ITestContext context) { }
}

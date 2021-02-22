package com.automationdemo.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by IntelliJ IDEA.
 * User: sivaraj
 * Date: 11/2/21
 * Time: 8:03 AM
 * To change this template use File | Settings | File and Code Templates.
 */
public class TestMethodListener implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart called...");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSuccess called...");
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("onTestFailure called...");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped called...");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("onTestFailedButWithinSuccessPercentage called...");
    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart called...");
    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish called...");
    }
}
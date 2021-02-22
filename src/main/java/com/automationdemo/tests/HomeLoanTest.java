package com.automationdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: sivaraj
 * Date: 11/2/21
 * Time: 7:45 AM
 * To change this template use File | Settings | File and Code Templates.
 */
public class HomeLoanTest {

    private void sleepThread()
    {
        try {
            Thread.sleep(20000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test(groups = "PartnerSanity", description = "")
    public void HL_Apply_For_INDIABULLS_Bank_For_Salaried_Employee()
    {
        sleepThread();
        System.out.println("Executed, test-case: HL_Apply_For_INDIABULLS_Bank_For_Salaried_Employee.");
        Assert.fail("Failing this test case");
    }

    @Test(groups = "PartnerSanity", description = "")
    public void HL_Apply_For_Self_Employed_Professional_Through_Slide_Flow() {
        sleepThread();
        System.out.println("Executed, test-case: HL_Apply_For_Self_Employed_Professional_Through_Slide_Flow.");
    }

    @Test(groups = "Regression", description = "")
    public void HL_Submit_Bank_Application_Using_Native_Login() {
        sleepThread();
        System.out.println("Executed, test-case: HL_Submit_Bank_Application_Using_Native_Login.");
    }

    @Test(groups = "Regression", description = "")
    public void HL_Apply_Partner_Apps_In_CoBrand_Sites_For_Salaried() {
        sleepThread();
        System.out.println("Executed, test-case: HL_Apply_Partner_Apps_In_CoBrand_Sites_For_Salaried.");
    }

}
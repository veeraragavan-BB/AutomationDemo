package com.automationdemo.tests;

import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: sivaraj
 * Date: 3/2/21
 * Time: 11:29 AM
 * To change this template use File | Settings | File and Code Templates.
 */
public class CreditCardTest {

    private void sleepThread()
    {
        try {
            Thread.sleep(20000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test(groups = "Regression", description = "Submit salaried app through slide flow from partner specific landing page."
        , enabled = true)
    public void CC_Apply_CreditCard_For_Salaried_Employee_In_BankSpecific_Flow()
    {
        sleepThread();
        System.out.println("Executed, test-case: CC_Apply_CreditCard_For_Salaried_Employee_In_BankSpecific_Flow.");
    }

    @Test(groups = "Regression", description = ""/*, priority = 1*/)
    public void CC_Apply_For_HSBC_CreditCard_For_Salaried_Employee()
    {
        sleepThread();
        System.out.println("Executed, test-case: CC_Apply_For_HSBC_CreditCard_For_Salaried_Employee.");
    }

    @Test(groups = {"FullSanity", "PartnerSanity"}, description = ""/*, priority = 2*/)
    public void CC_Verify_And_Validate_Compare_Offer_Functionality()
    {
        sleepThread();
        System.out.println("Executed, test-case: CC_Verify_And_Validate_Compare_Offer_Functionality.");
    }

    @Test(groups = "PartnerSanity", description = ""/*, priority = 3*/)
    public void CC_Verify_App_Page_Navigation_And_App_Submission()
    {
        sleepThread();
        System.out.println("Executed, test-case: CC_Verify_App_Page_Navigation_And_App_Submission.");
    }
}
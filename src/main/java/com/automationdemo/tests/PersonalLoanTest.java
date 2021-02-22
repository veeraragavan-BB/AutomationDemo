package com.automationdemo.tests;

import org.testng.annotations.Test;

/**
 * Created by IntelliJ IDEA.
 * User: sivaraj
 * Date: 10/2/21
 * Time: 2:34 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class PersonalLoanTest {

    private void sleepThread()
    {
        try {
            Thread.sleep(20000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test(groups = "PartnerSanity", description = "")
    public void PL_Apply_For_Kotak_Bank_Using_Custom_Quote() {
        sleepThread();
        System.out.println("Executed, test-case: PL_Apply_For_Kotak_Bank_Using_Custom_Quote.");
    }

    @Test(groups = "Regression", description = "")
    public void PL_Submit_Apps_through_Emi_calculator() {
        sleepThread();
        System.out.println("Executed, test-case: PL_Submit_Apps_through_Emi_calculator.");
    }

    @Test(groups = "Regression", description = "")
    public void PL_Create_Salaried_Lead_Via_Custom_Quote() {
        sleepThread();
        System.out.println("Executed, test-case: PL_Create_Salaried_Lead_Via_Custom_Quote.");
    }

    @Test(groups = "Regression", description = "")
    public void PL_Create_CoBrands_Salaried_Lead_Via_Quick_Quote() {
        sleepThread();
        System.out.println("Executed, test-case: PL_Create_CoBrands_Salaried_Lead_Via_Quick_Quote.");
    }
}
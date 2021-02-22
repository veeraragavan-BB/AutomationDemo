package com.automationdemo.tests;

import com.bankbazaar.automation.reports.asserts.CustomAssert;
import com.bankbazaar.automation.reports.loggers.ReportLogger;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: sivaraj
 * Date: 15/2/21
 * Time: 12:26 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class CDSServiceTest {
    @BeforeMethod(alwaysRun = true)
    public void beforeSuite(Method method)
    {
        Map<String, String> systemInfo = new HashMap<String, String>();
        systemInfo.put("Environment", "Stg3");
        systemInfo.put("Module", "Integration");
        systemInfo.put("Suite", "Integration Suite");
        ReportLogger.initLogger(systemInfo, "/home/sivaraj/Desktop");
        ReportLogger.initTest(method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterSuite()
    {
        ReportLogger.endTest();
        ReportLogger.closeLogger();
    }

    @Test
    public void cds_profile_test()
    {
        Response response = RestAssured.given()
                .header("content-type", "application/json")
                .header("accept", "application/json")
                .when()
                .baseUri("http://172.17.15.13:6111/cds/api/v3")
                .param("allowPIIData", "true")
                .log().all()
                .get("profiles/CUSTOMER/3640284765");

        String respStr = response.body().asString();
        JsonPath jsonPath = new JsonPath(respStr);
        JsonPath jsonPath2 = new JsonPath(jsonPath.getString("fetchResponse.profile"));
        String pan = jsonPath2.getString("pan.value.id");
        System.out.println("Response: " + response.body().asString());

        System.out.println("fetchResponse.profile: " + jsonPath.getString("fetchResponse.profile"));
        System.out.println("Pan Value: " + jsonPath2.getString("pan.value.id"));
//        Assert.assertEquals(pan, "AOTPZ4103M");
//        Assert.assertEquals(300, response.statusCode());

        CustomAssert.hardAssert().assertEquals(response.statusCode(), 200, "Http Status Code");
        CustomAssert.softAssert().assertEquals(pan, "AOTPZ4103L", "Customer Pan");
    }

    @Test
    public void cds_prefill_test()
    {
        String reqJson = "{\n" +
                "  \"prefillRequest\": {\n" +
                "    \"ignoreRecordsOlderThanDays\": \"100\",\n" +
                "    \"allowPIIData\": \"true\",\n" +
                "    \"prefillRecordType\": \"ELIGIBILITY\",\n" +
                "    \"recordSource\": \"MARKETPLACE\",\n" +
                "    \"recordsForPrefill\": \"{\\\"map\\\":[{\\\"entry\\\":[{\\\"com.bankbazaar.model.cds.PrefillRequest$SourceType\\\":\\\"CUSTOMER\\\",\\\"com.bankbazaar.model.cds.IdList\\\":{\\\"recordIds\\\":[{\\\"a\\\":[{\\\"@class\\\":\\\"string-array\\\",\\\"string\\\":\\\"3640284765\\\"}],\\\"@class\\\":\\\"java.util.Arrays$ArrayList\\\"}]}}]}]}\"\n" +
                "  }\n" +
                "}";
        Response response = RestAssured.given()
                .header("content-type", "application/json")
                .header("accept", "application/json")
                .baseUri("http://172.17.15.13:6111/cds/api/v3")
                .body(reqJson)
                .log().all()
                .post("prefill");

        System.out.println(response.body().asString());
    }
}
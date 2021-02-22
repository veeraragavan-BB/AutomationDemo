package com.automationdemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import javax.print.attribute.standard.RequestingUserName;

/**
 * Created by IntelliJ IDEA.
 * User: sivaraj
 * Date: 2/2/21
 * Time: 12:17 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class RestAssuredDemo {
    public static void main(String[] args) {
        //restGetCall();
        restPostCall();
    }

    public static void restGetCall()
    {
        Response response = RestAssured.given()
                .header("content-type", "application/json")
                .header("accept", "application/json")
                .baseUri("http://172.17.15.13:6111/cds/api/v3")
                .param("allowPIIData", "true")
                .log().all()
                .get("profiles/CUSTOMER/3640284765");

        System.out.println(response.body().asString());
    }

    public static void restPostCall()
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
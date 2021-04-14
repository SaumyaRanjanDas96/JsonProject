package com.employeeapi.testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_002_GetSingleEmployeeRequest extends TestBase{
	@BeforeClass
	void getSingleEmployees() throws InterruptedException {
		
		logger.info("**** started TC_001-GetSingleEmployees*****");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees/"+empID);
		Thread.sleep(3000);
		
	}
	@Test
	void checkResponseBody() throws InterruptedException{
		logger.info("*********started checking ResopnseBody**********");
		String responsebody = response.getBody().asString();
		logger.info("responsebody is"+responsebody);
		Assert.assertEquals(responsebody.contains(empID), true);
		Thread.sleep(3000);
		
	}
	@Test
void checkStatusCode() throws InterruptedException {
		logger.info("**********stated checking statuscode**********");
		int statuscode = response.getStatusCode();
		logger.info("statuscode is:"+statuscode);
		Assert.assertEquals(statuscode, 200);
		Thread.sleep(3000);
		
}
	@Test
	void checkContentType() throws InterruptedException{
		logger.info("**********checking the contenttype");
		String contenttype = response.header("Content-Type");
		logger.info("content type is:"+contenttype);
		Thread.sleep(3000);
	}
	
	@Test
	void checkResponseTime() throws InterruptedException {
		long responsetime = response.getTime();
		logger.info("***********checking response time********");
		Assert.assertTrue(responsetime<2000);//if it is taking more tahn 2 sec it will fail
		logger.info("****** single test case end*********");
        Thread.sleep(3000); 		
	}
}

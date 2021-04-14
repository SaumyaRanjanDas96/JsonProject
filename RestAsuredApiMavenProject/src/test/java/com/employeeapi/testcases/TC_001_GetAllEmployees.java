package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_001_GetAllEmployees extends TestBase{
	@BeforeClass
	void getAllEmployees() throws InterruptedException {
		
		logger.info("**** started TC_001-GtAllEmployees*****");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees");
		Thread.sleep(3000);
		
	}
	@Test
	void checkResponseBody() throws InterruptedException{
		logger.info("*********started checking ResopnseBody**********");
		String responsebody = response.getBody().asString();
		logger.info("responsebody is"+responsebody);
		Assert.assertTrue(responsebody!=null);//it will check the body contains something
		Thread.sleep(3000);
		
	}
	@Test
void checkStatusCode() throws InterruptedException {
		logger.info("**********stated checking statuscode**********");
		int statuscode = response.getStatusCode();
		logger.info("statuscode is:"+statuscode);
		Assert.assertEquals(statuscode, 200);
		Thread.sleep(3);
		
}
	@Test
	void checkContentType() throws InterruptedException{
		logger.info("**********checking the contenttype");
		String contenttype = response.header("Content-Type");
		logger.info("content type is:"+contenttype);
		Thread.sleep(3000);
	}
	
	@Test
	void serverType() throws InterruptedException {
		
		logger.info("****check server type******** ");
		String servertype = response.header("server");
		logger.info(servertype);
		Thread.sleep(3000);
		logger.info("*****gettestcase end****");
	}
}

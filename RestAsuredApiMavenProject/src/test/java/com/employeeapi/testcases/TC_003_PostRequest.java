package com.employeeapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_003_PostRequest extends TestBase{
	
	String empname=RestUtils.empName();
	String empsal=RestUtils.empSal();
	String empage=RestUtils.empAge();
	
	
	@BeforeClass
	void createEmployees() throws InterruptedException {
		
		logger.info("**** started TC_003 create Employees*****");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		
		JSONObject requestparams=new JSONObject();
		
		requestparams.put("name", empname);
		requestparams.put("salary", empsal);
		requestparams.put("age", empage);
	
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestparams.toJSONString());

		response=httpRequest.request(Method.POST,"/create");
		Thread.sleep(3000);
		
	}
	@Test
	void checkResponseBody() throws InterruptedException{
		logger.info("*********started checking ResopnseBody**********");
		String responsebody = response.getBody().asString();
		logger.info("responsebody is"+responsebody);
		Assert.assertEquals(responsebody,true);
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
	
	
}

package com.employeeapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_004_PutRequest extends TestBase{
	
	String empname=RestUtils.empName();
	String empsal=RestUtils.empSal();
	String empage=RestUtils.empAge();
	
	
	@BeforeClass
	void upateEmployees() throws InterruptedException {
		
		logger.info("**** started TC_003 put Employees*****");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		
		JSONObject requestparams=new JSONObject();
		
		requestparams.put("name", empname);
		requestparams.put("salary", empsal);
		requestparams.put("age", empage);
	
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestparams.toJSONString());

		response=httpRequest.request(Method.PUT,"/update/"+empID);
		Thread.sleep(3000);
		
	}
	@Test
	void checkResponseBody() throws InterruptedException{
		logger.info("*********started checking ResopnseBody**********");
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
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
		logger.info("*********put testcase ends*********");
	}
	
	
}

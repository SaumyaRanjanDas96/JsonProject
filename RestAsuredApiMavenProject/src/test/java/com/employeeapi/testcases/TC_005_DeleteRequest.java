package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC_005_DeleteRequest extends TestBase{
	@BeforeClass
	void getAllEmployees() throws InterruptedException {
		
		logger.info("**** started TC_005-Delete Employees*****");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees");
		
		//first get the json path object instance from the response interface
		JsonPath jsonpathevaluator = response.jsonPath();
		//capture id
		String empid = jsonpathevaluator.get("[0].id");//it will capture the id which is present first in the response body
		response=httpRequest.request(Method.DELETE,"/delete/"+empid);
		
		Thread.sleep(3000);
		
	}
	@Test
	void checkResponseBody() throws InterruptedException{
		logger.info("*********started checking ResopnseBody**********");
		String responsebody = response.getBody().asString();
		logger.info("responsebody is"+responsebody);
    	/*Assert.assertEquals(responsebody.contains("Successfully! deleted Records"), true);*/
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
		logger.info("*****Deletetestcase end****");
		
	}
}

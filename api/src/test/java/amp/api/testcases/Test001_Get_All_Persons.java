package amp.api.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amp.api.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Test001_Get_All_Persons extends TestBase{
	
	@BeforeClass
	void getAllPersons() throws InterruptedException{
		logger.info("*******Started get All Persons********");
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/persons");
		
		Thread.sleep(3000);
	}

	@Test
	void checkResponseBody() {
		logger.info("*******Checking response Body********");
		String responseBody = response.getBody().asString();
		logger.info("Response Body==> " + responseBody);
		Assert.assertTrue(responseBody!=null);
		
	}
	
	@Test
	void checkStatusCode() {
		logger.info("*******Checking response Code********");
		int responseCode = response.getStatusCode();
		logger.info("Response Code==> " + responseCode);
		Assert.assertEquals(responseCode,200);
		
	}
	
	@Test
	void checkResponseTime() {
		logger.info("*******Checking response Time********");
		long responseTime = response.getStatusCode();
		logger.info("Response Time==> " + responseTime);
		
		if(responseTime>2000)
			logger.warn("Response Time is greater than 2000");
		
		Assert.assertTrue(responseTime<2000);
		
	}
	
	@AfterClass
	void tearDown() {
		logger.info("*******Finished get All Persons********");
	}
}


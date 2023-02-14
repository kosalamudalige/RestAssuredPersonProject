package amp.api.testcases;

import org.apache.juneau.json.JsonSerializer;
//import org.apache.juneau.xml.XmlSerializer;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import amp.api.base.TestBase;
import amp.api.model.Person;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Test003_Create_Person_XML extends TestBase{
	
	@BeforeClass
	void createPerson() throws InterruptedException{
		logger.info("*******Create a Person********");
		httpRequest = RestAssured.given();
		
		JsonSerializer jsonSerializer =  JsonSerializer.DEFAULT_READABLE;
		Person person = new Person("Mark", "White", 25, 6, "aaaaa", 17722);
		String json = jsonSerializer.serialize(person);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(json);
		response = httpRequest.request(Method.POST,"/create");
		
		/*
		 * XmlSerializer xmlSerializer = XmlSerializer.DEFAULT_NS_SQ_READABLE; Person
		 * person = new Person("Mark", "White", 25, 6, "aaaaa", 17722); String xml =
		 * xmlSerializer.serialize(person);
		 * 
		 * httpRequest.header("Content-Type", "application/xml"); httpRequest.body(xml);
		 * response = httpRequest.request(Method.POST,"/create");
		 */
		
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
		Assert.assertEquals(responseCode,201);
		
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


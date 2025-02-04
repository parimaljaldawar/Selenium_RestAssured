package api.test;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import api.endpoints.UserEndpoints2;
import api.payload.User;
import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTests2 
{
	Faker faker;
	User userPayload;
	Logger logger;
	
	@BeforeClass
	public void setup() 
	{
		faker=new Faker();
		userPayload=new User();
				
		userPayload.setId(faker.idNumber().hashCode());
		
		userPayload.setUsername(faker.name().username());
		
		userPayload.setFirstName(faker.name().firstName());
		
		userPayload.setLastName(faker.name().lastName());
		
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		userPayload.setPassword(faker.internet().password(5, 10));
		
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
		// Initialize the logger
		logger = LogManager.getLogger(this.getClass());
		
	}
	
	
	@Test(priority=1)
	public void testPostUser() 
	{
		
		logger.info("************* Creating User *************");
		
		Response response=UserEndpoints2.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************* User has been created *************");
	}
	
	@Test(priority=2)
	public void testGetUserByName() 
	{
				
		logger.info("************* Reading User Info *************");
		
		Response response=UserEndpoints2.getUser(this.userPayload.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************* User Info is displayed *************");
	}
	
	
	@Test(priority=3)
	public void testUpdateUserByName() 
	{
				
		logger.info("************* Updating User *************");
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndpoints2.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response responseAfterUpdate=UserEndpoints2.getUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
		logger.info("************* User is updated *************");
	}
	
	
	@Test(priority=4)
	public void testDeleteUserByName() 
	{
		
		logger.info("************* Deleting User *************");
		
		Response response=UserEndpoints2.deleteUser(this.userPayload.getUsername());
				
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************* User is Deleted *************");
	}
	
}

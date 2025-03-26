package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

/**
 * UserEndpoints2 class provides methods to interact with User API endpoints
 * using values from a properties file.
 */
public class UserEndpoints2 {

    /**
     * Loads the routes from the properties file.
     * 
     * @return ResourceBundle containing API endpoint URLs.
     */
	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");  //load properties file
		return routes;
	}

	
    /**
     * Creates a new user.
     * 
     * @param payload User object containing user details.
     * @return Response of the API request.
     */
	
	public static Response createUser(User Payload) 
	{
		String post_url=getURL().getString("post_url");
		
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(Payload)
			.when()
				.post(Routes.post_url);		
			return response;
	}
	
	
    /**
     * Retrieves user details based on the username.
     * 
     * @param userName Username of the user to fetch details.
     * @return Response containing user details.
     */
	public static Response getUser(String userName) 
	{
		String get_url=getURL().getString("get_url");
		
		Response response=given()
							.pathParam("username", userName)				
						.when()
							.get(Routes.get_url);
						return response;
	}
	
	
    /**
     * Updates user details based on the username.
     * 
     * @param userName Username of the user to update.
     * @param payload  Updated user details.
     * @return Response of the API request.
     */
	public static Response updateUser(String userName, User Payload) 
	{
		
		String update_url=getURL().getString("update_url");
		
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(Payload)
			.when()
				.put(Routes.update_url);		
			return response;
	}
	

    /**
     * Deletes a user based on the username.
     * 
     * @param userName Username of the user to delete.
     * @return Response of the API request.
     */
	public static Response deleteUser(String userName) 
	{
		
		String delete_url=getURL().getString("delete_url");
		
		Response response=given()
					.pathParam("username", userName)
				.when()
					.delete(Routes.delete_url);
				return response;
	}
}

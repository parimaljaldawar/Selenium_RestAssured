package api.endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * UserEndpoints class provides methods to perform CRUD operations
 * on User resources via API calls.
 */
public class UserEndpoints {

    /**
     * Creates a new user.
     * 
     * @param payload User object containing user details.
     * @return Response of the API request.
     */
    public static Response createUser(User payload) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url);
    }

    /**
     * Retrieves user details based on the username.
     * 
     * @param userName Username of the user to fetch details.
     * @return Response containing user details.
     */
    public static Response getUser(String userName) {
        return given()
                .pathParam("username", userName)
                .when()
                .get(Routes.get_url);
    }

    /**
     * Updates user details based on the username.
     * 
     * @param userName Username of the user to update.
     * @param payload  Updated user details.
     * @return Response of the API request.
     */
    public static Response updateUser(String userName, User payload) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when()
                .put(Routes.update_url);
    }

    /**
     * Deletes a user based on the username.
     * 
     * @param userName Username of the user to delete.
     * @return Response of the API request.
     */
    public static Response deleteUser(String userName) {
        return given()
                .pathParam("username", userName)
                .when()
                .delete(Routes.delete_url);
    }
}

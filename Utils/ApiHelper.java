import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiHelper {

    /**
     * Sends a POST request with the given JSON payload and returns the response.
     * 
     * @param endpoint The API endpoint to send the request to.
     * @param jsonPayload The JSON payload to be sent in the request body.
     * @return Response object containing the API response.
     */
    public static Response sendPostRequest(String endpoint, String jsonPayload) {
        // Set the base URI if needed (optional)
        RestAssured.baseURI = "https://thetestingworldapi.com/"; 

        // Create the request specification
        RequestSpecification request = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(jsonPayload);

        // Send the POST request and return the response
        return request.post(endpoint);
    }
}

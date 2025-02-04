package com.selenium.testing.selenium_test_Handson_project;

import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.asserts.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;

/* 
given()
		set cookies, add authentication, add param, set header info
		
when()
		get, post, put, delete
		
then()
		validate status code, extract response, extract headers, cookies & response body
		 
*/

@SuppressWarnings("unused")
public class JsonHelper 
{

    /**
     * Creates a JSON payload dynamically based on input parameters.
     * 
     * @param id The ID value.
     * @param language The list of languages.
     * @param yearexp The year of experience.
     * @param lastused The last used information.
     * @param st_id The student ID.
     * @return JSON string representing the payload.
     * @throws Exception If JSON creation fails.
     */
    public static String createJsonPayload(int id, List<String> language, String yearexp, String lastused, String st_id) throws Exception {
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", id);
        payload.put("language", language);
        payload.put("yearexp", yearexp);
        payload.put("lastused", lastused);
        payload.put("st_id", st_id);

        // Convert the map to a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(payload);
    }
}
	
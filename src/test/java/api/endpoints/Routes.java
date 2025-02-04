package api.endpoints;

/* Swagger URLs :- https://petstore.swagger.io/
* 
* Post Method URL for creating user:- https://petstore.swagger.io/v2/user
* Get Method URL for getting user:- https://petstore.swagger.io/v2/user/{UserName}
* Put Method URL for changing the details:- https://petstore.swagger.io/v2/user/{UserName}
* Delete Method URL for changing the details:- https://petstore.swagger.io/v2/user/{UserName}
* 
* Base URL:-  https://petstore.swagger.io/v2
* End Point URL:- /user/{UserName}
*   
 */

public class Routes 
{
	public static String base_url="https://petstore.swagger.io/v2" ;
	
	/*Path Parameter = {username}
	*/
	
	
	//User Modules	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	
	//Store Modules
	
	
	
	//Pet Modules
}

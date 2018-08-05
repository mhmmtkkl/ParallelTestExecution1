package stepDefs;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class ApiTesting1 {

	Response response;
	Map responseMap;
	Map<String,Object> MyDataMap;
	
	@Given("I create map to store my data employee_id is {int} Username is {string} , first_name {string}, last_name is {string} , email is {string} , phone_number is {string} hire_date is {string} , job_id is {string}")
	public void i_create_map_to_store_my_data_employee_id_is_Username_is_first_name_last_name_is_email_is_phone_number_is_hire_date_is_job_id_is(Integer int1, String string, String string2, String string3, String string4, String string5, String string6, String string7) {
		  
		MyDataMap= new HashMap<>();
		
		MyDataMap.put("employee_id",165 );
		MyDataMap.put("first_name","Ahmet" );
		MyDataMap.put("last_name","Turkkahraman" );
		MyDataMap.put("email","EM165" );
		MyDataMap.put("phone_number","202.123.4567" );
		MyDataMap.put("hire_date","2018-04-24T07:25:00Z" );
		MyDataMap.put("job_id","IT_PROG" );
		 
	 		
	}

	 

	@And("I get an connection with API")
	public void i_get_an_connection_with_API() {
		 
		  response =given().accept(ContentType.JSON)
							.when().
							get("http://34.223.219.142:1212/ords/hr/employees/165");
							
	}

	@When("I checked the status code")
	public void i_checked_the_status_code() {
			
		assertEquals(response.getStatusCode(), 200);
		
		 responseMap=response.body().as(HashMap.class);
	}

	@Then("I verified usurname , first_name, last_name , email ,phone_number, hire_date, job_id is as expected")
	public void i_verified_usurname_first_name_last_name_email_phone_number_hire_date_job_id_is_as_expected() {
		 assertEquals(responseMap.containsKey("employee_id"), MyDataMap.containsKey("employee_id"));
		 assertEquals(responseMap.containsKey("first_name"), MyDataMap.containsKey("first_name"));
		 assertEquals(responseMap.containsKey("last_name"), MyDataMap.containsKey("last_name"));
		 assertEquals(responseMap.containsKey("email"), MyDataMap.containsKey("email"));
		 assertEquals(responseMap.containsKey("phone_number"), MyDataMap.containsKey("phone_number"));
		 assertEquals(responseMap.containsKey("hire_date"), MyDataMap.containsKey("hire_date"));
		 assertEquals(responseMap.containsKey("job_id"), MyDataMap.containsKey("job_id"));
	}

}

package steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.APIRequestsHelpers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class restExampleTests {

	private Response response;

	@When("^I send a request to retrieve employee details of employee with id = \"([^\"]*)\"$")
	public void i_send_a_request_to_retrieve_employee_details_of_employee_with_id(String employeeId) throws Throwable {
		String path = "v1/employee/" + employeeId;
		String url = APIRequestsHelpers.createURL(path); // create url for the api call
		response = APIRequestsHelpers.simpleGetRequest(url); // send get request to retrieve employee details
	}

	@Then("^I validate the response code (\\d+)$")
	public void i_validate_the_response_code(int statusCode) throws Throwable {
		APIRequestsHelpers.verifyResponseStatusCode(response, statusCode); // validate response code
	}

	@Then("^then I validate employee name \"([^\"]*)\", employee salary (\\d+) and age (\\d+)$")
	public void then_I_validate_employee_name_employee_salary_and_age(String name, int salary, int age)
			throws Throwable {
		JsonPath jsonPath = new JsonPath(response.asString()); // to parse the response body
		String employeeName = jsonPath.getString("data.employee_name"); // retrieve employee name from response body
		String employeeSalary = jsonPath.getString("data.employee_salary"); // retrieve employee salary
		String employeeAge = jsonPath.getString("data.employee_age"); // retrieve employee salary
		assertThat(employeeName).isEqualTo(name); // assert that actual employee name to expected employee name
		assertThat(Integer.parseInt(employeeSalary)).isEqualTo(salary); // assert that actual employee salary to
																		// expected employee salary
		assertThat(Integer.parseInt(employeeAge)).isEqualTo(age); // assert that actual employee age to expected
																	// employee age

	}

	@When("^I send a request to delete an employee record with id (\\d+)$")
	public void i_send_a_request_to_delete_an_employee_record_with_id(int employeeId) throws Throwable {
		String path = "v1/delete/" + employeeId;
		String url = APIRequestsHelpers.createURL(path); // create url to api call
		response = APIRequestsHelpers.simpleDeleteRequest(url); // send delete request to delete employee record
	}

	@Then("^then I validate status \"([^\"]*)\" and message \"([^\"]*)\" from response body$")
	public void then_I_validate_status_and_message_from_response_body(String status, String message) throws Throwable {
		response.then().assertThat().body("status", equalTo(status)); // verify status in response body
		response.then().assertThat().body("message", equalTo(message)); // verify message in response body
	}
}

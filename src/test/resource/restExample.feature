@example
Feature: CRUD employee records

  Scenario: GET employee details
    When I send a request to retrieve employee details of employee with id = "1"
    Then I validate the response code 200
    And then I validate employee name "Tiger Nixon", employee salary 320800 and age 61

  Scenario: Delete an employee record
    When I send a request to delete an employee record with id 2
    Then I validate the response code 200
    And then I validate status "success" and message "Successfully! Record has been deleted" from response body

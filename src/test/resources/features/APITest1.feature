Feature: I am testing employee data

@api
Scenario: Get from employee table and check data

	Given I create map to store my data employee_id is 123 Username is "username" , first_name "first_name ", last_name is "last_name" , email is "email" , phone_number is "phone_number " hire_date is "hire_date" , job_id is "job_id" 
	And I get an connection with API 
	And I checked the status code 
	And I verified usurname , first_name, last_name , email ,phone_number, hire_date, job_id is as expected
	
	

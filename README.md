To Run the UI tests:

A: Using Maven:

PreRequisite: Maven is installed.
1. Clone the repository on to the local machine 
2. Run below command from the repository i.e. APITests/  to run tests 
mvn test -Dexample_url="http://dummy.restapiexample.com/api/"


B. To run tests using IDE:
IDE is installed in system
1. Clone the repository on to the local machine.
2. Import the repository on IDE
3. Create Junit Run configuration (select JUnit4)
4. Use below VM Arguments to run the tests: 
-Dexample_url="http://dummy.restapiexample.com/api/

Test Report
To access test report go to UITests/target/cucumber-reports/cucumber-pretty
and double click on index.html then report will open in default browser
Click on Scenario to expand the report
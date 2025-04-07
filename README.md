
Setup guide
Open bank Restful WebServices as Web Application

Requirements to build and run the application successfully

- JDK 1.8
- Maven 3.x
- Eclipse/Java IDE - This application has been developed using
  Eclipse IDE for Enterprise Java Developers.
  Version: 2019-03 (4.11.0)

- Tomcat 8.5/9  -  application has been successfully tested on tomcat 8.5 and tomcat 9




Step by Step Guide
Note: This guide is only applicable for importing projects into eclipse IDE

1. Extract the application using the extrator tool like winzip
2. Open eclipse and import the project into IDE
   file -> import --> import as existing maven project -> open the directory when the project has been extracted and select root project directory where pom.xml file is located
3. To Run the application, add the tomcat server into eclipse IDE
   window -> show view -> servers -> Add New Server (Tomcat)
4. Add the application to tomcat server
   4.1 Right click on server -> select add/Remove -> select the project from available list to configured list.
   4.2 Start the Server and open a browser and enter the following URL
   http://localhost:8080/Open_Bank_App/

       OR

   4.3 Right click on the project and select Run As -> Run on server to select the project and run it.
   - This will open the application into default browser

        OR

   4.4 Use the cammand line to build the war file using maven and install the war file into tomcat server
   mvn clean install –e

How to Use the Application

1. There are three Rest Endpoints exposed and all of them are secured using basic http spring security
   Please follow the URL given below and enter the username and password when pop up appears
   Since it is just basic http authentication, You may need to clear session data and/or close and reopen you browser to start the new session

   1.1 -  Show the list of all transaction.
   http://localhost:8080/Open_Bank_App/transaction
   username= backbase
   password= backbase

   1.2 Show the list of all transactions by type
   http://localhost:8080/Open_Bank_App/transaction/SANDBOX_TAN
   username= backbase
   password= backbase

   1.3 Show the total amount of all transactions by type
   http://localhost:8080/Open_Bank_App/transaction/totalamount/SANDBOX_TAN
   username= backbase
   password= backbase

1.4 Additionally, A web page has been included which contains the details of the user and all the Rest e end points that can be tested directly by clicking on links
User web page displays who is logged in (anaonymousUser or logged in user)

       http://localhost:8080/Open_Bank_App/user.html
       Click on any Rest endpoint and enter username and password
       username= backbase
       password= backbase

2. Running the Junit test cases and Test Coverage from within the eclipse IDE
   2.1 Right click on project OpenBank from the project explorer and select Run As JUnit Test
   Open the JUnit perspective to see the results of JUnit Test Cases

   2.2 Right click on project OpenBank from the project explorer and select Coverage As JUnit Test
   Open the Coverage perspective to see the results of Coverage for JUnit Test cases


3. Bonus Features
   3.1 Logging
   3.1.1  Logging has been implemented using Java Util Logging API

4. Missing Bonus Features due to time contstraints
    - Use any embedded web servlet container to startup the web application in maven
    - Documentation of classes/code/packaging (swagger or RAML or any other tools)
    - Use Camel to route the web service call


5. Complete Java Standard Comments/Documentation has been included for code
 
 
 
 
 
    

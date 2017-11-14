Subject : Bank

We use Web service deployment with Axis2


here Services are Bankservices which have 4 operations or methods: message(), list(), conversion(), getAccounts()

- message() : it displays a simple String message 
- list() : it shows elements which are currently in a list
- conversion() : it converts a number and displays it
- getAccounts() : it creates objects and displays them


Here Clients are classes :

- TestClient
- BankServiceStub
- BankServiceCallbackHandler



the URL to create a Web Service Client : http://localhost:8080/ProjectWS/services/Bankservice?wsdl



here the URLs to test operations for this project :

http://localhost:8080/ProjectWS/services/BankService/message

http://localhost:8080/ProjectWS/services/BankService/conversion?mt=16

http://localhost:8080/ProjectWS/services/BankService/list


http://localhost:8080/ProjectWS/services/BankService/getAccounts





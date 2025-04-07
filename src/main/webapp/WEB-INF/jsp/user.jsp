<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Back Base Open Bank App</title>
</head>
<body>
<h1>Welcome to Back Base Open Bank Web Application</h1>

<h1>${user}</h1>


<h3>Here is the list of available Rest endpoints</h3>

<a href="transaction">Transactions List</a><br/>
<a href="transaction/SANDBOX_TAN">Transactions By Type</a><br/>
<a href="transaction/totalamount/SANDBOX_TAN">Transactions Total Amount By Type</a><br/>

</body>
</html>
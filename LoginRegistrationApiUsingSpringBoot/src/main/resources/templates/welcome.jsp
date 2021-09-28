<!DOCTYPE html>
<html>
<head>
<title>Welcome Page</title>
</head>
<!-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>-->
<body>
<h2>Please Select The Task Below</h2>
<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;">
	<a href="/register">Add User</a> | &nbsp;
    <a href="/list">Show All Users</a> 
    <form id="logoutForm" method="POST" action="/logout">
    <h3 style="color:red;">
            <a onclick="document.forms['logoutForm'].submit()">Logout</a>
    </h3>
    </form>
</div>
</body>
</html>
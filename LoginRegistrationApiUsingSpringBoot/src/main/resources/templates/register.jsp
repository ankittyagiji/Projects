<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
 
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Add User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>
 
<body>
<h3 th:text="${successMessage}"></h3>
    <div class="container my-5">
        <h3> Add User</h3>
        <div class="card">
            <div class="card-body">
                <div class="col-md-8">
                    <form action="#" th:action="@{/register}" th:object="${user}"
                                                                       method="post">
                        <div class="row">
                            <div class="form-group col-md-7">
                                <label for="firstName" class="col-form-label">First Name</label> 
                                <input type="text" th:field="*{firstName}" class="form-control"
                                            id="firstName" placeholder="First Name" />
                            </div>
                            <div class="form-group col-md-7">
                                <label for="lastName" class="col-form-label">Last Name</label> 
                                <input type="text" th:field="*{lastName}" class="form-control"
                                            id="lastName" placeholder="Last Name" name="lastName"/><br></br>
                                            <span th:if="${#fields.hasErrors('lastName')}" th:errors="*{lastName}" class="alert alert-danger"></span>
                            </div>
                            
                            <div class="form-group col-md-6">
                                <label for="pincode" class="col-form-label">Pincode</label> 
                                <input type="text" th:field="*{pincode}" class="form-control"
                                            id="pincode" placeholder="Pincode" />
                            </div>
                            
                            <div class="form-group col-md-6">
                                <label for="email" class="col-form-label">Email</label> 
                                <input type="text" th:field="*{email}" class="form-control"
                                            id="email" placeholder="Email Id" name="email"/><br></br>
                                            <span th:if="${#fields.hasErrors('email')}" th:errors="*{email}" class="alert alert-danger"></span>
                            </div>
 
 
                            <div class="form-group col-md-6">
                                <label for="address" class="col-form-label">Address</label> 
                                <input type="text" th:field="*{address}" class="form-control"
                                            id="address" placeholder="Address" />
                            </div>
                            
                              <div class="form-group col-md-6">
                                <label for="mobile" class="col-form-label">Mobile</label> 
                                <input type="text" th:field="*{mobile}" class="form-control"
                                            id="mobile" placeholder="Mobile" />
                            </div>
                            
                              <div class="form-group col-md-6">
                                <label for="password" class="col-form-label">Password</label> 
                                <input type="password" th:field="*{password}" class="form-control"
                                            id="password" placeholder="Password" />
                            </div>
                            <div class="col-md-5">
                                <input type="submit" class="btn btn-primary" value=" Submit ">
                            </div>
 
                            <input type="hidden" id="id" th:field="*{id}">
     
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
<a href="/welcome">Welcome Page</a>
</body>
 
</html>
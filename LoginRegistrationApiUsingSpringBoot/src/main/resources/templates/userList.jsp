<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Users</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <!-- <link rel="stylesheet" href="../css/shards.min.css"> -->
</head>

<body>
    <div class="container my-2">
        <div class="card">
            <div class="card-body">
                <div th:switch="${user}" class="container my-5">
                    <p class="my-5">
                        <a href="/register" class="btn btn-primary"><i
       class="fas fa-user-plus ml-2"> Add User</i></a>
                    </p>
                    <div class="col-md-10">
                        <h2 th:case="null">No User yet!</h2>
                        <div th:case="*">
                            <table class="table table-striped table-responsive-md">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Pincode</th>
                                        <th>Email</th>
                                        <th>Address</th>
                                        <th>Mobile</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr th:each="user : ${user}">
                                        <td th:text="${user.id}"></td>
                                        <td th:text="${user.firstName}"></td>
                                        <td th:text="${user.lastName}"></td>
                                        <td th:text="${user.pincode}"></td>
                                        <td th:text="${user.email}"></td>
                                        <td th:text="${user.address}"></td>
                                        <td th:text="${user.mobile}"></td>
                                        <td><a th:href="@{/edit/{id}(id=${user.id})}" class="btn btn-primary"><i class="fas fa-user-edit ml-2"></i></a></td>
                                        <td><a th:href="@{/delete/{id}(id=${user.id})}" class="btn btn-primary"><i class="fas fa-user-times ml-2"></i></a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
<a href="/welcome">Welcome Page</a>
</body>

</html>
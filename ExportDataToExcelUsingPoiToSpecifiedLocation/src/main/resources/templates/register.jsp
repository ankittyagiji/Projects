<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>User Detail</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>
<body>
	<h3 th:text="${successMessage}"></h3>
	<div class="container my-5">
		<h3>Enter User Details</h3>
		<div class="card">
			<div class="card-body">
				<div class="col-md-8">
					<form action="#" th:action="@{/export}" th:object="${user}"
						method="post">
						<div class="row">
							<div class="form-group col-md-7">
								<label for="firstName" class="col-form-label">Enter FirstName</label>
								<input type="text" th:field="*{firstName}" class="form-control"
									id="firstName" placeholder="firstName" /><br>
									<span th:if="${#fields.hasErrors('firstName')}" th:errors="*{firstName}" class="alert alert-danger"></span>
							</div>
							<div class="form-group col-md-7">
								<label for="lastName" class="col-form-label">Enter LastName</label>
								<input type="text" th:field="*{lastName}" class="form-control"
									id="lastName" placeholder="lastName" />
							</div>
							<div class="form-group col-md-7">
								<label for="address" class="col-form-label">Enter Address</label>
								<input type="text" th:field="*{address}" class="form-control"
									id="address" placeholder="address" />
							</div>

						</div>
						<div class="col-md-3">
							<i class="fa fa-file-excel-o"><input type="submit" style="margin:auto; text-align:center; display:block; font-size: 20px" value="Click Here to generate excel"></i>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
</body>

</html>
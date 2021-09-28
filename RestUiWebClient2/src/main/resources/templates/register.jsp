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
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
</head>

<body>
	<h3 th:text="${successMessage}"></h3>
	<div class="container my-5">
		<h3>Enter Username</h3>
		<div class="card">
			<div class="card-body">
				<div class="col-md-8">
					<form action="#" th:action="@{/register}" th:object="${user}"
						method="post">
						<div class="row">
							<div class="form-group col-md-7">
								<label for="username" class="col-form-label">UserName</label>
								<input type="text" th:field="*{username}" class="form-control"
									id="username" placeholder="username" />
							</div>

						</div>
						<div class="col-md-3">
							<input type="submit" class="btn btn-primary" value=" Submit ">
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
</body>

</html>
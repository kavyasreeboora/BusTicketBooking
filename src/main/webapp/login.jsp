<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background: linear-gradient(to right, #4facfe, #00f2fe);
    height: 100vh;
}

.login-card{
    margin-top: 80px;
    border-radius: 20px;
}
</style>

</head>
<body>

<div class="container">

    <div class="row justify-content-center">

        <div class="col-md-5">

            <div class="card shadow-lg login-card">

                <div class="card-header bg-primary text-white text-center">
                    <h3>🔐 User Login</h3>
                </div>

                <div class="card-body p-4">

                    <form action="login" method="post">

                        <div class="mb-3">
                            <label class="form-label">Email Address</label>
                            <input type="email"
                                   name="email"
                                   class="form-control"
                                   placeholder="Enter your email"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input type="password"
                                   name="password"
                                   class="form-control"
                                   placeholder="Enter your password"
                                   required>
                        </div>

                        <div class="d-grid">
                            <button type="submit"
                                    class="btn btn-primary">
                                Login
                            </button>
                        </div>

                    </form>

                </div>

                <div class="card-footer text-center">

                    New User?

                    <a href="register.jsp"
                       class="text-decoration-none fw-bold">
                       Register
                    </a>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bus Ticket Booking System</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background: linear-gradient(to right, #4facfe, #00f2fe);
    height: 100vh;
}

.main-card{
    margin-top: 120px;
    border-radius: 20px;
}
</style>

</head>
<body>

<div class="container">

    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card shadow-lg text-center main-card">

                <div class="card-body p-5">

                    <h1 class="text-primary mb-4">
                        🚌 Bus Ticket Booking System
                    </h1>

                    <p class="text-muted mb-4">
                        Book your journey quickly and easily
                    </p>

                    <a href="register.jsp"
                       class="btn btn-success btn-lg me-3">
                        Register
                    </a>

                    <a href="login.jsp"
                       class="btn btn-primary btn-lg">
                        Login
                    </a>

                </div>

            </div>

        </div>

    </div>

</div>

</body>
</html>
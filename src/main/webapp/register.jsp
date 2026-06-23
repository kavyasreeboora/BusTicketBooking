<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background: linear-gradient(to right, #4facfe, #00f2fe);
    height: 100vh;
}

.register-card{
    margin-top: 60px;
    border-radius: 20px;
}
</style>

</head>
<body>

<div class="container">

```
<div class="row justify-content-center">

    <div class="col-md-5">

        <div class="card shadow-lg register-card">

            <div class="card-header bg-success text-white text-center">
                <h3>📝 User Registration</h3>
            </div>

            <div class="card-body p-4">

                <form action="register" method="post">

                    <div class="mb-3">
                        <label class="form-label">Full Name</label>
                        <input type="text"
                               name="name"
                               class="form-control"
                               placeholder="Enter your name"
                               required>
                    </div>

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
                               placeholder="Enter password"
                               required>
                    </div>

                    <div class="d-grid">
                        <button type="submit"
                                class="btn btn-success">
                            Register
                        </button>
                    </div>

                </form>

            </div>

            <div class="card-footer text-center">

                Already Registered?

                <a href="login.jsp"
                   class="text-decoration-none fw-bold">
                   Login
                </a>

            </div>

        </div>

    </div>

</div>
```

</div>

</body>
</html>

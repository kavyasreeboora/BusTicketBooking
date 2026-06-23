<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Success</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: #f4f6f9;
}

.success-box {
    margin-top: 100px;
    padding: 30px;
    border-radius: 12px;
}
</style>

</head>

<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card success-box shadow text-center">

                <!-- Success Icon -->
                <div class="mb-3">
                    <span style="font-size:50px;">🎉</span>
                </div>

                <h2 class="text-success">Ticket Booked Successfully</h2>

                <p class="mt-2 text-muted">
                    Thank you for booking with us. Your ticket has been confirmed.
                </p>

                <div class="mt-4">

                    <a href="history" class="btn btn-primary me-2">
                        View Booking History
                    </a>

                    <a href="search.jsp" class="btn btn-outline-secondary">
                        Book Another Ticket
                    </a>

                </div>

            </div>

        </div>
    </div>
</div>

</body>
</html>
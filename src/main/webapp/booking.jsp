<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Ticket</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: #f4f6f9;
}

.card-box {
    margin-top: 80px;
    padding: 25px;
    border-radius: 12px;
}
</style>

</head>

<body>

<%
String busId = request.getParameter("busId");
%>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-5">

            <div class="card card-box shadow">

                <h3 class="text-center mb-4">Book Ticket</h3>

                <form action="bookTicket" method="post">

                    <!-- Bus ID -->
                    <div class="mb-3">
                        <label class="form-label">Bus ID</label>
                        <input type="number"
                               name="busId"
                               class="form-control"
                               value="<%= busId == null ? "" : busId %>"
                               readonly>
                    </div>

                    <!-- Seats -->
                    <div class="mb-3">
                        <label class="form-label">Number of Seats</label>
                        <input type="number"
                               name="seats"
                               class="form-control"
                               min="1"
                               required>
                    </div>

                    <!-- Submit -->
                    <button type="submit" class="btn btn-success w-100">
                        Confirm Booking
                    </button>

                </form>

            </div>

        </div>
    </div>
</div>

</body>
</html>
<%@ page import="java.util.List"%>
<%@ page import="com.bus.model.Bus"%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Buses</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background: #f4f6f9;
}

.container-box {
    margin-top: 50px;
}

.book-btn {
    text-decoration: none;
    padding: 6px 14px;
    border-radius: 6px;
    background: #198754;
    color: white;
    transition: 0.3s;
    display: inline-block;
}

.book-btn:hover {
    background: #146c43;
}
</style>

</head>

<body>

<div class="container container-box">

    <h2 class="text-center mb-4">Available Buses</h2>

    <div class="table-responsive">

        <table class="table table-hover table-bordered shadow bg-white text-center">

            <thead class="table-dark">
                <tr>
                    <th>Bus ID</th>
                    <th>Bus Name</th>
                    <th>Source</th>
                    <th>Destination</th>
                    <th>Fare</th>
                    <th>Available Seats</th>
                    <th>Action</th>
                </tr>
            </thead>

            <tbody>

            <%
                List<Bus> busList =
                        (List<Bus>) request.getAttribute("busList");

                if(busList != null && !busList.isEmpty()) {

                    for(Bus bus : busList) {
            %>

                <tr>
                    <td><%= bus.getBusId() %></td>
                    <td><%= bus.getBusName() %></td>
                    <td><%= bus.getSource() %></td>
                    <td><%= bus.getDestination() %></td>
                    <td>₹<%= bus.getFare() %></td>
                    <td><%= bus.getAvailableSeats() %></td>

                    <td>
                        <a class="book-btn"
                           href="booking.jsp?busId=<%= bus.getBusId() %>">
                            Book Ticket
                        </a>
                    </td>
                </tr>

            <%
                    }
                } else {
            %>

                <tr>
                    <td colspan="7" class="text-danger fw-bold">
                        No buses found
                    </td>
                </tr>

            <%
                }
            %>

            </tbody>

        </table>

    </div>

    <div class="text-center mt-3">
        <a href="search.jsp" class="btn btn-outline-secondary">
            ← Search Again
        </a>
    </div>

</div>

</body>
</html>
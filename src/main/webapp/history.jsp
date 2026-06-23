<%@ page import="java.util.List"%>
<%@ page import="com.bus.model.Booking"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking History</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background:#f4f6f9;
}

.container-box{
    margin-top:60px;
}
</style>

</head>
<body>

<div class="container container-box">

    <h2 class="text-center mb-4">Your Booking History</h2>

    <%
        List<Booking> history =
        (List<Booking>)request.getAttribute("history");
    %>

    <div class="table-responsive">

        <table class="table table-hover table-bordered bg-white shadow text-center">

            <thead class="table-dark">
                <tr>
                    <th>Booking ID</th>
                    <th>Bus ID</th>
                    <th>Seats Booked</th>
                    <th>Total Amount</th>
                    <th>Action</th>
                </tr>
            </thead>

            <tbody>

            <%
                if(history != null && !history.isEmpty()){

                    for(Booking b : history){
            %>

                <tr>
                    <td><%= b.getBookingId() %></td>
                    
                    <td><%= b.getBusId() %></td>

                    <td><%= b.getSeatsBooked() %></td>

                    <td>₹<%= b.getTotalAmount() %></td>

                    <td>

                        <a href="editBooking.jsp?bookingId=<%= b.getBookingId() %>"
                           class="btn btn-warning btn-sm">
                            Edit
                        </a>

                        <a href="cancelBooking?bookingId=<%= b.getBookingId() %>"
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('Cancel this booking?')">
                            Cancel
                        </a>

                    </td>
                </tr>

            <%
                    }
                }
                else{
            %>

                <tr>
                    <td colspan="5" class="text-danger fw-bold">
                        No booking history found
                    </td>
                </tr>

            <%
                }
            %>

            </tbody>

        </table>

    </div>

</div>

</body>
</html>
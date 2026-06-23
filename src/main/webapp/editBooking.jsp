<%@ page import="com.bus.dao.BookingDAO"%>
<%@ page import="com.bus.model.Booking"%>

<%
int bookingId =
    Integer.parseInt(request.getParameter("bookingId"));

BookingDAO dao = new BookingDAO();

Booking booking = dao.getBookingById(bookingId);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Booking</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container mt-5">

    <div class="card shadow p-4">

        <h3>Edit Booking</h3>

        <form action="editBooking" method="post">

            <input type="hidden"
                   name="bookingId"
                   value="<%= booking.getBookingId() %>">

            <div class="mb-3">
                <label>Seats</label>

                <input type="number"
                       name="seats"
                       class="form-control"
                       value="<%= booking.getSeatsBooked() %>"
                       required>
            </div>

            <button type="submit"
                    class="btn btn-success">
                Update Booking
            </button>

        </form>

    </div>

</div>

</body>
</html>
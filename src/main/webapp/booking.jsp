<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Ticket</title>
</head>
<body>

<h2>Book Ticket</h2>

<form action="bookTicket" method="post">

Bus ID:
<input type="number" name="busId" required><br><br>

Number Of Seats:
<input type="number" name="seats" required><br><br>

<input type="submit" value="Book Ticket">

</form>

</body>
</html>
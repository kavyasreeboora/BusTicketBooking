package com.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bus.model.Booking;
import com.bus.util.DBConnection;

public class BookingDAO {

	// Book Ticket
	public boolean bookTicket(Booking booking) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con
					.prepareStatement("insert into bookings(user_id,bus_id,seats_booked,total_amount) values(?,?,?,?)");

			ps.setInt(1, booking.getUserId());
			ps.setInt(2, booking.getBusId());
			ps.setInt(3, booking.getSeatsBooked());
			ps.setDouble(4, booking.getTotalAmount());

			int result = ps.executeUpdate();

			if (result > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// Booking History
	public List<Booking> getBookingHistory(int userId) {

		List<Booking> history = new ArrayList<>();

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from bookings where user_id=?");

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Booking booking = new Booking();

				booking.setBookingId(rs.getInt("booking_id"));
				booking.setUserId(rs.getInt("user_id"));
				booking.setBusId(rs.getInt("bus_id"));
				booking.setSeatsBooked(rs.getInt("seats_booked"));
				booking.setTotalAmount(rs.getDouble("total_amount"));

				history.add(booking);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return history;
	}

	// Get Booking By ID
	public Booking getBookingById(int bookingId) {

		Booking booking = null;

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from bookings where booking_id=?");

			ps.setInt(1, bookingId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				booking = new Booking();

				booking.setBookingId(rs.getInt("booking_id"));
				booking.setUserId(rs.getInt("user_id"));
				booking.setBusId(rs.getInt("bus_id"));
				booking.setSeatsBooked(rs.getInt("seats_booked"));
				booking.setTotalAmount(rs.getDouble("total_amount"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return booking;
	}

	// Cancel Booking
	public boolean cancelBooking(int bookingId) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con.prepareStatement("delete from bookings where booking_id=?");

			ps.setInt(1, bookingId);

			int result = ps.executeUpdate();

			if (result > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	// Update Booking (used for Edit Booking)
	public boolean updateBooking(int bookingId, int seatsBooked, double totalAmount) {

		boolean status = false;

		try {

			Connection con = DBConnection.getConnection();

			PreparedStatement ps = con
					.prepareStatement("update bookings set seats_booked=?, total_amount=? where booking_id=?");

			ps.setInt(1, seatsBooked);
			ps.setDouble(2, totalAmount);
			ps.setInt(3, bookingId);

			int result = ps.executeUpdate();

			if (result > 0) {
				status = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
}
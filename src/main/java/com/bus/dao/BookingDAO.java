package com.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bus.model.Booking;
import com.bus.util.DBConnection;

public class BookingDAO {

    public boolean bookTicket(Booking booking) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                    "insert into bookings(user_id,bus_id,seats_booked,total_amount) values(?,?,?,?)");

            ps.setInt(1, booking.getUserId());
            ps.setInt(2, booking.getBusId());
            ps.setInt(3, booking.getSeatsBooked());
            ps.setDouble(4, booking.getTotalAmount());

            int result = ps.executeUpdate();

            if(result > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}
package com.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bus.model.Bus;
import com.bus.util.DBConnection;

public class BusDAO {

    // Search buses
    public List<Bus> searchBus(String source, String destination) {

        List<Bus> busList = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "select * from buses where source=? and destination=?");

            ps.setString(1, source);
            ps.setString(2, destination);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Bus bus = new Bus();

                bus.setBusId(rs.getInt("bus_id"));
                bus.setBusName(rs.getString("bus_name"));
                bus.setSource(rs.getString("source"));
                bus.setDestination(rs.getString("destination"));
                bus.setTotalSeats(rs.getInt("total_seats"));
                bus.setAvailableSeats(rs.getInt("available_seats"));
                bus.setFare(rs.getDouble("fare"));

                busList.add(bus);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return busList;
    }

    // Get bus by ID
    public Bus getBusById(int busId) {

        Bus bus = null;

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "select * from buses where bus_id=?");

            ps.setInt(1, busId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                bus = new Bus();

                bus.setBusId(rs.getInt("bus_id"));
                bus.setBusName(rs.getString("bus_name"));
                bus.setSource(rs.getString("source"));
                bus.setDestination(rs.getString("destination"));
                bus.setTotalSeats(rs.getInt("total_seats"));
                bus.setAvailableSeats(rs.getInt("available_seats"));
                bus.setFare(rs.getDouble("fare"));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return bus;
    }

    // Reduce seats after booking
    public boolean updateSeats(int busId, int seatsBooked) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update buses set available_seats = available_seats - ? where bus_id=?");

            ps.setInt(1, seatsBooked);
            ps.setInt(2, busId);

            int result = ps.executeUpdate();

            if(result > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // Add seats back after cancellation
    public boolean increaseSeats(int busId, int seatsBooked) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "update buses set available_seats = available_seats + ? where bus_id=?");

            ps.setInt(1, seatsBooked);
            ps.setInt(2, busId);

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
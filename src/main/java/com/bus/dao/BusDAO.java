package com.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bus.util.DBConnection;

public class BusDAO {

    public ResultSet searchBus(
            String source,
            String destination) {

        ResultSet rs = null;

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                    "select * from buses where source=? and destination=?");

            ps.setString(1, source);
            ps.setString(2, destination);

            rs = ps.executeQuery();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return rs;
    }
}
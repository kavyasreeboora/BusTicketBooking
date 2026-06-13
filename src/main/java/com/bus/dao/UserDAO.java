package com.bus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bus.model.User;
import com.bus.util.DBConnection;

public class UserDAO {

    public boolean registerUser(User user) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                    "insert into users(name,email,password) values(?,?,?)");

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());

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
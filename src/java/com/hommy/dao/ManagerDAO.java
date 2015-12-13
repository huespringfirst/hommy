package com.hommy.dao;

import com.hommy.connection.ConnectionFactory;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManagerDAO {

    public ManagerDAO() {
    }

    public boolean creatNewManager(String username, String password,
            String firstname, String lastname, String avatar, String city,
            String province, String phone, String email) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO manager (username, password, firstname, lastname, avatar, city, province, phone, email) "
                    + "VALUES ('" + username + "','" + password + "','" + firstname + "','" + lastname + "','"
                    + avatar + "','" + city + "','" + province + "','" + phone + "','" + email + "')";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

    public boolean changePasswordManager(String username, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "UPDATE manager SET password = '" + password + "' WHERE username = '" + username + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

    public boolean creatRole(String username, int role) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO manager_role (username, role) VALUES ('" + username + "','" + role + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

    public boolean updateRole(String username, int role) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "UPDATE manager_role SET role = '" + role + "' WHERE username = '" + username + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

    public boolean updateManagerInformation(String username, String firstname, String lastname,
            String city, String province, String phone, String email) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "UPDATE manager SET firstname = '" + firstname + "',lastname = '" + lastname
                    + "',city = '" + city + "',province = '" + province + "',phone = '" + phone
                    + "',email = '" + email + "' WHERE username = '" + username + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

}

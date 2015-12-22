package com.hommy.dao;

import com.hommy.connection.ConnectionFactory;
import com.hommy.entity.Member;
import com.hommy.entity.MemberClock;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MemberDAO {

    public MemberDAO() {
    }

    //creat new member
    public boolean createMember(String username, String password,
            String firstname, String lastname, String gender, String avatar, String city,
            String district, String phone, String email) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO member (username, password, firstname, lastname, gender, avatar, city, district, phone, email) "
                    + "VALUES ('" + username + "','" + password + "','" + firstname + "','" + lastname + "','" + gender + "','"
                    + avatar + "','" + city + "','" + district + "','" + phone + "','" + email + "')";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

    //creat clock
    public boolean createMC(String username, Date timecurrent, int steptime) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO member_clock (username, timecurrent, steptime) "
                    + "VALUES ('" + username + toSringDateTime(timecurrent) + "','" + steptime + "')";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

    //delete clock
    public boolean deleteMC(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM member_clock WHERE username = '" + username + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

    //change password
    public boolean updatePasswordMember(String username, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "UPDATE member SET password = '" + password + "' WHERE username = '" + username + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

    //update private information
    public boolean updateInformationMember(String username, String firstname, String lastname, String gender,
            String city, String district, String phone, String email) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "UPDATE member SET firstname = '" + firstname + "',lastname = '" + lastname + "',gender = '" + gender 
                    + "',city = '" + city + "',district = '" + district + "',phone = '" + phone
                    + "',email = '" + email + "' WHERE username = '" + username + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

    //find all members
    public ArrayList<Member> findAllMembers() throws SQLException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM member";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ArrayList<Member> list = new ArrayList<>();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Member entity = new Member();
                    entity.setUsername(rs.getString("username"));
                    entity.setPassword(rs.getString("password"));
                    entity.setFirstname(rs.getString("firstname"));
                    entity.setLastname(rs.getString("lastname"));
                    entity.setGender(rs.getString("gender"));
                    entity.setAvatar(rs.getString("avatar"));
                    entity.setCity(rs.getString("city"));
                    entity.setDistrict(rs.getString("district"));
                    entity.setPhone(rs.getString("phone"));
                    entity.setEmail(rs.getString("email"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //find member by username
    public Member findMemberByUsername(String username) throws SQLException,
            ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM member WHERE username = '" + username + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                Member entity = new Member();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    entity.setUsername(rs.getString("username"));
                    entity.setPassword(rs.getString("password"));
                    entity.setFirstname(rs.getString("firstname"));
                    entity.setLastname(rs.getString("lastname"));
                    entity.setGender(rs.getString("gender"));
                    entity.setAvatar(rs.getString("avatar"));
                    entity.setCity(rs.getString("city"));
                    entity.setDistrict(rs.getString("district"));
                    entity.setPhone(rs.getString("phone"));
                    entity.setEmail(rs.getString("email"));
                }
                return entity;
            }
        }
    }

    //find list member_clock by username
    public ArrayList<MemberClock> findMCByUsername(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM member_clock WHERE username = '" + username + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<MemberClock> list = new ArrayList<>();
                while (rs.next()) {
                    MemberClock entity = new MemberClock();
                    entity.setUsername(rs.getString("username"));
                    entity.setTimecurrent(rs.getDate("timecurrent"));
                    entity.setSteptime(rs.getInt("steptime"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    public String toSringDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

}

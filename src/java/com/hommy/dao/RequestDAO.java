package com.hommy.dao;

import com.hommy.connection.ConnectionFactory;
import com.hommy.entity.Request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class RequestDAO {

    public RequestDAO() {
    }

    //create new request
    public boolean createRequest(String type_request_name, String username, String subject, String description, Date time,
            String street, String province, String area, String cost) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO request (type_request_name, username, subject, description, time, street, province, area, cost, contact) "
                    + "VALUES ('" + type_request_name + "','" + username + "','" + subject + "','" + description + "','" + toSringDateTime(time) + "','" + street + "','"
                    + province + "','" + area + "','" + cost + "')";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

    //delete request
    public boolean deleteRequest(int idrequest) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM request WHERE idrequest = '" + idrequest + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

    //edit request
    public boolean updateRequest(String idrequest, String type_request_name, String username, String subject, String description, Date time,
            String street, String province, String area, String cost) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "UPDATE request SET type_request_name = '" + type_request_name + "',username = '" + username
                    + "',subject = '" + subject + "',description = '" + description + "', time = '" + toSringDateTime(time)
                    + "',street = '" + street + "',province = '" + province 
                    + "',area = '" + area + "',cost = '" + cost + "' WHERE idrequest = '" + idrequest + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }
    
    //set up hide request <hide = 0>
    public boolean updateHideRequest(int idrequest) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "UPDATE request SET hide = '0' WHERE idrequest = '" + idrequest + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

    //check request - asign check = 1
    public boolean checkRequest(int idrequest) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "UPDATE request SET check = '1' WHERE idrequest = '" + idrequest + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                return ps.executeUpdate() > 0;
            }
        }
    }

    //find all requests
    public ArrayList<Request> findAllRequests() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //find requests by username
    public ArrayList<Request> findRequestsByUsername(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE username = '" + username + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //find request by username checked
    public ArrayList<Request> findRequestsByUsernameChecked(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE username = '" + username + "' AND check = '1'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //find request by username don't check
    public ArrayList<Request> findRequestsByUsernameNoChecked(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE username = '" + username + "' AND check = '0'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //find requests checked
    public ArrayList<Request> findRequestsChecked() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE check = '1'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //find requests don't check
    public ArrayList<Request> findRequestsNoChecked() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE check = '0'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //find requests by province
    public ArrayList<Request> findRequestsByProvince(String province) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE province = '" + province + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //find requests by street && province
    public ArrayList<Request> findRequestsByStreet(String street, String province) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE province = '" + province + "' AND street = '" + street + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //find requests by type_request_name
    public ArrayList<Request> findRequestsByType(String type_request_name) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE type_request_name = '" + type_request_name + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //find requests by hide = 0 && check = 1- public
    public ArrayList<Request> findRequestsShowCheck() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE hide = '0' AND check = '1'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }
    //find requests by province && type_request_name
    //find requests by province && type_request_name && street
    //find requests LIKE character by subject and description
    
    //sort cost ASC by province
    //sort coset ASC by type_request_name
    //sort cost ASC
    public ArrayList<Request> findRequestsSortCostASC() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE cost ORDER BY ASC";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //sort cost DESC
    public ArrayList<Request> findRequestsSortCostDESC() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE cost ORDER BY DESC";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //sort time ASC
    public ArrayList<Request> findRequestsSortTimeASC() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE time ORDER BY ASC";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //sort time DESC
    public ArrayList<Request> findRequestsSortTimeDESC() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE time ORDER BY DESC";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //sort area ASC
    public ArrayList<Request> findRequestsSortAreaASC() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE area ORDER BY ASC";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //sort area DESC
    public ArrayList<Request> findRequestsSortAreaDESC() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM request WHERE area ORDER BY DESC";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                ArrayList<Request> list = new ArrayList<>();
                while (rs.next()) {
                    Request entity = new Request();
                    entity.setIdrequest(rs.getInt("idrequest"));
                    entity.setUsername(rs.getString("username"));
                    entity.setType_request_name(rs.getString("type_request_name"));
                    entity.setSubject(rs.getString("subject"));
                    entity.setDescription(rs.getString("description"));
                    entity.setTime(rs.getDate("time"));
                    entity.setStreet(rs.getString("street"));
                    entity.setProvince(rs.getString("province"));
                    entity.setCost(rs.getString("cost"));
                    entity.setHide(rs.getInt("hide"));
                    entity.setCheck(rs.getInt("check"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

    //create comment request
    //delete comment request
    //edit comment request
    //find all comment request by idrequest
    //-------------------format---------------------//
    public String toSringDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}

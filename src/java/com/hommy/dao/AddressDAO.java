package com.hommy.dao;

import com.hommy.connection.ConnectionFactory;
import com.hommy.entity.City;
import com.hommy.entity.District;
import com.hommy.entity.Wards;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddressDAO {

    public AddressDAO() {
    }

    //find all cities
    public ArrayList<City> findAllCities() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM city";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ArrayList<City> list = new ArrayList<>();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    City entity = new City();
                    entity.setId(rs.getInt("id"));
                    entity.setCity_name(rs.getString("city_name"));
                    list.add(entity);
                }
                return list;
            }
        }
    }
    
    //find district by city_id
    public ArrayList<District>  findDistrictsByCityId(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
         try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT p.* FROM district p , city c WHERE c.id = d.city_id AND c.id = '" + id + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ArrayList<District> list = new ArrayList<>();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    District entity = new District();
                    entity.setCity_id(rs.getInt("city_id"));
                    entity.setDistrict_name(rs.getString("district_name"));
                    list.add(entity);
                }
                return list;
            }
        }
    }
    
    //find all districts
    public ArrayList<District> findAllDistricts() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
         try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM district";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ArrayList<District> list = new ArrayList<>();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    District entity = new District();
                    entity.setDistrict_id(rs.getInt("district_id"));
                    entity.setCity_id(rs.getInt("city_id"));
                    entity.setDistrict_name(rs.getString("district_name"));
                    list.add(entity);
                }
                return list;
            }
        }
    }
    
    //find districts in Da Nang
     public ArrayList<District> findDistrictsInDaNang() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
         try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT d.* FROM district d, city c WHERE c.id = d.city_id AND c.city_name LIKE 'Da Nang'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ArrayList<District> list = new ArrayList<>();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    District entity = new District();
                    entity.setCity_id(rs.getInt("city_id"));
                    entity.setDistrict_name(rs.getString("district_name"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

     //find district by name city
      public ArrayList<District> findDistrictByCityName(String city_name) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
         try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT d.* FROM district d, city c WHERE c.id = d.city_id AND c.city_name = '" + city_name + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ArrayList<District> list = new ArrayList<>();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    District entity = new District();
                    entity.setDistrict_id(rs.getInt("district_id"));
                    entity.setCity_id(rs.getInt("city_id"));
                    entity.setDistrict_name(rs.getString("district_name"));
                    list.add(entity);
                }
                return list;
            }
        }
    }
     
      //find wards by name district
      public ArrayList<Wards> findWardsByDistrictName(String district_name) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
         try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT w.* FROM district d, wards w WHERE d.district_id = w.district_district_id "
                    + "AND d.district_name = '" + district_name + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ArrayList<Wards> list = new ArrayList<>();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Wards entity = new Wards();
                    entity.setWards_id(rs.getInt("wards_id"));
                    entity.setDistrict_district_id(rs.getInt("district_district_id"));
                    entity.setWards_name(rs.getString("wards_name"));
                    list.add(entity);
                }
                return list;
            }
        }
    }
}

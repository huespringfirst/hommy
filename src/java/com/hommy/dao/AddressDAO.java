package com.hommy.dao;

import com.hommy.connection.ConnectionFactory;
import com.hommy.entity.City;
import com.hommy.entity.Provinces;
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
    
    //find provinces by city_id
    public ArrayList<Provinces>  findProvincesByCityId(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
         try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT p.* FROM provinces p , city c WHERE c.id = p.city_id AND c.id = '" + id + "'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ArrayList<Provinces> list = new ArrayList<>();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Provinces entity = new Provinces();
                    entity.setCity_id(rs.getInt("city_id"));
                    entity.setProvince_name(rs.getString("province_name"));
                    list.add(entity);
                }
                return list;
            }
        }
    }
    
    //find all provinces
    public ArrayList<Provinces> findAllProvinces() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
         try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM provinces";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ArrayList<Provinces> list = new ArrayList<>();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Provinces entity = new Provinces();
                    entity.setCity_id(rs.getInt("city_id"));
                    entity.setProvince_name(rs.getString("province_name"));
                    list.add(entity);
                }
                return list;
            }
        }
    }
    
    //find provinces in Da Nang
     public ArrayList<Provinces> findProvincesInDaNang() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
         try (Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT p.* FROM provinces p, city c WHERE c.id = p.city_id AND c.city_name LIKE 'Da Nang'";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ArrayList<Provinces> list = new ArrayList<>();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Provinces entity = new Provinces();
                    entity.setCity_id(rs.getInt("city_id"));
                    entity.setProvince_name(rs.getString("province_name"));
                    list.add(entity);
                }
                return list;
            }
        }
    }

}

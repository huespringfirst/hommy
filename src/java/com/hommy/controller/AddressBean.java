
package com.hommy.controller;

import com.hommy.dao.AddressDAO;
import com.hommy.entity.City;
import com.hommy.entity.Provinces;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class AddressBean {
    
    private City city = new City();
    private Provinces provinces = new Provinces();

    public AddressBean() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Provinces getProvinces() {
        return provinces;
    }

    public void setProvinces(Provinces provinces) {
        this.provinces = provinces;
    }

    public int getId() {
        return city.getId();
    }

    public void setId(int id) {
        city.setId(id);
    }

    public String getCity_name() {
        return city.getCity_name();
    }

    public void setCity_name(String city_name) {
        city.setCity_name(city_name);
    }

    public int getCity_id() {
        return provinces.getCity_id();
    }

    public void setCity_id(int city_id) {
        provinces.setCity_id(city_id);
    }

    public String getProvince_name() {
        return provinces.getProvince_name();
    }

    public void setProvince_name(String province_name) {
        provinces.setProvince_name(province_name);
    }
    
    public ArrayList<City> getAllCities() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        AddressDAO dao = new AddressDAO();
        return dao.findAllCities();
    }
    
    public ArrayList<Provinces> getProvincesByCityId() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        AddressDAO dao = new AddressDAO();
        return dao.findProvincesByCityId(city.getId());
    }
    
    public ArrayList<Provinces> getAllProvinces() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        AddressDAO dao = new AddressDAO();
        return dao.findAllProvinces();
    }
    
    //find provinces in Da Nang
    public ArrayList<Provinces> getProvincesInDaNang() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        AddressDAO dao = new AddressDAO();
        return dao.findProvincesInDaNang();
    }
}


package com.hommy.controller;

import com.hommy.dao.AddressDAO;
import com.hommy.entity.City;
import com.hommy.entity.District;
import com.hommy.entity.Wards;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;


@ManagedBean
@SessionScoped
public class AddressBean {
    
    private City city = new City();
    private District district = new District();
    private Wards wards = new Wards();

    public AddressBean() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Wards getWards() {
        return wards;
    }

    public void setWards(Wards wards) {
        this.wards = wards;
    }

    //find all cities
    public ArrayList<City> getAllCities() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        AddressDAO dao = new AddressDAO();
        return dao.findAllCities();
    }
    
    //find all district
    public ArrayList<District> getAllDistrict() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        AddressDAO dao = new AddressDAO();
        return dao.findAllDistricts();
    }
    
    //find district in Da Nang
    public ArrayList<District> getDistrictsInDaNang() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        AddressDAO dao = new AddressDAO();
        return dao.findDistrictsInDaNang();
    }
    
    //find districts by city_name
    public ArrayList<District> getDistrictsByCityName(String city_name) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
         AddressDAO dao = new AddressDAO();
         return dao.findDistrictByCityName(city_name);
    }
    
   //find wards by district_name
    public ArrayList<Wards> getWardsByDistrictName(String district_name) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
         AddressDAO dao = new AddressDAO();
         return dao.findWardsByDistrictName(district_name);
    }
    
    
}


package com.hommy.controller;

import com.hommy.entity.Manager;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class ManagerBean {

    private Manager manager = new Manager();
    
    public ManagerBean() {
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getUsername() {
        return manager.getUsername();
    }

    public void setUsername(String username) {
        manager.setUsername(username);
    }

    public String getPassword() {
        return manager.getPassword();
    }

    public void setPassword(String password) {
        manager.setPassword(password);
    }

    public String getFirstname() {
        return manager.getFirstname();
    }

    public void setFirstname(String firstname) {
        manager.setFirstname(firstname);
    }

    public String getLastname() {
        return manager.getLastname();
    }

    public void setLastname(String lastname) {
        manager.setLastname(lastname);
    }

    public String getGender() {
        return manager.getGender();
    }

    public void setGender(String gender) {
        manager.setGender(gender);
    }

    public String getAvatar() {
        return manager.getAvatar();
    }

    public void setAvatar(String avatar) {
        manager.setAvatar(avatar);
    }

    public String getCity() {
        return manager.getCity();
    }

    public void setCity(String city) {
        manager.setCity(city);
    }

    public String getProvince() {
        return manager.getProvince();
    }

    public void setProvince(String province) {
        manager.setProvince(province);
    }

    public String getPhone() {
        return manager.getPhone();
    }

    public void setPhone(String phone) {
        manager.setPhone(phone);
    }

    public String getEmail() {
        return manager.getEmail();
    }

    public void setEmail(String email) {
        manager.setEmail(email);
    }
    
    
}

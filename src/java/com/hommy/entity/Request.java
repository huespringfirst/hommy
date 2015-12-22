
package com.hommy.entity;

import java.util.Date;

public class Request {
    
    private int idrequest;
    private String username;
    private String type_request_name;
    private String subject;
    private String description;
    private Date time;
    private String district;
    private String wards;
    private String area;
    private String cost;
    private int hide;
    private int check;

    public Request() {
    }

    public int getIdrequest() {
        return idrequest;
    }

    public void setIdrequest(int idrequest) {
        this.idrequest = idrequest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType_request_name() {
        return type_request_name;
    }

    public void setType_request_name(String type_request_name) {
        this.type_request_name = type_request_name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWards() {
        return wards;
    }

    public void setWards(String wards) {
        this.wards = wards;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getHide() {
        return hide;
    }

    public void setHide(int hide) {
        this.hide = hide;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
    
}

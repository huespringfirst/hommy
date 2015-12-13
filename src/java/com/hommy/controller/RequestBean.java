package com.hommy.controller;

import com.hommy.dao.RequestDAO;
import com.hommy.entity.Request;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class RequestBean {

    private Request request = new Request();

    public RequestBean() {
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public int getIdrequest() {
        return request.getIdrequest();
    }

    public void setIdrequest(int idrequest) {
        request.setIdrequest(idrequest);
    }

    public String getUsername() {
        return request.getUsername();
    }

    public void setUsername(String username) {
        request.setUsername(username);
    }

    public String getType_request_name() {
        return request.getType_request_name();
    }

    public void setType_request_name(String type_request_name) {
        request.setType_request_name(type_request_name);
    }

    public String getSubject() {
        return request.getSubject();
    }

    public void setSubject(String subject) {
        request.setSubject(subject);
    }

    public String getDescription() {
        return request.getDescription();
    }

    public void setDescription(String description) {
        request.setDescription(description);
    }

    public Date getTime() {
        return request.getTime();
    }

    public void setTime(Date time) {
        request.setTime(time);
    }

    public String getStreet() {
        return request.getStreet();
    }

    public void setStreet(String street) {
        request.setStreet(street);
    }

    public String getProvince() {
        return request.getProvince();
    }

    public void setProvince(String province) {
        request.setProvince(province);
    }

    public String getArea() {
        return request.getArea();
    }

    public void setArea(String area) {
        request.setArea(area);
    }

    public String getCost() {
        return request.getCost();
    }

    public void setCost(String cost) {
        request.setCost(cost);
    }

    public int getHide() {
        return request.getHide();
    }

    public void setHide(int hide) {
        request.setHide(hide);
    }

    public int getCheck() {
        return request.getCheck();
    }

    public void setCheck(int check) {
        request.setCheck(check);
    }

    //set hide request <hide = 0>
    //create type_request (admin)
    //check non value - true is empty
    public boolean checkEmpty() {
        if (request.getSubject().equals("") && request.getDescription().equals("")) {
            return false;
        }
        return true;
    }

    //check content >= 10 words - true: >= 10 words
    public boolean checkWord() {
        String[] array = request.getDescription().split(" ");
        if (array.length >= 10) {
            return true;
        }
        return false;
    }
    
    //check number

    //test post's information
    public String testPostRequest() {
        if (checkEmpty()) {
            if (checkWord()) {
                return "view_request";
            } else {
                //show message
                return "post_request";
            }
        }
        //show message
        return "post_request";
    }

    //create new post request
    public String createNewRequest(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Date time = new Date();
        RequestDAO dao = new RequestDAO();
        dao.createRequest(request.getType_request_name(), username, request.getSubject(), request.getDescription(),
                time, request.getStreet(), request.getProvince(), request.getArea(),
                request.getCost());
        return "done_request";
    }

    //delete post request if check = 0
    //delete post request is same
    //edit post request <check = 0>
    //check edit - true: check = 1
    //check hide - true: hide = 0
    //check check - true: check = 1
    //find requests are waiting for check
    //find requests have been check <check = 1> && show <hide = 0> -> public
    //find requests are error
    //-----------format---------------//
    public String toSringDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    
    
}

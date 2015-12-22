package com.hommy.controller;

import com.hommy.dao.AddressDAO;
import com.hommy.dao.RequestDAO;
import com.hommy.entity.District;
import com.hommy.entity.Request;
import com.hommy.entity.Wards;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ManagedBean
@SessionScoped
public class RequestBean {

    private String check;
    private String message;
    private ArrayList<Wards> listWards = new ArrayList<>();
    private Request request = new Request();

    public RequestBean() {
    }

    public String isCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Wards> getListWards() {
        return listWards;
    }

    public void setListWards(ArrayList<Wards> listWards) {
        this.listWards = listWards;
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

    public String getDistrict() {
        return request.getDistrict();
    }

    public void setDistrict(String district) {
        request.setDistrict(district);
    }

    public String getWards() {
        return request.getWards();
    }

    public void setWards(String wards) {
        request.setWards(wards);
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
                message = "thieu tu";
                return "post_request";
            }
        }
        //show message
        message = "trong";
        return "post_request";
    }

    //create new post request
    public String createNewRequest(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Date time = new Date();
        RequestDAO dao = new RequestDAO();
        dao.createRequest(request.getType_request_name(), username, request.getSubject(), request.getDescription(),
                time, request.getDistrict(), request.getWards(), request.getArea(),
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
    //use ajax
    public void useAjax(AjaxBehaviorEvent event) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        AddressDAO dao = new AddressDAO();
        ArrayList<District> list = dao.findDistrictsInDaNang();
        for (District item : list) {
            if (request.getDistrict().equals(item.getDistrict_name())) {
                listWards = dao.findWardsByDistrictName(request.getDistrict());
            }
        }
    }

    //check type request - true: buy
    public void checkType(AjaxBehaviorEvent event) {
        if (request.getType_request_name().equalsIgnoreCase("Home - Buy")
                || request.getType_request_name().equalsIgnoreCase("Aparterment - Buy")) {
            check = "VND";
        } else {
            check = "VND/month";
        }
    }

    //-----------format---------------//
    public String toSringDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    
}

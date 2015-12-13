
package com.hommy.controller;

import com.hommy.entity.TypeAds;
import com.hommy.entity.TypeProvide;
import com.hommy.entity.TypeReport;
import com.hommy.entity.TypeRequest;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class TypePostBean {

    private TypeAds ads = new TypeAds();
    private TypeReport report = new TypeReport();
    private TypeProvide provide = new TypeProvide();
    private TypeRequest request = new TypeRequest();
    
    public TypePostBean() {
    }

    public TypeAds getAds() {
        return ads;
    }

    public void setAds(TypeAds ads) {
        this.ads = ads;
    }

    public TypeReport getReport() {
        return report;
    }

    public void setReport(TypeReport report) {
        this.report = report;
    }

    public TypeProvide getProvide() {
        return provide;
    }

    public void setProvide(TypeProvide provide) {
        this.provide = provide;
    }

    public TypeRequest getRequest() {
        return request;
    }

    public void setRequest(TypeRequest request) {
        this.request = request;
    }
    
    
}

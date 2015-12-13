
package com.hommy.entity;

import java.util.Date;


public class CommentRequest {
    
    private String username;
    private int request_idrequest;
    private String content;
    private Date time;

    public CommentRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRequest_idrequest() {
        return request_idrequest;
    }

    public void setRequest_idrequest(int request_idrequest) {
        this.request_idrequest = request_idrequest;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    
}

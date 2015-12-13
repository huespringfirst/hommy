
package com.hommy.entity;

import java.util.Date;


public class MemberClock {
    
    private String username;
    private Date timecurrent;
    private int steptime;

    public MemberClock() {
    }

    public MemberClock(String username, Date timecurrent, int steptime) {
        this.username = username;
        this.timecurrent = timecurrent;
        this.steptime = steptime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTimecurrent() {
        return timecurrent;
    }

    public void setTimecurrent(Date timecurrent) {
        this.timecurrent = timecurrent;
    }

    public int getSteptime() {
        return steptime;
    }

    public void setSteptime(int steptime) {
        this.steptime = steptime;
    }
    
}

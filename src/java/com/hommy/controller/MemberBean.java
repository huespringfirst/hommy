package com.hommy.controller;

import com.hommy.dao.AddressDAO;
import com.hommy.dao.MemberDAO;
import com.hommy.entity.City;
import com.hommy.entity.District;
import com.hommy.entity.Member;
import com.hommy.entity.MemberClock;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
public class MemberBean {

    private ArrayList<District> listDistricts = new ArrayList<>();
    private String passold;
    private String passnew1;
    private String passnew2;
    private Member member = new Member();
    private Part file;
    String message;

    public ArrayList<District> getListDistricts() {
        return listDistricts;
    }

    public void setListDistricts(ArrayList<District> listDistricts) {
        this.listDistricts = listDistricts;
    }

    public String getPassold() {
        return passold;
    }

    public void setPassold(String passold) {
        this.passold = passold;
    }

    public String getPassnew1() {
        return passnew1;
    }

    public void setPassnew1(String passnew1) {
        this.passnew1 = passnew1;
    }

    public String getPassnew2() {
        return passnew2;
    }

    public void setPassnew2(String passnew2) {
        this.passnew2 = passnew2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MemberBean() {
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getUsername() {
        return member.getUsername();
    }

    public void setUsername(String username) {
        member.setUsername(username);
    }

    public String getPassword() {
        return member.getPassword();
    }

    public void setPassword(String password) {
        member.setPassword(password);
    }

    public String getFirstname() {
        return member.getFirstname();
    }

    public void setFirstname(String firstname) {
        member.setFirstname(firstname);
    }

    public String getLastname() {
        return member.getLastname();
    }

    public void setLastname(String lastname) {
        member.setLastname(lastname);
    }

    public String getGender() {
        return member.getGender();
    }

    public void setGender(String gender) {
        member.setGender(gender);
    }

    public String getAvatar() {
        return member.getAvatar();
    }

    public void setAvatar(String avatar) {
        member.setAvatar(avatar);
    }

    public String getCity() {
        return member.getCity();
    }

    public void setCity(String city) {
        member.setCity(city);
    }

    public String getDistrict() {
        return member.getDistrict();
    }

    public void setDistrict(String province) {
        member.setDistrict(province);
    }

    public String getPhone() {
        return member.getPhone();
    }

    public void setPhone(String phone) {
        member.setPhone(phone);
    }

    public String getEmail() {
        return member.getEmail();
    }

    public void setEmail(String email) {
        member.setEmail(email);
    }

    //upload image from my computer
    public void uploadNewFileMember() throws IOException {
        InputStream input = file.getInputStream();
        Files.copy(input, new File("D:\\JavaIVietech_LyThuyet\\IViettech\\Demo\\hommy\\web\\resources\\imagesMember",
                file.getSubmittedFileName()).toPath());
        member.setAvatar(file.getSubmittedFileName());
        renameFileMember();
    }

    //copy file on server - female
    public void copyFileFemale() throws IOException {
        File oldfile = new File("D:\\JavaIVietech_LyThuyet\\IViettech\\Demo\\hommy\\web\\resources\\images\\avatar_female.png");
        File newfile = new File("D:\\JavaIVietech_LyThuyet\\IViettech\\Demo\\hommy\\web\\resources\\imagesMember\\" + member.getUsername() + ".png");
        Files.copy(oldfile.toPath(), newfile.toPath());
    }

    //copy file on server - male
    public void copyFileMale() throws IOException {
        File oldfile = new File("D:\\JavaIVietech_LyThuyet\\IViettech\\Demo\\hommy\\web\\resources\\images\\avatar_male.png");
        File newfile = new File("D:\\JavaIVietech_LyThuyet\\IViettech\\Demo\\hommy\\web\\resources\\imagesMember\\" + member.getUsername() + ".png");
        Files.copy(oldfile.toPath(), newfile.toPath());
    }

    //rename image - format image.png
    public void renameFileMember() {
        File oldfile = new File("D:\\JavaIVietech_LyThuyet\\IViettech\\Demo\\hommy\\web\\resources\\imagesMember\\" + member.getAvatar());
        File newfile = new File("D:\\JavaIVietech_LyThuyet\\IViettech\\Demo\\hommy\\web\\resources\\imagesMember\\" + member.getUsername() + ".png");
        oldfile.renameTo(newfile);
        member.setAvatar(member.getUsername() + ".png");
    }

    //change avatar
    public void changeAvatar() throws IOException {
        deleteFileMember();
        uploadNewFileMember();
    }

    //delete old image
    public void deleteFileMember() {
        File currentfile = new File("D:\\JavaIVietech_LyThuyet\\IViettech\\Demo\\hommy\\web\\resources\\imagesMember\\" + member.getUsername() + ".png");
        currentfile.delete();
    }

    //check value empty - true: not empty
    public boolean checkEmpty() {
        if (member.getUsername().equals("") && member.getPassword().equals("")
                && member.getFirstname().equals("") && member.getLastname().equals("")
                && member.getCity().equals("") && member.getDistrict().equals("")
                && member.getPhone().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    //create new account
    public String createNewMember() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        if (checkEmpty()) {
            if (checkExist(member.getUsername())) {
                MemberDAO dao = new MemberDAO();
                if (member.getGender().equalsIgnoreCase("Male")) {
                    copyFileMale();
                    member.setAvatar(member.getUsername() + ".png");
                } else {
                    if (member.getGender().equalsIgnoreCase("Female")) {
                        copyFileFemale();
                        member.setAvatar(member.getUsername() + ".png");
                    }
                }
                dao.createMember(member.getUsername(), member.getPassword(),
                        member.getFirstname(), member.getLastname(),
                        member.getGender(), member.getAvatar(), member.getCity(),
                        member.getDistrict(), member.getPhone(), member.getEmail());
                return "login";
            } else {
                //show message
                return "signup";
            }
        } else {
            //show message
            return "signup";
        }
    }

    //clock memeber
    public void clockMember(String username, int steptime) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        MemberDAO dao = new MemberDAO();
        Date timecurrent = new Date();
        dao.createMC(username, timecurrent, steptime);
    }

    //delete clocked
    public void deleteMC(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        MemberDAO dao = new MemberDAO();
        dao.deleteMC(username);
    }

    //check username - true: no exist
    public boolean checkExist(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Member entity = getMemberByUsername(username);
        if (entity.getUsername() == null) {
            return true;
        }
        return false;
    }

    //check clocked - true: clocking
    public boolean checkClocked(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ArrayList<MemberClock> list = getMCByUsername(username);
        if (list != null) {
            Date date = new Date();
            String t = toSringDateTime(date);
            for (MemberClock entity : list) {
                String tb = toSringDateTime(entity.getTimecurrent());
                String tf = addDate(entity.getTimecurrent(), entity.getSteptime());
                if (t.compareTo(tb) > 0 && t.compareTo(tf) < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    //check password - true: exist user and password is right
    public boolean checkPassword(String username, String password) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Member entity = getMemberByUsername(username);
        if (entity != null && entity.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    //add date
    public String addDate(Date date, int days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return sdf.format(c.getTime());
    }

    //login
    public String loginMember() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (checkPassword(member.getUsername(), member.getPassword())) {
            if (!checkClocked(member.getUsername())) {
                Member entity = getMemberByUsername(member.getUsername());
                member.setUsername(entity.getUsername());
                member.setFirstname(entity.getFirstname());
                member.setLastname(entity.getLastname());
                member.setAvatar(entity.getAvatar());
                member.setCity(entity.getCity());
                member.setDistrict(entity.getDistrict());
                member.setPhone(entity.getPhone());
                member.setEmail(entity.getEmail());
                return "post_request";
            } else {
                //show message - your account had been clocked
                return "login";
            }
        } else {
            //show message - username or password is wrong
            return "login";
        }
    }

    //change password
    public void changePasswordMember() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        if(!passold.equals("") && !passnew1.equals("") && !passnew2.equals("")){
           Member entity = getMemberByUsername(member.getUsername());
           if(entity.getPassword().equals(passold)){
               if(passnew1.equals(passnew2)){
               MemberDAO dao = new MemberDAO();
               dao.updatePasswordMember(member.getUsername(), passnew1);
               }else{
                   //show message - password confirm is incorrect
               }
           }else{
               //show message - password old is incorrect
           }
        }else{
            //show message - not empty
        }
    }
    
    //change personal information
    public void changeInformationMember() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        if(!member.getFirstname().equals("") && !member.getLastname().equals("") && !member.getCity().equals("")
                && !member.getPhone().equals("")){
            MemberDAO dao = new MemberDAO();
            dao.updateInformationMember(member.getUsername(), member.getFirstname(), member.getLastname(), member.getGender(),
                    member.getCity(), member.getDistrict(), member.getPhone(), member.getEmail());
        }else{
            //show message
        }
    }
    
    
    //find list member_clock by username
    public ArrayList<MemberClock> getMCByUsername(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        MemberDAO dao = new MemberDAO();
        return dao.findMCByUsername(username);
    }

    //find member by username
    public Member getMemberByUsername(String username) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        MemberDAO dao = new MemberDAO();
        return dao.findMemberByUsername(username);
    }

    //find all members
    public ArrayList<Member> getAllMembers() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        MemberDAO dao = new MemberDAO();
        return dao.findAllMembers();
    }

     //use ajax
    public void useAjax(AjaxBehaviorEvent event) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        AddressDAO dao = new AddressDAO();
        ArrayList<City> list = dao.findAllCities();
        for (City item : list) {
            if(member.getCity().equals(item.getCity_name())){
                listDistricts = dao.findDistrictByCityName(member.getCity());
            }
        }
    }
    
    //find member by request_idrequest
    //find member by provide_idprovide
    //find member by news_idnews
    //find memeber by idads
    /* ------------------format------------------ */
    public String toSringDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

}

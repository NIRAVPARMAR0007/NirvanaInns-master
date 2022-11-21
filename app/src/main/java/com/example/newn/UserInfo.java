package com.example.newn;

public class UserInfo {
    private String edit_name;
    private String edit_address;
    private String edit_uid;
    private String edit_pan;
    private String edit_birthdate;
    private String edit_email;
    private String edit_date;
    public UserInfo(){

    }

    public UserInfo(String edit_name, String edit_address, String edit_uid, String edit_pan, String edit_birthdate, String edit_email, String edit_date) {
        this.edit_name = edit_name;
        this.edit_address = edit_address;
        this.edit_uid = edit_uid;
        this.edit_pan = edit_pan;
        this.edit_birthdate = edit_birthdate;
        this.edit_email = edit_email;
        this.edit_date = edit_date;
    }

    public String getEdit_name() {
        return edit_name;
    }

    public void setEdit_name(String edit_name) {
        this.edit_name = edit_name;
    }

    public String getEdit_address() {
        return edit_address;
    }

    public void setEdit_address(String edit_address) {
        this.edit_address = edit_address;
    }

    public String getEdit_uid() {
        return edit_uid;
    }

    public void setEdit_uid(String edit_uid) {
        this.edit_uid = edit_uid;
    }

    public String getEdit_pan() {
        return edit_pan;
    }

    public void setEdit_pan(String edit_pan) {
        this.edit_pan = edit_pan;
    }

    public String getEdit_birthdate() {
        return edit_birthdate;
    }

    public void setEdit_birthdate(String edit_birthdate) {
        this.edit_birthdate = edit_birthdate;
    }

    public String getEdit_email() {
        return edit_email;
    }

    public void setEdit_email(String edit_email) {
        this.edit_email = edit_email;
    }

    public String getEdit_date() {
        return edit_date;
    }

    public void setEdit_date(String edit_date) {
        this.edit_date = edit_date;
    }
}

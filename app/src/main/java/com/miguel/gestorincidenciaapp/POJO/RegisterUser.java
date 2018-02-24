package com.miguel.gestorincidenciaapp.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

public class RegisterUser {


    @SerializedName("realname")
    @Expose
    String realname;

    @SerializedName("firstname")
    @Expose
    String firstname;

    @SerializedName("profiles_id")
    @Expose
    int profiles_id;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("phone")
    @Expose
    int phone;

    @SerializedName("_password")
    @Expose
    String _password;

    @SerializedName("_confirmpassword")
    @Expose
    String _confirmpassword;

    public RegisterUser(String realname, String firstname, int profiles_id, String name, int phone, String _password, String _confirmpassword) {
        this.realname = realname;
        this.firstname = firstname;
        this.profiles_id = profiles_id;
        this.name = name;
        this.phone = phone;
        this._password = _password;
        this._confirmpassword = _confirmpassword;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }

    public String get_confirmpassword() {
        return _confirmpassword;
    }

    public void set_confirmpassword(String _confirmpassword) {
        this._confirmpassword = _confirmpassword;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getProfiles_id() {
        return profiles_id;
    }

    public void setProfiles_id(int profiles_id) {
        this.profiles_id = profiles_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}

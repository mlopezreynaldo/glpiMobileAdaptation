package com.miguel.gestorincidenciaapp.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GlpiTableOf {

    @SerializedName("User")
    @Expose
    private String user;
    @SerializedName("Profile")
    @Expose
    private String profile;
    @SerializedName("APIClient")
    @Expose
    private String aPIClient;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getAPIClient() {
        return aPIClient;
    }

    public void setAPIClient(String aPIClient) {
        this.aPIClient = aPIClient;
    }

}
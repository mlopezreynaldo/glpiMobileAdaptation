package com.miguel.gestorincidenciaapp;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TokenInfo {

    @SerializedName("session_token")
    @Expose
    private String sessionToken;

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}

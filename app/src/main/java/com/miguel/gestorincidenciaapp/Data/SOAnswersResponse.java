package com.miguel.gestorincidenciaapp.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SOAnswersResponse{

    @SerializedName("session")
    @Expose
    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}

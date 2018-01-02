package com.miguel.gestorincidenciaapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class TicketJsonBuilder {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("urgency")
    @Expose
    private int urgency;
    @SerializedName("priority")
    @Expose
    private int priority;
    @SerializedName("type")
    @Expose
    private int type;

    public TicketJsonBuilder(String name, String date, int status, String content, int urgency, int priority, int type) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.content = content;
        this.urgency = urgency;
        this.priority = priority;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TicketJsonBuilder{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", status=" + status +
                ", content='" + content + '\'' +
                ", urgency=" + urgency +
                ", priority=" + priority +
                ", type=" + type +
                '}';
    }
}


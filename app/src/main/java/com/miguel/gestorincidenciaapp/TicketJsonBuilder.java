package com.miguel.gestorincidenciaapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class TicketJsonBuilder implements Serializable{

    @SerializedName("id")
    @Expose
    private int id;

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

    @SerializedName("solution")
    @Expose
    private String solution;

    @SerializedName("closeDate")
    @Expose
    private String closeDate;

    @SerializedName("solveDate")
    @Expose
    private String solveDate;

    @SerializedName("impact")
    @Expose
    private int impact;


    public TicketJsonBuilder(String name, String date, int status, String content, int urgency, int priority, int type) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.content = content;
        this.urgency = urgency;
        this.priority = priority;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getSolveDate() {
        return solveDate;
    }

    public void setSolveDate(String solveDate) {
        this.solveDate = solveDate;
    }

    public int getImpact() {
        return impact;
    }

    public void setImpact(int impact) {
        this.impact = impact;
    }

    @Override
    public String toString() {
        return "TicketJsonBuilder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", status=" + status +
                ", content='" + content + '\'' +
                ", urgency=" + urgency +
                ", priority=" + priority +
                ", type=" + type +
                ", solution='" + solution + '\'' +
                ", closeDate='" + closeDate + '\'' +
                ", solveDate='" + solveDate + '\'' +
                ", impact=" + impact +
                '}';
    }
}


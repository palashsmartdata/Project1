package com.example.newproject.Retrofit;

public class Model {

    int ruserid, rid;
    String title, body;

    public Model(int ruserid, int rid, String title, String body) {
        this.ruserid = ruserid;
        this.rid = rid;
        this.title = title;
        this.body = body;
    }

    public int getRuserid() {
        return ruserid;
    }

    public void setRuserid(int ruserid) {
        this.ruserid = ruserid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

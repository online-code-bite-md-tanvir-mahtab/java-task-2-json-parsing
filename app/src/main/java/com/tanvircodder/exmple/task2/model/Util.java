package com.tanvircodder.exmple.task2.model;

public class Util {
    private String mId;
    private String mName;
    private String mEmail;
    private String mGender;
    private String mActive;

    public Util(String mId, String mName, String mEmail, String mGender, String mActive) {
        this.mId = mId;
        this.mName = mName;
        this.mEmail = mEmail;
        this.mGender = mGender;
        this.mActive = mActive;
    }

    public String getmId() {
        return mId;
    }

    public String getmName() {
        return mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmGender() {
        return mGender;
    }

    public String getmActive() {
        return mActive;
    }
}

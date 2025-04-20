package com.iamhotcenplotz.chapter22.common;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Der Hotcenplotz
 * @version 1.0
 * 用户类
 */
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    private String userID;
    private String passwd;

    public User() {
    }

    public User(String userID, String passwd) {
        this.userID = userID;
        this.passwd = passwd;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}

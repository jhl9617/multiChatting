package net.multi.chatting.server;

import java.util.HashMap;
import java.util.Vector;

public class User {

    private String userid;
    private String userpwd;
    private String nickName;

    public User() {
    }

    public User(String userid, String userpwd, String nickName) {
        this.userid = userid;
        this.userpwd = userpwd;
        this.nickName = nickName;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

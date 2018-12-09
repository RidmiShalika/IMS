/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.bean;

/**
 *
 * @author ridmi_g
 */
public class SessionBean {
    private String name;
    private String userName;
    private String userRole;
    private String currentSessionId;
    private int id;
    private int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getCurrentSessionId() {
        return currentSessionId;
    }

    public void setCurrentSessionId(String currentSessionId) {
        this.currentSessionId = currentSessionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}

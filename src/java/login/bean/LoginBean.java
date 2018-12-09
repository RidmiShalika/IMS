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
public class LoginBean {

    private String userName;
    private String password;
    
    /////////////db information/////////////
    private String dbUsername;
    private String dbPassword;
    private String dbName;
    private String dbNic;
    private String dbContact;
    private String dbAddress;
    private String dbGender;
    private String dbUser_id;
    private String dbRole_id;
    
    
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbNic() {
        return dbNic;
    }

    public void setDbNic(String dbNic) {
        this.dbNic = dbNic;
    }

    public String getDbContact() {
        return dbContact;
    }

    public void setDbContact(String dbContact) {
        this.dbContact = dbContact;
    }

    public String getDbAddress() {
        return dbAddress;
    }

    public void setDbAddress(String dbAddress) {
        this.dbAddress = dbAddress;
    }

    public String getDbGender() {
        return dbGender;
    }

    public void setDbGender(String dbGender) {
        this.dbGender = dbGender;
    }

    public String getDbUser_id() {
        return dbUser_id;
    }

    public void setDbUser_id(String dbUser_id) {
        this.dbUser_id = dbUser_id;
    }

    public String getDbRole_id() {
        return dbRole_id;
    }

    public void setDbRole_id(String dbRole_id) {
        this.dbRole_id = dbRole_id;
    }
    
    

}

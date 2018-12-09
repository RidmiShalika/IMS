/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.bean;

import java.io.Serializable;

/**
 *
 * @author ridmi_g
 */
public class TaskBean implements Serializable{
     private String TASK_ID;
    private String TASK_NAME;
    private String URL;

    public String getTASK_ID() {
        return TASK_ID;
    }

    public void setTASK_ID(String TASK_ID) {
        this.TASK_ID = TASK_ID;
    }

    public String getTASK_NAME() {
        return TASK_NAME;
    }

    public void setTASK_NAME(String TASK_NAME) {
        this.TASK_NAME = TASK_NAME;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    
    
}

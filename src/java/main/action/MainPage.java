/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.action;

import Util.AccessControlService;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Ridmi Shalika
 */
public class MainPage extends ActionSupport implements AccessControlService{

    @Override
    public boolean checkAccess(String method, int userRole) {
        return  true;
    }
    @Override
    public String execute() {

        return SUCCESS;
    }
    public String AccCreation(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "accCreation";
    }
    
}

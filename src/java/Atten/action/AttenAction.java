/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atten.action;

import Atten.bean.AttenBean;
import Util.AccessControlService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ridmi_g
 */
public class AttenAction extends ActionSupport implements ModelDriven<AttenBean>, AccessControlService{
    
    AttenBean inputBean = new AttenBean();
    
    @Override
    public String execute(){
        return SUCCESS;

    }
    public String findSt(){
        try {
            String stuid = inputBean.getAttenid();
            System.out.println("-- "+stuid);
            HttpSession session = ServletActionContext.getRequest().getSession(false);
            session.setAttribute("assToCourse", stuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "findSt";
    }

    @Override
    public AttenBean getModel() {
        return inputBean;
    }

    @Override
    public boolean checkAccess(String method, int userRole) {
        return true;
    }
    public String loadandattendence(){
        try {
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "loadandattendence";
    }
}

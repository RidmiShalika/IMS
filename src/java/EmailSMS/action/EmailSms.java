/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailSMS.action;

import EmailSMS.bean.EmailSmsBean;
import EmailSMS.service.EmailSmsSevice;
import Util.AccessControlService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * @author ridmi_g
 */
public class EmailSms extends ActionSupport implements ModelDriven<EmailSmsBean> ,AccessControlService {

    EmailSmsBean inputbean = new EmailSmsBean();
    EmailSmsSevice service = new EmailSmsSevice();
    
    @Override
    public String execute() {

        return SUCCESS;
    }

    @Override
    public EmailSmsBean getModel() {
        try {
            service.getLecLists(inputbean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputbean;
    }

    @Override
    public boolean checkAccess(String method, int userRole) {
        return true;
    }
    
}

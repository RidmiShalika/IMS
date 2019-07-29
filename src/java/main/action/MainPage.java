/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.action;

import Util.AccessControlService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import main.bean.MainBean;
import main.service.MainService;

/**
 *
 * @author Ridmi Shalika
 */
public class MainPage extends ActionSupport implements ModelDriven<MainBean>, AccessControlService {

    MainService service = new MainService();
    MainBean inputbean = new MainBean();

    @Override
    public boolean checkAccess(String method, int userRole) {
        return true;
    }

    @Override
    public String execute() {

        return SUCCESS;
    }

    public String AccCreation() {
        try {
            if (!service.isAlreadycreated(inputbean)) {
                if (service.addPaymentAccount(inputbean)) {
                    inputbean.setSuccess(true);
                    inputbean.setMessage("Payment Account Creaton Successfully");
                } else {
                    inputbean.setSuccess(false);
                    inputbean.setMessage("Payment Account Creaton Fail");
                }
            }else{
                inputbean.setSuccess(false);
                inputbean.setMessage("Payment Account Creaton Already done for this month");
            }

        } catch (Exception e) {
            e.printStackTrace();
            inputbean.setSuccess(false);
            inputbean.setMessage("Payment Account Creaton Fail");
        }
        return "accCreation";
    }

    @Override
    public MainBean getModel() {
        return inputbean;
    }
}

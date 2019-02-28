/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atten.action;

import Atten.bean.AttenBean;
import Atten.service.AttenService;
import Util.AccessControlService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ridmi_g
 */
public class AttenAction extends ActionSupport implements ModelDriven<AttenBean>, AccessControlService {
    
    AttenBean inputBean = new AttenBean();
    AttenService service = new AttenService();
    
    @Override
    public String execute() {
        return SUCCESS;
        
    }

    public String findSt() {
        try {
            int stuid = Integer.parseInt(inputBean.getAttenid());
            System.out.println("-- " + stuid);
            HttpSession session = ServletActionContext.getRequest().getSession(false);
            session.setAttribute("stcourselist", stuid);
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

    public String loadandattendence() {
        try {
            //load data from service
            service.loadData(inputBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "loadandattendence";
    }

    public String loadhistorylist() {
        try {
            //load data from service
            System.out.println("atteid " + inputBean.getAttenid());
            int cid = service.getcorseid(inputBean);
            service.historyData(inputBean, cid);
            service.getpaymenthistory(inputBean, cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "loadhistorylist";
    }

    public String list() {
        System.out.println("list method");
        List<AttenBean> dataList;
        try {
            int rows = inputBean.getRows();
            int page = inputBean.getPage();
            int to = (rows * page);
            int from = to - rows;
            long records;
            String orderBy = "";
            
            dataList = service.loadStudent(inputBean, to, from, orderBy);
            if (!dataList.isEmpty()) {
                records = dataList.get(0).getFullCount();
                System.out.println("recode " + records);
                inputBean.setRecords(records);
                inputBean.setGridModel(dataList);
                int total = (int) Math.ceil((double) records / (double) rows);
                inputBean.setTotal(total);
            } else {
                inputBean.setRecords(0L);
                inputBean.setTotal(0);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "list";
    }

    public String paymentmark() {
        try {
            System.out.println(" selected data " + inputBean.getSelected_data());
            service.paymentdetails(inputBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "paymentmark";
    }
    
}

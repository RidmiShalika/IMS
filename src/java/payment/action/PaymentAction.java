/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment.action;

import Util.AccessControlService;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import payment.bean.PaymentBean;
import payment.service.PaymentSevice;

/**
 *
 * @author ridmi_g
 */
public class PaymentAction extends ActionSupport implements ModelDriven<PaymentBean>, AccessControlService {

    PaymentBean inputbean = new PaymentBean();
    PaymentSevice service = new PaymentSevice();
    
    @Override
    public String execute() {
        return SUCCESS;
    }

    @Override
    public PaymentBean getModel() {
        return inputbean;
    }

    @Override
    public boolean checkAccess(String method, int userRole) {
        return true;
    }
     public String findSt() {
        try {
            int stuid = Integer.parseInt(inputbean.getPayid());
            System.out.println("-- " + stuid);
            HttpSession session = ServletActionContext.getRequest().getSession(false);
            session.setAttribute("s_id", stuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "findSt";
    }
      public String list() {
        System.out.println("list method");
        List<PaymentBean> dataList;
        try {
            int rows = inputbean.getRows();
            int page = inputbean.getPage();
            int to = (rows * page);
            int from = to - rows;
            long records;
            String orderBy = "";
            
            dataList = service.loadStudent(inputbean, to, from, orderBy);
            if (!dataList.isEmpty()) {
                records = dataList.get(0).getFullCount();
                System.out.println("recode " + records);
                inputbean.setRecords(records);
                inputbean.setGridModel(dataList);
                int total = (int) Math.ceil((double) records / (double) rows);
                inputbean.setTotal(total);
            } else {
                inputbean.setRecords(0L);
                inputbean.setTotal(0);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "list";
    }
      public String paymentmark() {
        try {
            System.out.println(" selected data " + inputbean.getSelected_data());
            service.paymentdetails(inputbean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "paymentmark";
    }
      public String loadhistorylist() {
        try {
            //load data from service
            System.out.println("getPid " + inputbean.getPid());
            int cid = service.getcorseid(inputbean);
            service.historyData(inputbean, cid);
            service.getpaymenthistory(inputbean, cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "loadhistorylist";
    }

}

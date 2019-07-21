/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subject.action;

import Util.AccessControlService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import login.bean.SessionBean;
import mapping.Subject;
import org.apache.struts2.ServletActionContext;
import subject.bean.SubjectBean;
import subject.service.SubjectService;

/**
 *
 * @author ridmi_g
 */
public class SubjectRegister extends ActionSupport implements ModelDriven<SubjectBean>, AccessControlService {

    SubjectBean inputBean = new SubjectBean();
    Subject student = new Subject();
    HttpServletRequest req = ServletActionContext.getRequest();
    SessionBean sessionBean;
    SubjectService service = new SubjectService();

    public SessionBean getSessionBean() {
        return (SessionBean) req.getSession().getAttribute("SessionObject");
    }

    @Override
    public SubjectBean getModel() {
        try {
            getMedium(inputBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputBean;
    }
    
    public void getMedium(SubjectBean inputbean){
        try {
            inputbean.getSubList().put(1, "Sinhala");
            inputbean.getSubList().put(2, "English");
            inputbean.getSubList().put(3, "Tamil");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public boolean checkAccess(String method, int userRole) {
        //  throw new UnsupportedOperationException("Not supportedy yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    public String execute() {

        return SUCCESS;
    }

    public String list() {
        List<SubjectBean> dataList;
        try {
            int rows = inputBean.getRows();
            int page = inputBean.getPage();
            int to = (rows * page);
            int from = to - rows;
            long records;
            String orderBy = "";

            dataList = service.loadSubject(inputBean, rows, from, orderBy);

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

    public String Add() {

        try {
            if (doValidation(inputBean)) {
                if (service.addSubject(inputBean)) {
                    addActionMessage("Subjects add successfully");
                } else {
                    addActionError("Subject add fail");
                }
            }

        } catch (Exception e) {
            addActionError("Subject registration fail");
            e.printStackTrace();
        }

        return "add";
    }

    public boolean doValidation(SubjectBean inputbean) throws Exception {
        boolean ok = false;

        try {
            if (inputbean.getSubjectname() == null || inputbean.getSubjectname().isEmpty()) {
                addActionError("Subject name can not be empty");
                return ok;
            }  else {
                ok = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return ok;
    }
     public String find(){
        try {
            service.findsubject(inputBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "find";
    }
     
     public String update(){
         System.out.println("supate method "+inputBean.getSubjectId());
          try {
            if(service.updateSubject(inputBean)){
                addActionMessage("Successfully updated");
            }else{
                addActionError("Update fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return "update";
     }
     
     public String delete() {
        try {
            
            if (service.deleteData(inputBean)) {

                inputBean.setMessage("Subject delete success");
                inputBean.setSuccess(true);
            } else {
                inputBean.setMessage("Subject delete fail");
                inputBean.setSuccess(false);
            }

        } catch (Exception ex) {
            inputBean.setMessage("Subject delete fail");
            inputBean.setSuccess(false);
            ex.printStackTrace();
            
        }

        return "delete";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturer.action;

import Util.AccessControlService;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lecturer.bean.LecturerBean;
import lecturer.service.LecturerService;
import login.bean.SessionBean;
import org.apache.struts2.ServletActionContext;


/**
 *
 * @author ridmi_g
 */
public class RegisterLecturer extends ActionSupport implements ModelDriven<LecturerBean> ,AccessControlService {
    
    LecturerBean inputbean = new LecturerBean();
    HttpServletRequest req = ServletActionContext.getRequest();
    SessionBean sessionBean;
    LecturerService service = new LecturerService();
    
    public SessionBean getSessionBean() {
        return (SessionBean) req.getSession().getAttribute("SessionObject");
    }
     public String execute() {
     
        return SUCCESS;
    }

    @Override
    public LecturerBean getModel() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            service.getSubjectList(inputbean);
            getTitle(inputbean);
            getGender(inputbean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputbean;
    }
    public void getTitle(LecturerBean inputbean){
        inputbean.getTitleList().put(1, "Mr");
        inputbean.getTitleList().put(2, "Mrs");
        inputbean.getTitleList().put(3, "Miss");
        inputbean.getTitleList().put(4, "Rev");
    }
    public void getGender(LecturerBean inputbean){
        inputbean.getGenList().put(1, "Male");
        inputbean.getGenList().put(2, "Female");
    }

    @Override
    public boolean checkAccess(String method, int userRole) {
       return true;
    }
     public String list() {
        System.out.println("list method++++++++++++++++++++++");
        List<LecturerBean> dataList;
        try {
            int rows = inputbean.getRows();
            int page = inputbean.getPage();
            int to = (rows * page);
            int from = to - rows;
            long records;
            String orderBy = "";
            
            dataList = service.loadLec(inputbean, rows, from, orderBy);
            
            if (!dataList.isEmpty()) {
                records = dataList.get(0).getFullCount();
                System.out.println("recode "+records);
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
     public String Add(){
         
         try {
             if(service.addStudent(inputbean)){
                 addActionMessage("Lecturer added successfully");
             }else{
                 addActionError("Lecturer add fail");
             }
         } catch (Exception e) {
              addActionError("Lecturer add fail");
              e.printStackTrace();;
         }
         return "add";
     }
     
     public String find(){
       
         try {
             System.out.println("find method");
             service.findLec(inputbean);
             System.out.println(" id "+inputbean.getUplecid());
         
         } catch (Exception e) {
             e.printStackTrace();
         }
         return "find";
     }
     public String update(){
     
         try {
             
             System.out.println(" id "+inputbean.getUplecid());
             if(service.updateLecturer(inputbean)){
                 addActionMessage("Lecturer updated successfully");
             }else{
                 addActionError("Update fail");
             }
         } catch (Exception e) {
             e.printStackTrace();
             addActionError("Update fail2");
         }
         return "update";
     }
    
}

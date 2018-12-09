/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.action;

import Util.AccessControlService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import login.bean.SessionBean;
import mapping.Student;
import org.apache.struts2.ServletActionContext;
import student.bean.StudentBean;
import student.service.StudentService;

/**
 *
 * @author ridmi_g
 */
public class StudentRegister extends ActionSupport implements ModelDriven<StudentBean> ,AccessControlService {

    StudentBean inputBean = new StudentBean();
    Student student = new Student();
    HttpServletRequest req = ServletActionContext.getRequest();
    SessionBean sessionBean;
    StudentService service = new StudentService();
            

    public SessionBean getSessionBean() {
        return (SessionBean) req.getSession().getAttribute("SessionObject");
    }

    @Override
    public boolean checkAccess(String method, int userRole) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    public String execute() {
     
        return SUCCESS;
    }

    public String list() {
        System.out.println("list method++++++++++++++++++++++");
        List<StudentBean> dataList;
        try {
            int rows = inputBean.getRows();
            int page = inputBean.getPage();
            int to = (rows * page);
            int from = to - rows;
            long records;
            String orderBy = "";
            
            dataList = service.loadStudent(inputBean, rows, from, orderBy);
            
            if (!dataList.isEmpty()) {
                records = dataList.get(0).getFullCount();
                System.out.println("recode "+records);
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

    @Override
    public StudentBean getModel() {
        try {
            service.getSchoolList(inputBean);
            genderList(inputBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
       return inputBean;
    }
    public void genderList(StudentBean inputbean){
            try {
            inputbean.getGenderlList().put(1, "Female");
            inputbean.getGenderlList().put(2, "Male");
//               inputbean.getGenderlList().add("Female");
//               inputbean.getGenderlList().add("Male");
                System.out.println("tttttttttttttttttttttttttt  "+ inputbean.getGenderlList().get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String Add(){
        System.out.println("add method in sudent");
        try {
            if(doValidation(inputBean)){
                if(service.addStudent(inputBean)){
                    addActionMessage("Student registration successfull");
                }else{
                    addActionError("Student registration fail");
                }
            }
            
        } catch (Exception e) {
            addActionError("Student registration fail");
            e.printStackTrace();
        }
        return "add";
    }
    
    public boolean doValidation(StudentBean bean) throws Exception{
        boolean ok = false;
        
        try {
            if(bean.getName() == null || bean.getName().isEmpty()){
                addActionError("Student name can not be empty");
                return ok;
            }else{
                ok = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return ok;
    }
    public String find(){
        try {
            service.findstudent(inputBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "find";
    }
    
    public String update(){
        try {
            if(service.updateStudent(inputBean)){
                addActionMessage("Successfully updated");
            }else{
                addActionError("Update fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "update";
    }
    

}

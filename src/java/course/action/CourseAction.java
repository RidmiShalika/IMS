/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.action;

import Util.AccessControlService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import course.bean.CourseBean;
import course.service.CourseService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import login.bean.SessionBean;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ridmi_g
 */
public class CourseAction extends ActionSupport implements ModelDriven<CourseBean>, AccessControlService {

    CourseBean inputbean = new CourseBean();
    HttpServletRequest req = ServletActionContext.getRequest();
    SessionBean sessionBean;
    CourseService service = new CourseService();

    public SessionBean getSessionBean() {
        return (SessionBean) req.getSession().getAttribute("SessionObject");
    }

    public String execute() {

        return SUCCESS;
    }

    @Override
    public CourseBean getModel() {
        try {
            service.getlecList(inputbean);
            getMedium(inputbean);
            service.getsubList(inputbean);
            getGrade(inputbean);
            getClassType(inputbean);
            getHall(inputbean);
            getBatch(inputbean);
        } catch (Exception e) {
        }
        
        return inputbean;
    }
    public void getMedium(CourseBean inputbean){
        inputbean.getMedList().put(1, "Sinhala");
        inputbean.getMedList().put(2, "Enlish");
        inputbean.getMedList().put(3, "Tamil");
    }
    public void getClassType(CourseBean inputbean){
        inputbean.getClzList().put(1, "Theory Class");
        inputbean.getClzList().put(2, "Revision Class");
        inputbean.getClzList().put(3, "Paper Class");
    }
    public void getBatch(CourseBean inputbean){
        inputbean.getBatchList().put(1, "Batch 1");
        inputbean.getBatchList().put(2, "Batch 2");
        inputbean.getBatchList().put(3, "Batch 3");
        inputbean.getBatchList().put(4, "Batch 4");
        inputbean.getBatchList().put(5, "Batch 5");
        inputbean.getBatchList().put(6, "Batch 6");
        inputbean.getBatchList().put(7, "Batch 7");
        inputbean.getBatchList().put(8, "Batch 8");
        inputbean.getBatchList().put(9, "Batch 9");
        inputbean.getBatchList().put(10, "Batch 10");
    }
    public void getHall(CourseBean inputbean){
        inputbean.getHallList().put(1, "Hall 1");
        inputbean.getHallList().put(2, "Hall 2");
        inputbean.getHallList().put(3, "Hall 3");
        inputbean.getHallList().put(4, "Hall 4");
        inputbean.getHallList().put(5, "Hall 5");
        inputbean.getHallList().put(6, "Hall 6");
        inputbean.getHallList().put(7, "Hall 7");
        inputbean.getHallList().put(8, "Hall 8");
        inputbean.getHallList().put(9, "Hall 9");
        inputbean.getHallList().put(10, "Hall 10");
    }
    public void getGrade(CourseBean inputbean){
        inputbean.getGradeList().put(1, "Grade 1");
        inputbean.getGradeList().put(2, "Grade 2");
        inputbean.getGradeList().put(3, "Grade 3");
        inputbean.getGradeList().put(4, "Grade 4");
        inputbean.getGradeList().put(5, "Grade 5");
        inputbean.getGradeList().put(6, "Grade 6");
        inputbean.getGradeList().put(7, "Grade 7");
        inputbean.getGradeList().put(8, "Grade 8");
        inputbean.getGradeList().put(9, "Grade 9");
        inputbean.getGradeList().put(10, "Grade 10");
        inputbean.getGradeList().put(11, "O/L");
        inputbean.getGradeList().put(12, "A/L 2019");
        inputbean.getGradeList().put(13, "A/L 2020");
        inputbean.getGradeList().put(14, "A/L 2021");
        inputbean.getGradeList().put(15, "A/L 2022");
        inputbean.getGradeList().put(16, "A/L 2023");
        inputbean.getGradeList().put(17, "A/L 2024");
        inputbean.getGradeList().put(18, "A/L 2025");
        inputbean.getGradeList().put(19, "A/L 2026");
        inputbean.getGradeList().put(20, "A/L 2027");
        
    }

    @Override
    public boolean checkAccess(String method, int userRole) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }
     public String list() {
        System.out.println("list method++++++++++++++++++++++");
        List<CourseBean> dataList;
        try {
            int rows = inputbean.getRows();
            int page = inputbean.getPage();
            int to = (rows * page);
            int from = to - rows;
            long records;
            String orderBy = "";
            
            dataList = service.loadCourse(inputbean, rows, from, orderBy);
            
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
             if(doValidation(inputbean)){
                 if(service.addCourse(inputbean)){
                 addActionMessage("Course addes successfull");
             }else{
                 addActionError("Course added fail");
             }
             }
             
             
         } catch (Exception e) {
             e.printStackTrace();
             addActionError("Course added fail");
         }
         return "add";
     }
     public boolean doValidation(CourseBean inputbean){
         boolean ok;
         
         if(inputbean.getAddcourseDescription() == null || inputbean.getAddcourseDescription().isEmpty()){
             addActionError("Description can not be empty");
             ok = false;
         }else if(inputbean.getAddlecturer().equals("-1")){
             addActionError("Please select lecture");
             ok = false;
        }else if(inputbean.getAddconductingMedium().equals("-1")){
             addActionError("Please select medium");
             ok = false;
        }else if(inputbean.getAddsubject().equals("-1")){
             addActionError("Please select subject");
             ok = false;
        }else if(inputbean.getAddgrade().equals("-1")){
             addActionError("Please select grade");
             ok = false;
        }else if(inputbean.getAddlecturerPayment() == null || inputbean.getAddlecturerPayment().isEmpty()){
             addActionError("Lecture payment can not be empty");
             ok = false;
        }else{
             ok = true;
         }
         
         
         return ok;
     }

}

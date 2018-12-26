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
import javax.servlet.http.HttpSession;
import login.bean.SessionBean;
import mapping.Student;
import org.apache.struts2.ServletActionContext;
import student.bean.StudentBean;
import student.service.StudentService;

/**
 *
 * @author ridmi_g
 */
public class StudentRegister extends ActionSupport implements ModelDriven<StudentBean>, AccessControlService {

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
    public String listcr() {
        System.out.println("list method cr++++++++++++++++++++++");
        List<StudentBean> dataList;
        try {
            int rows = inputBean.getRows();
            int page = inputBean.getPage();
            int to = (rows * page);
            int from = to - rows;
            long records;
            String orderBy = "";

            dataList = service.loadStudentcr(inputBean, rows, from, orderBy);

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

        return "list1";
    }

    @Override
    public StudentBean getModel() {
        try {
            service.getSchoolList(inputBean);
            genderList(inputBean);
            service.getsubList(inputBean);
            getGrade(inputBean);
            service.getCorList(inputBean);
            cardTypeList(inputBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputBean;
    }

    public void genderList(StudentBean inputbean) {
        try {
            inputbean.getGenderlList().put(1, "Male");
            inputbean.getGenderlList().put(2, "Female");
//               inputbean.getGenderlList().add("Female");
//               inputbean.getGenderlList().add("Male");
            System.out.println("tttttttttttttttttttttttttt  " + inputbean.getGenderlList().get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String Add() {
        System.out.println("add method in sudent");
        try {
            if (doValidation(inputBean)) {
                if (service.addStudent(inputBean)) {
                    addActionMessage("Student registration successfull");
                } else {
                    addActionError("Student registration fail");
                }
            }

        } catch (Exception e) {
            addActionError("Student registration fail");
            e.printStackTrace();
        }
        return "add";
    }

    public boolean doValidation(StudentBean bean) throws Exception {
        boolean ok = false;

        try {
            if (bean.getName() == null || bean.getName().isEmpty()) {
                addActionError("Student name can not be empty");
                return ok;
            } else if (bean.getFirstname() == null || bean.getFirstname().isEmpty()) {
                addActionError("Student first name can not be empty");
                return ok;
            } else if (bean.getSchool().equals("-1")) {
                addActionError("Please select school");
                return ok;
            } else {
                ok = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return ok;
    }

    public String find() {
        try {
            service.findstudent(inputBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "find";
    }

    public String update() {
        try {
            if (updoValidation(inputBean)) {
                if (service.updateStudent(inputBean)) {
                    addActionMessage("Successfully updated");
                } else {
                    addActionError("Update fail");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "update";
    }

    public boolean updoValidation(StudentBean bean) throws Exception {
        boolean ok = false;

        try {
            if (bean.getUpname() == null || bean.getUpname().isEmpty()) {
                addActionError("Student name can not be empty");
                return ok;
            } else if (bean.getUpfirstname() == null || bean.getUpfirstname().isEmpty()) {
                addActionError("Student first name can not be empty");
                return ok;
            } else if (bean.getUpschool().equals("-1")) {
                addActionError("Please select school");
                return ok;
            } else {
                ok = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return ok;
    }
    
     public String assign() {

        int stuid = inputBean.getStudentId();
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        session.setAttribute("assToCourse", stuid);
        return "Assign";

    }
     public void getGrade(StudentBean inputbean){
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
     public void cardTypeList(StudentBean inputbean) {
        try {
            inputbean.getCardTypeList().put(1, "Normal Card");
             inputbean.getCardTypeList().put(2, "Half Card");
              inputbean.getCardTypeList().put(3, "Free Card");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public String studentRegistrationForCourse(){
         try {
             service.addStudentForCourse(inputBean);
             addActionMessage("Student successfuly added to course");
         } catch (Exception e) {
             e.printStackTrace();
             addActionError("Student added to course fail");
         }
         return "assForCourse";
     }
     public String delete(){
         try {
             service.DeleteC(inputBean);
             inputBean.setMessage("Delete successfull");
             inputBean.setSuccess(true);
         } catch (Exception e) {
             e.printStackTrace();
             inputBean.setMessage("Delete fail");
             inputBean.setSuccess(false);
         }
         return "delete";
     }
      public String pay() {

        int stuid = inputBean.getStuId();
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        session.setAttribute("stuid", stuid);
        return "pay";

    }
      public String paymentAdd(){
          try {
              if(service.checkAddmission(inputBean)){
                  addActionMessage("Student already paid admission");
              }else{
                  service.addAddmission(inputBean);
                  addActionMessage("Student paid admission successfuly");
              }
          } catch (Exception e) {
              e.printStackTrace();
              addActionError("Payment add faill");
          }
          return "payment";
      }
      public String getInfo(){
          try {
              if(service.checkAddmission(inputBean)){
                  inputBean.setPay_status("Paid");
              }else{
                  inputBean.setPay_status("Not Paid");
              }
              
          } catch (Exception e) {
              e.printStackTrace();
          }
          return "getInfo";
      }

}

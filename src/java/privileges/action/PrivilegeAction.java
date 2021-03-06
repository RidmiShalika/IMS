/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privileges.action;

import Util.AccessControlService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.List;
import privileges.bean.PrivilegeBean;
import privileges.service.PrivilegeService;

/**
 *
 * @author ridmi_g
 */
public class PrivilegeAction extends ActionSupport implements ModelDriven<PrivilegeBean>, AccessControlService {

    PrivilegeBean inputbean = new PrivilegeBean();
    PrivilegeService service = new PrivilegeService();

    @Override
    public PrivilegeBean getModel() {

        try {
//            System.out.println("load module methode");

            service.getPageList(inputbean);
            service.getUserRoleList(inputbean);
            genderList(inputbean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputbean;
    }

    public void genderList(PrivilegeBean inputbean) {
        try {
            inputbean.getGenderlList().put(1, "Female");
            inputbean.getGenderlList().put(2, "Male");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkAccess(String method, int userRole) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    public String execute() {
        return SUCCESS;
    }

    public String list() {

        List<PrivilegeBean> dataList;
        try {
            int rows = inputbean.getRows();
            int page = inputbean.getPage();
            int to = (rows * page);
            int from = to - rows;
            long records;
            String orderBy = "";

            dataList = service.loadPrivileges(inputbean, rows, from, orderBy);

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

    public String Find() {
//        System.out.println("FIND METHOD");
        try {
            service.findData(inputbean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "find";
    }

    public String AddPrivilage() {
        try {
//            System.out.println("add pri method");

            if (service.deleteexsitingpri(inputbean)) {
                service.addPri(inputbean);
                inputbean.setMessage("Successfully Updated");
                inputbean.setSuccess(true);
            } else {
                inputbean.setMessage("Updated Error");
                inputbean.setSuccess(false);
            }

        } catch (Exception e) {

            inputbean.setMessage("Updated Error");
            inputbean.setSuccess(false);
            e.printStackTrace();
        }
        return "addPriviles";
    }

    public String Add() {
        try {
            if (doValidation(inputbean)) {
                if (service.addUsr(inputbean)) {
                    addActionMessage("User add successfully");
                } else {
                    addActionError("User add fail");
                }
            }

        } catch (Exception e) {
            addActionError("User add fail");
            e.printStackTrace();
        }
        return "add";
    }

    public boolean doValidation(PrivilegeBean inputbean) throws Exception {
        boolean ok = false;
        try {
            if (inputbean.getAddname() == null || inputbean.getAddname().isEmpty()) {
                addActionError("Name can not be empty");
                return ok;
            } else if (inputbean.getAddgender().equals("-1")) {
                addActionError("Please select gender");
                return ok;
            } else if (inputbean.getAddusername() == null || inputbean.getAddusername().isEmpty()) {
                addActionError("Username can not be empty");
                return ok;
            } else if (inputbean.getAdduserrole().equals("-1")) {
                addActionError("Please select user role");
                return ok;
            } else if (inputbean.getAddpassword() == null || inputbean.getAddpassword().isEmpty()) {
                addActionError("Password can not be empty");
                return ok;
            } else if (inputbean.getAddconfirmpassword() == null || inputbean.getAddconfirmpassword().isEmpty()) {
                addActionError("Password comfirm can not be empty");
                return ok;
            } else if (!inputbean.getAddpassword().equals(inputbean.getAddconfirmpassword())) {
                addActionError("Password mismatch");
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

}

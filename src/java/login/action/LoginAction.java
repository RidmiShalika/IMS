/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.action;

import Util.constant.SessionVariable;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import login.bean.LoginBean;
import login.bean.SessionBean;
import login.bean.TaskBean;
import login.service.LoginService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author ridmi_g
 */
public class LoginAction extends ActionSupport implements ModelDriven<LoginBean>, SessionAware {

    LoginBean loginBean = new LoginBean();
    SessionBean sessionUserBean = new SessionBean();
    private SessionMap<String, Object> sessionMap;
    List<String> profilePageidList = new ArrayList<String>();
    LoginService loginService = new LoginService();
    Map<String, List<TaskBean>> taskList;

    @Override
    public LoginBean getModel() {
        return loginBean;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap) map;
    }

    public String execute() {
        return SUCCESS;
    }

    public String loginCheck() {
        try {
            if (validateLogin(loginBean)) {
                if (loginBean.getPassword().equals(loginService.getDbUserPassword(loginBean).getDbPassword())) {

                    sessionUserBean.setId(Integer.parseInt(loginBean.getDbUser_id()));
                    sessionUserBean.setName(loginBean.getDbName());
                    sessionUserBean.setUserName(loginBean.getUserName());
                    sessionUserBean.setUserid(Integer.parseInt( loginBean.getDbRole_id()));

                    HttpSession sessionPrevious = ServletActionContext.getRequest().getSession(false);
                    if (sessionPrevious != null) {
                        sessionPrevious.removeAttribute("SessionObject");

                    }

                    HttpSession session = ServletActionContext.getRequest().getSession(true);
                    sessionUserBean.setCurrentSessionId(session.getId());
                    session.setAttribute("SessionObject", sessionUserBean);
//                    sessionPrevious.removeAttribute("pageTaskList");

                    //set user and sessionid to hashmap              
                    ServletContext sc = ServletActionContext.getServletContext();
                    HashMap<String, String> userMap = (HashMap<String, String>) sc.getAttribute(SessionVariable.USERMAP);
                    if (userMap == null) {
                        userMap = new HashMap<String, String>();
                    }
                    userMap.put(sessionUserBean.getUserName(), session.getId());
                    sc.setAttribute(SessionVariable.USERMAP, userMap);

                    taskList = loginService.getAllPageTask(Integer.parseInt(loginBean.getDbRole_id()));
                    session.setAttribute("pageTaskList", taskList);
                    
                    // need or not
                     HttpServletRequest request1 = ServletActionContext.getRequest();
                                HttpSession session1 = request1.getSession(false);
                                SessionBean sessionUser = (SessionBean) session1.getAttribute("SessionObject");
                                
                                return SUCCESS;

                } else {
                    addActionError("Invalid password");
                    return LOGIN;
                }
            } else {
                addActionError("Invalid user login");
                return LOGIN;
            }
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("User login Error");
            return LOGIN;
        }
//        return LOGIN;

    }

    public boolean validateLogin(LoginBean bean) throws Exception {
        if (bean.getUserName() != null && bean.getUserName().equals("")) {
            addActionError("Empty user name");
            return false;
        }
        if (!loginService.checkUsername(bean)) {
            addActionError("Invalid user name");
            return false;
        } else if (bean.getPassword() != null && bean.getPassword().equals("")) {
            addActionError("Empty user name or password");
            return false;
        }
        return true;

    }
     public String logoutFunction() {
         return LOGIN;
     }

}

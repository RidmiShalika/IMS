/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Util.constant.SessionVariable;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import login.action.LoginAction;
import login.bean.SessionBean;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author ridmi_g
 */
public class AccessControlInterceptor implements Interceptor {

    @Override
    public void destroy() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        String result = "";
        String INTERCEPT_LOGOUT = "noaccessPage";
        ActionProxy ap = ai.getProxy();
        String method = ap.getMethod();
        
        try {
            if (ai.getAction() instanceof LoginAction) {
                result = ai.invoke();
            } else {
                
                 HttpServletRequest request = ServletActionContext.getRequest();
                HttpSession session = request.getSession(false);

                if (session != null) {
                    SessionBean sessionUser = (SessionBean) session.getAttribute("SessionObject");
                    if (sessionUser != null) {
                        //check user logged in another mechine
                        ServletContext sc = ServletActionContext.getServletContext();
                        HashMap<String, String> userMap = (HashMap<String, String>) sc.getAttribute(SessionVariable.USERMAP);
                        String sessionId = userMap.get(sessionUser.getUserName());
                        if (sessionId.equals(session.getId())) {
                            Object action = ai.getAction();
                            if (action instanceof AccessControlService) {
                                if (((AccessControlService) action).checkAccess(method, sessionUser.getUserid())) {
                                    result = ai.invoke();
                                } else {
                                    System.out.println("acces denied - interceptor log out");
                                    result = INTERCEPT_LOGOUT;
                                }

                            } else {
                            }
                        } else {
                            result = "multiaccess";
                        }
                    } else {
                        result = INTERCEPT_LOGOUT; //session user null
                    }
                }else{
                    result = INTERCEPT_LOGOUT;
                }
                
            }
        } catch (Exception e) {
             e.printStackTrace();
            result = INTERCEPT_LOGOUT;
        }
          return result;
       
    }
    
}

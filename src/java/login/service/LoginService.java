/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.service;

import Util.HibernateInit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import login.bean.LoginBean;
import login.bean.TaskBean;
import org.hibernate.Session;
import mapping.SysUsers;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import mapping.Privileges;
import javax.persistence.Entity;

/**
 *
 * @author ridmi_g
 */
public class LoginService {

    public LoginBean getDbUserPassword(LoginBean loginBean) throws Exception {
        Session session = null;
//        session = HibernateInit.sessionFactory.openSession();
        session = HibernateInit.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            SysUsers initbean = (SysUsers) session.createCriteria(SysUsers.class)
                    .add(Restrictions.eq("userName", loginBean.getUserName())).uniqueResult();

            loginBean.setDbAddress(initbean.getAddress());
            loginBean.setDbContact(initbean.getContact());
            loginBean.setDbGender(initbean.getGender());
            loginBean.setDbName(initbean.getName());
            loginBean.setDbNic(initbean.getNic());
            loginBean.setDbPassword(initbean.getPassword());
            loginBean.setDbRole_id(Integer.toString(initbean.getRoleId().getUserRoleId()));
            loginBean.setDbUser_id(Integer.toString(initbean.getUserId()));
            loginBean.setDbUsername(initbean.getUserName());
            loginBean.setDbNic(initbean.getNic());
//            loginBean.setDbPassword(initbean.getPassword());

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session.flush();
                session = null;
            }
            throw e;
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.flush();
                session.close();
                session = null;
            }
        }
        return loginBean;

    }

    public boolean checkUsername(LoginBean loginBean) throws Exception {
        boolean result = false;
        Session session = null;
        System.out.println("111111111111111111");
//        session = HibernateInit.sessionFactory.openSession();
        session = HibernateInit.getSessionFactory().openSession();
        System.out.println("1222222222222222222222225");

        try {
            session.beginTransaction();
            SysUsers initbean = (SysUsers) session.createCriteria(SysUsers.class)
                    .add(Restrictions.eq("userName", loginBean.getUserName()))
                    .uniqueResult();
            result = (initbean != null);
            System.out.println("result>>>>>>>>>>>>> " + result);

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.flush();
                session.clear();
                session.close();
                session = null;
            }
            throw e;
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.close();
                session = null;
            }
        }
        return result;
    }

    public HashMap<String, List<TaskBean>> getAllPageTask(int profileID) throws Exception {
        HashMap<String, List<TaskBean>> pageTaskMap = new HashMap<String, List<TaskBean>>();
        List<Privileges> pageList = new ArrayList<Privileges>();
        Session session = null;
        try {

            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            String sql = "from Privileges as pp where pp.roleId.userRoleId =:userRoleId";
            Query query = session.createQuery(sql).setInteger("userRoleId", profileID);
            pageList = query.list();

            Set<String> userrole = new HashSet<String>();
            String secName = "";
            for (int i = 0; i < pageList.size(); i++) {
//              
                userrole.add(Integer.toString(pageList.get(i).getRoleId().getUserRoleId()));
                secName = pageList.get(i).getRoleId().getDescription();
                System.out.println("section name " + secName);

            }
            for (int i = 0; i < pageList.size(); i++) {
                System.out.println("pages list " + pageList.get(i).getRoleId().getUserRoleId());
            }
            List<TaskBean> tasklist = new ArrayList<TaskBean>();
            for (String strSec : userrole) {

                for (int i = 0; i < pageList.size(); i++) {

                    TaskBean bean = new TaskBean();
                    bean.setTASK_ID(Integer.toString(pageList.get(i).getPageId().getPageId()));
                    bean.setTASK_NAME(pageList.get(i).getPageId().getPageDescription());
                    bean.setURL(pageList.get(i).getPageId().getUrl());
                    tasklist.add(bean);
                }
                pageTaskMap.put(strSec, tasklist);
            }
            for (int i = 0; i < tasklist.size(); i++) {
                System.out.println("pages list " + tasklist.get(i).getTASK_NAME());
                 System.out.println("pages url " + tasklist.get(i).getURL());
            }

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.flush();
                session.close();
                session = null;
            }
            throw e;
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.flush();
                session.close();
                session = null;
            }
        }

        return pageTaskMap;
    }

}

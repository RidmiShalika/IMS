/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privileges.service;

import Util.HibernateInit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import login.bean.SessionBean;
import mapping.PageDetails;
import mapping.Privileges;
import mapping.SysUsers;
import mapping.UserRole;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import privileges.bean.PrivilegeBean;

/**
 *
 * @author ridmi_g
 */
public class PrivilegeService {
    SessionBean sub = (SessionBean) ServletActionContext.getRequest().getSession(false).getAttribute("SessionObject");

    public List<PrivilegeBean> loadPrivileges(PrivilegeBean inputBean, int max, int first, String orderBy) throws Exception {
        List<PrivilegeBean> dataList = new ArrayList<PrivilegeBean>();
        Session session = null;

        try {
            long count = 0;
            session = (Session) HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sqlCount = "select count(id) from UserRole";
//            String sqlCount = "select count(ID) from "
            Query queryCount = session.createQuery(sqlCount);
            Iterator itCount = queryCount.iterate();
            count = (Long) itCount.next();
            if (count > 0) {
                String sqlSearch = "from UserRole ";
                Query querySearch = session.createQuery(sqlSearch);

                querySearch.setMaxResults(max);
                querySearch.setFirstResult(first);

                Iterator it = querySearch.iterate();
                while (it.hasNext()) {
                    PrivilegeBean databean = new PrivilegeBean();
                    UserRole objBean = (UserRole) it.next();

                    try {
                        databean.setUserRoleId(objBean.getUserRoleId().toString());
                        System.out.println("ids "+databean.getUserRoleId());
                    } catch (NullPointerException e) {
                        databean.setUserRoleId("--");
                    }
                    try {
                        databean.setRole(objBean.getDescription());
                    } catch (NullPointerException e) {
                        databean.setRole("--");
                    }
                    
                    databean.setFullCount(count);
                    dataList.add(databean);

                }
            }
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session = null;
            }
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.flush();
                session.clear();
                session.close();
                session = null;
            }
        }
        return dataList;
    }
    public boolean addUsr(PrivilegeBean inputbean) throws Exception{
        boolean isAddPri = false;
        Session session = null;
        SysUsers usr = null;
        List<UserRole> usrR = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            usr = new SysUsers();
            usr.setAddress(inputbean.getAddaddress());
            usr.setContact(inputbean.getAddcontact());
            if(inputbean.getAddgender().equals("1")){
                  usr.setGender(inputbean.getGenderlList().get(1));
            }else if(inputbean.getAddgender().equals("2")){
                 usr.setGender(inputbean.getGenderlList().get(2));
            }
//            usr.setGender(inputbean.getAddgender());
            usr.setName(inputbean.getAddname());
            usr.setNic(inputbean.getAddnic());
            usr.setUserName(inputbean.getAddusername());
            usr.setPassword(inputbean.getAddpassword());
            
            UserRole role = new UserRole();
            role.setUserRoleId(Integer.parseInt(inputbean.getAdduserrole()));
            usr.setRoleId(role);
            
            
            session.save(usr);
           
            isAddPri = true;
            
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session = null;
            }
            e.printStackTrace();
            throw e;
        }finally {
            if (session != null) {
                 session.getTransaction().commit();
                session.close();
                session = null;
            }
        }
        return isAddPri;
    }
    
    public void findData(PrivilegeBean inputBean){
         List<UserRole> usr = null;
         Session session = null;
         try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            String sql = "from UserRole wu where wu.userRoleId =:userRoleId";
            Query query = session.createQuery(sql);
            query.setString("userRoleId", inputBean.getUserRoleId());
            usr = query.list();
            
             System.out.println("usr size "+usr.size());
             if (0 < usr.size()) {
//               inputBean.setUplecid(lecturerlist.get(0).getId().toString());
                inputBean.setUserRoleId(""+usr.get(0).getUserRoleId());
                System.out.println("role id "+inputBean.getUserRoleId());
                inputBean.setDescription(usr.get(0).getDescription());
                 System.out.println("role  "+inputBean.getDescription());
                
            
            }
         }catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session = null;
            }
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.close();
                session = null;
            }
        }
  }
    
//    public Map<String, String> getPageList(String pageId) throws Exception {
//    public List<PageDetails> getPageList(String pageId) throws Exception{
    public void getPageList(PrivilegeBean inputbean) throws Exception{
         Map<String, String> modulelist = new HashMap<String, String>();
         List<PageDetails> pagedetails = null;
         Session session = null;
         
         try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
//            String sql = "select pageDescription from PageDetails pageId =: pageId";
              String sql = "from PageDetails";
            Query query = session.createQuery(sql);
//            query.setString("userRoleId", pageId);
            pagedetails = query.list();
            
            for (int i = 0; i < pagedetails.size(); i++) {
                System.out.println(pagedetails.get(0));
                inputbean.getPageIdList().put(pagedetails.get(i).getPageId(), pagedetails.get(i).getPageDescription());
            }
            

            
        } catch (Exception e) {
             if (session != null) {
                 session.getTransaction().rollback();
                session.close();
                session = null;
            }
            throw e;
        }finally {
            if (session != null) {
                session.getTransaction().commit();
                session.close();
                session = null;
            }
        }
         
    }
    
    public boolean addPri(PrivilegeBean inputbean) throws Exception{
        boolean isAddPri = false;
        Session session = null;
        Privileges pri = null;
        List<UserRole> usr = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
             session.beginTransaction();
            
            String sql = "from UserRole wu where wu.description=:description";
            Query query = session.createQuery(sql);
            query.setString("description", inputbean.getDescription());
            usr = query.list();
             if (0 < usr.size()) {
                 inputbean.setUserRoleId(""+usr.get(0).getUserRoleId());
                }
            
            pri = new Privileges();
            System.out.println("page id "+inputbean.getPageId());
             System.out.println("role des "+inputbean.getDescription());
             System.out.println("role id "+inputbean.getUserRoleId());
            
            PageDetails pageDe = new PageDetails();
            pageDe.setPageId(Integer.parseInt(inputbean.getPageId()));
//                pageDe.setPageId(3);
            
            UserRole usrRole = new UserRole();
            usrRole.setUserRoleId(Integer.parseInt(inputbean.getUserRoleId()));
            
            pri.setPageId(pageDe);
            pri.setRoleId(usrRole);
           
            session.save(pri);
            
            
            isAddPri = true;
             
        } catch (Exception e) {
            if(session != null){
                session.getTransaction().rollback();
                session.flush();
                session.clear();
                session.close();
                session = null;
            }
            e.printStackTrace();
            throw e;
        }finally{
            if(session != null){
                session.getTransaction().commit();
                session.flush();
                session.clear();
                session.close();
                session = null;
            }
        }
        return isAddPri;
    }
    
     public void getUserRoleList(PrivilegeBean inputbean) throws Exception{
         List<UserRole> userRole = null;
         Session session = null;
         
         try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            String sql = "from UserRole";
            Query query = session.createQuery(sql);

            userRole = query.list();
            
            for (int i = 0; i < userRole.size(); i++) {
                System.out.println(userRole.get(0));
                inputbean.getUserroleList().put(userRole.get(i).getUserRoleId(), userRole.get(i).getDescription());
            }
            

            
        } catch (Exception e) {
             if (session != null) {
                 session.getTransaction().rollback();
                session.close();
                session = null;
            }
            throw e;
        }finally {
            if (session != null) {
                session.getTransaction().commit();
                session.close();
                session = null;
            }
        }
         
    }
}

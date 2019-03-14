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
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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

            String sqlCount = "select count(id) from UserRole ";
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
                        System.out.println("ids " + databean.getUserRoleId());
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

    public boolean addUsr(PrivilegeBean inputbean) throws Exception {
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
            if (inputbean.getAddgender().equals("1")) {
                usr.setGender(inputbean.getGenderlList().get(1));
            } else if (inputbean.getAddgender().equals("2")) {
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
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.close();
                session = null;
            }
        }
        return isAddPri;
    }

    public void findData(PrivilegeBean inputBean) {
        List<Privileges> privilegeses = null;
        Session session = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from Privileges pp where pp.roleId.userRoleId=:userRoleId";
            Query query = session.createQuery(sql);
            query.setString("userRoleId", inputBean.getUserRoleId());
            privilegeses = query.list();

            System.out.println("usr size " + privilegeses.size());
            if (privilegeses.isEmpty()) {
                if (inputBean.getUserRoleId().equals("1")) {
                    inputBean.setDescription("Super Admin");
                } else if (inputBean.getUserRoleId().equals("2")) {
                    inputBean.setDescription("Admin");
                } else if (inputBean.getUserRoleId().equals("3")) {
                    inputBean.setDescription("Manager");
                } else if (inputBean.getUserRoleId().equals("4")) {
                    inputBean.setDescription("User");
                }

            } else {
                for (int i = 0; i < privilegeses.size(); i++) {
                    inputBean.setUserRoleId("" + privilegeses.get(0).getRoleId().getUserRoleId());
                    inputBean.setDescription(privilegeses.get(0).getRoleId().getDescription());

                    inputBean.getAlreadyAcsessPageMap().put(privilegeses.get(i).getPageId().getPageId(), privilegeses.get(i).getPageId().getPageDescription());

                }
            }

        } catch (Exception e) {
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
    public void getPageList(PrivilegeBean inputbean) throws Exception {
        Map<String, String> modulelist = new HashMap<String, String>();
        List<PageDetails> pagedetails = null;
        Session session = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from PageDetails";
            Query query = session.createQuery(sql);
            pagedetails = query.list();

            for (int i = 0; i < pagedetails.size(); i++) {
                inputbean.getPageIdList().put(pagedetails.get(i).getPageId(), pagedetails.get(i).getPageDescription());
            }

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
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

    }

    public boolean addPri(PrivilegeBean inputbean) throws Exception {
        boolean isAddPri = false;
        Session session = null;
        Privileges pri = null;
        List<UserRole> usr = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            String pages[] = inputbean.getPageId().split("\\,");
            for (int i = 0; i < pages.length; i++) {
                session.beginTransaction();

                String sql = "from UserRole wu where wu.description=:description";
                Query query = session.createQuery(sql);
                query.setString("description", inputbean.getDescription());
                usr = query.list();
                if (0 < usr.size()) {
                    inputbean.setUserRoleId("" + usr.get(0).getUserRoleId());
                }

                System.out.println("page id " + inputbean.getPageId());
                System.out.println("role des " + inputbean.getDescription());
                System.out.println("role id " + inputbean.getUserRoleId());

//                Privileges criteria = (Privileges) session.createCriteria(Privileges.class, "privilages")
//                        .createAlias("privilages.roleId", "user_role")
//                        .createAlias("privilages.pageId", "pageId")
//                        .add(Restrictions.eq("user_role.userRoleId", Integer.parseInt(inputbean.getUserRoleId())))
//                        .add(Restrictions.eq("pageId.pageId", Integer.parseInt(pages[i]))).uniqueResult();
//                if(criteria!=null){
//                  session.delete(criteria);
//                }
                pri = new Privileges();
                UserRole ur = new UserRole();
                ur.setUserRoleId(Integer.parseInt(inputbean.getUserRoleId()));
                pri.setRoleId(ur);
                PageDetails pd = new PageDetails();
                pd.setPageId(Integer.parseInt(pages[i].trim()));
                pri.setPageId(pd);

                session.save(pri);
                session.getTransaction().commit();
            }

            isAddPri = true;

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.flush();
                session.clear();
                session.close();
                session = null;
            }
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                try {
//                    session.getTransaction().commit();
                    session.flush();
                    session.clear();
                    session.close();
                    session = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return isAddPri;
    }

    public boolean deleteexsitingpri(PrivilegeBean inputbean) throws Exception {
        boolean isAddPri = false;
        Session session = null;
        Privileges pri = null;
        List<UserRole> usr = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            String pages[] = inputbean.getPageId().split("\\,");
            for (int i = 0; i < pages.length; i++) {
                session.beginTransaction();

                String sql = "from UserRole wu where wu.description=:description";
                Query query = session.createQuery(sql);
                query.setString("description", inputbean.getDescription());
                usr = query.list();
                if (0 < usr.size()) {
                    inputbean.setUserRoleId("" + usr.get(0).getUserRoleId());
                }

                System.out.println("page id " + inputbean.getPageId());
                System.out.println("role des " + inputbean.getDescription());
                System.out.println("role id " + inputbean.getUserRoleId());

//                Privileges criteria = (Privileges) session.createCriteria(Privileges.class, "privilages")
//                        .createAlias("privilages.roleId", "user_role")
//                        .createAlias("privilages.pageId", "pageId")
//                        .add(Restrictions.eq("user_role.userRoleId", Integer.parseInt(inputbean.getUserRoleId())))
//                        .add(Restrictions.eq("pageId.pageId", Integer.parseInt(pages[i].trim()))).uniqueResult();
//                if (criteria != null) {
//                    session.delete(criteria);
//                    session.getTransaction().commit();
//                }

                String sql1 = "delete from Privileges wu where wu.roleId.userRoleId=:roleId";
                Query query1 = session.createQuery(sql1);
                query1.setInteger("roleId", Integer.parseInt(inputbean.getUserRoleId()));
                int result = query1.executeUpdate();
//                if (1 == result) {
//                    isAddPri = true;
//                }
                session.getTransaction().commit();

            }

            isAddPri = true;

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.flush();
                session.clear();
                session.close();
                session = null;
            }
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                try {
//                    session.getTransaction().commit();
                    session.flush();
                    session.clear();
                    session.close();
                    session = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return isAddPri;
    }

    public void getUserRoleList(PrivilegeBean inputbean) throws Exception {
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
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.close();
                session = null;
            }
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atten.service;

import Atten.bean.AttenBean;
import Util.HibernateInit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import mapping.Student;
import mapping.StudentCourse;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ridmi_g
 */
public class AttenService {
    public List<AttenBean> loadStudent(AttenBean inputBean, int max, int first, String orderBy) throws Exception {
        List<AttenBean> dataList = new ArrayList<AttenBean>();
        Session session = null;

        try {
            long count = 0;
            session = (Session) HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
        
             HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id= (int) sess.getAttribute("stcourselist");
            
            System.out.println("--------------- "+st_id);
            
            String sqlCount = "select count(s.id) from StudentCourse s where s.studentId.sId LIKE :sId";
            Query queryCount = session.createQuery(sqlCount);
            queryCount.setInteger("sId", st_id);
            Iterator itCount = queryCount.iterate();
            count = (Long) itCount.next();
            
            System.out.println("count "+count);
            
            if (count > 0) {
                String sqlSearch = "from StudentCourse s where s.studentId.sId LIKE :sId";
                Query querySearch = session.createQuery(sqlSearch);
                querySearch.setInteger("sId", st_id);

                querySearch.setMaxResults(max);
                querySearch.setFirstResult(first);

                Iterator it = querySearch.iterate();
                while (it.hasNext()) {
                    AttenBean databean = new AttenBean();
                    StudentCourse objBean = (StudentCourse) it.next();

                    try {
                        databean.setId(objBean.getId().toString());
                    } catch (NullPointerException e) {
                        databean.setId("--");
                    }
                    try {
                        databean.setCourseid(objBean.getCourseId().getCourseDescription());
                    } catch (NullPointerException e) {
                        databean.setCourseid("--");
                    }
                    try {
                        databean.setPayments(objBean.getCourseId().getMonthlyFee().toString());
                    } catch (NullPointerException e) {
                        databean.setPayments("--");
                    }
                    try {
                        databean.setCardType(objBean.getCardType().toString());
                    } catch (NullPointerException e) {
                        databean.setCardType("--");
                    }
                    try {
                        databean.setLastpayment(objBean.getCardType().toString());
                    } catch (NullPointerException e) {
                        databean.setLastpayment("--");
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
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.flush();
                session.clear();
                session.getTransaction().commit();
                session.close();
                session = null;
            }
        }
        return dataList;
    }
    
}

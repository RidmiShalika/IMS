/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report.service;

import Util.HibernateInit;
import java.util.ArrayList;
import java.util.List;
import login.bean.SessionBean;
import mapping.Course;
import mapping.Lecturer;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import report.bean.ReportBean;

/**
 *
 * @author ridmi_g
 */
public class ReportService {
    SessionBean sub = (SessionBean) ServletActionContext.getRequest().getSession(false).getAttribute("SessionObject");
    
    
      public void getCourseLists(ReportBean inputbean) throws Exception{
         List<Course> course = null;
         Session session = null;
         
         try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from Course";
            Query query = session.createQuery(sql);
            course = query.list();
            
            for (int i = 0; i < course.size(); i++) {
                 inputbean.getCourselList().put(i, course.get(i).getCourseDescription());
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
       public void getLecLists(ReportBean inputbean) throws Exception{
         List<Lecturer> lec = null;
         Session session = null;
         
         try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from Lecturer";
            Query query = session.createQuery(sql);
            lec = query.list();
            
            for (int i = 0; i < lec.size(); i++) {
                 inputbean.getLectureNamelList().put(lec.get(i).getId(), lec.get(i).getName());
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
       //for report 1
       public List<ReportBean> report1(){
           List<ReportBean> inputbean = new ArrayList<>();
           inputbean.add(new ReportBean("1", "asasa"));
           
           return inputbean;
       }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atten.service;

import Atten.bean.AttenBean;
import Util.HibernateInit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;
import mapping.Attendence;
import mapping.CourseDates;
import mapping.Student;
import mapping.StudentCourse;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
    public void loadData(AttenBean attenBean) throws Exception{
        Session session = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id= (int) sess.getAttribute("stcourselist");
            
            //load student details
            StudentCourse sc = (StudentCourse) session.createCriteria(StudentCourse.class, "studentcourse")
                    .add(Restrictions.eq("studentcourse.studentId.sId", st_id))
                    .uniqueResult();
            
            if(sc != null){
                attenBean.setName(sc.getStudentId().getSName());
                attenBean.setRegID(sc.getStudentId().getSId().toString());
                attenBean.setSchool(sc.getStudentId().getSSchool().getSchool());
                attenBean.setRegDate(sc.getRegistrationDate().toString());
                attenBean.setAddcardType(sc.getCardType().toString());
              
            }
            
            //get today paticular a class.ada dawsata adala class tiken lamaya apu welawath ekka aduma diff eka tiyna class eka  (cousrse_date , exctra class table)
            DateFormat dateFormat = new SimpleDateFormat("EEEE");
            Date date = new Date();
            String day = dateFormat.format(date).toLowerCase();
            System.out.println(day);
            
            if(day.equals("monday")){
                day = "monday";
            }else if(day.equals("tuesday")){
                day = "tueday";
            }else if(day.equals("wednesday")){
                day = "wedday";
            }else if(day.equals("thursday")){
                day = "thurday";
            }else if(day.equals("friday")){
                day = "friday";
            }else if(day.equals("thursday")){
                day = "satday";
            }else if(day.equals("sunday")){
                day = "sunday";
            }
            Criteria criteria = session.createCriteria(StudentCourse.class,"stc")
                    .createAlias("stc.studentId", "st")
                    .createAlias("stc.courseId", "cr")
                    .add(Restrictions.eq("st.sId", st_id));
//                    .add(Restrictions.not(Restrictions.eq("coursedate."+day+"", "-")));

            Iterator i = criteria.list()
                    .iterator();
            
            while (i.hasNext()) {
                StudentCourse studentCourse = (StudentCourse) i.next();
                Set<CourseDates> studentCoursesSet = studentCourse.getCourseId().getCourseDatesSet();
                List<CourseDates> siteIdList=new ArrayList<>(studentCoursesSet);
                
                System.out.println("course dates "+siteIdList.get(0));
                
            }
            
            
            //class ekata related payment status eka gannwa me current mmonth ekata payment table eken
            //attendance table ekta insert ekak wadina one ada apu class ekata adalawa
            //ada dawasata adala class eke lectuterge details load
                    
        } catch (Exception e) {
             if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session = null;
            }
            e.printStackTrace();
        }finally {
            if (session != null) {
                session.flush();
                session.clear();
                session.getTransaction().commit();
                session.close();
                session = null;
            }
        }
    }
    
}

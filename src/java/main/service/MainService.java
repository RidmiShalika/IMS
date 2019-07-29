/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.service;

import Util.HibernateInit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import main.bean.MainBean;
import mapping.PendingPayments;
import mapping.StudentCourse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ridmi_g
 */
public class MainService {
    public boolean addPaymentAccount(MainBean bean) throws Exception {
        boolean isAdd = false;
        Session session = null;
        Session session1 = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            Calendar cal = Calendar.getInstance();
            String curMonth = new SimpleDateFormat("MMMM").format(cal.getTime()).toLowerCase();
            String curYear = (new SimpleDateFormat("yyyy").format(cal.getTime())).toLowerCase();

            Criteria c = session.createCriteria(StudentCourse.class, "sc")
                    .add(Restrictions.eq("sc.status", "ACT"));
            Iterator i1 = c.list()
                    .iterator();
            while (i1.hasNext()) {
                StudentCourse studentCourse = (StudentCourse) i1.next();

                session1 = HibernateInit.getSessionFactory().openSession();
                session1.beginTransaction();
                PendingPayments pendingPayments = new PendingPayments();
                
                pendingPayments.setCid(studentCourse.getCourseId().getId());
                pendingPayments.setSid(studentCourse.getStudentId().getSId());
                pendingPayments.setMonth(curMonth);
                pendingPayments.setYear(curYear);
                pendingPayments.setCardType(studentCourse.getCardType());
                pendingPayments.setCreationDate(new Date());
                double monthlyfee = studentCourse.getCourseId().getMonthlyFee();
                pendingPayments.setClassFee(monthlyfee);
                pendingPayments.setStatus("Pending");
                pendingPayments.setFlag(1);
            
                if(pendingPayments.getCardType() == 1){
                    pendingPayments.setElegibleFee(monthlyfee);
                }else if(pendingPayments.getCardType() == 2){
                     pendingPayments.setElegibleFee(monthlyfee/2);
                }else{
                    pendingPayments.setElegibleFee(0.0);
                }
                session1.save(pendingPayments);
                session1.getTransaction().commit();
               
                isAdd = true;
            }
            
            
            
        } catch (Exception e) {
            if (session1 != null) {
                session1.getTransaction().rollback();
                session1.close();
                session1 = null;
            }
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session = null;
            }
            throw e;
        } finally {
            if (session1 != null) {
                session1.flush();
                session1.close();
                session1 = null;
            }
            if (session != null) {
                session.getTransaction().commit();
                session.flush();
                session.close();
                session = null;
            }
        }
        return isAdd;
    }
    public boolean isAlreadycreated(MainBean inputbean) throws Exception{
        boolean iscreated = false;
        Session session = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            Calendar cal = Calendar.getInstance();
            String curMonth = new SimpleDateFormat("MMMM").format(cal.getTime()).toLowerCase();
            String curYear = (new SimpleDateFormat("yyyy").format(cal.getTime())).toLowerCase();
            
            Criteria c = session.createCriteria(PendingPayments.class, "pp")
                    .add(Restrictions.eq("pp.month", curMonth))
                    .add(Restrictions.eq("pp.year", curYear))
                    .add(Restrictions.eq("pp.flag", 1))
                    .add(Restrictions.eq("pp.status", "Pending"));
            Iterator i1 = c.list()
                    .iterator();
            if (i1.hasNext()) {
                iscreated = true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session = null;
            }
            
            throw e;
        }finally{
            if (session != null) {
                session.getTransaction().commit();
                session.flush();
                session.close();
                session = null;
            }
        }
        return  iscreated;
    }
}

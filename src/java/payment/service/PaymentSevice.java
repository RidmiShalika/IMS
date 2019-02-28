/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment.service;

import Util.HibernateInit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import mapping.Attendence;
import mapping.Course;
import mapping.PaymentBillDetails;
import mapping.Payments;
import mapping.PendingPayments;
import mapping.Student;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import payment.bean.PaymentBean;

/**
 *
 * @author ridmi_g
 */
public class PaymentSevice {
    public List<PaymentBean> loadStudent(PaymentBean inputBean, int max, int first, String orderBy) throws Exception {
        List<PaymentBean> dataList = new ArrayList<PaymentBean>();
        Session session = null;

        try {
            long count = 0;
            session = (Session) HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id = (int) sess.getAttribute("s_id");

            System.out.println("--------------- " + st_id);

            String sqlCount = "select count(p.id) from PendingPayments p where p.status =:status and p.sid =:sId";
            Query queryCount = session.createQuery(sqlCount);
            queryCount.setString("status", "Pending");
            queryCount.setInteger("sId", st_id);
            Iterator itCount = queryCount.iterate();
            count = (Long) itCount.next();

            System.out.println("count " + count);

            if (count > 0) {
                String sqlSearch = "from PendingPayments p where p.status =:status and p.sid =:sId";
                Query querySearch = session.createQuery(sqlSearch);
                querySearch.setInteger("sId", st_id);
                querySearch.setString("status", "Pending");

                querySearch.setMaxResults(max);
                querySearch.setFirstResult(first);

                Iterator it = querySearch.iterate();
                while (it.hasNext()) {
                    PaymentBean databean = new PaymentBean();
                    PendingPayments objBean = (PendingPayments) it.next();

                    try {
                        databean.setId(objBean.getId().toString());
                    } catch (NullPointerException e) {
                        databean.setId("--");
                    }
                    try {
                        databean.setSid(objBean.getSid() + "");
                    } catch (NullPointerException e) {
                        databean.setSid("--");
                    }
                    try {
                        databean.setCid(objBean.getCid() + "");
                    } catch (NullPointerException e) {
                        databean.setCid("--");
                    }
                    try {
                        databean.setYear(objBean.getYear());
                    } catch (NullPointerException e) {
                        databean.setYear("--");
                    }
                    try {
                        databean.setMonth(objBean.getMonth());
                    } catch (NullPointerException e) {
                        databean.setMonth("--");
                    }
                    try {
                        databean.setStatus(objBean.getStatus());
                    } catch (NullPointerException e) {
                        databean.setStatus("--");
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
    public void paymentdetails(PaymentBean inputhbean) throws Exception {
        Session session = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String data[] = inputhbean.getSelected_data().split("\\,");

            for (int i = 0; i < data.length; i++) {

                Criteria criteria = session.createCriteria(PendingPayments.class, "pendingpayments")
                        .add(Restrictions.eq("pendingpayments.id", Integer.parseInt(data[i])))
                        .setProjection(Projections.distinct(Projections.projectionList()
                                .add(Projections.property("pendingpayments.sid"))
                                .add(Projections.property("pendingpayments.cid"))
                                .add(Projections.property("pendingpayments.month"))
                                .add(Projections.property("pendingpayments.year"))));

                Iterator iterator = criteria.list()
                        .iterator();

                while (iterator.hasNext()) {
                    Object[] ob = (Object[]) iterator.next();
                    int studentid = (int) ob[0];
                    int courseid  = (int) ob[1];
                    String month  = ob[2].toString();
                    String year   = ob[3].toString();
                    
                    Course course = (Course) session.createCriteria(Course.class, "c")
                        .add(Restrictions.eq("c.id", courseid))
                        .setProjection(Projections.distinct(Projections.projectionList()
                                .add(Projections.property("c.monthlyFee"))
                                .add(Projections.property("c.lecPaymentPercentage"))))
                            .uniqueResult();
                    
                    double monthlyFee = 0.0;
                    double lec_percentage = 0.0;
                    if(course!=null){
                        monthlyFee = course.getMonthlyFee();
                        lec_percentage = course.getLecPaymentPercentage();
                        
                    }
                    
                    //insert payment table
                    Payments payments = new Payments();
                    
                    Student s = new Student();
                    s.setSId(studentid);
                    payments.setStudentId(s);
                    
                    Course c = new Course();
                    c.setId(courseid);
                    payments.setCourseId(c);
                    
                    payments.setMonth(month);
                    payments.setYear(year);
                    payments.setAmount(monthlyFee);
                    payments.setDate(new Date().toString());
//                    payments.setPaidToLecture(Boolean.TRUE);
                    //card typ[e ???
                    session.save(payments);
                    
                    //insert payment bill table
                    PaymentBillDetails billDetails = new PaymentBillDetails();
                    //line id
                    billDetails.setStudentId(s);
                    billDetails.setCourseId(c);
                    //bill id
                    //bill amount
                    //payment month
                    //comment
                    //card type
                    
                    session.save(billDetails);
                    
                    
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
    }
    public void historyData(PaymentBean inputbean, int relv_cid) throws Exception{
        Session session = null;
        
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id = (int) sess.getAttribute("s_id");
            
            Criteria criteria = session.createCriteria(Attendence.class, "attendance")
                        .createAlias("attendance.studentId", "studentId")
                        .createAlias("attendance.courseId", "courseId")
                    .add(Restrictions.eq("studentId.sId",st_id))
                    .add(Restrictions.eq("courseId.id", relv_cid));
            criteria.addOrder(Order.desc("attendance.completeDate"));
            criteria.setMaxResults(20);
                    
             Iterator iterator = criteria.list()
                        .iterator();

            
            while (iterator.hasNext()) {
                Attendence attendence = (Attendence) iterator.next();
                String datee = attendence.getCompleteDate().toString();
                boolean Status = attendence.getAtten();
                String Statuss;
                if (Status == true) {
                    Statuss = "attend";
                } else {
                    Statuss = "not attend";
                }
                inputbean.getAttandance_history().add(datee + "     - " + Statuss);// 5 spaces before - and 1 space after -
            }

            
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
    
    public void getpaymenthistory(PaymentBean inputbean, int couid){
        Session session = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id = (int) sess.getAttribute("s_id");
            
            Criteria criteria = session.createCriteria(PendingPayments.class,"p")
                     .add(Restrictions.eq("p.sid",st_id))
                    .add(Restrictions.eq("p.cid", couid));
            criteria.setMaxResults(20);
            
            Iterator iterator = criteria.list()
                        .iterator();
            while (iterator.hasNext()) {
                PendingPayments pendingPayments = (PendingPayments) iterator.next();
                String month = pendingPayments.getMonth();
                String Status = pendingPayments.getStatus();
               
                inputbean.getPayment_history().add(month + "   - " + Status);
            }
            
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
    
    public int getcorseid(PaymentBean inputhbean){
        Session session = null;
        int courseid = 0;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            PendingPayments payments = (PendingPayments) session.createCriteria(PendingPayments.class, "p")
                     .add(Restrictions.eq("p.id",Integer.parseInt(inputhbean.getPid()))).uniqueResult();
             
            courseid = payments.getCid();
            
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
        return courseid;
    }
}

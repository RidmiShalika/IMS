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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;
import mapping.Attendence;
import mapping.Course;
import mapping.CourseDates;
import mapping.ExtraClasses;
import mapping.PaymentBillDetails;
import mapping.Payments;
import mapping.PendingPayments;
import mapping.Student;
import mapping.StudentCourse;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
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
            int st_id = (int) sess.getAttribute("stcourselist");

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
                    AttenBean databean = new AttenBean();
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

    public void loadData(AttenBean attenBean) throws Exception {
        Session session = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id = (int) sess.getAttribute("stcourselist");

            //load student details
            Iterator it = session.createCriteria(StudentCourse.class, "studentcourse")
                    .createAlias("studentcourse.studentId", "st")
                    .createAlias("st.sSchool", "sc")
                    .add(Restrictions.eq("st.sId", st_id))
                    //                    .uniqueResult();
                    .setProjection(Projections.distinct(Projections.projectionList()
                            .add(Projections.property("st.sName"))
                            .add(Projections.property("st.sId"))
                            .add(Projections.property("sc.school"))
                            .add(Projections.property("studentcourse.registrationDate"))
                            .add(Projections.property("studentcourse.cardType"))))
                    .list().iterator();

            while (it.hasNext()) {
                Object[] ob = (Object[]) it.next();

                attenBean.setName(ob[0] + "");
                attenBean.setRegID(ob[1] + "");
                attenBean.setSchool(ob[2] + "");
                attenBean.setRegDate(ob[3] + "");
                attenBean.setAddcardType(ob[4] + "");

                System.out.println(attenBean.getName());
            }

            //get today paticular a class.ada dawsata adala class tiken lamaya apu welawath ekka aduma diff eka tiyna class eka  (cousrse_date , exctra class table)
            DateFormat dateFormat = new SimpleDateFormat("EEEE");
            Date date = new Date();
            String day = dateFormat.format(date).toLowerCase();
            System.out.println(day);

            if (day.equals("monday")) {
                day = "monday";
            } else if (day.equals("tuesday")) {
                day = "tueday";
            } else if (day.equals("wednesday")) {
                day = "wedday";
            } else if (day.equals("thursday")) {
                day = "thurday";
            } else if (day.equals("friday")) {
                day = "friday";
            } else if (day.equals("saturday")) {
                day = "satday";
            } else if (day.equals("sunday")) {
                day = "sunday";
            }
            Criteria criteria = session.createCriteria(StudentCourse.class, "stc")
                    .createAlias("stc.studentId", "st")
                    .createAlias("stc.courseId", "cr")
                    .createAlias("cr.courseDatesSet", "coursedate")
                    .add(Restrictions.eq("st.sId", st_id))
                    .add(Restrictions.not(Restrictions.eq("coursedate." + day + "", "-")))
                    .setProjection(Projections.distinct(Projections.projectionList()
                            .add(Projections.property("cr.id"))
                            .add(Projections.property("coursedate." + day))));

            Iterator i = criteria.list()
                    .iterator();

            List<String[]> list = new ArrayList<String[]>();
            while (i.hasNext()) {
                Object[] ob = (Object[]) i.next();

                String[] classaArray = new String[3];
                classaArray[0] = ob[0].toString();
                classaArray[1] = ob[1].toString();
                classaArray[2] = "Normal";

                list.add(classaArray);

//                StudentCourse studentCourse = (StudentCourse) i.next();
//                Set<CourseDates> studentCoursesSet = studentCourse.getCourseId().getCourseDatesSet();
//                List<CourseDates> siteIdList = new ArrayList<>(studentCoursesSet);
//                
//                if (day.equals("monday")) {
//                    list.add(siteIdList.get(0).getMonday());
////                    classArray[0] = studentCourse.getCourseId().getId().toString();
////                    classArray[1] = studentCourse.getCourseId().getId().toString();
//                } else if (day.equals("tueday")) {
//                    list.add(siteIdList.get(0).getTueday());
//                } else if (day.equals("wedday")) {
//                    list.add(siteIdList.get(0).getWedday());
//                } else if (day.equals("thurday")) {
//                    list.add(siteIdList.get(0).getThurday());
//                } else if (day.equals("friday")) {
//                    list.add(siteIdList.get(0).getFriday());
//                } else if (day.equals("satday")) {
//                    list.add(siteIdList.get(0).getSatday());
//                } else if (day.equals("sunday")) {
//                    list.add(siteIdList.get(0).getSunday());
//                }
            }

            //from extra class table
            Date sdate = new Date();
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");

            Criteria c = session.createCriteria(ExtraClasses.class, "ex")
                    .add(Restrictions.eq("ex.date", sdf1.format(sdate)));
            Iterator i1 = c.list()
                    .iterator();
            while (i1.hasNext()) {
                ExtraClasses extraClasses = (ExtraClasses) i1.next();

                String[] exclassaArray = new String[3];

                exclassaArray[0] = extraClasses.getCourseId().getId().toString();
                exclassaArray[1] = extraClasses.getStartTime() + "-" + extraClasses.getEndTime();
                exclassaArray[2] = "Extra";

                list.add(exclassaArray);
            }

//            Set<String> set = new HashSet<>(list);
//            list.clear();
//            list.addAll(set);
            int selected_index = -1;
            if (list.size() == 1) {
//                return list.get(0);
                selected_index = 0;
            } else {
                long dif = 0;
                int count = 0;
                for (int x = 0; x < list.size(); x++) {
                    System.out.println("8888 " + list.get(x));
                    String courseid = list.get(x)[0];
                    String c_time = list.get(x)[1].split("-")[0];

                    DateFormat sdf = new SimpleDateFormat("HH:mm");
                    Date sysdate = new Date();
                    Date time1 = sdf.parse(c_time);
                    Date time2 = sdf.parse(sdf.format(sysdate));

                    long curr_difference = time1.getTime() - time2.getTime();

                    System.out.println(curr_difference);

                    if (curr_difference < 0) {
                        curr_difference = curr_difference * (-1);
                    }
                    if (count == 0) {
                        dif = curr_difference;
                    }
                    if (curr_difference <= dif) {
                        dif = curr_difference;
                        selected_index = x;
                    }
                    count++;
                }
            }

            String[] outList = new String[3];
            if (selected_index > -1) {
                outList = list.get(selected_index);
            }

//            int cid = 8;
            int cid = Integer.parseInt(outList[0]);
            //class ekata related payment status eka gannwa me current mmonth ekata payment table eken
            Criteria c1 = session.createCriteria(Payments.class, "payment")
                    .createAlias("payment.studentId", "sid")
                    .createAlias("payment.courseId", "cid")
                    .add(Restrictions.eq("sid.sId", st_id))
                    .add(Restrictions.eq("cid.id", cid));
            Iterator i2 = c1.list().iterator();

            attenBean.setAddpayments("NO");
            while (i2.hasNext()) {
                Payments p = (Payments) i2.next();

                attenBean.setAddpayments("YES");
            }

            //attendance table ekta insert ekak wadina one ada apu class ekata adalawa
            Date date1 = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
            String dd = sdf.format(date1);
            String datTime[] = dd.split("\\|");
            String dateonly[] = datTime[0].split("\\-");

            if (!alreadyAtte(st_id, cid, datTime[0])) {
                Attendence attendence = new Attendence();
                attendence.setAtten(true);
                attendence.setCompleteDate(new Date());
                Course c2 = new Course();
                c2.setId(cid);
                attendence.setCourseId(c2);
                Student s = new Student();
                s.setSId(st_id);
                attendence.setStudentId(s);
                attendence.setDate(Integer.parseInt(dateonly[2]));
                attendence.setDay(dateFormat.format(date).toLowerCase());
                attendence.setMonth(Integer.parseInt(dateonly[1]));
                attendence.setTime(datTime[1]);
                attendence.setYear(Integer.parseInt(dateonly[0]));
                attendence.setCompleteDate(new Date());
                session.save(attendence);
            }

            //ada dawasata adala class eke lectuterge details load
            Criteria c3 = session.createCriteria(StudentCourse.class, "stcr")
                    .createAlias("stcr.studentId", "stu")
                    .createAlias("stcr.courseId", "crs")
                    .add(Restrictions.eq("stu.sId", st_id))
                    .add(Restrictions.eq("crs.id", cid));

            Iterator i3 = c3.list().iterator();
            while (i3.hasNext()) {
                StudentCourse studentCourse = (StudentCourse) i3.next();

                attenBean.setLname(studentCourse.getCourseId().getLectureId().getName());
                if (studentCourse.getCourseId().getClassType() == 1) {
                    attenBean.setExtra_normal("Theory Class");
                } else if (studentCourse.getCourseId().getClassType() == 2) {
                    attenBean.setExtra_normal("Revision Class");
                } else if (studentCourse.getCourseId().getClassType() == 3) {
                    attenBean.setExtra_normal("Paper Class");
                }
                attenBean.setCourseId(studentCourse.getCourseId().getCourseDescription());
                if (studentCourse.getCardType() == 1) {
                    attenBean.setCrdType("Normal Card");
                } else if (studentCourse.getCardType() == 2) {
                    attenBean.setCrdType("Half Card");
                } else if (studentCourse.getCardType() == 3) {
                    attenBean.setCrdType("Free Card");
                }
                attenBean.setCrdType(day);

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

    public boolean alreadyAtte(int sid, int cid, String date) throws Exception {
        boolean isatte = false;
        Session session = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Attendence attendence = (Attendence) session.createCriteria(Attendence.class, "attendance")
                    .createAlias("attendance.studentId", "sid")
                    .createAlias("attendance.courseId", "cid")
                    .add(Restrictions.eq("sid.sId", sid))
                    .add(Restrictions.eq("cid.id", cid))
                    .add(Restrictions.eq("attendance.completeDate", sdf.parse(date))).uniqueResult();
            if (attendence != null) {
                isatte = true;
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
        return isatte;
    }

    public void paymentdetails(AttenBean inputhbean) throws Exception {
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
    
    public void historyData(AttenBean inputbean, int relv_cid) throws Exception{
//        ArrayList<String> attandance_history = new ArrayList<String>();
        Session session = null;
        
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id = (int) sess.getAttribute("stcourselist");
            
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
    
    public void getpaymenthistory(AttenBean inputbean, int couid){
        Session session = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id = (int) sess.getAttribute("stcourselist");
            
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
    
    public int getcorseid(AttenBean inputhbean){
        Session session = null;
        int courseid = 0;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            PendingPayments payments = (PendingPayments) session.createCriteria(PendingPayments.class, "p")
                     .add(Restrictions.eq("p.id",Integer.parseInt(inputhbean.getAttenid()))).uniqueResult();
             
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

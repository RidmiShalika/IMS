/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atten.service;

import Atten.bean.AttenBean;
import Util.Config;
import Util.HibernateInit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import login.bean.SessionBean;
import mapping.Attendence;
import mapping.Course;
import mapping.ExtraClasses;
import mapping.PaymentBillDetails;
import mapping.Payments;
import mapping.PendingPayments;
import mapping.SmsDetails;
import mapping.Student;
import mapping.StudentCourse;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import payment.bean.paymentBillBean;

/**
 *
 * @author ridmi_g
 */
public class AttenService {

    SessionBean sub = (SessionBean) ServletActionContext.getRequest().getSession(false).getAttribute("SessionObject");

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
                        String sqlSearch1 = "from Course p where p.id =:id";
                        Query querySearch1 = session.createQuery(sqlSearch1);
                        querySearch1.setInteger("id", objBean.getCid());

                        Iterator it1 = querySearch1.iterate();
                        while (it1.hasNext()) {
                            Course c = (Course) it1.next();
                            
                            databean.setCid(c.getCourseDescription());
                        }
                        
                    } catch (Exception e) {
                        e.printStackTrace();
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
    
    
    public List<paymentBillBean> getBillData(String bill_id) throws Exception {
        List<paymentBillBean> dataList = new ArrayList<paymentBillBean>();
        Session session = null;

        try {
            
            session = (Session) HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
//            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            
//            String sqlCount = "select s.s_name,p.student_id,p.created_date,p.issued_by,"
//                    + "c.course_description,p.payment_month,p.bill_amount "
//                    + "from payment_bill_details p, student s, course c "
//                    + "where bill_id = :bill and c.id = p.course_id and s.s_id = p.student_id";
//            Query queryCount = session.createQuery(sqlCount);
//            queryCount.setString("bill", bill_id);
//            
//            Iterator itCount = queryCount.iterate();
            
            Iterator itCount = session.createCriteria(PaymentBillDetails.class, "paymentBillDe")
                    .createAlias("paymentBillDe.studentId", "st")
                    .createAlias("paymentBillDe.courseId", "cs")
                    .add(Restrictions.eq("paymentBillDe.billId", bill_id))
                    .setProjection(Projections.distinct(Projections.projectionList()
                            .add(Projections.property("st.sName"))
                            .add(Projections.property("st.sId"))
                            .add(Projections.property("paymentBillDe.createdDate"))
                            .add(Projections.property("paymentBillDe.issuedBy"))
                            .add(Projections.property("cs.courseDescription"))
                            .add(Projections.property("paymentBillDe.paymentMonth"))
                            .add(Projections.property("paymentBillDe.billAmount"))))
                    .list().iterator();
             while (itCount.hasNext()) {
                 Object[] ob = (Object[]) itCount.next();
                 paymentBillBean bean = new paymentBillBean();
                 bean.setS_name(ob[0]+"");
                 bean.setS_id(Integer.parseInt(ob[1].toString()));
                 bean.setCreated_time(ob[2]+"");
                 bean.setIssued_by(ob[3]+"");
                 bean.setCourse_dis(ob[4]+"");
                 bean.setPayment_month(ob[5]+"");
                 bean.setBill_amount(Double.parseDouble(ob[6].toString()));
                 dataList.add(bean);
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
            attenBean.setError("NO");
            //load student details
            Iterator it = session.createCriteria(StudentCourse.class, "studentcourse")
                    .createAlias("studentcourse.studentId", "st")
                    .createAlias("st.sSchool", "sc")
                    .add(Restrictions.eq("st.sId", st_id))
                    .add(Restrictions.eq("studentcourse.status", "ACT"))
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
                    .add(Restrictions.eq("stc.status", "ACT"))
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

            }

            //from extra class table
            Date sdate = new Date();
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");

            Criteria c = session.createCriteria(ExtraClasses.class, "ex")
                    .add(Restrictions.eq("ex.status", "ACT"))
                    .add(Restrictions.eq("ex.date", sdf1.format(sdate)));
            Iterator i1 = c.list()
                    .iterator();
            while (i1.hasNext()) {
                ExtraClasses extraClasses = (ExtraClasses) i1.next();

                Criteria cc = session.createCriteria(StudentCourse.class, "stc")
                        .createAlias("stc.studentId", "st")
                        .createAlias("stc.courseId", "c")
                        .add(Restrictions.eq("st.sId", st_id))
                        .add(Restrictions.eq("c.id", extraClasses.getCourseId().getId()))
                        .add(Restrictions.eq("stc.status", "ACT"));
                Iterator i11 = cc.list()
                        .iterator();
                if (i11.hasNext()) {

                    String[] exclassaArray = new String[3];

                    exclassaArray[0] = extraClasses.getCourseId().getId().toString();
                    exclassaArray[1] = extraClasses.getStartTime() + "-" + extraClasses.getEndTime();
                    exclassaArray[2] = "Extra";

                    list.add(exclassaArray);
                }

            }

//            Set<String> set = new HashSet<>(list);
//            list.clear();
//            list.addAll(set);
            int selected_index = -1;
            if (list.size() == 0 && attenBean.getPaymentjsp().equals("1")) {
                attenBean.setError("YES");
            } else if (list.size() == 1) {
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

//            int cid = 8;
                int cid = Integer.parseInt(outList[0]);
                
                attenBean.setCid(cid + "");
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
                if (!attenBean.getPaymentjsp().equals("0")) {
                    Date date1 = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd|HH:mm:ss");
                    String dd = sdf.format(date1);
                    String datTime[] = dd.split("\\|");
                    String dateonly[] = datTime[0].split("\\-");

                    if (!alreadyAtte(st_id, cid, datTime[0].trim())) {
                        Attendence attendence = new Attendence();
                        attendence.setAtten(true);
                        attendence.setCompleteDate(new Date());
                        Course c2 = new Course();
                        c2.setId(cid);
                        attendence.setCourseId(c2);
                        Student s = new Student();
                        s.setSId(st_id);
                        attendence.setStudentId(s);
                        attendence.setDate(Integer.parseInt(dateonly[2].trim()));
                        attendence.setDay(dateFormat.format(date).toLowerCase());
                        attendence.setMonth(Integer.parseInt(dateonly[1].trim()));
                        attendence.setTime(datTime[1].trim());
                        attendence.setYear(Integer.parseInt(dateonly[0].trim()));
                        attendence.setCompleteDate(new Date());
                        session.save(attendence);
                    }
                }

                //ada dawasata adala class eke lectuterge details load
                Criteria c3 = session.createCriteria(StudentCourse.class, "stcr")
                        .createAlias("stcr.studentId", "stu")
                        .createAlias("stcr.courseId", "crs")
                        .add(Restrictions.eq("stu.sId", st_id))
                        .add(Restrictions.eq("crs.id", cid))
                        .add(Restrictions.eq("stcr.status", "ACT"));

                Iterator i3 = c3.list().iterator();
                while (i3.hasNext()) {
                    StudentCourse studentCourse = (StudentCourse) i3.next();

                    attenBean.setLname(studentCourse.getCourseId().getLectureId().getName());
                    
                    attenBean.setExtra_normal(outList[2]+" class");
                    attenBean.setCourseId(studentCourse.getCourseId().getCourseDescription());
                    if (studentCourse.getCardType() == 1) {
                        attenBean.setCrdType("Normal Card");
                    } else if (studentCourse.getCardType() == 2) {
                        attenBean.setCrdType("Half Card");
                    } else if (studentCourse.getCardType() == 3) {
                        attenBean.setCrdType("Free Card");
                    }
//                    attenBean.setCrdType(day);

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
        String paymentSMS = "";

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            //generate bill ifd
            String bill_id_post = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

            inputhbean.setHiddBillid("testbillid");

            String Payment_SMS = " is paid for following class(es) on " + new SimpleDateFormat("YYYY-MM-dd").format(new Date()) + "-NLC-";

            String data[] = inputhbean.getSelected_data().split("\\,");
            HashMap parameters = new HashMap();
            List<paymentBillBean> collection = new ArrayList<paymentBillBean>();
            


            for (int i = 0; i < data.length; i++) {

                Criteria criteria = session.createCriteria(PendingPayments.class, "pendingpayments")
                        .add(Restrictions.eq("pendingpayments.id", Integer.parseInt(data[i].trim())))
                        .setProjection(Projections.distinct(Projections.projectionList()
                                .add(Projections.property("pendingpayments.sid"))
                                .add(Projections.property("pendingpayments.cid"))
                                .add(Projections.property("pendingpayments.month"))
                                .add(Projections.property("pendingpayments.year"))
                                .add(Projections.property("pendingpayments.status"))));

                Iterator iterator = criteria.list()
                        .iterator();

                while (iterator.hasNext()) {
                    Object[] ob = (Object[]) iterator.next();
                    int studentid = (int) ob[0];
                    int courseid = (int) ob[1];
                    String month = ob[2].toString();
                    String year = ob[3].toString();

                    Criteria course = session.createCriteria(Course.class, "c")
                            .add(Restrictions.eq("c.id", courseid));
//                        .setProjection(Projections.distinct(Projections.projectionList()
//                                .add(Projections.property("c.monthlyFee"))
//                                .add(Projections.property("c.lecPaymentPercentage"))));

                    double monthlyFee = 0.0;
                    double lec_percentage = 0.0;

                    Iterator iterator1 = course.list()
                            .iterator();
                    while (iterator1.hasNext()) {
                        Course cc = (Course) iterator1.next();
                        monthlyFee = cc.getMonthlyFee();
                        lec_percentage = cc.getLecPaymentPercentage();

                    }

                    String bill_id = studentid + "_" + bill_id_post;
                    inputhbean.setHiddBillid(bill_id);
//                    parameters.put("bill_id", bill_id);//malinda
                    
                    StudentCourse scourse = (StudentCourse) session.createCriteria(StudentCourse.class, "sc")
                            .createAlias("sc.studentId", "sid")
                            .createAlias("sc.courseId", "cid")
                            .add(Restrictions.eq("sid.sId", studentid))
                            .add(Restrictions.eq("cid.id", courseid))
                            .add(Restrictions.eq("sc.status", "ACT"))
                            .uniqueResult();

                    //sms create
                    if (i == 0) {
                        paymentSMS = scourse.getStudentId().getSName() + Payment_SMS;
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
                    payments.setPaidToLecture(Boolean.FALSE);
                    payments.setCardType(scourse.getCardType());
                    session.save(payments);

                    //insert payment bill table
                    PaymentBillDetails billDetails = new PaymentBillDetails();
                    //line id
                    billDetails.setStudentId(s);
                    billDetails.setCourseId(c);
                    //bill id
                    billDetails.setBillId(bill_id);
                    //bill amount
                    billDetails.setBillAmount(monthlyFee);
                    //payment month
                    billDetails.setPaymentMonth(month + "-" + year);
                    //comment
                    billDetails.setComments("Full payment");
                    //card type

                    billDetails.setCardType(scourse.getCardType());
                    billDetails.setIssuedBy(sub.getUserName());
                    billDetails.setCreatedDate(new Date());

                    session.save(billDetails);
                    //set bill print details
//                    billBean.setBill_amount(monthlyFee);
//                    billBean.setBill_id(bill_id);
//                    billBean.setCard_type(scourse.getCardType()+"");
//                    billBean.setCourse_id(c.getCourseDescription());
//                    billBean.setCreated_time(new Date().toString());
//                    billBean.setIssued_by(sub.getUserName());
//                    billBean.setLine_id(1);
//                    billBean.setPayment_month(month + "-" + year);
//                    billBean.setS_id(s.getSId());
//                    collection.add(billBean);
//                    inputhbean.setReportdatalist(collection);

                    Query query = null;
                    PendingPayments refProfile = null;
                    String sql = "from PendingPayments wu where wu.id =:ID";
                    query = session.createQuery(sql);
                    query.setInteger("ID", Integer.parseInt(data[i].trim()));
                    refProfile = (PendingPayments) query.uniqueResult();
                    if (refProfile != null) {
                        refProfile.setStatus("Completed");

                        session.update(refProfile);
                    }

                    paymentSMS = paymentSMS + "Rs " + monthlyFee + " for " + scourse.getCourseId().getCourseDescription() + " Month of " + month + "-NLC-";

                }

            }
//            inputhbean.setBillList(collection);
//            inputhbean.setParameters(parameters);
            //print bill malinda
//            JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(collection);
//            String jasperPath = ServletActionContext.getServletContext().getRealPath("/resources/jasper/LatestPaymentRecipt _bean.jasper");
//            
////            Map parameters = new HashMap();
////            parameters.put("userid", 1);
////            net.sf.jasperreports.engine.JasperReport jr = JasperCompileManager.compileReport(jd);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperPath, parameters, beanCollectionDataSource);


            // insert sms table
            String mobileno = getmobileNo(inputhbean);
            if (!"".equals(mobileno)) {
                boolean checkmobileno = validateMobileNo(mobileno.trim());
                if (checkmobileno) {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
                    Date date = new Date();
                    insert_payment_SMS(paymentSMS, formatter.format(date).replace(" ", "+"), mobileno);
                } else {
                    System.out.println("Mobile number validation fails");
                }

            } else {
                System.out.println("No mobile number");
            }

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session = null;
            }

        } finally {
            if (session != null) {
                session.flush();
                session.clear();
                session.close();
                session = null;
            }
        }
    }

    public void historyData(AttenBean inputbean, int relv_cid) throws Exception {
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
                    .add(Restrictions.eq("studentId.sId", st_id))
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
                inputbean.getAttandance_history().add(datee + "     - " + Statuss + System.lineSeparator());// 5 spaces before - and 1 space after -
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

    public void getpaymenthistory(AttenBean inputbean, int couid) {
        Session session = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id = (int) sess.getAttribute("stcourselist");

            Criteria criteria = session.createCriteria(PendingPayments.class, "p")
                    .add(Restrictions.eq("p.sid", st_id))
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

    public int getcorseid(AttenBean inputhbean) {
        Session session = null;
        int courseid = 0;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            PendingPayments payments = (PendingPayments) session.createCriteria(PendingPayments.class, "p")
                    .add(Restrictions.eq("p.id", Integer.parseInt(inputhbean.getAttenid()))).uniqueResult();

            courseid = payments.getCid();

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
        return courseid;
    }

    public boolean IS_First_Entrence() throws Exception {
        boolean count = true;
        Session session = null;
        try {
            DateFormat dateFormat2 = new SimpleDateFormat("YYYY-MM-dd");
            String dateattendence2 = dateFormat2.format(new Date());

            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id = (int) sess.getAttribute("stcourselist");

            Criteria criteria = session.createCriteria(Attendence.class, "at")
                    .createAlias("at.studentId", "st")
                    .add(Restrictions.eq("at.atten", true))
                    .add(Restrictions.eq("at.completeDate", new Date()))
                    .add(Restrictions.eq("st.sId", st_id));

            Iterator iterator = criteria.list()
                    .iterator();
            if (iterator.hasNext()) {
                count = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public String getmobileNo(AttenBean inputbean) throws Exception {
        String mobileno = "";
        Session session = null;
        try {

            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id = (int) sess.getAttribute("stcourselist");

            Criteria criteria = session.createCriteria(Student.class, "st")
                    .add(Restrictions.eq("st.sId", st_id));

            Iterator iterator = criteria.list()
                    .iterator();
            while (iterator.hasNext()) {
                Student s = (Student) iterator.next();
                mobileno = s.getSParentContactNo();
                if (s.getSGender().equals("1")) {
                    inputbean.setStudent_gender("son");
                } else if (s.getSGender().equals("2")) {
                    inputbean.setStudent_gender("daughter");
                }
                inputbean.setStudent_name(s.getSName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mobileno;
    }

    public int insert_arrive_SMS(String title, String Name, String time, String mobile) {
        String new_body = Config.SMS_Genaral_attendance;
        int x = 0;
        time = time.replace(":", "%3A");
        new_body = new_body.replace("<TITLE>", title);
        new_body = new_body.replace("<NAME>", Name);
        new_body = new_body.replace("<TIME>", time);

        Session session = null;

        try {
            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id = (int) sess.getAttribute("stcourselist");

            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            SmsDetails smsDetails = new SmsDetails();
            smsDetails.setSId(st_id + "");
            smsDetails.setBody(new_body);
            smsDetails.setCreatedDate(time);
            smsDetails.setMobile(mobile);
            smsDetails.setRetryAttempts(0);
            smsDetails.setStatus(0);

            session.save(smsDetails);
            session.getTransaction().commit();
            x = 1;

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session = null;
            }
            throw ex;
        } finally {
            if (session != null) {
                session.flush();
                session.clear();
                session.close();
                session = null;
            }
        }
        return x;
    }

    public boolean validateMobileNo(String parentContactNo) throws Exception {
        boolean status = false;
        try {

            if (parentContactNo.length() == 9) {
                parentContactNo = "0" + parentContactNo;
            }
            if (parentContactNo.matches("[0-9]+") && parentContactNo.length() == 10) {
                String prefix = parentContactNo.trim().substring(0, 3);
                if (prefix.equals("070") || prefix.equals("071") || prefix.equals("072") || prefix.equals("075") || prefix.equals("076") || prefix.equals("077") || prefix.equals("078")) {
                    status = true;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return status;
    }

    public int insert_payment_SMS(String body, String time, String mobile) {
        int x = 0;
        Session session = null;
        time = time.replace(":", "%3A");

        try {
            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id = (int) sess.getAttribute("stcourselist");

            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            SmsDetails smsDetails = new SmsDetails();
            smsDetails.setSId(st_id + "");
            smsDetails.setBody(body);
            smsDetails.setCreatedDate(time);
            smsDetails.setMobile(mobile);
            smsDetails.setRetryAttempts(0);
            smsDetails.setStatus(0);

            session.save(smsDetails);
            session.getTransaction().commit();
            x = 1;

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session = null;
            }
            throw ex;
        } finally {
            if (session != null) {
                session.flush();
                session.clear();
                session.close();
                session = null;
            }
        }
        return x;
    }

    public int getSIDusibgCardNo(String cardno) throws Exception {
        Session session = null;
        int sid = 0;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Student.class, "st")
                    .add(Restrictions.eq("st.cardNumber", cardno.trim()));

            Iterator iterator = criteria.list()
                    .iterator();

            while (iterator.hasNext()) {
                Student student = (Student) iterator.next();
                sid = student.getSId();
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
        return sid;
    }

}

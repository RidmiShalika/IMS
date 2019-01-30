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
import mapping.CourseDates;
import mapping.ExtraClasses;
import mapping.Student;
import mapping.StudentCourse;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
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

            String sqlCount = "select count(s.id) from StudentCourse s where s.studentId.sId LIKE :sId";
            Query queryCount = session.createQuery(sqlCount);
            queryCount.setInteger("sId", st_id);
            Iterator itCount = queryCount.iterate();
            count = (Long) itCount.next();

            System.out.println("count " + count);

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
                    .add(Restrictions.not(Restrictions.eq("coursedate." + day + "", "-")));
//                    .setProjection(Projections.distinct(Projections.property("cr.id")));
            

            Iterator i = criteria.list()
                    .iterator();

            List<String> list= new ArrayList<String>();
            while (i.hasNext()) {
                StudentCourse studentCourse = (StudentCourse) i.next();
                Set<CourseDates> studentCoursesSet = studentCourse.getCourseId().getCourseDatesSet();
                List<CourseDates> siteIdList = new ArrayList<>(studentCoursesSet);
                
                
                if (day.equals("monday")) {
                    list.add(siteIdList.get(0).getMonday());
                } else if (day.equals("tueday")) {
                    list.add(siteIdList.get(0).getTueday());
                } else if (day.equals("wedday")) {
                    list.add(siteIdList.get(0).getWedday());
                } else if (day.equals("thurday")) {
                    list.add(siteIdList.get(0).getThurday());
                } else if (day.equals("friday")) {
                    list.add(siteIdList.get(0).getFriday());
                } else if (day.equals("satday")) {
                    list.add(siteIdList.get(0).getSatday());
                } else if (day.equals("sunday")) {
                    list.add(siteIdList.get(0).getSunday());
                }

            }
            
            //from extra class table
            Date sdate = new Date();
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
                    
            Criteria c = session.createCriteria(ExtraClasses.class,"ex")
                    .add(Restrictions.eq("ex.date", sdf1.format(sdate)));
            Iterator i1 = c.list()
                    .iterator();
             while (i1.hasNext()) {
                 ExtraClasses extraClasses = (ExtraClasses) i1.next();
                 list.add(extraClasses.getStartTime()+"-"+extraClasses.getEndTime());
             }
            
            Set<String> set = new HashSet<>(list);
            list.clear();
            list.addAll(set);
            
            long dif = 0;
            int count = 0;
            for(int x = 0 ; x<list.size();x++){
                System.out.println("8888 "+list.get(x));
                String st_date[]  = list.get(x).split("\\-");
                
                DateFormat sdf = new SimpleDateFormat("HH:mm");
                Date sysdate = new Date();  
                String time1 = st_date[0];
                String time2 = sdf.format(sysdate);

                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                Date date1 = format.parse(time1);
                Date date2 = format.parse(time2);
                long difference = date2.getTime() - date1.getTime(); 
                
                System.out.println(difference); 
                
                 if (difference < 0) {
                        difference = difference * (-1);
                    }
                    if (count == 0) {
                        dif = difference;
                    }
                    if (difference <= dif) {
                        dif = difference;

                    }
                    count++;
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

}

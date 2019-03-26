/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.service;

import Util.HibernateInit;
import course.bean.CourseBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import login.bean.SessionBean;
import mapping.Course;
import mapping.CourseDates;
import mapping.ExtraClasses;
import mapping.Lecturer;
import mapping.Subject;
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
public class CourseService {

    SessionBean sub = (SessionBean) ServletActionContext.getRequest().getSession(false).getAttribute("SessionObject");

    public List<CourseBean> loadCourse(CourseBean inputBean, int max, int first, String orderBy) throws Exception {

        List<CourseBean> dataList = new ArrayList<CourseBean>();
        Session session = null;

        try {
            long count = 0;
            session = (Session) HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sqlCount = "select count(id) from Course s where s.courseDescription LIKE :courseDescription";
            Query queryCount = session.createQuery(sqlCount);
            queryCount.setString("courseDescription", "%"+inputBean.getSearchname()+"%");
            Iterator itCount = queryCount.iterate();
            count = (Long) itCount.next();
            if (count > 0) {
                String sqlSearch = "from Course s where s.courseDescription LIKE :courseDescription";
                Query querySearch = session.createQuery(sqlSearch);
//                querySearch.setParameter("courseDescription", "%" + inputBean.getSearchname() + "%");
                querySearch.setString("courseDescription", "%"+inputBean.getSearchname()+"%");

                querySearch.setMaxResults(max);
                querySearch.setFirstResult(first);

                Iterator it = querySearch.iterate();
                while (it.hasNext()) {
                    CourseBean databean = new CourseBean();
                    Course objBean = (Course) it.next();

                    try {
                        databean.setCourseID(objBean.getId().toString());
                    } catch (NullPointerException e) {
                        databean.setCourseID("--");
                    }
                    try {
                        databean.setCourseDescription(objBean.getCourseDescription());
                    } catch (NullPointerException e) {
                        databean.setCourseDescription("--");
                    }
                    try {
                        if(objBean.getClassType() == 1){
                            databean.setClassType("Theory Class");
                        }else if(objBean.getClassType() == 2){
                             databean.setClassType("Revision Class");
                        }else if(objBean.getClassType() == 3){
                             databean.setClassType("Paper Class");
                        }
                        
                    } catch (NullPointerException e) {
                        databean.setClassType("--");
                    }
                    try {
                        if(objBean.getMedium() == 1){
                            databean.setMedium("Sinhala");
                        }else if(objBean.getMedium() == 2){
                             databean.setMedium("English");
                        }else if(objBean.getMedium() == 3){
                             databean.setMedium("Tamil");
                        }
                        
                    } catch (NullPointerException e) {
                        databean.setMedium("--");
                    }
                    try {
                        databean.setSubject(objBean.getSubjectId().getSubjectName());
                    } catch (NullPointerException e) {
                        databean.setSubject("--");
                    }
                    try {
                        databean.setLecturer(objBean.getLectureId().getName());
                    } catch (NullPointerException e) {
                        databean.setSubject("--");
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
                session.flush();
                session.clear();
                session.getTransaction().commit();
                session.close();
                session = null;
            }
        }
        return dataList;

    }

    public boolean addCourse(CourseBean bean) throws Exception {
        boolean isAddCor = false;
        Course cor = null;
        Session session = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            cor = new Course();

            cor.setBatchNo(Integer.parseInt(bean.getAddbatchNo()));
            cor.setClassType(Integer.parseInt(bean.getAddclassType()));
            cor.setCourseDescription(bean.getAddcourseDescription());
            cor.setGrade(Integer.parseInt(bean.getAddgrade()));
            cor.setMedium(Integer.parseInt(bean.getAddconductingMedium()));
            Lecturer l = new Lecturer();
            l.setId(Integer.parseInt(bean.getAddlecturer()));
            cor.setLectureId(l);
            Subject s = new Subject();
            s.setSubjectId(Integer.parseInt(bean.getAddsubject()));
            cor.setSubjectId(s);
            cor.setLecHallId(Integer.parseInt(bean.getAddlectureHall()));
            cor.setLecPaymentPercentage(Double.parseDouble(bean.getAddlecturerPayment()));
            
            try {
                cor.setTotalCourseFee(Double.parseDouble(bean.getAddtotalCoursefee()));
            } catch (Exception e) {
                cor.setTotalCourseFee(0.0);
            }
            try {
              cor.setCourseDuration(bean.getAddcourseDuration());  
            } catch (Exception e) {
                cor.setCourseDuration("");
            }
            try {
                cor.setMonthlyFee(Double.parseDouble(bean.getAddmonthlyFee()));
            } catch (Exception e) {
                cor.setMonthlyFee(0.0);
            }
            session.save(cor);

            isAddCor = true;
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
                session.flush();
                session.close();
                session = null;
            }
        }
        return isAddCor;
    }

    public boolean addCourseDates(CourseBean bean) throws Exception {
        boolean isAddCor = false;
        CourseDates cor = null;
        Session session = null;
        Integer id = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            Criteria criteria = session
                    .createCriteria(Course.class)
                    .setProjection(Projections.max("id"));
            id = (Integer) criteria.uniqueResult();

            System.out.println("max course id " + id);
            
            cor = new CourseDates();
            Course c = new Course();
            c.setId(id);
            cor.setCourseId(c);
            try {
                cor.setMonday(bean.getStarttimeM() +"-"+ bean.getEndtimeM());
            } catch (NullPointerException e) {
                cor.setMonday("-");
            }
            try {
                cor.setTueday(bean.getStarttimeTu() +"-"+ bean.getEndtimeTu());
            } catch (NullPointerException e) {
                cor.setTueday("-");
            }
            try {
                cor.setWedday(bean.getStarttimeW() +"-"+ bean.getEndtimeW());
            } catch (NullPointerException e) {
                cor.setWedday("-");
            }
            try {
                cor.setThurday(bean.getStarttimeTh() +"-"+ bean.getEndtimeTh());
            } catch (NullPointerException e) {
                cor.setThurday("-");
            }
            try {
                cor.setFriday(bean.getStarttimeF() +"-"+ bean.getEndtimeF());
            } catch (NullPointerException e) {
                cor.setFriday("-");
            }
            try {
                cor.setSatday(bean.getStarttimeSa() +"-"+ bean.getEndtimeSa());
            } catch (NullPointerException e) {
                cor.setSatday("-");
            }
            try {
                cor.setSunday(bean.getStarttimeSu() +"-"+ bean.getEndtimeSu());
            } catch (NullPointerException e) {
                cor.setSunday("-");
            }

            session.save(cor);

            isAddCor = true;
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                deleteCourse(id);// delete course 
                session.close();
                session = null;
            }
            throw e;
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.flush();
                session.close();
                session = null;
            }
        }
        return isAddCor;
    }

    public void deleteCourse(Integer id) throws Exception {
        Session session = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            Course c = (Course) session.createCriteria(Course.class)
                    .add(Restrictions.eq("id", id)).uniqueResult();
            session.delete(c);
            System.out.println("delete sucess");

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
                session.flush();
                session.close();
                session = null;
            }
        }
    }

    public void getlecList(CourseBean inputbean) throws Exception {
        List<Lecturer> lec = null;
        Session session = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from Lecturer";
            Query query = session.createQuery(sql);
            lec = query.list();

            for (int i = 0; i < lec.size(); i++) {
//                System.out.println(school.get(0));
                inputbean.getLecList().put(lec.get(i).getId(), lec.get(i).getName());
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

    public void getsubList(CourseBean inputbean) throws Exception {
        List<Subject> sub = null;
        Session session = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from Subject";
            Query query = session.createQuery(sql);
            sub = query.list();

            for (int i = 0; i < sub.size(); i++) {
//                System.out.println(school.get(0));
                inputbean.getSubList().put(sub.get(i).getSubjectId(), sub.get(i).getSubjectName());
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
    
   public void findCourse(CourseBean inputbean, String id) throws Exception {

        Session session = HibernateInit.getSessionFactory().openSession();

        try {
            session.beginTransaction();

            Iterator it = session.createCriteria(Course.class, "course")
                    .createAlias("course.lectureId", "lecid")
                    .createAlias("course.subjectId", "subid")
                    .add(Restrictions.eq("course.id", Integer.parseInt(id)))
                    .list()
                    .iterator();

            while (it.hasNext()) {
                Course ac = (Course) it.next();

               inputbean.setUpcourseid(ac.getId().toString());
               inputbean.setUpbatchNo(ac.getBatchNo().toString());
//               inputbean.setUpclassDays(ac.get);
               inputbean.setUpclassType(ac.getClassType().toString());
               inputbean.setUpconductingMedium(ac.getMedium().toString());
               inputbean.setUpcourseDescription(ac.getCourseDescription());
               inputbean.setUpgrade(ac.getGrade().toString());
               inputbean.setUplectureHall(ac.getLecHallId().toString());
               inputbean.setUplecturer(ac.getLectureId().getId().toString());
               inputbean.setUplecturerPayment(ac.getLecPaymentPercentage().toString());
               inputbean.setUpmonthlyFee(ac.getMonthlyFee().toString());
               inputbean.setUpsubject(ac.getSubjectId().getSubjectId().toString());
               inputbean.setUptotalCoursefee(ac.getTotalCourseFee().toString());

            }
            Iterator it1 = session.createCriteria(CourseDates.class, "coursed")
                    .createAlias("coursed.courseId", "courseId")
                    .add(Restrictions.eq("courseId.id", Integer.parseInt(id)))
                    .list()
                    .iterator();
             while (it1.hasNext()) {
                CourseDates courseDates = (CourseDates) it1.next();
                
                 System.out.println("--------------1 "+courseDates.getMonday());
                 System.out.println("--------------2 "+courseDates.getTueday());
                
                if(!courseDates.getMonday().isEmpty()){
                     String arr[] = courseDates.getMonday().split("-");
                     try {
                        inputbean.setUpstarttimeM(arr[0]);
                        inputbean.setUpendtimeM(arr[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        inputbean.setUpstarttimeM(courseDates.getMonday());
                        inputbean.setUpendtimeM(courseDates.getMonday());
                    }
                }
                if(!courseDates.getTueday().isEmpty()){
                     String arr[] = courseDates.getTueday().split("-");
                     try {
                        inputbean.setUpstarttimeTu(arr[0]);
                        inputbean.setUpendtimeTu(arr[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                      inputbean.setUpstarttimeTu(courseDates.getTueday());
                      inputbean.setUpendtimeTu(courseDates.getTueday());  
                    }
                }
                if(!courseDates.getWedday().isEmpty()){
                     String arr[] = courseDates.getWedday().split("-");
                     try {
                         inputbean.setUpstarttimeW(arr[0]);
                         inputbean.setUpendtimeW(arr[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                         inputbean.setUpstarttimeW(courseDates.getWedday());
                         inputbean.setUpendtimeW(courseDates.getWedday());
                    }
                 }
                 if(!courseDates.getThurday().isEmpty()){
                     String arr[] = courseDates.getThurday().split("-");
                     try {
                         inputbean.setUpstarttimeTh(arr[0]);
                         inputbean.setUpendtimeTh(arr[1]);
                     } catch (ArrayIndexOutOfBoundsException e) {
                         inputbean.setUpstarttimeTh(courseDates.getThurday());
                         inputbean.setUpendtimeTh(courseDates.getThurday());
                     }
                 }
                 if(!courseDates.getFriday().isEmpty()){
                     String arr[] = courseDates.getFriday().split("-");
                     try {
                        inputbean.setUpstarttimeF(arr[0]);
                        inputbean.setUpendtimeF(arr[1]); 
                     } catch (ArrayIndexOutOfBoundsException e) {
                         inputbean.setUpstarttimeF(courseDates.getFriday());
                         inputbean.setUpendtimeF(courseDates.getFriday());
                     }
                 }
                 if(!courseDates.getSatday().isEmpty()){
                     String arr[] = courseDates.getSatday().split("-");
                     try {
                         inputbean.setUpstarttimeSa(arr[0]);
                         inputbean.setUpendtimeSa(arr[1]);
                     } catch (ArrayIndexOutOfBoundsException e) {
                         inputbean.setUpstarttimeSa(courseDates.getSatday());
                         inputbean.setUpendtimeSa(courseDates.getSatday());
                     }
                 }
                 if(!courseDates.getSunday().isEmpty()){
                     String arr[] = courseDates.getSunday().split("-");
                     try {
                         inputbean.setUpstarttimeSu(arr[0]);
                         inputbean.setUpendtimeSu(arr[1]);
                     } catch (ArrayIndexOutOfBoundsException e) {
                         inputbean.setUpstarttimeSu(courseDates.getSunday());
                         inputbean.setUpendtimeSu(courseDates.getSunday());
                     }
                 }
                 
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
                if (!session.getTransaction().wasCommitted()) {
                    session.getTransaction().commit();
                }

                session.flush();
                session.close();
                session = null;
            }
        }
    }
   public boolean updateCourse(CourseBean inputbean) throws Exception {

        Session session = HibernateInit.getSessionFactory().openSession();
        boolean ok = false;
        try {
            session.beginTransaction();
            Course course = (Course) session
                    .createCriteria(Course.class)
                    .add(Restrictions.eq("id", Integer.parseInt(inputbean.getUpcourseid())))
                    .uniqueResult();
            
            CourseDates cd = (CourseDates) session
                    .createCriteria(CourseDates.class, "courDate")
                    .createAlias("courDate.courseId", "courseId")
                    .add(Restrictions.eq("courseId.id", Integer.parseInt(inputbean.getUpcourseid())))
                    .uniqueResult();
            if (course != null) {

                course.setBatchNo(Integer.parseInt(inputbean.getUpbatchNo()));
                course.setClassType(Integer.parseInt(inputbean.getUpclassType()));
                course.setCourseDescription(inputbean.getUpcourseDescription());
//                course.setCourseDuration(inputbean.getUpcourseDuration());
                course.setGrade(Integer.parseInt(inputbean.getUpgrade()));
                course.setLecHallId(Integer.parseInt(inputbean.getUplectureHall()));
                course.setLecPaymentPercentage(Double.parseDouble(inputbean.getUplecturerPayment()));
                
                Lecturer l = new Lecturer();
                l.setId(Integer.parseInt(inputbean.getUplecturer()));
                course.setLectureId(l);
                
                course.setMedium(Integer.parseInt(inputbean.getUpconductingMedium()));
                course.setMonthlyFee(Double.parseDouble(inputbean.getUpmonthlyFee()));
                
                Subject s = new Subject();
                s.setSubjectId(Integer.parseInt(inputbean.getUpsubject()));
                course.setSubjectId(s);
                
//                course.setTotalCourseFee(Double.parseDouble(inputbean.getUptotalCoursefee()));


                session.update(course);
                ok = true;
            }
            
            if(cd != null){
                try {
                    if(!inputbean.getUpstarttimeM().equals("-") || !inputbean.getUpendtimeM().equals("-")){
                        cd.setMonday(inputbean.getUpstarttimeM() +"-"+ inputbean.getUpendtimeM());
                    }
                } catch (Exception e) {
                    cd.setMonday("-");
                }
                try {
                    if(!inputbean.getUpstarttimeTu().equals("-") || !inputbean.getUpendtimeTu().equals("-")){
                        cd.setTueday(inputbean.getUpstarttimeTu() +"-"+ inputbean.getUpendtimeTu());
                    }
                } catch (Exception e) {
                    cd.setTueday("-");
                }
                try {
                    if(!inputbean.getUpstarttimeW().equals("-") || !inputbean.getUpendtimeW().equals("-")){
                        cd.setWedday(inputbean.getUpstarttimeW() +"-"+ inputbean.getUpendtimeW());
                    }
                } catch (Exception e) {
                    cd.setWedday("-");
                }
                try {
                    if(!inputbean.getUpstarttimeTh().equals("-") || !inputbean.getUpendtimeTh().equals("-")){
                        cd.setThurday(inputbean.getUpstarttimeTh() +"-"+ inputbean.getUpendtimeTh());
                    }
                } catch (Exception e) {
                    cd.setThurday("-");
                }
                try {
                    if(!inputbean.getUpstarttimeF().equals("-") || !inputbean.getUpendtimeF().equals("-")){
                        cd.setFriday(inputbean.getUpstarttimeF() +"-"+ inputbean.getUpendtimeF());
                    }
                } catch (Exception e) {
                    cd.setFriday("-");
                }
                try {
                    if(!inputbean.getUpstarttimeSa().equals("-") || !inputbean.getUpendtimeSa().equals("-")){
                        cd.setSatday(inputbean.getUpstarttimeSa() +"-"+ inputbean.getUpendtimeSa());
                    }
                } catch (Exception e) {
                    cd.setSatday("-");
                }
                try {
                    if(!inputbean.getUpstarttimeSu().equals("-") || !inputbean.getUpendtimeSu().equals("-")){
                        cd.setSunday(inputbean.getUpstarttimeSu() +"-"+ inputbean.getUpendtimeSu());
                    }
                } catch (Exception e) {
                    cd.setSunday("-");
                }
                session.update(cd);
                ok = true;
            }
            
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session = null;
            }
            ok = false;
            throw e;
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.flush();
                session.close();
                session = null;
            }
        }
        return ok;
    }
   public List<CourseBean> loadStopCourse(CourseBean inputBean, int max, int first, String orderBy) throws Exception {

        List<CourseBean> dataList = new ArrayList<CourseBean>();
        Session session = null;

        try {
            long count = 0;
            session = (Session) HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sqlCount = "select count(id) from CourseDates";
            Query queryCount = session.createQuery(sqlCount);
            Iterator itCount = queryCount.iterate();
            count = (Long) itCount.next();
            if (count > 0) {
                String sqlSearch = "from CourseDates ";
                Query querySearch = session.createQuery(sqlSearch);
                querySearch.setMaxResults(max);
                querySearch.setFirstResult(first);

                Iterator it = querySearch.iterate();
                while (it.hasNext()) {
                    CourseBean databean = new CourseBean();
                    CourseDates objBean = (CourseDates) it.next();

                    try {
                        databean.setId(objBean.getId().toString());
                    } catch (NullPointerException e) {
                        databean.setCourseID("--");
                    }
                    try {
                        databean.setStopcourseDescription(objBean.getCourseId().getCourseDescription());
                    } catch (NullPointerException e) {
                        databean.setStopcourseDescription("--");
                    }
                    try {
                        databean.setMonday(objBean.getMonday());
                    } catch (NullPointerException e) {
                        databean.setMonday("--");
                    }
                    try {
                        databean.setTueday(objBean.getTueday());
                    } catch (NullPointerException e) {
                        databean.setTueday("--");
                    }
                    try {
                        databean.setWedday(objBean.getWedday());
                    } catch (NullPointerException e) {
                        databean.setWedday("--");
                    }
                    try {
                        databean.setThurday(objBean.getThurday());
                    } catch (NullPointerException e) {
                        databean.setThurday("--");
                    }
                    try {
                        databean.setFriday(objBean.getFriday());
                    } catch (NullPointerException e) {
                        databean.setFriday("--");
                    }
                    try {
                        databean.setSatday(objBean.getSatday());
                    } catch (NullPointerException e) {
                        databean.setSatday("--");
                    }
                    try {
                        databean.setSunday(objBean.getSunday());
                    } catch (NullPointerException e) {
                        databean.setSunday("--");
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
                session.flush();
                session.clear();
                session.getTransaction().commit();
                session.close();
                session = null;
            }
        }
        return dataList;

    }
    public boolean addextraclz(CourseBean bean) throws Exception {
        boolean isAddCor = false;
        ExtraClasses extraClasses = null;
        Session session = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int c_id= (int) sess.getAttribute("extraclass");
            
            extraClasses = new ExtraClasses();
            
            Course c = new Course();
            c.setId(c_id);
            extraClasses.setCourseId(c);
            extraClasses.setDate(bean.getExtraDate());
            extraClasses.setStartTime(bean.getExtraStartTime());
            extraClasses.setEndTime(bean.getExtraEndTime());
            extraClasses.setStatus("ACT");

            session.save(extraClasses);

            isAddCor = true;
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
                session.flush();
                session.close();
                session = null;
            }
        }
        return isAddCor;
    }
    public List<CourseBean> loadexclz(CourseBean inputBean, int max, int first, String orderBy) throws Exception {

        List<CourseBean> dataList = new ArrayList<CourseBean>();
        Session session = null;

        try {
            long count = 0;
            session = (Session) HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sqlCount = "select count(id) from ExtraClasses";
            Query queryCount = session.createQuery(sqlCount);
            Iterator itCount = queryCount.iterate();
            count = (Long) itCount.next();
            if (count > 0) {
                String sqlSearch = "from ExtraClasses ";
                Query querySearch = session.createQuery(sqlSearch);
                querySearch.setMaxResults(max);
                querySearch.setFirstResult(first);

                Iterator it = querySearch.iterate();
                while (it.hasNext()) {
                    CourseBean databean = new CourseBean();
                    ExtraClasses objBean = (ExtraClasses) it.next();

                    try {
                        databean.setExid(objBean.getId().toString());
                    } catch (NullPointerException e) {
                        databean.setExid("--");
                    }
                    try {
                        databean.setCourseId(objBean.getCourseId().getCourseDescription());
                    } catch (NullPointerException e) {
                        databean.setCourseId("--");
                    }
                    try {
                        databean.setDate(objBean.getDate());
                    } catch (NullPointerException e) {
                        databean.setDate("--");
                    }
                    try {
                        databean.setStartTime(objBean.getStartTime());
                    } catch (NullPointerException e) {
                        databean.setStartTime("--");
                    }
                    try {
                        databean.setEndTime(objBean.getEndTime());
                    } catch (NullPointerException e) {
                        databean.setEndTime("--");
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
    public boolean DeleteexClz(CourseBean bean) throws Exception {
        boolean ok = false;

        Session session = HibernateInit.getSessionFactory().openSession();
        try {

            session.beginTransaction();
            ExtraClasses at = (ExtraClasses) session.createCriteria(ExtraClasses.class)
                    .add(Restrictions.eq("id", Integer.parseInt(bean.getExid())))
                    .uniqueResult();

            if (at != null) {
                session.delete(at);

                ok = true;
            }

        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session = null;
            }
            throw ex;
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.flush();
                session.close();
                session = null;
            }
        }

        return ok;

    }
    public boolean checkdublicateDes(CourseBean inputbean){
        boolean ok = false;

        Session session = HibernateInit.getSessionFactory().openSession();
        try {

            session.beginTransaction();
            Course at = (Course) session.createCriteria(Course.class)
                    .add(Restrictions.eq("courseDescription", inputbean.getAddcourseDescription()))
                    .uniqueResult();

            if (at != null) {
                ok = true;
            }

        } catch (Exception ex) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session = null;
            }
            throw ex;
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.flush();
                session.close();
                session = null;
            }
        }

        return ok;
    }
}

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
import login.bean.SessionBean;
import mapping.Course;
import mapping.Lecturer;
import mapping.Subject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;

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

            String sqlCount = "select count(id) from Course";
            Query queryCount = session.createQuery(sqlCount);
            Iterator itCount = queryCount.iterate();
            count = (Long) itCount.next();
            if (count > 0) {
                String sqlSearch = "from Course ";
                Query querySearch = session.createQuery(sqlSearch);
//                querySearch.setParameter("courseDescription", "%" + inputBean.getSearchname() + "%");

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
                        databean.setClassType(objBean.getClassType()+"");
                    } catch (NullPointerException e) {
                        databean.setClassType("--");
                    }
                    try {
                        databean.setMedium(""+objBean.getMedium());
                    } catch (NullPointerException e) {
                        databean.setMedium("--");
                    }
                    try {
                        databean.setSubject(""+objBean.getSubjectId());
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
            
            System.out.println("ff "+bean.getAddtotalCoursefee());
            
            
            if(bean.getAddtotalCoursefee() != null | !bean.getAddtotalCoursefee().isEmpty()){
                cor.setTotalCourseFee(Double.parseDouble(bean.getAddtotalCoursefee()));
            }
            if(bean.getAddcourseDuration()!= null || !bean.getAddcourseDuration().isEmpty()){
                cor.setCourseDuration(bean.getAddcourseDuration());
            }
            if(bean.getAddmonthlyFee()!= null){
                cor.setMonthlyFee(Double.parseDouble(bean.getAddmonthlyFee()));
            }
            
//            
            
            
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
     public void getlecList(CourseBean inputbean) throws Exception{
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
        }finally {
            if (session != null) {
                session.getTransaction().commit();
                session.close();
                session = null;
            }
        }
         
    }
     public void getsubList(CourseBean inputbean) throws Exception{
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
        }finally {
            if (session != null) {
                session.getTransaction().commit();
                session.close();
                session = null;
            }
        }
         
    }
}

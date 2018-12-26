/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.service;

import Util.HibernateInit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import login.bean.SessionBean;
import mapping.Course;
import mapping.School;
import mapping.Student;
import mapping.StudentCourse;
import mapping.Subject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jfree.chart.axis.SubCategoryAxis;
import student.bean.StudentBean;

/**
 *
 * @author ridmi_g
 */
public class StudentService {

    SessionBean sub = (SessionBean) ServletActionContext.getRequest().getSession(false).getAttribute("SessionObject");

    public List<StudentBean> loadStudent(StudentBean inputBean, int max, int first, String orderBy) throws Exception {
        List<StudentBean> dataList = new ArrayList<StudentBean>();
        Session session = null;

        try {
            long count = 0;
            session = (Session) HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sqlCount = "select count(sName) from Student";
            Query queryCount = session.createQuery(sqlCount);
            Iterator itCount = queryCount.iterate();
            count = (Long) itCount.next();
            if (count > 0) {
                String sqlSearch = "from Student ";
                Query querySearch = session.createQuery(sqlSearch);

                querySearch.setMaxResults(max);
                querySearch.setFirstResult(first);

                Iterator it = querySearch.iterate();
                while (it.hasNext()) {
                    StudentBean databean = new StudentBean();
                    Student objBean = (Student) it.next();

                    try {
                        databean.setsId(objBean.getSId().toString());
                    } catch (NullPointerException e) {
                        databean.setsId("--");
                    }
                    try {
                        databean.setCardNumber(objBean.getCardNumber());
                    } catch (NullPointerException e) {
                        databean.setCardNumber("--");
                    }
                    try {
                        databean.setsYor(objBean.getSYor());
                    } catch (NullPointerException e) {
                        databean.setsYor("--");
                    }
                    try {
                        databean.setsTelephone(objBean.getSTelephone());
                    } catch (NullPointerException e) {
                        databean.setsTelephone("--");
                    }
                    try {
                        databean.setsSchool(objBean.getSSchool().getSchool());
                    } catch (NullPointerException e) {
                        databean.setsSchool("--");
                    }
                    try {
                        databean.setsParentName(objBean.getSParentName());
                    } catch (NullPointerException e) {
                        databean.setsParentName("--");
                    }
                    try {
                        databean.setsParentEmail(objBean.getSParentEmail());
                    } catch (NullPointerException e) {
                        databean.setsParentEmail("--");
                    }
                    try {
                        databean.setsParentContactNo(objBean.getSParentContactNo());
                    } catch (NullPointerException e) {
                        databean.setsParentContactNo("--");
                    }
                    try {
                        databean.setsNic(objBean.getSNic());
                    } catch (NullPointerException e) {
                        databean.setsNic("--");
                    }
                    try {
                        databean.setsName(objBean.getSName());
                    } catch (NullPointerException e) {
                        databean.setsName("--");
                    }
                    try {
                        databean.setsImage(objBean.getSImage());
                    } catch (NullPointerException e) {
//                      databean.setsName("--");
                    }
                    try {
                        if(objBean.getSGender().equals("1")){
                            databean.setsGender("Male");
                        }else if(objBean.getSGender().equals("2")){
                            databean.setsGender("Female");
                        }
                        
                    } catch (NullPointerException e) {
                        databean.setsGender("--");
                    }
                    try {
                        databean.setsFirstname(objBean.getSFirstname());
                    } catch (NullPointerException e) {
                        databean.setsFirstname("--");
                    }
                    try {
                        databean.setsEmail(objBean.getSEmail());
                    } catch (NullPointerException e) {
                        databean.setsEmail("--");
                    }
                    try {
                        databean.setsDob(objBean.getSDob());
                    } catch (NullPointerException e) {
                        databean.setsDob("--");
                    }
                    try {
                        databean.setsAddress(objBean.getSAddress());
                    } catch (NullPointerException e) {
                        databean.setsAddress("--");
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
    public List<StudentBean> loadStudentcr(StudentBean inputBean, int max, int first, String orderBy) throws Exception {
        List<StudentBean> dataList = new ArrayList<StudentBean>();
        Session session = null;

        try {
            long count = 0;
            session = (Session) HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sqlCount = "select count(id) from StudentCourse";
            Query queryCount = session.createQuery(sqlCount);
            Iterator itCount = queryCount.iterate();
            count = (Long) itCount.next();
            if (count > 0) {
                String sqlSearch = "from StudentCourse ";
                Query querySearch = session.createQuery(sqlSearch);

                querySearch.setMaxResults(max);
                querySearch.setFirstResult(first);

                Iterator it = querySearch.iterate();
                while (it.hasNext()) {
                    StudentBean databean = new StudentBean();
                    StudentCourse objBean = (StudentCourse) it.next();

                    try {
                        databean.setS_c_id(objBean.getId().toString());
                    } catch (NullPointerException e) {
                        databean.setS_c_id("--");
                    }
                    try {
                        databean.setS_c_courseId(objBean.getCourseId().getCourseDescription());
                    } catch (NullPointerException e) {
                        databean.setS_c_courseId("--");
                    }
                    try {
                         if(objBean.getCardType() == 1){
                            databean.setS_c_cardType("Normal");
                        }else if(objBean.getCardType() == 2){
                            databean.setS_c_cardType("Half");
                        }else if(objBean.getCardType() == 3){
                            databean.setS_c_cardType("Free");
                        }
                    } catch (NullPointerException e) {
                        databean.setS_c_cardType("--");
                    }
                    try {
                        databean.setS_c_status(objBean.getStatus());
                    } catch (NullPointerException e) {
                        databean.setS_c_status("--");
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

    public boolean addStudent(StudentBean bean) throws Exception {
        boolean isAddStudent = false;
        Student student = null;
        Session session = null;
        List<School> school = null;
        String schoolName = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            
            student = new Student();

            student.setCardNumber(bean.getCardno());
            student.setSAddress(bean.getAddress());
            student.setSDob(bean.getBirthday());
            student.setSEmail(bean.getEmail());
            student.setSFirstname(bean.getFirstname());
            student.setSGender(bean.getGender());
            student.setSYor(bean.getYearOfRegistration());
            student.setSName(bean.getName());
            student.setSParentContactNo(bean.getParentContactNo());
            
            School s = new School();
            s.setSchoolId(Integer.parseInt(bean.getSchool()));
            student.setSSchool(s);
            student.setSTelephone(bean.getTelephone());

            
            session.save(student);
           
            isAddStudent = true;
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
        return isAddStudent;
    }

    public void findstudent(StudentBean inputBean) throws Exception {

        List<Student> studentlist = null;
        Session session = null;

        try {
            
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            String sql = "from Student wu where wu.sId =:sId";
            Query query = session.createQuery(sql);
            query.setInteger("sId", Integer.parseInt(inputBean.getId()));
            studentlist = query.list();

            if (0 < studentlist.size()) {
                
               
                inputBean.setUpname(studentlist.get(0).getSName());
                inputBean.setUpaddress(studentlist.get(0).getSAddress());
                inputBean.setUpbirthday(studentlist.get(0).getSDob());
                inputBean.setUpcardno(studentlist.get(0).getCardNumber());
                inputBean.setUpemail(studentlist.get(0).getSEmail());
                inputBean.setUpfirstname(studentlist.get(0).getSFirstname());
                inputBean.setUpgender(studentlist.get(0).getSGender());
                inputBean.setUpparentContactNo(studentlist.get(0).getSParentContactNo());
                inputBean.setUpschool(studentlist.get(0).getSSchool().getSchoolId().toString());
                inputBean.setUptelephone(studentlist.get(0).getSTelephone());
                inputBean.setUpyearOfRegistration(studentlist.get(0).getSYor());
                inputBean.setUpId(studentlist.get(0).getSId().toString());

            }
          

        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
                session.close();
                session = null;
            }
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.getTransaction().commit();
                session.close();
                session = null;
            }
        }
    }

    public boolean updateStudent(StudentBean inputBean) throws Exception {
        boolean isUpdated = false;
        Session session = null;
        Query query = null;
        List<Student> student = null;
        List<School> school = null;
        String schoolName = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
//             String sql1 ="from School sc where sc.schoolId =:schoolId";
//            Query query1 = session.createQuery(sql1);
//            query1.setString("schoolId", inputBean.getUpschool());
//            school = query1.list();
//             if (0 < school.size()) {
//                  schoolName = school.get(0).getSchool();
//                }
//            
            
            String sql = "from Student wu where wu.sId =:sId";
            query = session.createQuery(sql);
            query.setInteger("sId", Integer.parseInt(inputBean.getUpId()));
            student = query.list();
            if (student.size() > 0) {
                student.get(0).setCardNumber(inputBean.getUpcardno());
                student.get(0).setSAddress(inputBean.getUpaddress());
                student.get(0).setSDob(inputBean.getUpbirthday());
                student.get(0).setSEmail(inputBean.getUpemail());
                student.get(0).setSFirstname(inputBean.getUpfirstname());
                student.get(0).setSGender(inputBean.getUpgender());
                student.get(0).setSName(inputBean.getUpname());
                student.get(0).setSParentContactNo(inputBean.getUpparentContactNo());
                
                School s = new School();
                s.setSchoolId(Integer.parseInt(inputBean.getUpschool()));
                student.get(0).setSSchool(s);
                student.get(0).setSTelephone(inputBean.getUptelephone());
                student.get(0).setSYor(inputBean.getUpyearOfRegistration());

                session.save(student.get(0));
                session.getTransaction().commit();
                isUpdated = true;
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
                session.flush();
                session.close();
                session = null;
            }
        }
        return isUpdated;
    }
    
     public void getSchoolList(StudentBean inputbean) throws Exception{
         List<School> school = null;
         Session session = null;
         
         try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from School";
            Query query = session.createQuery(sql);
            school = query.list();
            
            for (int i = 0; i < school.size(); i++) {
//                System.out.println(school.get(0));
                inputbean.getSchoolList().put(school.get(i).getSchoolId(), school.get(i).getSchool());
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
     public void getsubList(StudentBean inputbean) throws Exception{
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
     public void getCorList(StudentBean inputbean) throws Exception{
         List<Course> cr = null;
         Session session = null;
         
         try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from Course";
            Query query = session.createQuery(sql);
            cr = query.list();
            
            for (int i = 0; i < cr.size(); i++) {
//                System.out.println(school.get(0));
                inputbean.getCorList().put(cr.get(i).getId(), cr.get(i).getCourseDescription());
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
     public boolean addStudentForCourse(StudentBean bean) throws Exception {
        boolean isAddStudent = false;
        StudentCourse studentCr = null;
        Session session = null;
        List<School> school = null;
        String schoolName = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            
            studentCr = new StudentCourse();

            HttpSession sess = ServletActionContext.getRequest().getSession(false);
            int st_id= (int) sess.getAttribute("assToCourse");
            
            System.out.println("st "+st_id);
            
            Student s1=new Student();
            s1.setSId(st_id);
            studentCr.setStudentId(s1);
            
            Course c = new Course();
            c.setId(Integer.parseInt(bean.getAssCourse()));
            studentCr.setCourseId(c);
            studentCr.setRegistrationDate(new Date());
            studentCr.setCardType(Integer.parseInt(bean.getAsscard_type()));
            studentCr.setStatus("ACT");
          
            session.save(studentCr);
           
            isAddStudent = true;
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
        return isAddStudent;
    }
     public boolean DeleteC(StudentBean bean) throws Exception {
        boolean ok = false;

        Session session = HibernateInit.getSessionFactory().openSession();
        try {

            session.beginTransaction();
            StudentCourse at = (StudentCourse) session.createCriteria(StudentCourse.class)
                    .add(Restrictions.eq("id", Integer.parseInt(bean.getS_c_id())))
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

}

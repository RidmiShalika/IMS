/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.service;

import Util.HibernateInit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import login.bean.SessionBean;
import mapping.School;
import mapping.Student;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
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
                        databean.setsGender(objBean.getSGender());
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

    public boolean addStudent(StudentBean bean) throws Exception {
        boolean isAddStudent = false;
        Student student = null;
        Session session = null;
        List<School> school = null;
        String schoolName = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            String sql ="from School sc where sc.schoolId =:schoolId";
            Query query = session.createQuery(sql);
            query.setString("schoolId", bean.getSchool());
            school = query.list();
             if (0 < school.size()) {
//                 inputbean.setUserRoleId(""+usr.get(0).getUserRoleId());
                   schoolName = school.get(0).getSchool();
                }
            
            student = new Student();

            student.setCardNumber(bean.getCardno());
            student.setSAddress(bean.getAddress());
            student.setSDob(bean.getBirthday());
            student.setSEmail(bean.getEmail());
            student.setSFirstname(bean.getFirstname());
            
            if(bean.getGender().equals("1")){
                  student.setSGender(bean.getGenderlList().get(1));
            }else if(bean.getGender().equals("2")){
                 student.setSGender(bean.getGenderlList().get(2));
            }
//            student.setSGender(bean.getGender());
            student.setSName(bean.getName());
            student.setSParentContactNo(bean.getParentContactNo());
//            student.setSSchool(schoolName);
            student.setSTelephone(bean.getTelephone());
            student.setSYor(bean.getYearOfRegistration());

            
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
            
            String sql = "from Student wu where wu.sName =:name";
            Query query = session.createQuery(sql);
            query.setString("name", inputBean.getUpname());
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
//                inputBean.setUpschool(studentlist.get(0).getSSchool());
                inputBean.setUptelephone(studentlist.get(0).getSTelephone());
                inputBean.setUpyearOfRegistration(studentlist.get(0).getSYor());

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
            
             String sql1 ="from School sc where sc.schoolId =:schoolId";
            Query query1 = session.createQuery(sql1);
            query1.setString("schoolId", inputBean.getUpschool());
            school = query1.list();
             if (0 < school.size()) {
                  schoolName = school.get(0).getSchool();
                }
            
            
            String sql = "from Student wu where wu.sName =:sName";
            query = session.createQuery(sql);
            query.setString("sName", inputBean.getUpname());
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
//                student.get(0).setSSchool(schoolName);
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

}

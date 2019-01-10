/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturer.service;

import Util.HibernateInit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import lecturer.bean.LecturerBean;
import login.bean.SessionBean;
import mapping.Lecturer;
import mapping.School;
import mapping.Subject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import student.bean.StudentBean;

/**
 *
 * @author ridmi_g
 */
public class LecturerService {

    SessionBean sub = (SessionBean) ServletActionContext.getRequest().getSession(false).getAttribute("SessionObject");

    public List<LecturerBean> loadLec(LecturerBean inputBean, int max, int first, String orderBy) throws Exception {

        List<LecturerBean> dataList = new ArrayList<LecturerBean>();
        Session session = null;

        try {
            long count = 0;
            session = (Session) HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            
            if(inputBean.getSearchname() == null){
                inputBean.setSearchname("");
            }

            String sqlCount = "select count(l.name) from Lecturer l where l.name LIKE :name";
            Query queryCount = session.createQuery(sqlCount);
            queryCount.setString("name", "%"+inputBean.getSearchname()+"%");
            Iterator itCount = queryCount.iterate();
            count = (Long) itCount.next();
            if (count > 0) {
                String sqlSearch = "from Lecturer l where l.name LIKE :name";
                Query querySearch = session.createQuery(sqlSearch);
                querySearch.setString("name", "%"+inputBean.getSearchname()+"%");

                querySearch.setMaxResults(max);
                querySearch.setFirstResult(first);

                Iterator it = querySearch.iterate();
                while (it.hasNext()) {
                    LecturerBean databean = new LecturerBean();
                    Lecturer objBean = (Lecturer) it.next();

                    try {
                        databean.setID(objBean.getId().toString());
                    } catch (NullPointerException e) {
                        databean.setID("--");
                    }
                    try {
                        databean.setName(objBean.getName());
                    } catch (NullPointerException e) {
                        databean.setName("--");
                    }
                    try {
                        databean.setNic(objBean.getNic());
                    } catch (NullPointerException e) {
                        databean.setNic("--");
                    }
                    try {
                        databean.setRegDate("" + objBean.getRegDate());
                    } catch (NullPointerException e) {
                        databean.setRegDate("--");
                    }
                    try {
                        databean.setAddress(objBean.getAddress());
                    } catch (NullPointerException e) {
                        databean.setAddress("--");
                    }
                    try {
                        databean.setContact(objBean.getContact());
                    } catch (NullPointerException e) {
                        databean.setContact("--");
                    }
                    try {
                        databean.setEmail(objBean.getEmail());
                    } catch (NullPointerException e) {
                        databean.setEmail("--");
                    }
                    try {
                        databean.setFirstname(objBean.getFirstName());
                    } catch (NullPointerException e) {
                        databean.setFirstname("--");
                    }
                    try {
                        if(objBean.getGender() == 1){
                            databean.setGender("Male");
                        }else if(objBean.getGender() == 2){
                            databean.setGender("Female");
                        }
//                        databean.setGender(objBean.getGender()+"");
                    } catch (NullPointerException e) {
                        databean.setGender("--");
                    }
                 
                    try {
                        if(objBean.getTitle() == 1){
                             databean.setTitle("Mr");
                        }else if(objBean.getTitle() == 2){
                             databean.setTitle("Mrs");
                        }else if(objBean.getTitle() == 3){
                             databean.setTitle("Miss");
                        }else if(objBean.getTitle() == 4){
                             databean.setTitle("Rev");
                        }
                       
                    } catch (NullPointerException e) {
                        databean.setTitle("--");
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
                session.getTransaction().commit();
                session.flush();
                session.clear();
                session.close();
                session = null;
            }
        }
        return dataList;

    }

    public boolean addStudent(LecturerBean bean) throws Exception {
        boolean isAddLec = false;
        Lecturer lec = null;
        Session session = null;
        List<Subject> sub = null;
        String subCode = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            

            lec = new Lecturer();

        
            lec.setAddress(bean.getAddaddress());
            lec.setContact(bean.getAddcontact());
            lec.setEmail(bean.getAddemail());
            lec.setFirstName(bean.getAddfirstname());
            lec.setGender(Integer.parseInt(bean.getAddgender()));
            lec.setName(bean.getAddfullname());
            lec.setNic(bean.getAddnic());
            lec.setTitle(Integer.parseInt(bean.getAddtitle()) );
            lec.setRegDate(new Date());

            session.save(lec);

            isAddLec = true;
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
        return isAddLec;
    }

    public void findLec(LecturerBean inputBean) throws Exception {

        List<Lecturer> lecturerlist = null;
        Session session = null;
        List<Subject> sub = null;
        String subCode = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from Lecturer wu where wu.id =:id";
            Query query = session.createQuery(sql);
            query.setString("id", inputBean.getID());
            lecturerlist = query.list();

            if (0 < lecturerlist.size()) {

              

                inputBean.setUplecid(lecturerlist.get(0).getId().toString());
                inputBean.setUpname(lecturerlist.get(0).getFirstName());
                inputBean.setUpaddress(lecturerlist.get(0).getAddress());
                inputBean.setUpcontact(lecturerlist.get(0).getContact());
                inputBean.setUpemail(lecturerlist.get(0).getEmail());
                inputBean.setUpgender(lecturerlist.get(0).getGender()+"");
                inputBean.setUpnic(lecturerlist.get(0).getNic());
                inputBean.setUptitle(lecturerlist.get(0).getTitle()+"");
                inputBean.setUpfullname(lecturerlist.get(0).getName());

            }
            System.out.println("444444444444444444444 " + inputBean.getUpfullname());

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

    public boolean updateLecturer(LecturerBean inputBean) throws Exception {
        boolean isUpdated = false;
        Session session = null;
        Query query = null;
        List<Lecturer> lec = null;
        List<Subject> sub = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();

            session.beginTransaction();
             System.out.println("name " + inputBean.getUplecid());

            String sql = "from Lecturer wu where wu.id =:id";
            query = session.createQuery(sql);
            query.setString("id", inputBean.getUplecid());
            lec = query.list();
            if (lec.size() > 0) {
                lec.get(0).setAddress(inputBean.getUpaddress());
                lec.get(0).setContact(inputBean.getUpcontact());
                lec.get(0).setEmail(inputBean.getUpemail());
                lec.get(0).setGender(Integer.parseInt(inputBean.getUpgender()));
                lec.get(0).setFirstName(inputBean.getUpname());
                lec.get(0).setNic(inputBean.getUpnic());
                lec.get(0).setTitle(Integer.parseInt(inputBean.getUptitle()));
                lec.get(0).setName(inputBean.getUpfullname());

                session.update(lec.get(0));

                isUpdated = true;
            }
            System.out.println("name " + inputBean.getUpname());
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
        return isUpdated;
    }

    public void getSubjectList(LecturerBean inputbean) throws Exception {
        List<Subject> subject = null;
        Session session = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();

            session.beginTransaction();

            String sql = "from Subject";
            Query query = session.createQuery(sql);
            subject = query.list();

            for (int i = 0; i < subject.size(); i++) {
                inputbean.getSubjectList().put(subject.get(i).getSubjectId(), subject.get(i).getSubjectName());
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

}

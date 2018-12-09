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

            String sqlCount = "select count(name) from Lecturer";
            Query queryCount = session.createQuery(sqlCount);
            Iterator itCount = queryCount.iterate();
            count = (Long) itCount.next();
            if (count > 0) {
                String sqlSearch = "from Lecturer ";
                Query querySearch = session.createQuery(sqlSearch);

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
                        databean.setGender(objBean.getGender());
                    } catch (NullPointerException e) {
                        databean.setGender("--");
                    }
                 
                    try {
                        databean.setTitle(objBean.getTitle());
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

            String sql1 = "from Subject sc where sc.subjectId =:subjectId";
            Query query1 = session.createQuery(sql1);
            query1.setString("subjectId", bean.getAddsubject());
            sub = query1.list();
            if (0 < sub.size()) {
                subCode = sub.get(0).getSubjectCode();
            }

            lec = new Lecturer();

            System.out.println("------------ " + bean.getAddsubject() + ", " + bean.getAddtitle());
            System.out.println("------------ " + subCode);

            if (bean.getAddgender().equals("1")) {
                bean.setAddgender("Male");
            } else if (bean.getAddgender().equals("2")) {
                bean.setAddgender("Female");
            }

            if (bean.getAddtitle().equals("1")) {
                bean.setAddtitle("Mr");
            } else if (bean.getAddtitle().equals("2")) {
                bean.setAddtitle("Mrs");
            } else if (bean.getAddtitle().equals("3")) {
                bean.setAddtitle("Miss");
            } else if (bean.getAddtitle().equals("4")) {
                bean.setAddtitle("Rev");
            }

            lec.setAddress(bean.getAddaddress());
            lec.setContact(bean.getAddcontact());
            lec.setEmail(bean.getAddemail());
            lec.setFirstName(bean.getAddfirstname());
            lec.setGender(bean.getAddgender());
            lec.setName(bean.getAddfullname());
            lec.setNic(bean.getAddnic());
            lec.setTitle(bean.getAddtitle());
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

                if (lecturerlist.get(0).getGender().equals("Male")) {
                    lecturerlist.get(0).setGender("1");
                } else if (lecturerlist.get(0).getGender().equals("Female")) {
                    lecturerlist.get(0).setGender("2");
                }

                
                if (lecturerlist.get(0).getTitle().equals("Mr")) {
                    lecturerlist.get(0).setTitle("1");
                } else if (lecturerlist.get(0).getTitle().equals("Mrs")) {
                    lecturerlist.get(0).setTitle("2");
                } else if (lecturerlist.get(0).getTitle().equals("Miss")) {
                    lecturerlist.get(0).setTitle("3");
                } else if (lecturerlist.get(0).getTitle().equals("Rev")) {
                    lecturerlist.get(0).setTitle("4");
                }

                inputBean.setUplecid(lecturerlist.get(0).getId().toString());
                inputBean.setUpname(lecturerlist.get(0).getName());
                inputBean.setUpaddress(lecturerlist.get(0).getAddress());
                inputBean.setUpcontact(lecturerlist.get(0).getContact());
                inputBean.setUpemail(lecturerlist.get(0).getEmail());
                inputBean.setUpgender(lecturerlist.get(0).getGender());
                inputBean.setUpnic(lecturerlist.get(0).getNic());
                inputBean.setUptitle(lecturerlist.get(0).getTitle());

            }
            System.out.println("444444444444444444444 " + inputBean.getUplecid());

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
                lec.get(0).setGender(inputBean.getUpgender());
                lec.get(0).setName(inputBean.getUpname());
                lec.get(0).setNic(inputBean.getUpnic());
                lec.get(0).setTitle(inputBean.getUptitle());

                session.save(lec.get(0));

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

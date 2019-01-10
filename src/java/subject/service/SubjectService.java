/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subject.service;

import Util.HibernateInit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mapping.Subject;
import org.hibernate.Query;
import org.hibernate.Session;
import subject.bean.SubjectBean;

/**
 *
 * @author ridmi_g
 */
public class SubjectService {

    public List<SubjectBean> loadSubject(SubjectBean inputBean, int max, int first, String orderBy) throws Exception {

        List<SubjectBean> dataList = new ArrayList<SubjectBean>();
        Session session = null;

        try {
            long count = 0;
            
            System.out.println("search name "+inputBean.getSearchname());
            if(inputBean.getSearchname() == null){
                inputBean.setSearchname("");
            }
            
            
            session = (Session) HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sqlCount = "select count(subjectName) from Subject sub where sub.subjectName LIKE :subjectName";
            Query queryCount = session.createQuery(sqlCount);
            queryCount.setString("subjectName", "%" + inputBean.getSearchname() + "%");
      
            Iterator itCount = queryCount.iterate();
            count = (Long) itCount.next();
            if (count > 0) {
//                String sqlSearch = "from Subject";
                String sqlSearch = "from Subject sub where sub.subjectName LIKE :subjectName";
                Query querySearch = session.createQuery(sqlSearch);
                querySearch.setString("subjectName", "%" + inputBean.getSearchname() + "%");

                querySearch.setMaxResults(max);
                querySearch.setFirstResult(first);

                Iterator it = querySearch.iterate();
                while (it.hasNext()) {
                    SubjectBean databean = new SubjectBean();
                    Subject objBean = (Subject) it.next();

                    try {
                        databean.setSubjectId(objBean.getSubjectId().toString());
//                        System.out.println("subject id "+databean.getSubjectId());
                    } catch (NullPointerException e) {
                        databean.setSubjectId("--");
                    }
                    try {
                        databean.setSubjectName(objBean.getSubjectName());
                    } catch (NullPointerException e) {
                        databean.setSubjectName("--");
                    }
//                    try {
//                        databean.setSubjectMedium(objBean.getSubjectMedium());
//                    } catch (NullPointerException e) {
//                        databean.setSubjectMedium("--");
//                    }
                    try {
                        databean.setSubjectCode(objBean.getSubjectCode());
                    } catch (NullPointerException e) {
                        databean.setSubjectcode("--");
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

    public boolean addSubject(SubjectBean bean) throws Exception {
        boolean isAddSubject = false;
        Subject subject = null;
        Session session = null;
        String medium = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            subject = new Subject();

            subject.setSubjectCode(bean.getSubjectname().toUpperCase() + (int) (Math.random() * 100));

//            if ((bean.getSubjectmedium().equals("1"))) {
//                medium = "Sinhala";
//            } else if ((bean.getSubjectmedium().equals("2"))) {
//                medium = "English";
//            } else if ((bean.getSubjectmedium().equals("3"))) {
//                medium = "Tamil";
//            }
//            bean.setSubjectmedium(medium);
//            subject.setSubjectMedium(bean.getSubjectmedium());
            subject.setSubjectName(bean.getSubjectname());

            session.save(subject);
            session.getTransaction().commit();
            isAddSubject = true;
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
        return isAddSubject;
    }

    public void findsubject(SubjectBean inputBean) throws Exception {

        List<Subject> studentlist = null;
        Session session = null;

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from Subject wu where wu.subjectName =:subjectName";
            Query query = session.createQuery(sql);
            query.setString("subjectName", inputBean.getUpsubjectname());
            studentlist = query.list();

            if (0 < studentlist.size()) {

                inputBean.setUpsubjectcode(studentlist.get(0).getSubjectCode());
//                inputBean.setUpsubjectmedium(studentlist.get(0).getSubjectMedium());
                inputBean.setUpsubjectname(studentlist.get(0).getSubjectName());

            }
            System.out.println("illlllllllllllllll  " + inputBean.getUpsubjectcode());
            System.out.println("illlllllllllllllll  " + inputBean.getUpsubjectname());
            System.out.println("illlllllllllllllll  " + inputBean.getUpsubjectmedium());

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

    public boolean updateSubject(SubjectBean inputBean) throws Exception {
        boolean isUpdated = false;
        Session session = null;
        Query query = null;
        List<Subject> subject = null;
        String medium = "";

        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "from Subject wu where wu.subjectCode =:subjectCode";
            query = session.createQuery(sql);
            query.setString("subjectCode", inputBean.getUpsubjectcode());
            subject = query.list();
            if (subject.size() > 0) {
//                subject.get(0).setSubjectCode(inputBean.getUpsubjectcode());

                if ((inputBean.getUpsubjectmedium().equals("1"))) {
                    medium = "Sinhala";
                } else if ((inputBean.getUpsubjectmedium().equals("2"))) {
                    medium = "English";
                } else if ((inputBean.getUpsubjectmedium().equals("3"))) {
                    medium = "Tamil";
                }
                inputBean.setUpsubjectmedium(medium);
//                subject.get(0).setSubjectMedium(inputBean.getUpsubjectmedium());
                subject.get(0).setSubjectName(inputBean.getUpsubjectname());

                session.save(subject.get(0));
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

    public boolean deleteData(SubjectBean inputbean) throws Exception {
        boolean isSubjectDeleted = false;
        Session session = null;
        Query query = null;
        try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "delete Subject wu"
                    + "  where wu.subjectId =:subjectId";
            query = session.createQuery(sql);

            query.setString("subjectId", inputbean.getSubjectId());
            int result = query.executeUpdate();
            if (1 == result) {
                isSubjectDeleted = true;
            }
            session.getTransaction().commit();
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
                session.flush();
                session.close();
                session = null;
            }
        }
        return isSubjectDeleted;
    }

}

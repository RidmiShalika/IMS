/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailSMS.service;

import EmailSMS.bean.EmailSmsBean;
import Util.HibernateInit;
import java.util.List;
import mapping.Lecturer;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ridmi_g
 */
public class EmailSmsSevice {
    public void getLecLists(EmailSmsBean inputbean) throws Exception{
         List<Lecturer> lec = null;
         Session session = null;
         
         try {
            session = HibernateInit.getSessionFactory().openSession();
            session.beginTransaction();

            String sql = "from Lecturer";
            Query query = session.createQuery(sql);
            lec = query.list();
            
            for (int i = 0; i < lec.size(); i++) {
                 inputbean.getLectureNamelList().put(lec.get(i).getId(), lec.get(i).getName());
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

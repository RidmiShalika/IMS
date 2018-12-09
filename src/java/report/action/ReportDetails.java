/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report.action;

import Util.AccessControlService;
import Util.HibernateInit;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import login.bean.SessionBean;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.apache.struts2.ServletActionContext;
import report.bean.ReportBean;
import report.service.ReportService;

/**
 *
 * @author ridmi_g
 */
public class ReportDetails extends ActionSupport implements ModelDriven<ReportBean> ,AccessControlService{

      ReportBean inputBean = new ReportBean();
      HttpServletRequest req = ServletActionContext.getRequest();
      SessionBean sessionBean;
      ReportService service = new ReportService();
    
    @Override
    public ReportBean getModel() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            
            System.out.println(" getModel ");
            
            monthList(inputBean);
            yearList(inputBean);
            service.getCourseLists(inputBean);
            service.getLecLists(inputBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
  
        return inputBean;
    }

    @Override
    public boolean checkAccess(String method, int userRole) {
         return true;
    }
     public SessionBean getSessionBean() {
        return (SessionBean) req.getSession().getAttribute("SessionObject");
    }
     public String execute(){
         return SUCCESS;
     }
       public String Genreport1(){
           System.out.println("genate report method");

        return "gen1";
    }
     public void monthList(ReportBean inputbean){
            try {
            inputbean.getMonthlList().put(1, "January");
            inputbean.getMonthlList().put(2, "February");
            inputbean.getMonthlList().put(3, "March");
            inputbean.getMonthlList().put(4, "April");
            inputbean.getMonthlList().put(5, "May");
            inputbean.getMonthlList().put(6, "June");
            inputbean.getMonthlList().put(7, "July");
            inputbean.getMonthlList().put(8, "August");
            inputbean.getMonthlList().put(9, "September");
            inputbean.getMonthlList().put(10, "October");
            inputbean.getMonthlList().put(11, "November");
            inputbean.getMonthlList().put(12, "December");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void yearList(ReportBean inputbean){
         try {
             inputbean.getYearlList().put(1, "2017");
             inputbean.getYearlList().put(2, "2018");
             inputbean.getYearlList().put(3, "2019");
             inputbean.getYearlList().put(4, "2020");
             inputbean.getYearlList().put(5, "2021");
             inputbean.getYearlList().put(6, "2022");
             inputbean.getYearlList().put(7, "2023");
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     
     public String Genreport2(){
          try {
             
         } catch (Exception e) {
             e.printStackTrace();
         }
        return "gen2";
    }
     public String Genreport3(){
          try {
             
         } catch (Exception e) {
             e.printStackTrace();
         }
        return "gen3";
    }
     public String Genreport4(){
          try {
             
         } catch (Exception e) {
             e.printStackTrace();
         }
        return "gen4";
    }
     public String Genreport5(){
          try {
             
         } catch (Exception e) {
             e.printStackTrace();
         }
        return "gen5";
    }
     public String Genreport6(){
          try {
             
         } catch (Exception e) {
             e.printStackTrace();
         }
        return "gen6";
    }
     public String Genreport7(){
          try {
             
         } catch (Exception e) {
             e.printStackTrace();
         }
        return "gen7";
    }
     public String Genreport8(){
          try {
             
         } catch (Exception e) {
             e.printStackTrace();
         }
        return "gen8";
    }
     public String Genreport9(){
          try {
             
         } catch (Exception e) {
             e.printStackTrace();
         }
        return "gen9";
    }
     public String Genreport10(){
          try {
             
         } catch (Exception e) {
             e.printStackTrace();
         }
        return "gen10";
    }
     public String Genreport11(){
          try {
             
         } catch (Exception e) {
             e.printStackTrace();
         }
        return "gen11";
    }
  
     
    public String Report1(ReportBean inputBean){
        try {
            
            
            System.out.println("report 1 method");
            
//            List<Map<String, Object>> dataSourse = new ArrayList<Map<String, Object>>();
//             String jasperPath = ServletActionContext.getServletContext().getRealPath("D:\\Ridmi\\Zeogyen\\src\\java\\iReport");
//            String pdfName = "Payment Report";
//            String rpt = "CoursePaymentStatus.jrxml";
//               Map<String, Object> row = new HashMap<String, Object>();
//            
//            for(ReportBean inputbean : service.report1()){
//             
//                row.put("advance_payments_lec_id",inputbean.getAdvance_payments_lec_id());
//                 row.put("advance_payments_amount",inputbean.getAdvance_payments_amount());
//                 dataSourse.add(row);
//            }
//           
//        JasperReport jr = JasperCompileManager.compileReport(jasperPath + "/" + rpt);
//	JasperPrint jp;
//            jp = JasperFillManager.fillReport(jr, row, HibernateInit.getSessionFactory().openSession());
//	JasperExportManager.exportReportToPdfFile(jp, jasperPath + pdfName + ".pdf");
//            FileInputStream fileInputStream = new FileInputStream(new File(jasperPath + pdfName + ".pdf"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "rep1";
    }
     public String Report2(ReportBean inputBean){
        try {
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "rep2";
    }
     public String Report3(ReportBean inputBean){
        try {
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "rep4";
    }
     public String Report4(ReportBean inputBean){
        try {
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "rep4";
    }
     public String Report5(ReportBean inputBean){
        try {
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "rep5";
    }
     public String Report6(ReportBean inputBean){
        try {
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "rep6";
    }
     public String Report7(ReportBean inputBean){
        try {
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "rep7";
    }
     public String Report8(ReportBean inputBean){
        try {
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "rep8";
    }
     public String Report9(ReportBean inputBean){
        try {
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "rep9";
    }
     public String Report10(ReportBean inputBean){
        try {
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "rep10";
    }
     public String Report11(ReportBean inputBean){
        try {
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "rep11";
    }
     
}

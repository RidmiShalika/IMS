/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atten.action;

import Atten.bean.AttenBean;
import Atten.service.AttenService;
import Util.AccessControlService;
import Util.Config;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;

import org.apache.struts2.ServletActionContext;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
/**
 *
 * @author ridmi_g
 */
public class AttenAction extends ActionSupport implements ModelDriven<AttenBean>, AccessControlService {

    AttenBean inputBean = new AttenBean();
    AttenService service = new AttenService();
    
    public String submit = null;
    public InputStream fileInputStream;
    public String jasperPath = "";
    public String pdfName = "";
    public String rpt = "";
    
    

    @Override
    public String execute() {
        return SUCCESS;

    }

    public String findSt() {
        try {
            int stuid = 0;
            if (inputBean.getAttenid().length() == Config.cardnoLength) {
                stuid = service.getSIDusibgCardNo(inputBean.getAttenid());
                inputBean.setIsmismatch(true);
            } else if (inputBean.getAttenid().length() == Config.studentIdLength) {
                stuid = Integer.parseInt(inputBean.getAttenid());
                inputBean.setIsmismatch(true);
            }else{
                inputBean.setIsmismatch(false);
            }

            System.out.println("Stuid " + stuid);
            HttpSession session = ServletActionContext.getRequest().getSession(false);
            session.setAttribute("stcourselist", stuid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "findSt";
    }

    @Override
    public AttenBean getModel() {
        return inputBean;
    }

    @Override
    public boolean checkAccess(String method, int userRole) {
        return true;
    }

    public String loadandattendence() {
        try {
            System.out.println("is payment jsp : " + inputBean.getPaymentjsp());
            boolean istrue = false;

//            if (inputBean.getAttenid().length() == Config.cardnoLength) {
//                istrue = true;
//            } else if (inputBean.getAttenid().length() == Config.studentIdLength) {
                istrue = true;
//            }

            if (istrue) {
                inputBean.setIsmismatch(istrue);
                if (!inputBean.getPaymentjsp().equals("0")) {
                    if (service.IS_First_Entrence()) {
                        String mobileno = service.getmobileNo(inputBean);
                        if (!"".equals(mobileno)) {
                            boolean checkmobileno = validateMobileNo(mobileno.trim());
                            if (checkmobileno) {
                                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
                                Date date = new Date();
                                service.insert_arrive_SMS(inputBean.getStudent_gender(), inputBean.getStudent_name(), formatter.format(date).replace(" ", "+"), mobileno);
                            } else {
                                System.out.println("Mobile number validation fails");
                            }

                        } else {
                            System.out.println("No mobile number");
                        }

                    }
                }

                //load data from service
                service.loadData(inputBean);
                
                service.historyData(inputBean, Integer.parseInt(inputBean.getCid()));
                service.getpaymenthistory(inputBean, Integer.parseInt(inputBean.getCid()));
            }else{
                inputBean.setIsmismatch(istrue);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "loadandattendence";
    }

    public String loadhistorylist() {
        try {
            //load data from service
            System.out.println("atteid " + inputBean.getAttenid());
            int cid = service.getcorseid(inputBean);
            service.historyData(inputBean, cid);
            service.getpaymenthistory(inputBean, cid);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "loadhistorylist";
    }

    public String list() {
        System.out.println("list method");
        List<AttenBean> dataList;
        try {
            int rows = inputBean.getRows();
            int page = inputBean.getPage();
            int to = (rows * page);
            int from = to - rows;
            long records;
            String orderBy = "";

            dataList = service.loadStudent(inputBean, to, from, orderBy);
            if (!dataList.isEmpty()) {
                records = dataList.get(0).getFullCount();
                System.out.println("recode " + records);
                inputBean.setRecords(records);
                inputBean.setGridModel(dataList);
                int total = (int) Math.ceil((double) records / (double) rows);
                inputBean.setTotal(total);
            } else {
                inputBean.setRecords(0L);
                inputBean.setTotal(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "list";
    }

    public String paymentmark() {
        try {
            System.out.println(" selected data " + inputBean.getSelected_data());
            service.paymentdetails(inputBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "paymentmark";
    }

    public boolean validateMobileNo(String parentContactNo) throws Exception {
        boolean status = false;
        try {

            if (parentContactNo.length() == 9) {
                parentContactNo = "0" + parentContactNo;
            }
            if (parentContactNo.matches("[0-9]+") && parentContactNo.length() == 10) {
                String prefix = parentContactNo.trim().substring(0, 3);
                if (prefix.equals("070") || prefix.equals("071") || prefix.equals("072") || prefix.equals("075") || prefix.equals("076") || prefix.equals("077") || prefix.equals("078")) {
                    status = true;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return status;
    }
    public String printBill(){
//         InputStream inputStream;
        try {
            System.out.println("printBill>>>>>>>>>>.."+inputBean.getHiddBillid());
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute_management", "root", "");
//            String str;
//            str = ServletActionContext.getServletContext().getRealPath("/resources/jasper/LatestPaymentRecipt.jrxml");
//            JasperDesign jd=JRXmlLoader.load(str);
//            Map parameters = new HashMap();
//            parameters.put("userid", 1);
//            net.sf.jasperreports.engine.JasperReport jr = JasperCompileManager.compileReport(jd);
//            JasperPrint jp=JasperFillManager.fillReport(jr, parameters,cn);
//            JRExporter exporter = new net.sf.jasperreports.engine.export.JRPdfExporter();
//            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
//            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, ServletActionContext.getServletContext().getRealPath("/resources/jasper/LatestPaymentRecipt.pdf"));
//            exporter.exportReport();
//            File file = new File(ServletActionContext.getServletContext().getRealPath("/resources/jasper/LatestPaymentRecipt.pdf"));  
//            inputStream = new DataInputStream( new FileInputStream(file));

//                jasperPath = ServletActionContext.getServletContext().getRealPath("/resources/jasper");
//		jasperPath = jasperPath+"\\"+"LatestPaymentRecipt.jasper";//jasper eka daanna one ummiyoo		
//                 File reportFile = new File(jasperPath);
//                 JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
//        
//                        //JRResultSetDataSource resultSetDataSource = new JRResultSetDataSource(rs);
//				HashMap<String, Object> pm = new HashMap<String, Object>();
//				String bill_id = "10001";
//				pm.put("bill_id", bill_id);
//				//JasperReport jr = JasperCompileManager.compileReport(jasperPath);
//				JasperPrint jp = JasperFillManager.fillReport(jasperReport, pm,cn);
//                                
//                                //me thiyenne mage eke thiye widiya
//                                boolean autoprint = true;
//                                  JRViewer viewer = new JRViewer(jp);
//                                if(autoprint){
//                                    JasperPrintManager.printReport(jp,false);
//                                }
            
           
              // If compiled file is not found, then compile XML template
   
  
//            ///end
//				JasperExportManager.exportReportToPdfFile(jp, jasperPath + pdfName + ".pdf");
//				fileInputStream = new FileInputStream(new File(jasperPath + pdfName + ".pdf"));

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "PdfDownload";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report.bean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ridmi_g
 */
public class ReportBean {
      private Map<Integer, String> monthlList = new HashMap<Integer, String>();
      private Map<Integer, String> yearlList = new HashMap<Integer, String>();
      private Map<Integer, String> courselList = new HashMap<Integer, String>();
      private Map<Integer, String> lectureNamelList = new HashMap<Integer, String>();
      private String month;
      private String year;
      private String lectureName;
      private String course;
      
      //report1
      private String advance_payments_lec_id;
      private String advance_payments_amount;
      
      private String month2;

    public ReportBean() {
        
    }

    public String getMonth2() {
        return month2;
    }

    public void setMonth2(String month2) {
        this.month2 = month2;
    }
    

    public ReportBean(String advance_payments_lec_id, String advance_payments_amount) {
        this.advance_payments_lec_id = advance_payments_lec_id;
        this.advance_payments_amount = advance_payments_amount;
    }

    public String getAdvance_payments_lec_id() {
        return advance_payments_lec_id;
    }

    public void setAdvance_payments_lec_id(String advance_payments_lec_id) {
        this.advance_payments_lec_id = advance_payments_lec_id;
    }

    public String getAdvance_payments_amount() {
        return advance_payments_amount;
    }

    public void setAdvance_payments_amount(String advance_payments_amount) {
        this.advance_payments_amount = advance_payments_amount;
    }
    
     public Map<Integer, String> getCourselList() {
        return courselList;
    }

    public void setCourselList(Map<Integer, String> courselList) {
        this.courselList = courselList;
    }

    public Map<Integer, String> getLectureNamelList() {
        return lectureNamelList;
    }

    public void setLectureNamelList(Map<Integer, String> lectureNamelList) {
        this.lectureNamelList = lectureNamelList;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

      
    public Map<Integer, String> getYearlList() {
        return yearlList;
    }

    public void setYearlList(Map<Integer, String> yearlList) {
        this.yearlList = yearlList;
    }
      
    public Map<Integer, String> getMonthlList() {
        return monthlList;
    }

    public void setMonthlList(Map<Integer, String> monthlList) {
        this.monthlList = monthlList;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
      
      
}

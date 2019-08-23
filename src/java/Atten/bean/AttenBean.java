/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atten.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ridmi_g
 */
public class AttenBean {
    //Table data

    private List<AttenBean> gridModel = new ArrayList<AttenBean>();
    private Integer rows = 0;
    private Integer page = 0;
    private Integer total = 0;
    private Long records = 0L;
    private String sord;
    private String sidx;
    private long fullCount;

    private String attenid;

//    private String Id;
//    private String courseid;
//    private String payments;
//    private String cardType;
//    private String lastpayment;
    private String id;
    private String sid;
    private String cid;
    private String year;
    private String month;
    private String status;
    
    
    private String name;
    private String regID;
    private String school;
    private String regDate;
    private String addcardType;
    private String addpayments;

    private String lname;
    private String crdType;
    private String time;
    private String courseId;
    private String extra_normal;
    
    private String selected_data;
    private String student_gender;
    private String student_name;
    
    //payment flag
    private String paymentjsp;
    private boolean ismismatch;
    
    ArrayList<String> attandance_history = new ArrayList<String>();
    ArrayList<String> payment_history = new ArrayList<String>();

    public boolean isIsmismatch() {
        return ismismatch;
    }

    public void setIsmismatch(boolean ismismatch) {
        this.ismismatch = ismismatch;
    }

    
    public String getPaymentjsp() {
        return paymentjsp;
    }

    public void setPaymentjsp(String paymentjsp) {
        this.paymentjsp = paymentjsp;
    }

    
    public String getStudent_gender() {
        return student_gender;
    }

    public void setStudent_gender(String student_gender) {
        this.student_gender = student_gender;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    
    public ArrayList<String> getPayment_history() {
        return payment_history;
    }

    public void setPayment_history(ArrayList<String> payment_history) {
        this.payment_history = payment_history;
    }

    public ArrayList<String> getAttandance_history() {
        return attandance_history;
    }

    public void setAttandance_history(ArrayList<String> attandance_history) {
        this.attandance_history = attandance_history;
    }

    
    public String getSelected_data() {
        return selected_data;
    }

    public void setSelected_data(String selected_data) {
        this.selected_data = selected_data;
    }

    
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCrdType() {
        return crdType;
    }

    public void setCrdType(String crdType) {
        this.crdType = crdType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getExtra_normal() {
        return extra_normal;
    }

    public void setExtra_normal(String extra_normal) {
        this.extra_normal = extra_normal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegID() {
        return regID;
    }

    public void setRegID(String regID) {
        this.regID = regID;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getAddcardType() {
        return addcardType;
    }

    public void setAddcardType(String addcardType) {
        this.addcardType = addcardType;
    }

    public String getAddpayments() {
        return addpayments;
    }

    public void setAddpayments(String addpayments) {
        this.addpayments = addpayments;
    }

    public long getFullCount() {
        return fullCount;
    }

    public void setFullCount(long fullCount) {
        this.fullCount = fullCount;
    }

    public List<AttenBean> getGridModel() {
        return gridModel;
    }

    public void setGridModel(List<AttenBean> gridModel) {
        this.gridModel = gridModel;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Long getRecords() {
        return records;
    }

    public void setRecords(Long records) {
        this.records = records;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getAttenid() {
        return attenid;
    }

    public void setAttenid(String attenid) {
        this.attenid = attenid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

}

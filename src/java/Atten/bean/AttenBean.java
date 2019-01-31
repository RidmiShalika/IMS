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

    private String Id;
    private String courseid;
    private String payments;
    private String cardType;
    private String lastpayment;

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

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getLastpayment() {
        return lastpayment;
    }

    public void setLastpayment(String lastpayment) {
        this.lastpayment = lastpayment;
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

}

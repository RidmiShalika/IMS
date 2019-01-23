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

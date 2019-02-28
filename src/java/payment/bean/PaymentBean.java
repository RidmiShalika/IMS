/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ridmi_g
 */
public class PaymentBean {
    String payid;
    String pid;
    //Table data
    private List<PaymentBean> gridModel = new ArrayList<PaymentBean>();
    private Integer rows = 0;
    private Integer page = 0;
    private Integer total = 0;
    private Long records = 0L;
    private String sord;
    private String sidx;
    private long fullCount;
    
    private String id;
    private String sid;
    private String cid;
    private String year;
    private String month;
    private String status;
    
    private String selected_data;
    
    ArrayList<String> attandance_history = new ArrayList<String>();
    ArrayList<String> payment_history = new ArrayList<String>();

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    
    public String getSelected_data() {
        return selected_data;
    }

    public void setSelected_data(String selected_data) {
        this.selected_data = selected_data;
    }

    public ArrayList<String> getAttandance_history() {
        return attandance_history;
    }

    public void setAttandance_history(ArrayList<String> attandance_history) {
        this.attandance_history = attandance_history;
    }

    public ArrayList<String> getPayment_history() {
        return payment_history;
    }

    public void setPayment_history(ArrayList<String> payment_history) {
        this.payment_history = payment_history;
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
    
    
    public List<PaymentBean> getGridModel() {
        return gridModel;
    }

    public void setGridModel(List<PaymentBean> gridModel) {
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

    public long getFullCount() {
        return fullCount;
    }

    public void setFullCount(long fullCount) {
        this.fullCount = fullCount;
    }

    
    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid;
    }
    
}

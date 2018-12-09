/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subject.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ridmi_g
 */
public class SubjectBean {

    private String subjectId;
    private String subjectName;
    private String subjectCode;
    private String subjectMedium;

    private Map<Integer, String> subList = new HashMap<Integer, String>();
    private long fullCount;

    //Table data
    private List<SubjectBean> gridModel = new ArrayList<SubjectBean>();
    private Integer rows = 0;
    private Integer page = 0;
    private Integer total = 0;
    private Long records = 0L;
    private String sord;
    private String sidx;

    //Add data
    private String subjectname;
    private String subjectmedium;
    
    
    private String subjectcode;

    //Edit data
    private String upsubjectname;
    private String upsubjectmedium;
    private String upsubjectcode;

    //search data
    private String searchname;
    
     //Delete Data
    private String message;
    private boolean success;

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    
    public Map<Integer, String> getSubList() {
        return subList;
    }

    public void setSubList(Map<Integer, String> subList) {
        this.subList = subList;
    }

    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectMedium() {
        return subjectMedium;
    }

    public void setSubjectMedium(String subjectMedium) {
        this.subjectMedium = subjectMedium;
    }

    public long getFullCount() {
        return fullCount;
    }

    public void setFullCount(long fullCount) {
        this.fullCount = fullCount;
    }

    public List<SubjectBean> getGridModel() {
        return gridModel;
    }

    public void setGridModel(List<SubjectBean> gridModel) {
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

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectmedium() {
        return subjectmedium;
    }

    public void setSubjectmedium(String subjectmedium) {
        this.subjectmedium = subjectmedium;
    }

    

    public String getUpsubjectname() {
        return upsubjectname;
    }

    public void setUpsubjectname(String upsubjectname) {
        this.upsubjectname = upsubjectname;
    }

    public String getUpsubjectmedium() {
        return upsubjectmedium;
    }

    public void setUpsubjectmedium(String upsubjectmedium) {
        this.upsubjectmedium = upsubjectmedium;
    }

    public String getUpsubjectcode() {
        return upsubjectcode;
    }

    public void setUpsubjectcode(String upsubjectcode) {
        this.upsubjectcode = upsubjectcode;
    }

    public String getSearchname() {
        return searchname;
    }

    public void setSearchname(String searchname) {
        this.searchname = searchname;
    }
    
    
    
}

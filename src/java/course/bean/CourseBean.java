/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package course.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ridmi_g
 */
public class CourseBean {
    private long fullCount;

    //Table data
    private List<CourseBean> gridModel = new ArrayList<CourseBean>();
    private Integer rows = 0;
    private Integer page = 0;
    private Integer total = 0;
    private Long records = 0L;
    private String sord;
    private String sidx;
    
    // List data
   
    private String courseID;
    private String courseDescription;
    private String subject;
    private String lecturer;
    private String classType;
    private String medium;
    
    //Add data
    
    private String addcourseDescription;
    private String addlecturer;
    private String addconductingMedium;
    private String addsubject;
    private String addtotalCoursefee;
    private String addgrade;
    private String addcourseDuration;
    private String addmonthlyFee;
    private String addclassType;
    private String addlectureHall;
    private String addbatchNo;
    private String addlecturerPayment;
    private String addclassDays;
    private String addstartTime;
    private String addendTime;
    
    private String searchname = "";
    
    private Map<Integer, String> lecList = new HashMap<Integer, String>();
    private Map<Integer, String> medList = new HashMap<Integer, String>();
    private Map<Integer, String>  subList = new HashMap<Integer, String>();
    private Map<Integer, String>  gradeList = new HashMap<Integer, String>();
    private Map<Integer, String>  clzList = new HashMap<Integer, String>();
    private Map<Integer, String>  hallList = new HashMap<Integer, String>();
    private Map<Integer, String>  batchList = new HashMap<Integer, String>();

    public Map<Integer, String> getBatchList() {
        return batchList;
    }

    public void setBatchList(Map<Integer, String> batchList) {
        this.batchList = batchList;
    }
    
    
    public Map<Integer, String> getClzList() {
        return clzList;
    }

    public void setClzList(Map<Integer, String> clzList) {
        this.clzList = clzList;
    }

    public Map<Integer, String> getHallList() {
        return hallList;
    }

    public void setHallList(Map<Integer, String> hallList) {
        this.hallList = hallList;
    }

    
    public Map<Integer, String> getGradeList() {
        return gradeList;
    }

    public void setGradeList(Map<Integer, String> gradeList) {
        this.gradeList = gradeList;
    }
    

    public Map<Integer, String> getSubList() {
        return subList;
    }

    public void setSubList(Map<Integer, String> subList) {
        this.subList = subList;
    }

    
    public Map<Integer, String> getMedList() {
        return medList;
    }

    public void setMedList(Map<Integer, String> medList) {
        this.medList = medList;
    }

    
    public Map<Integer, String> getLecList() {
        return lecList;
    }

    public void setLecList(Map<Integer, String> lecList) {
        this.lecList = lecList;
    }

    
    public String getSearchname() {
        return searchname;
    }

    public void setSearchname(String searchname) {
        this.searchname = searchname;
    }

  
    

    public String getAddcourseDescription() {
        return addcourseDescription;
    }

    public void setAddcourseDescription(String addcourseDescription) {
        this.addcourseDescription = addcourseDescription;
    }

    public String getAddlecturer() {
        return addlecturer;
    }

    public void setAddlecturer(String addlecturer) {
        this.addlecturer = addlecturer;
    }

    public String getAddconductingMedium() {
        return addconductingMedium;
    }

    public void setAddconductingMedium(String addconductingMedium) {
        this.addconductingMedium = addconductingMedium;
    }

    public String getAddsubject() {
        return addsubject;
    }

    public void setAddsubject(String addsubject) {
        this.addsubject = addsubject;
    }

    public String getAddtotalCoursefee() {
        return addtotalCoursefee;
    }

    public void setAddtotalCoursefee(String addtotalCoursefee) {
        this.addtotalCoursefee = addtotalCoursefee;
    }

    public String getAddgrade() {
        return addgrade;
    }

    public void setAddgrade(String addgrade) {
        this.addgrade = addgrade;
    }

    public String getAddcourseDuration() {
        return addcourseDuration;
    }

    public void setAddcourseDuration(String addcourseDuration) {
        this.addcourseDuration = addcourseDuration;
    }

    public String getAddmonthlyFee() {
        return addmonthlyFee;
    }

    public void setAddmonthlyFee(String addmonthlyFee) {
        this.addmonthlyFee = addmonthlyFee;
    }

    public String getAddclassType() {
        return addclassType;
    }

    public void setAddclassType(String addclassType) {
        this.addclassType = addclassType;
    }

    public String getAddlectureHall() {
        return addlectureHall;
    }

    public void setAddlectureHall(String addlectureHall) {
        this.addlectureHall = addlectureHall;
    }

    public String getAddbatchNo() {
        return addbatchNo;
    }

    public void setAddbatchNo(String addbatchNo) {
        this.addbatchNo = addbatchNo;
    }

    public String getAddlecturerPayment() {
        return addlecturerPayment;
    }

    public void setAddlecturerPayment(String addlecturerPayment) {
        this.addlecturerPayment = addlecturerPayment;
    }

    public String getAddclassDays() {
        return addclassDays;
    }

    public void setAddclassDays(String addclassDays) {
        this.addclassDays = addclassDays;
    }

    public String getAddstartTime() {
        return addstartTime;
    }

    public void setAddstartTime(String addstartTime) {
        this.addstartTime = addstartTime;
    }

    public String getAddendTime() {
        return addendTime;
    }

    public void setAddendTime(String addendTime) {
        this.addendTime = addendTime;
    }
    
    public long getFullCount() {
        return fullCount;
    }

    public void setFullCount(long fullCount) {
        this.fullCount = fullCount;
    }

    public List<CourseBean> getGridModel() {
        return gridModel;
    }

    public void setGridModel(List<CourseBean> gridModel) {
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

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }
    

    
}

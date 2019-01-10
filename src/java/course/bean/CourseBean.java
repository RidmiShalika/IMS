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
    
    // update
    private String upcourseid;
    private String upcourseDescription;
    private String uplecturer;
    private String upconductingMedium;
    private String upsubject;
    private String uptotalCoursefee;
    private String upgrade;
    private String upcourseDuration;
    private String upmonthlyFee;
    private String upclassType;
    private String uplectureHall;
    private String upbatchNo;
    private String uplecturerPayment;
    private String upclassDays;
    private String upstartTime;
    private String upendTime;
    
    private String upstarttimeM;
    private String upstarttimeTu;
    private String upstarttimeW;
    private String upstarttimeTh;
    private String upstarttimeF;
    private String upstarttimeSa;
    private String upstarttimeSu;
    
    private String upendtimeM;
    private String upendtimeTu;
    private String upendtimeW;
    private String upendtimeTh;
    private String upendtimeF;
    private String upendtimeSa;
    private String upendtimeSu;
    
    
    private String searchname = "";
    
    private Map<Integer, String> lecList = new HashMap<Integer, String>();
    private Map<Integer, String> medList = new HashMap<Integer, String>();
    private Map<Integer, String>  subList = new HashMap<Integer, String>();
    private Map<Integer, String>  gradeList = new HashMap<Integer, String>();
    private Map<Integer, String>  clzList = new HashMap<Integer, String>();
    private Map<Integer, String>  hallList = new HashMap<Integer, String>();
    private Map<Integer, String>  batchList = new HashMap<Integer, String>();
    
    //add class days time
    private String starttimeM;
    private String starttimeTu;
    private String starttimeW;
    private String starttimeTh;
    private String starttimeF;
    private String starttimeSa;
    private String starttimeSu;
    
    private String endtimeM;
    private String endtimeTu;
    private String endtimeW;
    private String endtimeTh;
    private String endtimeF;
    private String endtimeSa;
    private String endtimeSu;
    
    //stop class
    private String id;
    private String stopcourseDescription;
    private String monday;
    private String tueday;
    private String wedday;
    private String thurday;
    private String friday;
    private String satday;
    private String sunday;
    
    private int course_ID;
    
    //extra class
    private String extraDate;
    private String extraStartTime;
    private String extraEndTime;
    
    //list extra clz
    private String exid;
    private String courseId;
    private String date;
    private String startTime;
    private String endTime;
    private String status;
    
    private String message;
    private boolean success;

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
    
    public String getExid() {
        return exid;
    }

    public void setExid(String exid) {
        this.exid = exid;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExtraDate() {
        return extraDate;
    }

    public void setExtraDate(String extraDate) {
        this.extraDate = extraDate;
    }

    public String getExtraStartTime() {
        return extraStartTime;
    }

    public void setExtraStartTime(String extraStartTime) {
        this.extraStartTime = extraStartTime;
    }

    public String getExtraEndTime() {
        return extraEndTime;
    }

    public void setExtraEndTime(String extraEndTime) {
        this.extraEndTime = extraEndTime;
    }

    public int getCourse_ID() {
        return course_ID;
    }

    public void setCourse_ID(int course_ID) {
        this.course_ID = course_ID;
    }

    
    public String getStarttimeM() {
        return starttimeM;
    }

    public void setStarttimeM(String starttimeM) {
        this.starttimeM = starttimeM;
    }

    public String getStarttimeTu() {
        return starttimeTu;
    }

    public void setStarttimeTu(String starttimeTu) {
        this.starttimeTu = starttimeTu;
    }

    public String getStarttimeW() {
        return starttimeW;
    }

    public void setStarttimeW(String starttimeW) {
        this.starttimeW = starttimeW;
    }

    public String getStarttimeTh() {
        return starttimeTh;
    }

    public void setStarttimeTh(String starttimeTh) {
        this.starttimeTh = starttimeTh;
    }

    public String getStarttimeF() {
        return starttimeF;
    }

    public void setStarttimeF(String starttimeF) {
        this.starttimeF = starttimeF;
    }

    public String getStarttimeSa() {
        return starttimeSa;
    }

    public void setStarttimeSa(String starttimeSa) {
        this.starttimeSa = starttimeSa;
    }

    public String getStarttimeSu() {
        return starttimeSu;
    }

    public void setStarttimeSu(String starttimeSu) {
        this.starttimeSu = starttimeSu;
    }
    
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

    public String getUpcourseid() {
        return upcourseid;
    }

    public void setUpcourseid(String upcourseid) {
        this.upcourseid = upcourseid;
    }

    public String getUpcourseDescription() {
        return upcourseDescription;
    }

    public void setUpcourseDescription(String upcourseDescription) {
        this.upcourseDescription = upcourseDescription;
    }

    public String getUplecturer() {
        return uplecturer;
    }

    public void setUplecturer(String uplecturer) {
        this.uplecturer = uplecturer;
    }

    public String getUpconductingMedium() {
        return upconductingMedium;
    }

    public void setUpconductingMedium(String upconductingMedium) {
        this.upconductingMedium = upconductingMedium;
    }

    public String getUpsubject() {
        return upsubject;
    }

    public void setUpsubject(String upsubject) {
        this.upsubject = upsubject;
    }

    public String getUptotalCoursefee() {
        return uptotalCoursefee;
    }

    public void setUptotalCoursefee(String uptotalCoursefee) {
        this.uptotalCoursefee = uptotalCoursefee;
    }

    public String getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(String upgrade) {
        this.upgrade = upgrade;
    }

    public String getUpcourseDuration() {
        return upcourseDuration;
    }

    public void setUpcourseDuration(String upcourseDuration) {
        this.upcourseDuration = upcourseDuration;
    }

    public String getUpmonthlyFee() {
        return upmonthlyFee;
    }

    public void setUpmonthlyFee(String upmonthlyFee) {
        this.upmonthlyFee = upmonthlyFee;
    }

    public String getUpclassType() {
        return upclassType;
    }

    public void setUpclassType(String upclassType) {
        this.upclassType = upclassType;
    }

    public String getUplectureHall() {
        return uplectureHall;
    }

    public void setUplectureHall(String uplectureHall) {
        this.uplectureHall = uplectureHall;
    }

    public String getUpbatchNo() {
        return upbatchNo;
    }

    public void setUpbatchNo(String upbatchNo) {
        this.upbatchNo = upbatchNo;
    }

    public String getUplecturerPayment() {
        return uplecturerPayment;
    }

    public void setUplecturerPayment(String uplecturerPayment) {
        this.uplecturerPayment = uplecturerPayment;
    }

    public String getUpclassDays() {
        return upclassDays;
    }

    public void setUpclassDays(String upclassDays) {
        this.upclassDays = upclassDays;
    }

    public String getUpstartTime() {
        return upstartTime;
    }

    public void setUpstartTime(String upstartTime) {
        this.upstartTime = upstartTime;
    }

    public String getUpendTime() {
        return upendTime;
    }

    public void setUpendTime(String upendTime) {
        this.upendTime = upendTime;
    }

    public String getUpstarttimeM() {
        return upstarttimeM;
    }

    public void setUpstarttimeM(String upstarttimeM) {
        this.upstarttimeM = upstarttimeM;
    }

    public String getUpstarttimeTu() {
        return upstarttimeTu;
    }

    public void setUpstarttimeTu(String upstarttimeTu) {
        this.upstarttimeTu = upstarttimeTu;
    }

    public String getUpstarttimeW() {
        return upstarttimeW;
    }

    public void setUpstarttimeW(String upstarttimeW) {
        this.upstarttimeW = upstarttimeW;
    }

    public String getUpstarttimeTh() {
        return upstarttimeTh;
    }

    public void setUpstarttimeTh(String upstarttimeTh) {
        this.upstarttimeTh = upstarttimeTh;
    }

    public String getUpstarttimeF() {
        return upstarttimeF;
    }

    public void setUpstarttimeF(String upstarttimeF) {
        this.upstarttimeF = upstarttimeF;
    }

    public String getUpstarttimeSa() {
        return upstarttimeSa;
    }

    public void setUpstarttimeSa(String upstarttimeSa) {
        this.upstarttimeSa = upstarttimeSa;
    }

    public String getUpstarttimeSu() {
        return upstarttimeSu;
    }

    public void setUpstarttimeSu(String upstarttimeSu) {
        this.upstarttimeSu = upstarttimeSu;
    }

    public String getEndtimeM() {
        return endtimeM;
    }

    public void setEndtimeM(String endtimeM) {
        this.endtimeM = endtimeM;
    }

    public String getEndtimeTu() {
        return endtimeTu;
    }

    public void setEndtimeTu(String endtimeTu) {
        this.endtimeTu = endtimeTu;
    }

    public String getEndtimeW() {
        return endtimeW;
    }

    public void setEndtimeW(String endtimeW) {
        this.endtimeW = endtimeW;
    }

    public String getEndtimeTh() {
        return endtimeTh;
    }

    public void setEndtimeTh(String endtimeTh) {
        this.endtimeTh = endtimeTh;
    }

    public String getEndtimeF() {
        return endtimeF;
    }

    public void setEndtimeF(String endtimeF) {
        this.endtimeF = endtimeF;
    }

    public String getEndtimeSa() {
        return endtimeSa;
    }

    public void setEndtimeSa(String endtimeSa) {
        this.endtimeSa = endtimeSa;
    }

    public String getEndtimeSu() {
        return endtimeSu;
    }

    public void setEndtimeSu(String endtimeSu) {
        this.endtimeSu = endtimeSu;
    }

    public String getUpendtimeM() {
        return upendtimeM;
    }

    public void setUpendtimeM(String upendtimeM) {
        this.upendtimeM = upendtimeM;
    }

    public String getUpendtimeTu() {
        return upendtimeTu;
    }

    public void setUpendtimeTu(String upendtimeTu) {
        this.upendtimeTu = upendtimeTu;
    }

    public String getUpendtimeW() {
        return upendtimeW;
    }

    public void setUpendtimeW(String upendtimeW) {
        this.upendtimeW = upendtimeW;
    }

    public String getUpendtimeTh() {
        return upendtimeTh;
    }

    public void setUpendtimeTh(String upendtimeTh) {
        this.upendtimeTh = upendtimeTh;
    }

    public String getUpendtimeF() {
        return upendtimeF;
    }

    public void setUpendtimeF(String upendtimeF) {
        this.upendtimeF = upendtimeF;
    }

    public String getUpendtimeSa() {
        return upendtimeSa;
    }

    public void setUpendtimeSa(String upendtimeSa) {
        this.upendtimeSa = upendtimeSa;
    }

    public String getUpendtimeSu() {
        return upendtimeSu;
    }

    public void setUpendtimeSu(String upendtimeSu) {
        this.upendtimeSu = upendtimeSu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStopcourseDescription() {
        return stopcourseDescription;
    }

    public void setStopcourseDescription(String stopcourseDescription) {
        this.stopcourseDescription = stopcourseDescription;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTueday() {
        return tueday;
    }

    public void setTueday(String tueday) {
        this.tueday = tueday;
    }

    public String getWedday() {
        return wedday;
    }

    public void setWedday(String wedday) {
        this.wedday = wedday;
    }

    public String getThurday() {
        return thurday;
    }

    public void setThurday(String thurday) {
        this.thurday = thurday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSatday() {
        return satday;
    }

    public void setSatday(String satday) {
        this.satday = satday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.bean;

/**
 *
 * @author ridmi_g
 */
public class MainBean {
    private String message;
    private boolean success;
    
    // home page details
    private String studentCount;
    private String teachersCount;
    private String subjectCount;
    private String courseCount;

    public String getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(String studentCount) {
        this.studentCount = studentCount;
    }

    public String getTeachersCount() {
        return teachersCount;
    }

    public void setTeachersCount(String teachersCount) {
        this.teachersCount = teachersCount;
    }

    public String getSubjectCount() {
        return subjectCount;
    }

    public void setSubjectCount(String subjectCount) {
        this.subjectCount = subjectCount;
    }

    public String getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(String courseCount) {
        this.courseCount = courseCount;
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
    
    
}

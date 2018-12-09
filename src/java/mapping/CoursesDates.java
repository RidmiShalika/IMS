/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ridmi_g
 */
@Entity
@Table(name = "courses_dates", catalog = "institute_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "CoursesDates.findAll", query = "SELECT c FROM CoursesDates c")})
public class CoursesDates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "course_id")
    private String courseId;
    @Size(max = 20)
    @Column(name = "monday")
    private String monday;
    @Size(max = 20)
    @Column(name = "tuesday")
    private String tuesday;
    @Size(max = 20)
    @Column(name = "wednesday")
    private String wednesday;
    @Size(max = 20)
    @Column(name = "thursday")
    private String thursday;
    @Size(max = 20)
    @Column(name = "friday")
    private String friday;
    @Size(max = 30)
    @Column(name = "saturday")
    private String saturday;
    @Size(max = 20)
    @Column(name = "sunday")
    private String sunday;

    public CoursesDates() {
    }

    public CoursesDates(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoursesDates)) {
            return false;
        }
        CoursesDates other = (CoursesDates) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.CoursesDates[ courseId=" + courseId + " ]";
    }
    
}

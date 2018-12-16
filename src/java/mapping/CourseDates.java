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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Ridmi Shalika
 */
@Entity
@Table(name = "course_dates", catalog = "institute_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "CourseDates.findAll", query = "SELECT c FROM CourseDates c")})
public class CourseDates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "monday")
    private String monday;
    @Size(max = 20)
    @Column(name = "tueday")
    private String tueday;
    @Size(max = 20)
    @Column(name = "wedday")
    private String wedday;
    @Size(max = 20)
    @Column(name = "thurday")
    private String thurday;
    @Size(max = 20)
    @Column(name = "friday")
    private String friday;
    @Size(max = 20)
    @Column(name = "satday")
    private String satday;
    @Size(max = 20)
    @Column(name = "sunday")
    private String sunday;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course courseId;

    public CourseDates() {
    }

    public CourseDates(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Course getCourseId() {
        return courseId;
    }

    public void setCourseId(Course courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseDates)) {
            return false;
        }
        CourseDates other = (CourseDates) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.CourseDates[ id=" + id + " ]";
    }
    
}

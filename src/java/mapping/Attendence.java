/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ridmi_g
 */
@Entity
@Table(name = "attendence", catalog = "institute_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "Attendence.findAll", query = "SELECT a FROM Attendence a")})
public class Attendence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "s_id")
    private Integer sId;
    @Size(max = 50)
    @Column(name = "c_id")
    private String cId;
    @Column(name = "year")
    private Integer year;
    @Column(name = "month")
    private Integer month;
    @Column(name = "date")
    private Integer date;
    @Size(max = 10)
    @Column(name = "day")
    private String day;
    @Size(max = 10)
    @Column(name = "time")
    private String time;
    @Column(name = "attendence")
    private Boolean attendence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "completeDate")
    @Temporal(TemporalType.DATE)
    private Date completeDate;

    public Attendence() {
    }

    public Attendence(Integer id) {
        this.id = id;
    }

    public Attendence(Integer id, Date completeDate) {
        this.id = id;
        this.completeDate = completeDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getAttendence() {
        return attendence;
    }

    public void setAttendence(Boolean attendence) {
        this.attendence = attendence;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
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
        if (!(object instanceof Attendence)) {
            return false;
        }
        Attendence other = (Attendence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.Attendence[ id=" + id + " ]";
    }
    
}

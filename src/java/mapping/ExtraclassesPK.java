/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ridmi_g
 */
@Embeddable
public class ExtraclassesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "courseID")
    private String courseID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "startTime")
    private String startTime;

    public ExtraclassesPK() {
    }

    public ExtraclassesPK(String courseID, String date, String startTime) {
        this.courseID = courseID;
        this.date = date;
        this.startTime = startTime;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseID != null ? courseID.hashCode() : 0);
        hash += (date != null ? date.hashCode() : 0);
        hash += (startTime != null ? startTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExtraclassesPK)) {
            return false;
        }
        ExtraclassesPK other = (ExtraclassesPK) object;
        if ((this.courseID == null && other.courseID != null) || (this.courseID != null && !this.courseID.equals(other.courseID))) {
            return false;
        }
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        if ((this.startTime == null && other.startTime != null) || (this.startTime != null && !this.startTime.equals(other.startTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.ExtraclassesPK[ courseID=" + courseID + ", date=" + date + ", startTime=" + startTime + " ]";
    }
    
}

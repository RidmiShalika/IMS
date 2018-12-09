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
public class StudentCoursePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "S_ID")
    private int sId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "course_id")
    private String courseId;

    public StudentCoursePK() {
    }

    public StudentCoursePK(int sId, String courseId) {
        this.sId = sId;
        this.courseId = courseId;
    }

    public int getSId() {
        return sId;
    }

    public void setSId(int sId) {
        this.sId = sId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) sId;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentCoursePK)) {
            return false;
        }
        StudentCoursePK other = (StudentCoursePK) object;
        if (this.sId != other.sId) {
            return false;
        }
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.StudentCoursePK[ sId=" + sId + ", courseId=" + courseId + " ]";
    }
    
}

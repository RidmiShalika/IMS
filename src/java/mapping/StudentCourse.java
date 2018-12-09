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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "student-course", catalog = "institute_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "StudentCourse.findAll", query = "SELECT s FROM StudentCourse s")})
public class StudentCourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentCoursePK studentCoursePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registation_date")
    @Temporal(TemporalType.DATE)
    private Date registationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cardType")
    private int cardType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;

    public StudentCourse() {
    }

    public StudentCourse(StudentCoursePK studentCoursePK) {
        this.studentCoursePK = studentCoursePK;
    }

    public StudentCourse(StudentCoursePK studentCoursePK, Date registationDate, int cardType, String status) {
        this.studentCoursePK = studentCoursePK;
        this.registationDate = registationDate;
        this.cardType = cardType;
        this.status = status;
    }

    public StudentCourse(int sId, String courseId) {
        this.studentCoursePK = new StudentCoursePK(sId, courseId);
    }

    public StudentCoursePK getStudentCoursePK() {
        return studentCoursePK;
    }

    public void setStudentCoursePK(StudentCoursePK studentCoursePK) {
        this.studentCoursePK = studentCoursePK;
    }

    public Date getRegistationDate() {
        return registationDate;
    }

    public void setRegistationDate(Date registationDate) {
        this.registationDate = registationDate;
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentCoursePK != null ? studentCoursePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentCourse)) {
            return false;
        }
        StudentCourse other = (StudentCourse) object;
        if ((this.studentCoursePK == null && other.studentCoursePK != null) || (this.studentCoursePK != null && !this.studentCoursePK.equals(other.studentCoursePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.StudentCourse[ studentCoursePK=" + studentCoursePK + " ]";
    }
    
}

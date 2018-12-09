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
@Table(name = "lecturer_payments", catalog = "institute_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "LecturerPayments.findAll", query = "SELECT l FROM LecturerPayments l")})
public class LecturerPayments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lecturer_id")
    private int lecturerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "payment_month")
    private String paymentMonth;
    @Basic(optional = false)
    @NotNull
    @Column(name = "patment_year")
    private int patmentYear;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "course_id")
    private String courseId;

    public LecturerPayments() {
    }

    public LecturerPayments(Integer id) {
        this.id = id;
    }

    public LecturerPayments(Integer id, int lecturerId, double amount, Date date, String paymentMonth, int patmentYear, String courseId) {
        this.id = id;
        this.lecturerId = lecturerId;
        this.amount = amount;
        this.date = date;
        this.paymentMonth = paymentMonth;
        this.patmentYear = patmentYear;
        this.courseId = courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentMonth() {
        return paymentMonth;
    }

    public void setPaymentMonth(String paymentMonth) {
        this.paymentMonth = paymentMonth;
    }

    public int getPatmentYear() {
        return patmentYear;
    }

    public void setPatmentYear(int patmentYear) {
        this.patmentYear = patmentYear;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LecturerPayments)) {
            return false;
        }
        LecturerPayments other = (LecturerPayments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.LecturerPayments[ id=" + id + " ]";
    }
    
}

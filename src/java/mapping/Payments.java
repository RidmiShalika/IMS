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
@Table(name = "payments", catalog = "institute_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "Payments.findAll", query = "SELECT p FROM Payments p")})
public class Payments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 110)
    @Column(name = "s_id")
    private String sId;
    @Size(max = 110)
    @Column(name = "course_id")
    private String courseId;
    @Size(max = 110)
    @Column(name = "year")
    private String year;
    @Size(max = 25)
    @Column(name = "month")
    private String month;
    @Size(max = 50)
    @Column(name = "date")
    private String date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "amount")
    private Double amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "paid_to_lecture")
    private boolean paidToLecture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_issue_date")
    @Temporal(TemporalType.DATE)
    private Date paymentIssueDate;
    @Size(max = 100)
    @Column(name = "payment_issue_month")
    private String paymentIssueMonth;
    @Size(max = 100)
    @Column(name = "payment_issue_year")
    private String paymentIssueYear;

    public Payments() {
    }

    public Payments(Integer id) {
        this.id = id;
    }

    public Payments(Integer id, boolean paidToLecture, Date paymentIssueDate) {
        this.id = id;
        this.paidToLecture = paidToLecture;
        this.paymentIssueDate = paymentIssueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSId() {
        return sId;
    }

    public void setSId(String sId) {
        this.sId = sId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public boolean getPaidToLecture() {
        return paidToLecture;
    }

    public void setPaidToLecture(boolean paidToLecture) {
        this.paidToLecture = paidToLecture;
    }

    public Date getPaymentIssueDate() {
        return paymentIssueDate;
    }

    public void setPaymentIssueDate(Date paymentIssueDate) {
        this.paymentIssueDate = paymentIssueDate;
    }

    public String getPaymentIssueMonth() {
        return paymentIssueMonth;
    }

    public void setPaymentIssueMonth(String paymentIssueMonth) {
        this.paymentIssueMonth = paymentIssueMonth;
    }

    public String getPaymentIssueYear() {
        return paymentIssueYear;
    }

    public void setPaymentIssueYear(String paymentIssueYear) {
        this.paymentIssueYear = paymentIssueYear;
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
        if (!(object instanceof Payments)) {
            return false;
        }
        Payments other = (Payments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.Payments[ id=" + id + " ]";
    }
    
}

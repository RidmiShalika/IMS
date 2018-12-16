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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Ridmi Shalika
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
    @Column(name = "paid_to_lecture")
    private Boolean paidToLecture;
    @Column(name = "payment_issue_date")
    @Temporal(TemporalType.DATE)
    private Date paymentIssueDate;
    @Size(max = 100)
    @Column(name = "payment_issue_month")
    private String paymentIssueMonth;
    @Size(max = 100)
    @Column(name = "payment_issue_year")
    private String paymentIssueYear;
    @Column(name = "card_type")
    private Integer cardType;
    @JoinColumn(name = "student_id", referencedColumnName = "S_ID")
    @ManyToOne(optional = false)
    private Student studentId;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Course courseId;

    public Payments() {
    }

    public Payments(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Boolean getPaidToLecture() {
        return paidToLecture;
    }

    public void setPaidToLecture(Boolean paidToLecture) {
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

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
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

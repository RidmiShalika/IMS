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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ridmi Shalika
 */
@Entity
@Table(name = "advance_payments", catalog = "institute_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "AdvancePayments.findAll", query = "SELECT a FROM AdvancePayments a")})
public class AdvancePayments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @Size(min = 1, max = 20)
    @Column(name = "status")
    private String status;
    @Column(name = "settle_date")
    @Temporal(TemporalType.DATE)
    private Date settleDate;
    @Size(max = 20)
    @Column(name = "settled_payment_month")
    private String settledPaymentMonth;
    @Column(name = "settled_payment_year")
    private Integer settledPaymentYear;
    @JoinColumn(name = "lec_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Lecturer lecId;

    public AdvancePayments() {
    }

    public AdvancePayments(Integer id) {
        this.id = id;
    }

    public AdvancePayments(Integer id, double amount, Date date, String status) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    public String getSettledPaymentMonth() {
        return settledPaymentMonth;
    }

    public void setSettledPaymentMonth(String settledPaymentMonth) {
        this.settledPaymentMonth = settledPaymentMonth;
    }

    public Integer getSettledPaymentYear() {
        return settledPaymentYear;
    }

    public void setSettledPaymentYear(Integer settledPaymentYear) {
        this.settledPaymentYear = settledPaymentYear;
    }

    public Lecturer getLecId() {
        return lecId;
    }

    public void setLecId(Lecturer lecId) {
        this.lecId = lecId;
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
        if (!(object instanceof AdvancePayments)) {
            return false;
        }
        AdvancePayments other = (AdvancePayments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.AdvancePayments[ id=" + id + " ]";
    }
    
}

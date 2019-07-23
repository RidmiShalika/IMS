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
 * @author Ridmi Shalika
 */
@Entity
@Table(name = "pending_payments", catalog = "institute_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "PendingPayments.findAll", query = "SELECT p FROM PendingPayments p")})
public class PendingPayments implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "card_type")
    private int cardType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "class_fee")
    private double classFee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "elegible_fee")
    private double elegibleFee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sid")
    private int sid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cid")
    private int cid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "month")
    private String month;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "year")
    private String year;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status")
    private String status;

    public PendingPayments() {
    }

    public PendingPayments(Integer id) {
        this.id = id;
    }

    public PendingPayments(Integer id, int sid, int cid, String month, String year, String status) {
        this.id = id;
        this.sid = sid;
        this.cid = cid;
        this.month = month;
        this.year = year;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PendingPayments)) {
            return false;
        }
        PendingPayments other = (PendingPayments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.PendingPayments[ id=" + id + " ]";
    }

    public int getCardType() {
        return cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public double getClassFee() {
        return classFee;
    }

    public void setClassFee(double classFee) {
        this.classFee = classFee;
    }

    public double getElegibleFee() {
        return elegibleFee;
    }

    public void setElegibleFee(double elegibleFee) {
        this.elegibleFee = elegibleFee;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
}

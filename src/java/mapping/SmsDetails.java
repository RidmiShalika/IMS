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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ridmi Shalika
 */
@Entity
@Table(name = "sms_details", schema = "")
@NamedQueries({
    @NamedQuery(name = "SmsDetails.findAll", query = "SELECT s FROM SmsDetails s")})
public class SmsDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "s_id")
    private String sId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50000)
    @Column(name = "body")
    private String body;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "mobile")
    private String mobile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "created_date")
    private String createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "retry_attempts")
    private int retryAttempts;
    @Basic(optional = false)
    @Size(min = 1, max = 30)
    @Column(name = "send_date")
    private String sendDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;

    public SmsDetails() {
    }

    public SmsDetails(Integer id) {
        this.id = id;
    }

    public SmsDetails(Integer id, String sId, String body, String mobile, String createdDate, int retryAttempts, String sendDate, int status) {
        this.id = id;
        this.sId = sId;
        this.body = body;
        this.mobile = mobile;
        this.createdDate = createdDate;
        this.retryAttempts = retryAttempts;
        this.sendDate = sendDate;
        this.status = status;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(int retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
        if (!(object instanceof SmsDetails)) {
            return false;
        }
        SmsDetails other = (SmsDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.SmsDetails[ id=" + id + " ]";
    }
    
}

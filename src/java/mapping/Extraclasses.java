/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ridmi_g
 */
@Entity
@Table(name = "extraclasses", catalog = "institute_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "Extraclasses.findAll", query = "SELECT e FROM Extraclasses e")})
public class Extraclasses implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ExtraclassesPK extraclassesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "endTime")
    private String endTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "status")
    private String status;

    public Extraclasses() {
    }

    public Extraclasses(ExtraclassesPK extraclassesPK) {
        this.extraclassesPK = extraclassesPK;
    }

    public Extraclasses(ExtraclassesPK extraclassesPK, String endTime, String status) {
        this.extraclassesPK = extraclassesPK;
        this.endTime = endTime;
        this.status = status;
    }

    public Extraclasses(String courseID, String date, String startTime) {
        this.extraclassesPK = new ExtraclassesPK(courseID, date, startTime);
    }

    public ExtraclassesPK getExtraclassesPK() {
        return extraclassesPK;
    }

    public void setExtraclassesPK(ExtraclassesPK extraclassesPK) {
        this.extraclassesPK = extraclassesPK;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
        hash += (extraclassesPK != null ? extraclassesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Extraclasses)) {
            return false;
        }
        Extraclasses other = (Extraclasses) object;
        if ((this.extraclassesPK == null && other.extraclassesPK != null) || (this.extraclassesPK != null && !this.extraclassesPK.equals(other.extraclassesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.Extraclasses[ extraclassesPK=" + extraclassesPK + " ]";
    }
    
}

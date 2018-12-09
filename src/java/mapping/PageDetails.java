/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ridmi_g
 */
@Entity
@Table(name = "page_details", catalog = "institute_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "PageDetails.findAll", query = "SELECT p FROM PageDetails p")})
public class PageDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "page_id")
    private Integer pageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "page_description")
    private String pageDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pageId")
    private Set<Privileges> privilegesSet;
     @Column(name = "url")
    private String url;

    public PageDetails() {
    }

    public PageDetails(Integer pageId) {
        this.pageId = pageId;
    }

    public PageDetails(Integer pageId, String pageDescription) {
        this.pageId = pageId;
        this.pageDescription = pageDescription;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }

    public Set<Privileges> getPrivilegesSet() {
        return privilegesSet;
    }

    public void setPrivilegesSet(Set<Privileges> privilegesSet) {
        this.privilegesSet = privilegesSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pageId != null ? pageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PageDetails)) {
            return false;
        }
        PageDetails other = (PageDetails) object;
        if ((this.pageId == null && other.pageId != null) || (this.pageId != null && !this.pageId.equals(other.pageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.PageDetails[ pageId=" + pageId + " ]";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}

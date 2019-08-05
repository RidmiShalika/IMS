/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ridmi Shalika
 */
@Entity
@Table(name = "lecturer", schema = "")
@NamedQueries({
    @NamedQuery(name = "Lecturer.findAll", query = "SELECT l FROM Lecturer l")})
public class Lecturer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 10)
    @Column(name = "nic")
    private String nic;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 40)
    @Column(name = "email")
    private String email;
    @Size(max = 11)
    @Column(name = "contact")
    private String contact;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gender")
    private int gender;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Column(name = "regDate")
    @Temporal(TemporalType.DATE)
    private Date regDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "title")
    private int title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lecId")
    private Set<AdvancePayments> advancePaymentsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lectureId")
    private Set<LecturePayment> lecturePaymentSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lectureId")
    private Set<Course> courseSet;

    public Lecturer() {
    }

    public Lecturer(Integer id) {
        this.id = id;
    }

    public Lecturer(Integer id, String name, int gender, String firstName, int title) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.firstName = firstName;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public Set<AdvancePayments> getAdvancePaymentsSet() {
        return advancePaymentsSet;
    }

    public void setAdvancePaymentsSet(Set<AdvancePayments> advancePaymentsSet) {
        this.advancePaymentsSet = advancePaymentsSet;
    }

    public Set<LecturePayment> getLecturePaymentSet() {
        return lecturePaymentSet;
    }

    public void setLecturePaymentSet(Set<LecturePayment> lecturePaymentSet) {
        this.lecturePaymentSet = lecturePaymentSet;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
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
        if (!(object instanceof Lecturer)) {
            return false;
        }
        Lecturer other = (Lecturer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.Lecturer[ id=" + id + " ]";
    }
    
}

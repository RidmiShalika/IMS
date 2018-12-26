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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Ridmi Shalika
 */
@Entity
@Table(name = "student", catalog = "institute_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")})
public class Student implements Serializable {

    @Lob
    @Column(name = "S_IMAGE")
    private byte[] sImage;

    private static final long serialVersionUID = 1L;
    @Size(max = 100)
    @Column(name = "S_NAME")
    private String sName;
    @Size(max = 20)
    @Column(name = "S_DOB")
    private String sDob;
    @Size(max = 150)
    @Column(name = "S_ADDRESS")
    private String sAddress;
    @Size(max = 50)
    @Column(name = "S_EMAIL")
    private String sEmail;
    @Size(max = 10)
    @Column(name = "S_GENDER")
    private String sGender;
    @Size(max = 20)
    @Column(name = "S_YOR")
    private String sYor;
    @Size(max = 10)
    @Column(name = "S_TELEPHONE")
    private String sTelephone;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "S_ID")
    private Integer sId;
    @Size(max = 10)
    @Column(name = "S_PARENT_CONTACT_NO")
    private String sParentContactNo;
    @Size(max = 50)
    @Column(name = "S_PARENT_EMAIL")
    private String sParentEmail;
    @Size(max = 100)
    @Column(name = "S_PARENT_NAME")
    private String sParentName;
    @Size(max = 20)
    @Column(name = "S_NIC")
    private String sNic;
    @Size(max = 100)
    @Column(name = "S_FIRSTNAME")
    private String sFirstname;
    @Size(max = 100)
    @Column(name = "card_number")
    private String cardNumber;
    @JoinColumn(name = "S_SCHOOL", referencedColumnName = "school_id")
    @ManyToOne(optional = false)
    private School sSchool;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Set<Payments> paymentsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sId")
    private Set<Admission> admissionSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Set<PaymentBillDetails> paymentBillDetailsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Set<Attendence> attendenceSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId")
    private Set<StudentCourse> studentCourseSet;

    public Student() {
    }

    public Student(Integer sId) {
        this.sId = sId;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSDob() {
        return sDob;
    }

    public void setSDob(String sDob) {
        this.sDob = sDob;
    }

    public String getSAddress() {
        return sAddress;
    }

    public void setSAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getSEmail() {
        return sEmail;
    }

    public void setSEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getSGender() {
        return sGender;
    }

    public void setSGender(String sGender) {
        this.sGender = sGender;
    }

    public String getSYor() {
        return sYor;
    }

    public void setSYor(String sYor) {
        this.sYor = sYor;
    }

    public String getSTelephone() {
        return sTelephone;
    }

    public void setSTelephone(String sTelephone) {
        this.sTelephone = sTelephone;
    }

    public Integer getSId() {
        return sId;
    }

    public void setSId(Integer sId) {
        this.sId = sId;
    }

    public String getSParentContactNo() {
        return sParentContactNo;
    }

    public void setSParentContactNo(String sParentContactNo) {
        this.sParentContactNo = sParentContactNo;
    }

    public String getSParentEmail() {
        return sParentEmail;
    }

    public void setSParentEmail(String sParentEmail) {
        this.sParentEmail = sParentEmail;
    }

    public String getSParentName() {
        return sParentName;
    }

    public void setSParentName(String sParentName) {
        this.sParentName = sParentName;
    }

    public byte[] getSImage() {
        return sImage;
    }

    public void setSImage(byte[] sImage) {
        this.sImage = sImage;
    }

    public String getSNic() {
        return sNic;
    }

    public void setSNic(String sNic) {
        this.sNic = sNic;
    }

    public String getSFirstname() {
        return sFirstname;
    }

    public void setSFirstname(String sFirstname) {
        this.sFirstname = sFirstname;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public School getSSchool() {
        return sSchool;
    }

    public void setSSchool(School sSchool) {
        this.sSchool = sSchool;
    }

    public Set<Payments> getPaymentsSet() {
        return paymentsSet;
    }

    public void setPaymentsSet(Set<Payments> paymentsSet) {
        this.paymentsSet = paymentsSet;
    }

    public Set<Admission> getAdmissionSet() {
        return admissionSet;
    }

    public void setAdmissionSet(Set<Admission> admissionSet) {
        this.admissionSet = admissionSet;
    }

    public Set<PaymentBillDetails> getPaymentBillDetailsSet() {
        return paymentBillDetailsSet;
    }

    public void setPaymentBillDetailsSet(Set<PaymentBillDetails> paymentBillDetailsSet) {
        this.paymentBillDetailsSet = paymentBillDetailsSet;
    }

    public Set<Attendence> getAttendenceSet() {
        return attendenceSet;
    }

    public void setAttendenceSet(Set<Attendence> attendenceSet) {
        this.attendenceSet = attendenceSet;
    }

    public Set<StudentCourse> getStudentCourseSet() {
        return studentCourseSet;
    }

    public void setStudentCourseSet(Set<StudentCourse> studentCourseSet) {
        this.studentCourseSet = studentCourseSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sId != null ? sId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.sId == null && other.sId != null) || (this.sId != null && !this.sId.equals(other.sId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.Student[ sId=" + sId + " ]";
    }

    

   
    
}

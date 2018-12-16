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
@Table(name = "course", catalog = "institute_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "course_unique_id")
    private String courseUniqueId;
    @Size(max = 200)
    @Column(name = "course_description")
    private String courseDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_course_fee")
    private Double totalCourseFee;
    @Column(name = "monthly_fee")
    private Double monthlyFee;
    @Size(max = 50)
    @Column(name = "course_duration")
    private String courseDuration;
    @Column(name = "lec_hall_id")
    private Integer lecHallId;
    @Column(name = "grade")
    private Integer grade;
    @Column(name = "medium")
    private Integer medium;
    @Column(name = "class_type")
    private Integer classType;
    @Column(name = "batch_no")
    private Integer batchNo;
    @Column(name = "lec_payment_percentage")
    private Double lecPaymentPercentage;
    @Size(max = 10)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Set<ClassConductDetails> classConductDetailsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Set<LecturePayment> lecturePaymentSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Set<Payments> paymentsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Set<PaymentBillDetails> paymentBillDetailsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Set<CourseDates> courseDatesSet;
    @JoinColumn(name = "subject_id", referencedColumnName = "SUBJECT_ID")
    @ManyToOne(optional = false)
    private Subject subjectId;
    @JoinColumn(name = "lecture_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Lecturer lectureId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Set<Attendence> attendenceSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Set<ExtraClasses> extraClassesSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private Set<StudentCourse> studentCourseSet;

    public Course() {
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseUniqueId() {
        return courseUniqueId;
    }

    public void setCourseUniqueId(String courseUniqueId) {
        this.courseUniqueId = courseUniqueId;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Double getTotalCourseFee() {
        return totalCourseFee;
    }

    public void setTotalCourseFee(Double totalCourseFee) {
        this.totalCourseFee = totalCourseFee;
    }

    public Double getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(Double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Integer getLecHallId() {
        return lecHallId;
    }

    public void setLecHallId(Integer lecHallId) {
        this.lecHallId = lecHallId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getMedium() {
        return medium;
    }

    public void setMedium(Integer medium) {
        this.medium = medium;
    }

    public Integer getClassType() {
        return classType;
    }

    public void setClassType(Integer classType) {
        this.classType = classType;
    }

    public Integer getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Integer batchNo) {
        this.batchNo = batchNo;
    }

    public Double getLecPaymentPercentage() {
        return lecPaymentPercentage;
    }

    public void setLecPaymentPercentage(Double lecPaymentPercentage) {
        this.lecPaymentPercentage = lecPaymentPercentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ClassConductDetails> getClassConductDetailsSet() {
        return classConductDetailsSet;
    }

    public void setClassConductDetailsSet(Set<ClassConductDetails> classConductDetailsSet) {
        this.classConductDetailsSet = classConductDetailsSet;
    }

    public Set<LecturePayment> getLecturePaymentSet() {
        return lecturePaymentSet;
    }

    public void setLecturePaymentSet(Set<LecturePayment> lecturePaymentSet) {
        this.lecturePaymentSet = lecturePaymentSet;
    }

    public Set<Payments> getPaymentsSet() {
        return paymentsSet;
    }

    public void setPaymentsSet(Set<Payments> paymentsSet) {
        this.paymentsSet = paymentsSet;
    }

    public Set<PaymentBillDetails> getPaymentBillDetailsSet() {
        return paymentBillDetailsSet;
    }

    public void setPaymentBillDetailsSet(Set<PaymentBillDetails> paymentBillDetailsSet) {
        this.paymentBillDetailsSet = paymentBillDetailsSet;
    }

    public Set<CourseDates> getCourseDatesSet() {
        return courseDatesSet;
    }

    public void setCourseDatesSet(Set<CourseDates> courseDatesSet) {
        this.courseDatesSet = courseDatesSet;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    public Lecturer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Lecturer lectureId) {
        this.lectureId = lectureId;
    }

    public Set<Attendence> getAttendenceSet() {
        return attendenceSet;
    }

    public void setAttendenceSet(Set<Attendence> attendenceSet) {
        this.attendenceSet = attendenceSet;
    }

    public Set<ExtraClasses> getExtraClassesSet() {
        return extraClassesSet;
    }

    public void setExtraClassesSet(Set<ExtraClasses> extraClassesSet) {
        this.extraClassesSet = extraClassesSet;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.Course[ id=" + id + " ]";
    }
    
}

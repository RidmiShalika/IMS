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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "course", catalog = "institute_management", schema = "")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "course_id")
    private String courseId;
    @Size(max = 200)
    @Column(name = "course_description")
    private String courseDescription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_course_fee")
    private Double totalCourseFee;
    @Column(name = "monthly_fee")
    private Double monthlyFee;
    @Column(name = "course_duration")
    private Integer courseDuration;
    @Column(name = "lecture_hole_id")
    private Integer lectureHoleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "grade")
    private String grade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "class_type")
    private String classType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "medium")
    private String medium;
    @Basic(optional = false)
    @NotNull
    @Column(name = "batch_number")
    private int batchNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lecturer_payment_precentage")
    private double lecturerPaymentPrecentage;
    @JoinColumn(name = "lecturer_id", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Lecturer lecturerId;
    @JoinColumn(name = "subject_id", referencedColumnName = "SUBJECT_ID")
    @ManyToOne(optional = false)
    private Subject subjectId;

    public Course() {
    }

    public Course(String courseId) {
        this.courseId = courseId;
    }

    public Course(String courseId, String grade, String classType, String medium, int batchNumber, double lecturerPaymentPrecentage) {
        this.courseId = courseId;
        this.grade = grade;
        this.classType = classType;
        this.medium = medium;
        this.batchNumber = batchNumber;
        this.lecturerPaymentPrecentage = lecturerPaymentPrecentage;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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

    public Integer getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(Integer courseDuration) {
        this.courseDuration = courseDuration;
    }

    public Integer getLectureHoleId() {
        return lectureHoleId;
    }

    public void setLectureHoleId(Integer lectureHoleId) {
        this.lectureHoleId = lectureHoleId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public double getLecturerPaymentPrecentage() {
        return lecturerPaymentPrecentage;
    }

    public void setLecturerPaymentPrecentage(double lecturerPaymentPrecentage) {
        this.lecturerPaymentPrecentage = lecturerPaymentPrecentage;
    }

    public Lecturer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Lecturer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mapping.Course[ courseId=" + courseId + " ]";
    }
    
}

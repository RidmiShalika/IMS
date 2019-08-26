/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.bean;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ridmi_g
 */
public class StudentBean {

    /**
     * @return the viewImage
     */
   
    /**
     * @return the upimageContentType
     */
    
    

    

    private String sName;
    private String sDob;
    private String sAddress;
    private String sEmail;
    private String sGender;
    private String sYor;
    private String sTelephone;
    private String sSchool;
    private String sId;
    private String sParentContactNo;
    private String sParentEmail;
    private String sParentName;
    private byte[] sImage;
    private String viewImage;
    private String sImageContentType;
    private String sImageFileName;
    private String sNic;
    private String sFirstname;
    private String cardNumber;
    private Map<Integer, String> schoolList = new HashMap<Integer, String>();
    private Map<Integer, String> genderlList = new HashMap<Integer, String>();

    private long fullCount;

    //Table data
    private List<StudentBean> gridModel = new ArrayList<StudentBean>();
    private Integer rows = 0;
    private Integer page = 0;
    private Integer total = 0;
    private Long records = 0L;
    private String sord;
    private String sidx;

    //Add data
    private String name;
    private String firstname;
    private String address;
    private String email;
    private String gender;
    private String yearOfRegistration;
    private String telephone;
    private String school;
    private String birthday;
    private String parentContactNo;
    private String cardno;
    private File addimage;
   
	private String addimageContentType;
	private String addimageFileName;
    private String tt;
    

    //Edit data
    private String upname;
    private String upfirstname;
    private String upaddress;
    private String upemail;
    private String upgender;
    private String upyearOfRegistration;
    private String uptelephone;
    private String upschool;
    private String upbirthday;
    private String upparentContactNo;
    private String upcardno;
    private File upimage;
    private String upimageContentType;
	private String upimageFileName;

    private String id;
    private String upId;
    private int  studentId;
    private int stuId;
    
    
    private String card_id;
    private String upcardId;
    private String upasscard_type;
    
     private Map<Integer, String>  subList = new HashMap<Integer, String>();
     private Map<Integer, String>  gradeList = new HashMap<Integer, String>();
//     private Map<Integer, String>  corList = new HashMap<Integer, String>();
     private Map<Integer, String>  cardTypeList = new HashMap<Integer, String>();
     private ArrayList<CoData> corList = new ArrayList<CoData>();
     private String assgrade;
     private String assSubject;
     private String assCourse;
     private String course_fee;
     private String course_duration;
     private String asscard_type;
     
    private String s_c_id;
    private String s_c_courseId;
    private String s_c_cardType;
    private String s_c_status;
    
    private String message;
    private boolean success;
     
    //payment
    private String pay_status;
    private String payment_date;
    private String payment_amount;
    
    private String grade_id;
    private String sub_id;
    
    //search data
    private String searchname;

    public File getUpimage() {
        return upimage;
    }

    public void setUpimage(File upimage) {
        this.upimage = upimage;
    }
    
    public String getUpimageContentType() {
        return upimageContentType;
    }

    public void setUpimageContentType(String upimageContentType) {
        this.upimageContentType = upimageContentType;
    }

    public String getUpimageFileName() {
        return upimageFileName;
    }

    public void setUpimageFileName(String upimageFileName) {
        this.upimageFileName = upimageFileName;
    }
     public String getViewImage() {
        return viewImage;
    }

    public void setViewImage(String viewImage) {
        this.viewImage = "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";
    }


    
    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getUpcardId() {
        return upcardId;
    }

    public void setUpcardId(String upcardId) {
        this.upcardId = upcardId;
    }

    public String getUpasscard_type() {
        return upasscard_type;
    }

    public void setUpasscard_type(String upasscard_type) {
        this.upasscard_type = upasscard_type;
    }

    
    public String getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(String grade_id) {
        this.grade_id = grade_id;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    
    public File getAddimage() {
        return addimage;
    }

    public void setAddimage(File addimage) {
        this.addimage = addimage;
    }

    public String getAddimageContentType() {
        return addimageContentType;
    }

    public void setAddimageContentType(String addimageContentType) {
        this.addimageContentType = addimageContentType;
    }

    public String getAddimageFileName() {
        return addimageFileName;
    }

    public void setAddimageFileName(String addimageFileName) {
        this.addimageFileName = addimageFileName;
    }
    
    
    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }

    
    
    public String getPay_status() {
        return pay_status;
    }

    public void setPay_status(String pay_status) {
        this.pay_status = pay_status;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(String payment_amount) {
        this.payment_amount = payment_amount;
    }

    
    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    
    public String getS_c_id() {
        return s_c_id;
    }

    public void setS_c_id(String s_c_id) {
        this.s_c_id = s_c_id;
    }

    public String getS_c_courseId() {
        return s_c_courseId;
    }

    public void setS_c_courseId(String s_c_courseId) {
        this.s_c_courseId = s_c_courseId;
    }

    public String getS_c_cardType() {
        return s_c_cardType;
    }

    public void setS_c_cardType(String s_c_cardType) {
        this.s_c_cardType = s_c_cardType;
    }

    public String getS_c_status() {
        return s_c_status;
    }

    public void setS_c_status(String s_c_status) {
        this.s_c_status = s_c_status;
    }

    public Map<Integer, String> getCardTypeList() {
        return cardTypeList;
    }

    public void setCardTypeList(Map<Integer, String> cardTypeList) {
        this.cardTypeList = cardTypeList;
    }

    public String getAssCourse() {
        return assCourse;
    }

    public void setAssCourse(String assCourse) {
        this.assCourse = assCourse;
    }

    public String getCourse_fee() {
        return course_fee;
    }

    public void setCourse_fee(String course_fee) {
        this.course_fee = course_fee;
    }

    public String getCourse_duration() {
        return course_duration;
    }

    public void setCourse_duration(String course_duration) {
        this.course_duration = course_duration;
    }

    public String getAsscard_type() {
        return asscard_type;
    }

    public void setAsscard_type(String asscard_type) {
        this.asscard_type = asscard_type;
    }

    
    public Map<Integer, String> getGradeList() {
        return gradeList;
    }

    public void setGradeList(Map<Integer, String> gradeList) {
        this.gradeList = gradeList;
    }

    public String getAssgrade() {
        return assgrade;
    }

    public void setAssgrade(String assgrade) {
        this.assgrade = assgrade;
    }

    public String getAssSubject() {
        return assSubject;
    }

    public void setAssSubject(String assSubject) {
        this.assSubject = assSubject;
    }

    
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    
    public String getUpId() {
        return upId;
    }

    public void setUpId(String upId) {
        this.upId = upId;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public Map<Integer, String> getGenderlList() {
        return genderlList;
    }

    public void setGenderlList(Map<Integer, String> genderlList) {
        this.genderlList = genderlList;
    }

    public Map<Integer, String> getSchoolList() {
        return schoolList;
    }

    public void setSchoolList(Map<Integer, String> schoolList) {
        this.schoolList = schoolList;
    }

    public List<StudentBean> getGridModel() {
        return gridModel;
    }

    public void setGridModel(List<StudentBean> gridModel) {
        this.gridModel = gridModel;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Long getRecords() {
        return records;
    }

    public void setRecords(Long records) {
        this.records = records;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsDob() {
        return sDob;
    }

    public void setsDob(String sDob) {
        this.sDob = sDob;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsGender() {
        return sGender;
    }

    public void setsGender(String sGender) {
        this.sGender = sGender;
    }

    public String getsYor() {
        return sYor;
    }

    public void setsYor(String sYor) {
        this.sYor = sYor;
    }

    public String getsTelephone() {
        return sTelephone;
    }

    public void setsTelephone(String sTelephone) {
        this.sTelephone = sTelephone;
    }

    public String getsSchool() {
        return sSchool;
    }

    public void setsSchool(String sSchool) {
        this.sSchool = sSchool;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsParentContactNo() {
        return sParentContactNo;
    }

    public void setsParentContactNo(String sParentContactNo) {
        this.sParentContactNo = sParentContactNo;
    }

    public String getsParentEmail() {
        return sParentEmail;
    }

    public void setsParentEmail(String sParentEmail) {
        this.sParentEmail = sParentEmail;
    }

    public String getsParentName() {
        return sParentName;
    }

    public void setsParentName(String sParentName) {
        this.sParentName = sParentName;
    }

    public byte[] getsImage() {
        return sImage;
    }

    public void setsImage(byte[] sImage) {
        this.sImage = sImage;
    }
    
    
    
    

    public String getsNic() {
        return sNic;
    }

    public void setsNic(String sNic) {
        this.sNic = sNic;
    }

    public String getsFirstname() {
        return sFirstname;
    }

    public void setsFirstname(String sFirstname) {
        this.sFirstname = sFirstname;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getFullCount() {
        return fullCount;
    }

    public void setFullCount(long fullCount) {
        this.fullCount = fullCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getYearOfRegistration() {
        return yearOfRegistration;
    }

    public void setYearOfRegistration(String yearOfRegistration) {
        this.yearOfRegistration = yearOfRegistration;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getParentContactNo() {
        return parentContactNo;
    }

    public void setParentContactNo(String parentContactNo) {
        this.parentContactNo = parentContactNo;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getUpname() {
        return upname;
    }

    public void setUpname(String upname) {
        this.upname = upname;
    }

    public String getUpfirstname() {
        return upfirstname;
    }

    public void setUpfirstname(String upfirstname) {
        this.upfirstname = upfirstname;
    }

    public String getUpaddress() {
        return upaddress;
    }

    public void setUpaddress(String upaddress) {
        this.upaddress = upaddress;
    }

    public String getUpemail() {
        return upemail;
    }

    public void setUpemail(String upemail) {
        this.upemail = upemail;
    }

    public String getUpgender() {
        return upgender;
    }

    public void setUpgender(String upgender) {
        this.upgender = upgender;
    }

    public String getUpyearOfRegistration() {
        return upyearOfRegistration;
    }

    public void setUpyearOfRegistration(String upyearOfRegistration) {
        this.upyearOfRegistration = upyearOfRegistration;
    }

    public String getUptelephone() {
        return uptelephone;
    }

    public void setUptelephone(String uptelephone) {
        this.uptelephone = uptelephone;
    }

    public String getUpschool() {
        return upschool;
    }

    public void setUpschool(String upschool) {
        this.upschool = upschool;
    }

    public String getUpbirthday() {
        return upbirthday;
    }

    public void setUpbirthday(String upbirthday) {
        this.upbirthday = upbirthday;
    }

    public String getUpparentContactNo() {
        return upparentContactNo;
    }

    public void setUpparentContactNo(String upparentContactNo) {
        this.upparentContactNo = upparentContactNo;
    }

    public String getUpcardno() {
        return upcardno;
    }

    public void setUpcardno(String upcardno) {
        this.upcardno = upcardno;
    }

    public String getSearchname() {
        return searchname;
    }

    public void setSearchname(String searchname) {
        this.searchname = searchname;
    }

    public Map<Integer, String> getSubList() {
        return subList;
    }

    public void setSubList(Map<Integer, String> subList) {
        this.subList = subList;
    }
    

//    public File getAddimage() {
//        return addimage;
//    }
//
//    public void setAddimage(File addimage) {
//        this.addimage = addimage;
//    }

    public ArrayList<CoData> getCorList() {
        return corList;
    }

    public void setCorList(ArrayList<CoData> corList) {
        this.corList = corList;
    }

    

    

}

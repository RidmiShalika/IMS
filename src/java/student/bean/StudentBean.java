/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ridmi_g
 */
public class StudentBean {
    
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
      private String sNic;
      private String sFirstname;
      private String cardNumber;
      private Map<Integer, String> schoolList = new HashMap<Integer, String>();
      private Map<Integer, String> genderlList = new HashMap<Integer, String>();
      
        private long fullCount;
    
    //Table data
    private List<StudentBean> gridModel= new ArrayList<StudentBean>();
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
    
    //search data
    private String searchname;

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
    
    
    
}

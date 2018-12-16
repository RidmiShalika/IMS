/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturer.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ridmi_g
 */
public class LecturerBean {

    private long fullCount;

    //Table data
    private List<LecturerBean> gridModel = new ArrayList<LecturerBean>();
    private Integer rows = 0;
    private Integer page = 0;
    private Integer total = 0;
    private Long records = 0L;
    private String sord;
    private String sidx;

    //search data
    private String searchname;

    // List data
    private String ID;
    private String nic;
    private String name;
    private String subject_code;
    private String email;
    private String contact;
    private String gender;
    private String address;
    private String regDate;
    private String firstname;
    private String title;

    // Add data
    private String addtitle;
    private String addfirstname;
    private String addaddress;
    private String addemail;
    private String addgender;
    private String addfullname ;
    private String addcontact ;
    private String addnic ;
    private String addsubject ;
    private Map<Integer, String> subjectList = new HashMap<Integer, String>(); 
    private Map<Integer, String> titleList = new HashMap<Integer, String>(); 
    private Map<Integer, String> genList = new HashMap<Integer, String>(); 
    
    
    // Edit data
    private String upname;
    private String upnic;
    private String upcontact;
    private String upemail;
    private String upgender;
    private String upsubject;
    private String upaddress;
    private String uplecid;
    private String uptitle;
    private String upfullname;

    public String getUpfullname() {
        return upfullname;
    }

    public void setUpfullname(String upfullname) {
        this.upfullname = upfullname;
    }

    
    public String getUptitle() {
        return uptitle;
    }

    public void setUptitle(String uptitle) {
        this.uptitle = uptitle;
    }

    
    public Map<Integer, String> getGenList() {
        return genList;
    }

    public void setGenList(Map<Integer, String> genList) {
        this.genList = genList;
    }

    
    public Map<Integer, String> getTitleList() {
        return titleList;
    }

    public void setTitleList(Map<Integer, String> titleList) {
        this.titleList = titleList;
    }

    
    public Map<Integer, String> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(Map<Integer, String> subjectList) {
        this.subjectList = subjectList;
    }
    
    

    public String getUplecid() {
        return uplecid;
    }

    public void setUplecid(String uplecid) {
        this.uplecid = uplecid;
    }
    
    

    public String getUpname() {
        return upname;
    }

    public void setUpname(String upname) {
        this.upname = upname;
    }

    public String getUpnic() {
        return upnic;
    }

    public void setUpnic(String upnic) {
        this.upnic = upnic;
    }

    public String getUpcontact() {
        return upcontact;
    }

    public void setUpcontact(String upcontact) {
        this.upcontact = upcontact;
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

    public String getUpsubject() {
        return upsubject;
    }

    public void setUpsubject(String upsubject) {
        this.upsubject = upsubject;
    }

    public String getUpaddress() {
        return upaddress;
    }

    public void setUpaddress(String upaddress) {
        this.upaddress = upaddress;
    }
    
    

    public String getAddtitle() {
        return addtitle;
    }

    public void setAddtitle(String addtitle) {
        this.addtitle = addtitle;
    }

    public String getAddfirstname() {
        return addfirstname;
    }

    public void setAddfirstname(String addfirstname) {
        this.addfirstname = addfirstname;
    }

    public String getAddaddress() {
        return addaddress;
    }

    public void setAddaddress(String addaddress) {
        this.addaddress = addaddress;
    }

    public String getAddemail() {
        return addemail;
    }

    public void setAddemail(String addemail) {
        this.addemail = addemail;
    }

    public String getAddgender() {
        return addgender;
    }

    public void setAddgender(String addgender) {
        this.addgender = addgender;
    }

    public String getAddfullname() {
        return addfullname;
    }

    public void setAddfullname(String addfullname) {
        this.addfullname = addfullname;
    }

    public String getAddcontact() {
        return addcontact;
    }

    public void setAddcontact(String addcontact) {
        this.addcontact = addcontact;
    }

    public String getAddnic() {
        return addnic;
    }

    public void setAddnic(String addnic) {
        this.addnic = addnic;
    }

    public String getAddsubject() {
        return addsubject;
    }

    public void setAddsubject(String addsubject) {
        this.addsubject = addsubject;
    }
    
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getSubject_code() {
        return subject_code;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getFullCount() {
        return fullCount;
    }

    public void setFullCount(long fullCount) {
        this.fullCount = fullCount;
    }

    public List<LecturerBean> getGridModel() {
        return gridModel;
    }

    public void setGridModel(List<LecturerBean> gridModel) {
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

    public String getSearchname() {
        return searchname;
    }

    public void setSearchname(String searchname) {
        this.searchname = searchname;
    }

}

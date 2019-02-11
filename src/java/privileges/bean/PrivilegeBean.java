/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privileges.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mapping.PageDetails;

/**
 *
 * @author ridmi_g
 */
public class PrivilegeBean {
    
    //Table data
    private List<PrivilegeBean> gridModel= new ArrayList<PrivilegeBean>();
    private Integer rows = 0;
    private Integer page = 0;
    private Integer total = 0;
    private Long records = 0L;
    private String sord;
    private String sidx;
    
     private String message;
    private boolean success;
    
     private long fullCount;
     
     //List data
     private String userRoleId;
     private String role;
     
     private String description;
     private String pageId;
     private Map<Integer, String> PageIdList = new HashMap<Integer, String>();
     
     //add data
     private String addname;
     private String addgender;
     private String addaddress;
     private String addnic;
     private String addcontact;
     private String addusername;
     private String adduserrole;
     private String addpassword;
     private String addconfirmpassword;
     private Map<Integer, String> userroleList = new HashMap<Integer, String>();
     private Map<Integer, String> genderlList = new HashMap<Integer, String>();
     private Map<Integer,String> alreadyAcsessPageMap = new HashMap<Integer, String>();

    public Map<Integer, String> getAlreadyAcsessPageMap() {
        return alreadyAcsessPageMap;
    }

    public void setAlreadyAcsessPageMap(Map<Integer, String> alreadyAcsessPageMap) {
        this.alreadyAcsessPageMap = alreadyAcsessPageMap;
    }

    
    public Map<Integer, String> getGenderlList() {
        return genderlList;
    }

    public void setGenderlList(Map<Integer, String> genderlList) {
        this.genderlList = genderlList;
    }
     
      
    public Map<Integer, String> getUserroleList() {
        return userroleList;
    }

    public void setUserroleList(Map<Integer, String> userroleList) {
        this.userroleList = userroleList;
    }
     public String getAddname() {
        return addname;
    }

    public void setAddname(String addname) {
        this.addname = addname;
    }

    public String getAddgender() {
        return addgender;
    }

    public void setAddgender(String addgender) {
        this.addgender = addgender;
    }

    public String getAddaddress() {
        return addaddress;
    }

    public void setAddaddress(String addaddress) {
        this.addaddress = addaddress;
    }

    public String getAddnic() {
        return addnic;
    }

    public void setAddnic(String addnic) {
        this.addnic = addnic;
    }

    public String getAddcontact() {
        return addcontact;
    }

    public void setAddcontact(String addcontact) {
        this.addcontact = addcontact;
    }

    public String getAddusername() {
        return addusername;
    }

    public void setAddusername(String addusername) {
        this.addusername = addusername;
    }

    public String getAdduserrole() {
        return adduserrole;
    }

    public void setAdduserrole(String adduserrole) {
        this.adduserrole = adduserrole;
    }

    public String getAddpassword() {
        return addpassword;
    }

    public void setAddpassword(String addpassword) {
        this.addpassword = addpassword;
    }

    public String getAddconfirmpassword() {
        return addconfirmpassword;
    }

    public void setAddconfirmpassword(String addconfirmpassword) {
        this.addconfirmpassword = addconfirmpassword;
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

       
    public Map<Integer, String> getPageIdList() {
        return PageIdList;
    }

    public void setPageIdList(Map<Integer, String> PageIdList) {
        this.PageIdList = PageIdList;
    }

     
    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }
  public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

     
    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

   

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
     
    public long getFullCount() {
        return fullCount;
    }

    public void setFullCount(long fullCount) {
        this.fullCount = fullCount;
    }

     
    public List<PrivilegeBean> getGridModel() {
        return gridModel;
    }

    public void setGridModel(List<PrivilegeBean> gridModel) {
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
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmailSMS.bean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ridmi_g
 */
public class EmailSmsBean {
    private Map<Integer, String> lectureNamelList = new HashMap<Integer, String>();

    public Map<Integer, String> getLectureNamelList() {
        return lectureNamelList;
    }

    public void setLectureNamelList(Map<Integer, String> lectureNamelList) {
        this.lectureNamelList = lectureNamelList;
    }
    
    
}

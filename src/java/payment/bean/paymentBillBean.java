/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payment.bean;

/**
 *
 * @author malindad
 */
public class paymentBillBean {

    
    
    //report data 
    private String BATCH_ID;
    private String COMPANY_NAME;
    private String RECEIVE_TIME;
    private String STATUS;
    private String COMPANY_MID;
    private String REG_DATE;
    

    public String getBATCH_ID() {
        return BATCH_ID;
    }

    public void setBATCH_ID(String BATCH_ID) {
        this.BATCH_ID = BATCH_ID;
    }

    public String getCOMPANY_NAME() {
        return COMPANY_NAME;
    }

    public void setCOMPANY_NAME(String COMPANY_NAME) {
        this.COMPANY_NAME = COMPANY_NAME;
    }

    public String getRECEIVE_TIME() {
        return RECEIVE_TIME;
    }

    public void setRECEIVE_TIME(String RECEIVE_TIME) {
        this.RECEIVE_TIME = RECEIVE_TIME;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

    public String getCOMPANY_MID() {
        return COMPANY_MID;
    }

    public void setCOMPANY_MID(String COMPANY_MID) {
        this.COMPANY_MID = COMPANY_MID;
    }

    public String getREG_DATE() {
        return REG_DATE;
    }

    public void setREG_DATE(String REG_DATE) {
        this.REG_DATE = REG_DATE;
    }
    
    

    /**
     * @return the line_id
     */
    public Integer getLine_id() {
        return line_id;
    }

    /**
     * @param line_id the line_id to set
     */
    public void setLine_id(Integer line_id) {
        this.line_id = line_id;
    }

    /**
     * @return the bill_id
     */
    public String getBill_id() {
        return bill_id;
    }

    /**
     * @param bill_id the bill_id to set
     */
    public void setBill_id(String bill_id) {
        this.bill_id = bill_id;
    }

    /**
     * @return the course_id
     */
    public String getCourse_id() {
        return course_id;
    }

    /**
     * @param course_id the course_id to set
     */
    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    /**
     * @return the bill_amount
     */
    public double getBill_amount() {
        return bill_amount;
    }

    /**
     * @param bill_amount the bill_amount to set
     */
    public void setBill_amount(double bill_amount) {
        this.bill_amount = bill_amount;
    }

    /**
     * @return the payment_month
     */
    public String getPayment_month() {
        return payment_month;
    }

    /**
     * @param payment_month the payment_month to set
     */
    public void setPayment_month(String payment_month) {
        this.payment_month = payment_month;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the s_id
     */
    public Integer getS_id() {
        return s_id;
    }

    /**
     * @param s_id the s_id to set
     */
    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    /**
     * @return the card_type
     */
    public String getCard_type() {
        return card_type;
    }

    /**
     * @param card_type the card_type to set
     */
    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    /**
     * @return the created_time
     */
    public String getCreated_time() {
        return created_time;
    }

    /**
     * @param created_time the created_time to set
     */
    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    /**
     * @return the issued_by
     */
    public String getIssued_by() {
        return issued_by;
    }

    /**
     * @param issued_by the issued_by to set
     */
    public void setIssued_by(String issued_by) {
        this.issued_by = issued_by;
    }

    /**
     * @return the s_name
     */
    public String getS_name() {
        return s_name;
    }

    /**
     * @param s_name the s_name to set
     */
    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    /**
     * @return the course_dis
     */
    public String getCourse_dis() {
        return course_dis;
    }

    /**
     * @param course_dis the course_dis to set
     */
    public void setCourse_dis(String course_dis) {
        this.course_dis = course_dis;
    }

    private Integer line_id;
    private String bill_id;
    private String course_id;
    private double bill_amount;
    private String payment_month;
    private String comments;
    private Integer s_id;
    private String card_type;
    private String created_time;
    private String issued_by;
    private String s_name;
    private String course_dis;
}

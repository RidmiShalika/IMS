<%-- 
    Document   : assignToCourse
    Created on : Dec 23, 2018, 3:51:38 PM
    Author     : Ridmi Shalika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="overflow:hidden" onload="load()">
        <section class="app-content">
            <div class="wrapper">
                <div class="body_content" id="includedContent" >
                    <div class="watermark"></div>
                    <!--<div class="heading">Register New Student</div>-->
                    <!--<div class="AddUser_box ">-->
                        <div class="message">         
                            <s:div id="divmsg1">
                                <i style="color: red">  <s:actionerror theme="jquery"/></i>
                                <i style="color: green"> <s:actionmessage theme="jquery"/></i>
                            </s:div>         
                        </div>
                        <div class="contentcenter">
                            <s:form  id="assignC"  theme="simple" method="post">
                                <table>
                                     <tr>
                                        <td class="formLable">Select Subject</td> <td >:</td>
                                         <td><s:select  name="assSubject" id="assSubject" list="%{subList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                        <td width="25px;"></td>
                                         <td class="formLable">Select Grade</td> <td >:</td>
                                        <td><s:select  name="assgrade" id="assgrade" list="%{gradeList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                    </tr>
                                     <tr>
                                        <td class="formLable">Select Course</td> <td >:</td>
                                         <td><s:select  name="assCourse" id="assCourse" list="%{corList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                        <td width="25px;"></td>
                                        <td class="formLable">Course Fee</td> <td >:</td>
                                        <td><s:textfield id="course_fee" name="course_fee"></s:textfield></td> 
                                    </tr>
                                    <tr>
                                        
                                       
                                        <td class="formLable">Course Duration</td> <td >:</td>
                                        <td><s:textfield id="course_duration" name="course_duration"></s:textfield></td> 
                                     <td width="25px;"></td>
                                    <td class="formLable">Card Type</td> <td >:</td>
                                         <td><s:select  name="asscard_type" id="asscard_type" list="%{cardTypeList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                    </tr>
                                
                                </table>
                                    <table>
                                    <tr>
                                        <td>
                                            <s:url var="assaddurl" action="assstudentToCr" />

                                            <sj:submit  id="assAddbtn" button="true" href="%{assaddurl}" value="Add"   targets="divmsg1" cssClass="button_aback"/> 
                                            <sj:submit button="true" value="Reset" cssClass="button_aback"/>
                                            </td>
                                        </tr>
                                    </table>
                            </s:form>
                           
                                        
                            

                        </div>
                        <div class="viewuser_tbl">
                            <div id="tablediv">
                                

                              
                                
                                <s:url var="listurl1" action="listCr"/>
                                <sjg:grid
                                    id="gridtable1"
                                    caption="Assign To Courses"
                                    cssStyle=""
                                    dataType="json"
                                    href="%{listurl1}"
                                    pager="true"
                                    gridModel="gridModel"
                                    rowList="10,15,20"
                                    rowNum="10"
                                    autowidth="true"
                                    shrinkToFit = "false"
                                    rownumbers="true"
                                    onCompleteTopics="completetopics"
                                    rowTotal="false"
                                    viewrecords="true"
                                    >

                                    <sjg:gridColumn name="s_c_id" index="id" title="Id" hidden="true"/>
                                    <sjg:gridColumn name="s_c_courseId" index="courseId" title="Course" hidden="true"/>
                                    <sjg:gridColumn name="s_c_cardType" index="cardType" title="Card Type" hidden="true"/>
                                    <sjg:gridColumn name="s_c_status" index="status" title="Status" hidden="true"/>
                                   

                                </sjg:grid> 
                            </div>
                        </div>
                    <!--</div>-->
                    </section>

                </div>

                </body>
</html>

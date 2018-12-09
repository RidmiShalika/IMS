<%-- 
    Document   : emailSms
    Created on : Oct 9, 2018, 11:57:35 AM
    Author     : ridmi_g
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Styles.jsp" />

        <script type="text/javascript">
            function display1() {
                alert("dis 1");
                $('#courseForm').show();
                $('#studentForm').hide();

            }
            function display2() {
                alert("dis 2");
//                document.getElementById("courseForm").style.display = "none";
//                document.getElementById("studentForm").style.display = "block";
                $("#courseForm").hide();
                $("#studentForm").show();
            }
//            $.subscribe('display1', function (event, data) {
//                alert("hjhj");
//                $ $('#courseForm').show();
//                $('#studentForm').hide();
//            });

            function ResetForm() {
                 $('#divmsg').empty();
                 
                $('#lectureName').val("-1");
                $('#courseId').val("");
                $('#courseName').val("");
                $('#msgSample').val("");
                $('#msg').val("");
                
               
            }
            function ResetForm1() {
                 $('#divmsg').empty();
                 
                $('#stdId').val("");
                $('#stdName').val("");
                $('#msgSample1').val("");
                $('#msg1').val("");
            }
        </script>
    </head>
    <body style="overflow:hidden" onload="load()">
        <section class="app-content">
            <jsp:include page="../../header.jsp" />    
            <div class="wrapper">
                <div class="body_content" id="includedContent" >
                    <div class="watermark"></div>
                    <div class="heading">Notifications</div>
                    <div class="AddUser_box ">
                        <div class="message">         
                            <s:div id="divmsg">
                                <i style="color: red">  <s:actionerror theme="jquery"/></i>
                                <i style="color: green"> <s:actionmessage theme="jquery"/></i>
                            </s:div>         
                        </div>
                        <div class="contentcenter">
                            

                            <s:form id="courseForm"  theme="simple" >
                                <table class="form_table">
                                     <tr>
                                         <td>
                                             <sj:submit id="btncourse" name="btncourse" cssClass="button_aback" value="Course Notification" cssStyle="width:200px" disabled="true"/>
                                         </td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Select lecture Name<span class="mandatory">*</span></td> <td >:</td>
                                        <td><s:select  name="lectureName" id="lectureName" list="%{lectureNamelList}" 
                                                   listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>                                   


                                    </tr> 
                                    <tr>
                                        <td class="formLable">Course ID</td> <td >:</td>
                                        <td><s:textfield id="courseId" name="courseId" cssClass="textField"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Course Name</td> <td >:</td>
                                        <td><s:textfield id="courseName" name="courseName" cssClass="textField"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Message Sample</td> <td >:</td>
                                        <td><s:textfield id="msgSample" name="msgSample" cssClass="textField"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Message</td> <td >:</td>
                                        <td><s:textarea id="msg" name="msg" cssClass="textField"/></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <s:url var="crsurl" action="SendCrs" />
                                            <sj:submit  id="sendbtn" button="true" href="%{crsurl}" value="Send"   targets="divmsg" cssClass="button_aback"/> 
                                            <sj:submit button="true" value="Reset"  onclick="ResetForm()" cssClass="button_aback"/>
                                        </td>
                                    </tr>
                                </table>

                            </s:form>

                            <s:form id="studentForm"  theme="simple" >
                                <table class="form_table">
                                   <tr>
                                         <td>
                                            <sj:submit id="btnstudent" name="btnstudent" cssClass="button_aback" value="Student Notification" cssStyle="width:200px" disabled="true"/>
                                         </td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Student ID</td> <td >:</td>
                                        <td><s:textfield id="stdId" name="stdId" cssClass="textField"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Student Name</td> <td >:</td>
                                        <td><s:textfield id="stdName" name="stdName" cssClass="textField"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Message Sample</td> <td >:</td>
                                        <td><s:textfield id="msgSample1" name="msgSample1" cssClass="textField"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Message</td> <td >:</td>
                                        <td><s:textarea id="msg1" name="msg1" cssClass="textField"/></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <s:url var="stdurl" action="SendStd" />
                                            <sj:submit  id="sendbtn1" button="true" href="%{stdurl}" value="Send"   targets="divmsg" cssClass="button_aback"/> 
                                            <sj:submit button="true" value="Reset"  onclick="ResetForm1()" cssClass="button_aback"/>
                                        </td>
                                    </tr>
                                </table>

                            </s:form>





                        </div>

                    </div>

                    </section>



                    </body>
                    </html>

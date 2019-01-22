
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Styles.jsp" />

        <script type="text/javascript">
            $(document).ready(function () {
                //load student and lecture details and mark attendence
                 $.ajax({
                    url: '${pageContext.request.contextPath}/loadandattendence',
                    dataType: "json",
                    type: "GET",
                    success: function (data) {
                       $('#name').val("data.pay_status");
                    },
                    error: function (data) {
                       
                    }
                });
            });

        </script>
    </head>
    <body style="overflow:hidden" onload="load()">
        <section class="app-content">
            <jsp:include page="../../header.jsp" />    
            <div class="wrapper">
                <div class="body_content" id="includedContent" >
                    <div class="watermark"></div>
                    <div class="heading">Attendance</div>
                    <div class="AddUser_box ">
                        <div class="message">         
                            <s:div id="divmsg">
                                <i style="color: red">  <s:actionerror theme="jquery"/></i>
                                <i style="color: green"> <s:actionmessage theme="jquery"/></i>
                            </s:div>         
                        </div>
                        <div style="width: 50%; float:left">
                            <s:form id="studentDetailsForm"  theme="simple" >
                                <table>
                                    <tr>
                                        <td class="formLable">Student Details</td> 
                                    </tr>
                                    <tr>
                                        <td class="formLable">Name</td> <td >:</td>
                                        <td><s:textfield id="name" name="name" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Reg ID</td> <td >:</td>
                                        <td><s:textfield id="regID" name="regID" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">School</td> <td >:</td>
                                        <td><s:textfield id="school" name="school" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Reg Date</td> <td >:</td>
                                        <td><s:textfield id="regDate" name="regDate" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Card Type</td> <td >:</td>
                                        <td><s:textfield id="cardType" name="cardType" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Payments</td> <td >:</td>
                                        <td><s:textfield id="payments" name="payments" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <%--<sj:submit button="true" value="Atten"  onclick="keyPress()" cssClass="button_aback"/>--%>
                                        </td>
                                    </tr>
                                </table>

                            </s:form>
                        </div>
                        <div style="width: 40%; float:right">
                            <s:form id="lectureDetailsForm"  theme="simple" >
                                <table>
                                    <tr>
                                        <td class="formLable">Lecture Details</td> 
                                    </tr>
                                    <tr>
                                        <td class="formLable">Lecture Name</td> <td >:</td>
                                        <td><s:textfield id="lname" name="lname" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                        <td class="formLable">Class Type</td> <td >:</td>
                                        <td><s:textfield id="classType" name="classType" cssClass="textField" disabled="true"/></td>
                                    <tr>
                                        <td class="formLable">Time</td> <td >:</td>
                                        <td><s:textfield id="time" name="time" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Course Id</td> <td >:</td>
                                        <td><s:textfield id="courseId" name="courseId" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                       
                                    <tr>
                                         <td class="formLable">Extra/Normal</td> <td >:</td>
                                        <td><s:textfield id="extra_normal" name="extra_normal" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                     <tr>
                                         <td class="formLable"></td> <td ></td>
                                         <td ><s:textfield id="" name="" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                  
                                   <tr>
                                        <td>
                                            <%--<sj:submit button="true" value="Atten"  onclick="keyPress()" cssClass="button_aback"/>--%>
                                        </td>
                                    </tr>
                                </table>

                            </s:form>
                        </div>
                        <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                    <div style="width: 50%; float:left">    
                        <div class="viewuser_tbl">
                            <div id="tablediv">
                                <s:url var="listurl" action="liststudent"/>
                                <sjg:grid
                                    id="gridtable"
                                    caption="Student Attendance"
                                    cssStyle=""
                                    dataType="json"
                                    href="%{listurl}"
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
                                    multiselect="true"
                                    >

                                    <sjg:gridColumn name="sId" index="sId" title="StudentId" hidden="true" width="10"/>
                                    <sjg:gridColumn name="sName" index="sName" title="Course Id" width="150"/>
                                    <sjg:gridColumn name="sDob" index="sDob" title="Fee" width="100"/>
                                    <sjg:gridColumn name="sAddress" index="sAddress" title="Card Type" width="130"/>
                                    <sjg:gridColumn name="sEmail" index="sEmail" title="Last Payment" width="150"/>
                                    
                                    

                                </sjg:grid> 
                            </div>
                        </div>
                    </div>
                                
                                
                    <div style="width: 40%; float:right">
                            <s:form id="attHistory"  theme="simple" >
                                <table>
                                    <tr>
                                        <td class="formLable">Attendance History</td> 
                                    </tr>
                                </table>

                            </s:form>
                    </div><div style="width: 40%; float:right">
                            <s:form id="payHistory"  theme="simple" >
                                <table>
                                    <tr>
                                        <td class="formLable">Payment History</td> 
                                    </tr>
                                </table>

                            </s:form>
                    </div>
            </div>
                    </section>



                    </body>
                    </html>

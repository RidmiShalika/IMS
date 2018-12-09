<%-- 
    Document   : course
    Created on : Apr 3, 2018, 1:33:46 PM
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

            function ResetSearchForm1() {
                $('#searchname').val("");
                jQuery("#gridtable").trigger("reloadGrid");
            }
            function loadAddForm() {
                $('#searchForm').hide();
                $('#addForm').show();

            }
            function ResetAddForm() {
                $('#addcourseDescription').val("");
                $('#addlecturer').val("");
                $('#addconductingMedium').val("");
                $('#addsubject').val("");
                $('#addtotalCoursefee').val("");
                $('#addgrade').val("");
                $('#addcourseDuration').val("");
                $('#addmonthlyFee').val("");
                $('#addclassType').val("");
                $('#addlectureHall').val("");
                $('#addbatchNo').val("");
                $('#addlecturerPayment').val("");
                $('#addclassDays').val("");
                $('#addstartTime').val("");
                $('#addendTime').val("");

                jQuery("#gridtable").trigger("reloadGrid");

            }
            function BackToMain() {
                $('#divmsg').empty();
                $('#searchForm').show();

                $('#addForm').hide()();

                jQuery("#gridtable").trigger("reloadGrid");
            }
            function BackToMain1() {
                $('#searchForm').show();
                $('#updateForm').hide()();
                $('#divmsg').empty();
                jQuery("#gridtable").trigger("reloadGrid");
            }
            function editformatter(cellvalue, options, rowObject) {
//                 alert(cellvalue);
                return "<a href='#' onClick='javascript:editNow(&#34;" + cellvalue + "&#34;)'><img src ='${pageContext.request.contextPath}/resources/images/iconEdit.png' /></a>";
            }
            function editNow(keyval) {

                $('#updateForm').show();
                var text = ' Edit User';

                $.ajax({
                    url: '${pageContext.request.contextPath}/findLecturer',
                    data: {ID: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {

                        $('#searchForm').hide();
                        $('#upname').val(data.upname);
                        $('#upnic').val(data.upnic);
                        $('#upcontact').val(data.upcontact);
                        $('#upemail').val(data.upemail);
                        $('#upgender').val(data.upgender);
                        $('#upsubject').val(data.upsubject);
                        $('#upaddress').val(data.upaddress);

                    },
                    error: function (data) {
                        alert("error");
                        window.location = "${pageContext.request.contextPath}/logOut.action";
                    }
                });

            }
            function resetData() {

                jQuery("#gridtable").trigger("reloadGrid");
            }
            function resetUpdateForm() {
                var keyval = $('#upname').val();
                $.ajax({
                    url: '${pageContext.request.contextPath}/findStudent',
                    data: {upname: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {

                        $('#searchForm').hide();
                        $('#upname').val(data.upname);
                        $('#upfirstname').val(data.upfirstname);
                        $('#upaddress').val(data.upaddress);
                        $('#upemail').val(data.upemail);
                        $('#upgender').val(data.upgender);
                        $('#upyearOfRegistration').val(data.upyearOfRegistration);
                        $('#uptelephone').val(data.uptelephone);
                        $('#upschool').val(data.upschool);
                        $('#upbirthday').val(data.upbirthday);
                        $('#upparentContactNo').val(data.upparentContactNo);
                        $('#upcardno').val(data.upcardno);

                    },
                    error: function (data) {
                        alert("error");
                        window.location = "${pageContext.request.contextPath}/logOut.action";
                    }
                });


            }
            $.subscribe('onclicksearch', function (event, data) {
                var searchname = $('#searchname').val();
                $("#gridtable").jqGrid('setGridParam', {postData: {searchname: searchname, search: true}});
//                $("#gridtable").jqGrid('setGridParam', {page: 1});
                jQuery("#gridtable").trigger("reloadGrid");
            });

        </script>
    </head>

    <body style="overflow:hidden" onload="load()">
        <section class="app-content">
            <jsp:include page="../../header.jsp" />    
            <div class="wrapper">
                <div class="body_content" id="includedContent" >
                    <div class="watermark"></div>
                    <div class="heading">Register New Courses</div>
                    <div class="AddUser_box ">
                        <div class="message">         
                            <s:div id="divmsg">
                                <i style="color: red">  <s:actionerror theme="jquery"/></i>
                                <i style="color: green"> <s:actionmessage theme="jquery"/></i>
                            </s:div>         
                        </div>
                        <div class="contentcenter">
                            <s:form id="searchForm"  theme="simple">         
                                <table >              
                                    <tr>
                                        <td style="font-size: 15px">Course Name</td>
                                        <td>:</td>
                                        <td colspan="2"><s:textfield name="searchname"  id="searchname" cssClass="textField" /> </td>
                                        <td class="content_td formLable">

                                        </td>
                                    </tr>
                                </table>
                                <table>
                                    </br>
                                    <tr>                                
                                        <td> 


                                            <sj:a     button="true"    onClickTopics="onclicksearch"  cssClass="button_aback"  role="button" >Search</sj:a>

                                            <sj:a     button="true"    onClickTopics="loadAddForm" onclick="loadAddForm()"  cssClass="button_aback"  role="button" >Add</sj:a>
                                            <sj:a     button="true"  onclick="ResetSearchForm1()"  cssClass="button_aback"  role="button" >Reset</sj:a>

                                            </td>
                                        </tr>
                                    </table>
                            </s:form>
                            <s:form  id="addForm"  theme="simple" method="post"  cssStyle="display:none">
                                <table >
                                    <tr>
                                        <td class="formLable">Course Description</td> <td>:</td>

                                        <td><s:textfield id="addcourseDescription" name="addcourseDescription" cssClass="textField" /></td>
                                        <td width="25px;"></td>
                                        <td class="formLable">Lecturer<span class="mandatory">*</span></td> <td>:</td>
                                        <!--<td><s:textfield id="addlecturer" name="addlecturer" cssClass="textField" /></td>-->
                                        <td><s:select  name="addlecturer" id="addlecturer" list="%{lecList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                    </tr> 
                                    <tr>
                                        <td class="formLable">Conducting Medium<span class="mandatory">*</span></td> <td >:</td>
                                        <!--<td><s:textfield id="addconductingMedium" name="addconductingMedium" cssClass="textField" /></td>-->    
                                        <td><s:select  name="addconductingMedium" id="addconductingMedium" list="%{medList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                        <td width="25px;"></td>
                                        <td class="formLable">Subject<span class="mandatory">*</span></td> <td>:</td>
                                        <!--<td><s:textfield id="addsubject" name="addsubject" cssClass="textField" /></td>-->
                                        <td><s:select  name="addsubject" id="addsubject" list="%{subList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                    </tr>
                                    <tr>
                                        <td class="formLable">Total Course Fee<span class="mandatory">*</span></td> <td >:</td>
                                        <td><s:textfield id="addtotalCoursefee" name="addtotalCoursefee" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">Grade<span class="mandatory">*</span></td> <td>:</td>
                                        <!--<td><s:textfield id="addgrade" name="addgrade" cssClass="textField" /></td>-->
                                        <td><s:select  name="addgrade" id="addgrade" list="%{gradeList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                    </tr>
                                    <tr>
                                        <td class="formLable">Course Duration<span class="mandatory">*</span></td> <td >:</td>
                                        <td><s:textfield id="addcourseDuration" name="addcourseDuration" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">Monthly Fee</td> <td>:</td>
                                        <td><s:textfield id="addmonthlyFee" name="addmonthlyFee" cssClass="textField" /></td>  

                                    </tr>

                                    <tr>
                                        <td class="formLable">Class Type<span class="mandatory">*</span></td> <td >:</td>
                                        <!--<td><s:textfield id="addclassType" name="addclassType" cssClass="textField" /></td>-->  
                                        <td><s:select  name="addclassType" id="addclassType" list="%{clzList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>
                                        <td width="25px;"></td>
                                        <td class="formLable">Lecture Hall</td> <td>:</td>
                                        <!--<td><s:textfield id="addlectureHall" name="addlectureHall" cssClass="textField" /></td>-->
                                        <td><s:select  name="addlectureHall" id="addlectureHall" list="%{hallList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Batch No<span class="mandatory">*</span></td> <td >:</td>
                                        <!--<td><s:textfield id="addbatchNo" name="addbatchNo" cssClass="textField" /></td>-->
                                        <td><s:select  name="addbatchNo" id="addbatchNo" list="%{batchList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>
                                        <td width="25px;"></td>
                                        <td class="formLable">Lecturer Payment</td> <td>:</td>
                                        <td><s:textfield id="addlecturerPayment" name="addlecturerPayment" cssClass="textField" /></td>  
                                    </tr>
                                    <tr>
                                        <td class="formLable">Class Days<span class="mandatory">*</span></td> <td >:</td>
                                        <td><s:checkbox id="addclassDaysM" name="addclassDaysM" cssClass="textField">Monday</s:checkbox></td>
                                        <td><s:checkbox id="addclassDaysM" name="addclassDaysM" cssClass="textField">Tuesday</s:checkbox></td>
                                        <!--<td width="25px;"></td>-->
<!--                                        <td class="formLable">Start Time</td> <td>:</td>
                                        <td><s:textfield id="addstartTime" name="addstartTime" cssClass="textField" /></td>  
                                        <td width="25px;"></td>
                                        <td class="formLable">End Time</td> <td>:</td>
                                        <td><s:textfield id="addendTime" name="addendTime" cssClass="textField" /></td>  -->
                                    </tr>

                                </table>
                                <table>
                                    <tr>
                                        <td>
                                            <s:url var="addurl" action="AddCourse" />
                                            <!--<button type="button" id="addbtn" onclick= "javascript:location.href='Addstudent.action';" class="btn btn-primary">Add</button>-->
                                            <sj:submit  id="addbtn" button="true" href="%{addurl}" value="Add"   targets="divmsg" cssClass="button_aback"/> 
                                            <sj:submit button="true" value="Reset"  onclick="ResetAddForm()" cssClass="button_aback"/>
                                            <sj:submit id="backbtn" value="Back" onclick="BackToMain()" cssClass="button_aback"/>
                                        </td>
                                    </tr>
                                </table>
                            </s:form>
                            <s:form  id="updateForm"  theme="simple" method="post"  cssStyle="display:none">
                                <table >
                                    <tr>
                                        <s:hidden id="uplecid" name="upcusid" cssClass="textField" />   
                                        <td class="formLable">Name</td> <td >:</td>
                                        <td><s:textfield id="upname" name="upname" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">NIC</td> <td>:</td>
                                        <td><s:textfield id="upnic" name="upnic" cssClass="textField" /></td>
                                    </tr> 
                                    <tr>
                                        <td class="formLable">Contact</td> <td >:</td>
                                        <td><s:textfield id="upcontact" name="upcontact" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">Email</td> <td>:</td>
                                        <td><s:textfield id="upemail" name="upemail" cssClass="textField" /></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Gender</td> <td >:</td>
                                        <td><s:textfield id="upgender" name="upgender" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">Subject</td> <td>:</td>
                                        <td><s:textfield id="upsubject" name="upsubject" cssClass="textField" /></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Address</td> <td >:</td>
                                        <td><s:textfield id="upaddress" name="upaddress" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>

                                    </tr>

                                </table>
                                <table>
                                    <tr>
                                        <td>
                                            <s:url var="updateurl" action="updatelecturer" />

                                            <sj:submit  id="updatebtn" button="true" href="%{updateurl}" value="Update"   targets="divmsg" cssClass="button_aback"/> 
                                            <sj:submit button="true" value="Reset" onclick="resetUpdateForm()" cssClass="button_aback"/>
                                            <%--<sj:submit id="upbackbtn" value="Back" onclick="BackToMain()" cssClass="button_aback"/>--%>
                                            <sj:a href="#" name="back" button="true" onclick="BackToMain1()"  cssClass="button_aback" >Back</sj:a> 
                                            </td>
                                        </tr>
                                    </table>

                            </s:form>

                        </div>
                        <div class="viewuser_tbl">
                            <div id="tablediv">
                                <s:url var="listurl" action="listcourses"/>
                                <sjg:grid
                                    id="gridtable"
                                    caption="Registered Courses"
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
                                    >
                                    <sjg:gridColumn name="courseID" index="courseID" title="Course ID" />
                                    <sjg:gridColumn name="courseDescription" index="courseDescription" title="Course Description" />
                                    <sjg:gridColumn name="subject" index="subject" title="Subject" />
                                    <sjg:gridColumn name="lecturer" index="lecturer" title="Lecturer" />
                                    <sjg:gridColumn name="classType" index="classType" title="Class Type" />
                                    <sjg:gridColumn name="medium" index="medium" title="Medium" />
                                    <sjg:gridColumn name="courseID" index="courseID" title="Edit" formatter="editformatter" align="center"/>

                                </sjg:grid> 
                            </div>
                        </div>
                    </div>
                    </section>

                </div>

                </body>
                </html>

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
           
            function getCheckValue(){
                if ($('#addclassDaysM').is(":checked"))
                {
                  var starttimeM = $('#starttimeM').val();
                }
                if ($('#addclassDaysTu').is(":checked")){
                   var starttimeTu = $('#starttimeTu').val();
                }
                if ($('#addclassDaysW').is(":checked")){
                     var starttimeW = $('#starttimeW').val();
                }
                if ($('#addclassDaysTh').is(":checked")){
                    var starttimeTh = $('#starttimeTh').val();;
                }
                if ($('#addclassDaysF').is(":checked")){
                     var starttimeF = $('#starttimeF').val();
                }
                if ($('#addclassDaysSa').is(":checked")){
                     var starttimeSa = $('#starttimeSa').val();
                }
                if ($('#addclassDaysSu').is(":checked")){
                    var starttimeSu = $('#starttimeSu').val();
                }
            }

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
                                    <td class="formLable">Course Description<span class="mandatory">*</span></td> <td>:</td>

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
                                    <td class="formLable">Total Course Fee</td> <td >:</td>
                                    <td><s:textfield id="addtotalCoursefee" name="addtotalCoursefee" cssClass="textField" /></td>                                    
                                    <td width="25px;"></td>
                                    <td class="formLable">Grade<span class="mandatory">*</span></td> <td>:</td>
                                    <!--<td><s:textfield id="addgrade" name="addgrade" cssClass="textField" /></td>-->
                                    <td><s:select  name="addgrade" id="addgrade" list="%{gradeList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                </tr>
                                <tr>
                                    <td class="formLable">Course Duration</td> <td >:</td>
                                    <td><s:textfield id="addcourseDuration" name="addcourseDuration" cssClass="textField" /></td>                                    
                                    <td width="25px;"></td>
                                    <td class="formLable">Monthly Fee</td> <td>:</td>
                                    <td><s:textfield id="addmonthlyFee" name="addmonthlyFee" cssClass="textField" /></td>  

                                </tr>

                                <tr>
                                    <td class="formLable">Class Type</td> <td >:</td>
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
                                    <td class="formLable">Lecturer Payment<span class="mandatory">*</span></td> <td>:</td>
                                    <td><s:textfield id="addlecturerPayment" name="addlecturerPayment" cssClass="textField" /></td>  
                                </tr>

                            </table>
                            <table>
                                <tr>
                                    <td class="formLable">Class Days</td><td>:</td>
                                    <td class="formLable"><s:checkbox id="addclassDaysM" name="addclassDaysM">Monday</s:checkbox></td>
                                    <td class="formLable"><s:checkbox id="addclassDaysTu" name="addclassDaysTu">Tuesday</s:checkbox></td>
                                    <td class="formLable"><s:checkbox id="addclassDaysW" name="addclassDaysW">Wednesday</s:checkbox></td>
                                    <td class="formLable"><s:checkbox id="addclassDaysTh" name="addclassDaysTh">Thursday</s:checkbox></td>
                                    <td class="formLable"><s:checkbox id="addclassDaysF" name="addclassDaysF">Friday</s:checkbox></td>
                                    <td class="formLable"><s:checkbox id="addclassDaysSa" name="addclassDaysSa">Saturday</s:checkbox></td>
                                    <td class="formLable"><s:checkbox id="addclassDaysSu" name="addclassDaysSu">Sunday</s:checkbox></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Start Time</td><td>:</td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeM" name="starttimeM" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeTu" name="starttimeTu" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeW" name="starttimeW" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeTh" name="starttimeTh" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeF" name="starttimeF" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeSa" name="starttimeSa" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeSu" name="starttimeSu" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>

                                </tr>
                                <tr>
                                        <td class="formLable">End Time</td><td>:</td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeM" name="endtimeM" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeTu" name="endtimeTu" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeW" name="endtimeW" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeTh" name="endtimeTh" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeF" name="endtimeF" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeSa" name="endtimeSa" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeSu" name="endtimeSu" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>

                                </tr>

                            </table>
                            <table>
                                <tr>
                                    <td>
                                        <s:url var="addurl" action="AddCourse" />
                                        <!--<button type="button" id="addbtn" onclick= "javascript:location.href='Addstudent.action';" class="btn btn-primary">Add</button>-->
                                        <sj:submit  id="addbtn" button="true"  href="%{addurl}" value="Add"   targets="divmsg" cssClass="button_aback"/> 
                                        <sj:submit button="true" value="Reset"  onclick="ResetAddForm()" cssClass="button_aback"/>
                                        <sj:submit id="backbtn" value="Back" onclick="BackToMain()" cssClass="button_aback"/>
                                    </td>
                                </tr>
                            </table>
                        </s:form>
                        <s:form  id="updateForm"  theme="simple" method="post"  cssStyle="display:none">
                            <table >
                                
                                <tr>
                                    <s:hidden id="upcourseid" name="upcourseid" cssClass="textField" />   
                                    <td class="formLable">Course Description<span class="mandatory">*</span></td> <td>:</td>

                                    <td><s:textfield id="upcourseDescription" name="upcourseDescription" cssClass="textField" /></td>
                                    <td width="25px;"></td>
                                    <td class="formLable">Lecturer<span class="mandatory">*</span></td> <td>:</td>
                                    <td><s:select  name="uplecturer" id="uplecturer" list="%{lecList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                </tr> 
                                <tr>
                                    <td class="formLable">Conducting Medium<span class="mandatory">*</span></td> <td >:</td>
                                    <td><s:select  name="upconductingMedium" id="upconductingMedium" list="%{medList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                    <td width="25px;"></td>
                                    <td class="formLable">Subject<span class="mandatory">*</span></td> <td>:</td>
                                    <td><s:select  name="upsubject" id="upsubject" list="%{subList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                </tr>
                                <tr>
                                    <td class="formLable">Total Course Fee</td> <td >:</td>
                                    <td><s:textfield id="uptotalCoursefee" name="uptotalCoursefee" cssClass="textField" /></td>                                    
                                    <td width="25px;"></td>
                                    <td class="formLable">Grade<span class="mandatory">*</span></td> <td>:</td>
                                    <td><s:select  name="upgrade" id="upgrade" list="%{gradeList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                </tr>
                                <tr>
                                    <td class="formLable">Course Duration</td> <td >:</td>
                                    <td><s:textfield id="upcourseDuration" name="upcourseDuration" cssClass="textField" /></td>                                    
                                    <td width="25px;"></td>
                                    <td class="formLable">Monthly Fee</td> <td>:</td>
                                    <td><s:textfield id="upmonthlyFee" name="upmonthlyFee" cssClass="textField" /></td>  

                                </tr>

                                <tr>
                                    <td class="formLable">Class Type</td> <td >:</td>
                                    <td><s:select  name="upclassType" id="upclassType" list="%{clzList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>
                                    <td width="25px;"></td>
                                    <td class="formLable">Lecture Hall</td> <td>:</td>
                                    <td><s:select  name="uplectureHall" id="uplectureHall" list="%{hallList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>
                                </tr>
                                <tr>
                                    <td class="formLable">Batch No<span class="mandatory">*</span></td> <td >:</td>
                                    <td><s:select  name="upbatchNo" id="upbatchNo" list="%{batchList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>
                                    <td width="25px;"></td>
                                    <td class="formLable">Lecturer Payment<span class="mandatory">*</span></td> <td>:</td>
                                    <td><s:textfield id="uplecturerPayment" name="uplecturerPayment" cssClass="textField" /></td>  
                                </tr>

                            </table>
                                <table>
                                <tr>
                                    <td class="formLable">Class Days</td><td>:</td>
                                    <td class="formLable"><s:checkbox id="upclassDaysM" name="upclassDaysM">Monday</s:checkbox></td>
                                    <td class="formLable"><s:checkbox id="upclassDaysTu" name="upclassDaysTu">Tuesday</s:checkbox></td>
                                    <td class="formLable"><s:checkbox id="upclassDaysW" name="upclassDaysW">Wednesday</s:checkbox></td>
                                    <td class="formLable"><s:checkbox id="upclassDaysTh" name="upclassDaysTh">Thursday</s:checkbox></td>
                                    <td class="formLable"><s:checkbox id="upclassDaysF" name="upclassDaysF">Friday</s:checkbox></td>
                                    <td class="formLable"><s:checkbox id="upclassDaysSa" name="upclassDaysSa">Saturday</s:checkbox></td>
                                    <td class="formLable"><s:checkbox id="upclassDaysSu" name="upclassDaysSu">Sunday</s:checkbox></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Start Time</td><td>:</td>
                                        <td class="formLable">
                                        <sj:datepicker id="upstarttimeM" name="upstarttimeM" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="upstarttimeTu" name="upstarttimeTu" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="upstarttimeW" name="upstarttimeW" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="upstarttimeTh" name="upstarttimeTh" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="upstarttimeF" name="upstarttimeF" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="upstarttimeSa" name="upstarttimeSa" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="upstarttimeSu" name="upstarttimeSu" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>

                                </tr>
                                <tr>
                                        <td class="formLable">End Time</td><td>:</td>
                                        <td class="formLable">
                                        <sj:datepicker id="upendtimeM" name="upendtimeM" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="upendtimeTu" name="upendtimeTu" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="upendtimeW" name="upendtimeW" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="upendtimeTh" name="upendtimeTh" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="upendtimeF" name="upendtimeF" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="upendtimeSa" name="upendtimeSa" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td class="formLable">
                                        <sj:datepicker id="upendtimeSu" name="upendtimeSu" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>

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

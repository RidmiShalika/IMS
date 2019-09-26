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
         <style>
            .ui-datepicker {
                 /*background: transparent;*/
                 background: white;
            }
        </style>
        <script type="text/javascript">

             function extraclzformatter(cellvalue, options, rowObject) {
                return "<a href='#' onClick='javascript:addextraclz(&#34;" + cellvalue + "&#34;,&#34;" + rowObject.courseID + "&#34;)'><i class='fa fa-share-square-o' aria-hidden='true'></i></a>";
            }
             function addextraclz(id, bin) {
                $("#viewdialog").data('Id', id);
                $("#viewdialog").data('courseID', bin).dialog('open');
            }
             $.subscribe('openview', function (event, data) {
                var $led = $("#viewdialog");
                $led.load("AddExtraClz?course_ID=" + $led.data('Id'));
            });
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
//                $('#addlectureHall').val("");
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
                return "<a href='#' onClick='javascript:editNow(&#34;" + cellvalue + "&#34;)'><img src ='${pageContext.request.contextPath}/resources/images/iconEdit.png' /></a>";
            }
            function editNow(keyval) {
               
                $('#updateForm').show();
                var text = ' Edit User';

                $.ajax({
                    url: '${pageContext.request.contextPath}/findCourse',
                    data: {courseID: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        $('#searchForm').hide();
                         $('#addForm').hide();
                        $('#upcourseid').val(data.upcourseid);
                        $('#upcourseDescription').val(data.upcourseDescription);
                        $('#uplecturer').val(data.uplecturer);
                        $('#upconductingMedium').val(data.upconductingMedium);
                        $('#upsubject').val(data.upsubject);
                        $('#uptotalCoursefee').val(data.uptotalCoursefee);
                        $('#upgrade').val(data.upgrade);
                        $('#upcourseDuration').val(data.upcourseDuration);
                        $('#upmonthlyFee').val(data.upmonthlyFee);
                        $('#upclassType').val(data.upclassType);
                        $('#uplectureHall').val(data.uplectureHall);
                        $('#upbatchNo').val(data.upbatchNo);
                        $('#uplecturerPayment').val(data.uplecturerPayment);
                        $('#upclassDays').val(data.upclassDays);
                        $('#upstartTime').val(data.upstartTime);
                        $('#upendTime').val(data.upendTime);
                        
                        $('#upstarttimeM').val(data.upstarttimeM);
                        $('#upstarttimeTu').val(data.upstarttimeTu);
                        $('#upstarttimeW').val(data.upstarttimeW);
                        $('#upstarttimeTh').val(data.upstarttimeTh);
                        $('#upstarttimeF').val(data.upstarttimeF);
                        $('#upstarttimeSa').val(data.upstarttimeSa);
                        $('#upstarttimeSu').val(data.upstarttimeSu);
                        
                        $('#upendtimeM').val(data.upendtimeM);
                        $('#upendtimeTu').val(data.upendtimeTu);
                        $('#upendtimeW').val(data.upendtimeW);
                        $('#upendtimeTh').val(data.upendtimeTh);
                        $('#upendtimeF').val(data.upendtimeF);
                        $('#upendtimeSa').val(data.upendtimeSa);
                        $('#upendtimeSu').val(data.upendtimeSu);

                    },
                    error: function (data) {
                        window.location = "${pageContext.request.contextPath}/logOut.action";
                    }
                });

            }
            function resetData() {

                jQuery("#gridtable").trigger("reloadGrid");
            }
            function resetUpdateForm() {
                var keyval = $('#upcourseid').val();
                $('#divmsg').empty();
                $.ajax({
                    url: '${pageContext.request.contextPath}/findCourse',
                    data: {courseID: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {

                        $('#searchForm').hide();
//                         $('#addForm').hide()();
                        $('#upcourseid').val(data.upcourseid);
                        $('#upcourseDescription').val(data.upcourseDescription);
                        $('#uplecturer').val(data.uplecturer);
                        $('#upconductingMedium').val(data.upconductingMedium);
                        $('#upsubject').val(data.upsubject);
                        $('#uptotalCoursefee').val(data.uptotalCoursefee);
                        $('#upgrade').val(data.upgrade);
                        $('#upcourseDuration').val(data.upcourseDuration);
                        $('#upmonthlyFee').val(data.upmonthlyFee);
                        $('#upclassType').val(data.upclassType);
                        $('#uplectureHall').val(data.uplectureHall);
                        $('#upbatchNo').val(data.upbatchNo);
                        $('#uplecturerPayment').val(data.uplecturerPayment);
                        $('#upclassDays').val(data.upclassDays);
                        $('#upstartTime').val(data.upstartTime);
                        $('#upendTime').val(data.upendTime);
                        
                        $('#upstarttimeM').val(data.upstarttimeM);
                        $('#upstarttimeTu').val(data.upstarttimeTu);
                        $('#upstarttimeW').val(data.upstarttimeW);
                        $('#upstarttimeTh').val(data.upstarttimeTh);
                        $('#upstarttimeF').val(data.upstarttimeF);
                        $('#upstarttimeSa').val(data.upstarttimeSa);
                        $('#upstarttimeSu').val(data.upstarttimeSu);
                        
                        $('#upendtimeM').val(data.upendtimeM);
                        $('#upendtimeTu').val(data.upendtimeTu);
                        $('#upendtimeW').val(data.upendtimeW);
                        $('#upendtimeTh').val(data.upendtimeTh);
                        $('#upendtimeF').val(data.upendtimeF);
                        $('#upendtimeSa').val(data.upendtimeSa);
                        $('#upendtimeSu').val(data.upendtimeSu);

                    },
                    error: function (data) {
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
                                    <td style="font-size: 15px">Course Description</td>
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
                                            <td width="50px;"></td>
                                           
                                            <td class="formLable">Lecturer<span class="mandatory">*</span></td> <td>:</td>
                                           
                                            <td><s:select  name="addlecturer" id="addlecturer" list="%{lecList}" 
                                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                            <td width="50px;"></td>
                                            <td class="formLable">Conducting Medium<span class="mandatory">*</span></td> <td >:</td>
                                           
                                            <td><s:select  name="addconductingMedium" id="addconductingMedium" list="%{medList}" 
                                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                        </tr> 
                                        <tr>
                                            <td class="formLable">Grade<span class="mandatory">*</span></td> <td>:</td>
                                            <td><s:select  name="addgrade" id="addgrade" list="%{gradeList}" 
                                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                            
                                            <td width="50px;"></td>
                                            
                                            <td class="formLable">Subject<span class="mandatory">*</span></td> <td>:</td>
                                           
                                            <td><s:select  name="addsubject" id="addsubject" list="%{subList}" 
                                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                            <td width="50px;"></td>
                                            <td class="formLable">Class Type<span class="mandatory">*</span></td> <td >:</td>
                                           
                                            <td><s:select  name="addclassType" id="addclassType" list="%{clzList}" 
                                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>
                                            
                                        </tr>
                                        <tr>
                                            <td class="formLable">Batch No<span class="mandatory">*</span></td> <td >:</td>
                                            
                                            <td><s:select  name="addbatchNo" id="addbatchNo" list="%{batchList}" 
                                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>

                                            <td width="50px;"></td>
                                           
                                            <td class="formLable">Monthly Fee</td> <td>:</td>
                                            <td><s:textfield id="addmonthlyFee" name="addmonthlyFee" cssClass="textField" /></td>  

                                            <td width="50px;"></td>
                                         <td class="formLable">Lecturer Payment<span class="mandatory">*</span></td> <td>:</td>
                                            <td><s:textfield id="addlecturerPayment" name="addlecturerPayment" cssClass="textField" /></td>  
                                        </tr>

                                        

                                    </table>
                                
                            <table>
                                <tr>   </tr>
                                <br>
                                <tr>
                                    <td class="formLable">Class Days</td><td>:</td>
                                    <td width="25px;"></td>
                                    <td class="formLable"><s:label id="addclassDaysM" name="addclassDaysM">Monday</s:label></td>
                                    <td width="25px;"></td>
                                    <td class="formLable"><s:label id="addclassDaysTu" name="addclassDaysTu">Tuesday</s:label></td>
                                    <td width="25px;"></td>
                                    <td class="formLable"><s:label id="addclassDaysW" name="addclassDaysW">Wednesday</s:label></td>
                                    <td width="25px;"></td>
                                    <td class="formLable"><s:label id="addclassDaysTh" name="addclassDaysTh">Thursday</s:label></td>
                                    <td width="25px;"></td>
                                    <td class="formLable"><s:label id="addclassDaysF" name="addclassDaysF">Friday</s:label></td>
                                    <td width="25px;"></td>
                                    <td class="formLable"><s:label id="addclassDaysSa" name="addclassDaysSa">Saturday</s:label></td>
                                    <td width="25px;"></td>
                                    <td class="formLable"><s:label id="addclassDaysSu" name="addclassDaysSu">Sunday</s:label></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Start Time</td><td>:</td>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeM" name="starttimeM" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeTu" name="starttimeTu" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeW" name="starttimeW" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeTh" name="starttimeTh" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeF" name="starttimeF" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeSa" name="starttimeSa" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="starttimeSu" name="starttimeSu" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>

                                </tr>
                                <tr>
                                        <td class="formLable">End Time</td><td>:</td>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeM" name="endtimeM" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeTu" name="endtimeTu" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeW" name="endtimeW" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeTh" name="endtimeTh" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeF" name="endtimeF" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeSa" name="endtimeSa" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>
                                        <td width="25px;"></td>
                                        <td class="formLable">
                                        <sj:datepicker id="endtimeSu" name="endtimeSu" timepicker="true" timepickerOnly="true" cssStyle="width : 50px"/>
                                        </td>

                                </tr>
                                

                            </table>
                            <table>
                                <tr>   </tr>
                                <br>
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
<!--                                    <td class="formLable">Total Course Fee</td> <td >:</td>
                                    <td><s:textfield id="uptotalCoursefee" name="uptotalCoursefee" cssClass="textField" /></td>                                    
                                    <td width="25px;"></td>-->
                                    <td class="formLable">Grade<span class="mandatory">*</span></td> <td>:</td>
                                    <td><s:select  name="upgrade" id="upgrade" list="%{gradeList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
<!--                                </tr>
                                <tr>
                                    <td class="formLable">Course Duration</td> <td >:</td>
                                    <td><s:textfield id="upcourseDuration" name="upcourseDuration" cssClass="textField" /></td>                                    -->
                                    <td width="25px;"></td>
                                    <td class="formLable">Monthly Fee</td> <td>:</td>
                                    <td><s:textfield id="upmonthlyFee" name="upmonthlyFee" cssClass="textField" /></td>  

                                </tr>

                                <tr>
                                    <td class="formLable">Class Type<span class="mandatory">*</span></td> <td >:</td>
                                    <td><s:select  name="upclassType" id="upclassType" list="%{clzList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>
                                    <td width="25px;"></td>
<!--                                    <td class="formLable">Lecture Hall</td> <td>:</td>
                                    <td><s:select  name="uplectureHall" id="uplectureHall" list="%{hallList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>-->
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
                                    <td class="formLable"><s:label id="upclassDaysM" name="upclassDaysM">Monday</s:label></td>
                                    <td class="formLable"><s:label id="upclassDaysTu" name="upclassDaysTu">Tuesday</s:label></td>
                                    <td class="formLable"><s:label id="upclassDaysW" name="upclassDaysW">Wednesday</s:label></td>
                                    <td class="formLable"><s:label id="upclassDaysTh" name="upclassDaysTh">Thursday</s:label></td>
                                    <td class="formLable"><s:label id="upclassDaysF" name="upclassDaysF">Friday</s:label></td>
                                    <td class="formLable"><s:label id="upclassDaysSa" name="upclassDaysSa">Saturday</s:label></td>
                                    <td class="formLable"><s:label id="upclassDaysSu" name="upclassDaysSu">Sunday</s:label></td>
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
                                        <s:url var="updateurl" action="updateCourse" />

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
                            <sj:dialog 
                                        id="viewdialog" 
                                        buttons="{
                                        'OK':function() { $( this ).dialog( 'close' );}                                    
                                        }" 
                                        autoOpen="false" 
                                        modal="true"                            
                                        width="1000"
                                        height="500"
                                        position="center"
                                        title="Add Extra Class"
                                        onOpenTopics="openview" 
                                        loadingText="Loading .."
                            />
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
                                <sjg:gridColumn name="courseID" index="courseID" title="Extra Class" formatter="extraclzformatter" align="center"/>

                            </sjg:grid> 
                        </div>
                    </div>
                </div>
                </section>

            </div>

            </body>
            </html>

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
        <script type="text/javascript">
//            $(document).ready(function () { 
            function test(keyval) {
                var tId = keyval;
                $.ajax({
                    url: '${pageContext.request.contextPath}/getclassInfo',
                    data: {s_c_id: tId},
                    dataType: "json",
                    type: "GET",
                    success: function (data) {
                        $('#course_fee').val(data.course_fee);
                        $('#course_duration').val(data.course_duration);
                    },
                    error: function (data) {

                    }
                });
            }
//             });
            
            function editformatter(cellvalue, options, rowObject) {
                return "<a href='#' onClick='javascript:editNow1(&#34;" + cellvalue + "&#34;)'><img src ='${pageContext.request.contextPath}/resources/images/iconEdit.png' /></a>";
            }
            function editNow1(keyval) {
                $('#updateForm1').show();
                var text = ' Edit User';

                $.ajax({
                    url: '${pageContext.request.contextPath}/findCard',
                    data: {card_id: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                      
                      $('#assignC').hide();
                        $('#upasscard_type').val(data.upasscard_type);
                        $('#upcardId').val(data.upcardId);
 

                    },
                    error: function (data) {
                        window.location = "${pageContext.request.contextPath}/logOut.action";
                    }
                });

            }
            function deleteformatter(cellvalue, options, rowObject) {
                return "<a href='#' onClick='deleteInit(&#34;" + cellvalue + "&#34;)'><img src='${pageContext.request.contextPath}/resources/images/iconDelete.png'  /></a>";
            }
            function deleteInit(keyval) {
                $("#confirmdialogbox").data('keyval', keyval).dialog('open');
                $("#confirmdialogbox").html('<br><b><font size="3" color="red"><center>Please confirm to delete  : ' + keyval + '');
                return false;
            }
            function deleteNow(keyval) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/deletesc',
                    data: {s_c_id: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        if (data.success) {
                            $("#dialogbox").dialog('open');
                            $("#dialogbox").html('<br><b><font size="3" color="green"><center>' + data.message + ' ');
                        } else {
                            $("#dialogbox").dialog('open');
                            $("#dialogbox").html('<br><b><font size="3" color="red"><center>' + data.message + ' ');
                        }
                        jQuery("#gridtable1").trigger("reloadGrid");
                    },
                    error: function (data) {
                        window.location = "${pageContext.request.contextPath}/LogoutloginCall";
                    }
                });

            }
            function resetData() {
                jQuery("#gridtable1").trigger("reloadGrid");
            }
            function restfunction() {
                jQuery("#gridtable1").trigger("reloadGrid");
                $('#divmsg1').hide();
                $('#assSubject').val("-1");
                $('#assCourse').val("-1");
                $('#assgrade').val("-1");
                $('#asscard_type').val("-1");
                $('#course_fee').val("");
                $('#course_duration').val("");

            }
            function BackToMain12(){
                 $('#divmsg1').hide();
                 $('#updateForm1').hide();
                 $('#assignC').show();
            }
        </script>
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
                                    <td class="formLable">Select Subject<span class="mandatory">*</span></td> <td >:</td>
                                    <td><s:select  name="assSubject" id="assSubject" list="%{subList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                    <td width="25px;"></td>
                                    <td class="formLable">Card Type<span class="mandatory">*</span></td> <td >:</td>
                                    <td><s:select  name="asscard_type" id="asscard_type" list="%{cardTypeList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 

                                </tr>
                                <tr>
                                    <td class="formLable">Select Grade<span class="mandatory">*</span></td> <td >:</td>
                                    <td><s:select  name="assgrade" id="assgrade" list="%{gradeList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                    <td width="25px;"></td>

                                    <td class="formLable">Course Fee</td> <td >:</td>
                                    <td><s:textfield id="course_fee" name="course_fee" disabled="true"></s:textfield></td> 

                                    </tr>
                                    <tr>
                                        <td class="formLable">Select Course<span class="mandatory">*</span></td> <td >:</td>
                                        <td><s:select  name="assCourse" id="assCourse" list="%{corList}" 
                                               listKey="id"
                                               listValue="name"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" onchange="test(this.value)" /></td> 

                                    <td width="25px;"></td>
                                    

                                    </tr>

                                </table>
                                <table>
                                    <tr>
                                        <td>
                                        <s:url var="assaddurl" action="assstudentToCr" />

                                        <sj:submit  id="assAddbtn" button="true" href="%{assaddurl}" value="Add"   targets="divmsg1" cssClass="button_aback"/> 
                                        <sj:submit button="true" value="Reset" onclick="restfunction()" cssClass="button_aback"/>
                                    </td>
                                </tr>
                            </table>
                        </s:form>
                        <s:form  id="updateForm1"  theme="simple" method="post"  cssStyle="display:none">
                                <table >
                                    <tr>
                                        <s:hidden id="upcardId" name="upcardId"/>
                                        <td class="formLable">Card Type<span class="mandatory">*</span></td> <td >:</td>
                                    <td><s:select  name="upasscard_type" id="upasscard_type" list="%{cardTypeList}" 
                                               listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 

                                    </tr> 
                                   
                                </table>
                                <table>
                                    <tr>
                                        <td>
                                            <s:url var="updateurl1" action="updateCard" />

                                            <sj:submit  id="updatebtn1" button="true" href="%{updateurl1}" value="Update"   targets="divmsg1" cssClass="button_aback"/> 
                                            <sj:a href="#" name="back" button="true" onclick="BackToMain12()"  cssClass="button_aback" >Back</sj:a> 
                                            </td>
                                        </tr>
                                    </table>
                            </s:form>



                    </div>
                    <div class="viewuser_tbl">
                        <div id="tablediv">
                            <sj:dialog 
                                id="confirmdialogbox" 
                                buttons="{ 
                                'OK':function() { deleteNow($(this).data('keyval'));$( this ).dialog( 'close' ); },
                                'Cancel':function() { $( this ).dialog( 'close' );} 
                                }" 
                                autoOpen="false" 
                                modal="true" 
                                title="Confirm Message"
                                width="400"
                                height="150"
                                position="center"
                                />
                            <sj:dialog 
                                id="dialogbox" 
                                buttons="{
                                'OK':function() { $( this ).dialog( 'close' );}
                                }"  
                                autoOpen="false" 
                                modal="true" 
                                title="Delete Message" 
                                width="400"
                                height="150"
                                position="center"
                                />



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
                                <sjg:gridColumn name="s_c_courseId" index="courseId" title="Course" />
                                <sjg:gridColumn name="s_c_cardType" index="cardType" title="Card Type" />
                                <sjg:gridColumn name="s_c_status" index="status" title="Status" />
                                <sjg:gridColumn name="s_c_id" index="sId" title="Edit" formatter="editformatter" align="center" width="200"/>
                                <sjg:gridColumn name="s_c_id" index="id" title="Delete" width="50" align="center" width="200"  formatter="deleteformatter" sortable="false"/>

                            </sjg:grid> 
                        </div>
                    </div>
                    <!--</div>-->
                    </section>

                </div>

                </body>
                <script>
                    $('#assgrade').change(function () {
                        var grade_id = $('#assgrade').find(":selected").val();
                        var sub_id = $('#assSubject').find(":selected").val();
                        loadData1(grade_id, sub_id);

                    });
                    function loadData1(grade_id, sub_id) {
                        if (sub_id != "") {
                            if (grade_id != "") {
                                $.ajax({
                                    url: '${pageContext.request.contextPath}/getCList',
                                    data: {sub_id: sub_id, grade_id: grade_id},
                                    dataType: "json",
                                    type: "POST",
                                    success: function (data) {
                                        var list = data.corList;
                                        $('#assCourse').empty();

                                        $('#assCourse').append($('<option>',
                                                {
                                                    value: "-1",
                                                    text: "---Select---"
                                                }));

                                        list.forEach(function (element) {
                                            console.log(element);
                                            $('#assCourse').append($('<option>',
                                                    {
                                                        value: element.id,
                                                        text: element.name
                                                    }));
                                        });
                                    },
                                    error: function (data) {
//                            window.location = "${pageContext.request.contextPath}/logOut";
                                        console.log(JSON.stringify(data));
                                    }
                                });
                            }
                        }
                    }
                </script>
                </html>

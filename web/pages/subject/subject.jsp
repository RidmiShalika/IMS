<%-- 
    Document   : subject
    Created on : Mar 22, 2018, 10:57:55 AM
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
                 $('#divmsg').empty();
                jQuery("#gridtable").trigger("reloadGrid");
            }
            function loadAddForm() {
                $('#searchForm').hide();
                $('#addForm').show();

            }
            function ResetAddForm() {
                $('#subjectname').val("");
//                 $('#subjectcode').val("");
                  $('#subjectmedium').val("");
                   $('#divmsg').empty();
               
                jQuery("#gridtable").trigger("reloadGrid");

            }
            function BackToMain() {
                $('#divmsg').empty();
                $('#searchForm').show();

                $('#addForm').hide()();
                
                jQuery("#gridtable").trigger("reloadGrid");
            }
            function BackToMain1() {
                 $('#divmsg').empty();
                $('#searchForm').show();
                $('#updateForm').hide()();
               
                jQuery("#gridtable").trigger("reloadGrid");
            }
            function editformatter(cellvalue, options, rowObject) {
//                 alert(cellvalues);
                return "<a href='#' onClick='javascript:editNow(&#34;" + cellvalue + "&#34;)'><img src ='${pageContext.request.contextPath}/resources/images/iconEdit.png' /></a>";
            } 
            function editNow(keyval) {

                $('#updateForm').show();
                $('#searchForm').hide();
                 $('#addForm').hide()();
                var text = ' Edit subject';

                $.ajax({
                    url: '${pageContext.request.contextPath}/findSubject',
                    data: {upsubjectname: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        $('#searchForm').hide();
                        $('#upsubjectname').val(data.upsubjectname);
                        
                         $('#upsubjectcode').val(data.upsubjectcode);
                         
                         if(data.upsubjectmedium === "Sinhala"){
                             $('#upsubjectmedium').val(1);
                         }else if(data.upsubjectmedium === "English"){
                             $('#upsubjectmedium').val(2);
                         }else if(data.upsubjectmedium === "Tamil"){
                             $('#upsubjectmedium').val(3);
                         } 
                         
                    },
                    error: function (data) {
//                        alert("error");
                        window.location = "${pageContext.request.contextPath}/logOut.action";
                    }
                });

            }
            function resetData() {

                jQuery("#gridtable").trigger("reloadGrid");
            }
            function resetSubUpdateForm() {
                var keyval = $('#upsubjectname').val();
//                    var keyval = 
//                alert(keyval);
                $.ajax({
                    url: '${pageContext.request.contextPath}/findSubject',
                    data: {upsubjectname: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
//                        alert(data.upsubjectname);
                        $('#searchForm').hide();
                        $('#upsubjectname').val(data.upsubjectname);
                        $('#upsubjectmedium').val(data.upsubjectmedium);
                         $('#upsubjectcode').val(data.upsubjectcode);
                         
                           jQuery("#gridtable").trigger("reloadGrid");

                    },
                    error: function (data) {
                        alert("error");
                        window.location = "${pageContext.request.contextPath}/logOut.action";
                    }
                });
                 $('#divmsg').empty();

            }
            $.subscribe('onclicksearch', function (event, data) {
                var searchname = $('#searchname').val();
                $("#gridtable").jqGrid('setGridParam', {postData: {searchname: searchname, search: true}});
//                $("#gridtable").jqGrid('setGridParam', {page: 1});
                jQuery("#gridtable").trigger("reloadGrid");
            });
            
              function deleteformatter(cellvalue, options, rowObject) {
                return "<a href='#' onClick='deleteInit(&#34;" + cellvalue + "&#34;)'><img src='${pageContext.request.contextPath}/resources/images/iconDelete.png'  /></a>";
            }
             function deleteInit(keyval) {
                $("#confirmdialogbox").data('keyval', keyval).dialog('open');
                $("#confirmdialogbox").html('<br><b><font size="3" color="red"><center>Please confirm to delete subject : ' + keyval + '');
                return false;
            }
            function deleteNow(keyval) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/deletestudent',
                    data: {subjectId: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        if (data.success) {
//                            alert("success");
//                            BackToMain();
                            $("#dialogbox").dialog('open');
                            $("#dialogbox").html('<br><b><font size="3" color="green"><center>' + data.message + ' ');
                        } else {
                            $("#dialogbox").dialog('open');
                            $("#dialogbox").html('<br><b><font size="3" color="red"><center>' + data.message + ' ');
                        }
                        jQuery("#gridtable").trigger("reloadGrid");
                    },
                    error: function (data) {
                        window.location = "${pageContext.request.contextPath}/LogoutloginCall";
                    }
                });

            }

        </script>
    </head>

    <body style="overflow:hidden" onload="load()">
        <section class="app-content">
            <jsp:include page="../../header.jsp" />    
            <div class="wrapper">
                <div class="body_content" id="includedContent" >
                    <div class="watermark"></div>
                    <div class="heading">Register Subject</div>
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
                                        <td style="font-size: 15px">Subject name</td>
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
                                                    <td class="formLable">Subject Name<span class="mandatory">*</span></td> <td >:</td>
                                                    <td><s:textfield id="subjectname" name="subjectname" cssClass="textField" /></td>                                    
                                                    <td width="25px;"></td>
<!--                                                    <td class="formLable">Subject Medium<span class="mandatory">*</span></td> <td>:</td>
                                                    <td><s:select  name="subjectmedium" id="subjectmedium" list="%{subList}" 
                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> -->
                                                </tr> 
<!--                                                 <tr>
                                                    <td class="formLable">Subject Code<span class="mandatory">*</span></td> <td >:</td>
                                                    <td><s:textfield id="subjectcode" name="subjectcode" cssClass="textField" /></td>                                    
                                                    <td width="25px;"></td>
                                                    
                                                </tr> -->
                                               
                
                                            </table>
                                            <table>
                                                <tr>
                                                    <td>
                                            <s:url var="addsubjecturl" action="Addsubject" />
                                            <!--<button type="button" id="addbtn" onclick= "javascript:location.href='Addstudent.action';" class="btn btn-primary">Add</button>-->
                                            <sj:submit  id="addbtn" button="true" href="%{addsubjecturl}" value="Add"   targets="divmsg" cssClass="button_aback"/> 
                                            <sj:submit button="true" value="Reset"  onclick="ResetAddForm()" cssClass="button_aback"/>
                                            <sj:submit id="backbtn" value="Back" onclick="BackToMain()" cssClass="button_aback"/>
                                        </td>
                                    </tr>
                                </table>
                            </s:form>
                            <s:form  id="updateForm"  theme="simple" method="post"  cssStyle="display:none">
                                <table >
                                    <tr>
                                        <td class="formLable">Subject Name</td> <td >:</td>
                                        <td><s:textfield id="upsubjectname" name="upsubjectname" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">Subject Medium</td> <td>:</td>
                                         <td><s:select  name="upsubjectmedium" id="upsubjectmedium" list="%{subList}" 
                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                    </tr> 
                                    <s:hidden id="upsubjectcode" name="upsubjectcode"/>
<!--                                    <tr>
                                        <td class="formLable">Subject Code</td> <td >:</td>
                                        <td><s:textfield id="upsubjectcode" name="upsubjectcode" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        
                                    </tr>-->
                                  
                                </table>
                                <table>
                                    <tr>
                                        <td>
                                            <s:url var="subjectupdateurl" action="updatesubject" />

                                            <sj:submit  id="updatebtn" button="true" href="%{subjectupdateurl}" value="Update"   targets="divmsg" cssClass="button_aback"/> 
                                            <sj:submit button="true" value="Reset" onclick="resetSubUpdateForm()" cssClass="button_aback"/>
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
                                
                                <s:url var="listurl" action="listsubject"/>
                                <sjg:grid
                                    id="gridtable"
                                    caption="Registered Subject"
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

                                    <sjg:gridColumn name="subjectId" index="subjectId" title="subjectId" hidden="true"/>
                                    <sjg:gridColumn name="subjectName" index="subjectName" title="Subject Name" width="400"/>
                                    <sjg:gridColumn name="subjectCode" index="subjectCode" title="Subject Code" width="400"/>
                                    <%--<sjg:gridColumn name="subjectMedium" index="subjectMedium" title="Subject Medium"width="350" />--%>
                                    
                                    <%--<sjg:gridColumn name="subjectName" index="subjectId" title="Edit" formatter="editformatter" align="center" sortable="false"/>--%>
                                    <%--<sjg:gridColumn name="subjectId" index="subjectId" title="Delete" formatter="deleteformatter" align="center" sortable="false"/>--%>

                                   
                                </sjg:grid> 
                            </div>
                        </div>
                    </div>
                    </section>

                </div>

                </body>
                </html>

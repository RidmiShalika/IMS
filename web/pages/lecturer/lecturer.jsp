<%-- 
    Document   : lecturer
    Created on : Mar 28, 2018, 1:21:27 PM
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
            .buttonS {
                color: white;
                background-color: blue;
            }


        </style>
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
                $('#title').val("");
                $('#firstname').val("");
                $('#address').val("");
                $('#email').val("");
                $('#gender').val("");
                $('#fullname').val("");
                $('#contact').val("");
                $('#nic').val("");
                $('#subject').val("");
                
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
                $('#searchForm').hide();

                var text = ' Edit User';

                $.ajax({
                    url: '${pageContext.request.contextPath}/findLecturer.action',
                    data: {ID: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        
                        $('#searchForm').hide();
                        $('#addForm').hide();
                        $('#upname').val(data.upname);
                        $('#upnic').val(data.upnic);
                        $('#upcontact').val(data.upcontact);
                        $('#upemail').val(data.upemail);
                        $('#upgender').val(data.upgender);
                        $('#upsubject').val(data.upsubject);
                        $('#upaddress').val(data.upaddress);
                        $('#uptitle').val(data.uptitle);
                         $('#uplecid').val(data.uplecid);
                          $('#upfullname').val(data.upfullname);
                        
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
                var keyval = $('#uplecid').val();
                $.ajax({
                    url: '${pageContext.request.contextPath}/findLecturer.action',
                    data: {ID: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {

                         $('#searchForm').hide();
                         $('#addForm').hide();
                        $('#upname').val(data.upname);
                        $('#upnic').val(data.upnic);
                        $('#upcontact').val(data.upcontact);
                        $('#upemail').val(data.upemail);
                        $('#upgender').val(data.upgender);
                        $('#upsubject').val(data.upsubject);
                        $('#upaddress').val(data.upaddress);
                        $('#uptitle').val(data.uptitle);
                         $('#uplecid').val(data.uplecid);
                        
                        jQuery("#gridtable").trigger("reloadGrid");

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

        </script>
    </head>

    <body style="overflow:hidden" onload="load()">
        <section class="app-content">
            <jsp:include page="../../header.jsp" />    
            <div class="wrapper">
                <div class="body_content" id="includedContent" >
                    <div class="watermark"></div>
                    <div class="heading">Register New Lecturer</div>
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
                                        <td style="font-size: 15px">Lecturer Name</td>
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
                                        <td class="formLable">Title</td> <td>:</td>

                                        <!--<td><s:textfield id="addtitle" name="addtitle" cssClass="textField" /></td>-->
                                        <td><s:select  name="addtitle" id="addtitle" list="%{titleList}" 
                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                        <td width="25px;"></td>
                                        <td class="formLable">First Name<span class="mandatory">*</span></td> <td>:</td>
                                        <td><s:textfield id="addfirstname" name="addfirstname" cssClass="textField" /></td>
                                    </tr> 
                                    <tr>
                                        <td class="formLable">Full Name<span class="mandatory">*</span></td> <td >:</td>
                                        <td><s:textfield id="addfullname" name="addfullname" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">NIC</td> <td>:</td>
                                        <td><s:textfield id="addnic" name="addnic" cssClass="textField" /></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Contact</td> <td >:</td>
                                        <td><s:textfield id="addcontact" name="addcontact" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">Email</td> <td>:</td>
                                        <td><s:textfield id="addemail" name="addemail" cssClass="textField" /></td>
                                    </tr>
                                    <tr>
<!--                                        <td class="formLable">Subject<span class="mandatory">*</span></td> <td >:</td>
                                        <td><s:textfield id="addsubject" name="addsubject" cssClass="textField" /></td>  
                                         <td><s:select  name="addsubject" id="addsubject" list="%{subjectList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                        <td width="25px;"></td>-->
                                        <td class="formLable">Gender<span class="mandatory">*</span></td> <td>:</td>
                                        <!--<td><s:textfield id="addgender" name="addgender" cssClass="textField" /></td>-->  
                                        <td><s:select  name="addgender" id="addgender" list="%{genList}" 
                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 

                                    </tr>

                                    <tr>
                                        <td class="formLable">Address</td> <td >:</td>
                                        <td><s:textfield id="addaddress" name="addaddress" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                    </tr>

                                </table>
                                <table>
                                    <tr>
                                        <td>
                                            <s:url var="addurl" action="AddLecturer" />
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
                                        <td class="formLable">Title<span class="mandatory">*</span></td> <td>:</td>

                                        <td><s:select  name="uptitle" id="uptitle" list="%{titleList}" 
                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                        <td width="25px;"></td>
                                        <td class="formLable">Address</td> <td >:</td>
                                        <td><s:textfield id="upaddress" name="upaddress" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                       
                                    </tr>
                                    <tr>
                                        <s:hidden id="uplecid" name="uplecid" cssClass="textField" />   
                                        <td class="formLable">Name<span class="mandatory">*</span></td> <td >:</td>
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
                                        <td class="formLable">Gender<span class="mandatory">*</span></td> <td >:</td>
                                        <!--<td><s:textfield id="upgender" name="upgender" cssClass="textField" /></td>-->   
                                        <td><s:select  name="upgender" id="upgender" list="%{genList}" 
                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                        <td width="25px;"></td>
                                 <td class="formLable">Full Name<span class="mandatory">*</span></td> <td >:</td>
                                        <td><s:textfield id="upfullname" name="upfullname" cssClass="textField" /></td>       
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
                                <s:url var="listurl" action="listlecturer"/>
                                <sjg:grid
                                    id="gridtable"
                                    caption="Registered Lecturer"
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

                                    <sjg:gridColumn name="ID" index="ID" title="LecturerId" hidden="true"/>
                                    <sjg:gridColumn name="name" index="name" title="Name" />
                                    <sjg:gridColumn name="title" index="title" title="Title" />
                                    <sjg:gridColumn name="firstname" index="firstname" title="First Name" />
                                    <sjg:gridColumn name="nic" index="nic" title="NIC" />
                                    <%--<sjg:gridColumn name="subject_code" index="subject_code" title="Subject Code" />--%>
                                    <sjg:gridColumn name="email" index="email" title="Email" />
                                    <sjg:gridColumn name="contact" index="contact" title="Contact No" />
                                    <sjg:gridColumn name="gender" index="gender" title="Gender" />
                                    <sjg:gridColumn name="address" index="address" title="Address" />
                                    <sjg:gridColumn name="regDate" index="regDate" title="Reg Date" /> 
                                   
                                    <sjg:gridColumn name="ID" index="ID" title="Edit" formatter="editformatter" align="center"/>

                                </sjg:grid> 
                            </div>
                        </div>
                    </div>
                    </section>

                </div>

                </body>
                </html>

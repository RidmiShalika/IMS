<%-- 
    Document   : student
    Created on : Mar 8, 2018, 9:13:45 AM
    Author     : ridmi_g
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>      

<html>
    <head>
        <%--<sj:head jqueryui="true" jquerytheme="redmond" />--%>
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
            }
            function loadAddForm() {
                $('#searchForm').hide();
                $('#addForm').show();

            }
            function ResetAddForm() {
                $('#name').val("");
                $('#firstname').val("");
                $('#address').val("");
                $('#email').val("");
                $('#gender').val("");
                $('#yearOfRegistration').val("");
                $('#telephone').val("");
                $('#school').val("");
                $('#birthday').val("");
                $('#parentContactNo').val("");
                $('#cardno').val("");
                jQuery("#gridtable").trigger("reloadGrid");

            }
            function BackToMain() {
                $('#searchForm').show();

                $('#addForm').hide()();
                $('#divmsg').empty();
                jQuery("#gridtable").trigger("reloadGrid");
            }
            function BackToMain1() {
                $('#searchForm').show();
                $('#divmsg').empty();
                $('#updateForm').hide()();
                
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
                    <div class="heading">Register New Student</div>
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
                                        <td style="font-size: 15px">Student Name</td>
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
                                                    <td class="formLable">Name<span class="mandatory">*</span></td> <td >:</td>
                                                    <td><s:textfield id="name" name="name" cssClass="textField" /></td>                                    
                                                    <td width="25px;"></td>
                                                    <td class="formLable">First Name<span class="mandatory">*</span></td> <td>:</td>
                                                    <td><s:textfield id="firstname" name="firstname" cssClass="textField" /></td>
                                                </tr> 
                                                <tr>
                                                    <td class="formLable">Address<span class="mandatory">*</span></td> <td >:</td>
                                                    <td><s:textfield id="address" name="address" cssClass="textField" /></td>                                    
                                                    <td width="25px;"></td>
                                                    <td class="formLable">Email<span class="mandatory">*</span></td> <td>:</td>
                                                    <td><s:textfield id="email" name="email" cssClass="textField" /></td>
                                                </tr>
                                                <tr>
                                                    <td class="formLable">Gender<span class="mandatory">*</span></td> <td >:</td>
                                                    <!--<td><s:textfield id="gender" name="gender" cssClass="textField" /></td>-->    
                                                   <td><s:select  name="gender" id="gender" list="%{genderlList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                                    
                                                    
                                                    <td width="25px;"></td>
                                                    <td class="formLable">Year of Registration<span class="mandatory">*</span></td> <td>:</td>
                                                    <td><s:textfield id="yearOfRegistration" name="yearOfRegistration" cssClass="textField" /></td>
                                                </tr>
                                                <tr>
                                                    <td class="formLable">Telephone<span class="mandatory">*</span></td> <td >:</td>
                                                    <td><s:textfield id="telephone" name="telephone" cssClass="textField" /></td>                                    
                                                    <td width="25px;"></td>
                                                    <td class="formLable">School<span class="mandatory">*</span></td> <td>:</td>
                                                    <!--<td><s:textfield id="school" name="school" cssClass="textField" /></td>-->
                                                     <td><s:select  name="school" id="school" list="%{schoolList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                                </tr>
                                                <tr>
                                                    <td class="formLable">Birth Day<span class="mandatory">*</span></td> <td >:</td>
                                                    <td><s:textfield id="birthday" name="birthday" cssClass="textField" /></td>                                    
                                                    <td width="25px;"></td>
                                                    <td class="formLable">Parent Contact No<span class="mandatory">*</span></td> <td>:</td>
                                                    <td><s:textfield id="parentContactNo" name="parentContactNo" cssClass="textField" /></td>
                                                </tr>
                                                <tr>
                                                    <td class="formLable">Card No<span class="mandatory">*</span></td> <td >:</td>
                                                    <td><s:textfield id="cardno" name="cardno" cssClass="textField" /></td>                                    
                                                    <td width="25px;"></td>
                                                </tr>
                
                                            </table>
                                            <table>
                                                <tr>
                                                    <td>
                                            <s:url var="addurl" action="Addstudent" />
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
                                        <td class="formLable">Name</td> <td >:</td>
                                        <td><s:textfield id="upname" name="upname" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">First Name</td> <td>:</td>
                                        <td><s:textfield id="upfirstname" name="upfirstname" cssClass="textField" /></td>
                                    </tr> 
                                    <tr>
                                        <td class="formLable">Address</td> <td >:</td>
                                        <td><s:textfield id="upaddress" name="upaddress" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">Email</td> <td>:</td>
                                        <td><s:textfield id="upemail" name="upemail" cssClass="textField" /></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Gender</td> <td >:</td>
                                        <td><s:textfield id="upgender" name="upgender" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">Year of Registration</td> <td>:</td>
                                        <td><s:textfield id="upyearOfRegistration" name="upyearOfRegistration" cssClass="textField" /></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Telephone</td> <td >:</td>
                                        <td><s:textfield id="uptelephone" name="uptelephone" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">School</td> <td>:</td>
                                        <!--<td><s:textfield id="upschool" name="upschool" cssClass="textField" /></td>-->
                                        <td><s:select  name="upschool" id="upschool" list="%{schoolList}" 
                                                     listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                    </tr>
                                    <tr>
                                        <td class="formLable">Birth Day</td> <td >:</td>
                                        <td><s:textfield id="upbirthday" name="upbirthday" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">Parent Contact No</td> <td>:</td>
                                        <td><s:textfield id="upparentContactNo" name="upparentContactNo" cssClass="textField" /></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Card No</td> <td >:</td>
                                        <td><s:textfield id="upcardno" name="upcardno" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                    </tr>

                                </table>
                                <table>
                                    <tr>
                                        <td>
                                            <s:url var="updateurl" action="updatestudent" />

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
                                <s:url var="listurl" action="liststudent"/>
                                <sjg:grid
                                    id="gridtable"
                                    caption="Registered Student"
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

                                    <sjg:gridColumn name="sId" index="sId" title="StudentId" hidden="true"/>
                                    <sjg:gridColumn name="sName" index="sName" title="Name" />
                                    <sjg:gridColumn name="sDob" index="sDob" title="Birthday" />
                                    <sjg:gridColumn name="sAddress" index="sAddress" title="Address" />
                                    <sjg:gridColumn name="sEmail" index="sEmail" title="Email" />
                                    <sjg:gridColumn name="sGender" index="sGender" title="Gender" />
                                    <sjg:gridColumn name="sYor" index="sYor" title="Year" />
                                    <sjg:gridColumn name="sTelephone" index="sTelephone" title="Telephone No" />
                                    <sjg:gridColumn name="sSchool" index="sSchool" title="School" />
                                    <sjg:gridColumn name="sParentContactNo" index="sParentContactNo" title="Parent Con.No" />
                                    <sjg:gridColumn name="sParentEmail" index="sParentEmail" title="Parent Email" /> 
                                    <sjg:gridColumn name="sParentName" index="sParentName" title="Parent Name" />
                                    <sjg:gridColumn name="sNic" index="sNic" title="NIC" />
                                    <sjg:gridColumn name="cardNumber" index="cardNumber" title="Card No" />
                                    <sjg:gridColumn name="sName" index="sName" title="Edit" formatter="editformatter" align="center"/>

                                </sjg:grid> 
                            </div>
                        </div>
                    </div>
                    </section>

                </div>

                </body>
                </html>


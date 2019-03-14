<%-- 
    Document   : privileges
    Created on : Apr 6, 2018, 2:04:01 PM
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
            }
            function loadAddForm() {
                $('#searchForm').hide();
                $('#addForm').show();

            }
            function ResetAddForm() {
                $('#addname').val("");
                $('#addgender').val("-1");
                $('#addaddress').val("");
                $('#addnic').val("");
                $('#addcontact').val("");
                $('#addusername').val("");
                $('#adduserrole').val("-1");
                $('#addpassword').val("");
                $('#addconfirmpassword').val("");
                 $('#divmsg').hide();
                
                jQuery("#gridtable").trigger("reloadGrid");

            }
            function BackToMain() {
                $('#searchForm').show();
                $('#taskasinForm').hide();
                $('#addForm').hide()();
                $('#divmsg').empty();
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
                return "<a href='#' onClick='javascript:assineTaskNow(&#34;" + cellvalue + "&#34;)'><img src ='${pageContext.request.contextPath}/resources/images/iconEdit.png' /></a>";
            }

            function resetData() {

                jQuery("#gridtable").trigger("reloadGrid");
            }
            function assineTaskNow(keyval) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/Findprivileges',
                    data: {userRoleId: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {

                        $('#taskasinForm').show();
                        $('#editForm').hide();
                        $('#searchForm').hide();
                        $('#addForm').hide();
                        $('#userRoleId').val(data.userRoleId);
                        $('#description').attr('readOnly', true);
                        $('#description').val(data.description);
                        $('#newBox2').empty();

                        $.each(data.alreadyAcsessPageMap, function (key, value) {
                            $('#newBox2').append($('<option></option>').val(key).html(value));
                        });

                    },
                            
                    error: function (data) {
                        window.location = "${pageContext.request.contextPath}/LogoutloginCall";
                    }
                }
                );
            }
            function ResetTaskAsinForm() {
                $('#divmsg').hide();
                $('#pageId').val(-1);
            }

            $.subscribe('onclicksearch', function (event, data) {
                var searchname = $('#searchname').val();
                $("#gridtable").jqGrid('setGridParam', {postData: {searchname: searchname, search: true}});
//                $("#gridtable").jqGrid('setGridParam', {page: 1});
                jQuery("#gridtable").trigger("reloadGrid");
            });
            function addPrivilage() {
 
                var pageId = [];
                $('#newBox2 option').each(function() { 
                pageId.push( $(this).attr('value') );
//                alert(pageId)
                });
                var userRoleId=$("#description").val()
//                alert(userRoleId);
                
                $.ajax({
                    url: '${pageContext.request.contextPath}/Addprivileges',
                    data: {pageId: pageId, description: $("#description").val()},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        alert(JSON.stringify(data));
                        $('#divmsg').show();
                        alert(data.success);
                        if (data.success) {
                            alert("data sucess");
                            document.getElementById("divmsg").innerHTML = "Successfully Updated";
                        } else {
                            alert("data not sucess");
                            document.getElementById("divmsg").innerHTML = "Updated Error ";
                            $("divmsg").css("background-color", "red");
                        }


                    },
                    error: function (data) {
                        alert("error");
                        window.location = "${pageContext.request.contextPath}/LogoutloginCall";

                    }
                }
                );
            }

            function toright2() {
                $("#currentBox2 option:selected").each(function () {

                    $("#newBox2").append($('<option>', {
                        value: $(this).val(),
                        text: $(this).text()
                    }));
                    (this).remove();

                })
            }
            function toleft2() {
                $("#newBox2 option:selected").each(function () {
                        $("#currentBox2").append($('<option>', {
                            value: $(this).val(),
                            text: $(this).text()
                        }));
                        $(this).remove();
                })
            }
            function toleftall2() {
                $("#newBox2 option").each(function () {

                    $("#currentBox2").append($('<option>', {
                        value: $(this).val(),
                        text: $(this).text()
                    }));
                    $(this).remove();

                });
            }
            function torightall2() {
                $("#currentBox2 option").each(function () {

                    $("#newBox2").append($('<option>', {
                        value: $(this).val(),
                        text: $(this).text()
                    }));
                    $(this).remove();
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
                    <div class="heading">Privileges Assigning</div>
                    <div class="AddUser_box ">
                        <div class="message">         
                            <s:div id="divmsg">
                                <i style="color: red">  <s:actionerror theme="jquery"/></i>
                                <i style="color: green"> <s:actionmessage theme="jquery"/></i>
                            </s:div>         
                        </div>
                        <div class="contentcenter">
                            <s:form id="searchForm"  theme="simple">         
<!--                                <table >              
                                    <tr>
                                        <td style="font-size: 15px">User Name</td>
                                        <td>:</td>
                                        <td colspan="2"><s:textfield name="searchname"  id="searchname" cssClass="textField" /> </td>
                                        <td class="content_td formLable">

                                        </td>
                                    </tr>
                                </table>-->
                                <table>
                                    <br/>
                                    <tr>                                
                                        <td> 


                                            <%--<sj:a     button="true"    onClickTopics="onclicksearch"  cssClass="button_aback"  role="button" >Search</sj:a>--%>

                                            <sj:a     button="true"    onClickTopics="loadAddForm" onclick="loadAddForm()"  cssClass="button_aback"  role="button" >Add</sj:a>
                                            <%--<sj:a     button="true"  onclick="ResetSearchForm1()"  cssClass="button_aback"  role="button" >Reset</sj:a>--%>

                                            </td>
                                        </tr>
                                    </table>
                            </s:form>
                            <s:form  id="addForm"  theme="simple" method="post"  cssStyle="display:none">
                                <table >
                                    <tr>
                                        <td class="formLable">Name<span class="mandatory">*</span></td> <td >:</td>
                                        <td><s:textfield id="addname" name="addname" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">Gender<span class="mandatory">*</span></td> <td>:</td>
                                        <!--<td><s:textfield id="addgender" name="addgender" cssClass="textField" /></td>-->
                                        <td><s:select  name="addgender" id="addgender" list="%{genderlList}" 
                                                   listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td> 
                                    </tr> 
                                    <tr>
                                        <td class="formLable">Address</td> <td >:</td>
                                        <td><s:textfield id="addaddress" name="addaddress" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">NIC</td> <td>:</td>
                                        <td><s:textfield id="addnic" name="addnic" cssClass="textField" /></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Contact</td> <td >:</td>
                                        <td><s:textfield id="addcontact" name="addcontact" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">User Name<span class="mandatory">*</span></td> <td >:</td>
                                        <td><s:textfield id="addusername" name="addusername" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">User Role<span class="mandatory">*</span></td> <td>:</td>
                                        <!--<td><s:textfield id="adduserrole" name="adduserrole" cssClass="textField" /></td>-->
                                        <td><s:select  name="adduserrole" id="adduserrole" list="%{userroleList}" 
                                                   listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>                           
                                    </tr>
                                    <tr>
                                        <td class="formLable">Password<span class="mandatory">*</span></td> <td >:</td>
                                        <td><s:textfield id="addpassword" name="addpassword" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable">Confirm Password<span class="mandatory">*</span></td> <td>:</td>
                                        <td><s:textfield id="addconfirmpassword" name="addconfirmpassword" cssClass="textField" /></td>
                                    </tr>

                                </table>
                                <table>
                                    <tr>
                                        <td>
                                            <s:url var="addurl" action="Adduser" />
                                            <!--<button type="button" id="addbtn" onclick= "javascript:location.href='Addstudent.action';" class="btn btn-primary">Add</button>-->
                                            <sj:submit  id="addbtn" button="true" href="%{addurl}" value="Add"   targets="divmsg" cssClass="button_aback"/> 
                                            <sj:submit button="true" value="Reset"  onclick="ResetAddForm()" cssClass="button_aback"/>
                                            <sj:submit id="backbtn" value="Back" onclick="BackToMain()" cssClass="button_aback"/>
                                        </td>
                                    </tr>
                                </table>
                            </s:form>

                            <s:form id="taskasinForm"  theme="simple" method="post" cssStyle="display:none" >
                                <table class="form_table">
                                    <s:hidden id="userRoleId" name="userRoleId" />     
                                    <tr>
                                        <td class="formLable">Profile Name</td> <td >:</td>
                                        <td><s:textfield id="description" name="description" cssClass="textField" /></td>                                    
                                        <td width="25px;"></td>
                                        <td class="formLable"></td> <td></td>
                                        <td></td>
                                    </tr>  
                                  
                                    <tr>
                                       
                                    <div class="d-row">
                                        <label class="col-1 form-label">Pages<sup class="required">*</sup></label>
                                        <div class="right-col form-field move-items">
                                            <td>
                                                <s:select multiple="true" name="currentBox2" id="currentBox2" list="pageIdList" ondblclick="toright2()"  cssClass="ddl-input width-15" size="10" />
                                            </td>
                                            <td>
                                                <div class="inline-fields">
                                                <button type="button" id="left2" onClick="toleft2()" class="btn default-button"><i class="fa fa-angle-left" aria-hidden="true"></i></button>
                                                <button type="button" id="leftall2" onClick="toleftall2()" class="btn default-button"><i class="fa fa-angle-double-left" aria-hidden="true"></i></button>
                                                <button type="button" id="right2" onClick="toright2()" class="btn default-button"><i class="fa fa-angle-right" aria-hidden="true"></i></button>
                                                <button type="button" id="rightall2" onClick="torightall2()" class="btn default-button lnk"><i class="fa fa-angle-double-right" aria-hidden="true"></i></button>
                                            </div>
                                            </td>
                                            <td>
                                                <s:select multiple="true"  name="newBox2" id="newBox2" list="alreadyAcsessPageMap" cssClass="ddl-input width-15" size="10" />
                                            </td>
                                           
                                        </div>
                                    </div>
                                   <div class="d-row">
                                                
                                    </div>

                                    </tr>

                                </table>
                                <table class="form_table">
                                    <tr>
                                        <td colspan="4" height="5px"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                  

                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="content_td formLable" colspan="7"><span class="mandatory_text">Mandatory fields are marked with</span><span class="mandatory">*</span></td>
                                    </tr>
                                </table>
                                <table class="form_table">
                                    </br>
                                    <tr>                                
                                        <td> 
                                            <s:url var="updateuserurl" action="UpdateTaskusrprofileMng"/>                                   
                                            <sj:submit id="assignbut"  href="%{updateuserurl}"  targets="divmsg"  value="Add"  button="true"  cssStyle="display: none; visibility: hidden;"  />
                                            <sj:a button="true"  onclick="addPrivilage()" cssClass="button_sadd"  >Update</sj:a></td>
                                        </td> <td>  

                                    <sj:submit button="true" value="Reset" onClick="ResetTaskAsinForm()" cssClass="button_sreset"/>
                                    <sj:a href="#" name="back" button="true" onclick="BackToMain()"  cssClass="button_aback" >Back</sj:a>    
                                    </td>
                                </tr>
                            </table>
                    </s:form> 

                </div>
                <div class="viewuser_tbl">
                    <div id="tablediv">
                        <s:url var="listurl" action="listpriviles"/>
                        <sjg:grid
                            id="gridtable"
                            caption="Registered Users"
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

                            <sjg:gridColumn name="userRoleId" index="Id" title="userRoleId" hidden="true"/>
                            <sjg:gridColumn name="role" index="role" title="Role" />

                            <sjg:gridColumn name="userRoleId" index="userRoleId" title="Edit" formatter="editformatter" align="center"/>

                        </sjg:grid> 
                    </div>
                </div>
            </div>
            </section>

   

        </body>
        </html>

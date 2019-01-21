<%-- 
    Document   : attendence
    Created on : Oct 10, 2018, 10:51:41 AM
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
            
            function ResetForm(){
                $('#attenid').val("");
            }
            function keyPress() {
                
                var keyval = $('#attenid').val();
                
                 $.ajax({
                    url: '${pageContext.request.contextPath}/findSt',
                    data: {attenid: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        window.location.href = "${pageContext.request.contextPath}/pages/atten/atte.jsp";
                    },
                    error: function (data) {
                    }
                });
            }
//            function keyPress() {
//                var keyval = $('#attenid').val();
//                $("#viewdialog").data('Id', keyval);
//                $("#viewdialog").data('sId', keyval).dialog('open');
//            }
//             $.subscribe('openview', function (event, data) {
//                var $led = $("#viewdialog");
//                $led.load("findSt?attenid=" + $led.data('Id'));
//            });

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
                        <div class="contentcenter">


                            <s:form id="mainForm"  theme="simple" >
                                <table class="form_table">

                                    <tr>
                                        <td class="formLable">ID</td> <td >:</td>
                                        <td><s:textfield id="attenid" name="attenid" cssClass="textField"/></td>
                                    </tr>


                                    <tr>
                                        <td>
                                            <sj:submit button="true" value="Atten"  onclick="keyPress()" cssClass="button_aback"/>
                                            <%--<sj:submit button="true" value="Reset"  onclick="ResetForm()" cssClass="button_aback"/>--%>
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
                                        title="Assign To Courses"
                                        onOpenTopics="openview" 
                                        loadingText="Loading .."
                            />
                                
                               
                            </div>
                        </div>

                    </div>

                    </section>



                    </body>
                    </html>

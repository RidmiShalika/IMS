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
//                 if (e.keyCode === 13) {
//                      window.location.href = "${pageContext.request.contextPath}/pages/course/stopClass.jsp";
//                     alert(${pageContext.request.contextPath});
                     window.location.href = "${pageContext.request.contextPath}/pages/atten/atte.jsp";
//                }
            }

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

                    </div>

                    </section>



                    </body>
                    </html>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Styles.jsp" />
        
        <script type="text/javascript">
           

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


                            <s:form id=""  theme="simple" >
                                <table class="form_table">
                                    <tr>
                                        <td class="formLable">Student Details</td> 
                                    </tr>
                                    <tr>
                                        <td class="formLable">Name</td> <td >:</td>
                                        <td><s:label id="name" name="name" cssClass="textField"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Reg ID</td> <td >:</td>
                                        <td><s:label id="regID" name="regID" cssClass="textField"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">School</td> <td >:</td>
                                        <td><s:label id="school" name="school" cssClass="textField"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Reg Date</td> <td >:</td>
                                        <td><s:label id="regDate" name="regDate" cssClass="textField"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Card Type</td> <td >:</td>
                                        <td><s:label id="cardType" name="cardType" cssClass="textField"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Payments</td> <td >:</td>
                                        <td><s:label id="payments" name="payments" cssClass="textField"/></td>
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

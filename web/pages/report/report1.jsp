<%-- 
    Document   : report1
    Created on : Jul 3, 2018, 10:31:38 AM
    Author     : ridmi_g
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%> 
<!DOCTYPE html>
<html>
    <head>

    </head>
    <body>
        <section class="app-content">
            <%--<jsp:include page="../../header.jsp" />--%>    



            <div class="contentcenter">
                <s:form  id="genarateForm"  theme="simple" method="post">
                    <table >
                        <tr>
                            <td class="formLable">Select Month<span class="mandatory">*</span></td> <td >:</td>
                            <td><s:select  name="month" id="month" list="%{monthlList}" 
                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>                                   
                            <td width="25px;"></td>
                            <td class="formLable">Select Year<span class="mandatory">*</span></td> <td>:</td>
                            <td><s:select  name="year" id="year" list="%{yearlList}" 
                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>  
                        </tr> 
                        <tr>
                            <td class="formLable">Select lecture Name<span class="mandatory">*</span></td> <td >:</td>
                            <td><s:select  name="lectureName" id="lectureName" list="%{lectureNamelList}" 
                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>                                   


                        </tr> 
                        <tr>
                            <td class="formLable">Select Course<span class="mandatory">*</span></td> <td >:</td>
                            <td><s:select  name="course" id="course" list="%{courselList}" 
                                       listKey="key" listValue="value"  headerKey="-1"  headerValue="---Select---"     cssClass="dropdown" /></td>                                   

                        </tr> 
                        <tr>
                            <td>
                                <s:url var="genurl" action="GenCoursePayment" />
                                <sj:submit  id="genbtn" button="true" href="%{genurl}" value="Generate Report" cssStyle="width: 150px" cssClass="button_aback"/>
                            </td>
                        </tr>
                    </table>
                </s:form>
            </div>



        </section>



    </body>
</html>

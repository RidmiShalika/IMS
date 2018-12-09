<%-- 
    Document   : report8
    Created on : Oct 4, 2018, 9:36:52 AM
    Author     : ridmi_g
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section class="app-content">
         
            <div class="contentcenter">
                <s:form  id="genarateForm6"  theme="simple" method="post">
                    <table >
                   
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
                                <s:url var="genur8" action="GenCoursePayment8" />
                                <sj:submit  id="genbtn8" button="true" href="%{genur8}" value="Generate Report" cssStyle="width: 150px" cssClass="button_aback"/>
                            </td>
                        </tr>
                       
                    </table>
                </s:form>
            </div>



        </section>



    </body>
</html>

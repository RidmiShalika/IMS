<%-- 
    Document   : report9
    Created on : Oct 4, 2018, 9:36:59 AM
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
                <s:form  id="genarateForm9"  theme="simple" method="post">
                    <table >
                        <tr>
                            <td class="formLable">No of Courses<span class="mandatory">*</span></td> <td >:</td>
                            <td><s:textfield  name="noOfCourses" id="noOfCourses"  cssClass="textFiled" /></td>                                   
                        </tr> 
                       
                        <tr>
                            <td>
                                <s:url var="genurl9" action="GenCoursePayment9" />
                                <sj:submit  id="genbtn9" button="true" href="%{genurl9}" value="Generate Report" cssStyle="width: 150px" cssClass="button_aback"/>
                            </td>
                        </tr>
                    </table>
                </s:form>
            </div>



        </section>



    </body>
</html>

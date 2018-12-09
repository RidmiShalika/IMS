<%-- 
    Document   : report11
    Created on : Oct 4, 2018, 9:37:17 AM
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
                <s:form  id="genarateForm11"  theme="simple" method="post">
                    <table >
                      
                        <tr>
                            <td class="formLable">From<span class="mandatory">*</span></td> <td >:</td>
                            <td><sj:datepicker id="fromDate" name="fromDate"  value="today"   changeYear="true" buttonImageOnly="true" displayFormat="yy-mm-dd"  cssClass="textField"/></td>
                        
                            <td class="formLable">To<span class="mandatory">*</span></td> <td >:</td>
                            <td><sj:datepicker id="toDate" name="toDate"  value="today"   changeYear="true" buttonImageOnly="true" displayFormat="yy-mm-dd"  cssClass="textField"/></td>
                        </tr>
                        
                        <tr>
                            <td>
                                <s:url var="genurl11" action="GenCoursePayment11" />
                                <sj:submit  id="genbtn11" button="true" href="%{genurl11}" value="Generate Report" cssStyle="width: 150px" cssClass="button_aback"/>
                            </td>
                        </tr>
                    </table>
                </s:form>
            </div>

        </section>
    </body>
</html>

<%-- 
    Document   : report3
    Created on : Oct 4, 2018, 9:36:12 AM
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
                <s:form  id="genarateForm3"  theme="simple" method="post">
                    <table >
                        <tr>
                            <td class="formLable">Select Date<span class="mandatory">*</span></td> <td >:</td>
                            <td><sj:datepicker maxDate="today"  id="date" name="date"  value="today"   changeYear="true" buttonImageOnly="true" displayFormat="yy-mm-dd"  cssClass="textField"/></td>
                            <td width="25px;"></td>
                            
                        </tr> 
                      
                        <tr>
                            <td>
                                <s:url var="genur3" action="GenCoursePayment3" />
                                <sj:submit  id="genbtn3" button="true" href="%{genur3}" value="Generate Report" cssStyle="width: 150px" cssClass="button_aback"/>
                            </td>
                        </tr>
                       
                    </table>
                </s:form>
            </div>



        </section>



    </body>
</html>

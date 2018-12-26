<%-- 
    Document   : payAdd
    Created on : Dec 26, 2018, 10:40:57 AM
    Author     : ridmi_g
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
             $(document).ready(function () { 
                  $.ajax({
                    url: '${pageContext.request.contextPath}/getadmissionInfo',
                    dataType: "json",
                    type: "GET",
                    success: function (data) {
                       $('#pay_status').val(data.pay_status);
                       $('#payment_date').val(data.payment_date);
                    },
                    error: function (data) {
                       
                    }
                });
             });
            
            
        </script>
    </head>
    <body style="overflow:hidden" onload="load()">
        <section class="app-content">
            <div class="wrapper">
                <div class="body_content" id="includedContent" >
                    <div class="watermark"></div>
                        <div class="message">         
                            <s:div id="divmsg2">
                                <i style="color: red">  <s:actionerror theme="jquery"/></i>
                                <i style="color: green"> <s:actionmessage theme="jquery"/></i>
                            </s:div>         
                        </div>
                        <div class="contentcenter">
                            <s:form  id="payAddmission"  theme="simple" method="post">
                                <table>
                                     <tr>
                                        <td class="formLable">Payment Status</td> <td >:</td>
                                        <td><s:textfield id="pay_status" name="pay_status" disabled="true" cssClass="textField"></s:textfield></td>
                                    </tr>
                                     <tr>
                                        <td class="formLable">Payment Date</td> <td >:</td>
                                        <td><s:textfield id="payment_date" name="payment_date" disabled="true" cssClass="textField"></s:textfield></td>
                                    </tr>
                                    <tr>
                                       <td class="formLable">Payment Amount</td> <td >:</td>
                                       <td><s:textfield id="payment_amount" name="payment_amount" cssClass="textField"></s:textfield></td>
                                    </tr>
                                
                                </table>
                                    <table>
                                    <tr>
                                        <td>
                                            <s:url var="paymentaddurl" action="payment" />

                                            <sj:submit  id="assAddbtn" button="true" href="%{paymentaddurl}" value="Add"   targets="divmsg2" cssClass="button_aback"/> 
                                            </td>
                                        </tr>
                                    </table>
                            </s:form>
                           
                                        
                            

                        </div>
                        
                    <!--</div>-->
                    </section>

                </div>

                </body>
</html>


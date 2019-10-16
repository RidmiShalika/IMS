
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Styles.jsp" />

        <script type="text/javascript">
            $(document).ready(function () {
                //load student and lecture details and mark attendence
                var paymentjsp = "0";
                $.ajax({
                    url: '${pageContext.request.contextPath}/loadandattendence',
                    data: {paymentjsp: paymentjsp},
                    dataType: "json",
                    type: "GET",
                    success: function (data) {
                        $('#name').val(data.name);
                        $('#regID').val(data.regID);
                        $('#school').val(data.school);
                        $('#regDate').val(data.regDate);
                        $('#addcardType').val(data.addcardType);
                        $('#addpayments').val(data.addpayments);

                        $('#lname').val(data.lname);
                        $('#crdType').val(data.crdType);
                        $('#time').val(data.time);
                        $('#courseId').val(data.courseId);
                        $('#extra_normal').val(data.extra_normal);

                        $('#testid').val(data.attandance_history);
                        $('#phisid').val(data.payment_history);
                    },
                    error: function (data) {

                    }
                });
            });

            function paymentformatter(cellvalue, options, rowObject) {
                return "<a href='#' onClick='javascript:pay(&#34;" + cellvalue + "&#34;,&#34;" + rowObject.id + "&#34;)'><i class='fa fa-share-square-o' aria-hidden='true'></i></a>";
            }
            function pay(keyval) {
                //load history lists
                $('#testid').val("");
                $('#phisid').val("");
                $.ajax({
                    url: '${pageContext.request.contextPath}/loadhistorylist',
                    data: {attenid: keyval},
                    dataType: "json",
                    type: "GET",
                    success: function (data) {
                        $('#testid').val(data.attandance_history);
                        $('#phisid').val(data.payment_history);
                    },
                    error: function (data) {
                        alert("error");
                    }
                });
            }
            function test() {

                var selected_data = $('#gridtable').jqGrid('getGridParam', 'selarrrow');
//                alert('selected rows:' + selected_data);

                $.ajax({
                    url: '${pageContext.request.contextPath}/paymentmark',
                    data: {selected_data: selected_data},
                    dataType: "json",
                    type: "GET",
                    success: function (data) {
                        alert("Payment Successfully Completed");
                        jQuery("#gridtable").trigger("reloadGrid");
//                        alert("data.hiddBillid "+data.hiddBillid);
                        
//                        $('#hiddBillid').val(data.hiddBillid);
//                        $('#downloadbut').click();
                        

                    },
                    error: function (data) {
                        alert("Payment Error");
                    }

                });
            }
            $('#gridtable.id').change(function () {
                alert('changed');
            });

        </script>
    </head>
    <body style="overflow:hidden" onload="load()">
        <section class="app-content">
            <jsp:include page="../../header.jsp" />    
            <div class="wrapper">
                <div class="body_content" id="includedContent" >
                    <div class="watermark"></div>
                    <div class="heading">Payments</div>
                    <div class="AddUser_box ">
                        <div class="message">         
                            <s:div id="divmsg">
                                <i style="color: red">  <s:actionerror theme="jquery"/></i>
                                <i style="color: green"> <s:actionmessage theme="jquery"/></i>
                            </s:div>         
                        </div>
                        <div class="col-sm-6 col-md-6">
                            <s:form id="studentDetailsForm"  theme="simple" >
                                <table>
                                    <tr>
                                        <td class="formLable">Student Details</td> 
                                    </tr>
                                    <tr>
                                        <td class="formLable">Name</td> <td >:</td>
                                        <td><s:textfield id="name" name="name" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Reg ID</td> <td >:</td>
                                        <td><s:textfield id="regID" name="regID" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">School</td> <td >:</td>
                                        <td><s:textfield id="school" name="school" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">Reg Date</td> <td >:</td>
                                        <td><s:textfield id="regDate" name="regDate" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                    <!--                                    <tr>
                                                                            <td class="formLable">Card Type</td> <td >:</td>
                                                                            <td><s:textfield id="addcardType" name="addcardType" cssClass="textField" disabled="true"/></td>
                                                                        </tr>-->
                                    <tr>
                                        <td class="formLable">Payments</td> <td >:</td>
                                        <td><s:textfield id="addpayments" name="addpayments" cssClass="textField" disabled="true"/></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <%--<sj:submit button="true" value="Atten"  onclick="keyPress()" cssClass="button_aback"/>--%>
                                        </td>
                                    </tr>
                                </table>

                            </s:form>
                            
                            <br><br>
                           
                            <div class="viewuser_tbl">
                                <div id="tablediv">
                                    <s:url var="listurl" action="liststatt"/>
                                    <sjg:grid
                                        id="gridtable"
                                        caption="Student Payment"
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
                                        multiselect="true"
                                        >

                                        <sjg:gridColumn name="id" index="id" title="id" hidden="true" width="10"/>
                                        <sjg:gridColumn name="id" index="id" title="His" width="50" formatter="paymentformatter"/>
                                        <sjg:gridColumn name="sid" index="sid" title="Student Id" width="80"/>
                                        <sjg:gridColumn name="cid" index="cid" title="Course Id" width="80"/>
                                        <sjg:gridColumn name="year" index="v" title="Year" width="100"/>
                                        <sjg:gridColumn name="month" index="month" title="Month" width="130"/>
                                        <sjg:gridColumn name="status" index="status" title="Status" width="100"/>



                                    </sjg:grid> 
                                </div>
                                     <table>
                                <tr>
                                    <td>
                                        <sj:submit  id="stopbtn" button="true" onclick="test()" value="PAY"  cssClass="button_aback"/> 
                                    </td>
                                </tr>
                            </table>
                            </div>
                       

                        <div style="width: 40%; float:right">
                            <s:form id="payList"  theme="simple" >
                                <!--                                <table>
                                                                    <tr>
                                                                        <td class="formLable">Payment List</td> 
                                                                    </tr>
                                                                    <tr>
                                <sj:submit button="true" value="PAYMENT"  onclick="" cssClass="button_aback"/>
                            </tr>
                        </table>-->

                            </s:form>
                        </div> 
                                    
                        </div>
                                    
                        <div class="col-sm-6 col-md-6">
                            <div>
                            <div  class="form_new" theme="simple" >
                                <table>
                                    <tr>
                                        <td class="formLable" >Attendance History</td> 
                                        
                                    </tr>
                                    <tr>
                                        
                                        <td><s:textarea id="testid" cssStyle="width : 280px;height: 210px"/>
                                    </tr>
                                </table>

                            </div>
                            </div>
                            <div>
                            <div  class="form_new" theme="simple" >
                                <table>
                                    <tr>
                                        <td class="formLable">Payment History &nbsp&nbsp&nbsp;</td> 
                                       
                                    </tr>
                                    <tr>
                                        
                                        <td><s:textarea id="phisid" cssStyle="width : 280px;height: 210px"/>
                                    </tr>
                                </table>

                            </div>
                        </div>       
                        </div>


                                   
                        
                    </div>

                    <s:form action="downloadBillpdf" theme="simple" method="post">
                        <s:hidden id="hiddBillid" name ="hiddBillid"/>
                        <s:hidden id="bankaname" name="bankaname"/>
                        <s:hidden id="terminalid" name="terminalid" />
                        <s:hidden id="merchantname" name="merchantname"/>
                        <s:hidden id="mek" name="mek" />
                        <s:hidden id="issuedDate" name="issuedDate" />
                        <s:hidden id="keyid" name="keyid" />
                        <s:hidden id="tmk" name="tmk" />
                        <%--<s:submit button="true"  id="downloadbut" cssStyle="display: none; visibility: hidden;"  />--%>
                         <s:submit button="true"  id="downloadbut"  />
                    </s:form>
                    </section>



                    </body>
                    </html>

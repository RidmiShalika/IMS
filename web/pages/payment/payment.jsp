
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Styles.jsp" />

        <script type="text/javascript">
            
            function paymentformatter(cellvalue, options, rowObject) {
                return "<a href='#' onClick='javascript:pay(&#34;" + cellvalue + "&#34;,&#34;" + rowObject.id + "&#34;)'><i class='fa fa-share-square-o' aria-hidden='true'></i></a>";
            }
            function pay(keyval) {
                //load history lists
                $.ajax({
                    url: '${pageContext.request.contextPath}/loadhistorylistp',
                    data: {pid: keyval},
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
                alert('selected rows:' + selected_data);

                $.ajax({
                    url: '${pageContext.request.contextPath}/paymentmarkp',
                    data: {selected_data: selected_data},
                    dataType: "json",
                    type: "GET",
                    success: function (data) {
//                       $('#name').val("data.pay_status");
                    },
                    error: function (data) {

                    }
                });
            }
            

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
                        
                        <div style="width: 50%; float:left">  
                            <table>
                                <tr>
                                    <td>
                                        <sj:submit  id="stopbtn" button="true" onclick="test()" value="PAY"  cssClass="button_aback"/> 
                                    </td>
                                </tr>
                            </table>
                            <div class="viewuser_tbl">
                                <div id="tablediv">
                                    <s:url var="listurl" action="liststpayp"/>
                                    <sjg:grid
                                        id="gridtable"
                                        caption="Student Payments"
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
                                        <sjg:gridColumn name="id" index="id" title="Pay" width="50" formatter="paymentformatter"/>
                                        <sjg:gridColumn name="sid" index="sid" title="Student Id" width="80"/>
                                        <sjg:gridColumn name="cid" index="cid" title="Course Id" width="80"/>
                                        <sjg:gridColumn name="year" index="v" title="Year" width="100"/>
                                        <sjg:gridColumn name="month" index="month" title="Month" width="130"/>
                                        <sjg:gridColumn name="status" index="status" title="Status" width="100"/>



                                    </sjg:grid> 
                                </div>
                            </div>
                        </div>

                        <div style="width: 40%; float:right">
                          
                        </div>            
                        <div style="width: 40%; float:right">
                            <s:form id="attHistory"  theme="simple" >
                                <table>
                                    <tr>
                                        <td class="formLable" >Attendance History</td> 
                                        <td><s:textarea id="testid" cssStyle="width : 250px"/>
                                    </tr>
                                </table>

                            </s:form>
                        </div><div style="width: 40%; float:right">
                            <s:form id="payHistory"  theme="simple" >
                                <table>
                                    <tr>
                                        <td class="formLable">Payment History</td> 
                                        <td><s:textarea id="phisid" cssStyle="width : 290px"/>
                                    </tr>
                                </table>

                            </s:form>
                        </div>
                    </div>
                    </section>



                    </body>
                    </html>

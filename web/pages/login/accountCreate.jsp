<%-- 
    Document   : accountCreate
    Created on : Jul 28, 2019, 7:04:24 PM
    Author     : Ridmi Shalika
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Styles.jsp" />

        <style>
            .buttonS {
                color: white;
                background-color: blue;
            }
            .ui-datepicker {
                 /*background: transparent;*/
                 background: white;
            }


        </style>
        <script type="text/javascript">
            $(document).ready(function () { 
                openCom();
//                  $.ajax({
//                    url: '${pageContext.request.contextPath}/getadmissionInfo',
//                    dataType: "json",
//                    type: "GET",
//                    success: function (data) {
//                       $('#pay_status').val(data.pay_status);
//                       $('#payment_date').val(data.payment_date);
//                    },
//                    error: function (data) {
//                       
//                    }
//                });
             });
             
             function openCom() {
                $("#confirmdialogbox1").dialog('open');
                $("#confirmdialogbox1").html('<br><b><font size="3" color="red"><center>Please confirm to delete  : ' + "keyval" + '');
            }
             $.subscribe('openview', function (event, data) {
                var $led = $("#viewdialog");
//                $led.load("AssignCourse?studentId=" + $led.data('Id'));
            });
            
           
        </script>
    </head>

    <body style="overflow:hidden" onload="load()">
        <section class="app-content">
            <jsp:include page="../../header.jsp" />    
            <div class="wrapper">
                <div class="body_content" id="includedContent" >
                    <div class="watermark"></div>
                    <div class="heading"></div>
                    <div class="AddUser_box ">
                        
                        <div class="contentcenter">
                            
                                        
                            

                        </div>
                        <div class="viewuser_tbl">
                            <div id="tablediv">
                                

                                <sj:dialog 
                                id="confirmdialogbox1" 
                                buttons="{ 
                                'OK':function() { deleteNow1($(this).data('keyval'));$( this ).dialog( 'close' ); },
                                'Cancel':function() { $( this ).dialog( 'close' );} 
                                }" 
                                autoOpen="false" 
                                modal="true" 
                                title="Confirm Message"
                                width="400"
                                height="150"
                                position="center"
                                />
                            </div>
                        </div>
                    </div>
                    </section>

                </div>

                </body>
                </html>


<%-- 
    Document   : home
    Created on : Mar 6, 2018, 3:43:29 PM
    Author     : ridmi_g
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>  
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../../Styles.jsp" /> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/resources/new_home/css/main.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/resources/new_home/css/bootstrap.min.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/resources/new_home/fonts/icomoon/icomoon.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/new_home/js/barIndicator/barIndicator.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/new_home/css/datepicker.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/resources/new_home/css/c3/c3.css" rel="stylesheet" type="text/css">
        

        <script type="text/javascript">
            function paymentCreate(){
                alert("es");
            }
        </script>

    </head>
    <!--<body oncontextmenu="return false;" style="overflow:hidden" onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">-->

    <body oncontextmenu="return false;" style="overflow:hidden" onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">

        <section class="app-content">
            <jsp:include page="../../header.jsp" /> 
            <div class="body_content" id="includedContent">
                <div class="AddUser_box">
                    <!--                    <div class="watermark"></div>-->
                    <div class="contentcenter">

                        <div class="row gutter" style="margin-right: 2px">
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="simple-widget">
                                    <div class="growth">+12</div>
                                    <h3 class="text-white">9,521</h3>
                                    <p class="text-white">Students</p>
                                    <div class="progress sm">
                                        <div class="progress-bar" role="progressbar" style="width: 37%;" aria-valuenow="37" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="simple-widget">
                                    <div class="growth">-3</div>
                                    <h3 class="text-white">6,417</h3>
                                    <p class="text-white">Teachers</p>
                                    <div class="progress sm">
                                        <div class="progress-bar" role="progressbar" style="width: 48%;" aria-valuenow="48" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="simple-widget">
                                    <div class="growth">+25</div>
                                    <h3 class="text-white">9,421</h3>
                                    <p class="text-white">Subjects</p>
                                    <div class="progress sm">
                                        <div class="progress-bar" role="progressbar" style="width: 65%;" aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="simple-widget secondary">
                                    <div class="growth">+19</div>
                                    <h3 class="text-white">5429</h3>
                                    <p class="text-white">Classes</p>
                                    <div class="progress sm">
                                        <div class="progress-bar" role="progressbar" style="width: 80%;" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>



                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                
                                   
                                    <div class="panel-body">
                                        <div class="row" style="margin : 20px 0px 0px 20px">
                                            <div class="col-xs-2 col-md-2">
                                                <a href="load.action" class="btn btn-default btn-lg"  role="button"><i class="glyphicon glyphicon-list-alt"></i> <br/>&nbsp&nbsp&nbsp&nbspEnd Course&nbsp&nbsp&nbsp&nbsp</a>
                                            </div>
                                            <div class="col-xs-2 col-md-2">
                                                <a href="#" class="btn btn-default btn-lg"  role="button"><i class="glyphicon glyphicon-file"></i> <br/>&nbsp&nbspBackup Data&nbsp&nbsp</a>
                                            </div>
                                            <div class="col-xs-2 col-md-2">
                                                <a href="#" class="btn btn-default btn-lg"  role="button"><i class="glyphicon glyphicon-comment"></i> <br/>&nbsp&nbsp&nbsp&nbspSend SMS&nbsp&nbsp&nbsp&nbsp</a>
                                            </div>
                                            <div class="col-xs-2 col-md-2">
                                                <a href="#" class="btn btn-default btn-lg"  role="button"><i class="glyphicon glyphicon-remove"></i> <br/>&nbsp&nbsp&nbspClass DACT&nbsp&nbsp&nbsp</a>
                                             </div>
                                            <div class="col-xs-2 col-md-2">
                                                <a href="AccCreation.action" onclick="paymentCreate()" class="btn btn-default btn-lg"  role="button"><i class="glyphicon glyphicon-eye-open"></i> <br/>&nbspPayment Account Creation&nbsp</a>
                                             </div>
                                        </div>
                                       
                                    </div>
                                
                            </div>
                        </div>
                    </div>

                    <!--                        <div class="viewuser_tbl">
                                                <div id="tablediv">        -->
                    <sj:dialog 
                        id="viewdialog" 
                        buttons="{
                        'OK':function() { $( this ).dialog( 'close' );}                                    
                        }" 
                        autoOpen="false" 
                        modal="true"                            
                        width="1000"
                        height="500"
                        position="center"
                        title="Assign To Courses"

                        loadingText="Loading .."
                        />
                </div>
            </div>
            <!--                </div>
                        </div>-->
        </section>
        <script src="js/jquery.js"></script>

        <script src="js/bootstrap.min.js"></script>


    </body>
</html>

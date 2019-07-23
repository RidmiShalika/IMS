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
                                    <h3 class="text-white">$9,521</h3>
                                    <p class="text-white">Sales</p>
                                    <div class="progress sm">
                                        <div class="progress-bar" role="progressbar" style="width: 37%;" aria-valuenow="37" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="simple-widget">
                                    <div class="growth">-3</div>
                                    <h3 class="text-white">$6,417</h3>
                                    <p class="text-white">Expenses</p>
                                    <div class="progress sm">
                                        <div class="progress-bar" role="progressbar" style="width: 48%;" aria-valuenow="48" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="simple-widget">
                                    <div class="growth">+25</div>
                                    <h3 class="text-white">9,421</h3>
                                    <p class="text-white">Visits</p>
                                    <div class="progress sm">
                                        <div class="progress-bar" role="progressbar" style="width: 65%;" aria-valuenow="65" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="simple-widget secondary">
                                    <div class="growth">+19</div>
                                    <h3 class="text-white">5429</h3>
                                    <p class="text-white">Orders</p>
                                    <div class="progress sm">
                                        <div class="progress-bar" role="progressbar" style="width: 80%;" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
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

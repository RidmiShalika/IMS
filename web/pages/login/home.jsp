<%-- 
    Document   : home
    Created on : Mar 6, 2018, 3:43:29 PM
    Author     : ridmi_g
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../../Styles.jsp" /> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <!--<body oncontextmenu="return false;" style="overflow:hidden" onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">-->

       <body oncontextmenu="return false;" style="overflow:hidden" onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">

        <section class="app-content">
             <jsp:include page="../../header.jsp" /> 
             <div class="body_content" id="includedContent">
                <div class="AddUser_box">
                    <!--                    <div class="watermark"></div>-->
                    <div class="contentcenter">
                        <div class="table_center">

                            <table class="form_table" cellspacing="8" align="center">

                            </table>
                        </div>
                        <div id="favorite" >
                            <h4 style="text-align: center;">Favorite Links</h4>
                        </div>




                    </div>
                </div>
            </div>
        </section>
        <script src="js/jquery.js"></script>

        <script src="js/bootstrap.min.js"></script>


    </body>
</html>

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

        <script type="text/javascript">
            function showClass(){
                alert("test");
                var keyval = 1;
                window.location.href = "${pageContext.request.contextPath}/pages/course/stopClass.jsp";
//                $.ajax({
//                    url: '${pageContext.request.contextPath}/load.action',
//                    data: {id: keyval},
//                    dataType: "json",
//                    type: "POST",
//                    success: function (data) {
//                        alert("");
//                    },
//                    error: function (data) {
//                        alert("error");
//                      
//                    }
//                });

           
//               
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
                        <div class="table_center">
                            <!--<form>-->
                                 <table class="form_table" cellspacing="8" align="center">
                                <tr>
                                    <td><sj:submit  id="stopclass" button="true" value="STOP CLASSES" cssStyle="width:150px" onclick="showClass()"/> </td>
                                </tr>
                                 <tr>
                                     <td ><img src="${pageContext.request.contextPath}/resources/images/images.jpg" ></td>
                                </tr>
                                
                            </table>
                         <!--</form>-->
                           
                        </div>
                        <!--<div id="favorite" >-->
                            <!--<h4 style="text-align: center;">Favorite Links</h4>-->
                        <!--</div>-->




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

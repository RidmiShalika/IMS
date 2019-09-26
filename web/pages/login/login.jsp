<%-- 
    Document   : login
    Created on : Mar 6, 2018, 10:34:24 AM
    Author     : ridmi_g
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>IMS</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/bootstrap/css/bootstrap.css">
        <script src="${pageContext.request.contextPath}/resources/js/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/assets/js/jquery.backstretch.min.js"></script>        
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/style.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/font-awesome/css/font-awesome.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/js/bootstrap.min.js"></script>
        <link href="${pageContext.request.contextPath}/resources/images/favicon.ico" rel="shortcut icon" type="image/ico" />
        <script src="${pageContext.request.contextPath}/resources/assets/js/script.js"></script>
        <script type="text/javascript">
            function noBack() {
                window.history.forward();
            }
            $(document).ready(function () {
                $(this).bind("contextmenu", function (e) {
                    e.preventDefault();
                });
                window.history.forward();

//                window.onbeforeunload = function() {window.history.forward(); return "You work will be lost."; };
            })
        </script>
    </head>
    <body class="login_background" oncontextmenu="return false;"  onload="noBack();" onpageshow="if (event.persisted) noBack();"  onunload="">
        <div class="container ">

            <div class="inner-bg"> 
                <div class="row">  

                </div> 

                <div class="row">

                    <s:form action="loginCheckloginCall" theme="simple">
                        <div class="modal show"> 
                            <div class=" modal-dialog">
                                <div class="modal-content">

                                    <div class="modal-header">
                                        
                                                
                                                  <div class="row">
                                                    
                                                        
                                                        <div class="col-sm-7 title">
                                                          <h3>  <strong>Institute Management System</strong></h3>
                                                        </div>
                                                      
<!--                                                        <div class="col-sm-5 logo fill">
                                                            <img src="${pageContext.request.contextPath}/resources/newimages/logo.png" width="160px" height="50" style="width: 100%;"/>
                                                        <h3>    hELLO </h3>
                                                        </div>    -->
                                                 </div>
                                               
                                        
                                    </div>
                                    

                                    <div class="modal-body">

                                        <div class="form-field">
                                            <div class="inner-addon left-addon">
                                                <label class="sr-only" for="form-username">Username</label>
                                                <span><i class="fa fa-lg fa-user"></i></span>
                                                    <s:textfield name="userName" type="text" cssClass="form-control" id="userName1" placeholder="Login ID"/>
                                            </div>      
                                        </div>

                                        <div class="form-field">
                                            <div class="inner-addon left-addon">  
                                                <label class="sr-only" for="form-password">Password</label>
                                                <span><i class="fa fa-lg fa-lock"></i></span>
                                                    <s:password  name="password" type="password" cssClass="form-control" id="pwd" placeholder="Password"/>
                                            </div>  
                                        </div>

                                        <div class="error_msg">
                                            <i style="color:rgba(188, 20, 16, 1);"> <s:actionerror/></i> 
                                            <i style="color: rgba(41, 113, 70, 1);"> <s:actionmessage/></i> 
                                        </div>

                                        <div class="submit1">
                                            <button type="submit" name="submit" class="btn btn-primary btn-block">Sign In</button>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </s:form> 
                </div>
            </div>       
        </div>
    </body>
</html>

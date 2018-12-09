<%-- 
    Document   : report
    Created on : Jul 3, 2018, 8:37:31 AM
    Author     : ridmi_g
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>   
<!DOCTYPE html>
<html>
   <head>
        <jsp:include page="/Styles.jsp" />

        <script type="text/javascript">
            function viewDailog1(){
                $("#dailog1").dialog('open');
                return false;
            }
             $.subscribe('openview1', function (event, data) {
                var $led = $("#dailog1");
                $led.load("Genreport1");
            });
            
            function viewDailog2(){
                $("#dailog2").dialog('open');
                return false;
            }
             $.subscribe('openview2', function (event, data) {
                var $led = $("#dailog2");
                $led.load("Genreport2");
            });
            
            function viewDailog3(){
                $("#dailog3").dialog('open');
                return false;
            }
             $.subscribe('openview3', function (event, data) {
                var $led = $("#dailog3");
                $led.load("Genreport3");
            });
            
            function viewDailog4(){
                $("#dailog4").dialog('open');
                return false;
            }
             $.subscribe('openview4', function (event, data) {
                var $led = $("#dailog4");
                $led.load("Genreport4");
            });
            
            function viewDailog5(){
                $("#dailog5").dialog('open');
                return false;
            }
             $.subscribe('openview5', function (event, data) {
                var $led = $("#dailog5");
                $led.load("Genreport5");
            });
            
            function viewDailog6(){
                $("#dailog6").dialog('open');
                return false;
            }
             $.subscribe('openview6', function (event, data) {
                var $led = $("#dailog6");
                $led.load("Genreport6");
            });
            
            function viewDailog7(){
                $("#dailog7").dialog('open');
                return false;
            }
             $.subscribe('openview7', function (event, data) {
                var $led = $("#dailog7");
                $led.load("Genreport7");
            });
            
            function viewDailog8(){
                $("#dailog8").dialog('open');
                return false;
            }
             $.subscribe('openview8', function (event, data) {
                var $led = $("#dailog8");
                $led.load("Genreport8");
            });
            
            function viewDailog9(){
                $("#dailog9").dialog('open');
                return false;
            }
             $.subscribe('openview9', function (event, data) {
                var $led = $("#dailog9");
                $led.load("Genreport9");
            });
            
            function viewDailog10(){
                $("#dailog10").dialog('open');
                return false;
            }
             $.subscribe('openview10', function (event, data) {
                var $led = $("#dailog10");
                $led.load("Genreport10");
            });
            
            function viewDailog11(){
                $("#dailog11").dialog('open');
                return false;
            }
             $.subscribe('openview11', function (event, data) {
                var $led = $("#dailog11");
                $led.load("Genreport11");
            });
        </script>
    </head>

    <body style="overflow:hidden" onload="load()">
        <section class="app-content">
            <jsp:include page="../../header.jsp" />    
            <div class="wrapper">
                <div class="body_content" id="includedContent" >
                    <div class="watermark"></div>
                    <div class="heading">Report</div>
                    <div class="AddUser_box ">
                        <div class="message">         
                            <s:div id="divmsg">
                                <i style="color: red">  <s:actionerror theme="jquery"/></i>
                                <i style="color: green"> <s:actionmessage theme="jquery"/></i>
                            </s:div>         
                        </div>
                        <div class="contentcenter">
                            <s:form id="viewForm"  theme="simple">         
                                <table >              
                                    <tr>
                                        <td style="font-size: 15px">course Payment Status</td>
                                        <td style="padding-right: 75px"></td>
                                        <td style="font-size: 15px">Total Monthly Income</td>
                                        <td style="padding-right: 75px"></td>
                                        <td style="font-size: 15px">Total Daily Income</td>
                                        <td style="padding-right: 75px"></td>
                                        <td style="font-size: 15px">Lecture Monthly Payment</td>
                                    </tr> 
                                     <tr>
                                        <td><sj:a href="#" name="payment" button="true" onclick="viewDailog1()"  cssClass="button_aback" cssStyle="width : 100px">Payment</sj:a></td>
                                        <td style="padding-right: 75px"></td>
                                        <td><sj:a href="#" name="mIncome" button="true" onclick="viewDailog2()"  cssClass="button_aback" cssStyle="width : 100px">M_Income</sj:a></td>
                                        <td style="padding-right: 75px"></td>
                                        <td><sj:a href="#" name="dIncome" button="true" onclick="viewDailog3()"  cssClass="button_aback" cssStyle="width : 100px">D_Income</sj:a></td>
                                        <td style="padding-right: 75px"></td>
                                        <td><sj:a href="#" name="mPayment" button="true" onclick="viewDailog4()"  cssClass="button_aback" cssStyle="width : 100px">M_Payment</sj:a></td>
                                    </tr> 
                                   
                                 
                                    <tr>
                                        <td style="font-size: 15px">Student Details</td>
                                        <td style="padding-right: 75px"></td>
                                        <td style="font-size: 15px">Student Attendance</td>
                                        <td style="padding-right: 75px"></td>
                                        <td style="font-size: 15px">Student Payment</td>
                                        <td style="padding-right: 75px"></td>
                                        <td style="font-size: 15px">Total Student</td>
                                       
                                    </tr>
                                     <tr>
                                        <td><sj:a href="#" name="s_details" button="true" onclick="viewDailog5()"  cssClass="button_aback" cssStyle="width : 100px">S_Details</sj:a></td>
                                        <td style="padding-right: 75px"></td>
                                        <td><sj:a href="#" name="s_attendance" button="true" onclick="viewDailog6()"  cssClass="button_aback" cssStyle="width : 100px">S_Atten</sj:a></td>
                                        <td style="padding-right: 75px"></td>
                                        <td><sj:a href="#" name="s_payment" button="true" onclick="viewDailog7()"  cssClass="button_aback" cssStyle="width : 100px">S_Payment</sj:a></td>
                                        <td style="padding-right: 75px"></td>
                                        <td><sj:a href="#" name="totalstu" button="true" onclick="viewDailog8()"  cssClass="button_aback" cssStyle="width : 100px">Total_Student</sj:a></td>
                                    </tr>
                                    <tr>
                                        <td style="font-size: 15px">Student Enrollment in multiple course</td>
                                        <td style="padding-right: 75px"></td>
                                        <td style="font-size: 15px">Course Attendance </td>
                                        <td style="padding-right: 75px"></td>
                                        <td style="font-size: 15px">Admission Income</td>
                                    </tr>
                                     <tr>
                                        <td><sj:a href="#" name="multi_course" button="true" onclick="viewDailog9()"  cssClass="button_aback" cssStyle="width : 100px">Multi_Course</sj:a></td>
                                        <td style="padding-right: 75px"></td>
                                        <td><sj:a href="#" name="cAtten" button="true" onclick="viewDailog10()"  cssClass="button_aback" cssStyle="width : 100px">C_Atten</sj:a></td>
                                        <td style="padding-right: 75px"></td>
                                        <td><sj:a href="#" name="add_income" button="true" onclick="viewDailog11()"  cssClass="button_aback" cssStyle="width : 100px">Add_Income</sj:a></td>
                                        <td style="padding-right: 75px"></td>
                                        
                                    </tr>
                                </table>
                       
                                </s:form>
                       
                        </div>
                     
                    </div>
                     <sj:dialog 
                            id="dailog1" 
                            buttons="{
                            'OK':function() { $( this ).dialog( 'close' );}                                    
                            }" 
                            autoOpen="false" 
                            modal="true"                            
                            width="1000"
                            height="500"
                            position="center"
                            title="Course Payment Status"
                            onOpenTopics="openview1" 
                           loadingText="Loading .."
                            />
                     
                     <sj:dialog 
                            id="dailog2" 
                            buttons="{
                            'OK':function() { $( this ).dialog( 'close' );}                                    
                            }" 
                            autoOpen="false" 
                            modal="true"                            
                            width="1000"
                            height="500"
                            position="center"
                            title="Total Month Income"
                            onOpenTopics="openview2" 
                           loadingText="Loading .."
                            />
                     
                     <sj:dialog 
                            id="dailog3" 
                            buttons="{
                            'OK':function() { $( this ).dialog( 'close' );}                                    
                            }" 
                            autoOpen="false" 
                            modal="true"                            
                            width="1000"
                            height="500"
                            position="center"
                            title="Total Daily Income"
                            onOpenTopics="openview3" 
                           loadingText="Loading .."
                            />
                     <sj:dialog 
                            id="dailog4" 
                            buttons="{
                            'OK':function() { $( this ).dialog( 'close' );}                                    
                            }" 
                            autoOpen="false" 
                            modal="true"                            
                            width="1000"
                            height="500"
                            position="center"
                            title="Lecture Monthly Payment"
                            onOpenTopics="openview4" 
                           loadingText="Loading .."
                            />
                     <sj:dialog 
                            id="dailog5" 
                            buttons="{
                            'OK':function() { $( this ).dialog( 'close' );}                                    
                            }" 
                            autoOpen="false" 
                            modal="true"                            
                            width="1000"
                            height="500"
                            position="center"
                            title="Student Details"
                            onOpenTopics="openview5" 
                           loadingText="Loading .."
                            />
                     <sj:dialog 
                            id="dailog6" 
                            buttons="{
                            'OK':function() { $( this ).dialog( 'close' );}                                    
                            }" 
                            autoOpen="false" 
                            modal="true"                            
                            width="1000"
                            height="500"
                            position="center"
                            title="Student Attendance"
                            onOpenTopics="openview6" 
                           loadingText="Loading .."
                            />
                     <sj:dialog 
                            id="dailog7" 
                            buttons="{
                            'OK':function() { $( this ).dialog( 'close' );}                                    
                            }" 
                            autoOpen="false" 
                            modal="true"                            
                            width="1000"
                            height="500"
                            position="center"
                            title="Student Payment"
                            onOpenTopics="openview7" 
                           loadingText="Loading .."
                            />
                     <sj:dialog 
                            id="dailog8" 
                            buttons="{
                            'OK':function() { $( this ).dialog( 'close' );}                                    
                            }" 
                            autoOpen="false" 
                            modal="true"                            
                            width="1000"
                            height="500"
                            position="center"
                            title="Total Student"
                            onOpenTopics="openview8" 
                           loadingText="Loading .."
                            />
                     <sj:dialog 
                            id="dailog9" 
                            buttons="{
                            'OK':function() { $( this ).dialog( 'close' );}                                    
                            }" 
                            autoOpen="false" 
                            modal="true"                            
                            width="1000"
                            height="500"
                            position="center"
                            title="Student Enrollment in multiple course"
                            onOpenTopics="openview9" 
                           loadingText="Loading .."
                            />
                     <sj:dialog 
                            id="dailog10" 
                            buttons="{
                            'OK':function() { $( this ).dialog( 'close' );}                                    
                            }" 
                            autoOpen="false" 
                            modal="true"                            
                            width="1000"
                            height="500"
                            position="center"
                            title="Course Attendance"
                            onOpenTopics="openview10" 
                           loadingText="Loading .."
                            />
                     <sj:dialog 
                            id="dailog11" 
                            buttons="{
                            'OK':function() { $( this ).dialog( 'close' );}                                    
                            }" 
                            autoOpen="false" 
                            modal="true"                            
                            width="1000"
                            height="500"
                            position="center"
                            title="Admission Income"
                            onOpenTopics="openview11" 
                           loadingText="Loading .."
                            />
                    </section>

           

                </body>
</html>

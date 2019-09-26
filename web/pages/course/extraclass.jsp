

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%> 
<!DOCTYPE html>
<html>
    <head>
        <style>
            .viewuser_tbl {
    
                border-radius: 10px;
                padding-left: 10px;
                padding-right: 10px;
                padding-top: 10px;
                padding-bottom: 10px;
                margin-right: auto;
                margin-bottom: auto;
                margin-left: 10px;
                width: 75%;
   

}
        </style>
        <script type="text/javascript">
            function resetData() {
                jQuery("#exgridtable").trigger("reloadGrid");
            }
            function deleteformatter(cellvalue, options, rowObject) {
                return "<a href='#' onClick='deleteInit1(&#34;" + cellvalue + "&#34;)'><img src='${pageContext.request.contextPath}/resources/images/iconDelete.png'  /></a>";
            }
            function deleteInit1(keyval) {
                $("#confirmdialogbox1").data('keyval', keyval).dialog('open');
                $("#confirmdialogbox1").html('<br><b><font size="3" color="red"><center>Please confirm to delete  : ' + keyval + '');
                return false;
            }
            function deleteNow1(keyval) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/Deletex',
                    data: {exid: keyval},
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        if (data.success) {
                            $("#dialogbox1").dialog('open');
                            $("#dialogbox1").html('<br><b><font size="3" color="green"><center>' + data.message + ' ');
                        } else {
                            $("#dialogbox1").dialog('open');
                            $("#dialogbox1").html('<br><b><font size="3" color="red"><center>' + data.message + ' ');
                        }
                        jQuery("#exgridtable").trigger("reloadGrid");
                    },
                    error: function (data) {
                        window.location = "${pageContext.request.contextPath}/LogoutloginCall";
                    }
                });

            }
            
        </script>
    </head>
    <!--<body style="overflow:hidden" onload="load()">-->
    <body>
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
                            <s:form  id="extraclz"  theme="simple" method="post">
                                <table>
                                     <tr>
                                        <td class="formLable">Date<span class="mandatory">*</span></td><td>:</td>
                                        <td class="formLable">
                                        <sj:datepicker id="extraDate" name="extraDate" cssStyle="width : 100px"/>
                                        </td>
                                    </tr>
                                     <tr>
                                        <td class="formLable">Start Time<span class="mandatory">*</span></td><td>:</td>
                                        <td class="formLable">
                                        <sj:datepicker id="extraStartTime" name="extraStartTime" timepicker="true" timepickerOnly="true" cssStyle="width : 100px"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="formLable">End Time<span class="mandatory">*</span></td><td>:</td>
                                        <td class="formLable">
                                        <sj:datepicker id="extraEndTime" name="extraEndTime" timepicker="true" timepickerOnly="true" cssStyle="width : 100px"/>
                                        </td>
                                    </tr>
                                
                                </table>
                                    <table>
                                    <tr>
                                        <td>
                                            <s:url var="extraclzaddurl" action="addextraclz" />

                                            <sj:submit  id="assAddbtn1" button="true" href="%{extraclzaddurl}" value="Add"   targets="divmsg2" cssClass="button_aback"/> 
                                            </td>
                                        </tr>
                                    </table>
                            </s:form>
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
                              <sj:dialog 
                                id="dialogbox1" 
                                buttons="{
                                'OK':function() { $( this ).dialog( 'close' );}
                                }"  
                                autoOpen="false" 
                                modal="true" 
                                title="Delete Message" 
                                width="400"
                                height="150"
                                position="center"
                                />
                           
                            <s:url var="exlisturl" action="listextraclz"/>
                            <sjg:grid
                                id="exgridtable"
                                caption="Extra Classes"
                                cssStyle=""
                                dataType="json"
                                href="%{exlisturl}"
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
                                >
                                <sjg:gridColumn name="exid" index="id" title="Course ID" hidden="true"/>
                                <sjg:gridColumn name="courseId" index="courseId" title="Course description" />
                                <sjg:gridColumn name="date" index="date" title="Date" />
                                <sjg:gridColumn name="startTime" index="startTime" title="Start Time" />
                                <sjg:gridColumn name="endTime" index="endTime" title="End Time" />
                                <sjg:gridColumn name="status" index="status" title="Status" />
                                <sjg:gridColumn name="exid" index="id" title="Delete"  align="center" width="100" formatter="deleteformatter" sortable="false"/>
                                

                            </sjg:grid> 
                        </div>
                    </div>
                        
                    <!--</div>-->
                    </section>

                </div>

                </body>
</html>


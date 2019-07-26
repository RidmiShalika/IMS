
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"  %>  
<%@taglib  uri="/struts-jquery-tags" prefix="sj"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>      

<html>
    <head>
        <jsp:include page="/Styles.jsp" />
        <script type="text/javascript">

            function test(courceid,endtime) {
//                var s = $('#gridtable').jqGrid('getGridParam','selarrrow');
//                 var s= ;
                 var s = courceid+","+endtime;

                $.ajax({
                    url: '${pageContext.request.contextPath}/stopclases',
                    data: {selecteddata: s},
                    dataType: "json",
                    type: "GET",
                    success: function (data) {
                     jQuery("#gridtable").trigger("reloadGrid");
                      
                    },
                    error: function (data) {
                    }
                     
                });
            }
            function stopformatter(cellvalue, options, rowObject) {
                return "<a href='#' onClick='javascript:test(&#34;" + cellvalue + "&#34;,&#34;" + rowObject.endedTime + "&#34;)'><i class='fa fa-share-square-o' aria-hidden='true'></i></a>";
            }
        </script>
    </head>

    <body style="overflow:hidden" onload="load()">
        <section class="app-content">
            <jsp:include page="../../header.jsp" />    
            <div class="wrapper">
                <div class="body_content" id="includedContent" >
                    <div class="watermark"></div>
            <div class="heading">Stop Class</div>
            <div class="AddUser_box ">
                <div class="message">         
                    <s:div id="divmsg">
                        <i style="color: red">  <s:actionerror theme="jquery"/></i>
                        <i style="color: green"> <s:actionmessage theme="jquery"/></i>
                    </s:div>         
                </div>
                
                <form>
                     <table>
                        <tr>
                            <td>
                               <%--<s:url var="stopeurl" action="stopClz" />--%>
                                <%--<sj:submit  id="stopbtn" button="true" href="%{stopeurl}" value="STOP"   targets="divmsg" cssClass="button_aback"/>--%> 
                                <sj:submit  id="stopbtn" button="true" onclick="test()" value="STOP"  cssClass="button_aback"/> 
                            </td>
                        </tr>
                     </table>
                </form>
                
                <div class="viewuser_tbl">
                    <div id="tablediv">
                        <s:url var="listurlstop" action="liststopClass"/>
                                <sjg:grid
                                    id="gridtable"
                                    caption="Stop Class"
                                    cssStyle=""
                                    dataType="json"
                                    href="%{listurlstop}"
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

                                    <sjg:gridColumn name="id" index="id" title="id" hidden="true"/>
                                     <sjg:gridColumn name="details" index="details" title="Stop" formatter="stopformatter" />
                                    <sjg:gridColumn name="stopcourseDescription" index="courseId.courseDescription" title="Course Description" />
                                    <sjg:gridColumn name="startEnd" index="startEnd" title="Start/End" width="300"/>
                                    <sjg:gridColumn name="endedTime" index="endedTime" title="Ended Time" width="300" editable="true" edittype="text"/>
                                    <sjg:gridColumn name="classTypet" title="Class Type" width="200"/>
                                    <%--<sjg:gridColumn name="details" index="details" title="Select" />--%>
                                   
                                    
                                </sjg:grid> 
                    
                     </div>
                </div>
            </div>
                    
        </section>

    </body>
</html>




<%--<%@page import="com.epic.tle.util.SectionComparator"%>--%>
<%@page import="Util.ModuleComparator"%>
<%@page import="java.util.TreeSet"%>
<%@page import="login.bean.TaskBean"%>

<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<!--Banner-->
<!--<div class="banner">
     App header begin 
    <header>
        <a href='homeCall.action' class=""></a>
        <div class="service-status">
            <div id="node"></div><div id="serviceStatus" class="active"></div>
        </div>
        <div class="top-nav">
            <div class="right-links">
                <a href='logOut.action' id="logout"  class="lnk-logout" title="Log Out"></a>
                <a href='homeCall.action' id="home" class="lnk-home" title="Home"></a>
            </div>
            <div class="user-info">
                <h2></h2>
                <h1>Welcome</h1>
                <div>
                    <a href="#">${SessionObject.userName}</a><br />
                    <span>${SessionObject.userRole}</span>
                </div>
            </div>
        </div>
    </header>
     End 

</div>-->
<!--End of Banner-->

<!-- Left side navigation begin -->
<!--<div class="row">
    <div class="col-lg-3">

    </div>
</div>-->
<div>
    <h1 style="color: #007dc1;text-align: center">NIKARSHA</h1>
    <div class="container-fluid" style="color: #fff;">
    <div class="row">
        <div class="col-lg-12 topborder">
            <div class="username "><span id="disUser" class="caps">${SessionObject.userName}</span></div>
            <div class="dropdownnav">
                <div id="myDropdown" class="dropdown-content">
                
                    <a  onclick="clearCookie()" href="logoutCall.action" style="color: white">Logout</a>
                    <!--<a  onclick="clearCookie()" >Logout</a>-->
                </div>
            </div> 
        </div>
    </div>         
</div>
</div>
<div class="left_menu_bar">
    <!--<span class="login_data"><div class="home"><a onclick="clearCookieOnHome()" href="homeCall.action"><img style="position: fixed;" src="${pageContext.request.contextPath}/resources/images/housings_items.png"/></a></div></span>-->

    <div id="accordian">
        <ul class="tree-style">

        <%
            try {
//                System.out.println("server request " + request.getSession());
//                System.out.println("session name " + request.getSession().getAttribute("pageTaskList"));

                HashMap<String, List<TaskBean>> sectionPageList = (HashMap<String, List<TaskBean>>) request.getSession().getAttribute("pageTaskList");

//                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//                System.out.println("section page list " + sectionPageList);

                int secId = 1;
                int pageId = 1000;
                for (List<TaskBean> key : sectionPageList.values()) {

                    for (int i = 0; i < key.size(); i++) {
                        pageId++;
//                        System.out.println(key.get(i).getTASK_NAME());
//                        System.out.println(key.get(i).getURL());
                        out.println("<a id= " + pageId + " href=\'" + request.getContextPath() + "/" + key.get(i).getURL() + ".action\'>");
                        out.println("<li class='parentnav'><i class='fa fa-chevron-right' aria-hidden='true'></i>" + key.get(i).getTASK_NAME());
                        out.println("</a>");

                        out.println("</li>");
                    }
                    out.println(" </ul>");
                    secId++;
                }

//                out.println("</a></li>");
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        %>

    </ul>
</div>
</div>
<!-- End -->
<script>
    $(function () {
        var SessionObject = '<s:property value="#session.SessionObject"/>';
        var i = ${pageContext.session.maxInactiveInterval};
        var session_time_out = i * 1000;

        setInterval(function () {

            sesseionTimeOut();
        }, session_time_out);
        function sesseionTimeOut() {
            $.ajax({
                url: '${pageContext.request.contextPath}/removeSessionAttribute',
                dataType: "json",
                type: "POST",
                success: function (data) {
                    window.location = "${pageContext.request.contextPath}/logOut.action";
                },
                error: function (errorThrown) {
                    window.location = "${pageContext.request.contextPath}/logOut.action";
                }
            });
        }



        $('#logout').click(function () {
            $.removeCookie('selectedpage', {path: '/'});
            window.location = $(this).attr('hrefa');
        });
        $('#home').click(function () {
            $.removeCookie('selectedpage', {path: '/'});
            window.location = $(this).attr('href');
        });


        var idpage = $.cookie("selectedpage");
        console.log(" cookie----- " + idpage)
        var idpageval = "#" + idpage;
        $(idpageval).addClass('menuselect');
    })


</script>
<!--End of Left Menu-->



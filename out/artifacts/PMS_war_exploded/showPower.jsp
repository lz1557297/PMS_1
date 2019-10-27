<%@ page language="java" import="java.util.*,po.*" pageEncoding="UTF-8"%>
<%@ page import="service.PowerService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>项目管理系统</title>
    <link href="css/style_frame.css" rel="stylesheet" type="text/css" />
    <link href="css/jquery.treeview.css" rel="stylesheet"/>
    <script src="js/jquery-1.6.2.min.js"></script>
    <script src="ui/jquery.ui.core.js"></script>
    <script src="ui/jquery.ui.widget.js"></script>
    <script src="ui/jquery.ui.accordion.js"></script>
    <script src="js/jquery.cookie.js" type="text/javascript"></script>
    <script src="js/jquery.treeview.js" type="text/javascript"></script>
    <script src="js/demo.js" type="text/javascript"></script>
    <script>
        $(function() {
            var icons = {
                header: "ui-icon-circle-arrow-e",
                headerSelected: "ui-icon-circle-arrow-e"
            };
            $( "#accordion" ).accordion({
                icons: icons
            });
        });
    </script>
    <script type="text/javascript">
        var preObj = false;
        function showMe(id){
            if (preObj){
                preObj.style.display = "none";//上一次被显示的对象
            }
            var obj = document.getElementById(id);//和当前点击的div相关权限div
            if (preObj != obj){
                obj.style.display = "block";
                preObj = obj;
            }
        }
    </script>
</head>
<body>
<form id="form1" runat="server">
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="back_top01">
        <tr>
            <td height="83" colspan="2" align="left"><img src="images/top_img01.jpg" width="390" height="83" /></td>
        </tr>
        <tr>
            <td width="15%" height="45" align="left" valign="top"><table border="0" cellpadding="0" cellspacing="0" class="back_top02">
                <tr>
                    <td width="55" align="right"><img src="images/top_img02.gif" width="27" height="26" align="absmiddle" /></td>
                    <td width="154" align="left" style="font-family:arial;font-size:11px;">&nbsp;&nbsp;<span id="localtime"></span>
                        <script type="text/javascript">
                            function showLocale(objD)
                            {
                                var str,colorhead,colorfoot;
                                var yy = objD.getYear();
                                if(yy<1900) yy = yy+1900;
                                var MM = objD.getMonth()+1;
                                if(MM<10) MM = '0' + MM;
                                var dd = objD.getDate();
                                if(dd<10) dd = '0' + dd;
                                var hh = objD.getHours();
                                if(hh<10) hh = '0' + hh;
                                var mm = objD.getMinutes();
                                if(mm<10) mm = '0' + mm;
                                var ss = objD.getSeconds();
                                if(ss<10) ss = '0' + ss;
                                var ww = objD.getDay();
                                if  ( ww==0 )  colorhead="<font color=\"#ffffff\">";
                                if  ( ww > 0 && ww < 6 )  colorhead="<font color=\"#ffffff\">";
                                if  ( ww==6 )  colorhead="<font color=\"#ffffff\">";
                                if  (ww==0)  ww="周日";
                                if  (ww==1)  ww="周一";
                                if  (ww==2)  ww="周二";
                                if  (ww==3)  ww="周三";
                                if  (ww==4)  ww="周四";
                                if  (ww==5)  ww="周五";
                                if  (ww==6)  ww="周六";
                                colorfoot="</font>"
                                str = colorhead + yy + "-" + MM + "-" + dd + " " + hh + ":" + mm + "  " + ww + colorfoot;
                                return(str);
                            }
                            function tick()
                            {
                                var today;
                                today = new Date();
                                document.getElementById("localtime").innerHTML = showLocale(today);
                                window.setTimeout("tick()", 1000);
                            }
                            tick();
                        </script>
                        <script type="text/javascript" language="javascript">
                            function iFrameHeight() {
                                var ifm= document.getElementById("iframepage");
                                var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;
                                if(ifm != null && subWeb != null) {
                                    if (subWeb.body.scrollHeight > 549){
                                        ifm.height = subWeb.body.scrollHeight;
                                    }

                                }
                            }
                        </script>


                    </td>
                </tr>
            </table></td>
            <td width="85%" align="center"><table width="98%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="65%" align="left"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="25%"><img src="images/top_icon04.gif" width="24" height="26" hspace="5" align="absmiddle" /><span class="font_white">欢迎您  :)</span></td>
                            <td width="75%"><table border="0" cellpadding="0" cellspacing="0" class="back_top03">
                                <tr>
                                    <td><span class="font_bold">点击左侧按钮，进行操作:)</span></td>
                                </tr>
                            </table></td>
                        </tr>
                    </table></td>
                    <td width="35%" align="right"><table width="278" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td align="left"><img src="images/top_icon01.gif" width="26" height="24" hspace="5" align="absmiddle" /><a class="link_white" href="http://dm.hljtx.com">系统首页</a></td>
                            <td align="left"><img src="images/top_icon02.gif" width="26" height="24" hspace="5" align="absmiddle" />网站首页</td>
                            <td align="left"><img src="images/top_icon03.gif" width="20" height="24" hspace="5" align="absmiddle" /><a class="link_white" href="index.jsp">退出系统</a></td>
                        </tr>
                    </table></td>
                </tr>
            </table></td>
        </tr>
    </table>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td width="209" valign="top">
                <table width="209" border="0" cellpadding="0" cellspacing="0" class="back_left01">
                    <tr>
                        <td align="center" valign="top"><table border="0" cellpadding="0" cellspacing="0" class="back_left02">
                            <tr>
                                <td><span class="font_bold02">系统功能菜单</span></td>
                            </tr>
                        </table>
                            <table width="140" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td>
                                        <div >
                                            <c:forEach items="${requestScope.list}" var="powerOne" varStatus="v">
                                                <h3><div onclick="showMe('d${v.index}')" >${powerOne.power_name }</div></h3>
                                                <div id="d${v.index}" style="display:none">
                                                    <c:forEach items="${requestScope.map[powerOne.power_name]}" var="pow">
                                                        <a href="${pow.power_href }" target="mainFrame">${pow.power_name }</a><br/>
                                                        <%--从数据库中读到phref xxx.do?method 经由baseServlet去到运行时类--%>
                                                    </c:forEach>
                                                </div>
                                            </c:forEach>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                            <div style="clear:both; height:15px; line-height:15px;"></div>
                            <table width="140" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td align="center"><img src="images/left_icon01.gif" width="55" height="54" border="0" /></td>
                                    <td align="center"><img src="images/left_icon02.gif" width="55" height="54" border="0" /></td>
                                </tr>
                            </table>
                            <div style="clear:both; height:15px; line-height:15px;"></div></td>
                    </tr>
                </table>    </td>
            <td align="center" valign="top"><iframe onLoad="iFrameHeight()" src="member_main.jsp" name="mainFrame" id="iframepage" frameborder="0" scrolling="no" allowtransparency="true" width="100%" height="549px"></iframe></td>
        </tr>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="back_bottom01">
        <tr>
            <td><a onfocus="this.blur()" href="http://www.hljtx.com" target="_blank"><img src="images/bottom02.gif" width="107" height="41" border="0" /></a></td>
        </tr>
    </table>
</form>
</body>
</html>


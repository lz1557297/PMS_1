<%--
  Created by IntelliJ IDEA.
  User: lz
  Date: 2019-10-23
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>个人信息</title>
    <link href="css/style_main.css" rel="stylesheet" type="text/css" />
    <script>
        function requestNewPage(){
            var pageObj = document.getElementById("fenye");
            var curPage = pageObj[pageObj.selectedIndex].value;
            window.location.href="role!queryAllRole.action?curPage="+curPage
        }
    </script>
</head>
<body>
<div style="clear:both; height:40px; line-height:40px;"></div>
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="main_table02" >
    <tr>
        <td width="180" align="left"><table width="167" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="left" class="back_main04"><span class="font_bold">消息列表</span></td>
            </tr>
        </table></td>
        <td width="503" align="left">&nbsp;</td>
        <td width="27" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="back_main05">
            <%--<tr>--%>
            <%--<td align="center"><a class="link_white" href="login.do?method=loadAllUser">+ 新建消息</a></td>--%>
            <%--</tr>--%>
        </table></td>
    </tr>
    <tr>
        <td colspan="3">
            <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dedede">
                <tr>
                    <%--<td align="center" class="back_main03"><span class="font_bold">选择</span></td>--%>
                    <td align="center" class="back_main03"><span class="font_bold">用户id</span></td>
                    <td align="center" class="back_main03"><span class="font_bold">用户名</span></td>
                    <td align="center" class="back_main03"><span class="font_bold">密码</span></td>
                    <td align="center" class="back_main03"><span class="font_bold">职位ID</span></td>
                    <td align="center" class="back_main03"><span class="font_bold">电话</span></td>
                    <td align="center" class="back_main03"><span class="font_bold">邮箱</span></td>
                    <td align="center" class="back_main03"><span class="font_bold">操作</span></td>
                </tr>
                    <tr>
                            <%--<td height="35" align="center" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox9" /></td>--%>
                        <td align="center" bgcolor="#FFFFFF">${requestScope.user.user_id }</td>
                        <td align="center" bgcolor="#FFFFFF">${requestScope.user.username }</td>
                        <td align="center" bgcolor="#FFFFFF">${requestScope.user.password }</td>
                        <td align="center" bgcolor="#FFFFFF">${requestScope.user.job_id }</td>
                        <td align="center" bgcolor="#FFFFFF">${requestScope.user.user_tel }</td>
                        <td align="center" bgcolor="#FFFFFF">${requestScope.user.user_email }</td>
                        <td align="center" bgcolor="#FFFFFF"><a href='user.do?method=loadOne' class="link_blue">修改个人信息</a></td>
                    </tr>





            </table>    </td>
    </tr>

    <tr>
        <td height="30" colspan="3" align="left">
            <input type="submit" name="button2" id="button3" value="返 回" onclick="javascript:history.go(-1);" /></td>
    </tr>
</table>
<div style="clear:both; height:10px; line-height:10px;"></div>
</body>
</html>

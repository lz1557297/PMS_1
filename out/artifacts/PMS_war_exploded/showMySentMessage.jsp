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
    <title>资源查询</title>
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
        </table></td>
    </tr>
    <tr>
        <td colspan="3">
            <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dedede">
                <tr>
                    <%--<td align="center" class="back_main03"><span class="font_bold">选择</span></td>--%>
                    <td align="center" class="back_main03"><span class="font_bold">消息编号</span></td>
                    <td align="center" class="back_main03"><span class="font_bold">发送人</span></td>
                    <td align="center" class="back_main03"><span class="font_bold">接收人</span></td>
                    <td align="center" class="back_main03"><span class="font_bold">标题</span></td>
                    <td align="center" class="back_main03"><span class="font_bold">内容</span></td>
                    <td align="center" class="back_main03"><span class="font_bold">创建时间</span></td>
                    <td align="center" class="back_main03"><span class="font_bold">操作</span></td>
                </tr>
                <c:forEach items="${requestScope.list}" var="message">
                    <tr>
                            <%--<td height="35" align="center" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox9" /></td>--%>
                        <td align="center" bgcolor="#FFFFFF">${message.message_id }</td>
                        <td align="center" bgcolor="#FFFFFF">${message.sender }</td>
                        <td align="center" bgcolor="#FFFFFF">${message.receiver }</td>
                        <td align="center" bgcolor="#FFFFFF">${message.message_title }</td>
                        <td align="center" bgcolor="#FFFFFF">${message.message_info }</td>
                        <td align="center" bgcolor="#FFFFFF">${message.send_time }</td>
                        <td align="center" bgcolor="#FFFFFF">【<a href='message.do?method=checkThisOne&message_id=${message.message_id }' class="link_blue">查看</a>】 【<a href='message.do?method=deleteMySentMessage&message_id=${message.message_id }' onclick="return confirm('确定要删除当前记录吗?')">删除</a>】</td>
                    </tr>
                </c:forEach>




            </table>    </td>
    </tr>
    <!--
    <tr>
      <td height="50" colspan="3" align="center">
         共10条记录,共分2页,当前第1页
         <a href="role!queryAllRole.action?curPage=1">上一页</a>|
         <a href="role!queryAllRole.action?curPage=2">下一页</a>
        <select id="fenye" onchange="requestNewPage();">

             <option value="1" selected>1</option>

             <option value="2" >2</option>

        </select>
      </td>
    </tr>
    -->
</table>
<div style="clear:both; height:10px; line-height:10px;"></div>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>客户查询</title>
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
        <td align="left" class="back_main04"><span class="font_bold">人员信息列表页面</span></td>
      </tr>
    </table></td>
    <td width="503" align="left">&nbsp;</td>
    <td width="27" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="back_main05">
      <tr>
        <td align="center"><a class="link_white" href="insertuser.jsp">+ 添加人员</a></td>
      </tr>
    </table></td>
  </tr>  
  <tr>
    <td colspan="3"> 
         <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dedede">
          <tr>
           <%--<td align="center" class="back_main03"><span class="font_bold">选择</span></td>--%>
           <td align="center" class="back_main03"><span class="font_bold">用户id</span></td>
           <td align="center" class="back_main03"><span class="font_bold">用户姓名</span></td>  
            <td align="center" class="back_main03"><span class="font_bold">登录密码</span></td> 
             <td align="center" class="back_main03"><span class="font_bold">职位id</span></td>
             <td align="center" class="back_main03"><span class="font_bold">角色id</span></td>
             <td align="center" class="back_main03"><span class="font_bold">用户电话</span></td> 
             <td align="center" class="back_main03"><span class="font_bold">用户email</span></td>   
                                                                                       
           <td align="center" class="back_main03"><span class="font_bold">操作</span></td>                   
         </tr>
         <c:forEach items="${requestScope.list}" var="user">
         	<tr>
              <%--<td height="35" align="center" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox9" /></td>--%>
              <td align="center" bgcolor="#FFFFFF">${user.user_id}</td>
              <td align="center" bgcolor="#FFFFFF">${user.username}</td>
              <td align="center" bgcolor="#FFFFFF">${user.password}</td>
              <td align="center" bgcolor="#FFFFFF">${user.job_id}</td>
              <td align="center" bgcolor="#FFFFFF">${user.role_id}</td>
              <td align="center" bgcolor="#FFFFFF">${user.user_tel}</td>
              <td align="center" bgcolor="#FFFFFF">${user.user_email}</td>
              
              <td align="center" bgcolor="#FFFFFF">【<a href='user.do?method=queryOne&user_id=${user.user_id }' class="link_blue">修改</a>】 【<a href='user.do?method=delete&user_id=${user.user_id }' onclick="return confirm('确定要删除当前记录吗?')">删除</a>】</td>
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
  <tr>
    <td height="30" colspan="3" align="left">
      <input type="submit" name="button" id="button" value="删 除" /> <input type="submit" name="button2" id="button2" value="返 回" onclick="javascript:history.go(-1);" /></td>
  </tr>
</table>
<div style="clear:both; height:10px; line-height:10px;"></div>
</body>
</html>
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
<title></title>
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
        <td align="left" class="back_main04"><span class="font_bold">职位信息列表页面</span></td>
      </tr>
    </table></td>
    <td width="503" align="left">&nbsp;</td>
    <td width="27" align="right" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="back_main05">
      <tr>
        <%--<td align="center"><a class="link_white" href="insertjob.jsp">+ 添加职位</a></td>--%>
      </tr>
    </table></td>
  </tr>  
  <tr>
    <td colspan="3"> 
         <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dedede">
          <tr>
           <%--<td align="center" class="back_main03"><span class="font_bold">选择</span></td>--%>
           <td align="center" class="back_main03"><span class="font_bold">职位id</span></td>
           <td align="center" class="back_main03"><span class="font_bold">职位姓名</span></td>  
              
                                                                                       
           <td align="center" class="back_main03"><span class="font_bold">操作</span></td>                   
         </tr>
         <c:forEach items="${requestScope.list}" var="job">
         	<tr>
              <td height="35" align="center" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox9" /></td>
              <td align="center" bgcolor="#FFFFFF">${job.job_id}</td>
              <td align="center" bgcolor="#FFFFFF">${job.job_name}</td>
             
              
              <td align="center" bgcolor="#FFFFFF">【<a href='job.do?method=queryOne&job_id=${job.job_id }' class="link_blue">修改</a>】 </td>
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
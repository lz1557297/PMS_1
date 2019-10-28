<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>





<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>添加修改信息</title>
    <link rel="stylesheet" href="../kindeditor/themes/default/default.css" />
    <link rel="stylesheet" href="../kindeditor/plugins/code/prettify.css" />
    <script charset="utf-8" src="../kindeditor/kindeditor.js"></script>
    <script charset="utf-8" src="../kindeditor/lang/zh_CN.js"></script>
    <script charset="utf-8" src="../kindeditor/plugins/code/prettify.js"></script>
    <script>
        KindEditor.ready(function(K) {
            var editor1 = K.create('#content1', {
                cssPath : '../kindeditor/plugins/code/prettify.css',
                uploadJson : '../kindeditor/asp.net/upload_json.ashx',
                fileManagerJson : '../kindeditor/asp.net/file_manager_json.ashx',
                allowFileManager : true,
                afterCreate : function() {
                    var self = this;
                    K.ctrl(document, 13, function() {
                        self.sync();
                        K('form[name=example]')[0].submit();
                    });
                    K.ctrl(self.edit.doc, 13, function() {
                        self.sync();
                        K('form[name=example]')[0].submit();
                    });
                }
            });
            prettyPrint();
        });
    </script>


    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="css/style_main.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="themes/base/jquery.ui.all.css">
    <script src="../js/jquery-1.6.2.min.js"></script>
    <script src="ui/jquery.ui.core.js"></script>
    <script src="ui/jquery.ui.widget.js"></script>
    <script src="ui/jquery.ui.datepicker.js"></script>
    <script src="ui/i18n/jquery.ui.datepicker-zh-CN.js"></script>
    <script>
        $(function() {
            $("#TextBox2").datepicker($.datepicker.regional["zh-CN"]);
        });


        var x = null;
        function getXmlHttp(){
            var xmlHttp;
            try{
                xmlHttp=new XMLHttpRequest();
            }catch (e){
                try{
                    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
                }catch (e){
                    try{
                        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
                    }catch (e){
                        alert("您的浏览器不支持AJAX！");
                        return false;
                    }
                }
            }
            return xmlHttp;
        }

        function changeValue(){
            var obj_select = document.getElementById("s1");
            var url = "need.do?method=queryNeedsByProject&value="+obj_select.value+"&v="+Math.random();  //传ID
            var xmlHttp = getXmlHttp();
            xmlHttp.open("get",url,true);  //打开连接
            xmlHttp.onreadystatechange = function () {  //ajax状态码改变
                if (xmlHttp.readyState == 4){
                    var str = xmlHttp.responseText;  //得到queryCityServlet的回写数据
                    var x = eval("("+str+")");  //
                    //return x;
                    var parent = document.getElementById("d1");
                    parent.innerHTML="请选择所属需求：";   //内容初始化
                    var new_select = document.createElement("select");
                    new_select.name="need";

                    //console.alert(x);



                    var defaultOption = document.createElement("option");  //默认选项
                    defaultOption.innerHTML="--请选择--";
                    //defaultOption.innerHTML=new_select.name;
                    new_select.appendChild(defaultOption);  //defaultOption在new_select下
                    for (var i = 0; i < x.length; i++) {
                        var new_option = document.createElement("option");
                        new_option.innerHTML = x[i].need_title;
                        new_option.value = x[i].need_id;
                        new_select.appendChild(new_option);
                    }
                    parent.appendChild(new_select);  //new_select在parent下
                    //print(new_select.value);

                }
            }
            xmlHttp.send();
        }


    </script>


</head>
<body>
<form id="form1" runat="server" method="post" action="mod.do?method=insert">
    <div style="clear:both; height:15px; line-height:15px;"></div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" id="main_table03">
        <tr>
            <td width="570" align="left"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="50%"><table width="167" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td align="left" class="back_main04"><span class="font_bold">新建模块窗口</span></td>
                        </tr>
                    </table></td>
                    <td width="50%" align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="back_main05">
                        <tr>
                            <td align="center"><a class="link_white" href="role!queryAllRole.action?curPage=1">+ 返回列表</a></td>
                        </tr>
                    </table></td>
                </tr>
            </table>
                <table width="100%" border="0" cellpadding="0" cellspacing="10" bgcolor="#FFFFFF" class="border03">

                    <tr>
                        <td align="left">模块名称：
                            <input type="text" name="mod_title" value="" id="textfield3" class="input" /></td>
                    </tr>

                    <tr>
                        <td align="left">模块详情：
                            <input type="text" name="mod_info" value="" id="textfield4" class="input" /></td>
                    </tr>

                    所属项目:
                    <select name="project_id" id="s1" onchange="changeValue();">
                        <c:forEach items="${requestScope.list}" var="project">
                            <option value='${project.project_id}'>${project.project_name}</option>
                        </c:forEach>
                    </select>
                    <div id="d1" ></div>

                    <%--所属需求:--%>
                    <%--<select name="project_id" id="s2" onchange="changeValue();">--%>
                        <%--<c:forEach items="" var="project">--%>
                            <%--<option value='${project.project_id}'>${project.project_name}</option>--%>
                        <%--</c:forEach>--%>
                    <%--</select>--%>

                    优先级：<select name="priority">
                    <option value="0">--请选择--</option>
                    <option value="暂不">暂不</option>
                    <option value="一般">一般</option>
                    <option value="优先">优先</option>
                </select>  <br/>

                </table>
            </td>
            <td width="140" align="right">
                <table width="100%" border="0" cellspacing="15" cellpadding="0">
                    <tr>
                        <td align="center"><input type="image" src="images/main_btn4.gif" onclick="return confirm('确定提交数据?')"/></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td height="40" align="center" valign="bottom">&nbsp;</td>
            <td align="right" valign="top">&nbsp;</td>
        </tr>
    </table>
</form>
</body>
</html>

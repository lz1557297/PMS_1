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
    </script>
</head>
<body>
<form id="form1" runat="server" method="post" action="project.do?method=update">
    <input type="hidden" name="project_id" value="${param.project_id }">
    <div style="clear:both; height:15px; line-height:15px;"></div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" id="main_table03">
        <tr>
            <td width="570" align="left"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="50%"><table width="167" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td align="left" class="back_main04"><span class="font_bold">项目信息编辑窗口</span></td>
                        </tr>
                    </table></td>
                    <td width="50%" align="right"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="back_main05">
                        <tr>
                            <td align="center"><a class="link_white" href="project.do?method=queryAll">+ 返回列表</a></td>
                        </tr>
                    </table></td>
                </tr>
            </table>
                <table width="100%" border="0" cellpadding="0" cellspacing="10" bgcolor="#FFFFFF" class="border03">

                    经理选择:
                    <select name="user_id">
                        <c:forEach items="${requestScope.list}" var="user">
                            <option value='${user.user_id}'>${user.username}</option>
                        </c:forEach>
                    </select>

                    优先级：<select name="priority">
                    <option value="0">--请选择--</option>
                    <option value="暂不">暂不</option>
                    <option value="一般">一般</option>
                    <option value="优先">优先</option>
                </select>  <br/>

                    项目状态：<select name="status">
                    <option value="0">--请选择--</option>
                    <option value="未开始">未开始</option>
                    <option value="已开始">已开始</option>
                </select>  <br/>

                    <tr>
                        <td align="left">开发人数：
                            <input type="text" name="coder_count"  id="textfield2" class="input" value="${requestScope.project.coder_count }"/></td>
                    </tr>

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

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

    <script>

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

        function checkForm() {
            var obj_id = document.getElementById("n1");
            if (obj_id.value == ""){
                alert("请输入账号");
                return false;
            }

            var obj_password = document.getElementById("p1");
            if (obj_password.value.length<5){
                alert("密码长度不够");
                return false;
            }

            var obj_country = document.getElementsByName("country");
            if (obj_country[0].value == 0){
                alert("请选择一个国家");
                return false;
            }

            var obj_info = document.getElementById("information");
            if (obj_info.value == ""){
                alert("请填写备注");
                return false;
            }
            return true;
        }

        function checkId(obj) {
            var xmlHttp = getXmlHttp();
            xmlHttp.open("get","user.do?method=loadUser"+"&value="+Math.random()+"&user_id="+obj.value,false);
            xmlHttp.onreadystatechange=function (){
                if (xmlHttp.readyState == 4){
                    document.getElementById("d1").innerHTML=xmlHttp.responseText;
                }
            }
            xmlHttp.send();
        }


    </script>


</head>
<body>
<form id="form1" runat="server" method="post" action="user.do?method=insert">
    <div style="clear:both; height:15px; line-height:15px;"></div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" id="main_table03">
        <tr>
            <td width="570" align="left"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="50%"><table width="167" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td align="left" class="back_main04"><span class="font_bold">新增用户窗口</span></td>
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

                    工号:<input type="text" name="user_id" id="n1" onblur="checkId(this)"><div id="d1"></div><br/>

                    <tr>
                        <td align="left">姓名：
                            <input type="text" name="username" value="" id="textfield3" class="input" /></td>
                    </tr>

                    <tr>
                        <td align="left">密码：
                            <input type="text" name="password" value="" id="textfield4" class="input" /></td>
                    </tr>


                    职位：<select name="job">
                    <option value="0">--请选择--</option>
                    <option value="1">Admin</option>
                    <option value="2">Chef</option>
                    <option value="3">Coder</option>
                    </select>  <br/>

                    角色：<select name="role">
                    <option value="0">--请选择--</option>
                    <option value="1">Admin</option>
                    <option value="2">Chef</option>
                    <option value="3">Coder</option>
                    </select>  <br/>

                    <tr>
                        <td align="left">电话：
                            <input type="text" name="user_tel" value="" id="textfield5" class="input" /></td>
                    </tr>

                    <tr>
                        <td align="left">邮箱：
                            <input type="text" name="user_email" value="" id="textfield6" class="input" /></td>
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

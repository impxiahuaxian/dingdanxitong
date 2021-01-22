<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%><%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
function checkForm(){
	var name=document.getElementsByName("vip.name")[0].value;
	var phone=document.getElementsByName("vip.phone")[0].value;
	var ident=document.getElementsByName("vip.ident")[0].value;
	if(name==null||name==""){alert("姓名不能为空!");return false;}
	if(phone==null||phone==""){alert("电话不能为空!");return false;}
	if(ident==null||ident==""){alert("证件不能为空!");return false;}
	return true;
}
//判断是否为手机号
function checkPhone(phone) {
            //验证电话号码手机号码，包含至今所有号段? ?
            var ab = /^[1][3,4,5,7,8][0-9]{9}$/;
            if (ab.test(MobileTelephone) == false) {
                layer.alert("请正确填写手机号码!", { icon: 5, offset: '200px' });
                returnfalse;
            }
        }

</script>
<body>

	<form action="vip!add.action" method="post" onsubmit="return checkForm()">
	姓名：<input type="text" name="vip.name"/><font color="red">*</font><br>
	电话：<input type="text" maxlength="11" oninput="value=value.replace(/[^\d]/g,'')"
             placeholder="请输入您的电话号码"  onChange="checkPhone(this.value)" 
            id="MobileTelephone" name="vip.phone" /><br>

	
	证件：<input type="text" name="vip.ident"/><font color="red">*</font><br>
	性别：<select name="vip.sex" style="width:154px">
			<option value="">请选择</option><option value="1">男</option><option value="2">女</option></select><br>
	地址：<input type="text" name="vip.address"/><br>
	<input type="submit" value="确认添加"/>
	</form>
	
</body>
</html>

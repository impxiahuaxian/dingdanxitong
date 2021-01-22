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
	var name=document.getElementsByName("factory.name")[0].value;
	var phone=document.getElementsByName("factory.linkman")[0].value;
	var ident=document.getElementsByName("factory.phone")[0].value;
	if(name==null||name==""){alert("厂商不能为空!");return false;}
	if(phone==null||phone==""){alert("姓名不能为空!");return false;}
	if(ident==null||ident==""){alert("电话不能为空!");return false;}
	return true;
}
</script>
<body>

	<form action="factory!add.action" method="post" onsubmit="return checkForm()">
	厂商：<input type="text" name="factory.name"/><font color="red">*</font><br>
	姓名：<input type="text" name="factory.linkman"/><font color="red">*</font><br>
	电话：<input type="text" name="factory.phone"/><font color="red">*</font><br>
	地址：<input type="text" name="factory.address"/><br>
	备注：<input type="text" name="factory.remark"/><br>
	<input type="submit" value="确认添加"/>
	</form>
	
</body>
</html>

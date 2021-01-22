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
	var name=document.getElementsByName("emp.name")[0].value;
	var pass=document.getElementsByName("emp.pass")[0].value;
	if(name==null||name==""){alert("姓名不能为空!");return false;}
	if(pass==null||pass==""){alert("电话不能为空!");return false;}
	return true;
}
</script>
<body>

	<form action="emp!add.action" method="post" onsubmit="return checkForm()">
	姓名：<input type="text" name="emp.name"/><font color="red">*</font><br>
	密码：<input type="text" name="emp.pass"/><font color="red">*</font><br>
	职位：<select name="emp.type" style="width: 155px">
				<option value="1">员工</option>
				<option value="2">库管</option>
				<option value="3">经理</option>
			</select><br>
	性别：<select name="emp.sex" style="width: 155px">
				<option value="1">男</option>
				<option value="0">女</option>
			</select><br>
	年龄：<input type="text" name="emp.age"/><br>
	电话：<input type="text" name="emp.phone"/><br>
	备注：<input type="text" name="emp.remark"/><br>
	<input type="submit" value="确认添加"/>
	</form>
	
</body>
</html>

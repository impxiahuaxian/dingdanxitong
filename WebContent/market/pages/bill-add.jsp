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
	var name=document.getElementsByName("bill.goods.id")[0].value;
	var pass=document.getElementsByName("bill.amount")[0].value;
	if(name==null||name==""){alert("商品不能为空!");return false;}
	if(pass==null||pass==""){alert("数量不能为空!");return false;}
	return true;
}
</script>
<body>

	<form action="bill!add.action" method="post" onsubmit="return checkForm()">
	商品：<select name="bill.goods.id" style="width: 155px">
				<s:iterator value="#request.goodses">
					<option value=<s:property value="id"/>><s:property value="name"/></option>
				</s:iterator>
			</select><font color="red">*</font><br>
	数量：<input type="text" name="bill.amount"/><font color="red">*</font><br>
	备注：<input type="text" name="bill.remark"/><br>
	<input type="submit" value="确认添加"/>
	</form>
	<font color="red">${msg}</font>
</body>
</html>

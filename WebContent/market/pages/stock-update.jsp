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

<body>

	<form action="stock!update.action" method="post">
			<input type="hidden" name="stock.id" value="${stock.id}"/>
	商品：<select name="stock.goods.id" style="width: 155px">
				<option value="${stock.goods.id}">${stock.goods.name}</option>
				<s:iterator value="#request.goodses">
					<option value=<s:property value="goods.id"/>><s:property value="goods.name"/></option>
				</s:iterator>
			</select><br>
	数量：<input type="text" name="stock.amount" value="${stock.amount}"/><br>
	备注：<input type="text" name="stock.remark" value="${stock.remark}"/><br>
	<input type="submit" value="确认添加"/>
	</form>
	
</body>
</html>

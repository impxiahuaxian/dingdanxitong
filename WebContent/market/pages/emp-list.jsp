<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}
a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}
a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}
a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}
a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

-->
</style>
</head>

<body>

<table width="80%" border="0" align="left" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
		  <td width="15" height="30"><img src="market/images/tab_03.gif" width="15" height="30" /></td>
		  <td background="market/images/tab_05.gif"><img src="market/images/311.gif" width="16" height="16" /> 
			<span class="STYLE4">员工管理</span></td>
		  <td width="14"><img src="market/images/tab_07.gif" width="14" height="30" /></td>
		</tr>
	  </table>
	</td>
  </tr>
  <tr>
    <td>
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="9" background="market/images/tab_12.gif">&nbsp;</td>
          <td bgcolor="e5f1d6">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CECECE">
				<tr>
					<td width="10%" height="26" background="market/images/tab_14.gif" class="STYLE1">
					<div align="center" class="STYLE2 STYLE1">姓名</div></td>
					<td width="10%" height="26" background="market/images/tab_14.gif" class="STYLE1">
					<div align="center" class="STYLE2 STYLE1">密码</div></td>
					<td width="10%" height="26" background="market/images/tab_14.gif" class="STYLE1">
					<div align="center" class="STYLE2 STYLE1">性别</div></td>
					<td width="10%" height="26" background="market/images/tab_14.gif" class="STYLE1">
					<div align="center" class="STYLE2 STYLE1">年龄</div></td>
					<td width="10%" height="26" background="market/images/tab_14.gif" class="STYLE1">
					<div align="center" class="STYLE2 STYLE1">职位</div></td>
					<td width="10%" height="26" background="market/images/tab_14.gif" class="STYLE1">
					<div align="center" class="STYLE2 STYLE1">电话</div></td>
					<td width="10%" height="26" background="market/images/tab_14.gif" class="STYLE1">
					<div align="center" class="STYLE2 STYLE1">备注</div></td>
					<td width="10%" height="26" background="market/images/tab_14.gif" class="STYLE1">
					<div align="center" class="STYLE2">编辑</div></td>
					<td width="10%" height="26" background="market/images/tab_14.gif" class="STYLE1">
					<div align="center" class="STYLE2">删除</div></td>
				</tr>
				
				<!-- 用struts的iterator标签遍历news集合, 并去处每一个name显示 -->
				<s:iterator value="#request.emps">
	
					<tr>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1"><s:property value="name"/></div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1"><s:property value="pass"/></div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1"><s:if test="sex==1">男</s:if><s:if test="sex==0">女</s:if></div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1"><s:property value="age"/></div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1"><s:if test="type==1">经理</s:if><s:if test="type==2">库管</s:if><s:if test="type==3">员工</s:if></div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1"><s:property value="phone"/></div></td>
						<td height="20" bgcolor="#FFFFFF">
							<div align="center" class="STYLE2 STYLE1"><s:property value="remark"/></div></td>
	
						<td height="20" bgcolor="#FFFFFF"><div align="center">
							<img src="market/images/037.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="emp!update.action?emp.id=<s:property value="id"/>&type='get'">修改</a><span class="STYLE1">]</span></div></td>
						<td height="20" bgcolor="#FFFFFF"><div align="center">
							<img src="market/images/010.gif" width="9" height="9" /><span class="STYLE1">[</span><a href="emp!delete.action?emp.id=<s:property value="id"/>">删除</a><span class="STYLE1">]</span></div></td>
					</tr>
					
				</s:iterator>
				
			</table>
		  </td>
		  <td width="9" background="market/images/tab_16.gif">&nbsp;</td>
		</tr>
	  </table>
	</td>
  </tr>
  <tr>
    <td height="29">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
			<td width="15" height="29"><img src="market/images/tab_20.gif" width="15" height="29" /></td>
			<td background="market/images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0"></table></td>
			<td width="14"><img src="market/images/tab_22.gif" width="14" height="29" /></td>
		  </tr>
		</table>
	</td>
  </tr>
</table>

</body>
</html>

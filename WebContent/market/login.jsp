<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录超市管理系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}
.STYLE3 {
	color: #528311;
	font-size: 12px;
}
.STYLE4 {
	color: #42870a;
	font-size: 12px;
}
-->
</style>

</head>

<body>

<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#70DB93">&nbsp;</td>
  </tr>
  <tr>
    <td height="608">
    <table width="900" style="border: 1px solid #ddd"  cellpadding="0" cellspacing="0" align="center"> 
      <tr>
        <td height="300">
        <form action="emp!login.action" method="post" id="form_login" style="margin-top: 100px">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
          <tr>
            <td  align="center"> 
            <p style="margin-bottom: 40px"><span class="STYLE3" style="font-size:45px;border-bottom: 1px solid #ddd;color:blue;"><b>超市进销存系统</b></span></p>
              <p>
                <input type="text" name="emp.name"  style="height:30px; width:315px; border:solid 1px #cadcb2; font-size:12px; color:black;padding: 4px;" placeholder="请输入用户名">
			 </p>
              <p>
                <input type="password" name="emp.pass"  style="height:30px; width:315px; border:solid 1px #cadcb2; font-size:12px; color:black; padding: 4px" placeholder="请输入密码">
              </p>
            </td>
          </tr>
        </table>
        </td>
      </tr>
      <tr>
        <td height="247" valign="top">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
          <tr>
            <td text-align="center">　　　　　　　　　　　
              <input type="submit" name="Submit" value="提交" style="width:150px;height:40px;margin-left: 110px">　
              <input name="Reset" type="Reset" id="Reset" value="重置" style="width:150px;height:40px;"></td>
          </tr>
          <tr>
            <td height="30">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="20"><font color="red" size="2">${msg}</font></td>
                </tr>
            </table>
            </from>
            </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td bgcolor="#32CD99">&nbsp;</td>
  </tr>
</table>


</body>
</html>

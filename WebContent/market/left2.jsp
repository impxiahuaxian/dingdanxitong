<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
-->

dl,ul,li{list-style:none;}
a{color:#000;}
a:link,a:visited,a:active,a:hover{text-decoration:none;}

.meun_div{width:110px;height:auto;border-top:0;background:#fff;padding-top:10px;font-size:14px;}
.meun_top{width:80px;height:27px;line-height:27px;padding-left:20px;}
.meun_img{float:left;width:7px;height:27px;background:url(market/images/menu_1.gif) no-repeat;}
.meun_box ul{margin:0;padding:0 5px 0 19px;font-size:12px;}
.meun_box li{width:auto;height:20px;line-height:20px;margin:3px 0;padding-left:2px;}
.none_box {display:none;}

</style>

<script type="text/JavaScript"> 
var $=function(id) {
   return document.getElementById(id);
}

//显示子菜单
function show_menu_box(num){
	for(var j=0;j<10;j++){
		if(j!=num){
			if($('box'+j)){
				$('box'+j).style.display='none';
				$('img'+j).style.background='url(market/images/menu_1.gif)';
			}
		}
	}
	if($('box'+num)){   
		if($('box'+num).style.display=='block'){
		  $('box'+num).style.display='none';
		 $('img'+num).style.background='url(market/images/menu_1.gif)';
		}else {
		  $('box'+num).style.display='block';
		  $('img'+num).style.background='url(market/images/menu_2.gif)';
		}
	}
}

</script>
</head>

<body>
<table width="173" height="100%" border="0" cellpadding="0" cellspacing="0" style="table-layout:fixed;">
  <tr>
    <td style="width:4px; background-image:url(market/images/main_16.gif)">&nbsp;</td>
    <td width="169" valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		  <tr>
			<td height="20" background="market/images/main_11.gif">&nbsp;</td>
		  </tr>
		  <tr>
			<td>
				<div class="meun_div" align="center">
					
					<div class="meun_top">
						<div id="img2" class="meun_img"></div>
						<a onclick="show_menu_box(2)" href="javascript:;">商品管理</a>
					</div>
					<div class="meun_box none_box" id="box2">
						<ul>
							<li><a href="goods!storelist.action"  target="rightFrame">&middot;商品库存</a></li>
						</ul>
					</div>
					
					<div class="meun_top">
						<div id="img4" class="meun_img"></div>
						<a onclick="show_menu_box(4)" href="javascript:;">进货管理</a>
					</div>
					<div class="meun_box none_box" id="box4">
						<ul>
							<li><a href="stock!stocklist.action"  target="rightFrame">&middot;进货管理</a></li>
							<li><a href="stock!add.action?type='get'"  target="rightFrame"  target="rightFrame">&middot;进购商品</a></li>
						</ul>
					</div>
					
					<div class="meun_top">
						<div id="img5" class="meun_img"></div>
						<a onclick="show_menu_box(5)" href="javascript:;">出货管理</a>
					</div>
					<div class="meun_box none_box" id="box5">
						<ul>
							<li><a href="sell!selllist.action"  target="rightFrame">&middot;出货管理</a></li>
							<li><a href="sell!add.action?type='get'"  target="rightFrame">&middot;商品出库</a></li>
						</ul>
					</div>

				</div>
			
			</td>
		  </tr>
		</table>
	</td>
  </tr>
</table>
</body>
</html>

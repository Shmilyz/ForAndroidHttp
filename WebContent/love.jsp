<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- href的属性值是一个路径，该路径会自动添加到页面中所有使用相对路径的路径前方 -->
<base href="<%=basePath%>">
<!-- 引入jQuery所依赖的外部文件 -->
<script src="js/jquery-2.2.3.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	function createXmlHttpRequest() {
		var xmlHttp;
		try { //Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try { //Internet Explorer                  xmlHttp=newActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = newActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}
		return xmlHttp;

	}

	var xhr; // 全局变量
	function loginCheck() {
		// 获取数据
		var name = $("#username").val();
		var pwd = $("#userpass").val();
		// 非空检测
		if(name==null || pwd == null || name=="" || pwd=="") {
			alert("请填入用户名和密码") ;
			return ;
		}
		// 向服务器发送请求
		xhr = createXmlHttpRequest() ;
		xhr.open("post" , "login.action" , "true");
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded") ;
		xhr.send("uname=" + name + "&upass=" + pwd);
		// 如果是get方式发送请求，上传的数据跟在url后面? , send()方法不需要加参数，而且不需要调用setRequestHeader()
		xhr.onreadystatechange=loginResult ;
	}
	function loginResult() {
		if(xhr.status==200 && xhr.readyState==4) {
			// 获取服务器响应数据
			var resultStr = xhr.responseText ;
			alert("loginResult : " + resultStr) ;
			// 将结果转换为json对象
			var resultJson = JSON.parse(resultStr) ;
			if("1" == resultJson.result) {
				$("#errM").html("用户名或密码错误！");
			} else {
				// 页面跳转
				location.href="main.action" ;
			}
		}
	}
</script>


</head>
<body>
	<form id="loginForm">
		<div id="errM"></div>
		账号 <input type="text" name="uname" id="username" /> <br /> 密码 <input
			type="password" name="upass" id="userpass" /> <br /> <input
			type="button" id="loginButton" value="登录" onClick="loginCheck()" />
		<input type="reset" value="取消" />
	</form>

</body> 
</html>
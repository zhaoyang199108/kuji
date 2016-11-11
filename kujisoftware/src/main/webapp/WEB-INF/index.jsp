<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		console.log("ss");
		  $("button").click(function(){
				 /* $.ajax({
					url:'http://localhost:8080/kujisoftware/user/login?loginId=admin&psw=1',
					type:'GET',
					success:function(data){
						window.location.href = 'firstPage.jsp';
					}
				});  */
			  window.location.href = '/user/firstPage';
			  });

	})

	</script>
<body>

	<div class="form-group">
		<label for="name">用户名</label> <input type="text" class="form-control"
			id="loginId" placeholder="请输入名称">
	</div>
	<div class="form-group">
		<label for="name">密码</label> <input type="password"
			class="form-control" id="psw" placeholder="密码">
	</div>
	<button type="submit" class="btn btn-default">提交</button>

</body>
</html>

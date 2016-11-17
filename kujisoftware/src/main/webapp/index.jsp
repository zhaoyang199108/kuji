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

		
		  $("button").click(function(){
				var loginId = $("#loginId").val();
				var psw = $("#psw").val();
				   $.ajax({
					url:'http://localhost:8080/kujisoftware/user/login?loginId='+loginId+'&psw='+psw,
					type:'GET',
					success:function(data){
						console.log(data)
						if(data.code==0){
							alert(data.message);
							window.location.href = 'user/firstPage';
						}else{
							alert(data.message);
						}
							
						
					}
				});  
			  
			  });

	})

	</script>
<body>
	<!-- background:url(img/beijing.jpg) no-repeat 10px center -->
	<div id="container" class="container"
		style="margin-top: 10px; height: 600px; background: url(img/1.png) no-repeat center">
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">全脑教育酷●记软件</a>
				</div>
				<!--     <ul class="nav navbar-nav navbar-right">
			      <li><a href="#"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
			      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
			    </ul> -->
			</div>
		</nav>
		<div class="col-md-4" style="margin-top: 200px; margin-left: 750px;">
			<div class="form-group">
				<label for="name">用户名</label> <input type="text"
					class="form-control" id="loginId" placeholder="请输入名称">
			</div>
			<div class="form-group">
				<label for="name">密码</label> <input type="password"
					class="form-control" id="psw" placeholder="密码">
			</div>
			<button type="submit" class="btn btn-default">提交</button>
		</div>
	</div>
<script>
 	
 	function upload(){
 		var upload = $("#ep_file").val();
 		console.log(upload);
 		$("form").submit(function(e){
 			  alert("Submitted");
 			});
 	}
 	</script>
</body>
</html>

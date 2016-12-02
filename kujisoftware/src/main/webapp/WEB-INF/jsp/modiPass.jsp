<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
session.getAttribute("user"); 
 %>
<html>
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
   <script>
   function submitForm(){
		
		var oldPassword = $('#oldPassword').val();
		var newPassword = $('#newPassword').val();
		var re = $('#re').val();
		$.ajax({
			url :path+'/kujisoftware/modiPass/mofifyPassword',
			data:{'oldPassword':oldPassword,'newPassword':newPassword,'re':re},
			type:'GET',
			success : function(data){
				console.log(data);
				if(data.code == '1'){
					alert(data.message);
					 window.location.href = path+'/kujisoftware/modiPass/mofifyPassword';
				}
				if(data.code == '0'){
					alert(data.message);
					 window.location.href = path+'/kujisoftware/user/firstPage';
				}
				if(data.code == '2'){
					alert(data.message);
				  window.location.href = path+'/kujisoftware';
				}
				console.log("ss");
			}
		});
	}	
   
</script>
<body>
	<div id="container" class="container" style="margin-top: 10px;">
		<%-- <%@ include file="common/nav.jsp"%> --%>
		<jsp:include page="common/nav.jsp" />

		<div class="col-md-9">
			<form role="form"  id="modifyPassword_form" >
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">当前登录密码</span> 
					<input type="password"  class="form-control" placeholder="oldPassword" id="oldPassword" name="oldPassword">
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">新密码</span> 
					<input type="password" class="form-control" placeholder="newPassword" 
					id="newPassword" name="newPassword">
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">确认新登录密码</span> 
					<input type="password" 
						class="form-control" placeholder="re" id="re" name="re" name="re">
				</div>
				<div style="margin-top: 10px" align="center" align="center">
					<button type="button" class="btn  btn-primary" onclick="submitForm()">提交</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>

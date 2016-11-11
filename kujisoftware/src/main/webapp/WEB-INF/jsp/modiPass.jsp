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
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
   <script>
	    function submitForm(){
// 	 		var a = $('#a').val();
	 		var type = $('#type').val();
	 		var whichDay = $('#whichDay').val();
	 		var category = $('#category').val();
	 		var errorNumber = $('#errorNumber').val();
	 		var words = $('#words').val();
	 		var anwserTime = $('#anwserTime').val();
	 		var number = $('#number').val();
	 		$.ajax({
	 			url: 'http://localhost:8080/kujisoftware/memoryTrain/saveOrUpdate',
	 			data:{'type':type,'whichDay':whichDay,'category':category,'errorNumber':errorNumber,'words':words,'anwserTime':anwserTime,'number':number},
	 			type:'GET',
	 			success : function(data){
	 				console.log("ss");
	 			}
	 		});
	 	}	
			function checkform(){
				var f=document.opform;
				if(f.oldPassword.value==""){
					alert("请输入原密码");
					return false;
				}else if(f.newPassword.value==""){
					alert("请输入新密码");
					return false;
				}else if(f.newPassword.value!=f.re.value){
					alert("两输入密码不一样，请重新输入");
					return false;
				}
			}
</script>
<body>
	<div id="container" class="container" style="margin-top: 10px;">
		<%-- <%@ include file="common/nav.jsp"%> --%>
		<jsp:include page="common/nav.jsp" />

		<div class="col-md-9">
			<form role="form" onsubmit="javascript:return checkform();">
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">当前登录密码</span> <input type="text"
						class="form-control" placeholder="oldPassword" id="oldPassword">
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">新密码</span> <input type="text"
						class="form-control" placeholder="newPassword" id="newPassword">
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">确认新登录密码</span> <input type="text"
						class="form-control" placeholder="re" id="re">
				</div>
				<div style="margin-top: 10px" align="center" align="center">
					<button type="button" class="btn  btn-primary" onclick="submitForm()">提交</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>

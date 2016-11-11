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
   <script>
	    function submitForm(){
// 	 		var a = $('#a').val();
	 		var type = $('#type').val();
	 		var whichDay = $('#whichDay').val();
	 		var category = $('#category').val();
	 		var errorNumber = $('#errorNumber').val();
	 		var imgName = $('#imgName').val();
	 		var anwserTime = $('#anwserTime').val();
	 		var number = $('#number').val();
	 		var score = $('#score').val();
	 		$.ajax({
	 			url: 'http://localhost:8080/kujisoftware/pictureMemory/saveOrUpdate',
	 			data:{'score':score,'type':type,'whichDay':whichDay,'category':category,'errorNumber':errorNumber,'imgName':imgName,'anwserTime':anwserTime,'number':number},
	 			type:'GET',
	 			success : function(data){
	 				console.log("ss");
	 			}
	 		});
	 	}	
	</script>
<body>
	<div id="container" class="container" style="margin-top: 10px;">
		<jsp:include page="common/nav.jsp" />
		<div class="col-md-9">
			<form role="form">
				<div class="input-group">
					<span class="input-group-addon">题型</span>
					<input id="type" type="text" class="form-control" placeholder="type" value="图片记忆训练"	disabled> 
				</div>

				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">所属类别</span>
					<!-- 		  <input type="text" class="form-control" placeholder="category"> -->
					<select class="form-control" id="category">
						<option value="21天训练">21天训练</option>
						<option value="90天养成好习惯">90天养成好习惯</option>
					</select>
				</div>

				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">第几天</span> <input type="text"
						class="form-control" placeholder="whichDay" id="whichDay">
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">图片</span> <input type="text"
						class="form-control" id="imgName" placeholder="imgName">
				</div>
<!-- 				<div class="input-group" style="margin-top: 10px"> -->
<!-- 					<span class="input-group-addon">上传附件</span> <input type="file" -->
<!-- 						style="width: 170px" id="images" name="ep_file" /> -->
<!-- 				</div> -->
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">数量</span> <input type="text"
						class="form-control" placeholder="number" id="number">
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">错误次数</span> <input type="text"
						class="form-control" placeholder="errorNumber" id="errorNumber">
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">分值</span> <input type="text"
						class="form-control" placeholder="score" id="score">
				</div>
				<div style="margin-top: 10px" align="center">
					<button type="button" class="btn  btn-primary" onclick="submitForm()">提交</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>

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
	 		var playOrder = $('#playOrder').val();
	 		var music = $('#music').val();
	 		$.ajax({
	 			url: 'http://localhost:8080/kujisoftware/musicUpload/saveOrUpdate',
	 			data:{'type':type,'playOrder':playOrder,'music':music},
	 			type:'GET',
	 			success : function(data){
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
					<div class="col-md-8">
			<form role="form" enctype="multipart/form-data"  id="formUp">
				<div class="input-group" >
				  <span class="input-group-addon">类别</span>
				  <input type="text" class="form-control" placeholder="背景音乐"  id="type" value="背景音乐" disabled>
				</div>	
				<div class="input-group" style="margin-top:10px">
				  <span class="input-group-addon">播放顺序</span>
				  <input type="text" class="form-control" placeholder="1" id="playOrder" >
				</div>
				<div class="input-group" style="margin-top:10px">
				 <span class="input-group-addon">音乐</span>
				 <input type="text"  class="form-control"  id="music"/>
				</div>
				<div style="margin-top:10px" align="center">
				<button  type="button" class="btn  btn-primary" onclick="submitForm()">提交</button>
				</div>
			</form>
		    </div>
		     </div>
			</div>
</body>
</html>

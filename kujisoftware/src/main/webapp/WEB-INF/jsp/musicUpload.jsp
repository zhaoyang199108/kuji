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
<script type="text/javascript">
   $(document).ready(function() {
		  $("form").submit(function(e){
			  console.log(e);
			  });
	})
	</script>
<body>
			<div id="container" class="container" style="margin-top: 10px;">
				<%-- <%@ include file="common/nav.jsp"%> --%>
				<jsp:include page="common/nav.jsp" />
			<div class="col-md-9">
			<div class="col-md-8">
			<form role="form" method="POST"  enctype="multipart/form-data"  id="form"  action="http://localhost:8080/kujisoftware/musicUpload/saveOrUpdate" >
				<div class="input-group" >
				  <span class="input-group-addon">类别</span>
				  <input type="text" class="form-control" placeholder="背景音乐"  id="type" value="背景音乐"  name="type" readonly="readonly">
				</div>	
				<div class="input-group" style="margin-top:10px">
				  <span class="input-group-addon">播放顺序</span>
				  <input type="text" class="form-control" placeholder="playOrder" id="playOrder"  name="playOrder">
				</div>
				<div class="input-group" style="margin-top:10px">
				 <span class="input-group-addon">音乐</span>
				 <input type="file" style="width:170px"  name="music_file"  id="music_file" accept="audio/mp3"/>
				</div>
				<div style="margin-top:10px" align="center">
				<button type="submit"  class="btn  btn-primary" name="submit">提交</button>
				</div>
			</form>
		    </div>
		     </div>
			</div>
</body>
</html>

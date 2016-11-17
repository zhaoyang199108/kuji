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
			<form  id = "form" method="POST" enctype="multipart/form-data"  action="http://localhost:8080/kujisoftware/learnExplain/saveOrUpdate">
				<div class="input-group">
					<span class="input-group-addon">题型</span>
							  <input type="text" class="form-control" placeholder="type"  id="type"  name="type"  value="学习讲解"  readonly="readonly">
				</div>

				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">所属类别</span>
					<!-- 		  <input type="text" class="form-control" placeholder="category"> -->
					<select class="form-control"  id="category"  name="category">
						<option value="1">21天训练</option>
						<option value="2">90天养成好习惯</option>
					</select>
				</div>

				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">第几天</span> <input type="text"
						class="form-control"  placeholder="whichDay"   id="whichDay"  name="whichDay" >
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">图片</span> 
 	                     <input type="file" style="width:170px"  name="ep_file"  id="ep_file" accept="image/gif, image/jpeg, image/png, image/jpg"/>
				 </div>
				<div class="input-group" style="margin-top: 10px"> 
					<span class="input-group-addon">语音</span> 
					<input type="file" style="width:170px"  name="vo_file"  id="vo_file" />
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">分值</span> 
					<input type="text"  class="form-control"  placeholder="score"  id="score" name="score">
				</div>
				<div style="margin-top: 10px" align="center">
					<button type="submit" class="btn  btn-primary"  name="submit">提交</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>

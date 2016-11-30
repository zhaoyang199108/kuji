<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@include file="common/tag.jsp" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教育资讯</title>

<script >
		  function submitForm(){
	 		var eduCounseTitle = $('#eduCounseTitle').val();
	 		var eduCounseContent = $('#eduCounseContent').val();
	 		var eduCounseImg = $('#eduCounseImg').val();
	 		var id = $('#id').val();
	 		$.ajax({
	 			url: path+'/kujisoftware/eduCounse/saveOrUpdate',
	 			data:{'eduCounseImg':eduCounseImg,'eduCounseTitle':eduCounseTitle,'eduCounseContent':eduCounseContent,'id':id},
	 			type:'GET',
	 			success : function(data){
	 				alert(data.message);
	 				if(data.code == 0){
	 					 $('#id').val('');
	 					window.location.href=path+'/kujisoftware/eduCounse/eduCounse';
	 				}
	 			}
	 		});
	 		
	 	}	
	 		
	 		function updataEduCounse(id){
	 			$.ajax({
	 				url:path+'/kujisoftware/eduCounse/findEduCounseById',
	 				type:'GET',
	 				data:{'id':id},
	 				success : function(data){
	 					console.log(data);
	 					if(data.code == 0){
	 						  $('#myTab a:first').tab('show'); 
	 						  $('#id').val(data.data.eduCounseId);
	 						  $('#eduCounseTitle').val(data.data.eduCounseTitle);
	 						  $('#eduCounseImg').val(data.data.eduCounseImg);
	 						  $('#eduCounseContent').val(data.data.eduCounseContent);
	 					}
	 				}
	 			}); 

	 		}
	 		
	 		function deleteEduCounse(id){
//	 			console.log($(this))
	 			console.log(id);
	 			$.ajax({
	 				url:path+'/kujisoftware/eduCounse/deleteEduCounse',
	 				type:'GET',
	 				data:{'id':id},
	 				success : function(data){
	 					alert(data.message);
	 					if(data.code == 0){
	 						window.location.href=path+'/kujisoftware/eduCounse/eduCounse';
	 					}
	 				}
	 			}); 
	 		}
</script>
<body>
	<div id="container" class="container" style="margin-top: 10px;">
		<%@ include file="common/nav.jsp"%>
		<div class="col-md-9">
			<ul id="myTab" class="nav nav-tabs">
				<li class="active">
					<a href="#add" data-toggle="tab">
						增加
					</a>
				</li>
				<li><a href="#find" data-toggle="tab" >查询</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="add">
				   <div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">标题</span>
							  <input type="text" class="form-control"  id="eduCounseTitle"  name="eduCounseTitle" >
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">内容图片</span>
					<input type="text" class="form-control"  id="eduCounseImg"  name="eduCounseImg" >
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">内容文本</span> 
				<textarea  class="form-control"  style="overflow-y:auto;" rows="2" cols="30" id="eduCounseContent" ></textarea>
				<input type="hidden" name="id" id="id"> 
				</div>
				<div style="margin-top: 10px" align="center">
				      <button type="button" class="btn  btn-primary" onclick="submitForm()">保存</button>
				</div>
				</div>
			<div class="tab-pane fade" id="find" >
			<!-- style="display:block;position:relative;top:-300px;" -->
				<table class="table table-hover">
					<thead>
						<tr>
							<th>id</th>
							<th>标题</th>
							<th>内容图片</th>
							<th>内容文本</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "sk" items="${eduCounse }">
							<tr>
								<td>${sk.eduCounseId }</td>
								<td>${sk.eduCounseTitle }</td>
								<td>${sk.eduCounseImg }</td>
								<td>${sk.eduCounseContent }</td>
								<td>
									<fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>
									<a class="btn btn-info" target="_blank"   onclick="updataEduCounse(${sk.eduCounseId })" >修改</a>
									<a class="btn btn-info"  onclick="deleteEduCounse(${sk.eduCounseId })" target="_blank" >删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>	
				</table>
			</div>
			</div>
	</div>
	</div>
</body>
</html>
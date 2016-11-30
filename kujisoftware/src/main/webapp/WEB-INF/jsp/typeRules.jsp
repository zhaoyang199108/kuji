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
<title>规则说明</title>
</head>
   <script>
	    function submitForm(){
	 		var typeRulesName = $('#typeRulesName').val();
	 		var typeRulesContent = $('#typeRulesContent').val();
	 		var id = $('#id').val();
	 		$.ajax({
	 			url: 'http://localhost:8080/kujisoftware/typeRules/saveOrUpdate',
	 			data:{'typeRulesName':typeRulesName,'typeRulesContent':typeRulesContent,'id':id},
	 			type:'GET',
	 			success : function(data){
	 				alert(data.message);
	 				if(data.code == 0){
	 					 $('#id').val('');
	 					window.location.href=path+'/kujisoftware/typeRules/typeRules';
	 				}
// 	 				if(data.code == '2'){
// 		 				alert(data.message);
// 		 				 window.location.href = 'http://localhost:8080/kujisoftware/user/firstPage';
// 		 				}
// 	 				if(data.code == '3'){
// 		 				alert(data.message);
// 		 				window.location.href = 'http://localhost:8080/kujisoftware/pictureMemory/pictureMemory';
// 		 				}
	 			}
	 		});
	 		
	 	}	
	 		
	 		function updataTypeRules(id){
	 			$.ajax({
	 				url:path+'/kujisoftware/typeRules/findTypeRulesById',
	 				type:'GET',
	 				data:{'id':id},
	 				success : function(data){
	 					console.log(data);
	 					if(data.code == 0){
	 						 $('#myTab a:first').tab('show'); 
	 						  $("#typeRulesName  option[value='"+data.data.typeRulesName+"'] ").attr("selected",true)
	 						  $('#id').val(data.data.typeRulesId);
	 						 $('#typeRulesContent').val(data.data.typeRulesContent);
	 					}
	 				}
	 			}); 

	 		}
	 		
	 		function deleteTypeRules(id){
//	 			console.log($(this))
	 			console.log(id);
	 			$.ajax({
	 				url:path+'/kujisoftware/typeRules/deleteTypeRules',
	 				type:'GET',
	 				data:{'id':id},
	 				success : function(data){
	 					alert(data.message);
	 					if(data.code == 0){
	 						window.location.href=path+'/kujisoftware/typeRules/typeRules';
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
				      <span class="input-group-addon">题型名称</span>
						<select class="form-control" id="typeRulesName">
							<option value="1">舒尔特表训练</option>
							<option value="2">记忆训练</option>
							<option value="3">学习讲解训练</option>
							<option value="4">图片记忆训练</option>
							<option value="5">速度训练</option>
					 	</select>
					 </div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">规则内容</span> 
					<textarea  class="form-control"  style="overflow-y:auto;" rows="2" cols="30" id="typeRulesContent" ></textarea>
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
							<th>题型名称</th>
							<th>规则内容</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "sk" items="${typeRules }">
							<tr>
								<td>${sk.typeRulesId }</td>
								<td>${sk.typeRulesName }</td>
								<td>${sk.typeRulesContent }</td>
								<td>
									<fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>
									<a class="btn btn-info" target="_blank"   onclick="updataTypeRules(${sk.typeRulesId })" >修改</a>
									<a class="btn btn-info"  onclick="deleteTypeRules(${sk.typeRulesId })" target="_blank" >删除</a>
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
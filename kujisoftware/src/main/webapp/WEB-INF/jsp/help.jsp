<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@include file="common/tag.jsp" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>帮助说明</title>
</head>

<script>
function saveHelp(){
	var whichExercise = $('#whichExercise').val();
	var content = $('#content').val();
	var id = $('#id').val();
	$.ajax({
		url:path+'/kujisoftware/help/saveHelp',
		data:{'whichExercise':whichExercise,'content':content,'id':id},
		type:'GET',
		success:function(data){
			alert(data.message);
			if(data.code == 0){
				 $('#id').val('');
				window.location.href=path+'/kujisoftware/help/help';
			}
		}
	});
}
function updataHelp(id){
	$.ajax({
		url:path+'/kujisoftware/help/findHelpById',
		type:'GET',
		data:{'id':id},
		success : function(data){
			console.log(data);
			if(data.code == 0){
				 $('#myTab a:first').tab('show'); 
				  $("#whichExercise  option[value='"+data.data.exerciseId+"'] ").attr("selected",true)
				  $('#id').val(data.data.helpId);
				 $('#content').val(data.data.helpContent);
			}
		}
	}); 

}
function deleteHelp(id){
//	console.log($(this))
	console.log(id);
	$.ajax({
		url:path+'/kujisoftware/help/deleteHelp',
		type:'GET',
		data:{'id':id},
		success : function(data){
			alert(data.message);
			if(data.code == 0){
				 
				window.location.href=path+'/kujisoftware/help/help';
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
		      <select class="form-control"  id="whichExercise"  name="whichExercise">
					<option value="1000">21天训练</option>
					<option value="1001">90天养成好习惯</option>
				</select>
			</div>
			<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">帮助说明文本</span> 
					<textarea  class="form-control"  style="overflow-y:auto;" rows="10" cols="30" id="helpContent" ></textarea>
				<input type="hidden" name="id" id="id"> 
				</div>
				
<!-- 				<div class="input-group" style="margin-top: 10px"> -->
<!-- 				<span style="display:block;position:relative;top:0px;">帮助说明文本：</span> -->
<!-- 				<textarea id="content" style="width:400px;height:200px;"></textarea> -->
<!-- 				<input type="hidden" name="id" id="id">  -->
<!-- 				</div> -->
				<div align="center">
				<button class="btn btn-primary" onclick="saveHelp()">保存</button>
				</div>
			</div>
			<div class="tab-pane fade" id="find" >
				<table class="table table-hover">
					<thead>
						<tr>
							<th>id</th>
							<th>内容</th>
							<th>创建时间</th>
							<th>类别id</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "sk" items="${help }">
							<tr>
								<td>${sk.helpId }</td>
								<td>${sk.helpContent }</td>
								<td>
									<fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>
								${sk.exerciseId }
								</td>
								<td>
									<a class="btn btn-info" target="_blank"   onclick="updataHelp(${sk.helpId })" >修改</a>
									<a class="btn btn-info"  onclick="deleteHelp(${sk.helpId })" target="_blank" >删除</a>
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

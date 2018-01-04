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
<title>曼陀罗训练</title>
</head>
<script>
	function submitForm(){
		    var id = $('#id').val();
	 		var score = $('#score').val();
	 		var type = $('#type').val();
	 		var whichDay = $('#whichDay').val();
	 		var exerciseId = $('#exerciseId').val();
	 		var errorNumber = $('#errorNumber').val();
	 		$.ajax({
	 			url: path+'/kujisoftware/mandara/saveOrUpdate',
	 			data:{
	 				'id':id,
	 				'type':type,
	 				'whichDay':whichDay,
	 				'exerciseId':exerciseId,
	 				'errorNumber':errorNumber,
	 				'score':score},
	 			type:'GET',
	 			success : function(data){
	 				if(data.code == 1){
	 					alert(data.message);
	 				}
	 				if(data.code == 0){
	 					alert(data.message);
	 					window.location.href=path+'/kujisoftware/mandara/mandara';
	 				}
	 			}
	 		});
	 	}	
	
	function updataMandara(id){
		$.ajax({
			url:path+'/kujisoftware/mandara/findMandaraById',
			type:'GET',
			data:{'id':id},
			success : function(data){
				console.log(data);
				if(data.code == 0){
					  $('#myTab a:first').tab('show'); 
					  $("#type  option[value='"+data.data.type+"'] ").attr("selected",true)
					  $('#exerciseId').val(data.data.exerciseId);
					  $('#whichDay').val(data.data.whichDay);
					  $('#id').val(data.data.id);
					 $('#errorNumber').val(data.data.errorNumber);
					 $('#score').val(data.data.score);
				}
			}
		}); 

	}

	
	</script>
<body>
	<div id="container" class="container" style="margin-top: 10px;">
		<%-- <%@ include file="common/nav.jsp"%> --%>
		<jsp:include page="common/nav.jsp" />
		<div class="col-md-9">
			<ul id="myTab" class="nav nav-tabs">
				<li class="active">
					<a href="#add" data-toggle="tab">
						增加
					</a>
				</li>
				<li><a href="#find" data-toggle="tab" >查询</a></li>
			</ul>
			<div  id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="add">
						<div class="input-group">
							<span class="input-group-addon">题型</span> 
							<select class="form-control" id="type" disabled>
						          <option value="5">曼陀罗训练</option>
			                </select>
						</div>
						<div class="input-group" style="margin-top: 10px">
							<span class="input-group-addon">所属类别</span> 
							<select class="form-control" id="exerciseId">
								<option value="1000">21天训练</option>
								<option value="1001">90天养成好习惯</option>
							</select>
						</div>
		
						<div class="input-group" style="margin-top: 10px">
							<span class="input-group-addon">第几天</span> 
							<select class="form-control" id="whichDay">
								<option value="1">第一天</option>
								<option value="2">第二天</option>
								<option value="3">第三天</option>
								<option value="4">第四天</option>
								<option value="5">第五天</option>
								<option value="6">第六天</option>
								<option value="7">第七天</option>
								<option value="8">第八天</option>
								<option value="9">第九天</option>
								<option value="10">第十天</option>
								<option value="11">第十一天</option>
								<option value="12">第十二天</option>
								<option value="13">第十三天</option>
								<option value="14">第十四天</option>
								<option value="15">第十五天</option>
								<option value="16">第十六天</option>
								<option value="17">第十七天</option>
								<option value="18">第十八天</option>
								<option value="19">第十九天</option>
								<option value="20">第二十天</option>
								<option value="21">第二十一天</option>
							</select>
						</div>
						<div class="input-group" style="margin-top: 10px">
							<span class="input-group-addon">错误次数</span> <input type="text"
								class="form-control" placeholder="errorNumber" id="errorNumber">
						</div>
						<div class="input-group" style="margin-top: 10px">
							<span class="input-group-addon">分值</span> <input type="text"
								class="form-control" placeholder="score" id="score">
								<input type="hidden" name="id" id="id"> 
						</div>
						<div style="margin-top: 10px" align="center">
							<button type="button" class="btn  btn-primary" onclick="submitForm()" >提交</button>
						</div>
				</div>
				<div class="tab-pane fade" id="find">
					<table class="table table-hover">
					<thead>
						<tr>
							<th>题型</th>
							<th>所属类别</th>
							<th>第几天</th>
							<th>错误次数</th>
							<th>分值</th>
							<th>创建时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "sk" items="${mandara }">
							<tr>
								<td>${sk.type }</td>
								<td>${sk.exerciseId }</td>
								<td>${sk.whichDay }</td>
								<td>${sk.errorNumber }</td>
								<td>${sk.score }</td>
								<td>
									<fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>
									<a class="btn btn-info" target="_blank"   onclick="updataMandara(${sk.id })" >修改</a>
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
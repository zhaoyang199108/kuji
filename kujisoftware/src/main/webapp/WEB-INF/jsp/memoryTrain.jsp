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
<script src="https://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>记忆训练</title>
</head>
   <script>
   var temp;
	    function submitForm(){
// 	 		var a = $('#a').val();
            var id = $('#id').val();
	 		var type = $('#type').val();
	 		var whichDay = $('#whichDay').val();
	 		var exerciseId = $('#exerciseId').val();
	 		var errorNumber = $('#errorNumber').val();
	 		var words = $('#contents').val();
	 		var number = $('#number').val();
	 		var score = $('#score').val();
	 		$.ajax({
	 			url: path+'/kujisoftware/memoryTrain/saveOrUpdate',
	 			data:{'id':id,'score':score,'type':type,'whichDay':whichDay,'exerciseId':exerciseId,'errorNumber':errorNumber,'words':words,'number':number},
	 			type:'GET',
	 			success : function(data){
	 				alert(data.message);
					if(data.code == 0){
						window.location.href=path+'/kujisoftware/memoryTrain/memoryTrain';
					}
	 			}
	 		});
	 	}	
		function saveToTextarea(){
			var word = $('#word').val();
		    var content = 	$('#contents').val();
		    console.log(content);
			if(content==null||content==""){
				$('#contents').append(word);
			}else{
				$('#contents').val(content+";"+word);
			}
				$('#myModal').modal('hide');
				$('#word').val("");
			}

	
	function updatamemoryTrain(id){
			$.ajax({
				url:path+'/kujisoftware/memoryTrain/findMemoryTrainById',
				type:'GET',
				data:{'id':id},
				success : function(data){
					console.log(data);
					if(data.code == 0){
						 $('#myTab a:first').tab('show'); 
						  $("#type  option[value='"+data.data.type+"'] ").attr("selected",true)
						  $('#exerciseId').val(data.data.exerciseId);
// 						  $("#exerciseId  option[value='"+data.data.exerciseId+"'] ").attr("selected",true)
						   $('#whichDay').val(data.data.memoryTrainWhichDay);
// 						   $("#whichDay  option[value='"+data.data.whichDay+"'] ").attr("selected",true)
						  $('#id').val(data.data.memoryTrainId);
						 $('#contents').val(data.data.memoryTrainWords);
						 $('#number').val(data.data.memoryTrainNumber);
						 $('#errorNumber').val(data.data.memoryTrainErrorNumber);
						 $('#score').val(data.data.memoryTrainScore);
					}
				}
			}); 

		}
	
	function deleteMemoryTrain(id){
			console.log(id);
			$.ajax({
				url:path+'/kujisoftware/memoryTrain/deleteMemoryTrain',
				type:'GET',
				data:{'id':id},
				success : function(data){
					alert(data.message);
					if(data.code == 0){
						window.location.href=path+'/kujisoftware/memoryTrain/memoryTrain';
					}
				}
			}); 
		}
	
	function showDialog(){
		$('#myModal').modal('show');
	}
	
	function showDialo(id){
		$('#myModa').modal('show');
		temp=id;
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
					<span class="input-group-addon">题型</span>
					<select class="form-control" id="type" disabled>
						  <option value="2">记忆训练</option>
			        </select>
				</div>

				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">所属类别</span>
					<!-- 		  <input type="text" class="form-control" placeholder="category"> -->
				<select class="form-control" id="exerciseId">
						<option value="1000">21天训练</option>
						<option value="1001">90天养成好习惯</option>
					</select>
				</div>

				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">第几天</span> 
							<select class="form-control" id="whichDay">
								<option value="c1">测试一</option>
								<option value="1">第一天</option>
								<option value="2">第二天</option>
								<option value="3">第三天</option>
								<option value="4">第四天</option>
								<option value="5">第五天</option>
								<option value="6">第六天</option>
								<option value="7">第七天</option>
								<option value="c2">测试二</option>
								<option value="8">第八天</option>
								<option value="9">第九天</option>
								<option value="10">第十天</option>
								<option value="11">第十一天</option>
								<option value="12">第十二天</option>
								<option value="13">第十三天</option>
								<option value="14">第十四天</option>
								<option value="c3">测试三</option>
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
					<span class="input-group-addon" id="words">词语</span>
					
					<textarea 	 class="form-control"  rows="3"  id="contents" name="contents"></textarea> <span>(格式为1;2;3;4...分号为英文)</span>
							<!-- 按钮触发模态框 -->
				</div>

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
					<input type="hidden" name="id" id="id"> 
				</div>
				<div style="margin-top: 10px" align="center" align="center">
					<button type="button" class="btn  btn-primary" onclick="submitForm()">保存</button>
				</div>
				 <button class="btn btn-primary btn-md"  onclick="showDialog()" style="display:block;position:relative;top:0px">
					添加词语
					</button>	
						
						<!-- 模态框（Modal） -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
										&times;
									</button>
									<h4 class="modal-title" id="myModalLabel">
										添加词语
									</h4>
								</div>
								
								<div class="modal-body">
								请输入词语：<input type = "text" id="word">
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
									</button>
									<button type="button" class="btn btn-primary" onclick="saveToTextarea()">
										提交更改
									</button>
								</div>
							</div><!-- /.modal-content -->
						</div><!-- /.modal -->
					</div>
				</div>
			<div class="tab-pane fade" id="find" >
			<!-- style="display:block;position:relative;top:-300px;" -->
				<table class="table table-hover">
					<thead>
						<tr>
							<th>id</th>
							<th>题型</th>
							<th>所属类别</th>
							<th>第几天</th>
							<th>词语</th>
							<th>数量</th>
							<th>错误次数</th>
							<th>分值</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "sk" items="${memoryTrain }">
							<tr>
								<td>${sk.memoryTrainId }</td>
								<td>${sk.memoryTrainType }</td>
								<td>${sk.exerciseId }</td>
								<td>${sk.memoryTrainWhichDay }</td>
								<td>${sk.memoryTrainWords }</td>
								<td>${sk.memoryTrainNumber }</td>
								<td>${sk.memoryTrainErrorNumber }</td>
								<td>${sk.memoryTrainScore }</td>
								<td>
									<fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>
									<a class="btn btn-info" target="_blank"   onclick="updatamemoryTrain(${sk.memoryTrainId })" >修改</a>
									<button class="btn btn-info"  onclick="showDialo(${sk.memoryTrainId })" style="display:block;position:relative;top:0px">
									删除
								</button>	
									<!-- 模态框（Modal） -->
					<div class="modal fade" id="myModa" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
										&times;
									</button>
								
								</div>
								<div class="modal-body">
									确定要删除数据吗?
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
									</button>
									<button type="button" class="btn btn-primary" onclick="deleteMemoryTrain(temp)">
									    确定
									</button>
								</div>
							</div><!-- /.modal-content -->
						</div><!-- /.modal -->
					</div>
<%-- 									<a class="btn btn-info"  onclick="deleteMemoryTrain(${sk.memoryTrainId })" target="_blank" >删除</a> --%>
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

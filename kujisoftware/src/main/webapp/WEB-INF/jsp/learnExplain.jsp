<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="common/tag.jsp" %>	
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
			  $("form").submit(function(data){
				   alert(document.getElementById("ep_file").value);   
				  if(document.getElementById("ep_file").value==null || document.getElementById("ep_file").value==""){
					  alert("请上传图片!");
					  window.location.href = path+'/kujisoftware/learnExplain/learnExplain';
				  }
				  if(document.getElementById("vo_file").value==null || document.getElementById("vo_file").value==""){
					  alert("请上传语音!");
					  window.location.href = path+'/kujisoftware/learnExplain/learnExplain';
				  }
				  if(document.getElementById("learnExplainScore").value==null || document.getElementById("learnExplainScore").value==""){
					  alert("请输入分值!");
					  window.location.href = path+'/kujisoftware/learnExplain/learnExplain';
				  }
				  console.log(data);
// 				  alert(data.message);
// 				  if(data.code == '3'){
// 		 				alert(data.message);
// 		 		   }
				  });
		})
		
function deleteLearnExplain(id){
//	console.log($(this))
	console.log(id);
	$.ajax({
		url:path+'/kujisoftware/learnExplain/deleteLearnExplain',
		type:'GET',
		data:{'id':id},
		success : function(data){
			alert(data.message);
			if(data.code == 0){
				 
				window.location.href=path+'/kujisoftware/learnExplain/learnExplain';
			}
		}
	}); 
}
function updataLearnExplain(id){
	
	$.ajax({
		url:path+'/kujisoftware/learnExplain/findLearnExplainById',
		type:'GET',
		data:{'id':id},
		success : function(data){
			console.log(data);
			//alert(data.message);
			if(data.code == 0){
				$('#myTab a:first').tab('show'); 
				/*   $("#whichExercise  option[value='"+data.data.exerciseId+"'] ").attr("selected",true)
				  $('#id').val(data.data.helpId);
				 $('#content').val(data.data.helpContent); */
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
			<div id="myTabContent" class="tab-content">
			<div class="tab-pane fade in active" id="add">
			<form  id = "form" method="POST" enctype="multipart/form-data"  action="<%=basePath %>learnExplain/saveOrUpdate">
				<div class="input-group">
					<span class="input-group-addon">题型</span>
				  <!--   <input type="text" class="form-control" placeholder="learnExplainType"  id="learnExplainType"  name="learnExplainType"  value="学习讲解"  readonly="readonly"> -->
					<select class="form-control" id="learnExplainType" name="learnExplainType" readonly="readonly">
						  <option value="3">学习讲解</option>
			        </select>
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">所属类别</span>
					<!-- 		  <input type="text" class="form-control" placeholder="category"> -->
					<select class="form-control"  id="exerciseId"  name="exerciseId">
						<option value="1000">21天训练</option>
						<option value="1001">90天养成好习惯</option>
					</select>
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">第几天</span> 
					<select class="form-control" id="learnExplainWhichDay" name="learnExplainWhichDay">
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
					<span class="input-group-addon">图片</span> 
 	                     <input type="file" style="width:170px"  name="ep_file"  id="ep_file" accept="image/gif, image/jpeg, image/png, image/jpg"/>
				 </div>
				<div class="input-group" style="margin-top: 10px"> 
					<span class="input-group-addon">语音</span> 
					<input type="file" style="width:170px"  name="vo_file"  id="vo_file" />
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">分值</span> 
					<input type="text"  class="form-control"  placeholder="learnExplainScore"  id="learnExplainScore" name="learnExplainScore">
				</div>
				<div style="margin-top: 10px" align="center">
					<button type="submit" class="btn  btn-primary"  name="submit">提交</button>
				</div>
			</form>
			
			</div>
		
			<div class="tab-pane fade" id="find" >
				<table class="table table-hover">
					<thead>
						<tr>
							<th>id</th>
							<th>第几天</th>
							<th>类别</th>
							<th>分数</th>
							<th>创建时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "sk" items="${help }">
						<tr>
								<td>${sk.learnExplainId }</td>
								<td>${sk.learnExplainWhichDay }</td>
								<td>${sk.learnExplainType }</td>
								<td>${sk.learnExplainScore }</td>
								<td>
									<fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>
									<a class="btn btn-info" target="_blank"   onclick="updataLearnExplain(${sk.learnExplainId })" >修改</a>
									<a class="btn btn-info"  onclick="deleteLearnExplain(${sk.learnExplainId })" target="_blank" >删除</a>
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

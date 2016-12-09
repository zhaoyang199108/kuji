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
<title>图片记忆训练</title>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
   <script>
   $(document).ready(function() {
		  $("form").submit(function(data){
			  if(document.getElementById("file_upload").value==null || document.getElementById("file_upload").value==""){
				  alert("请上传图片!");
			  }
			  if(document.getElementById("number").value==null || document.getElementById("number").value==""){
				  alert("请填写数量!");
			  }
			  if(document.getElementById("errorNumber").value==null || document.getElementById("errorNumber").value==""){
				  alert("请填写错误次数!");
			  }
			  if(document.getElementById("score").value==null || document.getElementById("score").value==""){
				  alert("请填写分数!");
			  }
			  console.log(data);
			  });
	})
	
   function openUpload(){
	   $('#myModal').modal('show');
   }
   
   $(function() {
	   $("#file_upload").change(function() {
	   var $file = $(this);
	   var fileObj = $file[0];
	   var windowURL = window.URL || window.webkitURL;
	   var dataURL;
	   var $img = $("#preview");
	    
	   if(fileObj && fileObj.files && fileObj.files[0]){
	   dataURL = windowURL.createObjectURL(fileObj.files[0]);
	   $img.attr('src',dataURL);
	   }else{
	   dataURL = $file.val();
	   var imgObj = document.getElementById("preview");
	   // 两个坑:
	   // 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
	   // 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
	   imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
	   imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
	    
	   }
	   });
	   });
   
	function deletePictureMemory(id){
//			console.log($(this))
			console.log(id);
			$.ajax({
				url:path+'/kujisoftware/pictureMemory/deletePictureMemory',
				type:'GET',
				data:{'id':id},
				success : function(data){
					alert(data.message);
					if(data.code == 0){
						window.location.href=path+'/kujisoftware/pictureMemory/pictureMemory';
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
			<form method="post" enctype="multipart/form-data" action="<%=basePath %>pictureMemory/saveOrUpdate">
				<div class="input-group">
					<span class="input-group-addon">题型</span>
					<select class="form-control" id="type" name="type" readonly="readonly">
						  <option value="3">学习讲解</option>
			        </select>
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">所属类别</span>
					<select class="form-control" id="exerciseId" name = "exerciseId">
						<option value="1000">21天训练</option>
						<option value="1001">90天养成好习惯</option>
					</select>
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">第几天</span> 
						<select class="form-control" id="whichDay" name="whichDay">
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
					<input id="file_upload" type="file"  name="files" multiple="true" />
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">数量</span> <input type="text"
						class="form-control" placeholder="number" id="number" name = "number">
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">错误次数</span> <input type="text"
						class="form-control" placeholder="errorNumber" id="errorNumber" name = "errorNumber">
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">分值</span> <input type="text"
						class="form-control" placeholder="score" id="score" name = "score">
				</div>
				<div style="margin-top: 10px" align="center">
					<button type="submit" class="btn  btn-primary" >提交</button>
				</div>
			</form>
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
							<th>数量</th>
							<th>错误次数</th>
							<th>分值</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "sk" items="${pictureMemory }">
							<tr>
								<td>${sk.pictureMemoryId }</td>
								<td>${sk.pictureMemoryType }</td>
								<td>${sk.exerciseId }</td>
								<td>${sk.pictureMemoryWhichDay }</td>
								<td>${sk.pictureMemoryNumber }</td>
								<td>${sk.pictureMemoryErrorNumber }</td>
								<td>${sk.pictureMemoryScore }</td>
								<td>
									<fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>
									<a class="btn btn-info"  onclick="deletePictureMemory(${sk.pictureMemoryId })" target="_blank" >删除</a>
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
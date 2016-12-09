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
<title>音乐上传</title>
</head>
<script type="text/javascript">
$(document).ready(function() {
	  $("form").submit(function(data){
		  if(document.getElementById("playOrder").value==null || document.getElementById("playOrder").value==""){
			  alert("请填写播放顺序!");
			  window.location.href = path+'/kujisoftware/musicUpload/musicUpload';
		  }
		  if(document.getElementById("music_file").value==null || document.getElementById("music_file").value==""){
			  alert("请上传图片!");
			  window.location.href = path+'/kujisoftware/musicUpload/musicUpload';
		  }
		  console.log(data);
		  });
})

function updataMusicUpload(id){
	$.ajax({
		url:path+'/kujisoftware/musicUpload/findMusicUploadById',
		type:'GET',
		data:{'id':id},
		success : function(data){
			console.log(data);
			if(data.code == 0){
				 $('#myTab a:first').tab('show'); 
				  $('#id').val(data.data.musicUploadId);
				  $("#type  option[value='"+data.data.type+"'] ").attr("selected",true)
				  $('#playOrder').val(data.data.musicUploadPlayOrder);
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
			<form role="form" method="POST"  enctype="multipart/form-data"  id="form1" action="<%=basePath %>musicUpload/saveOrUpdate" >
				<div class="input-group" >
				  <span class="input-group-addon">类别</span>
				  <input type="text" class="form-control" placeholder="背景音乐"  id="type" value="背景音乐"  name="type" readonly="readonly">
				<input type="hidden" name="id" id="id"> 
				</div>	
				<div class="input-group" style="margin-top:10px">
				  <span class="input-group-addon">播放顺序</span>
				  <input type="text" class="form-control" placeholder="playOrder" id="playOrder"  name="playOrder">
				</div>
				<div class="input-group" style="margin-top:10px">
				 <span class="input-group-addon">音乐</span>
				 <input type="file" style="width:170px"  name="music_file"  id="music_file" accept="audio/mp3"/>(*注：请上传6M以下的图片)
				</div>
				<div style="margin-top:10px" align="center">
				<button type="submit"   class="btn  btn-primary" name="submit">提交</button>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="find" >
			<!-- style="display:block;position:relative;top:-300px;" -->
				<table class="table table-hover">
					<thead>
						<tr>
							<th>id</th>
							<th>类别</th>
							<th>播放顺序</th>
							<th>音乐</th>
							<th>音乐名称</th>
<!-- 							<th>创建时间</th> -->
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "sk" items="${musicUpload }">
							<tr>
								<td>${sk.musicUploadId }</td>
								<td>${sk.musicUploadType }</td>
								<td>${sk.musicUploadPlayOrder }</td>
								<td>${sk.musicUploadMusic }</td>
								<td>${sk.musicUploadName }</td>
<!-- 								<td> -->
<%-- 									<fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/> --%>
<!-- 								</td> -->
								<td>
								<a class="btn btn-info" target="_blank"   onclick="updataMusicUpload(${sk.musicUploadId })" >修改</a>
<%-- 									<a class="btn btn-info"  onclick="deletePictureMemory(${sk.pictureMemoryId })" target="_blank" >删除</a> --%>
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
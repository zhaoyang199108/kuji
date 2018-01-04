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
<title>教育资讯</title>

<script >
		  function submitForm(){
			  if(document.getElementById("file_upload").value==null || document.getElementById("file_upload").value==""){
				  alert("请上传图片!");
				  window.location.href=path+'/kujisoftware/eduCounse/eduCounse';
			  }
// 			  console.log(data);
// 	 		var eduCounseTitle = $('#eduCounseTitle').val();
// 	 		var eduCounseContent = $('#eduCounseContent').val();
// 	 		var eduCounseImg = $('#eduCounseImg').val();
// 	 		var id = $('#id').val();
// 	 		$.ajax({
// 	 			url: path+'/kujisoftware/eduCounse/saveOrUpdate',
// 	 			data:{'eduCounseImg':eduCounseImg,'eduCounseTitle':eduCounseTitle,'eduCounseContent':eduCounseContent,'id':id},
// 	 			type:'POST',
// 	 			success : function(data){
// 	 				alert(data.message);
// 	 			}
// 	 		});
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
	 		var temp;
	 		function showDialog(id){
	 			$('#myModal').modal('show');
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
				<form method="post" enctype="multipart/form-data" action="<%=basePath %>eduCounse/saveOrUpdate">
				 <div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">标题</span>
							  <input type="text" class="form-control"  id="eduCounseTitle"  name="eduCounseTitle" >
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">内容图片</span>
					<input id="file_upload" type="file"  name="files" multiple="true" />
<!-- 					<input type="text" class="form-control"  id="eduCounseImg"  name="eduCounseImg" > -->
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">内容文本</span> 
				<textarea  class="form-control"  style="overflow-y:auto;" rows="2" cols="30" id="eduCounseContent" name="eduCounseContent"></textarea>
				<input type="hidden" name="id" id="id"> 
				</div>
				<div style="margin-top: 10px" align="center">
				      <button type="submit" class="btn  btn-primary"  name="submit">保存</button>
				</div>
				</form>
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
								<button class="btn btn-info"  onclick="showDialog(${sk.eduCounseId })" style="display:block;position:relative;top:0px">
									删除
								</button>
					<!-- 模态框（Modal） -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
									<button type="button" class="btn btn-primary" onclick="deleteEduCounse(temp)">
									    确定
									</button>
								</div>
							</div><!-- /.modal-content -->
						</div><!-- /.modal -->
					</div>
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
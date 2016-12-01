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
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

   <script>
	 /*    function submitForm(){
// 	 		var a = $('#a').val();
	 		var type = $('#type').val();
	 		var whichDay = $('#whichDay').val();
	 		var category = $('#category').val();
	 		var errorNumber = $('#errorNumber').val();
	 		//var imgName = $('#imgName').val();
	 		var images = $('#images[]').val();
	 		var anwserTime = $('#anwserTime').val();
	 		var number = $('#number').val();
	 		var score = $('#score').val();
	 		$.ajax({
	 			url: 'http://localhost:8080/kujisoftware/pictureMemory/saveOrUpdate',
	 			data:{'score':score,'type':type,'whichDay':whichDay,'category':category,'errorNumber':errorNumber,'imgName':imgName,'anwserTime':anwserTime,'number':number},
	 			type:'GET',
	 			success : function(data){
	 				console.log("ss");
	 			}
	 		});
	 	} */
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
	</script>
<body>
	<div id="container" class="container" style="margin-top: 10px;">
		<jsp:include page="common/nav.jsp" />
		<div class="col-md-9">
			<form method="post" enctype="multipart/form-data" action="/kujisoftware/pictureMemory/saveOrUpdate">
				<div class="input-group">
					<span class="input-group-addon">题型</span>
					<input id="type" type="text" class="form-control" placeholder="type" value="图片记忆训练"	disabled> 
				</div>

				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">所属类别</span>
					<!-- 		  <input type="text" class="form-control" placeholder="category"> -->
					<select class="form-control" id="category">
						<option value="1000">21天训练</option>
						<option value="1001">90天养成好习惯</option>
					</select>
				</div>

				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">第几天</span> <input type="text"
						class="form-control" placeholder="whichDay" id="whichDay">
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">图片</span> 
					<!--  <div id="zyupload" name="zyupload" class="zyupload"></div>   -->
					<!-- <input type="button" value="上传图片" onclick="openUpload()"> -->
					<!-- <input type="file" name="img" id="img" >
					<div id="imgshow">
					
					</div> -->
					<input id="file_upload" type="file"  name="files" multiple="true" />
					<div class="image_container">
					<img id="preview" width="60" height="60">
					</div>
				</div>
<!-- 				<div class="input-group" style="margin-top: 10px"> -->
<!-- 					<span class="input-group-addon">上传附件</span> <input type="file" -->
<!-- 						style="width: 170px" id="images" name="ep_file" /> -->
<!-- 				</div> -->
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
				</div>
				<div style="margin-top: 10px" align="center">
					<button type="submit" class="btn  btn-primary" >提交</button>
				</div>
			</form>
		</div>
	</div>
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
									 <div id="zyupload" name="zyupload" class="zyupload"></div>  
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
</body>
</html>

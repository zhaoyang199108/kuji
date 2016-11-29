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
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
/* $(document).ready(function() {
			  $("form").submit(function(data){
				   alert(document.getElementById("eduCounseTitle").value);   
				  if(document.getElementById("eduCounseTitle").value==null || document.getElementById("eduCounseTitle").value==""){
					  alert("请填写标题!");
					  window.location.href = 'http://localhost:8080/kujisoftware/eduCounse/eduCounse';
				  }
				  if(document.getElementById("eduCounseContent").value==null || document.getElementById("eduCounseContent").value==""){
					  alert("请填写内容!");
					  window.location.href = 'http://localhost:8080/kujisoftware/eduCounse/eduCounse';
				  }
				  if(document.getElementById("learnExplainScore").value==null || document.getElementById("learnExplainScore").value==""){
					  alert("请输入分值!");
					  window.location.href = 'http://localhost:8080/kujisoftware/eduCounse/eduCounse';
				  }
				  console.log(data);
// 				  alert(data.message);
// 				  if(data.code == '3'){
// 		 				alert(data.message);
// 		 		   }
				  });
		}) */
		  function submitForm(){
	 		var eduCounseTitle = $('#eduCounseTitle').val();
	 		var eduCounseContent = $('#eduCounseContent').val();
	 		var id = $('#id').val();
	 		$.ajax({
	 			url: 'http://localhost:8080/kujisoftware/eduCounse/saveOrUpdate',
	 			data:{'eduCounseTitle':eduCounseTitle,'eduCounseContent':eduCounseContent,'id':id},
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
	 		
	 		function updataTypeRules(id){
	 			$.ajax({
	 				url:path+'/kujisoftware/eduCounse/findEduCounseById',
	 				type:'GET',
	 				data:{'id':id},
	 				success : function(data){
	 					console.log(data);
	 					if(data.code == 0){
	 						 $('#myTab a:first').tab('show'); 
	 						  $("#eduCounseId  option[value='"+data.data.eduCounseTitle+"'] ").attr("selected",true)
	 						  $('#id').val(data.data.eduCounseId);
	 						 $('#typeRulesContent').val(data.data.eduCounseContent);
	 					}
	 				}
	 			}); 

	 		}
	 		
	 		function deleteTypeRules(id){
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
		<%-- <%@ include file="common/nav.jsp"%> --%>
		<jsp:include page="common/nav.jsp" />
		<div class="col-md-9">
			<form  id = "form" method="POST" enctype="multipart/form-data"  action="http://localhost:8080/kujisoftware/learnExplain/saveOrUpdate">
				<div class="input-group">
					<span class="input-group-addon">标题</span>
							  <input type="text" class="form-control" placeholder="eduCounseTitle"  id="eduCounseTitle"  name="eduCounseTitle" >
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">内容图片</span>
					<input type="text" class="form-control" placeholder="eduCounseImg"  id="eduCounseImg"  name="eduCounseImg" >
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">内容文本</span> 
				<textarea  class="form-control"  style="overflow-y:auto;" rows="2" cols="30" id="eduCounseContent" ></textarea>
				</div>
				<div style="margin-top: 10px" align="center">
					<button type="submit" class="btn  btn-primary"  name="submit">提交</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>

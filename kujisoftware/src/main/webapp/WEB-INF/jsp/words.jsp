<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
   <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script >
	$(document).ready(function() {
		
/* 		$.ajax({
			url:'http://localhost:8080/kujisoftware/exercise/findAllExercise',
			type:'GET',
			success:function(data){
				console.log(data)		
			}
			
		}); */
	})
	</script>
<body>
	<div id="container" class="container" style="margin-top:10px;">
		<%-- <%@ include file="common/nav.jsp"%> --%>
		<jsp:include page="common/nav.jsp" />

  <div class="col-md-9">
	<form role="form">
		<div class="input-group" >
		  <span class="input-group-addon">题型</span>
<!-- 		  <input type="text" class="form-control" placeholder="type"> -->
		     <select  class="form-control" id="type" >   
                        <option value="1">1</option>  
                        <option value="2">2</option>  
              </select> 
		</div>
	
		<div class="input-group" style="margin-top:10px">
		  <span class="input-group-addon">所属类别</span>
<!-- 		  <input type="text" class="form-control" placeholder="category"> -->
		   <select  class="form-control" id="category"  >   
                        <option value="1">1</option>  
                        <option value="2">2</option>  
              </select> 
		</div>
		
		<div class="input-group" style="margin-top:10px">
		 <span class="input-group-addon">第几天</span>
		  <input type="text" class="form-control" placeholder="day">
		</div>
		<div class="input-group" style="margin-top:10px">
		 <span class="input-group-addon">词语</span>
		<div style="margin-bottom:10px ">
		  <table >
		  <tr>
			  <td style="width:30px; hight:60px">
			  	<input type="text" style="width:30px">
			  </td>
		  </tr>
		  </table>
		  </div>
		  <div>
		  <table >
		  <tr>
			  <td style="width:30px; hight:60px">
			  	<input type="text" style="width:30px">
			  </td>
		  </tr>
		  </table>
		  </div>
		</div>
		<div class="input-group" style="margin-top:10px">
		 <span class="input-group-addon">数量</span>
		  <input type="text" class="form-control" placeholder="time">
		</div>
		<div class="input-group" style="margin-top:10px">
		 <span class="input-group-addon">答题时间</span>
		  <input type="text" class="form-control" placeholder="time">
		</div>
		<div class="input-group" style="margin-top:10px">
		 <span class="input-group-addon">分值</span>
		  <input type="text" class="form-control" placeholder="score">
		</div>
		<div style="margin-top:10px" align="center">
		<button type="button" class="btn  btn-primary">提交</button>
		</div>
	</form>
</div>
</div>
</body>
</html>

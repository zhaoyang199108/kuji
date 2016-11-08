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
 <jsp:include page="common/nav.jsp"/> 

	<div class="col-md-3">
	<div class="panel-group" id="accordion">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#collapseOne">
					28天训练
				</a>
			</h4>
		</div>
		<div id="collapseOne" class="panel-collapse collapse in">
			<div class="panel-body">
				<div class="btn-group-vertical" style="width:200px;">
					<button href="#col-md-9" type="button" class="btn btn-default" style=" outline: none;	">5X5格</button>
					<button type="button" class="btn btn-default">词语排列</button>
					<button type="button" class="btn btn-default">图片讲解</button>
					<button type="button" class="btn btn-default">图片顺序</button>
					<button type="button" class="btn btn-default">曼陀罗系列</button>
					
				</div>
			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#collapseTwo">
					120天训练
				</a>
			</h4>
		</div>
		<div id="collapseTwo" class="panel-collapse collapse">
			<div class="panel-body">
				Nihil anim keffiyeh helvetica, craft beer labore wes anderson 
				cred nesciunt sapiente ea proident. Ad vegan excepteur butcher 
				vice lomo.
			</div>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="panel-title">
				<a data-toggle="collapse" data-parent="#accordion" 
				   href="#collapseThree">
					综合练习
				</a>
			</h4>
		</div>
		<div id="collapseThree" class="panel-collapse collapse">
			<div class="panel-body">
				Nihil anim keffiyeh helvetica, craft beer labore wes anderson 
				cred nesciunt sapiente ea proident. Ad vegan excepteur butcher 
				vice lomo.
			</div>
		</div>
	</div>
	</div>	
  </div>
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
		 <span class="input-group-addon">图&nbsp;&nbsp;&nbsp;片</span>
		 	  <img src="img/logon.gif" style="width:200px; hight:100px"  id="images_nm" name="images_nm" >
		</div>
		<div class="input-group" style="margin-top:10px">
		 <span class="input-group-addon">介&nbsp;&nbsp;&nbsp;绍</span>
		  <div >
               <textarea id="stem" name="stem" class="form-control" rows="4">sss</textarea>
           </div>
		</div>
		<div class="input-group" style="margin-top:10px">
		 <span class="input-group-addon">题&nbsp;&nbsp;&nbsp;目</span>
		   <input type="text" class="form-control" placeholder="title">
		</div>
		<div class="input-group" style="margin-top:10px">
		 <span class="input-group-addon">答案A</span>
		  <input type="text"  style="width:620px; hight:160px" placeholder="答案A">&nbsp;&nbsp;&nbsp;
		 <span > 是否正确  </span> &nbsp;
		     <select  style="width:40px; hight:40px" id="type"  >   
                        <option value="是">是</option>  
                        <option value="否">否</option>  
              </select> 
		</div>
		<div class="input-group" style="margin-top:10px">
		 <span class="input-group-addon">答案B</span>
		  <input type="text"  style="width:620px; hight:160px" placeholder="答案B">&nbsp;&nbsp;&nbsp;
		 <span > 是否正确  </span> &nbsp;
		     <select  style="width:40px; hight:40px" id="type"  >   
                        <option value="是">是</option>  
                        <option value="否">否</option>  
              </select> 
		</div>
		<div class="input-group" style="margin-top:10px;padding-bottom:20px;border-bottom:1px solid  black">
		 <span class="input-group-addon">答案C</span>
		  <input type="text"  style="width:620px; hight:160px" placeholder="答案C">&nbsp;&nbsp;&nbsp;
		 <span > 是否正确  </span> &nbsp;
		     <select  style="width:40px; hight:40px" id="type"  >   
                        <option value="是">是</option>  
                        <option value="否">否</option>  
              </select> 
		</div>
		<div class="input-group" style="margin-top:10px;">
		 <button type="button" class="btn  btn-primary"> 添加题目</button>
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

</body>
</html>

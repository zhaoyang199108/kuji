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
   <script>
	    function submitForm(){
// 	 		var a = $('#a').val();
	 		var type = $('#type').val();
	 		var whichDay = $('#whichDay').val();
	 		var category = $('#category').val();
	 		var errorNumber = $('#errorNumber').val();
	 		var words = $('#content').val();
	 		var number = $('#number').val();
	 		var score = $('#score').val();
	 		$.ajax({
	 			url: 'http://192.168.0.103:8080/kujisoftware/memoryTrain/saveOrUpdate',
	 			data:{'score':score,'type':type,'whichDay':whichDay,'category':category,'errorNumber':errorNumber,'words':words,'number':number},
	 			type:'GET',
	 			success : function(data){
	 				console.log("ss");
	 			}
	 		});
	 	}	
		function saveToTextarea(){
			var word = $('#word').val();
		    var content = 	$('#content').val();
		    console.log(content);
			if(content==null||content==""){
				$('#content').append(word);
			}else{
				$('#content').val(content+";"+word);
			}
				$('#myModal').modal('hide');
				$('#word').val("");
			}
	function showDialog(){
		$('#myModal').modal('show');
	}
	</script>
<body>
	<div id="container" class="container" style="margin-top: 10px;">
		<%-- <%@ include file="common/nav.jsp"%> --%>
		<jsp:include page="common/nav.jsp" />

		<div class="col-md-9">
			<form role="form">
				<div class="input-group">
					<span class="input-group-addon">题型</span>
							  <input type="text" class="form-control" placeholder="type" value="记忆训练" id="type">
				</div>

				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">所属类别</span>
					<!-- 		  <input type="text" class="form-control" placeholder="category"> -->
				<select class="form-control" id="category">
						<option value="21天训练">21天训练</option>
						<option value="90天养成好习惯">90天养成好习惯</option>
					</select>
				</div>

				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">第几天</span> <input type="text"
						class="form-control" placeholder="whichDay" id="whichDay">
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon" id="words">词语</span>
					
					<textarea 	 rows="3" style="width:200px;" id="content" name="content"></textarea> <span>(格式为1;2;3;4...分号为英文)</span>
							<!-- 按钮触发模态框 -->
					

				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">数量</span> <input type="text"
						class="form-control" placeholder="number" id="number">
				</div>
<!-- 				<div class="input-group" style="margin-top: 10px"> -->
<!-- 					<span class="input-group-addon">答题时间</span> <input type="text" -->
<!-- 						class="form-control" placeholder="anwserTime" id="anwserTime"> -->
<!-- 				</div> -->
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">错误次数</span> <input type="text"
						class="form-control" placeholder="errorNumber" id="errorNumber">
				</div>
				<div class="input-group" style="margin-top: 10px">
					<span class="input-group-addon">分值</span> <input type="text"
						class="form-control" placeholder="score" id="score">
				</div>
				<div style="margin-top: 10px" align="center" align="center">
					<button type="button" class="btn  btn-primary" onclick="submitForm()">提交</button>
				</div>
			</form>
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
	
</body>
</html>

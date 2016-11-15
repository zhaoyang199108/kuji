<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
       
		function loginOnclick(){
			window.location.href = 'http://localhost:8080/kujisoftware';
		}

		function fiveOnclick(){
			window.location.href = 'http://localhost:8080/kujisoftware/questionFive/five';
		}
		function memoryTrainOnclick(){
			window.location.href = 'http://localhost:8080/kujisoftware/memoryTrain/memoryTrain';
		}
		function learnExplainOnclick(){
			window.location.href = 'http://localhost:8080/kujisoftware/learnExplain/learnExplain';
		}
		function pictureMemoryOnclick(){
			window.location.href = 'http://localhost:8080/kujisoftware/pictureMemory/pictureMemory';
		}
		function speedOnclick(){
			window.location.href = 'http://localhost:8080/kujisoftware/speed/speed';
		}
		function mandaraOnclick(){
// 			window.location.href = 'http://localhost:8080/kujisoftware/mandara/mandara';
		}
		function musicUploadOnclick(){
			window.location.href = 'http://localhost:8080/kujisoftware/musicUpload/musicUpload';
		}
		function modiPassOnclick(){
			window.location.href = 'http://localhost:8080/kujisoftware/modiPass/modiPass';
		}
	</script>
<body>

		<nav class="navbar navbar-default" role="navigation">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">全脑教育酷●记软件</a>
		    </div>
		    <ul class="nav navbar-nav navbar-right">
                    <li ><a href="#" onclick="modiPassOnclick()">修改密码</a></li> 
                    <li><a href="#" onclick="loginOnclick()">退出</a></li> 
               </ul>
		  </div>
		</nav>

	<div class="col-md-3">
		<div class="panel-group" id="accordion">
		
		<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseOne"> 21天训练 </a>
					</h4>
				</div>
				<div id="collapseOne" class="panel-collapse collapse in">
					<div class="panel-body">
						<div class="btn-group-vertical" style="width: 200px;">
							<button type="button" class="btn btn-default"
								style="margin-top: 10px;" onclick="fiveOnclick()">舒尔特表训练</button>
							<button type="button" class="btn btn-default"
								style="margin-top: 10px;" onclick="memoryTrainOnclick()">记忆训练</button>
							<button type="button" class="btn btn-default"
								style="margin-top: 10px;" onclick="learnExplainOnclick()">学习讲解训练</button>
							<button type="button" class="btn btn-default"
								style="margin-top: 10px;" onclick="pictureMemoryOnclick()">图片记忆训练</button>
							<button type="button" class="btn btn-default"
									style="margin-top: 10px;" onclick="mandaraOnclick()">曼陀罗训练</button>
						</div>
					</div>
				</div>
			</div>
			
				<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseTwo"> 90天养成好习惯 </a>
					</h4>
				</div>
				<div id="collapseTwo" class="panel-collapse collapse in">
					<div class="panel-body">
						<div class="btn-group-vertical" style="width: 200px;">
							<button type="button" class="btn btn-default"
								style="margin-top: 10px;" onclick="fiveOnclick()">舒尔特表训练</button>
							<button type="button" class="btn btn-default"
								style="margin-top: 10px;" onclick="memoryTrainOnclick()">记忆训练</button>
							<button type="button" class="btn btn-default"
								style="margin-top: 10px;" onclick="learnExplainOnclick()">学习讲解训练</button>
							<button type="button" class="btn btn-default"
								style="margin-top: 10px;" onclick="pictureMemoryOnclick()">图片记忆训练</button>
							<button type="button" class="btn btn-default"
								style="margin-top: 10px;" onclick="speedOnclick()">速度训练</button>
							<button type="button" class="btn btn-default"
								style="margin-top: 10px;" onclick="mandaraOnclick()">曼陀罗训练</button>
							<button type="button" class="btn btn-default"
								style="margin-top: 10px;" onclick="eyeSpanOnclick()">视幅训练</button>
						</div>
					</div>
				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseThree"> 综合训练 </a>
					</h4>
				</div>
				<!-- <div id="collapseThree" class="panel-collapse collapse">
					<div class="panel-body">Nihil anim keffiyeh helvetica, craft
						beer labore wes anderson cred nesciunt sapiente ea proident. Ad
						vegan excepteur butcher vice lomo.</div>
				</div> -->
			</div>
		</div>

            <div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordion"
							href="#collapseFour"> 设置 </a>
					</h4>
				</div>
				<div id="collapseFour" class="panel-collapse collapse in">
					<div class="panel-body">
						<div class="btn-group-vertical" style="width: 200px;">
							<button type="button" class="btn btn-default"
								style="margin-top: 10px;" onclick="musicUploadOnclick()">音乐上传</button>
						</div>
					</div>
				</div>
			</div>
			
	</div>
</body>
</html>
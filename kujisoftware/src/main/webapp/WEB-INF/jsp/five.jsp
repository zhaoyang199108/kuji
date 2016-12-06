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
<title>舒尔特表训练</title>
</head>
<script>
/* function closeDiv(){
	//设置div关闭
	document.getElementById("divId").style.display="none";
}
function getRowValue(element){
   
	//设置div显示
	 document.getElementById("divId").style.display="";
	//this做为参数传过来是方法中的element,parentNode就是获取父节点，获取了连个父节点，就相当于获取了tr
	var node = element.parentNode.parentNode;
	//给每一个input框赋值，node.children[0].innerHTML,node就是tr，tr的子类有多个【0】根据下标取值
	 document.getElementById("a").value=node.children[0].innerHTML;
	 document.getElementById("b").value=node.children[1].innerHTML;
	 document.getElementById("c").value=node.children[2].innerHTML
	 document.getElementById("d").value=node.children[3].innerHTML;
	
	
}
 */
//  var objInput = document.getElementById("tableList").getElementsByTagName("input");
//  for (i = 0; i < objInput.length; i++) 
// 	    alert(objInput[i].value);
 
//     window.onload=function(){
// 	   var input=document.getElementById("tableList").getElementByTagName("input");
// 	    for(var i=0;i<input.length;i++)
// 	    {  
// 	     if(input[i].type=='text')
// 	     {alert(input[i].value);}//一个一个警告过去显示input类型的值!
// 	     }
// 	   }
 
	function submitForm(){
		  var id = $('#id').val();
	 		var a = $('#a').val();
	 		var b = $('#b').val();
	 		var c = $('#c').val();
	 		var d = $('#d').val();
	 		var e = $('#e').val();
	 		var f = $('#f').val();
	 		var g = $('#g').val();
	 		var h = $('#h').val();
	 		var i = $('#i').val();
	 		var j = $('#j').val();
	 		var k = $('#k').val();
	 		var l = $('#l').val();
	 		var m = $('#m').val();
	 		var n = $('#n').val();
	 		var o = $('#o').val();
	 		var p = $('#p').val();
	 		var q = $('#q').val();
	 		var r = $('#r').val();
	 		var s = $('#s').val();
	 		var t = $('#t').val();
	 		var u = $('#u').val();
	 		var v = $('#v').val();
	 		var w = $('#w').val();
	 		var x = $('#x').val();
	 		var y = $('#y').val();
	 		var score = $('#score').val();
	 		var type = $('#type').val();
	 		var whichDay = $('#whichDay').val();
	 		var exerciseId = $('#exerciseId').val();
	 		var errorNumber = $('#errorNumber').val();
	 		$.ajax({
	 			url: path+'/kujisoftware/questionFive/saveOrUpdate',
	 			data:{
	 				'id':id,
	 				'a':a,
	 				'b':b,
	 				'c':c,
	 				'd':d,
	 				'e':e,
	 				'f':f,
	 				'g':g,
	 				'h':h,
	 				'i':i,
	 				'j':j,
	 				'k':k,
	 				'l':l,
	 				'm':m,
	 				'n':n,
	 				'o':o,
	 				'p':p,
	 				'q':q,
	 				'r':r,
	 				's':s,
	 				't':t,
	 				'u':u,
	 				'v':v,
	 				'w':w,
	 				'x':x,
	 				'y':y,
	 				'type':type,
	 				'whichDay':whichDay,
	 				'exerciseId':exerciseId,
	 				'errorNumber':errorNumber,
	 				'score':score},
	 			type:'GET',
	 			success : function(data){
	 				if(data.code == 1){
	 					alert(data.message);
	 				}
	 				if(data.code == 0){
	 					
	 					alert(data.message);
	 					alert(data);
	 					window.location.href=path+'/kujisoftware/questionFive/five';
	 				}
	 			}
	 		});
	 	}	
	
	function updataFive(id){
		$.ajax({
			url:path+'/kujisoftware/questionFive/findFiveById',
			type:'GET',
			data:{'id':id},
			success : function(data){
				console.log(data);
				if(data.code == 0){
					  $('#myTab a:first').tab('show'); 
					  $("#type  option[value='"+data.data.type+"'] ").attr("selected",true)
					  $('#exerciseId').val(data.data.exerciseId);
					  $('#whichDay').val(data.data.fiveWhichDay);
					  $('#id').val(data.data.fiveId);
					  var tableList=[];
						tableList = data.data.fiveContent.split(";");
						for(var i=0;i<tableList.length;i++){
							 var list =tableList[i];
						     $('#a').val(tableList[0]);
						     $('#b').val(tableList[1]);
							 $('#c').val(tableList[2]);
							 $('#d').val(tableList[3]);
							 $('#e').val(tableList[4]);
							 $('#f').val(tableList[5]);
							 $('#g').val(tableList[6]);
							 $('#h').val(tableList[7]);
							 $('#i').val(tableList[8]);
							 $('#j').val(tableList[9]);
							 $('#k').val(tableList[10]);
							 $('#l').val(tableList[11]);
							 $('#m').val(tableList[12]);
							 $('#n').val(tableList[13]);
							 $('#o').val(tableList[14]);
							 $('#p').val(tableList[15]);
							 $('#q').val(tableList[16]);
							 $('#r').val(tableList[17]);
							 $('#s').val(tableList[18]);
							 $('#t').val(tableList[19]);
							 $('#u').val(tableList[20]);
							 $('#v').val(tableList[21]);
							 $('#w').val(tableList[22]);
							 $('#x').val(tableList[23]);
							 $('#y').val(tableList[24]);
						}
					 $('#errorNumber').val(data.data.errorNumber);
					 $('#score').val(data.data.fiveScore);
				}
			}
		}); 

	}
	
	function deleteFive(id){
		console.log(id);
		$.ajax({
			url:path+'/kujisoftware/questionFive/deleteFive',
			type:'GET',
			data:{'id':id},
			success : function(data){
				alert(data.message);
				if(data.code == 0){
					window.location.href=path+'/kujisoftware/questionFive/five';
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
			<div  id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="add">
					<form id="fiveForm" method="get" enctype="multipart/form-data">
						<div class="input-group">
							<span class="input-group-addon">题型</span> 
							<select class="form-control" id="type" disabled>
						          <option value="1">舒尔特表训练</option>
			                </select>
						</div>
		
						<div class="input-group" style="margin-top: 10px">
							<span class="input-group-addon">所属类别</span> 
							<select class="form-control" id="exerciseId">
								<option value="1000">21天训练</option>
								<option value="1001">90天养成好习惯</option>
							</select>
						</div>
		
						<div class="input-group" style="margin-top: 10px">
							<span class="input-group-addon">第几天</span> 
							<select class="form-control" id="whichDay">
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
						<div class="input-group" style="margin-top: 10px" id="divId">
							<span class="input-group-addon">内容</span>
							<table class=""  id="tableList">
								<tr>
									<td style="width: 155px;"><input type="text"
										style="width: 155px;" id="a"></td>
									<td style="width: 155px;"><input type="text"
										style="width: 155px;" id="b"></td>
									<td style="width: 155px;"><input type="text"
										style="width: 155px;" id="c"></td>
									<td style="width: 155px;"><input type="text"
										style="width: 155px;" id="d"></td>
									<td style="width: 155px;"><input type="text"
										style="width: 155px;" id="e"></td>
								</tr>
								<tr>
									<td><input type="text" style="width: 155px;" id="f">
									</td>
									<td><input type="text" style="width: 155px;" id="g">
									</td>
									<td><input type="text" style="width: 155px;" id="h">
									</td>
									<td><input type="text" style="width: 155px;" id="i">
									</td>
									<td><input type="text" style="width: 155px;" id="j">
									</td>
								</tr>
								<tr>
									<td><input type="text" style="width: 155px;" id="k">
									</td>
									<td><input type="text" style="width: 155px;" id="l">
									</td>
									<td><input type="text" style="width: 155px;" id="m">
									</td>
									<td><input type="text" style="width: 155px;" id="n">
									</td>
									<td><input type="text" style="width: 155px;" id="o">
									</td>
								</tr>
								<tr>
									<td><input type="text" style="width: 155px;" id="p">
									</td>
									<td><input type="text" style="width: 155px;" id="q">
									</td>
									<td><input type="text" style="width: 155px;" id="r">
									</td>
									<td><input type="text" style="width: 155px;" id="s">
									</td>
									<td><input type="text" style="width: 155px;" id="t">
									</td>
								</tr>
								<tr>
									<td><input type="text" style="width: 155px;" id="u">
									</td>
									<td><input type="text" style="width: 155px;" id="v">
									</td>
									<td><input type="text" style="width: 155px;" id="w">
									</td>
									<td><input type="text" style="width: 155px;" id="x">
									</td>
									<td><input type="text" style="width: 155px;" id="y">
									</td>
								</tr>
							</table>
						</div>
						<div class="input-group" style="margin-top: 10px">
							<span class="input-group-addon">错误次数</span> <input type="text"
								class="form-control" placeholder="errorNumber" id="errorNumber">
						</div>
						<div class="input-group" style="margin-top: 10px">
							<span class="input-group-addon">分值</span> <input type="text"
								class="form-control" placeholder="score" id="score">
								<input type="hidden" name="id" id="id"> 
						</div>
						<div style="margin-top: 10px" align="center">
							<button type="button" class="btn  btn-primary" onclick="submitForm()" >提交</button>
						</div>
					</form>
				</div>
				<div class="tab-pane fade" id="find">
					<table class="table table-hover">
					<thead>
						<tr>
<!-- 							<th>id</th> -->
							<th>题型</th>
							<th>所属类别</th>
							<th>第几天</th>
							<th>内容</th>
							<th>错误次数</th>
							<th>分值</th>
							<th>创建时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var = "sk" items="${five }">
							<tr>
<%-- 								<td>${sk.fiveId }</td> --%>
								<td>${sk.fiveType }</td>
								<td>${sk.exerciseId }</td>
								<td>${sk.fiveWhichDay }</td>
								<td >${sk.fiveContent }</td>
								<td>${sk.errorNumber }</td>
								<td>${sk.fiveScore }</td>
								<td>
									<fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>
									<a class="btn btn-info" target="_blank"   onclick="updataFive(${sk.fiveId })" >修改</a>
									<a class="btn btn-info"  onclick="deleteFive(${sk.fiveId })" target="_blank" >删除</a>
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
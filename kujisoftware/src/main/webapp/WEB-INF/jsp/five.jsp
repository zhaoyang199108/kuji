<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<html>
   <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script >
	function submitForm(){
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
	 		var type = $('#type').val();
	 		var whichDay = $('#whichDay').val();
	 		var category = $('#category').val();
	 		$.ajax({
	 			url: 'http://localhost:8080/kujisoftware/questionFive/saveOrUpdate',
	 			data:{'a':a,'type':type,'whichDay':whichDay,'category':category},
	 			type:'GET',
	 			success : function(data){
	 				console.log("ss");
	 			}
	 		});
	 	}	
	</script>
<body>
	<div id="container" class="container" style="margin-top:10px;">
		<%-- <%@ include file="common/nav.jsp"%> --%>
		<jsp:include page="common/nav.jsp" />
		<div class="col-md-9">
	<form  id="fiveForm" method="get" enctype="multipart/form-data">
		<div class="input-group" >
		  <span class="input-group-addon">题型</span>
		  <input id="type" type="text" class="form-control" placeholder="type" value="舒尔特表训练" disabled>
		</div>
		
		<div class="input-group" style="margin-top:10px">
		  <span class="input-group-addon">所属类别</span>
		  <input id="category" type="text" class="form-control" placeholder="category" value="21天训练" disabled>
		</div>
		
		<div class="input-group" style="margin-top:10px">
		<span class="input-group-addon">第几天</span>
		  <input type="text" id="whichDay" class="form-control" placeholder="day">
		</div>
		<div class="input-group" style="margin-top:10px">
		 <span class="input-group-addon">内容</span>
		  <table class="">
		  <tr>
			  <td style="width:155px;">
			  	<input type="text" style="width:155px;" id="a">
			  </td>
			   <td style="width:155px;" >
			  	<input type="text" style="width:155px;" id="b">
			  </td>
			   <td style="width:155px;">
			  	<input type="text" style="width:155px;" id="c">
			  </td>
			   <td style="width:155px;">
			  	<input type="text" style="width:155px;" id="d">
			  </td>
			   <td style="width:155px;">
			  	<input type="text" style="width:155px;" id="e">
			  </td>
		  </tr>
		  <tr>
			  <td>
			  	<input type="text" style="width:155px;" id="f">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="g">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="h">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="i">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="j">
			  </td>
		  </tr>
		  <tr>
			  <td>
			  	<input type="text" style="width:155px;" id="k">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="l">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="m">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="n">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="o">
			  </td>
		  </tr>
		  <tr>
			  <td>
			  	<input type="text" style="width:155px;" id="p">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="q">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="r">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="s">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="t">
			  </td>
		  </tr>
		    <tr>
			  <td>
			  	<input type="text" style="width:155px;" id="u">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="v">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="w">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="x">
			  </td>
			   <td>
			  	<input type="text" style="width:155px;" id="y">
			  </td>
		  </tr>
		  </table>
		</div>
		<div class="input-group" style="margin-top:10px">
		 <span class="input-group-addon">错误次数</span>
		  <input type="text" class="form-control" placeholder="errorNumber">
		</div>
		<div class="input-group" style="margin-top:10px">
		 <span class="input-group-addon">分值</span>
		  <input type="text" class="form-control" placeholder="score">
		</div>
		<div style="margin-top:10px;">
		<button type="button" class="btn  btn-primary" onclick="submitForm()" >提交</button>
		</div>
	</form>
		</div>
</div>
	

</body>
</html>

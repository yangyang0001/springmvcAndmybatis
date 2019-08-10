<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSON交互测试</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.9.1.min.js"></script>	
		<script type="text/javascript" src="${pageContext.request.contextPath}/json2.js"></script>	
		<script type="text/javascript">
			//请求JSON,输出JSON
			function requestJSON(){
				
				$.ajax({
					type : 'post',
					data :'{"name":"手机","price":999}',	//向后台传递数据
					contentType : 'application/json;charset=utf-8',
					url  : '${pageContext.request.contextPath}/requestJSON.action',
					cache: false,	//禁用缓存
					async: false, 	//是否等待加载，起到同步的作用
					dataType : 'json',					//服务器返回的数据类型
					success : function(data){
						alert(typeof data + "----------" + data);
						console.info(data);
					}
				});
				
			}
			//请求key=value,输出JSON
			function responseJSON(){
				$.ajax({
					type : 'post',
					data :{"name":"手机","price":999},	//向后台传递数据
					//虽然为json对象,这里这种$.ajax会转化为key=value的形式！也可以写成data : 'name=手机&price=999'
					//这里不需要contentType:默认就是key=value的形式！
					url  : '${pageContext.request.contextPath}/responseJSON.action',
					cache: false,	//禁用缓存
					async: false, 	//是否等待加载，起到同步的作用
					dataType : 'json',					//服务器返回的数据类型
					success : function(data){
						alert(typeof data + "----------" + data);
						console.info(data);
					}
				});
			}
			
			//测试ObjectToJson
			function ObjectToStrJson(){
				var obj = {
						name : "张三",
						age : 10
				};
				var json = JSON.stringify(obj);
				alert(typeof json + "---------------" + json);
				console.info(json);
			}
			//测试JsonToObject
			function StrJsonToObject(){
				var strjson = '{"name":"Mike","age":"29"}';
				var obj = eval("(" + strjson + ")");
				var obj1 = JSON.parse(strjson);
				alert("obj ----- :" +typeof obj + "----------------" + obj);
				console.info(obj);
				alert("obj1 ----- :" +typeof obj1 + "----------------" + obj1);
				console.info(obj1);
			}
		</script>
	</head>
	
	<body>
		<input type="button" onclick="requestJSON()" value="请求JSON,输出JSON"/>
		<input type="button" onclick="responseJSON()" value="请求key=value,输出JSON"/>
		<br/><br/>
		<input type="button" onclick="ObjectToStrJson()" value="测试ObjectToStrJson"/>
		<input type="button" onclick="StrJsonToObject()" value="测试StrJsonToObject"/>
		
	</body>
	
</html>
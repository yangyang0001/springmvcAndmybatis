<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/uploadify/uploadify.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/uploadify/jquery.uploadify.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/uploadify/jquery.uploadify.min.js"></script>
<!-- uploadify.swf要和uploadify.css放到一起否则报错! -->


<script type="text/javascript">

	/* $('#rightFrame').load(function(){
		var account = $("#account").val();			//
		var id= $("#userId").val();					//
		var currentNode=0;							//
		$("#uploadify").uploadify({					//注:这里uploadify为html标签，文件输入框id
			swf: '/uploadify/uploadify.swf',		//
			uploader: '${pageContext.request.contextPath}/upload/uploadFile.action',	//
			cancelImg: '/uploadify/uploadify-cancel.png',	//
			buttonText:'选择文件',						//按钮文字
			fileObjName :'uploadify',				//
			auto: true,								//是否自动!
			multi:true,								//是否支持多文件上传，默认为true
			Debug:true,								//
			queueID:'fileQueue',					//这里fileQueue 为上传进度条显示在哪个div里
			formData:{'account':account,'id':id,'currentNode':$("#rightFrame").contents().find("#test").val()},
			removeCompleted:true,					//
			queueSizeLimit:999,						//
			fileSizeLimit:'100MB',					//上传文件的大小限制,默认单位为KB
			height:28,								//
			width:90,								//
			successTimeout:28,						//
			requeueErrors:true,						//
			uploadLimit:5,							//
			onUploadSuccess : function (file, data, response) {
				if(response){
					currentNode=data;
				}
		    },
		    onQueueComplete : function(stats){
			 	window.parent.rightFrame.location.href="fileaction?filenode="+currentNode;
				alert("上传完毕");
			}
        });
    }); */

	$(function(){
		$("#uploadify").uploadify({					//注:这里uploadify为html标签，文件输入框id
			swf: '/uploadify/uploadify.swf',		//
			uploader: '${pageContext.request.contextPath}/upload/uploadFile.action',	//
			cancelImg: '/uploadify/uploadify-cancel.png',	//
			buttonText:'选择文件',						//按钮文字
			fileObjName :'uploadify',				//
			auto: true,								//是否自动!
			multi:true,								//是否支持多文件上传，默认为true
			Debug:true,								//
			queueID:'fileQueue',					//这里fileQueue 为上传进度条显示在哪个div里
			formData:{},							//
			removeCompleted:true,					//
			queueSizeLimit:999,						//
			fileSizeLimit:'100MB',					//上传文件的大小限制,默认单位为KB
			height:28,								//
			width:90,								//
			successTimeout:28,						//
			requeueErrors:true,						//
			uploadLimit:5,							//
			onUploadSuccess : function (file, data, response) {
				if(response){
					currentNode=data;
				}
		    },
		    onQueueComplete : function(stats){
			 	window.parent.rightFrame.location.href="fileaction?filenode="+currentNode;
				alert("上传完毕");
			}
        });
	});
	
</script>

</head>
<body>
	<div id="fileQueue"></div>
	<input type="file" name="uploadify" id="uploadify" />
</body>
</html>
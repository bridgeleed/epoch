<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body style="font-size: 20px">
<!-- 1.method必须是post
     2.enctype="multipart/form-data"
     3.<input type="file">
     . -->
<form action="${pageContext.request.contextPath}/upload/uploadFile.do" method="post" enctype="multipart/form-data" >

请选择文件：<input type="file" name="file" id="file">
<br>
<input type="submit" value="上传"> 


</form>

</body>
</html>
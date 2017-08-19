<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/18
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>文件上传</title>
</head>
<body>
<h1>采用流的方式上传文件</h1>
    <form name="serForm" action="/upload.do" enctype="multipart/form-data"
          method="post">
        上传文件2: <input type="file" name="file"><br/>
        <input type="submit" name="上传">
    </form>
    <h1>采用multipart提供的file.transfer方法上传文件</h1>
    <form name="Form1" action="/upload2.do"n enctype="multipart/form-data" method="post">
        <input type="file" name="file">
        <input type="submit" name="提交">
    </form>

    <h1>使用spring mvc提供的类方法上传文件</h1>
    <form name="Form2" action="/upload3.do"enctype="multipart/form-data" method="post">
    <input type="file" name="file">
    <input type="submit" name="提交">
    </form>
<h2></h2>

    <h1>spring 下载</h1>
    <a href="/download.do">springUploadwhile循环复制 视频下载</a>

</body>
</html>

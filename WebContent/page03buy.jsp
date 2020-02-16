<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当当网-名社新书大PK</title>
<link href="css/page_06.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
<div id="wrapper">
  <!-- header 部分 -->
  <div id="header">
      <!-- 登录信息 -->
  	<div id="information">
    	<span>您好，</span><a href="forgetpassword.jsp" >${sessionScope.username}</a> <a href="Invalidate" class="exit">[退出登录]</a>
    </div><!-- 登录信息 END -->
        <!-- 搜索 -->
        <div class="search">
        <input class="searchInput" type="text" /><input type="button" class="searchBtn" />
        </div><!-- 搜索 END -->
   
  </div><!-- header 部分 END -->
  
  
  <!-- content 部分 -->
  <div id="content">
    <p>购买成功，页面跳转中......</p>
  </div>
  
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当当网-名社新书大PK</title>
<link href="css/page_04.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
<div id="wrapper">
  <!-- header 部分 -->
  <div id="header">
    <!-- 登录信息 -->
  	<div id="information">
			<!-- 搜索 -->
        <div class="search">
        <input class="searchInput" type="text" /><input type="button" class="searchBtn" />
        </div><!-- 搜索 END -->
    </div><!-- 登录信息 END -->
  </div><!-- header 部分 -->
  
  <!-- content 部分 -->
  <div id="content">
    <!-- 注册信息 -->
  	<form action="Register" method="post">
    <p><span>用户名：</span><input type="text" class="textInput" name="user"/></p>
    <p><span>登录密码：</span><input type="text"  class="textInput" name="password"/></p>
    <p><span>确认密码：</span><input type="text"  class="textInput" name="password2"/></p>
    <p><span>&nbsp;&nbsp;&nbsp;&nbsp;验证码：</span><input type="text" class="textInput" name="verify1"/></p>
    <p><img src="images/Page_04_yzm.png" alt="" /><span class="grey">看不清？</span><a href="forgetpassword.jsp">换不了</a></p>
    <p><input type="submit" value="" class="btn" /></p>
    <p><input name="verify2" type="checkbox" value="a" /> 我已阅读并同意《当当网交易条款》和《当当网社区条款》</p>
    </form>
  </div>
  
</div>
</body>
</html>
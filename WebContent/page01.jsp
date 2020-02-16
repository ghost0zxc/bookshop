<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当当网-名社新书大PK</title>
<link href="css/page_01.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/ie6.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/ie7.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
<div id="wrapper">
  <!-- header 部分 -->
  <div id="header">
  	<!-- 登录信息 -->
  	<div id="information">
    	<span>您好，</span><a href="forgetpassword.jsp" >${sessionScope.username}</a> <a href="Invalidate" class="exit">[退出登录]</a>
        <!-- 搜索 -->
        <div class="search">
        <form action="Find" method="post">
        <input class="searchInput" type="text" value="" name="find"/><input type="submit" value="" class="searchBtn" />
        </form>
        </div><!-- 搜索 END -->
    </div><!-- 登录信息 END-->
  </div><!-- header END -->
  
  <div id="banner"></div>
  
  <!-- content 部分 -->
  <div id="content">
  	<!-- 图书商品分类 -->

  	<div class="content-left">
    	<ul>
  	<c:forEach var="aa" items="${typelist}">
        	<li><a href="NewTypeMySQL?id=${aa.id}">${aa.typename}</a><span>（${aa.typenum}）</span></li>
     </c:forEach>
        </ul>
    </div><!-- 图书商品分类 END -->
    
    <div class="content-right">
        <!-- 排序条件（评分、价格等） -->
    	<div class="row01">
          <p class="px">
            <a href="###"><img src="images/xl.jpg"  /></a>&nbsp;
            <a href="###"><img src="images/pf.jpg"  /></a>&nbsp;
            <a href="###"><img src="images/jg.jpg"  /></a>&nbsp;
            <a href="###"><img src="images/zk.jpg"  /></a>&nbsp;
            <a href="###"><img src="images/cbsj.jpg"  /></a>
         </p>
        </div><!-- 排序条件（评分、价格等） END -->
        
        <!-- 循环内容 part 1 -->
        <div class="row02">
        <c:forEach var="bb" items="${booklist}">
        	<a href="###"><img src="${bb.image}" height=160 width=120 hspace=50/></a>
        	<h2><a href="###">${bb.bookname}</a></h2>
            <p>
            		&nbsp;&nbsp;<a href="###">${bb.author}</a>
          			&nbsp; &nbsp;<a href="page_02.html">${bb.press}</a>
            </p>
            <p>
           ${bb.briefintroduction}
            </p>
            <form action="" method="get">
            <p class="p02">
            <span class="red">￥${bb.price}</span> &nbsp;&nbsp;<span class="line-through">￥999.00</span> &nbsp;&nbsp;超级划算
            <a href="Cart?id=${bb.id}"><input type="button"class="buy" /></a>
            </p>
            </form>
        </c:forEach>
        </div>
        
 
        
        
        <!-- 分页 -->
        <div class="row04">
        <a href="#">上一页</a> <a href="#"> 1 </a> <a href="#"> 2</a> <a href="#"> 3 </a> <a href="#">下一页</a>
        &nbsp;&nbsp;共<span>5</span>页 到第<input type="text" class="inputPage" />页
        </div><!-- 分页 END -->
    </div><!-- content-right部分 END -->
  </div><!-- content部分 END -->
 
  
  <!-- footer 部分 -->
  <div id="footer"></div>
</div>
</body>
</html>

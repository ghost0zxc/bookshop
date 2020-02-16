<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>当当网-购物车</title>
<link href="css/page_03.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>

<div id="wrapper">
  =<!-- header 部分 -->
  <div id="header">
    <!-- 登录信息 -->
  	<div id="information">
    	<span>您好，</span><a href="forgetpassword.jsp" >${sessionScope.username}</a> <a href="Invalidate" class="exit">[退出登录]</a>
    </div><!-- 登录信息 END -->
  </div><!-- header 部分 -->
  
  <div id="content_01"></div>
 
  <!-- content_02 部分 -->

   
     
      <form name="formname"  method="post" action="">      
    <table align="center" border=1>
   
      <tr>
        <td align="center"  width="248">商品名称</td>
        <td align="center"  width="183">数量</td>
        <td align="center"  width="199">当当价</td>
        <td align="center"  width="190">增加数量</td>
        <td align="center"  width="134">操作</td>
      </tr>
      <%!int i =0;int id =0; %>
      <%i=0 ;%>>
   <c:forEach var="cc" items="${clist}">  
    <c:forEach var="bb" items="${blist}">  
      <c:if test="${(cc.bookid==bb.id)&&(cc.userid==sessionScope.userid) }">
       
      <tr>
       <td align="center"><img  src="images/${cc.bookid}}.jpg">${bb.bookname }</td>
       <td align="center">${cc.num}</td>
       <td align="center">${bb.price }</td>
        <c:set var="v1" value="${bb.price}" scope="request"/> 
        <c:set var="v2" value="${cc.num}" scope="request"/> 
        <% id=(Integer)request.getAttribute("v1")*(Integer)request.getAttribute("v2");
        i=i+id;%>
      
       <td align="center">
	 	<a href="Add?bookid=${cc.bookid }&&userid=${cc.userid}&&num=${cc.num}">增加</a></td>

	   <!--购买数量 --></td>                               
       <td align="center"> <a href="Delete?bookid=${cc.bookid }&&userid=${cc.userid}">删除</a></td>
      </tr>
      </c:if>
       
      </c:forEach>
       </c:forEach>


    </table>
    
<p align="right">
         <!-- 商品金额总计 -->
    	<span >商品金额总计￥：<%=i %></span>
        
    </p>
  

   
    <!-- 继续购物 -->
    <div id="goBuy">
    	<div align="right"><a href="Type"><img src="images/Page_03_03_buy.jpg" alt=""  border="0"/></a> </div>
    </div>
    
     <div align="right">
       <!-- 结算按钮 -->
      <a href="page03buy.jsp"><img src="images/Page_03_solve.jpg" alt=""  border="0"/></a>    
    </div> 
  <!-- content_03 部分 -->
  <div id="content_03"></div>
  <!-- footer 部分 -->
  <div id="footer"></div>
</div>
</form> 
</body>
</html>


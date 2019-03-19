<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="span10 last">
	<div class="topNav clearfix">
		<ul>
			<c:choose>
				<c:when test="${user==null}">
					<li id="headerLogin" class="headerLogin" style="display: list-item;">
						<a href="${ pageContext.request.contextPath }/user_loginPage.action">登录</a>|</li>
					<li id="headerRegister" class="headerRegister"
						style="display: list-item;"><a href="${ pageContext.request.contextPath }/user_registPage.action">注册</a>|
					</li>
				</c:when>
				<c:otherwise>
				
				</c:otherwise>
			</c:choose>
			
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
				${user.name}
				|</li>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${ pageContext.request.contextPath }/order_findByUid.action?page=1">我的订单</a>
				|</li>
				<li id="headerRegister" class="headerRegister"
					style="display: list-item;"><a href="${ pageContext.request.contextPath }/user_quit.action">退出</a>|
				</li>
			
		
			<li><a>会员中心</a> |</li>
			<li><a>购物指南</a> |</li>
			<li><a>关于我们</a></li>
		</ul>
	</div>
	<div class="cart">
		<a href="${ pageContext.request.contextPath }/cart_myCart.action">购物车</a>
	</div>
	<div class="phone">
		客服热线: <strong>96008/53277764</strong>
	</div>
</div>
<div class="span24">
	<ul class="mainNav">
		<li><a href="${ pageContext.request.contextPath }/index.action">首页</a> |</li>
		<c:forEach items="${clist}" var="category">
	
			<li><a href="${pageContext.request.contextPath}/product_findByCid.action?cid=${category.cid}"/>${category.cname}</a> |</li>
		
		</c:forEach>
	</ul>
</div>
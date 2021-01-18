<%@page import="kr.or.ddit.common.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<meta name="description" content="">
	<meta name="author" content="">

	<title>pagingUser</title>

	<%@ include file="/common/common_lib.jsp" %>
	
	<script src="/js/jquery/jquery-1.12.4.js"></script>
	<link href="<%=request.getContextPath() %>/css/dashboard.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/css/blog.css" rel="stylesheet">
	
	<script>
		// 문서 로딩이 완료되고 나서 실행되는 영역
		$(function() {
			$(".user").on('click', function() {
				// this : 클릭 이벤트가 발생한 element
				// data-속성명  data-userid, 속성명은 대소문자 무시하고 소문자로 인식
				// ex ] data-userId ==> data-userid로 인식
				var userid = $(this).data("userid");
				$('#userid').val(userid);
				$('#frm').submit();
			})
		});
	</script>
</head>

<body>
	<form id="frm" action="${pageContext.request.contextPath}/user">
		<input type="hidden" id="userid" name="userid" value=""/>
	</form>
	<%@ include file="/common/header.jsp" %>

	<div class="container-fluid">
		<div class="row">
				
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/common/left.jsp" %>
			</div>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자123</h2>
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>사용자 별명</th>
									<th>등록일시</th>
								</tr>
<%-- 								<% --%>
<!--  									List<UserVo> users = (List<UserVo>)request.getAttribute("userList");  -->
<!--  									for(UserVo vo : users){ -->
<%-- 								%> --%>
								
								
<%-- 								<tr class="user" data-userid="<%=vo.getUserid() %>"> --%>
<%-- 									<td><%=vo.getUserid() %></td> --%>
<%-- 									<td><%=vo.getUsernm() %></td> --%>
<%-- 									<td><%=vo.getAlias() %></td> --%>
<%-- 									<td><%=vo.getReg_dt_fmt() %></td> --%>
<!-- 								</tr> -->
<%-- 								<% --%>
<!-- 									} -->
<%-- 								%> --%>

												
											 <!-- JSTL VERSION -->
									<c:forEach items="${userList }" var="user">
										<tr>
											<td>${user.userid }</td>
											<td>${user.usernm }</td>
											<td>${user.alias }</td>
											<td>${user.getReg_dt_fmt() }</td>
										</tr>
									</c:forEach>
											 
							</table>
						</div>
				
						<a class="btn btn-default pull-right" href="${pageContext.request.contextPath}/registUser">사용자 등록</a>
				
						<div class="text-center">
<%-- 							<% --%>
<!-- 							PageVo pageVo = ((PageVo)request.getAttribute("pageVo")); -->
<%-- 							%> --%>
<%-- 							<c:set var ="pageVo" value="${pageVo }"/> --%>
							<ul class="pagination">
								<li class="prev"><a href="${pageContext.request.contextPath}/pagingUser?page=1&pageSize=${pageVo.getPageSize() }">«</a></li>

									<c:forEach items="${PageVo }" var="page">
										<c:choose>
											<c:when test="${pageVo.getPage() == page }">
												<li class="active"><span>${page }</span></li>
											</c:when>
											<c:otherwise>
												<li><a href="${pageContext.request.contextPath}/pagingUser?page=${page }&pageSize=${pageVo.getPageSize() }">${page }</a></li>
											</c:otherwise>	
										
										</c:choose>
									</c:forEach>
<%-- 								<%																						${pageVo.pageSize } --%>
<!--  									// pagination 값이 4이므로 1부터 4까지 4번 반복된다 -->
<!--  									// 전체 사용자 수 : 16명  , 페이지 사이즈 : 4 -->
<!--  									int pagination = (int)request.getAttribute("userCnt"); -->
									
<!--  									for(int i = 1; i <= pagination; i++) { -->
<!--  										if(pageVo.getPage() == i) { -->
											
									
<%-- 								%> --%>
<%-- 										<li class="active"><span><%=i %></span></li> --%>
<%-- 								<%	 --%>
<!--  										} else { -->
<%-- 								%> --%>
<%-- 										<li><a href="${pageContext.request.contextPath}/pagingUser?page=<%=i %>&pageSize=<%=pageVo.getPageSize()%>"><%=i %></a></li> --%>
								
<%-- 								<%		} --%>
<!--  									}	 -->
<%-- 								%> --%>
								<li class="next"><a href="${pageContext.request.contextPath}/pagingUser?page=${pagination }&pageSize=${pageVo.getPageSize() }">»</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

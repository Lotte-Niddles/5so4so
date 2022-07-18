<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
Date nows = new Date();
request.setAttribute("_nows", nows); //key값으로 el에서 꺼낼거임
%>

<div style="width: 100%; height: 53px; border-bottom: 1px solid #5e5e5e">
	<div style="width: 100%; height: 100%; clear: both; display:inline-block">
		<div id="_title_image" style="width: 30%; float: left; display: inline">
<%-- 			<img alt="" src="<%=request.getContextPath() %>/image/titleImage.jpg" style="height: 53px"> --%>
<h1>logo</h1>
		</div>
	
		<div id="_title_today" style="width: 70%; float: left; text-align: right;">
			<div style="position: relative; top: 27px">
				<input type="text" id="search">
				<input type="button" onclick="search()" value="검색">
			</div>
		</div>
	
	</div>
</div> 
<script type="text/javascript">
function search() {
	location.href='<%=request.getContextPath() %>/searchList.do?searchPram=' + $('#search').val();
}
</script>





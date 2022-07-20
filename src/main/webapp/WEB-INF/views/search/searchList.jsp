<%@page import="com.needle.FsoFso.search.dto.SearchDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<SearchDto> searchList = (List<SearchDto>) request.getAttribute("searchList");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchList</title>
<style>
.productList{width: 60%;height: 100%;margin: 0 auto;padding-top: 5%;}
.productWrapper{width: 20%;height: 40%;float: left;margin: 0 2.5%;margin-bottom: 2%;}
.productImage img{width: 100%;border-radius: 4px;}
.productCart{display: flex;justify-content: space-around;}
</style>
</head>
<body>
<div class="productList">
<%
	if (searchList.size() > 0) {
		for (int i = 0; i < searchList.size(); i++) {
			SearchDto searchDto = searchList.get(i);
%>
		<div class="productWrapper">
			<div class="productImage">
				<a href="productDetail.do?id=<%=searchDto.getId()%>">
					<img alt="" src="<%=searchDto.getthumbnailUrl()%>">
				</a>
			</div>
			<div class="productContent">
				<div class="productTitle">
					<a href="productDetail.do?id=<%=searchDto.getId()%>">
						<span><%=searchDto.getName()%></span>
					</a>
				</div>
				<div class="productCart">
					<span><%=searchDto.getPrice()%>원</span>
				</div>
			</div>
		</div>
<%
		}
	} else {
%>
	<p style="text-align: center;margin-top: 200px;">앗! 찾으시는 결과가 없네요.</p>
<%
	}
%>
</div>
</body>
</html>
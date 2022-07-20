<%@page import="com.needle.FsoFso.search.dto.SearchDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<SearchDto> searchList = (List<SearchDto>) request.getAttribute("searchList");
	int pageNumber = (Integer)request.getAttribute("pageNumber");
	int searchPage = (Integer)request.getAttribute("searchPage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchList</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/product/main.css">
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
	<p style="text-align:center;margin-top:200px;">앗! 찾으시는 결과가 없네요.</p>
<%
	}
%>
</div>
<br>
<div class="pageNum">
<%
	for (int i = 0; i < searchPage; i++){
		if (pageNumber == i) {
%>
			<span style="font-size: 15pt;color: #0000ff;font-weight: bold;">
				<%=i + 1%>
			</span>
<%
		} else {
%>
			<a href="#none" title="<%=i + 1%>페이지" onclick="goPage(<%=i%>)"
				style="font-size: 15pt; color: #000; font-weight: bold;text-decoration: none;">
				[<%=i + 1%>]
			</a>
<%	
		}	
	}
%>
</div>
<script type="text/javascript">
function goPage(pageNumber) {
	let keyWord = $('#search').val();
	location.href = 'searchList.do?keyWord=' + keyWord + "&pageNumber=" + pageNumber; 
}
</script>
</body>
</html>
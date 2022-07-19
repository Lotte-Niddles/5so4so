<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.needle.FsoFso.product.dto.ProductDto"%>
<%
	List<ProductDto> productList = (List<ProductDto>) request.getAttribute("productList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/product/main.css">

</head>
<body>
	<div class="productList">
		<%
			for (int i = 0; i < productList.size(); i++) {
				ProductDto dto = productList.get(i);
		%>
	
			<div class="productWrapper">
				<div class="productImage">
					<a href="productDetail.do?id=<%=dto.getId()%>">
						<img alt="" src="<%=dto.getthumbnailUrl()%>">
					</a>
				</div>
				<div class="productContent">
					<div class="productTitle">
						<a href="productDetail.do?id=<%=dto.getId()%>">
							<span><%=dto.getName()%></span>
						</a>
					</div>
					<div class="productCart">
						<span><%=dto.getPrice() %>원</span>
					</div>
					
				</div>
			</div>
		<%
			}
		%>
		<div class="pageNum">
			<%
			// 페이지 번호
			String sPageNumber = (String)request.getAttribute("pageNumber");
			
			int pageNumber = 0;
			if(sPageNumber != null && !sPageNumber.equals("")){
				pageNumber = Integer.parseInt(sPageNumber);
			}
			
			// 글의 총수
			int len = (int)request.getAttribute("len");
			
			// 페이지의 수
			int bbsPage = len / 12;
			if((len % 12) > 0){
				bbsPage = bbsPage + 1;
			}
			
			%>
			<%
			for(int i = 0;i < bbsPage; i++){
				if(pageNumber == i){	// 현재 페이지
					%>
					<span style="font-size: 15pt;color: #0000ff;font-weight: bold;">
						<%=i + 1 %>
					</span>
					<%
				}else{					// 그외의 페이지		[1] 2 [3]
					%>
					<a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>)"
						style="font-size: 15pt; color: #000; font-weight: bold;text-decoration: none;">
						[<%=i + 1 %>]
					</a>
					<%	
				}	
			}
			%>
		</div>
</div>
	

<script type="text/javascript">
function goPage( pageNumber ) {
	location.href = "productList.do?pageNumber=" + pageNumber;	
}
</script>
	
</body>
</html>
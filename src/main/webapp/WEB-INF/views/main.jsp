<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="java.util.List" %>
<%@page import="com.needle.FsoFso.product.dto.ProductDto" %>
<%
    List<ProductDto> productList = (List<ProductDto>) request.getAttribute("productList");
%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/product/main.css">
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
        String startPageNumber = (String) request.getAttribute("pageNumber");

        int pageNumber = 0;
        if (startPageNumber != null && !startPageNumber.equals("")) {
            pageNumber = Integer.parseInt(startPageNumber);
        }

        int totalCount = (int) request.getAttribute("totalCount");

        int productPerPage = totalCount / 12;
        if ((totalCount % 12) > 0) {
            productPerPage = productPerPage + 1;
        }

        for (int i = 0; i < productPerPage; i++) {
            if (pageNumber == i) {
        %>
            <span style="font-size: 15pt;color: #0000ff;font-weight: bold;">
                <%=i + 1 %>
            </span>
        <%
            } else {
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
  function goPage(pageNumber) {
    location.href = "productList.do?pageNumber=" + pageNumber;
  }
</script>
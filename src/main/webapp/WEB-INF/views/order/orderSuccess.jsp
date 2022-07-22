<%@ page import="com.needle.FsoFso.order.dto.Order.OrderSuccessDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: namhyeop
  Date: 2022/07/22
  Time: 12:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<OrderSuccessDto> orderSuccessDtoList = (List) request.getAttribute("orderSuccessDtoList");
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<p>결제가 완료되었습니다.</p>

<p>결제 내역</p>
<% for(int i = 0; i < orderSuccessDtoList.size(); i++){ %>
  <text class="itemList"> 이름 : <%=orderSuccessDtoList.get(i).getName()%></text>
  <text class="itemList"> 가격 : <%=orderSuccessDtoList.get(i).getPrice()%></text>
  <text class="itemList"> 수량 : <%=orderSuccessDtoList.get(i).getQuantity()%></text>
  <text class="itemList"> 이미지 : <%=orderSuccessDtoList.get(i).getImgSrc()%></text>
    <br>
    <br>
<%}%>
<button onclick="location.href='<%=request.getContextPath()%>/proudctList.do'">메인으로 가기</button>
</body>
</html>

<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.List"%>
<%@page import="com.needle.FsoFso.admin.dto.AdminMemberDto"%>
<%@page import="com.needle.FsoFso.admin.dto.AdminMemberListRequestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
AdminMemberListRequestDto dtos = (AdminMemberListRequestDto)request.getAttribute("dto");
List<AdminMemberDto> memberList = dtos.getAdminMembers();
%>

<div id="admin-member-list" align="center">
<table>
	<col width="100px"><col width="100px"><col width="100px"><col width="100px"><col width="100px"><col width="100px">
	<tr>
		<th>닉네임</th>
		<th>아이디</th>
		<th>생년월일</th>
		<th>총 구매 수</th>
		<th>총 구매 액</th>
		<th>가입일</th>
	</tr>
	<tr>
		<%
			for(AdminMemberDto dto: memberList) {
			%>
				<td><%=dto.getName() %></td>
				<td><%=dto.getId() %></td>
				<td><%=dto.getBirth() %></td>
				<td><%=dto.getPurchasesCount() %></td>
				<td><%=dto.getTotalPurchase() %>원</td>
				<td><%=dto.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) %></td>
				
			<%
			}
		%>
	</tr>
</table>
</div>
<script type="text/javascript">

</script>

<%@page import="com.needle.FsoFso.admin.dto.AdminMemberDto"%>
<%@page import="com.needle.FsoFso.admin.dto.AdminMemberListRequestDto"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
AdminMemberListRequestDto dtos = (AdminMemberListRequestDto)request.getAttribute("dto");
List<AdminMemberDto> memberList = dtos.getAdminMembers();
%>

<div id="admin-member-list" align="center">
<table id="admin-member-list-table">
	<col width="50px"><col width="100px"><col width="100px"><col width="50px"><col width="50px"><col width="100px"><col width="100px"><col width="100px">
	<tr>
		<th>회원번호</th>
		<th>닉네임</th>
		<th>아이디</th>
		<th>연령대</th>
		<th>성별</th>
		<th>총 구매 수</th>
		<th>총 구매 액</th>
		<th>가입일</th>
	</tr>
	<tr>
		<%
			for(AdminMemberDto dto: memberList) {
			%>
				<td><%=dto.getId() %></td>
				<td><%=dto.getNickname() %></td>
				<td><%=dto.getProviderId() %></td>
				<td><%=dto.getAgeRange() %></td>
				<td><%=dto.getGender() %></td>
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

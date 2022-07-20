<%@page import="java.time.ZoneId"%>
<%@page import="java.util.Locale"%>
<%@page import="com.needle.FsoFso.admin.dto.AdminMemberDto"%>
<%@page import="com.needle.FsoFso.admin.dto.AdminMemberListRequestDto"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
AdminMemberListRequestDto dtos = (AdminMemberListRequestDto)request.getAttribute("MemberListDto");
List<AdminMemberDto> memberList = dtos.getAdminMembers();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
.withLocale(Locale.KOREA).withZone(ZoneId.of("UTC"));
%>

<div id="admin-member-list" align="center">
<table id="admin-member-list-table">
	<col width="80px"><col width="150px"><col width="150px"><col width="80px"><col width="50px"><col width="100px"><col width="100px"><col width="100px">
	<tr>
		<th>회원번호</th>
		<th>닉네임</th>
		<th>카카오아이디</th>
		<th>연령대</th>
		<th>성별</th>
		<th>구매 수</th>
		<th>총 구매 액</th>
		<th>가입일</th>
		<th>정보수정일</th>
	</tr>
	
		<%
			for(AdminMemberDto dto: memberList) {
				if(dto.getUpdatedAt() == null || dto.getCreatedAt() == null) continue;
			%>
			<tr>
				<td><%=dto.getId() %></td>
				<td><%=dto.getNickname() %></td>
				<td><%=dto.getProviderId() %></td>
				<td><%=dto.getAgeRange() %></td>
				<td><%=dto.getGender() == null ? "-" :
							dto.getGender().equals("male") ? "남" : 
							((dto.getGender().equals("female"))? "여" : "-")%></td>
				<td><%=dto.getPurchasesCount() %></td>
				<td style="text-align: right;"><%=dto.getTotalPurchase() %>원</td>
				<td><%=formatter.format(dto.getCreatedAt()) %></td>
				<td><%=formatter.format(dto.getUpdatedAt()) %></td>
			</tr>
			<%
			}
		%>
	
</table>
</div>

<script type="text/javascript">

</script>

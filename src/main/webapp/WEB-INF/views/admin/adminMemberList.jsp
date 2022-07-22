<%@page import="java.time.ZoneId"%>
<%@page import="java.util.Locale"%>
<%@page import="com.needle.FsoFso.admin.dto.AdminMemberDto"%>
<%@page import="com.needle.FsoFso.admin.dto.AdminMemberListRequestDto"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- 폰트 -->
<link href="https://webfontworld.github.io/Jalpullineun/JalpullineunOneul.css" rel="stylesheet">

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin/adminMemberList.css">
<%
AdminMemberListRequestDto dtos = (AdminMemberListRequestDto)request.getAttribute("MemberListDto");
List<AdminMemberDto> memberList = dtos.getAdminMembers();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
.withLocale(Locale.KOREA).withZone(ZoneId.of("UTC"));

String keyWord = (String) request.getAttribute("keyWord");
if (keyWord == null) {
	keyWord = "";
}
%>
  
<div id="admin-member-list" align="center">
<h2 style="margin-top: 8px;">회원관리</h2>
<div class="searchBar">
<select>
	<option>닉네임</option>
</select>
<input type="text" id="search" value="<%=keyWord%>">
<input type="button" id="searchBtn" value="검색">
</div>
<table id="admin-member-list-table" class="table table-hover">
	<col width="70px"><col width="150px"><col width="150px"><col width="70px"><col width="50px"><col width="60px"><col width="100px"><col width="100px"><col width="100px">
	<thead>
	<tr style="color: #35C5F0; text-align: center;" >
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
	</thead>
	<tbody style="font-family: 'JalpullineunOneul';">
		<%
			if (memberList.size() > 0) {
				for(AdminMemberDto dto: memberList) {
					if(dto.getUpdatedAt() == null || dto.getCreatedAt() == null) continue;
		%>
				<tr>
					<td style="text-align: center;"><%=dto.getId() %></td>
					<td><%=dto.getNickname() %></td>
					<td><%=dto.getProviderId() %></td>
					<td style="text-align: center;"><%=dto.getAgeRange() == null ? "-" : dto.getAgeRange() %></td>
					<td style="text-align: center;"><%=dto.getGender() == null ? "-" :
								dto.getGender().equals("male") ? "남" : 
								((dto.getGender().equals("female"))? "여" : "-")%></td>
					<td style="text-align: right;"><%=dto.getPurchasesCount() %>회</td>
					<td style="text-align: right;"><%=dto.getTotalPurchase() %>원</td>
					<td><%=formatter.format(dto.getCreatedAt()) %></td>
					<td><%=formatter.format(dto.getUpdatedAt()) %></td>
				</tr>
		<%
				}
		%>
	</tbody>
</table>
		<% 
				} else {
		%>
	</tbody>
</table>
				<p style="text-align:center;margin-top:200px;">앗! 찾으시는 결과가 없네요.</p>
		<%
			}
		%>
</div>

<script type="text/javascript">
$(function() {
	const enterKey = 13;
	$(document).keypress(function(e) {
		if (e.keyCode === enterKey) {
			e.preventDefault();
		}
	});
	$('#searchBtn').click(function(e) {
		const keyWord = $('#search').val().trim();
		if (keyWord != '') {
			location.href='adminMemberList.do?keyword=' + keyWord;
		} else {
			alert('검색어를 입력해 주세요!');
			$('#search').focus();
		}
	});
	$('#search').keypress(function(e) {
		const key = e.which;
		const keyWord = $('#search').val().trim();
		if (key === enterKey){
			if (keyWord != '') {
				location.href='adminMemberList.do?keyword=' + keyWord;
			} else {
				alert('검색어를 입력해 주세요!');
			}
		}		
	});
});
</script>

<%@ page import="com.needle.fsofso.member.service.Member" %>
<%@ page import="java.util.Optional" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final Optional<Object> loginMember = Optional.ofNullable(request.getSession().getAttribute("member"));
    if (loginMember.isEmpty()) {
        return;
    }
    Member member = (Member) loginMember.get();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>메인페이지</h2>
<a href="/logout.do?id=<%=member.getId()%>">로그아웃</a>
</body>
</html>

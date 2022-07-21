<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>5so4so</title>
    <tiles:insertAttribute name="header"/>        <!-- link 파일 (bootstrap, jquery) -->
</head>
<body>
<div id="body_wrap">
    <div id="main_wrap">
        <tiles:insertAttribute name="top_inc"/>
    </div>
    <div id="middle_wrap">
        <div id="content_wrap">
            <tiles:insertAttribute name="main"/>
        </div>
    </div>
    <div id="footer_wrap">
        <tiles:insertAttribute name="bottom_inc"/>
    </div>
</div>
</body>
</html>
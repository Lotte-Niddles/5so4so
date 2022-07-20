<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final Object member = request.getSession().getAttribute("member");
    System.out.println(member);
%>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<style>
    #content_wrap {
        height: 100vh !important;
    }

    .main-wrapper {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;

        height: 100%;
        background-color: #F7F9FA;
    }

    .login-card {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;

        height: 50%;
        min-width: 300px;
        background-color: white;
        border: 1px solid #efefef;
        border-radius: 12px;

        padding: 2rem 0.5rem;
    }
</style>
<div class="main-wrapper">
    <div class="login-card">

    </div>
    <p class="copyright">&copy; Copyright 2022. 5so4so, Co., Ltd. All rights reserved</p>
</div>
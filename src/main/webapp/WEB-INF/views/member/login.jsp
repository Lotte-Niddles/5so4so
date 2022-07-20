<%@ page import="com.needle.FsoFso.member.kakao.dto.KakaoOauthInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final KakaoOauthInfo kakaoClientId = (KakaoOauthInfo) request.getAttribute("kakaoInfo");
%>
<style>
    #content_wrap {
        height: 100vh !important;
    }
</style>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<div class="main-wrapper">
    <div class="login-card">
        <img
                src="<%=request.getContextPath()%>/images/logo.png"
                alt="main-logo"
                class="main-logo"
        />
        <img
                onclick="loginWithKakao()"
                src="<%=request.getContextPath()%>/images/kakao_login_logo.png"
                alt="kakao_login_logo"
                class="kakao-login-logo"
        />
        <p id="token-result"></p>
    </div>
    <p class="copyright">&copy; Copyright 2022. 5so4so, Co., Ltd. All rights reserved</p>
</div>
<script type="text/javascript">

  Kakao.init('<%=kakaoClientId.getClientId()%>');

  function loginWithKakao() {
    Kakao.Auth.authorize({
      redirectUri: '<%=kakaoClientId.getRedirectUrl()%>',
    })
  }
</script>

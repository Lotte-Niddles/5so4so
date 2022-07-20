<%@ page import="com.needle.FsoFso.member.kakao.dto.KakaoOauthInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final KakaoOauthInfo kakaoClientId = (KakaoOauthInfo) request.getAttribute("kakaoInfo");
%>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<style>
    body {
        margin: 0;
    }

    .main-wrapper {
        /*min-height: 100%;*/
        /*background-color: #fafafa;*/

        display: flex;
        justify-content: center;
        align-items: center;
    }

    .login-card {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;

        height: 50%;
        background-color: white;
        border: 1px solid #efefef;
        border-radius: 12px;

        padding: 2rem 0.5rem;
    }

    .main-logo {
        margin-bottom: 3rem;
    }

    .kakao-login-logo {
        max-width: 60%;
        cursor: pointer;
    }
</style>
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
</div>
<script type="text/javascript">

  Kakao.init('<%=kakaoClientId.getClientId()%>');

  function loginWithKakao() {
    Kakao.Auth.authorize({
      redirectUri: '<%=kakaoClientId.getRedirectUrl()%>',
    })
  }

</script>

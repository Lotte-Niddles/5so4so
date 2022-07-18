<%@ page import="com.needle.fsofso.member.KakaoOauthInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final KakaoOauthInfo kakaoClientId = (KakaoOauthInfo) request.getAttribute("kakaoInfo");
%>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<div>
    <div>

        <a id="custom-login-btn" href="javascript:loginWithKakao()">
            카카오 로그인
        </a>
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

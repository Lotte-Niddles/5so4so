<%@ page import="com.needle.FsoFso.common.util.AttributeContainer" %>
<%@ page import="com.needle.FsoFso.member.service.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");
%>
<style>
    .mypage-container {
        display: flex;
        justify-content: center;
        align-items: flex-start;

        min-height: 90vh;
    }

    .mypage-wrapper {
        display: grid;
        width: 80%;
        grid-template-columns: 20% minmax(70%, auto);
        grid-column-gap: 2rem;

        padding: 2rem;
    }

    .mypage-wrapper > div {
        padding: 2rem;
    }

    .mypage-profile {
        display: flex;
        flex-direction: column;
        justify-content: flex-start;
        align-items: center;
    }

    .mypage-contents {
        display: flex;
        flex-direction: column;
        justify-content: flex-start;
        align-items: center;
    }

    .mypage-border {
        border: 1px solid #ebebeb;
        border-radius: 12px;
    }

    .divider {
        width: 100%;
        border-bottom: 1px solid #ebebeb;
        margin: 2rem 0;
    }

    .divider-col {
        color: #ebebeb;
        margin: 0 1rem;
    }

    .profile-head {
        font-size: 1.5rem;
        font-weight: 700;
        color: #35c5f0;
        margin: 1rem 0 2rem 0;
    }

    .profile-contents-label {
        font-weight: 400;
    }

    .profile-img {
        max-width: 60%;
        opacity: 70%;
    }

    .content-heads {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .content-head {
        font-size: 1.2rem;
    }

    .activated {
        color: #009FCE;
        font-weight: 700;
    }

    .disabled {
        color: #969696;
    }

    a, a:hover {
        text-decoration: none;
        outline: none;
        color: inherit;
    }
</style>
<div class="mypage-container">
    <div class="mypage-wrapper">
        <div class="mypage-profile mypage-border">
            <img class="profile-img" src="<%=request.getContextPath()%>/images/smile.png"/>
            <div class="profile-head">이름</div>
            <div class="profile-contents-label">연령대</div>
            <div class="profile-contents-label">성별</div>
            <div class="profile-contents-label">회원등급?</div>
        </div>
        <div class="mypage-contents mypage-border">
            <div class="content-heads">
                <div class="content-head activated">나의 주문</div>
                <div class="divider-col content-head">|</div>
                <div class="content-head disabled"><a href="<%=request.getContextPath()%>/me.do">나의 리뷰</a></div>
            </div>
            <div class="divider"></div>
            <div class="content-order">아직 주문 내역이 없어요.</div>
            <div class="content-order">쇼핑 하러 가기
                <a href="<%=request.getContextPath()%>/productList.do" style="color: #35c5f0">click!</a>
            </div>
        </div>
    </div>
</div>
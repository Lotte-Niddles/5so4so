<%@ page import="com.needle.FsoFso.common.util.AttributeContainer" %>
<%@ page import="com.needle.FsoFso.member.service.Member" %>
<%@ page import="java.util.Optional" %>
<%@ page import="com.needle.FsoFso.review.dto.ReviewDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.time.ZoneId" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    final Member member = (Member) AttributeContainer.sessionAttributeFrom(request, "member");

    final List<ReviewDto> reviews = Optional.ofNullable(
                    (List<ReviewDto>) AttributeContainer.attributeFrom(request, "reviewList"))
            .orElse(Collections.emptyList());

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            .withLocale(Locale.KOREA).withZone(ZoneId.of("UTC"));
%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/member/mypage.css">
<div class="flex-center mypage-container">
    <div class="mypage-wrapper">
        <div class="flex-col-center mypage-profile mypage-border">
            <div class="flex-col-center">
                <img class="profile-img" src="<%=request.getContextPath()%>/images/smile.png"/>
                <div class="flex-col-center">
                    <div id="profile-head" class="profile-head"><%=member.getNickname()%>
                    </div>
                    <div id="name-edit" class="profile-edit pointer-cursor">✏️ 닉네임 수정</div>
                </div>
                <div class="flex-center profile-contents">
                    <div class="profile-contents-label profile-text">
                        연령
                    </div>
                    <div class="profile-text">
                        <%=member.getAgeRange()%>
                    </div>
                    <div class="divider-col">|</div>
                    <div class="profile-contents-label profile-text">
                        성별
                    </div>
                    <div class="profile-text">
                        <%="female".equals(member.getGender()) ? "여성" : "남성"%>
                    </div>
                </div>
            </div>
            <div>
                <div class="flex-center auth-contents">
                    <div class="profile-text pointer-cursor" style="color: #ebebeb"
                         onclick="handleLogout(<%=member.getId()%>)"
                    >
                        로그아웃
                    </div>
                    <div class="divider-col">|</div>
                    <div class="profile-text pointer-cursor" style="color: #ebebeb"
                         onclick="handleExit(<%=member.getId()%>)"
                    >
                        회원탈퇴
                    </div>
                </div>
            </div>
        </div>
        <div class="flex-col-center mypage-contents mypage-border activated-page">
            <div class="content-heads flex-center">
                <div class="content-head activated">나의 주문</div>
                <div class="divider-col content-head">|</div>
                <div onclick="handlePage()" class="content-head disabled pointer-cursor">나의 리뷰</div>
            </div>
            <div class="divider"></div>
            <div class="content-text">아직 주문 내역이 없어요.</div>
            <div class="content-text">쇼핑 하러 가기
                <a href="<%=request.getContextPath()%>/productList.do"
                   style="color: #35c5f0">click!</a>
            </div>
        </div>
        <div class="flex-col-center mypage-contents mypage-border disabled-page">
            <div class="content-heads flex-center">
                <div onclick="handlePage()" class="content-head disabled pointer-cursor">
                    나의 주문
                </div>
                <div class="divider-col content-head">|</div>
                <div class="content-head activated">나의 리뷰</div>
            </div>
            <div class="divider"></div>
            <% if (reviews.isEmpty()) {%>
            <div class="content-text">작성한 리뷰가 없어요.</div>
            <div class="content-text">첫 리뷰 쓰러 가기
                <a href="<%=request.getContextPath()%>/productList.do"
                   style="color: #35c5f0">click!</a>
            </div>
            <%
            } else {
                for (int i = 0; i < reviews.size(); i++) {
                    ReviewDto review = reviews.get(i);
            %>
            <div class="flex-center content-item">
                <div>
                    <img
                            class="content-img pointer-cursor"
                            src="<%=review.getThumbnailUrl()%>"
                            alt="<%=review.getName()%>"
                            onclick="toProduct(<%=review.getProductId()%>)"
                    >
                </div>
                <div class="flex-center" style="width: 100%; justify-content: space-between">
                    <div class="flex-col-center" style="align-items: flex-start">
                        <div
                                style="font-weight: 700" class="content-text pointer-cursor"
                                onclick="toProduct(<%=review.getProductId()%>)"
                        >
                            <%=review.getName()%>
                        </div>
                        <div class="content-text"><%=review.getContent()%>
                        </div>

                    </div>
                    <div class="flex-col-center review-date" style="justify-content: space-between">
                        <div>
                            작성: <%=formatter.format(review.getCreatedAt())%>
                        </div>
                        <div>
                            수정: <%=formatter.format(review.getUpdatedAt())%>
                        </div>
                    </div>
                </div>
            </div>
            <% if (i != reviews.size() - 1) { %>
            <div class="divider"></div>
            <%
                        }
                    }
                } %>
        </div>
    </div>
</div>
<script>
  function handlePage() {
    const $disabled_page = document.querySelector('.disabled-page');
    const $activated_page = document.querySelector('.activated-page');

    $disabled_page.classList.remove('disabled-page');
    $disabled_page.classList.add('activated-page');

    $activated_page.classList.remove('activated-page');
    $activated_page.classList.add('disabled-page')
  }

  function toProduct(product_id) {
    location.href = '<%=request.getContextPath()%>/productDetail.do?id=' + product_id;
  }

  function handleLogout(member_id) {
    const conf = confirm('로그아웃 하시겠습니까?')
    if (conf) {
      location.href = '<%=request.getContextPath()%>/logout.do?id=' + member_id;
    }
  }

  function handleExit(member_id) {
    const conf = confirm('모든 정보가 삭제됩니다. \n정말 탈퇴하시겠습니까?')
    if (conf) {
      location.href = '<%=request.getContextPath()%>/exit.do?id=' + member_id;
    }
  }

  $('#name-edit').click(function () {
    const newName = prompt('수정할 닉네임을 입력해주세요.');

    $.ajax({
      url: '/me.do',
      method: 'post',
      contentType: 'application/json',
      data: JSON.stringify({
        'nickname': newName
      }),
      success: function () {
        document.querySelector('#profile-head').innerHTML = newName;
      },
      error: function () {
        alert('닉네임 수정에 실패했습니다.');
      },
    })
  })
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

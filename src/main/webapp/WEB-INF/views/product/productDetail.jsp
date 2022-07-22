<%@page import="com.needle.FsoFso.common.util.CurrencyFormatter" %>
<%@page import="com.needle.FsoFso.review.dto.Review" %>
<%@page import="java.util.List" %>
<%@page import="com.needle.FsoFso.product.dto.ProductDto" %>
<%@ page import="com.needle.FsoFso.common.util.AttributeContainer" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    final boolean isLoggedIn = AttributeContainer.hasSessionAttributeOf(request, "member");
    ProductDto product = (ProductDto) request.getAttribute("product");
    List<Review> reviewList = (List<Review>) request.getAttribute("reviewList");
    List<String> nicknameList = (List<String>) request.getAttribute("nicknameList");
%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <!-- Link Swiper's CSS -->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <!-- Swiper JS -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

    <!-- thoma폰트 -->
    <link href="//db.onlinewebfonts.com/c/cd0381aa3322dff4babd137f03829c8c?family=Tahoma"
          rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/product/productDetail.css"/>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
<div class="productDetailReview">
    <div class="detailWrapper" align="center">
        <div class="detailLeft">
            <img src="<%=product.getthumbnailUrl()%>" width="500" height="500">
        </div>
        <div class="detailRight">
            <form id="detail" action="addCart.do" method="post">
                <div class="detailTitle">
                    <span><%=product.getName()%></span>
                </div>

                <div class="detailPrice">
                    <div class="detailPriceContent">
                        <span>정가 : <%=CurrencyFormatter.toCurrencyFormat(
                                (int) (product.getPrice() * 1.1))%>원</span>
                    </div>
                    <div class="detailPriceContent grade">
                        <span>회원 적용가 : <%=CurrencyFormatter.toCurrencyFormat(
                                product.getPrice())%>원</span>
                    </div>
                </div>

                <div class="detailStock">
                    <span>남은 수량 : <%=product.getStock()%>개</span>
                </div>

                <div class="detailOrder">
                    수량 : <input type="number" id="quantity" name="quantity" min="0" value="0"
                                style="text-align: right; ">개
                </div>
                <input type="hidden" value="<%=product.getId() %>" name="productId"/>
                <button type="button" id="addCart" <%= isLoggedIn ? "" : "disabled style=\"background-color: #bfbfbf;\""%>>장바구니</button>
            </form>
            <div class="swiper mySwiper" style="width: 260px; height: 70px;">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <img alt=""
                             src="<%=request.getContextPath()%>/images/product/slide1.png"
                             width="260px" height="70px">
                    </div>
                    <div class="swiper-slide">
                        <img alt=""
                             src="<%=request.getContextPath()%>/images/product/slide2.png"
                             width="260px" height="70px">
                    </div>
                    <div class="swiper-slide">
                        <img alt=""
                             src="<%=request.getContextPath()%>/images/product/slide3.png"
                             width="260px" height="70px">
                    </div>
                </div>
                <div class="swiper-pagination"></div>
            </div>
        </div>
    </div>

    <div class="review">
        <div style="display: flex; justify-content: space-between; margin-bottom: 25px;">
            <span style="font-size: 40px">리뷰</span>
            <button <%= isLoggedIn ? "" : "disabled style=\"background-color: #bfbfbf;\""%> onclick="isValidMemberForAddReivew()">리뷰작성</button>
        </div>

        <table style="text-align: center">
            <col width="100">
            <col width="500">
            <col width="300">
            <tr height="50">
                <th>닉네임</th>
                <th>내용</th>
                <th>일자</th>
            </tr>
            <%
                for (int i = 0; i < reviewList.size(); i++) {
            %>
            <tr height="40">
                <td><%=nicknameList.get(i)%>
                </td>
                <td><%=reviewList.get(i).getContent()%>
                </td>
                <td><%=reviewList.get(i).getCreatedAt().toString().substring(0, 10) %>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </div>


</div>
<script type="text/javascript">
  $("#addCart").click(function () {
    if ($("#quantity").val() == "" || $("#quantity").val() == 0) {
      alert("수량을 입력하세요");
    } else if ($("#quantity").val() > <%=product.getStock()%>) {
      alert("재고가 부족합니다");
    } else {
      Swal.fire({
        title: '장바구니 담기 완료',
        text: '장바구니에 상품을 성공적으로 담았습니다.',
        imageUrl: '<%=product.getthumbnailUrl()%>',
        imageWidth: 400,
        imageHeight: 300,
        imageAlt: 'Custom image',
      }).then(function (isConfirm) {
        if (isConfirm) {
          $("#detail").submit();
        }
      });
    }
  });

  <!-- Initialize Swiper -->
  var swiper = new Swiper(".mySwiper", {
    autoplay: {
      delay: 3000,
    },
  });

  function isValidMemberForAddReivew() {
    $.ajax({
      url: "checkBuyMember.do",
      type: "get",
      data: {
        "productId": "<%=product.getId()%>"
      },
      dataType: "text",
      success: function (result) {
        if (result == "true") {
          location.href = "addReview.do?id=<%=product.getId()%>";
        } else {
          alert("상품을 구입한 회원이 아닙니다.");
        }
      }
    })
  }
</script>
</body>
</html>

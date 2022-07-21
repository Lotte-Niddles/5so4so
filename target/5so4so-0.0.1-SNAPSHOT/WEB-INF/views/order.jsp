<%@ page import="com.needle.FsoFso.order.service.ShopService" %>
<%@ page import="com.needle.FsoFso.order.repository.ShopRepository" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List" %>
<%@ page import="com.needle.FsoFso.order.dto.Shop.ShopDto" %>
<%@ page import="java.util.List" %>
<%@ page import="static java.awt.SystemColor.text" %>
<%@ page import="com.needle.FsoFso.order.dto.Shop.DisplayShopDto" %><%--
  Created by IntelliJ IDEA.
  User: namhyeop
  Date: 2022/07/18
  Time: 4:47 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<DisplayShopDto> displayShopDto = (java.util.List<DisplayShopDto>) request.getAttribute("shopInfo");
    Long allPrice = (Long) request.getAttribute("AllPrice");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">
        body {
            margin: 0;
        }

        * {
            box-sizing: border-box;
        }

        p,
        span {
            margin: 0;
        }

        a {
            color: black;
        }

        img {
            /*display: block;*/
            width: 80%;
            height: 80px;
            margin: auto;
        }

        .cart {
            width: 80%;
            margin: auto;
            padding: 30px;
        }

        .inner_chart_cart {
            width: 100%;
            margin: auto;
            padding: 30px;
        }

        .cart ul {
            background-color: whitesmoke;
            padding: 30px;
            margin-bottom: 50px;
            border: whitesmoke solid 1px;
            border-radius: 5px;
            font-size: 13px;
            font-weight: 300;
        }

        .cart ul :first-child {
            color: #35C5F0;
        }

        table {
            border-top: solid 1.5px black;
            border-collapse: collapse;
            width: 100%;
            font-size: 14px;
        }

        thead {
            text-align: center;
            font-weight: bold;
        }

        tbody {
            font-size: 12px;
        }

        td {
            padding: 15px 0px;
            border-bottom: 1px solid lightgrey;
        }

        .cart__list__detail :nth-child(3) {
            vertical-align: top;
        }

        .cart__list__detail :nth-child(3) a {
            font-size: 12px;
        }

        .cart__list__detail :nth-child(3) p {
            margin-top: 6px;
            font-weight: bold;
        }

        .cart__list__5SO4SO {
            font-size: 12px;
            color: gray;
        }

        .cart__list__option {
            vertical-align: top;
            padding: 20px;
        }

        .cart__list__option p {
            margin-bottom: 25px;
            position: relative;
        }

        .cart__list__option p::after {
            content: "";
            width: 90%;
            height: 1px;
            background-color: lightgrey;
            left: 0px;
            top: 25px;
            position: absolute;
        }

        .cart__list__optionbtn {
            background-color: white;
            font-size: 10px;
            border: lightgrey solid 1px;
            padding: 7px;
        }

        .cart__list__detail :nth-child(4),
        .cart__list__detail :nth-child(5),
        .cart__list__detail :nth-child(6) {
            border-left: 2px solid whitesmoke;
        }

        .cart__list__detail :nth-child(5),
        .cart__list__detail :nth-child(6) {
            text-align: center;
        }

        .cart__list__detail :nth-child(5) button {
            background-color: #35C5F0;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 4px 8px;
            font-size: 12px;
            margin-top: 5px;
        }

        .price {
            font-weight: bold;
        }

        .cart__mainbtns {
            width: 420px;
            height: 200px;
            padding-top: 40px;
            /*display: block;*/
            margin: auto;
        }

        .cart__bigorderbtn {
            width: 200px;
            height: 50px;
            font-size: 16px;
            margin: auto;
            border-radius: 5px;
        }

        .cart__bigorderbtn.left {
            background-color: white;
            border: 1px lightgray solid;
        }

        .cart__bigorderbtn.right {
            background-color: #35C5F0;
            color: white;
            border: none;
        }

        .float_left {
            display: flex;
        }

        .payment_right {
            font-weight: bold;
            font-size: 100%;
            margin: 10px 10px 10px 10px;
        }

        .payment_right_back {
            margin: 29px 0 0 0;
            width: 100%;
            height: 100%;
            border: lightgrey solid 1px;
            background-color: white;
        }

        .cart-tmp {
            display: flex;
            justify-content: center;
            align-items: flex-start;
        }
    </style>
</head>
<body>
<div>
    <div class="cart cart__information">
        <ul>
            <li>장바구니 상품은 최대 30일간 저장됩니다.</li>
            <li>가격, 옵션 등 정보가 변경된 경우 주문이 불가할 수 있습니다.</li>
            <li>오늘출발 상품은 판매자 설정 시점에 따라 오늘출발 여부가 변경될 수 있으니 주문 시 꼭 다시 확인해 주시기 바랍니다.</li>
        </ul>
    </div>
    <div class="cart-tmp">
        <div class="float_left">
            <form>
                <section class="inner_chart_cart">
                    <table class="cart__list">
                        <form>
                            <thead>
                            <tr>
                                <td><input type="checkbox"></td>
                                <td colspan="2">상품정보</td>
                                <td>옵션</td>
                                <td>상품금액</td>
                                <td>배송비</td>
                            </tr>
                            </thead>
                            <tbody>
                            <%
                                for (int i = 0; i < displayShopDto.size(); i++) {%>
                            <tr class="cart__list__detail">
                                <td><input type="checkbox"></td>
                                <td><img src="<%=displayShopDto.get(i).getImageSrc()%>%"
                                         alt="<%=displayShopDto.get(i).getItemName()%>"></td>
                                <td><span class="cart__list__5SO4SO"> 5SO4SO</span>
                                    <p><%=displayShopDto.get(i).getItemName()%>
                                    </p>
                                    <sapn class="price"><%=displayShopDto.get(i).getPrice()%>
                                    </sapn>
                                </td>
                                <td class="cart__list__option">
                                    <button class="cart__list__optionbtn">주문조건 추가/변경</button>
                                </td>
                                <td><span class="price"><%=displayShopDto.get(i).getPrice()%>></span><br>
                                    <button class="cart__list__orderbtn">주문하기</button>
                                </td>
                                <td>무료</td>
                            </tr>
                            <% } %>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="3"><input type="checkbox">
                                    <button class="cart__list__optionbtn">선택상품 삭제</button>
                                    <button class="cart__list__optionbtn">선택상품 찜</button>
                                </td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                            </tfoot>
                        </form>
                    </table>
                </section>
            </form>
        </div>

        <div class="float_left">
            <form>
                <div class="cart__mainbtns payment_right_back">
                    <div class="payment_right">총 상품금액 <%=allPrice%></div>
                    <div class="payment_right">총 배송비 0</div>
                    <div class="payment_right">총 할인금액 0</div>
                    <div class="payment_right">총 결제액 <%=allPrice%> </div>
                    <button class="cart__bigorderbtn left">쇼핑 계속하기</button>
                    <button class="cart__bigorderbtn right">주문하기</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>

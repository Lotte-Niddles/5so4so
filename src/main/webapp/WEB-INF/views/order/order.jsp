<%@ page import="java.util.List" %>

<%@ page import="com.needle.FsoFso.order.dto.Shop.DisplayShopDto" %>
<%@ page import="com.needle.FsoFso.common.util.CurrencyFormatter" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

	if(request.getAttribute("stockFlag") != null) {
		int flag = (int)request.getAttribute("stockFlag");
		if(flag == 1) {
			%>
			<script>
			alert("수량이 변경되었습니다.");
			</script>
			<%
		} else if(flag == 2) {
			%>
			<script>
			alert("수량이 변경실패했습니다. 다시 시도해주세요");
			</script>
			<%
		} else if(flag == 0) {
			// none
		}
	}

    List<DisplayShopDto> displayShopDto = (List<DisplayShopDto>) request.getAttribute("allDisplayDto");

    /* for (DisplayShopDto shopDto : displayShopDto) {
        System.out.println("shopDto = " + shopDto);
    } */
    Long allPrice = (Long) request.getAttribute("allPrice");

    int productTotalPrice = 0;
    int deliveryFee = 3000;
%>

<html>
<head>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <title>Title</title>

    <style type="text/css">

        .cart__information {
            width: 80%;
            margin: auto;
            padding: 30px;

        }

        .cart__information ul {
            background-color: whitesmoke;
            padding: 30px;
            margin-bottom: 50px;
            border: whitesmoke solid 1px;
            border-radius: 5px;
            font-size: 13px;
            font-weight: 300;
        }

        .cart__information ul li:first-child {
            color: #35C5F0;
        }

        .cart__list__optionbtn {
            background-color: white;
            font-size: 10px;
            border: lightgrey solid 1px;
            padding: 7px;
        }

        .cart__list__orderbtn {
            background-color: #35C5F0;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 4px 8px;
            font-size: 12px;
            margin-top: 5px;
            vertical-align: top;
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

        .float_right {
		    position: fixed;
		    top: 422px;
		    width: 407px;
		    height: 277px;
		    right: 24px;
        } 

        .payment_right {
            /*  font-weight: bold; */
            font-size: 100%;
            margin: 20px 30px;
        }

        .payment_right span {
            display: inline-block;
            width: 100px;
        }

        .payment_right_back {
            margin: 29px 0 0 0;
            width: 100%;
            height: 100%;
            border: lightgrey solid 1px;
            background-color: white;
        }

        .cart-tmp {
            width: 65%;
            margin: 0 auto 75px auto;
            min-height: 400px;
            font-family: 'JalpullineunOneul';

        }

        .cart__list td, .cart__list th {
            text-align: center;
        }

        .cart__list tr:first-child {
            height: 80px;
        }

        .cart__list tr {
            height: 120px;
        }

    </style>
</head>
<body>
<div>
    <div class="cart__information">
        <ul>
            <li>가격, 옵션 등 정보가 변경된 경우 주문이 불가할 수 있습니다.</li>
            <li>오늘출발 상품은 판매자 설정 시점에 따라 오늘출발 여부가 변경될 수 있으니 주문 시 꼭 다시 확인해 주시기 바랍니다.</li>
        </ul>
    </div>
    <div class="cart-tmp">
        <div class="float_left">
            <form>
                <table class="cart__list">
                    <thead>
                    <tr>
                        <th width="80"><input type="checkbox" id="allCheck"></th>
                        <th colspan="2" width="200">상품정보</th>
                        <th width="150">수량</th>
                        <th width="150">상품금액</th>
                        <th width="50">배송비</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (int i = 0; i < displayShopDto.size(); i++) {
                            DisplayShopDto nowDto = displayShopDto.get(i);
                    %>

                    <tr class="cart__list__detail">
                        <td><input type="checkbox" name="check" data-cat="<%=nowDto.getPrice()%>"
                                   value="<%=nowDto.getProductId()%>"></td>
                        <td><img src="<%=nowDto.getImageSrc()%>"
                                 alt="<%=nowDto.getItemName()%>" width="100" height="100"></td>
                        <td width="100"><span class="cart__list__5SO4SO"> 5SO4SO</span>
                            <p><%=nowDto.getItemName()%>
                            </p>
                            <span class="price"><%=CurrencyFormatter.toCurrencyFormat(nowDto.getPrice())%>
                                    </span>
                                </td>
                                <td class="cart__list__option">
                                    <input type="number" id="<%=nowDto.getProductId()%>" class="cart__list__numberinput" value="<%=nowDto.getQuantity() %>" min="0"  style="width: 100px;">
                                </td>
                                <td><span class="price"><%=CurrencyFormatter.toCurrencyFormat(nowDto.getPrice())%></span><br>
                                </td>
                                <td>무료</td>
                            </tr>
                            <% } %>
                            <tr>
                        <td style="padding: 5px; text-align: right;" colspan="6">
                            <button type="button" id="cart__list__deletebtn" class="cart__list__optionbtn"
                                    style="font-size: 13px;">선택상품 삭제
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>

        <div class="float_right">
            <form>
                <div class="cart__mainbtns payment_right_back" style="font-weight: 100;">
                    <div class="payment_right">
                        <span>총 상품금액</span>
                        <span id="productPrice">0</span>
                    </div>
                    <div class="payment_right">
                        <span>총 배송비</span>
                        3,000
                    </div>
                    <div class="payment_right">
                        <span>총 할인금액</span>
                        0
                    </div>
                    <div class="payment_right">
                        <span>총 결제액 </span>
                        <span id="totalPrice">3,000</span>
                    </div>
                    <input type="hidden" name="productTotalPrice" value="">
                    <button class="cart__bigorderbtn left">쇼핑 계속하기</button>
                    <button id="orderForm" class="cart__bigorderbtn right">주문하기</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
    $(function () {
        $("#allCheck").click(function () {
            let sumVal = 0;

            if ($("#allCheck").prop("checked")) {
                $("input[type=checkbox]").prop("checked", true);

                $("input:checkbox[name=check]").each(function () {

                    sumVal += (parseInt($(this).attr('data-cat')) * $(this).parent().parent().find(".cart__list__numberinput").attr('value'));
                })
                let productPrice = sumVal;
                let totalPrice = sumVal + parseInt(3000);

                productPrice = productPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
                totalPrice = totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');

                document.getElementById("productPrice").innerHTML = productPrice;
                document.getElementById("totalPrice").innerHTML = totalPrice;

            } else {
                $("input[type=checkbox]").prop("checked", false);
                document.getElementById("productPrice").innerHTML = 0;
                document.getElementById("totalPrice").innerHTML = "3,000";
            }
        });

        $("input:checkbox[name=check]").click(function () {
            let sumVal = 0;
            $("#allCheck").prop("checked", false);
            $("input:checkbox[name=check]:checked").each(function () {
                sumVal += (parseInt($(this).attr('data-cat')) * $(this).parent().parent().find(".cart__list__numberinput").attr('value'));
            })
            let productPrice = sumVal;
            let totalPrice = sumVal + parseInt(3000);

            productPrice = productPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
            totalPrice = totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');

            document.getElementById("productPrice").innerHTML = productPrice;
            document.getElementById("totalPrice").innerHTML = totalPrice;
            document.getElementsByName("productTotalPrice")[0].setAttribute("value", sumVal + parseInt(3000));

        });

        $(".cart__list__numberinput").change(function () {
            let changedVal = $(this).val();
            if (changedVal <= 0) {
                alert("0개 이상만 주문할 수 있습니다.");
            } else {
                let changedValProductId = $(this).attr('id');
                location.href = "<%=request.getContextPath()%>/cartNumReplace.do?changeItemCnt=" + changedVal + "&productId=" + changedValProductId;
            }
        });

        $('#orderForm').click(function (e) {
            e.preventDefault();
            let $input = $('input:checkbox[name=check]');
            console.log($input)

            const productId = [];
            $input.each(function () {
                if (this.checked) {
                    productId.push(parseInt(this.value));
                }
            });

            console.log(productId);
            $.ajax({
                url: '<%=request.getContextPath()%>/orderProduct.do',
                contentType: 'application/json',
                method: 'POST',
                data: JSON.stringify({
                    'productId': productId
                }),
                success: function (res) {
                    console.log(res);
                    console.log('success');
                    location.href = "<%=request.getContextPath()%>/me.do";
                },
                error: function () {
                    console.log('error');
                    location.href="<%=request.getContextPath()%>/order.do";
                },
            });
        });

        $("#cart__list__deletebtn").click(function () {
            let deleteList = [];
            let count = 0;
            $("input:checkbox[name=check]").each(function () {
                if (this.checked) {
                    deleteList.push($(this).attr('value'));
                    // console.log($(this).attr('value'));
                    count = count + 1;
                }
            });
            // console.log(count);
            if (count > 0) {
                $.ajax({
                    url: "<%=request.getContextPath()%>/cartDeleteProduct.do",
                    contentType: 'application/json',
                    type: "POST",
                    data: JSON.stringify({
                        'productId': deleteList
                    }),
                    // data: {"productId": JSON.stringify(deleteList)},
                    success: function (msg) {
                        location.href = "<%=request.getContextPath()%>/order.do";
                    },
                    error: function () {
                        console.log(data);
                        location.href = "<%=request.getContextPath()%>/order.do";
                    }
                })
            } else {
                alert('선택해주세요');
            }
        });
    });
</script>


</html>

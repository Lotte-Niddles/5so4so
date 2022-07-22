<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- 폰트 -->
<link href="https://webfontworld.github.io/Jalpullineun/JalpullineunOneul.css" rel="stylesheet">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/addProduct.css" />

<div id="product-input" align="center">
<h2 style="margin: 35px 0;">상품등록</h2>

<form action="product.do" name="frmForm" id="frm" method="post" enctype="multipart/form-data">

<table id="product-input-table" class="table table-hover" style="width: 85%">
<col width="100px"><col width="500">

<tr>
   <th>상품명</th>
   <td>
      <input id="frm-name-input" type="text" class="form-control" name="name" required="required">
   </td>
</tr>
<tr>
   <th>대표이미지</th>
   <td>
      <input id="frm-file-input" type="file" name="fileload" style="width: 350px" required="required">
   </td>
</tr>
<tr>
   <th>가격</th>
   <td>
      <input id="frm-price-input" type="number" class="form-control" name="price" required="required" style="text-align: right; ">
   </td>
</tr>
<tr>
   <th>재고</th>
   <td>
      <input id="frm-stock-input" type="number" class="form-control" name="stock" min="0" value="0" style="text-align: right; ">
   </td>
</tr>

<tr align="center">
   <td colspan="2">
      <button id="addProductBtn" type="button">상품등록</button>
   </td>
</tr>
</table>

</form>
</div>

<script>


$(document).ready(function() {
   $('#addProductBtn').click(function() {
      if($('#frm-name-input').val().length == 0 || !$('#frm-file-input')) {
         alert("0은 입력할 수 없습니다.");
      } else if($('#frm-stock-input').val() == 0 || $('#frm-price-input').val() == 0) {
         alert("값을 입력해주세요.");
      } else {
      $("#frm").submit();
      }
   });
});

</script>

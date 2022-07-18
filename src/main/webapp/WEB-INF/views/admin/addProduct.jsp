<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Hi</h2>

<form action="product.do" name="frmForm" id="frm" method="post" enctype="multipart/form-data">

<table class="list_table" style="width: 85%">
<col width="200"><col width="500">

<tr>
	<th>상품명</th>
	<td style="text-align: left;">
		<input type="text" class="form-control" name="name" value="" size="50">
	</td>
</tr>
<tr>
	<th>대표이미지</th>
	<td style="text-align: left;">
		<input type="file" name="fileload" style="width: 350px">
	</td>
</tr>
<tr>
	<th>가격</th>
	<td style="text-align: left;">
		<input type="text" class="form-control" name="price" size="50">
	</td>
</tr>
<tr>
	<th>재고</th>
	<td style="text-align: left;">
		<textarea rows="10" cols="50" class="form-control" name="stock"></textarea>
	</td>
</tr>

<tr align="center">
	<td colspan="2">
		<button type="button" class="btn btn-primary">자료올리기</button>
	</td>
</tr>
</table>

</form>
<script>
$("button").click(function () {
	
	// 빈칸 첵크
	
	$("#frm").submit();
});
</script>

</body>
</html>
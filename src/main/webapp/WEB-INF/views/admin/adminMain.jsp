<%@page import="com.needle.FsoFso.admin.dto.DailyDetailDto"%>
<%@page import="com.needle.FsoFso.admin.dto.AdminMainRequestDto"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin/adminMain.css">
<%
AdminMainRequestDto requestDto = (AdminMainRequestDto) request.getAttribute("AdminMainRequestDto");
List<DailyDetailDto> detailList = requestDto.getDailyDetails();

LocalDate mindate = LocalDate.now();
String sMaxDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd"));
String categoryJson = "[";
String dataJson = "[";

for(DailyDetailDto dto : detailList) {
	LocalDate dtoDate = dto.getDate();
	if(mindate.isAfter(dtoDate)){ mindate = dtoDate;}
	
	categoryJson += dto.getDate().format(DateTimeFormatter.ofPattern("MM/dd"))+", ";
	dataJson += dto.getSales()+", ";
}
categoryJson = categoryJson.substring(0, categoryJson.lastIndexOf(","));
dataJson = dataJson.substring(0, dataJson.lastIndexOf(","));

categoryJson += "]";
dataJson += "]";

String sMindate = mindate.format(DateTimeFormatter.ofPattern("MM/dd"));
%>


<div id="admin-main" align="center" style="padding: 10px;">
	<div id="admin-left-chart" style="width: 50%; padding: 5px; background-color: gray;">
		<div id="daily-sales-container"></div>
	</div>
	<div id="admin-right-chart" style="width: 50%; padding: 5px; background-color: gray;">
		<div id="daily-sales-detail">
			<div id="daily-sales-detail-title"><p style="font-size: 15px;">일자별 요약</p></div>
			<table>
				<col width="100px"><col width="100px"><col width="50px"><col width="50px">
				<tr>
					<th>일자</th>
					<th>매출액</th>
					<th>주문수</th>
					<th>가입</th>
				</tr>
			<%
				for(DailyDetailDto dto : detailList) {
					%>
						<tr>
							<td><%=dto.getDate().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))%></td>
							<td><%=dto.getSales()%>원</td>
							<td><%=dto.getSalesCnt()%>건</td>
							<td><%=dto.getSigninCnt()%>명</td>
						</tr>
					<%
				}
			%>
			</table>
		</div>
	</div>
</div>


<script type="text/javascript">
const chart = Highcharts.chart('daily-sales-container', {
    title: {
        text: '최근 일간매출 그래프'
    },
    subtitle: {
        text: <%=sMindate %> ~ <%=sMaxDate%>
    },
    xAxis: {
        categories: <%=categoryJson%>
    },
    series: [{
        type: 'column',
        colorByPoint: true,
        data: <%=dataJson%>,
        showInLegend: false
    }]
});
</script>

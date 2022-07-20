<%@page import="java.time.ZoneId"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.Instant"%>
<%@page import="com.needle.FsoFso.admin.dto.DailyDetailDto"%>
<%@page import="com.needle.FsoFso.admin.dto.AdminMainRequestDto"%>
<%@page import="java.time.format.DateTimeFormatter"%>
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
AdminMainRequestDto requestDto = (AdminMainRequestDto) request.getAttribute("adminMainDto");
List<DailyDetailDto> detailList = requestDto.getDailyDetails();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd")
									.withLocale(Locale.KOREA)
									.withZone(ZoneId.of("UTC"));

Instant mindate = Instant.now();

String sMaxDate = formatter.format(mindate);
String categoryJson = "[";
String dataJson = "[";

for(DailyDetailDto dto : detailList) {
	Instant dtoDate = dto.getDate();
	if(mindate.isAfter(dtoDate)){ mindate = dtoDate;}
	
	categoryJson += "'"+formatter.format(dto.getDate())+"', ";
	dataJson += dto.getSales()+", ";
	
}
categoryJson = categoryJson.substring(0, categoryJson.lastIndexOf(","));
dataJson = dataJson.substring(0, dataJson.lastIndexOf(","));

categoryJson += "]";
dataJson += "]";

String sMindate = formatter.format(mindate);
%>


<div id="admin-main" align="center" style="display: flex; padding: 10px; width: 1000px; margin:0 auto;">
	<div id="admin-left-chart" style="width: 500px; margin:10px; padding: 5px; background-color: gray;">
		<div id="container"></div>
	</div>
	<div id="admin-right-chart" style="width: 500px; margin:10px; padding: 5px; background-color: gray;">
		<div id="daily-sales-detail">
			<div id="daily-sales-detail-title"><p style="font-size: 20px; font:bold;">일자별 요약</p></div>
			<table>
				<col width="100px"><col width="100px"><col width="100px"><col width="100px">
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
							<td><%=dto.getDate().toString().substring(0, 10)%></td>
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
const chart = Highcharts.chart('container', {
    title: {
        text: '최근 일간매출 그래프'
    },
    subtitle: {
        text: '<%=sMindate %> ~ <%=sMaxDate%>'
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

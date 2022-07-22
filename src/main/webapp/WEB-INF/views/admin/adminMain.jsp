<%@page import="com.needle.FsoFso.admin.dto.AgeChartDto"%>
<%@page import="com.needle.FsoFso.admin.dto.GenderChartDto"%>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="java.time.ZoneId" %>
<%@ page import="java.time.Instant" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%@ page import="java.util.Locale" %>
<%@ page import="java.util.List" %>

<%@ page import="com.needle.FsoFso.admin.dto.DailyDetailDto" %>
<%@ page import="com.needle.FsoFso.admin.dto.AdminMainRequestDto" %>
<%@ page import="com.needle.FsoFso.admin.util.InstantUtil" %>
<%@ page import="com.needle.FsoFso.common.util.CurrencyFormatter" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 하이차트 -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/highcharts-more.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin/adminMain.css">
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<!-- 폰트 -->
<link href="https://webfontworld.github.io/Jalpullineun/JalpullineunOneul.css" rel="stylesheet">

<%
List<AgeChartDto> ageChartDtoList = (List<AgeChartDto>) request.getAttribute("ageChartDtoList");
List<GenderChartDto> genderChartList = (List<GenderChartDto>) request.getAttribute("genderDtoList");
String ageChartCategory = "";
String ageChartData = "";
for(int i = 0; i < ageChartDtoList.size(); i++){
	ageChartCategory += "'" + ageChartDtoList.get(i).getAge() + "'" + ",";
	ageChartData += ageChartDtoList.get(i).getCount()+ ",";
}
ageChartCategory = ageChartCategory.substring(0, ageChartCategory.lastIndexOf(","));
ageChartData = ageChartData.substring(0, ageChartData.lastIndexOf(","));

AdminMainRequestDto requestDto = (AdminMainRequestDto) request.getAttribute("adminMainDto");
List<DailyDetailDto> detailList = requestDto.getDailyDetails();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd")
									.withLocale(Locale.KOREA)
									.withZone(ZoneId.of("UTC"));

Instant mindate = Instant.now(); // have to find min date
String sMaxDate = formatter.format(Instant.now()); // today

String categoryJson = "[";
String dataJson = "[";

int listCount = 0;
for(int i = (InstantUtil.SEARCHDAYS - 1); i >= 0; i--) {
	int salesData = 0;
	Instant refDate = Instant.now().minus(i, ChronoUnit.DAYS); // 기준날짜
	String sRefDate = formatter.format(refDate);
	if(mindate.isAfter(refDate)){ mindate = refDate;} // 최소 날짜 찾기
	
	// 데이터 불러오기
	DailyDetailDto dto = null;
	String sDataDate = "";
	if(listCount < detailList.size()) {
		dto = detailList.get(listCount);
	}
	if(dto != null) {
		sDataDate = formatter.format(dto.getDate()); // 데이터 날짜
	}
	
	// 날짜 확인
	if(dto == null || sDataDate.equals("") || !sDataDate.equals(sRefDate)){ // 데이터날짜와 기준날짜가 다르다면
		salesData = 0;
	} else { // 데이터날짜와 기준날짜가 같다면
		salesData = dto.getSales();
		listCount++;
	}
	categoryJson += "'"+sRefDate+"', ";
	dataJson += salesData+", ";
}

categoryJson = categoryJson.substring(0, categoryJson.lastIndexOf(","));
dataJson = dataJson.substring(0, dataJson.lastIndexOf(","));

categoryJson += "]";
dataJson += "]";

String sMindate = formatter.format(mindate);
%>


<div id="admin-main" align="center" style="display: flex; padding: 10px; width: 1200px; margin:0 auto;">
	<div id="admin-left-chart" style="width: 700px; margin:10px; padding: 5px; background-color: gray;">
		<div id="container"></div>
	</div>
	<div id="admin-right-chart" style="width: 700px; margin:10px; padding: 5px; background-color: gray;">
		<div id="daily-sales-detail" style="background-color: white; height: 400px;">
			<div id="daily-sales-detail-title"><p style="font-size: 20px; font:bold;">주간 일별 요약</p></div>
			<table id="daily-sales-detail-table" class="table table-hover">
			<col width="100px"><col width="140px"><col width="90px"><col width="90px">
			<thead>
				<tr style="color: #35C5F0; text-align: center;" >
					<th>일자</th>
					<th>매출액</th>
					<th>주문수</th>
					<th>가입</th>
				</tr>
			</thead>
			<tbody style="font-family: 'JalpullineunOneul';">
			<%
				int totalSales = 0;
				for(DailyDetailDto dto : detailList) {
					totalSales += dto.getSales();
					%>
						<tr>
							<td style="text-align: center;"><%=dto.getDate().toString().substring(0, 10)%></td>
							<td style="text-align: right;"><%=CurrencyFormatter.toCurrencyFormat(dto.getSales())%>원</td>
							<td style="text-align: right;"><%=dto.getSalesCnt()%>건</td>
							<td style="text-align: right;"><%=dto.getSigninCnt()%>명</td>
						</tr>
					<%
				}
			%>
			</tbody>
			</table>
			<div id="daily-sales-detail-totalSales">
				<p style="margin-top:8px; font-family: 'JalpullineunOneul'; text-align: left; padding: 20px; border-top: double;">총 : <%=totalSales %></p>
			</div>
			
		</div>
	</div>
</div>

<div id="admin-main" align="center" style="display: flex; padding: 10px; width: 1200px; margin:0 auto;">
	<div id="admin-left-chart" style="width: 700px; margin:10px; padding: 5px; background-color: gray;">
		<div id="genderContainer"></div>
	</div>
	<div id="admin-right-chart" style="width: 700px; margin:10px; padding: 5px; background-color: gray;">
		<div id="ageContainer"></div>
	</div>
</div>


<script type="text/javascript">
const chart = Highcharts.chart('container', {
    title: {
        text: '주간 일별매출 그래프'
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

const genderChart = Highcharts.chart('genderContainer', {
	  chart: {
	    plotBackgroundColor: null,
	    plotBorderWidth: null,
	    plotShadow: false,
	    type: 'pie'
	  },
	  title: {
	    text: '회원 성별'
	  },
	  tooltip: {
	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	  },
	  accessibility: {
	    point: {
	      valueSuffix: '%'
	    }
	  },
	  plotOptions: {
	    pie: {
	      allowPointSelect: true,
	      cursor: 'pointer',
	      dataLabels: {
	        enabled: true,
	        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	      }
	    }
	  },
	  series: [{
	    name: 'Gender',
	    colorByPoint: true,
	    data: [{
	      name: '<%=genderChartList.get(0).getGender() %>',
	      y: <%=genderChartList.get(0).getCount() %>,
	      sliced: true,
	      selected: true
	    }, {
	      name: '<%=genderChartList.get(1).getGender() %>',
	      y: <%=genderChartList.get(1).getCount() %>
	    }]
	  }]
	});
	
const ageChart = Highcharts.chart('ageContainer', {
	  title: {
		    text: '회원 나이대'
		  },
		  xAxis: {
		    categories: [<%=ageChartCategory %>]
		  },
		  series: [{
		    type: 'column',
		    colorByPoint: true,
		    data: [<%=ageChartData %>],
		    showInLegend: false
		  }]
		});

		document.getElementById('plain').addEventListener('click', () => {
		  chart.update({
		    chart: {
		      inverted: false,
		      polar: false
		    },
		    subtitle: {
		      text: 'Plain'
		    }
		  });
		});

		document.getElementById('inverted').addEventListener('click', () => {
		  chart.update({
		    chart: {
		      inverted: true,
		      polar: false
		    },
		    subtitle: {
		      text: 'Inverted'
		    }
		  });
		});

		document.getElementById('polar').addEventListener('click', () => {
		  chart.update({
		    chart: {
		      inverted: false,
		      polar: true
		    },
		    subtitle: {
		      text: 'Polar'
		    }
		  });
		});
	
</script>

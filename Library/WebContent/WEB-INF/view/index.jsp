<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전국 도서관 웹 공간정보시스템</title>
<link rel="stylesheet" href="css/ol.campsite.css">
<link rel="stylesheet" href="css/campsite_main.css">
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/ol-debug.js"></script>
</head>
<body>
<div id="warp">
	<div id="header">
		<div class="topDecal"></div>
		<div id="campsiteLogo"></div>
		<h1>전국 도서관 웹 공간정보시스템</h1>
	</div>
	<div id="contents">
		<div id="left">
			<div class="gnb">
				<ul>
				<li class="gnbicon icon1"
							onclick="gnbMenuSelect(1)"><span>도서관지도</span></li>
				<li class="gnbicon icon2"
							onclick="gnbMenuSelect(2)"><span>지역별</span></li>
				<li class="gnbicon icon3"
							onclick="gnbMenuSelect(3)"><span>유형별</span>
				<li class="gnbicon icon4"
							onclick="gnbMenuSelect(4)"><span>통합검색</span>		
				</ul>
			</div>
		<div class="leftContents contents2">
			<h3>지역별 검색</h3>
			<p>지역별 검색을 하실 수 있습니다.</p>
			<ul class="campsiteList">
				<li onclick="selectRegion('서울특별시경기도인천광역시');">서울·경기·인천</li>
				<li onclick="selectRegion('대전광역시충청남도충청북도세종특별자치시');">대전·충남·충북·세종</li>
				<li onclick="selectRegion('강원도');">강원</li>
				<li onclick="selectRegion('대구광역시경상북도');">대구·경북</li>
				<li onclick="selectRegion('부산광역시울산광역시경상남도');">부산·울산·경남</li>
				<li onclick="selectRegion('전라남도전라북도광주광역시');">전남·광주·전북</li>
				<li onclick="selectRegion('제주특별자치도');">제주</li>
			</ul>
		</div>
		<div class="leftContents contents3">
			<h3>유형별 검색</h3>
			<p>유형별 검색을 하실 수 있습니다.</p>
			<ul class="campsiteList">
				<li onclick="selectType('공공도서관');">공공도서관</li>
				<li onclick="selectType('작은도서관');">작은도서관</li>
				<li onclick="selectType('어린이도서관');">어린이도서관</li>
				<li onclick="selectType('학교도서관');">학교도서관</li>
				<li onclick="selectType('전문도서관');">전문도서관</li>
				<li onclick="selectType('대학도서관');">대학도서관</li>				
			</ul>
		</div>
	</div>
	<div id="mapArea">
		<div id="map"></div>
		<div id="FeatureInfo"></div>
	</div>
</div>
	<div id="footer">
		<span class="copyright">Copyright &copy; 2021 LibraryWeb</span>
	</div>
</div>
<script src="js/library.map.js"></script>
<script src="js/library.ui.js"></script>
<script>
function selectRegion(regionname){
	var postdata={'action':'SelectRegion','region':regionname};
	$.ajax({
		url: "Library.do",
		cache: false,
		dataType: "json",
		data: postdata,
	}).done(function(data) {
		var count = data.length;
		var strTemp= "";
		for(var i =0;i<count;i++){
			strTemp+=data[i];
			strTemp+=(i<(count-1)? ',' : '' );
		}
		console.log(strTemp);
		setGIDList(strTemp);
	});
}
function selectType(typename){
	var postdata={'action':'SelectType','type':typename};
	$.ajax({
		url: "Library.do",
		cache: false,
		dataType: "json",
		data: postdata,
	}).done(function(data) {
		var count = data.length;
		var strTemp= "";
		for(var i =0;i<count;i++){
			strTemp+=data[i];
			strTemp+=(i<(count-1)? ',' : '' );
		}
		console.log(strTemp);
		setGIDList(strTemp);
	});
}
</script>
</body>
</html>
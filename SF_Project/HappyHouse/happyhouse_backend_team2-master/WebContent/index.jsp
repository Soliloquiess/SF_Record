<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="utf-8" />
<!DOCTYPE html>
<html lang="en">
<head>
<title>HappyHouse</title>
<meta charset="utf-8">
<!-- header호출 -->
<jsp:include page="common/header.jsp" />
<!-- js호출 -->
<script type="text/javascript" src ="js/index.js"></script>
<!-- css호출 -->
<link rel="stylesheet" href="css/index.css" type="text/css">

</head>
<body>
<!-- nav호출 -->
<jsp:include page="nav.jsp" />


	<!-- carousel 시작 -->
	<div id="demo" class="carousel slide" data-ride="carousel"
		data-interval="3000">
		<ul class="carousel-indicators">
			<li data-target="#demo" data-slide-to="0" class="active"></li>
			<li data-target="#demo" data-slide-to="1"></li>
			<li data-target="#demo" data-slide-to="2"></li>
		</ul>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="./img/home1.jpg" alt="Los Angeles" width="1100"
					height="500">
				<div class="carousel-caption">
					<h3>Happy House</h3>
					<p>행복한 우리집</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="./img/home2.jpg" alt="Chicago" width="1100" height="500">
				<div class="carousel-caption">
					<h3>Happy House</h3>
					<p>행복한 우리집</p>
				</div>
			</div>
			<div class="carousel-item">
				<img src="./img/home3.jpg" alt="New York" width="1100" height="500">
				<div class="carousel-caption">
					<h3>Happy House</h3>
					<p>행복한 우리집</p>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span
			class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next" href="#demo" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>
	<!-- carousel 끝 -->

	<!-- select 검색 시작 -->
	<div class="div-select">
		<form id="dong-form" action="${root}/map" method="post">
			<input type="hidden" name='act' value='apt' /> <select
				id="house-type" name="house-type" class="background-gray">
				<option value="">선택</option>
				<option value="전체">전체</option>
				<option value="아파트">아파트</option>
				<option value="주택">주택</option>
			</select> <select id="sido" name="sido" class="background-gray">
				<option value="">선택</option>
			</select> <select id="gugun" name="gugun" class="background-gray">
				<option value="">선택</option>
			</select> <select id="dong" name="dong" class="background-gray">
				<option value="">선택</option>
			</select> <input type="submit" value="검색" class="background-gray">
		</form>
	</div>
	<!-- select 검색 끝 -->

	<br />
	<!-- 카카오 맵 시작 -->
	<div id="map" style="width: 80%; height: 350px; margin: 0 auto;"></div>
	<!-- 카카오 맵 끝 -->

	<br />

	<!-- contents 시작 -->
	<div class="container-fluid contents">
		<div class="row">
			<div class="col-sm-8">
				<h3>주택 관련 기사</h3>
				<table class="table table_striped">
					<thead>
						<tr>
							<th class="title">제목</th>
							<th>작성자</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>12.16 대책 후 ‘매수·매도자 모두 일단 관망세’</td>
							<td>윤기현</td>
							<td>1756</td>
						</tr>
						<tr>
							<td>구미시, 낙동강 변 국가3산단에 민간공원 조성</td>
							<td>박지현</td>
							<td>998</td>
						</tr>
						<tr>
							<td>‘은행’과 ‘보험사’의 주택담보대출 조건, 어떻게 다를까?</td>
							<td>한혜원</td>
							<td>856</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-sm-4">
				<h3>오늘의 뉴스</h3>
				<table class="table table_bordered table_hover">
					<thead>
						<tr>
							<th class="title">제목</th>
							<th>작성자</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>KB국민은행, ‘디지털헌금바구니’출시</td>
							<td>기자</td>
							<td>12</td>
						</tr>
						<tr>
							<td>존슨콘트롤즈, OpenBlue 공개</td>
							<td>기자</td>
							<td>998</td>
						</tr>
						<tr>
							<td>제6회 INAK사회공헌대상 수상</td>
							<td>기자</td>
							<td>856</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- contents 끝 -->
	<br />

	<!-- footer호출 -->
<jsp:include page="common/footer.jsp" />
</body>

</html>

function logout() {
	document.location.href = "./member?act=logout";
}
function memberDetail() {
	document.location.href = "./member?act=memberDetail";
}


/*카카오 맵 script */

$(function() {
		var mapContainer = document.getElementById('map'), // 지도의 중심좌표
		mapOption = {
			center : new kakao.maps.LatLng(33.451475, 126.570528), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

		// 지도에 마커를 표시합니다 
		var marker = new kakao.maps.Marker({
			map : map,
			position : new kakao.maps.LatLng(33.450701, 126.570667)
		});

		// 커스텀 오버레이에 표시할 컨텐츠 입니다
		// 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
		// 별도의 이벤트 메소드를 제공하지 않습니다 
		var content = '<div class="wrap">'
				+ '    <div class="info">'
				+ '        <div class="title">'
				+ '            카카오 스페이스닷원'
				+ '            <div class="close" onclick="closeOverlay()" title="닫기"></div>'
				+ '        </div>'
				+ '        <div class="body">'
				+ '            <div class="img">'
				+ '                <img src="https://cfile181.uf.daum.net/image/250649365602043421936D" width="73" height="70">'
				+ '           </div>'
				+ '            <div class="desc">'
				+ '                <div class="ellipsis">제주특별자치도 제주시 첨단로 242</div>'
				+ '                <div class="jibun ellipsis">(우) 63309 (지번) 영평동 2181</div>'
				+ '                <div><a href="https://www.kakaocorp.com/main" target="_blank" class="link">홈페이지</a></div>'
				+ '            </div>' + '        </div>' + '    </div>'
				+ '</div>';

		// 마커 위에 커스텀오버레이를 표시합니다
		// 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
		var overlay = new kakao.maps.CustomOverlay({
			content : content,
			map : map,
			position : marker.getPosition()
		});

		kakao.maps.event.addListener(marker, 'mouseover', function() {
			overlay.setMap(map);
		});
		kakao.maps.event.addListener(marker, 'mouseout', function() {
			overlay.setMap(null);
		});

		function closeOverlay() {
			if (overlay !== undefined)
				overlay.setMap(null);
		}

	});
/*카카오 맵 script */
/*================================================================================================== */
/*시군구 읍면동 얻어오기 시작 */
	$(document).ready(
			function() {
				$.get("./map", {
					act : "sido"
				}, function(data, status) {
					$.each(data, function(index, vo) {
						$("#sido").append(
								"<option value='"+vo.sido_code+"'>"
										+ vo.sido_name + "</option>");
					});//each
				}//function
				, "json");//get
			});//ready
	$(document).ready(
			function() {
				$("#sido").change(
						function() {
							$.get("./map", {
								act : "gugun",
								sido : $("#sido").val()
							}, function(data, status) {
								$("#gugun").empty();
								$("#gugun").append(
										'<option value="0">선택</option>');
								$.each(data, function(index, vo) {
									$("#gugun").append(
											"<option value='"+vo.gugun_code+"'>"
													+ vo.gugun_name
													+ "</option>");
								});//each
							}//function
							, "json");//get
						});//change
				$("#gugun").change(
						function() {
							$.get("./map", {
								act : "dong",
								gugun : $("#gugun").val()
							}, function(data, status) {
								$("#dong").empty();
								$("#dong").append(
										'<option value="0">선택</option>');
								$.each(data, function(index, vo) {
									$("#dong").append(
											"<option value='"+vo.dong+"'>"
													+ vo.dong + "</option>");
								});//each
							}//function
							, "json");//get
						});//change
			});//ready
/*시군구 읍면동 얻어오기 끝  */
/*================================================================================================== */
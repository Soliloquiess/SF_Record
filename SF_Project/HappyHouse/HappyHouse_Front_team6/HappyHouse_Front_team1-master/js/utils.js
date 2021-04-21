/**
 * 
 */

window.onload = function () {
	$.ajax({
		url: '../data/building_news.json',
		dataType: 'json',
		success: function(result) {
			// 리스트용
			var content = "<p>주택 관련 기사</p>";
			content += "<hr/>";
			content += "<ul>";
			for (var i=0; i<result.length; ++i) {
				content += "<li><a href=news.html?id=" + result[i].id + "&type=building>" + result[i].title + "</a></li>";
			}
			content += "</ul>";
			content += "<hr/>";
			$(".building_news").html(content);
			
			// 내용용
			var url = location.href;
			var parameters = (url.slice(url.indexOf('?') + 1, url.length)).split();
			var temp = parameters[0].split("=")[1];
			var id = temp.split("&")[0];
			var type = parameters[0].split("=")[2];
			
			
			if (type == "building") {
				var content = "<h4>" + result[id-1].title + "</h4>";
				content += "<hr/>";
				content += "<p>" + result[id-1].article + "</p>";
				content += "<p>" + result[id-1].author + "</p>";
				content += "<p>" + result[id-1].time + "</p>";
				content += "<p>" + result[id-1].depart + "</p>";
				$(".article").empty();
				$(".article").html(content);			
			}

		}
	});
	$.ajax({
		url: '../data/today_news.json',
		dataType: 'json',
		success: function(result) {
			
			var content = "<p>오늘의 뉴스</p>";
			content += "<hr/>";
			content += "<ul>";
			for (var i=0; i<result.length; ++i) {
				content += "<li><a href=news.html?id=" + result[i].id + "&type=today>" + result[i].title + "</a></li>";
			}
			content += "</ul>";
			content += "<hr/>";
			$(".today_news").html(content);
			
			// 내용용
			var url = location.href;
			var parameters = (url.slice(url.indexOf('?') + 1, url.length)).split();
			var temp = parameters[0].split("=")[1];
			var id = temp.split("&")[0];
			var type = parameters[0].split("=")[2];
			
			
			if (type == "today") {
				var content = "<h4>" + result[id-1].title + "</h4>";
				content += "<hr/>";
				content += "<p>" + result[id-1].article + "</p>";
				content += "<p>" + result[id-1].author + "</p>";
				content += "<p>" + result[id-1].time + "</p>";
				content += "<p>" + result[id-1].depart + "</p>";
				$(".article").empty();
				$(".article").html(content);			
			}
		}
	});
	
	$.ajax({
		url: '../data/notice.json',
		dataType: 'json',
		success: function(result) {
			
			var content = "<table class='table'>";
			content += "<thead>";
			content += "<tr>";
			content += "<th>" + "번호" + "</th>";
			content += "<th>" + "제목" + "</th>";
			content += "<th>" + "조회수" + "</th>";
			content += "<th></th>";
			content += "</tr>";
			content += "</thead>";
			content += "<tbody>";
						
			for (var i=0; i<result.length; ++i) {
				content += "<tr>";
				content += "<td>" + result[i].id + "</td>";
				content += "<td>" + result[i].title + "</td>";
				content += "<td>" + result[i].visitedCnt + "</td>";
				content += "<td><button><a style='color=black;' href=noticeView.html?id=" + result[i].id + ">조회</a></button></td>";
				content += "</tr>";
			}
			content += "</tbody>";
			content += "</table>";
			$(".content_notice").html(content);
		}
	});
}

function login() {
	var id = document.getElementById("usr").value;
	var pw = document.getElementById("pwd").value;
	
	if (id === "123" && pw === "123") {
		$(".before-login").hide();
		$(".after-login").show();
	}
}

function logout() {
	$(".before-login").show();
	$(".after-login").hide();
}

function changeSelect1() {
	var gun = ["시/구/군", "종로구", "중구"];
	var selectSel1 = $("#sel1").val();
	
	if (selectSel1 == "서울시") {
		$('#sel2').empty();
		
		for (var i=0; i<gun.length; ++i) {
			var option = $("<option>" + gun[i] + "</option>");
			$('#sel2').append(option);
		}
	}
}

function changeSelect2() {
	var dong1 = ["동", "신교동", "청운동"];
	var dong2 = ["동", "무교동", "다동"];
	
	var selectSel2 = $("#sel2").val();
	
	if (selectSel2 == "종로구") {
		$('#sel3').empty();
		
		for (var i=0; i<dong1.length; ++i) {
			var option = $("<option>" + dong1[i] + "</option>");
			$('#sel3').append(option);
		}
	} else if (selectSel2 == "중구") {
		$('#sel3').empty();
		
		for (var i=0; i<dong2.length; ++i) {
			var option = $("<option>" + dong2[i] + "</option>");
			$('#sel3').append(option);
		}
	}
}

function changeSelect3() {
	var selectSel3 = $("#sel3").val();
	
	if (selectSel3 !== "동") {
		location.href="searchRecentHouseDeal.html";
	}
}

function userRemove() {
	alert("삭제 완료됨.");
	location.href="main.html";
}
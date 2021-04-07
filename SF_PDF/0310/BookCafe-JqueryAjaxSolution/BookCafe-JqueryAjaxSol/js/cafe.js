//코드 작성해 봅시다!!!

$(document).ready(function(){
  /***************** 비동기 요청 start *****************/
  // 1. 프로그래밍 언어 목록 요청. callback method는 programmingBook(결과처리)
	$.ajax({
		url:"data/programming.xml",
		dataType:"xml",
		success:function(result){
			programmingBook(result);
		}
	});
	
  // 2.에세이 목록 요청.callback method는 essayBook(결과처리)
	$.ajax({
		url:"data/essay.json",
		dataType:"json",
		success: function(result){
			essayBook(result);
		}		
	});
 
  /***************** 비동기 요청 end *****************/
	
	

  /***************** 투표 생성 start *****************/
  // localStorage에서 poll이름의 data 얻기.
  var poll = localStorage.getItem("poll");
  
  // 투표가 보여질 div
  var pollDiv = document.querySelector("#vote");
  if (poll) {
    // localStorage에서 얻은 문자열을 JSON객체로 변환.
    var vote = JSON.parse(poll);
    var sdate = vote.start_date; // 시작일.
    var edate = vote.end_date; // 종료일.
    var question = vote.question; // 질문.
    var answers = vote.answers; // 답변항목.
    
    // 투표 화면 구성.
    var pollContent = '<div class="text-center text-secondary mb-3"><h4>[ 당신의 선택 ]</h4></div>';
    pollContent += '<div class="font-weight-bold">' + question + "</div>";
    pollContent += '<div class="p-3">';
    pollContent += '  <ul class="nav flex-column">';
    for (var i = 0; i < answers.length; i++) {
      pollContent += '<li class="nav-item">';
      pollContent += "    <label>";
      pollContent += '      <label><input type="radio" name="vote_answer" value="' + answers[i] + '" />' + answers[i];
      pollContent += "    </label>";
      pollContent += "  </li >";
    }
    
    pollContent += "</ul>";
    pollContent += "</div>";
    pollContent += '<div class="text-center">';
    pollContent += '  <button class="btn btn-outline-primary btn-sm" onclick="javascript:poll();">투표하기</button>';
    pollContent += '  <button class="btn btn-outline-danger btn-sm">결과보기</button>';
    pollContent += "</div>";
    pollContent +=
      '<div class="text-right text-secondary mt-1">투표기간 : ' +
      dateFormat(sdate) +   " ~ " +    dateFormat(edate) +  "</div>";
    
    // 투표가 보여질 div 화면에 투표양식 추가.
    pollDiv.innerHTML = pollContent;
    
  } else {
    // 진행중인 투표가 없을 경우 화면 추가.
    pollDiv.innerHTML = '<div class="vote_title">진행중인 투표가 없습니다.</div>';
  }
  /***************** 투표 생성 end *****************/
  
}); //여기까지가 document.ready() 끝

//3. callback method for programmingBook
function programmingBook(xml){
	var books = $(xml).find('book');
	var bookView = "";
	
	$(books).each(function(index, item){
		var isbn = $(item).find('isbn').text();
		var title = $(item).find('title').text();
		var price = $(item).find('price').text();
		var desc = $(item).find('desc').text();
		
		bookView += '<div class="col-md-3 border border-secondary rounded pt-2 pb-2">';
        bookView += ' <div class="mt-1">';
        bookView += '   <img src="img/book/' + isbn + '.png" class="rounded w-100" title="' + desc + '" alt="" />';
        bookView += " </div>";
        bookView += ' <div class="mt-1 p-1 text-center" style="background-color: #f2f2f2;">';
        bookView += "<h6>" + title + "<br />(" + numberWithCommas(price) + "원)</h6>";
        bookView += " </div>";
        bookView += "</div>";		
	});
	
	$('#plist').html(bookView);
}


/*function programmingBook() {
  // 서버로부터 data를 전부 받은 상태 (Completed)
  if (httpRequest1.readyState == 4) {
    // 서버로부터의 응답 상태 (OK)
    if (httpRequest1.status == 200) {
      // 서버에서 응답 온 data를 XML로 받음.
      var books = httpRequest1.responseXML;
      // xml에서 책목록을 배열로 받음.
      var booklist = books.querySelectorAll("book");
      var len = booklist.length;
      var bookView = "";
      for (var i = 0; i < len; i++) {
        var book = booklist[i];
        var isbn = book.querySelector("isbn").childNodes[0].nodeValue; // xml에서 isbn 얻기
        var title = book.querySelector("title").childNodes[0].nodeValue; // xml에서 제목 얻기
        var price = book.querySelector("price").childNodes[0].nodeValue; // xml에서 가격 얻기
        var desc = book.querySelector("description").childNodes[0].nodeValue; // xml에서 설명 얻기
      
        // 책의 갯수만큼 화면구성
        bookView += '<div class="col-md-3 border border-secondary rounded pt-2 pb-2">';
        bookView += ' <div class="mt-1">';
        bookView += '   <img src="img/book/' + isbn + '.png" class="rounded w-100" title="' + desc + '" alt="" />';
        bookView += " </div>";
        bookView += ' <div class="mt-1 p-1 text-center" style="background-color: #f2f2f2;">';
        bookView += "<h6>" + title + "<br />(" + numberWithCommas(price) + "원)</h6>";
        bookView += " </div>";
        bookView += "</div>";
      }
      // 아이디가 plist인 div에 책화면을 html로 삽입.
      document.querySelector("#plist").innerHTML = bookView;
    }
  }
}*/

//4. callback method for essay
function essayBook(jsonArray) {	
	var bookView = "";
	for(var i = 0; i < jsonArray.length;i++){
		var book = jsonArray[i];
		
		var isbn = book.isbn;
		var title = book.title;
		var price = book.price;
		var desc = book.description;
		
		bookView += '<div class="col-md-3 border border-secondary rounded pt-2 pb-2">';
        bookView += ' <div class="mt-1">';
        bookView += '   <img src="img/book/' + isbn + '.png" class="rounded w-100" title="' + desc + '" alt="" />';
        bookView += " </div>";
        bookView += ' <div class="mt-1 p-1 text-center" style="background-color: #f2f2f2;">';
        bookView += "<h6>" + title + "<br />(" + numberWithCommas(price) + "원)</h6>";
        bookView += " </div>";
        bookView += "</div>";	
	}
	$('#elist').html(bookView);
}


// 정규표현식을 이용한 3자리마다 ,(comma) 찍기(가격)
function numberWithCommas(x) {
  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

// 투표 시작일과 종료일 날짜 형식. (yy.mm.dd)
function dateFormat(date) {
  var yymmdd = date.split("-");
  return yymmdd[0].substr(2, 2) + "." + yymmdd[1] + "." + yymmdd[2];
}

// 5.로그인
function login() {
  //1.userid 정보를 입력받는다.(prompt 이용) 
	var userid = prompt('아이디를 입력해 주세요', 'ssafy');
	
  //입력받은 값이 비어 있으면 alert 띄우기
	if(userid == ''){
		alert('아이디를 입력해 주세요');
		return;
	}
  
  //2.userpass 정보를 입력받는다.(prompt 이용)
	var userpass = prompt('패스워드를 입력해 주세요', '123');
	
  //입력받은 값이 비어 있으면 alert 띄우기
	if(userpass == ''){
		alert('패스워드를 입력해 주세요');
		return;
	}
	
  //3.비동기 요청으로 'data/userList.xml'파일에서 사용자 정보를 얻어와 사용자가 입력한 값과 비교 (userList.xml은 작성할것)
	  $.ajax({
		  url:'data/userList.xml',
		  dataType:'xml',
		  success: function(xml){
			  var result = loginCheck(xml, userid, userpass);
			  
			  if(result){//로그인 정보가 맞으면
				  alert('로그인 성공!');
				  $('#profile_img').attr('src', 'img/profile.png');
				  $('#header_nav_confirm_off').hide();
				  $('#header_nav_confirm_on').show();
			  }else{
				  alert("아이디 또는 비밀번호 확인!!!");	
			  }			  
		  }
	  });  
}

function loginCheck(xml, userid, userpass){
	var id = $(xml).find('id').text();
	var pw = $(xml).find('pw').text();
	
	if(id == userid && pw == userpass)
		return true;
	else
		return false;
}


// 6.로그아웃
function logout() {
	 $('#profile_img').attr('src', 'img/noimg.png');
	 $('#header_nav_confirm_off').show();
	 $('#header_nav_confirm_on').hide();  
}

//투표하기
function poll() {
  var votes = document.querySelectorAll('input[name="vote_answer"]');
  var sel_menu = "";

  for (var i = 0; i < votes.length; i++) {
    if (votes[i].checked == true) {
      sel_menu = votes[i].value;
      break;
    }
  }
  alert(sel_menu + "를 선택했습니다.");
}

// 투표만들기
function pollMake() {
  // pollmake.html의 창아이디를 poll로 설정하고 가로 500, 세로 300인 창을 열기.
  window.open("pollmake.html", "poll", "width=500,height=300,top=300,left=400");
}

// 답변 항목 추가
function addAnswer() {
  var listDiv = document.querySelector("#poll_answer_list");

  var divEl = document.createElement("div"); // <div></div>
  divEl.setAttribute("class", "poll_answer_item form-inline mb-1"); // <div class="poll_answer_item"></div>
  var inputEl = document.createElement("input"); // <input/>
  inputEl.setAttribute("type", "text"); // <input type="text"/>
  inputEl.setAttribute("class", "form-control col-lg-10 mr-3"); // <input type="text" class="form-control"/>
  inputEl.setAttribute("name", "answer"); // <input type="text" class="form-control" name="answer"/>
  var buttonEl = document.createElement("button");
  buttonEl.setAttribute("type", "button");
  buttonEl.setAttribute("class", "btn btn-outline-danger btn-sm");
  // 버튼에 click 이벤트 리스너 등록.
  buttonEl.addEventListener("click", function (e) {
    var parent = this.parentNode;
    listDiv.removeChild(parent);
  });
  buttonEl.appendChild(document.createTextNode("삭제"));

  divEl.appendChild(inputEl);
  divEl.appendChild(buttonEl);
  listDiv.appendChild(divEl);
}

// 투표 생성
function makePoll() {
  var sdate = document.querySelector("#start_date").value; // 시작일.
  var edate = document.querySelector("#end_date").value; // 종료일.
  if (!sdate || !edate) {
    // 시작, 종료일 유효성검사.
    alert("설문 기간 입력!!!");
    return;
  }

  var quest = document.querySelector("#question").value; // 질문.
  if (!quest) {
    // 질문 유효성검사.
    alert("질문 내용 입력!!!");
    return;
  }

  var answerInput = document.querySelectorAll('input[name="answer"]'); // 답변 항목.
  for (var i = 0; i < answerInput.length; i++) {
    // 답변항목 유효성검사.
    if (!answerInput[i].value) {
      alert("답변 항목 입력!!!");
      return;
    }
  }

  var answers = [];
  for (var i = 0; i < answerInput.length; i++) {
    answers.push(answerInput[i].value); // 답변 배열에 입력 data 넣기.
  }

  // 입력 data를 이용하여 JSON객체 생성.
  var poll = {
    start_date: sdate,
    end_date: edate,
    question: quest,
    answers: answers
  };

  var poll_json = JSON.stringify(poll); // JSON객체를 문자열 변환.

  localStorage.setItem("poll", poll_json); // localStorage에 넣기.

  alert("투표를 생성합니다.");

  document.location.reload(); // 부모창 새로고침.
  $("#voteModal").modal("hide"); // 모달창 닫기.
}

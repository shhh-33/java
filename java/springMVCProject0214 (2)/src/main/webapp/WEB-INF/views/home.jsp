<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world! ${myname }</h1>
    <img alt="aa" src="resources/images/logo.png">
    <button id="btnPopup">Popup가운데띄우기</button>
	<P>The time on the server is ${serverTime}.</P>

	<!-- login창 열기  -->
	<a href="test/login">로그인가기1(상대경로이용)</a>
	<br>
	<a href="/education/test/login">로그인가기2(절대경로이용)</a>
	<br>
	<form action="test/login">
		<input type="submit" value="로그인가기3(Form이용)">
	</form>
	<hr>
	<form action="test/login" method="post">
		<input type="text" name="userid" value="sesac"><br> 
		<input type="text" name="userpass" value="aaaa"><br> 
		<input type="submit" value="로그인가기5(Form이용POST)">
	</form>
	<hr>
	<button id="btn1">로그인하기4(JS)</button>
	<hr>
	<form action="test/helloParam.do">
		<input type="text" name="userid" value="sesac"><br> 
		<input type="text" name="userpass" value="aaaa"><br> 
		  
		<input	type="submit" value="파라메터보내기">
	</form>






	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		//고전
		$(function() {
			$("#btn1").click(function() {
				//BOM(Brower Object Model):window,document,location,history,screen
				location.href = "test/login";
			});
			
			$("#btnPopup").click(function(){
				 
					 
				    var _width = '500';
				    var _height = '500';
				 
				    // 팝업을 가운데 위치시키기 위해 아래와 같이 값 구하기
				    var _left = Math.ceil(( window.screen.width - _width )/2);
				    var _top = Math.ceil(( window.screen.height - _height )/2); 
				 
				    aa=window.open('loginForm.jsp', 'popup-test', 'width='+ _width +', height='+ _height +', left=' + _left + ', top='+ _top );
				 
				    var x = 0;
				    var y = 0;
				    
				    //현재창의 가로,세로 크기를 구함
				    var w = $(window).outerWidth();
				    var h = $(window).outerHeight();
				    
				    //부모창 객체 선언
				    parentWin = window.opener;
				    
				    //부모창의 가로,세로 크기를 구함
				    var ww = $(parentWin).outerWidth();
				    var hh = $(parentWin).outerHeight();
				    
				    //부모창의 좌측상단 모서리의 x,y좌표를 구함
				    var pl = parentWin.screenLeft;
				    var pt = parentWin.screenTop;
				    
				    /*  
				    *중앙으로 위치 지정.
				    *부모창이 팝업창보다 클 경우에만 위치 세팅.
				    *계산은 가로의 중앙, 세로의 중앙을 구하고 팝업창의 크기를 절반으로 나눠서 중앙을 기준으로 상, 좌로 위치를 지정.
				    *부모창의 좌측상단 모서리의 좌표 위치를 더해주어 부모창을 기준으로 중앙에 위치시켜준다.
				    *단점: 모니터가 두개일 경우 브라우저를 다른 모니터로 옮긴상태에서는 정상작동이 되지 않음.
				     */
				    if( ww > w && hh > h ){
				     x = Number(ww)/2 - Number(w)/2 +pl;
				     y = Number(hh)/2 - Number(h)/2 + pt-90;
				    }
				    
				    //세팅된 위치로 이동 
				    aa.moveTo(x,y);
 
			});
		});
	</script>
</body>
</html>







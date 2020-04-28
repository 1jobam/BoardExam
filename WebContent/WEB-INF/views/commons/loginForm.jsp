<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">

<!-- 로그인폼 CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/commons/loginForm.css" >
<link rel="shortcut icon" type="image/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/800px-Apple_logo_black.svg.png">
<title>로그인 페이지</title>

</head>
<body class="login-page" style="min-height: 512.8px;">

<div class="login-box">
  <div class="login-logo">
    <a class="logo-nm" href="javascript:location.href='<%=request.getContextPath()%>/commons/loginForm.do'"><b>로그인</b>페이지</a>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">해당 사이트는 <br/> 로그인후 이용이 가능합니다.</p>

      <form action="/commons/login.do" method="post">
        <div class="input-group mb-3">
          <input type="text" name="id" class="form-control" placeholder="아이디" value="${param.id}">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" name="pwd" class="form-control" placeholder="패스워드">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-5">
              <button type="button" class="btn btn-primary btn-block" onclick="javascript:location.href='/commons/registForm.do'" >회원가입</button>
          </div>
          <!-- /.col -->
          <div class="col-7">
            <button type="submit" class="btn btn-primary btn-block">로그인</button>
          </div>
          <!-- /.col -->
        </div>
      </form>

	  <p class="mb-2">
        <a href="#">아이디 / 비밀번호 찾기</a>
      </p>
    </div>
    <!-- /.login-card-body -->
  </div>
</div>

<!-- jQuery -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>

<script>
	var message = "${msg}";
	if(message != ""){
		alert(message);		
	}
	<% session.removeAttribute("msg"); %>
</script>
</body>
</html>
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

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/commons/registForm.css" >
<link rel="shortcut icon" type="image/x-icon" href="https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/800px-Apple_logo_black.svg.png">


<title>회원가입 페이지</title>
<body class="register-page" style="min-height: 586.8px;">
	<div class="register-box">
	  <div class="register-logo">
	    <a href="/commons/registForm.do"><b>회원가입</b></a>
	  </div>
	
	  <div class="card">
	    <div class="card-body register-card-body">
	      <p class="login-box-msg">회원가입 진행에 감사드립니다.</p>
	
	      <form action="../../index.html" method="post">
	        <div class="input-group mb-3">
	          <input type="text" class="form-control" placeholder="이름">
	          <div class="input-group-append">
	            <div class="input-group-text">
	              <span class="fas fa-user"></span>
	            </div>
	          </div>
	        </div>
	        <div class="input-group mb-3">
	          <input type="email" class="form-control" placeholder="이메일">
	          <div class="input-group-append">
	            <div class="input-group-text">
	              <span class="fas fa-envelope"></span>
	            </div>
	          </div>
	        </div>
	        <div class="input-group mb-3">
	          <input type="password" class="form-control" placeholder="패스워드">
	          <div class="input-group-append">
	            <div class="input-group-text">
	              <span class="fas fa-lock"></span>
	            </div>
	          </div>
	        </div>
	        <div class="input-group mb-3">
	          <input type="password" class="form-control" placeholder="패스워드 확인">
	          <div class="input-group-append">
	            <div class="input-group-text">
	              <span class="fas fa-lock"></span>
	            </div>
	          </div>
	        </div>
	        <div class="row">
	          <div class="col-8">
	            <div class="icheck-primary">
	              <input type="checkbox" id="agreeTerms" name="terms" value="agree">
	              <label for="agreeTerms">
	               	가입동의 <a href="#">동의사항</a>
	              </label>
	            </div>
	          </div>
	          <!-- /.col -->
	          <div class="col-4">
	            <button type="submit" class="btn btn-primary btn-block">회원가입</button>
	          </div>
	          <!-- /.col -->
	        </div>
	      </form>
	
	      <a href="/commons/loginForm.do" class="text-center">로그인 페이지로 이동</a>
	    </div>
	    <!-- /.form-box -->
	  </div><!-- /.card -->
	</div>
	<!-- /.register-box -->

<!-- jQuery -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>

</body>

</html>
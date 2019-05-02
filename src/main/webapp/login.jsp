<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>欢迎登录易货二手交易平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/login2.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="webapp_js/login.js"></script>

</head>
<body>
	<h1 style="color: #4BC0A5">
		易货二手交易平台<sup>2019</sup>
	</h1>

	<div class="login" style="margin-top: 50px;">

		<div class="header">
			<div class="switch" id="switch">
				<a class="switch_btn_focus" id="switch_qlogin"
					href="javascript:void(0);" tabindex="7">快速登录</a> <a
					class="switch_btn" id="switch_login" href="javascript:void(0);"
					tabindex="8">快速注册</a>
				<div class="switch_bottom" id="switch_bottom"
					style="position: absolute; width: 64px; left: 0px;"></div>
			</div>
		</div>


		<div class="web_qr_login" id="web_qr_login"
			style="display: block; height: 235px;">

			<!--登录-->
			<div class="web_login" id="web_login">
				<div class="login-box">
					<div class="login_form">
						<div id="loginCue" class="cue">欢迎登陆</div>

						<form action="loginServlet.action" name="loginform"
							accept-charset="utf-8" id="login_form" class="loginForm"
							method="get">
							<input type="hidden" name="did" value="0" /> <input type="hidden"
								name="to" value="log" /> <input type="hidden" name="flag"
								value="3" />
							<div class="uinArea" id="uinArea">
								<label class="input-tips" for="id">学号：</label>
								<div class="inputOuter" id="uArea">

									<input type="text" id="id" name="uid" class="inputstyle"
										value="${uid}" />
								</div>
							</div>
							<div class="pwdArea" id="pwdArea">
								<label class="input-tips" for="pwd">密码：</label>
								<div class="inputOuter" id="pArea">

									<input type="password" id="pwd" name="pwd" class="inputstyle" />
								</div>
							</div>

							<div style="padding-left: 50px; margin-top: 20px;">
								<button id="login_button" type="submit"
									style="width: 150px;" class="button_blue" >登录按钮</button>
								<!-- <input id="login_button"type="submit" value="登 录" style="width:150px;" class="button_blue"/> -->
							</div>
						</form>
					</div>

				</div>

			</div>
			<!--登录end-->
		</div>

		<!--注册-->
		<div class="qlogin" id="qlogin" style="display: none;">

			<div class="web_login">
				<form name="form2" id="regForm" accept-charset="utf-8"
					action="regServlet.action" method="post">
					<input type="hidden" name="to" value="reg" /> <input type="hidden"
						name="did" value="0" /> <input type="hidden" name="flag" value="2" />
					<ul class="reg_form" id="reg-ul">
						<div id="userCue" class="cue">快速注册请注意格式</div>
						<li><label for="user" class="input-tips2">学号：</label>
							<div class="inputOuter2">
								<input type="text" id="userid" name="userid" maxlength="16"
									class="inputstyle2" />
							</div></li>

						<li><label for="passwd" class="input-tips2">密码：</label>
							<div class="inputOuter2">
								<input type="password" id="password" name="password"
									maxlength="16" class="inputstyle2" />
							</div></li>
						<li><label for="passwd2" class="input-tips2">确认密码：</label>
							<div class="inputOuter2">
								<input type="password" id="password2" name="" maxlength="16"
									class="inputstyle2" />
							</div></li>

						<li><label for="qq" class="input-tips2">QQ：</label>
							<div class="inputOuter2">

								<input type="text" id="qq" name="qq" maxlength="10"
									class="inputstyle2" />
							</div></li>

						<li>
							<div class="inputArea">
								<input type="button" id="reg_button"
									style="margin-top: 10px; margin-left: 85px;"
									class="button_blue"
									value="&nbsp;&nbsp;&nbsp;&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;&nbsp;&nbsp;&nbsp;" />
							</div>

						</li>
						<div class="cl"></div>
					</ul>
				</form>


			</div>


		</div>
		<!--注册end-->
	</div>
	<div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>
</body>

</html>
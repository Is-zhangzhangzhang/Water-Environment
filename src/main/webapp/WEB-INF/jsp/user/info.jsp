<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style type="text/css">
.show{
	display:block;
}
.userinfo-head{
	width:100px;
	height:40px;
	line-height:40px;
	margin:0;
	margin-top:30px;
	padding:0;
	text-align:center;
	display:inline-block;
	border:3px solid #EEE9E9;
	border-bottom:0px;
	background-color:white;
}
.userinfo-title{
	text-decoration:none;
}
.userinfo-title:link{
	text-decoration:none;
}
.userinfo-title:visited{
	text-decoration:none;
}
.userinfo-title:hover{
	text-decoration:none;
}
.userinfo-title:active{
	text-decoration:none;
}

</style>

<c:if test="${not empty user}">
<form class="info-form" onsubmit="return check(this)" modelAttribute="user">
	<div>
		<div class="userinfo-head" onclick="show_content(this)">
			<a href="javascript:;" class="userinfo-title">修改个人信息</a>
		</div><div class="userinfo-head" onclick="show_content(this)">
			<a href="javascript:;" class="userinfo-title">修改密码</a>
		</div>
	</div>
	<div style="border-top:3px solid #EEE9E9">
		<div id="userinfo-content0">
				<h3></h3>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9 show">全名:</label>
					<div class="input-icon">
						<i class="fa fa-font"></i>
						<input class="form-control placeholder-no-fix" type="text" placeholder="${user.userRealname}" value="${user.userRealname}" name="userRealname"/>
					</div>
				</div>
				<div class="form-group">
					<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
					<label class="control-label visible-ie8 visible-ie9 show">Email:</label>
					<div class="input-icon">
						<i class="fa fa-envelope"></i>
						<input class="form-control placeholder-no-fix" type="text" placeholder="${user.userEmail}" value="${user.userEmail}" name="userEmail"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9 show">地址:</label>
					<div class="input-icon">
						<i class="fa fa-check"></i>
						<input class="form-control placeholder-no-fix" type="text" placeholder="${user.userAddress}" value="${user.userAddress}" name="userAddress"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9 show">城市:</label>
					<div class="input-icon">
						<i class="fa fa-location-arrow"></i>
						<input class="form-control placeholder-no-fix" type="text" placeholder="${user.userCity}" value="${user.userCity}" name="userCity"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9 show">国家:</label>
					<select name="userCountry" id="select2_sample4" class="select2 form-control" onchange="change_country(this)">
						<option value=""></option>
						<option value="AF">Afghanistan</option>
						<option value="AL">Albania</option>
						<option value="DZ">Algeria</option>
						<option value="AS">American Samoa</option>
						<option value="AD">Andorra</option>
						<option value="AO">Angola</option>
						<option value="AI">Anguilla</option>
						<option value="AQ">Antarctica</option>
						<option value="AR">Argentina</option>
						<option value="AM">Armenia</option>
						<option value="AW">Aruba</option>
						<option value="AU">Australia</option>
						<option value="AT">Austria</option>
						<option value="AZ">Azerbaijan</option>
						<option value="BS">Bahamas</option>
						<option value="BH">Bahrain</option>
						<option value="BD">Bangladesh</option>
						<option value="BB">Barbados</option>
						<option value="BY">Belarus</option>
						<option value="BE">Belgium</option>
						<option value="BZ">Belize</option>
						<option value="BJ">Benin</option>
						<option value="BM">Bermuda</option>
						<option value="BT">Bhutan</option>
						<option value="BO">Bolivia</option>
						<option value="BA">Bosnia and Herzegowina</option>
						<option value="BW">Botswana</option>
						<option value="BV">Bouvet Island</option>
						<option value="BR">Brazil</option>
						<option value="IO">British Indian Ocean Territory</option>
						<option value="BN">Brunei Darussalam</option>
						<option value="BG">Bulgaria</option>
						<option value="BF">Burkina Faso</option>
						<option value="BI">Burundi</option>
						<option value="KH">Cambodia</option>
						<option value="CM">Cameroon</option>
						<option value="CA">Canada</option>
						<option value="CV">Cape Verde</option>
						<option value="KY">Cayman Islands</option>
						<option value="CF">Central African Republic</option>
						<option value="TD">Chad</option>
						<option value="CL">Chile</option>
						<option value="CN">China</option>
						<option value="CX">Christmas Island</option>
						<option value="CC">Cocos (Keeling) Islands</option>
						<option value="CO">Colombia</option>
						<option value="KM">Comoros</option>
						<option value="CG">Congo</option>
						<option value="CD">Congo, the Democratic Republic of the</option>
						<option value="CK">Cook Islands</option>
						<option value="CR">Costa Rica</option>
						<option value="CI">Cote d'Ivoire</option>
						<option value="HR">Croatia (Hrvatska)</option>
						<option value="CU">Cuba</option>
						<option value="CY">Cyprus</option>
						<option value="CZ">Czech Republic</option>
						<option value="DK">Denmark</option>
						<option value="DJ">Djibouti</option>
						<option value="DM">Dominica</option>
						<option value="DO">Dominican Republic</option>
						<option value="EC">Ecuador</option>
						<option value="EG">Egypt</option>
						<option value="SV">El Salvador</option>
						<option value="GQ">Equatorial Guinea</option>
						<option value="ER">Eritrea</option>
						<option value="EE">Estonia</option>
						<option value="ET">Ethiopia</option>
						<option value="FK">Falkland Islands (Malvinas)</option>
						<option value="FO">Faroe Islands</option>
						<option value="FJ">Fiji</option>
						<option value="FI">Finland</option>
						<option value="FR">France</option>
						<option value="GF">French Guiana</option>
						<option value="PF">French Polynesia</option>
						<option value="TF">French Southern Territories</option>
						<option value="GA">Gabon</option>
						<option value="GM">Gambia</option>
						<option value="GE">Georgia</option>
						<option value="DE">Germany</option>
						<option value="GH">Ghana</option>
						<option value="GI">Gibraltar</option>
						<option value="GR">Greece</option>
						<option value="GL">Greenland</option>
						<option value="GD">Grenada</option>
						<option value="GP">Guadeloupe</option>
						<option value="GU">Guam</option>
						<option value="GT">Guatemala</option>
						<option value="GN">Guinea</option>
						<option value="GW">Guinea-Bissau</option>
						<option value="GY">Guyana</option>
						<option value="HT">Haiti</option>
						<option value="HM">Heard and Mc Donald Islands</option>
						<option value="VA">Holy See (Vatican City State)</option>
						<option value="HN">Honduras</option>
						<option value="HK">Hong Kong</option>
						<option value="HU">Hungary</option>
						<option value="IS">Iceland</option>
						<option value="IN">India</option>
						<option value="ID">Indonesia</option>
						<option value="IR">Iran (Islamic Republic of)</option>
						<option value="IQ">Iraq</option>
						<option value="IE">Ireland</option>
						<option value="IL">Israel</option>
						<option value="IT">Italy</option>
						<option value="JM">Jamaica</option>
						<option value="JP">Japan</option>
						<option value="JO">Jordan</option>
						<option value="KZ">Kazakhstan</option>
						<option value="KE">Kenya</option>
						<option value="KI">Kiribati</option>
						<option value="KP">Korea, Democratic People's Republic of</option>
						<option value="KR">Korea, Republic of</option>
						<option value="KW">Kuwait</option>
						<option value="KG">Kyrgyzstan</option>
						<option value="LA">Lao People's Democratic Republic</option>
						<option value="LV">Latvia</option>
						<option value="LB">Lebanon</option>
						<option value="LS">Lesotho</option>
						<option value="LR">Liberia</option>
						<option value="LY">Libyan Arab Jamahiriya</option>
						<option value="LI">Liechtenstein</option>
						<option value="LT">Lithuania</option>
						<option value="LU">Luxembourg</option>
						<option value="MO">Macau</option>
						<option value="MK">Macedonia, The Former Yugoslav Republic of</option>
						<option value="MG">Madagascar</option>
						<option value="MW">Malawi</option>
						<option value="MY">Malaysia</option>
						<option value="MV">Maldives</option>
						<option value="ML">Mali</option>
						<option value="MT">Malta</option>
						<option value="MH">Marshall Islands</option>
						<option value="MQ">Martinique</option>
						<option value="MR">Mauritania</option>
						<option value="MU">Mauritius</option>
						<option value="YT">Mayotte</option>
						<option value="MX">Mexico</option>
						<option value="FM">Micronesia, Federated States of</option>
						<option value="MD">Moldova, Republic of</option>
						<option value="MC">Monaco</option>
						<option value="MN">Mongolia</option>
						<option value="MS">Montserrat</option>
						<option value="MA">Morocco</option>
						<option value="MZ">Mozambique</option>
						<option value="MM">Myanmar</option>
						<option value="NA">Namibia</option>
						<option value="NR">Nauru</option>
						<option value="NP">Nepal</option>
						<option value="NL">Netherlands</option>
						<option value="AN">Netherlands Antilles</option>
						<option value="NC">New Caledonia</option>
						<option value="NZ">New Zealand</option>
						<option value="NI">Nicaragua</option>
						<option value="NE">Niger</option>
						<option value="NG">Nigeria</option>
						<option value="NU">Niue</option>
						<option value="NF">Norfolk Island</option>
						<option value="MP">Northern Mariana Islands</option>
						<option value="NO">Norway</option>
						<option value="OM">Oman</option>
						<option value="PK">Pakistan</option>
						<option value="PW">Palau</option>
						<option value="PA">Panama</option>
						<option value="PG">Papua New Guinea</option>
						<option value="PY">Paraguay</option>
						<option value="PE">Peru</option>
						<option value="PH">Philippines</option>
						<option value="PN">Pitcairn</option>
						<option value="PL">Poland</option>
						<option value="PT">Portugal</option>
						<option value="PR">Puerto Rico</option>
						<option value="QA">Qatar</option>
						<option value="RE">Reunion</option>
						<option value="RO">Romania</option>
						<option value="RU">Russian Federation</option>
						<option value="RW">Rwanda</option>
						<option value="KN">Saint Kitts and Nevis</option>
						<option value="LC">Saint LUCIA</option>
						<option value="VC">Saint Vincent and the Grenadines</option>
						<option value="WS">Samoa</option>
						<option value="SM">San Marino</option>
						<option value="ST">Sao Tome and Principe</option>
						<option value="SA">Saudi Arabia</option>
						<option value="SN">Senegal</option>
						<option value="SC">Seychelles</option>
						<option value="SL">Sierra Leone</option>
						<option value="SG">Singapore</option>
						<option value="SK">Slovakia (Slovak Republic)</option>
						<option value="SI">Slovenia</option>
						<option value="SB">Solomon Islands</option>
						<option value="SO">Somalia</option>
						<option value="ZA">South Africa</option>
						<option value="GS">South Georgia and the South Sandwich Islands</option>
						<option value="ES">Spain</option>
						<option value="LK">Sri Lanka</option>
						<option value="SH">St. Helena</option>
						<option value="PM">St. Pierre and Miquelon</option>
						<option value="SD">Sudan</option>
						<option value="SR">Suriname</option>
						<option value="SJ">Svalbard and Jan Mayen Islands</option>
						<option value="SZ">Swaziland</option>
						<option value="SE">Sweden</option>
						<option value="CH">Switzerland</option>
						<option value="SY">Syrian Arab Republic</option>
						<option value="TW">Taiwan, Province of China</option>
						<option value="TJ">Tajikistan</option>
						<option value="TZ">Tanzania, United Republic of</option>
						<option value="TH">Thailand</option>
						<option value="TG">Togo</option>
						<option value="TK">Tokelau</option>
						<option value="TO">Tonga</option>
						<option value="TT">Trinidad and Tobago</option>
						<option value="TN">Tunisia</option>
						<option value="TR">Turkey</option>
						<option value="TM">Turkmenistan</option>
						<option value="TC">Turks and Caicos Islands</option>
						<option value="TV">Tuvalu</option>
						<option value="UG">Uganda</option>
						<option value="UA">Ukraine</option>
						<option value="AE">United Arab Emirates</option>
						<option value="GB">United Kingdom</option>
						<option value="US">United States</option>
						<option value="UM">United States Minor Outlying Islands</option>
						<option value="UY">Uruguay</option>
						<option value="UZ">Uzbekistan</option>
						<option value="VU">Vanuatu</option>
						<option value="VE">Venezuela</option>
						<option value="VN">Viet Nam</option>
						<option value="VG">Virgin Islands (British)</option>
						<option value="VI">Virgin Islands (U.S.)</option>
						<option value="WF">Wallis and Futuna Islands</option>
						<option value="EH">Western Sahara</option>
						<option value="YE">Yemen</option>
						<option value="ZM">Zambia</option>
						<option value="ZW">Zimbabwe</option>
					</select>
				</div>
		</div>
		
		<div id="userinfo-content1">
				<h3></h3>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9 show">旧密码:</label>
					<div class="input-icon">
						<i class="fa fa-lock"></i>
						<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="旧密码" name="oldPassword"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9 show">新密码:</label>
					<div class="input-icon">
						<i class="fa fa-lock"></i>
						<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="新密码" name="newPassword"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label visible-ie8 visible-ie9 show">确认密码:</label>
					<div class="controls">
						<div class="input-icon">
							<i class="fa fa-check"></i>
							<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="再次输入新密码" name="rPassword"/>
						</div>
					</div>
				</div>
		</div>
	</div>
	
	<div class="form-actions">
		<button type="submit" id="update-submit-btn" class="btn blue pull-right">
			修改 <i class="m-icon-swapright m-icon-white"></i>
		</button>
	</div>
</form>
			
<script src="app/lib/security/sha256.js" type="text/javascript"></script>
<script>
	function show_content(selectedHead){
		var heads = document.getElementsByClassName("userinfo-head");
		for(var i = 0; i < heads.length; i++){
			if(heads[i] == selectedHead){
				heads[i].style.backgroundColor = "#EEE9E9";
				document.getElementById("userinfo-content" + i).style.display = "block";
				
				if(i == 0){
					document.getElementsByName("oldPassword")[0].value = "";
					document.getElementsByName("newPassword")[0].value = "";
					document.getElementsByName("rPassword")[0].value = "";
				}
			}
			else{
				heads[i].style.backgroundColor = "white";
				document.getElementById("userinfo-content" + i).style.display = "none";
			}
		}
	}
	
	function user_info(){
		$.get("user/info", function(data){
			$('#main-content').html(data);
	        if(url.indexOf("dashboard") == -1){
	            $("#main-navbar").removeAttr("hidden");
	        }else{
	            $("#main-navbar").attr("hidden","hidden");
	        }
		})
	}
	
	function jump(){
		window.location.href="login";
	}
	
	function check(form){
		var realname = document.getElementsByName("userRealname")[0].value;
		var email = document.getElementsByName("userEmail")[0].value;
		var address = document.getElementsByName("userAddress")[0].value;
		var city = document.getElementsByName("userCity")[0].value;
		var country = document.getElementsByName("userCountry")[0].value;
		var oldPassword = document.getElementsByName("oldPassword")[0].value;
		var newPassword = document.getElementsByName("newPassword")[0].value;
		var rPassword = document.getElementsByName("rPassword")[0].value;
		var tips = "";
		var isLegal = true;
		
		if(document.getElementById("userinfo-content0").style.display == "block"){
			var emailRegex = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;
			if(email.length != 0){
				if(!emailRegex.test(email)){
					tips = "email地址格式不符合要求！";
					isLegal = false;
				}
			}
			
			if(isLegal){
				$.post(
					"user/update",
					{
						userRealname:realname,
						userEmail:email,
						userAddress:address,
						userCity:city,
						userCountry:country,
					},
					function(data){
						data = data.trim();
						showResult(data);
					}
				);
			}
		}
		else{
			if(oldPassword.length != 0 && newPassword.length != 0 && rPassword.length != 0){
				if(newPassword == rPassword){
					oldPassword = sha256_digest(oldPassword);
					newPassword = sha256_digest(newPassword);
				}
				else{
					tips = "新密码和确认密码不一致！";
					isLegal = false;
				}
			}
			else{
				tips = "旧密码、新密码、确认密码三者都不能为空！";
				isLegal = false;
			}
			
			if(isLegal){
				$.post(
					"user/modifyPassword",
					{
						newPassword:newPassword,
						oldPassword:oldPassword,
					},
					function(data){
						data = data.trim();
						showResult(data);
					}
				);
			}
		}
	
		if(!isLegal){
			var html = "<div style='text-align:center'>"
					+ "<h3>" + tips + "</h3>"
					+ "<input type='button' value='返回' onclick='user_info()'>";
			$("#main-content").html(html);
		}
		
		return false;
	}
	
	function showResult(data){
		var click = "user_info()";
		
		if(data == "ok"){
			tips = "修改成功！";
		}
		else if(data == "no"){
			tips = "修改失败！";
		}
		else if(data == "op wrong"){
			tips = "旧密码错误！";
		}
		else if(data == "no user"){
			tips = "用户未登录！";
			click = "jump()";
		}
		else{
			tips = "未知错误！";
			click = "jump()";
		}
		
		var html = "<div style='text-align:center'>"
			+ "<h3>" + tips + "</h3>"
			+ "<input type='button' value='确定' onclick='" + click + "'>";
		$("#main-content").html(html);
	}
	
	function change_country(select){
		select.value = select.options[select.selectedIndex].value;
	}
	
	$(document).ready(function(e){
		$("#select2_sample4").val("${user.userCountry}");
		
		var heads = document.getElementsByClassName("userinfo-head");
		show_content(heads[0]);
	})
</script>

</c:if>

<c:if test="${empty user}">
	<div style='text-align:center;'>
		<h3>页面超时或用户未登录</h3>
		<input type='button' onclick='jump()' value='确定'>
	</div>
	
	<script type='text/javascripte'>
		function jump(){
			window.location.href="login";
		}
	</script>
</c:if>
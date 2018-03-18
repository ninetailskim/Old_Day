$(function()
{
	$(".errorClass").each(function(){
		showerror($(this));
	});
	$("#submitBtn").hover(
			function(){
				$("#submitBtn").attr("src","/WEBCLASS/image/regist2.jpg");
			},
			function()
			{
				$("#submitBtn").attr("src","/WEBCLASS/image/regist1.jpg");
			}
	);
	$(".inputClass").focus(function(){
		var labelid = $(this).attr("id") + "Error";
		$("#" + labelid).text("");
		showerror($("#" + labelid));
	});
	
	$(".inputClass").blur(function(){
		var id = $(this).attr("id");
		var funName = "validate" + id + "()";
		eval(funName);
		
	});
	
	$("#registForm").submit(function(){
		var bool = true;
		//alert("first " + bool);
		if(!validateloginname())
		{
		bool = false;
		}
		//alert("validateloginname() " + bool);
		if(!validateloginpass())
		{
		bool = false;
		}
		//alert("validateloginpass() " + bool);
		if(!validatereloginpass())
		{
		bool = false;
		}
		//alert("validatereloginpass() " + bool);
		if(!validateemail())
		{
		bool = false;
		}
		//alert("validateemail() " + bool);
		if(!validateident())
		{
		bool = false;
		}
		//alert("validateident() " + bool);
		if(!validateverifyCode())
		{
		bool = false;
		}
		//alert("validateverifyCode() " + bool);
		return bool;
	});
});

function validateloginname()
{
	var id = "loginname";
	var value = $("#" + id).val();
	if(!value){
		$("#" + id + "Error").text("用户名为空！");
		showerror($("#" + id + "Error"));
		return false;
	}
	if(value.length > 20)
	{
		$("#" + id + "Error").text("用户名长度应该在20之间");
		showerror($("#" + id + "Error"));
		false;
	}
	$.ajax({
		url:"/WEBCLASS/UserServlet",
		data:{method:"ajaxvalidateloginname",loginname:value},
		type:"POST",
		dataType:"json",
		async:false,
		cache:false,
		success:function(result)
		{
			if(!result){
				$("#" + id + "Error").text("用户已被注册");
				showerror($("#" + id + "Error"));
				return false;
			}
		}
	});
	return true;
}

function validateloginpass()
{
	var id = "loginpass";
	var value = $("#" + id).val();
	if(!value){
		$("#" + id + "Error").text("密码不能为空");
		showerror($("#" + id + "Error"));
		return false;
	}
	return true;
}

function validatereloginpass()
{
	var id = "reloginpass";
	var value = $("#" + id).val();
	if(!value){
		$("#" + id + "Error").text("确认密码不能为空");
		showerror($("#" + id + "Error"));
		return false;
	}
	if(value != $("#loginpass").val())
	{
		$("#" + id + "Error").text("两次密码不同");
		showerror($("#" + id + "Error"));
		false;
	}
	return true;
}

function validateemail()
{
	var id = "email";
	var value = $("#" + id).val();
	if(!value){
		$("#" + id + "Error").text("邮箱不能为空");
		showerror($("#" + id + "Error"));
		return false;
	}
	if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(value)) {
		$("#" + id + "Error").text("错误的Email格式！");
		showerror($("#" + id + "Error"));
		false;
	}
	return true;
}

function validateverifyCode()
{
	var id = "verifyCode";
	var value = $("#" + id).val();
	if(!value){
		$("#" + id + "Error").text("验证码不能为空");
		showerror($("#" + id + "Error"));
		return false;
	}
	$.ajax({
		url:"/WEBCLASS/UserServlet",
		data:{method:"ajaxvalidateverifyCode",verifyCode:value},
		type:"POST",
		dataType:"json",
		async:false,
		cache:false,
		success:function(result)
		{
			if(!result){
				$("#" + id + "Error").text("验证码错误");
				showerror($("#" + id + "Error"));
				return false;
			}
		}
	});
	return true;
}

function validateident()
{
	var id = "ident";
	var value = $("#" + id).val();
	if(!value){
		$("#" + id + "Error").text("身份为空！");
		showerror($("#" + id + "Error"));
		return false;
	}
	return true;
}

function showerror(e)
{
	var text = e.text();
	
	if(!text)
	{
		e.css("display","none");
	}
	else
	{
		e.css("display","");
	}
}

function _hyz()
{
	$("#imgVerifyCode").attr("src","/WEBCLASS/VerifyCodeServlet?a=" + new Date().getTime());
}

$(function()
{
	$(".errorClass").each(function(){
		showerror($(this));
	});
	
	$("#submitBtn").hover(
			function(){
				$("#submitBtn").attr("src","/WEBCLASS/image/login2.jpg");
			},
			function()
			{
				$("#submitBtn").attr("src","/WEBCLASS/image/login1.jpg");
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
	
	$("#loginForm").submit(function(){
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
	if(value.length < 5 || value.length > 20)
	{
		$("#" + id + "Error").text("用户名长度应该在5~20之间");
		showerror($("#" + id + "Error"));
		false;
	}
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

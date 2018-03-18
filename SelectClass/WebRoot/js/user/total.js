/*$(function(){
	var va = $(".inputarea").text();
	if(val == "点此输入公告")
	{
		$(this).css("fontColor","#d0d0d0");
	}
	$(".inputarea").focus(function(){
		alert(1);
		var val = $(this).text();
		if(val == "点此输入公告")
		{
			$(this).text("");
		}
	});
	
	$(".inputarea").blur(function(){
		alert(2);
		var id = $(this).attr("id");
		var funName = "text" + id + "()";
		eval(funName);
	});	
});*/

$(function(){
			$(".inputarea").focus(function(){
				//alert(1);
				//var val = $(this).text();
				$("." + inputarea).value("点此输入公告");
				//if(val == "点此输入公告")
					//$(this).text("");	
				//alert(11);
			});
			
			$(".inputarea").blur(function(){
				//alert(2);
				var id = $(this).attr("class");
				var funName = "text" + id + "()";
				eval(funName);
			});
});

function textinputarea()
{
	//alert(3);
	var id = "inputarea";
	var value = $("." + id).val();
	if(!vaue)
		$("." + inputarea).text("点此输入公告");
	$.ajax({
		url:"/WEBCLASS/UserServlet",
		data:{method:"ajaxdif",inputarea:value},
		type:"POST",
		dataType:"json",
		async:false,
		cache:false,
		success:function(result)
		{
			if(!result){
				$("." + id + "Error").text("验证码错误");
				showerror($("." + id + "Error"));
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

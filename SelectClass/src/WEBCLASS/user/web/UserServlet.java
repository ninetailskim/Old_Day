package WEBCLASS.user.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import WEBCLASS.user.service.UserService;
import WEBCLASS.user.domain.*;

import cn.itcast.servlet.BaseServlet;

public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	
	public String regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("rigist。。。。。。");
			User tempuser = new User(); 
			tempuser.setUserName(request.getParameter("loginname"));
			tempuser.setUserPassword(request.getParameter("loginpass"));
			if(request.getParameter("ident").equals("student"))
				tempuser.setUserIdent(1);
			else if(request.getParameter("ident").equals("teacher"))
				tempuser.setUserIdent(2);
			tempuser.setEmail(request.getParameter("email"));
			//boolean b = 
					userService.regist(tempuser);
			//if(b)
			return "f:/jsps/user/registsuccess.jsp";
	}
	
	public String publish(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("publish。。。。。。");
			String inputarea = request.getParameter("inputarea");
			String loginname = request.getParameter("loginname");
			System.out.println(inputarea + "sevlet");
			System.out.println(loginname + "sevlet");
			System.out.println(request.getParameter("classId"));
			int cid = Integer.parseInt(request.getParameter("classId").substring(3));
			System.out.println(cid);
			System.out.println(inputarea + "UserServlet");
			boolean b = userService.publish(inputarea,cid);
			response.getWriter().print(!b);
			System.out.println(b);	
			return "r:/jsps/user/publish.jsp?loginname=" + loginname;
	}
	
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("login。。。。。。");
			String loginname = request.getParameter("loginname");
			String password = request.getParameter("loginpass");
			System.out.println(loginname + "UserServlet");
			boolean b = userService.login(loginname,password);
			if(b)
			{
				System.out.println(loginname + "success");
				return "r:/jsps/user/trans.jsp?bool=" + b +"&loginname=" + loginname;
			}
			else
			{	
				System.out.println(loginname + "faliure");
				return "f:/jsps/user/trans.jsp?loginname=" + loginname;
			}
	}
	
	public String hwrelease(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("release。。。。。。");
			String loginname = request.getParameter("loginname");
			String classId = request.getParameter("classId").substring(3);
			String hwName = request.getParameter("hwname");
			System.out.println(loginname + "UserServlet");
			boolean b = userService.hwrelease(loginname,classId,hwName);
			System.out.println(loginname + "success");
			return "r:/jsps/user/homework.jsp?bool=" + b +"&loginname=" + loginname;
			
	}

	public String ajaxvalidateloginname(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ajaxvalidateloginname。。。。。。");
		String loginname = request.getParameter("loginname");
		System.out.println(loginname + "UserServlet");
		boolean b = userService.ajaxvalidateloginname(loginname);
		response.getWriter().print(b);
		System.out.println(b);	
			return null;
	}
	
	public String ajaxvalidateverifyCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ajaxvalidateverifyCode。。。。。。");
			String verifycode = request.getParameter("verifyCode");
			
			String vcode = (String)request.getSession().getAttribute("vCode");
			
			boolean b = verifycode.equalsIgnoreCase(vcode);
			response.getWriter().print(b);
			System.out.println(b);
			return null;
	}

}
//62aae61d6d62d236be926e845ae4c4e4_9
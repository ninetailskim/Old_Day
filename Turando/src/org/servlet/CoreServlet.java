package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.*;
import org.util.*;

public class CoreServlet extends HttpServlet {

	private static final long serialVersionUID = 4440739483644821986L;
	/**
	 * Constructor of the object.
	 */
	public CoreServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String signature = request.getParameter("signature");
		
		String timestamp = request.getParameter("timestamp");
		
		String nonce = request.getParameter("nonce");
		
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		
//		File file = new File("c:\\test.txt");
//		
//		if(!file.exists()){
//			file.createNewFile();
//		}
//		
//		FileWriter fileWriter = new FileWriter(file.getName(),true);
//		BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
//		bufferWriter.write(request.toString());
//		bufferWriter.close();
		
		
		if(SignUtil.checkSignature(signature,timestamp,nonce)){
			out.print(echostr);
		}
		
		out.close();
		out = null;
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			request.setCharacterEncoding("UTF-8");
			
			response.setCharacterEncoding("UTF-8");
			
			String respMessage = CoreService.processRequest(request);
		
			PrintWriter out = response.getWriter();
			out.print(respMessage);
			out.close();
	}
	
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

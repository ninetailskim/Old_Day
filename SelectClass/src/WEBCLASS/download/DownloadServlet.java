package WEBCLASS.download;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import sun.misc.BASE64Encoder;

import WEBCLASS.upload.UpResc;
import WEBCLASS.upload.Upindatabase;

public class DownloadServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Upindatabase upindatabase = new Upindatabase();	
		
		
		String hwId = request.getParameter("hwId");
		String loginname = request.getParameter("loginname");
		System.out.println(hwId + "DownloadServlet");
		System.out.println(loginname + "DownloadServlet");
		UpResc upresc;
		try {
			upresc = upindatabase.upoutdatabase(hwId);
		} catch (Exception e) {
			throw new RuntimeException (e);
		}
		if(!upresc.getPathName().equals("No File")){
		String filename = upresc.getPathName();
		int index = filename.lastIndexOf("\\");
		if(index != -1)
		{
			filename = filename.substring(index + 1);
			System.out.println(filename);							
		}
		String framename = filenameEncoding(filename,request);
		System.out.println(framename);
		filename = upresc.getPathName();
		System.out.println(filename);
		String contentType = this.getServletContext().getMimeType(filename);//通过文件名称获取MIME类型
		System.out.println(contentType);
		String contentDisposition = "attachment;filename=" + framename;
		// 一个流
		FileInputStream input = new FileInputStream(filename);
		//设置头
		response.setHeader("Content-Type", contentType);
		response.setHeader("Content-Disposition", contentDisposition);
		// 获取绑定了响应端的流
		ServletOutputStream output = response.getOutputStream();
		
		IOUtils.copy(input, output);//把输入流中的数据写入到输出流中。
		
		input.close();
		output.close();
		}
		response.sendRedirect("/WEBCLASS/jsps/user/hwdownload.jsp?loginname=" + loginname);
		
		return;
	}
	
	// 用来对下载的文件名称进行编码的！
		public static String filenameEncoding(String filename, HttpServletRequest request) throws IOException {
			String agent = request.getHeader("User-Agent"); //获取浏览器
			if (agent.contains("Firefox")) {
				BASE64Encoder base64Encoder = new BASE64Encoder();
				filename = "=?utf-8?B?"
						+ base64Encoder.encode(filename.getBytes("utf-8"))
						+ "?=";
			} else if(agent.contains("MSIE")) {
				filename = URLEncoder.encode(filename, "utf-8");
			} else {
				filename = URLEncoder.encode(filename, "utf-8");
			}
			return filename;
		}

}

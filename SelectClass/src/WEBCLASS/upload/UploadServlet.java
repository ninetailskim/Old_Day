package WEBCLASS.upload;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class UploadServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Upindatabase upindatabase = new Upindatabase();	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset==utf-8");
		//创建工厂
		UpResc upresc = new UpResc();
		
				DiskFileItemFactory factory = new DiskFileItemFactory();
				String loginname;
				String hwId;
				//通过工厂创建解析器
				
				ServletFileUpload sfu = new ServletFileUpload(factory);
				
				//解析request，得到FileItem集合
				try{
					List<FileItem> fileItemList = sfu.parseRequest(request);
					String root = this.getServletContext().getRealPath("/WEB-INF/upload");
					//遍历FileItem集合，调用API，完成文件的保存
					FileItem fi0 = fileItemList.get(1);
					FileItem fi1 = fileItemList.get(0);
					FileItem fi2 = fileItemList.get(2);
					loginname = fi1.getString("UTF-8");
					hwId = fi0.getString("UTF-8");
					System.out.println(hwId);
					System.out.println(loginname + "uploadservlet");
							String filename = fi2.getName();
							int index = filename.lastIndexOf("\\");
							if(index != -1)
							{
								filename = filename.substring(index + 1);
								System.out.println(filename);
								System.out.println(root);								
							}
							File destFile = new File(root +"\\" + filename);
							fi2.write(destFile);
					upresc.setHwId(hwId);
					upresc.setUperId(loginname);
					upresc.setPathName(root +"\\" + filename);
					boolean b = upindatabase.upsetdatabase(upresc);
				}
				catch(FileUploadException e)
				{
					throw new RuntimeException (e);
				}
				catch(Exception e)
				{
					throw new RuntimeException (e);
				}
		response.sendRedirect("/WEBCLASS/jsps/user/homework.jsp?loginname=" + loginname);
		return;
	}
}

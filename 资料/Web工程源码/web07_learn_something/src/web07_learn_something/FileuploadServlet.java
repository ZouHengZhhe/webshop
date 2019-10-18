package web07_learn_something;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileuploadServlet
 */
@WebServlet("/FileuploadServlet")
public class FileuploadServlet extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item:list) {
//				//是否是普通输入项
				if(item.isFormField()) {
					System.out.println(item.getString("utf-8"));
				}else {
					//item是文件
					if(item.getInputStream().available()<=0) {
						continue;
					}
					
					String fileName = item.getName();
					fileName = fileName.substring(fileName.lastIndexOf("."));
					InputStream in = item.getInputStream();
					String path = this.getServletContext().getRealPath("/upload");
					String fullPath = path+"/"+new Date().getTime()+fileName;
					System.out.println(fullPath);
					FileOutputStream out = new FileOutputStream(fullPath);
					byte[] buffer = new byte[1024];
					int len = 0;
					while( (len=in.read(buffer))>0 ) {
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
					item.delete();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

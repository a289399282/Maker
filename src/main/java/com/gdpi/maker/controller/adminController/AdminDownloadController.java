package com.gdpi.maker.controller.adminController;

/*
import com.gdpi.maker.utilsmy.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@Controller
@RequestMapping(value="/admin/download")
public class AdminDownloadController {
	
	@RequestMapping(value="/forumVideo")
	public void down(HttpServletRequest request,HttpServletResponse response) {
		String filename = request.getParameter("file");
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename,"utf-8"));
			response.setContentType(request.getServletContext().getMimeType(filename));//MIME类型
			String load="D:\\Software\\TomCat\\resources\\maker\\video\\forumVideo\\"+filename;
			InputStream in = new FileInputStream(load);
			OutputStream out = response.getOutputStream();
			IOUtils.In2Out(in, out);
			IOUtils.close(in, null);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("下载错误!");
		}
		
	}
}
*/

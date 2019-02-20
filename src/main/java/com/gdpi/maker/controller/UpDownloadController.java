package com.gdpi.maker.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.uploadFileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpi.maker.utilsmy.IOUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/updownload")
public class UpDownloadController {

	@ResponseBody
	@RequestMapping(value="/forumVideo")
	public Result forumVideo(HttpServletRequest request, HttpServletResponse response) {
		String filename = request.getParameter("file");
		try {
			response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(filename,"utf-8"));
			response.setContentType(request.getServletContext().getMimeType(filename));//MIME类型
			String load=request.getSession().getServletContext().getRealPath("WEB-INF/user/video/forumVideo\"+filename");
			//String load="D:\\Software\\TomCat\\resources\\maker\\video\\forumVideo\\"+filename;
			InputStream in = new FileInputStream(load);
			OutputStream out = response.getOutputStream();
			IOUtils.In2Out(in, out);
			IOUtils.close(in, null);
		} catch (IOException e) {
			e.printStackTrace();
			//throw new RuntimeException("下载错误!");
			return ResultUtil.error("下载错误");
		}
		return ResultUtil.success(null,"下载成功");
	}

	@ResponseBody
	@RequestMapping(value="/forumImg")
	public String down(MultipartFile stuPic, HttpServletRequest request) {
		if (stuPic != null) {
				//调用方法上传图片到服务器上
				String imgDeveloper = uploadFileUtils.imgBuilder(stuPic,request);
				if(imgDeveloper !=null && imgDeveloper.length()!=0){
					return imgDeveloper;
				}
		}
		return null;
	}
}

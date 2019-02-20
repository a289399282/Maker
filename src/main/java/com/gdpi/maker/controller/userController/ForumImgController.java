package com.gdpi.maker.controller.userController;

import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.pojo.Forumimg;
import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.service.DeveloperService;
import com.gdpi.maker.service.ForumImgService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.DeleteFileUtil;
import com.gdpi.maker.utilsmy.MD5Utils;
import com.gdpi.maker.utilsmy.StringUtils;
import com.gdpi.maker.utilsmy.uploadFileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@SuppressWarnings("Duplicates")
@Controller
@RequestMapping(value="/forumImg")
public class ForumImgController {
	//@Qualifier("DaoImpl")        //实现类1的类名。注意区分与@Resource(name="dogImpl") 的区别。
	//@Autowired @Autowired 的注入方式是 byType 注入， 当要注入的类型在容器中存在多个时，Spring是不知道要引入哪个实现类的，所以会报错。

	@Resource(name="ForumImgServiceImpl")        //实现类1中 @Service注解中标定的名称
	private ForumImgService forumImgService;

	@ResponseBody
	@RequestMapping(value="/insertforumImg", method = RequestMethod.POST)
	public Result updateDevImg(MultipartFile forumPic,HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
		    //判断是否上传图片
			if(forumPic !=null){
				long size = forumPic.getSize();
				if (size <= 10485760) {
					//调用方法上传图片到服务器上
					String imgBuilder = uploadFileUtils.imgBuilder(forumPic, request);
					if(imgBuilder !=null){
						String rote="/Maker/user/img/forumImg/"+imgBuilder;
						Forumimg forumimg=new Forumimg();
						//设置图片名到developer对象里
						forumimg.setImgRoute(rote);
						forumimg.setImgAuthorid(developer.getDevId());
						forumimg.setImgSize((double) size);
						//调用方法更新开发人员的信息
						Result result = forumImgService.insertForumimg(forumimg);
						if (result.getCode()==1){
							return ResultUtil.success(null,rote);
						}else{
							DeleteFileUtil.deleteFile(imgBuilder, request);
						}
					}
				}
				return ResultUtil.error("图片上传大于10M");
			}
			//提示信息
			return ResultUtil.error("图片为空");
		}
		return ResultUtil.error("你还没登录,请你登录再试");
	}
}

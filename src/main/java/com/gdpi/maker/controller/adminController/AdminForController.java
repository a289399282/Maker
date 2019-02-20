package com.gdpi.maker.controller.adminController;

/*
import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.pojo.ForumWithBLOBs;
import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.service.ForumService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.StringUtils;
import com.gdpi.maker.utilsmy.uploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value="/admin/forum")
public class AdminForController {
	@Resource(name="AdminForumServiceImpl")
	private ForumService forumService;
	//上传文字作品
	@ResponseBody
	@RequestMapping(value="/addForText")
	public Result addForumText(HttpServletRequest request){
		Developer developer2=(Developer) request.getSession().getAttribute("developer");
		if (developer2!=null) {
			
			ForumWithBLOBs  forumWithBLOBs=new ForumWithBLOBs();
			
			String forumStart = request.getParameter("forumStart");
			String forumName = request.getParameter("forumName");
			String forumInfo = request.getParameter("forumInfo");
			String forumText = request.getParameter("forumText");
			String forumType = request.getParameter("forumType");
			forumWithBLOBs.setForumType(forumType);
			if (forumStart!=null) {
				int forumStart2 = Integer.parseInt(forumStart);
				forumWithBLOBs.setForumStart(forumStart2);
			}
			forumWithBLOBs.setForumInfo(forumInfo);
			forumWithBLOBs.setForumName(forumName);
			forumWithBLOBs.setForummemId(developer2.getDevId());
			forumWithBLOBs.setForumText(forumText);
			
			return forumService.addForum(forumWithBLOBs);
		}
		return ResultUtil.error("你还没登录,请登录再试");
	}
	//上传视频
	@ResponseBody
	@RequestMapping(value="/addForVideo")
	public Result addForumVideo(MultipartFile devVideo,HttpServletRequest request){
		Developer developer2=(Developer) request.getSession().getAttribute("developer");
		Map<String, String[]> parameterMap = request.getParameterMap();
		if (developer2!=null) {
			if (devVideo != null) {
				String forumName = request.getParameter("forumName");
				String forumInfo = request.getParameter("forumInfo");

				String forumStart = request.getParameter("forumStart");
				String forumType = request.getParameter("forumType");
				ForumWithBLOBs  forumWithBLOBs;

				String forumId;
				do {
					forumId= StringUtils.forumString();
					forumWithBLOBs=forumService.selectForumById(forumId);
				} while (forumWithBLOBs!=null);
				String string = uploadFileUtils.videoBuilder(devVideo, forumId,request);

				if (string!=null) {
					forumWithBLOBs=new ForumWithBLOBs();


					if (forumType != null && forumType.length()!=0) {
						forumWithBLOBs.setForumType(forumType);
					}

					if (forumStart!=null) {
						int forumStart2 = Integer.parseInt(forumStart);
						forumWithBLOBs.setForumStart(forumStart2);
					}
					if (forumInfo != null) {
						forumWithBLOBs.setForumInfo(forumInfo);
					}
					if (forumName != null) {
						forumWithBLOBs.setForumName(forumName);
					}

					forumWithBLOBs.setForumId(forumId);
					forumWithBLOBs.setForummemId(developer2.getDevId());

					return forumService.addForumVideo(forumWithBLOBs);
				}
				return ResultUtil.error("上传失败");
			}
			return ResultUtil.error("视频为空");
		}
		return ResultUtil.error("你还没登录,请登录再试");
	}
	
	//转发
	@ResponseBody
	@RequestMapping(value="/forwardFor")
	public Result forwardFor(String forumId,HttpServletRequest request){
		if (forumId!=null) {
			Developer developer=(Developer) request.getSession().getAttribute("developer");
			if (developer!=null) {
				ForumWithBLOBs  forumWithBLOBs=new ForumWithBLOBs();
				forumWithBLOBs.setForummemId(developer.getDevId());
				forumWithBLOBs.setForumForid(forumId);
				return forumService.addForum(forumWithBLOBs);
			}
			return ResultUtil.error("你还没登录,请登录再试");
		}
		return ResultUtil.error("forumId不能为空");
	}
	
	*/
/*
	@ResponseBody
	@RequestMapping(value="/deleteForum")
	public Result deleteForum(String forumId){
		return forumService.deleteForum(forumId);
	}*//*

	
	@ResponseBody
	@RequestMapping(value="/updateForum")
	public Result updateForum(HttpServletRequest request){
		String forumId = request.getParameter("forumId");
		if (forumId!=null) {
			Developer developer=(Developer) request.getSession().getAttribute("developer");
			if (developer!=null) {
				ForumWithBLOBs  forumWithBLOBs=new ForumWithBLOBs();
				
				String forumName = request.getParameter("forumName");
				String forumInfo = request.getParameter("forumInfo");
				String forumText = request.getParameter("forumText");
				String forumType = request.getParameter("forumType");
				forumWithBLOBs.setForumType(forumType);
				*/
/*String forumStart = request.getParameter("forumStart");
				
				if (forumStart!=null) {
					int forumStart2 = Integer.parseInt(forumStart);
					forumWithBLOBs.setForumStart(forumStart2);
				}*//*

				
				forumWithBLOBs.setForumName(forumName);
				forumWithBLOBs.setForumText(forumText);
				forumWithBLOBs.setForumInfo(forumInfo);
				
				forumWithBLOBs.setForummemId(developer.getDevId());
				forumWithBLOBs.setForumId(forumId);
				return forumService.updateForum(forumWithBLOBs);
			}
			return ResultUtil.error("你还没登录,请登录再试");
		}
		return ResultUtil.error("forumId不能为空");
	}
	
	@ResponseBody
	@RequestMapping(value="/updateForumStart")
	public Result updateForumStart(HttpServletRequest request){
		String forumId = request.getParameter("forumId");
		if (forumId!=null) {
			Developer developer=(Developer) request.getSession().getAttribute("developer");
			if (developer!=null) {
				ForumWithBLOBs  forumWithBLOBs=new ForumWithBLOBs();

				String forumStart = request.getParameter("forumStart");
				
				if (forumStart!=null) {
					int forumStart2 = Integer.parseInt(forumStart);
					forumWithBLOBs.setForumStart(forumStart2);
				}

				forumWithBLOBs.setForummemId(developer.getDevId());
				forumWithBLOBs.setForumId(forumId);
				return forumService.updateForumStart(forumWithBLOBs);
			}
			return ResultUtil.error("你还没登录,请登录再试");
		}
		return ResultUtil.error("forumId不能为空");
	}
	
	
	@ResponseBody
	@RequestMapping(value="/selectForum")
	public Result selectForum(@RequestParam(required = false,defaultValue = "5",value = "pageSize")Integer pageSize,
							  @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							  HttpServletRequest request){
		ForumWithBLOBs  forumWithBLOBs=new ForumWithBLOBs();
		
		String forummemId = request.getParameter("forummemId");
		String forumName = request.getParameter("forumName");
		String forumInfo = request.getParameter("forumInfo");
		String forumWhat = request.getParameter("forumWhat");
		String forumType = request.getParameter("forumType");
		forumWithBLOBs.setForumType(forumType);
		forumWithBLOBs.setForumWhat(Integer.parseInt(forumWhat));
		forumWithBLOBs.setForummemId(forummemId);
		forumWithBLOBs.setForumInfo(forumInfo);
		forumWithBLOBs.setForumName(forumName);
		
		return forumService.selectForum(forumWithBLOBs,fenye,pageSize);
	}
	
	@ResponseBody
	@RequestMapping(value="/selectForumMe")
	public Result selectForumMe(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
								@RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
								HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if (developer!=null) {
			ForumWithBLOBs  forumWithBLOBs=new ForumWithBLOBs();
			
			String forumName = request.getParameter("forumName");
			String forumInfo = request.getParameter("forumInfo");
			String forumWhat = request.getParameter("forumWhat");
			String forumStart = request.getParameter("forumStart");
			String forumType = request.getParameter("forumType");
			forumWithBLOBs.setForumType(forumType);
			if (forumStart!=null) {
				int forumStart2 = Integer.parseInt(forumStart);
				forumWithBLOBs.setForumStart(forumStart2);
			}
			
			if (forumWhat!=null) {
				int forumWhat2 = Integer.parseInt(forumWhat);
				forumWithBLOBs.setForumWhat(forumWhat2);
			}
			
			forumWithBLOBs.setForumInfo(forumInfo);
			forumWithBLOBs.setForumName(forumName);
			forumWithBLOBs.setForummemId(developer.getDevId());
			return forumService.selectForum(forumWithBLOBs,fenye,pageSize);
		}
		return ResultUtil.error("你还没登录,请登录再试");
	}
}
*/

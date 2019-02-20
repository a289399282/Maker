package com.gdpi.maker.controller.userController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.gdpi.maker.pojo.Studiomem;
import com.gdpi.maker.service.StudiomemService;
import com.gdpi.maker.utilsmy.DeleteFileUtil;
import com.gdpi.maker.utilsmy.StringUtils;
import com.gdpi.maker.utilsmy.uploadFileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.pojo.ForumWithBLOBs;
import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.service.ForumService;
import com.gdpi.maker.utils.ResultUtil;

import java.util.Map;

@SuppressWarnings("Duplicates")
@Controller
@RequestMapping(value="/forum")
public class ForumController {
	//@Qualifier("DaoImpl")        //实现类1的类名。注意区分与@Resource(name="dogImpl") 的区别。
	//@Autowired @Autowired 的注入方式是 byType 注入， 当要注入的类型在容器中存在多个时，Spring是不知道要引入哪个实现类的，所以会报错。

	@Resource(name="ForumServiceImpl")        //实现类1中 @Service注解中标定的名称
	private ForumService forumService;
	@Resource(name = "StudiomemServiceImpl")
	private StudiomemService studiomemService;
	/**
	 * 上传文字作品
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addForText")
	public Result addForumText(HttpServletRequest request){
		Developer developer2=(Developer) request.getSession().getAttribute("developer");
		if (developer2!=null) {
			//接受信息
			ForumWithBLOBs  forumWithBLOBs=new ForumWithBLOBs();
			
			String forumStart = request.getParameter("forumStart");
			String forumName = request.getParameter("forumName");
			String forumInfo = request.getParameter("forumInfo");
			String forumText = request.getParameter("forumText");
			String forumType = request.getParameter("forumType");
			//如果是作品是工作室就把工作室Id传到这里
			String forummemId = request.getParameter("forummemId");
			//发布者
			if(forummemId==null || forummemId.equals("null")) {
				forumWithBLOBs.setForummemId(developer2.getDevId());
			}else {
				Studiomem studiomem = studiomemService.selectStudiomem2(forummemId, developer2.getDevId());
				if (studiomem != null) {
					forumWithBLOBs.setForummemId(forummemId);
				}else{
					return ResultUtil.error("你不是该工作室成员");
				}
			}

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

	/**
	 * 上传视频
	 * @param devVideo 视频文件
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addForVideo")
	public Result addForumVideo(MultipartFile devVideo,HttpServletRequest request){
		Developer developer2=(Developer) request.getSession().getAttribute("developer");

		if (developer2!=null) {
			if (devVideo != null) {
				if (devVideo.getSize()<=10485760) {
					ForumWithBLOBs  forumWithBLOBs;
					//定义作品Id
					String forumId;
					do {
						forumId= StringUtils.forumString();
						forumWithBLOBs=forumService.selectForumById(forumId);
					} while (forumWithBLOBs!=null);
					//把视频存到服务器
					String string = uploadFileUtils.videoBuilder(devVideo, forumId,request);
					//成功返回字符串,失败返回null
					if (string!=null) {
						forumWithBLOBs=new ForumWithBLOBs();

						//接收作品信息
						String forumName = request.getParameter("forumName");
						String forumInfo = request.getParameter("forumInfo");
						String forumStart = request.getParameter("forumStart");
						String forumType = request.getParameter("forumType");
						//如果是作品是工作室就把工作室Id传到这里
						String forummemId = request.getParameter("forummemId");
						//发布者
						if(forummemId==null || forummemId.equals("null")) {
							forumWithBLOBs.setForummemId(developer2.getDevId());
						}else {
							Studiomem studiomem = studiomemService.selectStudiomem2(forummemId, developer2.getDevId());
							if (studiomem != null) {
								forumWithBLOBs.setForummemId(forummemId);
							}else{
								return ResultUtil.error("你不是该工作室成员");
							}
						}

						if (forumStart!=null) {
							int forumStart2 = Integer.parseInt(forumStart);
							forumWithBLOBs.setForumStart(forumStart2);
						}

						forumWithBLOBs.setForumType(forumType);
						forumWithBLOBs.setForumInfo(forumInfo);
						forumWithBLOBs.setForumName(forumName);
						forumWithBLOBs.setForumId(forumId);
						forumWithBLOBs.setForumRoute(string);

						Result result = forumService.addForumVideo(forumWithBLOBs);
						//判断是否失败,如果失败就删除视频文件
						if (result.getCode() == 0) {
							DeleteFileUtil.deleteFile(string, request);
						}
						return result;
					}
					return ResultUtil.error("上传失败");
				}
				return ResultUtil.error("视频大于10M的限制");
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
				//如果是作品是工作室就把工作室Id传到这里
				String forummemId = request.getParameter("forummemId");
				//发布者
				if(forummemId==null || forummemId.equals("null")) {
					forumWithBLOBs.setForummemId(developer.getDevId());
				}else {
					Studiomem studiomem = studiomemService.selectStudiomem2(forummemId, developer.getDevId());
					if (studiomem != null) {
						forumWithBLOBs.setForummemId(forummemId);
					}else{
						return ResultUtil.error("你不是该工作室成员");
					}
				}

				forumWithBLOBs.setForumForid(forumId);
				return forumService.addForum(forumWithBLOBs);
			}
			return ResultUtil.error("你还没登录,请登录再试");
		}
		return ResultUtil.error("forumId不能为空");
	}
	

	/*@ResponseBody
	@RequestMapping(value="/deleteForum")
	public Result deleteForum(String forumId,HttpServletRequest request){
		*//*boolean b = DeleteFileUtil.deleteFile(forumId, request);
		System.out.println(b);*//*
		return null;
		//return forumService.deleteForum(forumId);
	}*/

	/**
	 * 修改作品信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateForum")
	public Result updateForum(HttpServletRequest request){
		String forumId = request.getParameter("forumId");
		if (forumId!=null) {
			Developer developer=(Developer) request.getSession().getAttribute("developer");
			if (developer!=null) {
				ForumWithBLOBs  forumWithBLOBs=new ForumWithBLOBs();
				//接受信息
				String forumName = request.getParameter("forumName");
				String forumInfo = request.getParameter("forumInfo");
				String forumText = request.getParameter("forumText");
				String forumType = request.getParameter("forumType");
				//如果是作品是工作室就把工作室Id传到这里
				String forummemId = request.getParameter("forummemId");
				//发布者
				if(forummemId==null || forummemId.equals("null")) {
					forumWithBLOBs.setForummemId(developer.getDevId());
				}else {
					Studiomem studiomem = studiomemService.selectStudiomem2(forummemId, developer.getDevId());
					if (studiomem!=null) {
						forumWithBLOBs.setForummemId(forummemId);
					}else{
						return ResultUtil.error("你不是该工作室成员");
					}
				}

				forumWithBLOBs.setForumType(forumType);
				
				forumWithBLOBs.setForumName(forumName);
				forumWithBLOBs.setForumText(forumText);
				forumWithBLOBs.setForumInfo(forumInfo);
				forumWithBLOBs.setForumId(forumId);
				return forumService.updateForum(forumWithBLOBs);
			}
			return ResultUtil.error("你还没登录,请登录再试");
		}
		return ResultUtil.error("forumId不能为空");
	}

	/**
	 * 修改作品状态
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateForumStart")
	public Result updateForumStart(HttpServletRequest request){
		String forumId = request.getParameter("forumId");
		if (forumId!=null) {
			Developer developer=(Developer) request.getSession().getAttribute("developer");
			if (developer!=null) {
				//接收状态
				String forumStart = request.getParameter("forumStart");

				if (forumStart!=null) {
					ForumWithBLOBs  forumWithBLOBs=new ForumWithBLOBs();

					int forumStart2 = Integer.parseInt(forumStart);

					//如果是作品是工作室就把工作室Id传到这里
					String forummemId = request.getParameter("forummemId");
					//发布者
					if(forummemId==null || forummemId.equals("null")) {
						forumWithBLOBs.setForummemId(developer.getDevId());
					}else {
						Studiomem studiomem = studiomemService.selectStudiomem2(forummemId, developer.getDevId());
						//判断是否是工作室成员
						if (studiomem!= null) {
							//想删除就判断权限
							if (forumStart2 == 2) {
								if (studiomem.getStumemPower()==1) {
									return ResultUtil.error("你没权限修改");
								}
							}
							forumWithBLOBs.setForummemId(forummemId);
						}else{
							return ResultUtil.error("你不是该工作室成员");
						}
					}

					forumWithBLOBs.setForumStart(forumStart2);
					forumWithBLOBs.setForumId(forumId);
					return forumService.updateForumStart(forumWithBLOBs);
				}
				return ResultUtil.error("状态有误");
			}
			return ResultUtil.error("你还没登录,请登录再试");
		}
		return ResultUtil.error("forumId不能为空");
	}

	/**
	 * 删除作品
	 * @param forumId 作品IdList
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateForumListStart")
	public Result updateForumListStart(@RequestParam(value="forumId[]")String[] forumId,HttpServletRequest request){

		if (forumId!=null) {
			Developer developer=(Developer) request.getSession().getAttribute("developer");
			if (developer!=null) {
				//如果是作品是工作室就把工作室Id传到这里
				String forummemId = request.getParameter("forummemId");
				//发布者
				if(forummemId==null || forummemId.equals("null")) {
					return forumService.updateForumListStart(forumId, developer.getDevId());
				}else {
					Studiomem studiomem = studiomemService.selectStudiomem2(forummemId, developer.getDevId());
					//是否是工作室成员,判断权限
					if (studiomem != null && studiomem.getStumemPower()>1) {
						return forumService.updateForumListStart(forumId, forummemId);
					}else{
						return ResultUtil.error("你没有权限删除");
					}
				}
			}
			return ResultUtil.error("你还没登录,请登录再试");
		}
		return ResultUtil.error("forumId不能为空");
	}

	/**
	 * 查询作品
	 * @param pageSize 每页多少条数据
	 * @param fenye 页码数
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectForum")
	public Result selectForum(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							  @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							  Integer forumWhat,Integer OrderByClause,HttpServletRequest request){
		ForumWithBLOBs  forumWithBLOBs=new ForumWithBLOBs();
		//接收查询条件
		String forumId = request.getParameter("forumId");
		String forummemId = request.getParameter("forummemId");
		String forumName = request.getParameter("forumName");
		String forumInfo = request.getParameter("forumInfo");
		//String forumWhat = request.getParameter("forumWhat");
		String forumType = request.getParameter("forumType");


		forumWithBLOBs.setForumWhat(forumWhat);
		forumWithBLOBs.setForumType(forumType);
		forumWithBLOBs.setForummemId(forummemId);
		forumWithBLOBs.setForumInfo(forumInfo);
		forumWithBLOBs.setForumName(forumName);
		forumWithBLOBs.setForumId(forumId);
		//只能查找已发布的
		forumWithBLOBs.setForumStart(1);
		forumWithBLOBs.setOrderByClause(OrderByClause);
		return forumService.selectForum(forumWithBLOBs,fenye,pageSize);
	}

	/**
	 * 自己查询自己的作品信息
	 * @param pageSize
	 * @param fenye
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectForumMe")
	public Result selectForumMe(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
								@RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
								Integer OrderByClause,HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if (developer!=null) {
			ForumWithBLOBs  forumWithBLOBs=new ForumWithBLOBs();
			//接收信息
			String forumForId = request.getParameter("forumForId");
			String forumId = request.getParameter("forumId");
			String forumName = request.getParameter("forumName");
			String forumInfo = request.getParameter("forumInfo");
			String forumWhat = request.getParameter("forumWhat");
			String forumStart = request.getParameter("forumStart");
			String forumType = request.getParameter("forumType");

			//如果是作品是工作室就把工作室Id传到这里
			String forummemId = request.getParameter("forummemId");
			//发布者
			if(forummemId==null || forummemId.equals("null")) {
				forumWithBLOBs.setForummemId(developer.getDevId());
			}else {
				forumWithBLOBs.setForummemId(forummemId);
			}

			if (forumStart!=null) {
				int forumStart2 = Integer.parseInt(forumStart);
				forumWithBLOBs.setForumStart(forumStart2);
			}
			if (forumWhat!=null) {
				int forumWhat2 = Integer.parseInt(forumWhat);
				forumWithBLOBs.setForumWhat(forumWhat2);
			}
			forumWithBLOBs.setForumType(forumType);
			if (forumForId != null && forumForId.length()!=0) {
				forumWithBLOBs.setForumId(forumForId);
			}else{
				forumWithBLOBs.setForumId(forumId);
			}
			forumWithBLOBs.setOrderByClause(OrderByClause);
			forumWithBLOBs.setForumInfo(forumInfo);
			forumWithBLOBs.setForumName(forumName);
			forumWithBLOBs.setForummemId(developer.getDevId());
			return forumService.selectForum(forumWithBLOBs,fenye,pageSize);
		}
		return ResultUtil.error("你还没登录,请登录再试");
	}

	/**
	 * 根据Id查
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectForumById")
	public Result selectForumById(String forumId){
		return forumService.selectByPrimaryKey(forumId);
	}

	/**
	 * 排行版2
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/rankingsForum")
	public Result rankingsDev2(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							   @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							   @RequestParam(required = false,defaultValue = "2",value = "OrderByClause")Integer OrderByClause
								,Integer forumWhat){

		ForumWithBLOBs forumWithBLOBs=new ForumWithBLOBs();
		forumWithBLOBs.setOrderByClause(OrderByClause);
		forumWithBLOBs.setForumWhat(forumWhat);
		//调用方法查询开发人员的信息
		return forumService.ranKingsForum(forumWithBLOBs,fenye,pageSize);

	}
}

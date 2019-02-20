package com.gdpi.maker.controller.userController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.pojo.Studiomem;
import com.gdpi.maker.service.StudiomemService;
import com.gdpi.maker.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.pojo.Studio;
import com.gdpi.maker.service.StudioService;
import com.gdpi.maker.utilsmy.uploadFileUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("Duplicates")
@Controller
@RequestMapping(value="/studio")
public class StudioController {
	@Resource(name="StudioServiceImpl")
	private StudioService studioService;
	@Resource(name="StudiomemServiceImpl")
	private StudiomemService studiomemService;
	/**
	 * 注册工作室
	 * @param
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insertStu")
	public Result insertStu(HttpServletRequest request) throws ParseException {
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer!=null) {
			//接收工作室信息
			String stuName = request.getParameter("stuName");
			String stuPhone = request.getParameter("stuPhone");
			String stuEmail = request.getParameter("stuEmail");
			String stuLocation = request.getParameter("stuLocation");
			String stuSpeciality = request.getParameter("stuSpeciality");
			String stuInfo = request.getParameter("stuInfo");

			Studio studio = new Studio();

			studio.setStuName(stuName);
			studio.setStuEmail(stuEmail);
			studio.setStuInfo(stuInfo);
			studio.setStuLocation(stuLocation);
			studio.setStuSpeciality(stuSpeciality);
			studio.setDevId(developer.getDevId());
			studio.setStuPhone(stuPhone);
			return studioService.insertStudio(studio);
		}
		return ResultUtil.error("你还没登录,请登录再试!");
	}
	
	/**
	 * 注销工作室
	 * @param stuId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateStuStart")
	public Result updateStuStart(String stuId,HttpServletRequest request){
	    Developer developer = (Developer) request.getSession().getAttribute("developer");
        if (developer!=null) {
        	//接收工作室Id,判断是否有权限
            if (stuId != null) {
				Studio studio1 = studioService.selectStudioByIdExist(stuId);
				if (studio1 != null && studio1.getDevId().equals(developer.getDevId())) {
					Studio studio=new Studio();
					studio.setStuId(stuId);
					studio.setDevId(developer.getDevId());
					//设置注销日期
					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					try {
						studio.setStuEndtime(date.parse(date.format(new Date())));
					}catch (ParseException e) {
						e.printStackTrace();
						return ResultUtil.error("日期出错");
					}
					studio.setStuStart(0);
					//调用方法删除工作室的信息
					return studioService.updateStudio(studio);
				}
				return ResultUtil.error("你不是此工作室的创始人");
			}
            return ResultUtil.error("工作室Id为空!");
        }
        return ResultUtil.error("你还没登录,请登录再试!");
	}
	
	/**
	 * 修改工作室Id
	 * @param
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateStu")
	public Result updateStu(HttpServletRequest request){
        Developer developer = (Developer) request.getSession().getAttribute("developer");
        if (developer!=null) {
        	//接收信息
            String stuName = request.getParameter("stuName");
            String stuPhone = request.getParameter("stuPhone");
            String stuEmail = request.getParameter("stuEmail");
            String stuLocation = request.getParameter("stuLocation");
            String stuSpeciality = request.getParameter("stuSpeciality");
            String stuInfo = request.getParameter("stuInfo");
            Studio studio=new Studio();

            studio.setStuName(stuName);
            studio.setStuEmail(stuEmail);
            studio.setStuInfo(stuInfo);
            studio.setStuLocation(stuLocation);
            studio.setStuSpeciality(stuSpeciality);
            studio.setStuPhone(stuPhone);
            //调用方法更新开发人员的信息
            return studioService.updateStudio(studio);
        }
        return ResultUtil.error("你还没登录,请登录再试!");
	}
	/**
	 * 上传工作室头像
	 * @param
	 * @param stuPic
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateStuImg")
	public Result updateStuImg(MultipartFile stuPic,HttpServletRequest request){
        Developer developer = (Developer) request.getSession().getAttribute("developer");
        if (developer!=null) {
            String stuId = request.getParameter("stuId");
            if (stuId != null) {
                Studio studio=new Studio();
                //判断是否上传图片
                if(stuPic !=null && studio.getStuId() != null && studio.getStuId().length()!=0){
					if (stuPic.getSize() <= 1572864) {
						//判断是否有权限
						Studiomem studiomem = studiomemService.selectStudiomem2(stuId, developer.getDevId());
						if (studiomem != null && studiomem.getStumemPower()>1) {
							//调用方法上传图片到服务器上
							String imgDeveloper = uploadFileUtils.thumbnailUploadImage(stuPic, stuId,request);
							if(imgDeveloper !=null && imgDeveloper.length()!=0){
								//设置图片名到developer对象里
								studio.setStuImg(imgDeveloper);
								studio.setDevId(developer.getDevId());
								//调用方法更新开发人员的信息
								return studioService.updateStudio(studio);
							}
							return ResultUtil.error("上传失败!");
						}
						return ResultUtil.error("你没有权限修改!");
					}
					return ResultUtil.error("图片超出了1.5M的限制!");
				}
                return ResultUtil.error("图片为空!");
            }
            return ResultUtil.error("工作室Id为空!");
        }
        return ResultUtil.error("你还没登录,请登录再试!");
	}
	/**
	 * 查询
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectStu")
	public Result selectStu(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							@RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							Integer OrderByClause,HttpServletRequest request){
		//接收搜索条件
        String stuName = request.getParameter("stuName");
        String stuPhone = request.getParameter("stuPhone");
        String stuEmail = request.getParameter("stuEmail");
        String stuLocation = request.getParameter("stuLocation");
        String stuSpeciality = request.getParameter("stuSpeciality");
        //String stuInfo = request.getParameter("stuInfo");
        String stuId = request.getParameter("stuId");
        String devId = request.getParameter("devId");
        Studio studio=new Studio();

        studio.setStuName(stuName);
        studio.setStuEmail(stuEmail);
        //studio.setStuInfo(stuInfo);
        studio.setStuLocation(stuLocation);
        studio.setStuSpeciality(stuSpeciality);
        studio.setStuPhone(stuPhone);
        studio.setDevId(devId);
        studio.setStuId(stuId);
        studio.setOrderByClause(OrderByClause);
	    //调用方法查询开发人员的信息
		return studioService.selectStudio(studio,fenye,pageSize);
	}

	/**
	 * 查询
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectStuById")
	public Result selectStu(HttpServletRequest request){
		//接收搜索条件
		String stuId = request.getParameter("stuId");

		//调用方法查询开发人员的信息
		if (stuId != null) {
			Studio studio = studioService.selectStudioByIdExist(stuId);
			if (studio != null) {
				return ResultUtil.success(studio,"查询成功");
			}
			return ResultUtil.error("工作室不存在或已注销");
		}
		return ResultUtil.error("工作室Id为空");
	}

	/**
	 * 排行版
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/rankingsStu")
	public Result selectStu2(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							 @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							 Integer OrderByClause,HttpServletRequest request) {
		Studio studio = new Studio();
		studio.setOrderByClause(OrderByClause);
		return studioService.RankingsStu(studio,fenye,pageSize);
	}
}

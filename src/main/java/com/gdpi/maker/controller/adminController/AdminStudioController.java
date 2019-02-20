package com.gdpi.maker.controller.adminController;

import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.pojo.Studio;
import com.gdpi.maker.service.StudioService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.uploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
@Controller
@RequestMapping(value="/admin/studio")
public class AdminStudioController {
	@Resource(name="AdminStudioServiceImpl")
	private StudioService studioService;
	*/
/**
	 * 注册工作室
	 * @param
	 * @param
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value="/insertStu")
	public Result insertStu(HttpServletRequest request) throws ParseException {
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer!=null) {
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
	
	*/
/**
	 * 删除
	 * @param stuId
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value="/updateStuStart")
	public Result updateStuStart(String stuId,HttpServletRequest request){
	    Developer developer = (Developer) request.getSession().getAttribute("developer");
        if (developer!=null) {
            if (stuId != null) {
                Studio studio=new Studio();
                studio.setStuId(stuId);
                studio.setDevId(developer.getDevId());
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
            return ResultUtil.error("工作室Id为空!");
        }
        return ResultUtil.error("你还没登录,请登录再试!");
	}
	
	*/
/**
	 * 修改
	 * @param
	 * @param
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value="/updateStu")
	public Result updateStu(HttpServletRequest request){
        Developer developer = (Developer) request.getSession().getAttribute("developer");
        if (developer!=null) {
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
	*/
/**
	 * 修改
	 * @param
	 * @param stuPic
	 * @return
	 *//*

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
                return ResultUtil.error("图片为空!");
            }
            return ResultUtil.error("工作室Id为空!");
        }
        return ResultUtil.error("你还没登录,请登录再试!");
	}
	*/
/**
	 * 查询
	 * @param
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value="/selectStu")
	public Result selectStu(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							@RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							HttpServletRequest request){
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
	    //调用方法查询开发人员的信息
		return studioService.selectStudio(studio,fenye,pageSize);
	}
}
*/

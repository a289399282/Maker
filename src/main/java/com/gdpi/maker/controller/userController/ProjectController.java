package com.gdpi.maker.controller.userController;

import com.gdpi.maker.dao.DeveloperDao;
import com.gdpi.maker.pojo.*;
import com.gdpi.maker.service.DeveloperService;
import com.gdpi.maker.service.ProjectService;
import com.gdpi.maker.service.StudioService;
import com.gdpi.maker.service.StudiomemService;
import com.gdpi.maker.service.impl.userImpl.DeveloperServiceImpl;
import com.gdpi.maker.utils.ResultUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("Duplicates")
@Controller
@RequestMapping(value="/project")
public class ProjectController {

	@Resource(name="ProjectServiceImpl")
	private ProjectService projectService;
	@Resource(name="StudioServiceImpl")
	private StudioService studioService;
	@Resource(name="StudiomemServiceImpl")
	private StudiomemService studiomemService;
	@Resource(name="DeveloperServiceImpl")
	private DeveloperService developerService;
	/**
	 * 添加项目
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insertPro")
	public Result insertPro(@RequestParam(required = false,value="proType")String[]  proType,
							Double proMoney,Date proEndtime,HttpServletRequest request) throws ParseException {
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			//接收信息
			String proPublisher = request.getParameter("proPublisher");
			String proName = request.getParameter("proName");
			String proCity = request.getParameter("proCity");
			String proState = request.getParameter("proState");
			String proInfo = request.getParameter("proInfo");

			Project project=new Project();
			//发布者
			//验证发布者
			if(proPublisher==null || proPublisher.equals("null")){
				project.setProPublisher(developer.getDevId());
			}else{
				Studiomem studiomem = studiomemService.selectStudiomem2(proPublisher, developer.getDevId());
				if (studiomem !=null && studiomem.getStumemPower()>1) {
					project.setProPublisher(proPublisher);
				}else {
					return ResultUtil.error("你没权限创建项目");
				}
			}
			//结束时间
			if (proEndtime != null) {
				project.setProEndtime(proEndtime);
			}else{
				return ResultUtil.error("结束时间有误");
			}

			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			//状态
			if (proState!=null){
				int i = Integer.parseInt(proState);
				if (i == 1 || i==0) {
					project.setProState(i);
					//设置发布时间
					if (i==1) {
						project.setProReltime(date.parse(date.format(new Date())));
					}
				}else {
					return ResultUtil.error("项目状态有误");
				}
			}

			project.setProFoutime(date.parse(date.format(new Date())));
			String string="";
			if (proType != null) {
				for (String s: proType) {
					string+=s+"、";
				}
			}
			project.setProType(string.substring(0,string.length()-1));
			project.setProCity(proCity);
			project.setProName(proName);
			project.setProInfo(proInfo);
			project.setProMoney(proMoney);
			return projectService.insertProject(project);
		}
		return ResultUtil.error("你还没登录,请你登录再试");
	}

	/**
	 * 删除项目
	 * @param proId 项目id
	 * @return
	 */
	/*@ResponseBody
	@RequestMapping(value="/deletePro")
	public Result deletePro(String proId){
		return projectService.deleteProject(proId);
	}*/

    /**
     * 更新项目信息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/updateProListStart")
    public Result updateProListStart(@RequestParam(required = false,value="proId[]")String[]  proId,HttpServletRequest request){
        Developer developer=(Developer) request.getSession().getAttribute("developer");
        if(developer!=null){
            if (proId != null) {
                String proPublisher = request.getParameter("proPublisher");
                //发布者
                if(proPublisher==null || proPublisher.equals("null")){
					return projectService.updateProjectListStart(proId,developer.getDevId());
				}else{
					return projectService.updateProjectListStart(proId,proPublisher);
                }
            }
            return ResultUtil.error("项目Id有误");
        }
        return ResultUtil.error("你还没登录,请你登录再试");
    }


	/**
	 * 更新项目信息
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updatePro")
	public Result updatePro(Double proMoney,String proId,Date proEndtime,HttpServletRequest request) throws ParseException {
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			if (proId != null) {

				Project project=new Project();
				String proPublisher = request.getParameter("proPublisher");
				String proName = request.getParameter("proName");
				String proType = request.getParameter("proType");
				String proCity = request.getParameter("proCity");
				String proState = request.getParameter("proState");
				String proInfo = request.getParameter("proInfo");

				//验证发布者
				if(proPublisher==null || proPublisher.equals("null")){
					/*Project project1 = projectService.selectProjectById(proId);
					if (!project1.getProPublisher().equals(developer.getDevId())) {
						return ResultUtil.error("你没权限修改");
					}*/
                    project.setProPublisher(developer.getDevId());
				}else{
                    Studiomem studiomem = studiomemService.selectStudiomem2(proPublisher, developer.getDevId());
                    if (studiomem !=null && studiomem.getStumemPower()>1) {
                        project.setProPublisher(proPublisher);
                    }else {
                        return ResultUtil.error("你没权限修改2");
                    }
				}

				//状态
				if (proState!=null){
					int i = Integer.parseInt(proState);
                    if (i<0 || i>6){
                        return ResultUtil.error("项目状态有误");
                    }
					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					if (i == 1) {
						project.setProReltime(date.parse(date.format(new Date())));
					}
					if(i==6){
						project.setProReltime(date.parse(date.format(new Date())));
					}
                    project.setProState(i);
				}

				project.setProId(proId);
				project.setProEndtime(proEndtime);
				project.setProType(proType);
				project.setProCity(proCity);
				project.setProName(proName);
				project.setProInfo(proInfo);
				project.setProMoney(proMoney);
				return projectService.updateProject(project);
			}
			return ResultUtil.error("项目Id有误");
		}
		return ResultUtil.error("你还没登录,请你登录再试");
	}

	/**
	 * 查询项目
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectProAll")
	public Result selectProAll(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							   @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							   Integer orderByClause,HttpServletRequest request,Double money1,Double money2){
		Project project=new Project();
		String proPublisher = request.getParameter("proPublisher");
		String proName = request.getParameter("proName");
		String proType = request.getParameter("proType");
		String proCity = request.getParameter("proCity");
		String proState = request.getParameter("proState");
		String proInfo = request.getParameter("proInfo");

		//发布者
		project.setProPublisher(proPublisher);
		//状态
		if (proState!=null){
			int i = Integer.parseInt(proState);
			project.setProState(i);
			if (i<0 || i>6){
				return ResultUtil.error("项目状态有误");
			}
		}
		project.setOrderByClause(orderByClause);
		project.setProType(proType);
		project.setProCity(proCity);
		project.setProName(proName);
		project.setProInfo(proInfo);
		return projectService.selectProjectAll(project, money1, money2,fenye,pageSize);
		}

	/**
	 * 查询项目
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectProMe")
	public Result selectProMe(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							  @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							  Integer OrderByClause,HttpServletRequest request, Double money1, Double money2){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			Project project=new Project();
			String proPublisher = request.getParameter("proPublisher");
			String proName = request.getParameter("proName");
			String proType = request.getParameter("proType");
			String proCity = request.getParameter("proCity");
			String proState = request.getParameter("proState");
			String proInfo = request.getParameter("proInfo");

			//发布者
			project.setProPublisher(proPublisher);
			//状态
			if (proState!=null){
				int i = Integer.parseInt(proState);
				project.setProState(i);
				if (i<0 || i>6){
					return ResultUtil.error("项目状态有误");
				}
			}
			project.setProType(proType);
			project.setProCity(proCity);
			project.setProName(proName);
			project.setProInfo(proInfo);
			project.setOrderByClause(OrderByClause);
			return projectService.selectProjectMe(project, money1, money2,fenye,pageSize);
		}
		return ResultUtil.error("你还没登录,请你登录再试");
	}

	/**
	 * 查询项目
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectProById")
	public Result selectProById(HttpServletRequest request){
		//Developer developer=(Developer) request.getSession().getAttribute("developer");
		//if(developer!=null){

			String proId = request.getParameter("proId");
			if(proId!=null) {
				Project project = projectService.selectProjectById(proId);
				if (project != null) {
					ProjectCut projectCut=new ProjectCut();
					try {
						BeanUtils.copyProperties(projectCut, project);
						//设置发布人的名称
						String proPublisher = projectCut.getProPublisher();
						String substring = proPublisher.substring(0, 3);
						if ("Dev".equals(substring)){
							Developer developer = developerService.selectDevById(proPublisher);
							projectCut.setProPubname(developer.getDevName());
						}else if ("Stu".equals(substring)) {
							Studio studio = studioService.selectStudioById(proPublisher);
							projectCut.setProPubname(studio.getStuName());
						}
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
						return ResultUtil.error("出错");
					}

					//加1热度
					/*Project project1=new Project();
					project1.setProId(proId);
					project1.setProHeat((project.getProHeat()+1));*/
					projectService.updateProjectHeat(proId,(project.getProHeat()+1));

					return ResultUtil.success(projectCut,"查询成功");
				}
				return ResultUtil.error("项目不存在");
			}
		return ResultUtil.error("项目Id为空");
		//}
		//return ResultUtil.error("你还没登录,请你登录再试");
	}
}

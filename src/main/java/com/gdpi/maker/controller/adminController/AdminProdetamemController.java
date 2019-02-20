package com.gdpi.maker.controller.adminController;

import com.gdpi.maker.pojo.*;
import com.gdpi.maker.service.ProdetamemService;
import com.gdpi.maker.service.ProjectService;
import com.gdpi.maker.service.StudiomemService;
import com.gdpi.maker.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/*
@Controller
@RequestMapping(value="/admin/prodetamem")
public class AdminProdetamemController {
	@Resource(name="AdminProdetamemServiceImpl")
	private ProdetamemService prodetamemService;
	@Resource(name="AdminProjectServiceImpl")
	private ProjectService projectService;
	@Resource(name="AdminStudiomemServiceImpl")
	private StudiomemService studiomemService;
	*/
/**
	 * 参加项目竞标
	 * @param proId 项目id
	 * @param prdememId 用户id或工作室id
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value="/insertPrdemem")
	public Result insertPrdemem(String proId, String prdememId, HttpServletRequest request){
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer != null) {
			if (proId != null ) {
				Project project = projectService.selectProjectById(proId);
				Integer proState = project.getProState();
				if (proState == 1) {
					//以工作室参加
					if (prdememId != null ) {
						//发布者
						Studiomem studiomem = studiomemService.selectStudiomem2(prdememId, developer.getDevId());
						if (studiomem.getStumemPower()>1 && studiomem.getStumemIs()==2) {
							return prodetamemService.insertProdetamem(proId, prdememId);
						}
						return ResultUtil.error("你没权限修改2");
					}else{
						//个人参加
						return prodetamemService.insertProdetamem(proId, developer.getDevId());
					}
				}
				return ResultUtil.error("此项目已结束");
			}
			return ResultUtil.error("项目Id为空");
		}
		return ResultUtil.error("你还没登录,请登录再试");
	}
	*/
/**
	 * 删除项目竞标信息
	 * @param proId 项目id
	 * @param prdememId 用户id或工作室id
	 * @return
	 *//*

	*/
/*@ResponseBody
	@RequestMapping(value="/deletePrdemem")
	public Result deletePrdemem(String proId, String prdememId){
		return prodetamemService.deleteProdetamem(proId, prdememId);
		}*//*

	*/
/**
	 * 更新竞标项目的状态码(1只是表示参加2成功,3退出竞标)
	 * @param proId 项目id
	 * @param prdememId 用户id或工作室id
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value="/updatePrdemem")
	public Result updatePrdemem(String proId, String prdememId, HttpServletRequest request){
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer != null) {
			if (proId != null ) {
				Prodetamem prodetamem=new Prodetamem();
				Prodetamem prodetamem2=null;
				if (prdememId != null ) {
					prodetamem2 = prodetamemService.selectProdetamem2(proId, prdememId);
				}else {
					prodetamem2 = prodetamemService.selectProdetamem2(proId, developer.getDevId());
				}
				if (prodetamem2 != null) {
					String prdememState = request.getParameter("prdememState");
					if (prdememState != null) {
						int i = Integer.parseInt(prdememState);
						if (i == 1 || i==0) {
							prodetamem.setPrdememState(i);
						}else {
							return ResultUtil.error("状态有误");
						}
					}else {
						prodetamem.setPrdememState(1);
					}

					prodetamem.setProId(proId);
					prodetamem.setPrdememId(prdememId);
					return prodetamemService.updateProdetamem(prodetamem);
				}
				return ResultUtil.error("这申请记录不存在");
			}
			return ResultUtil.error("项目Id为空");
		}
		return ResultUtil.error("你还没登录,请登录再试");
	}
	*/
/**
	 * 查询竞标项目信息
	 * @param proId
	 * @param prdememId
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value="/selectPrdememAll")
	public Result selectPrdememAll(@RequestParam(required = false,defaultValue = "5",value = "pageSize")Integer pageSize,
								   @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
								   String proId, String prdememId,HttpServletRequest request){

				String prdememState = request.getParameter("prdememState");
				
				Prodetamem prodetamem=new Prodetamem();
				prodetamem.setProId(proId);
				prodetamem.setPrdememId(prdememId);
				if (prdememState != null) {
					int i = Integer.parseInt(prdememState);
					if (i == 1 || i==2) {
						prodetamem.setPrdememState(i);
					}else {
						return ResultUtil.error("状态有误");
					}
				}else {
					prodetamem.setPrdememState(1);
				}
				return prodetamemService.selectProdetamem(prodetamem,fenye,pageSize);

	}
	*/
/**
	 * 查询竞标项目信息
	 * @param proId
	 * @param prdememId
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value="/selectPrdememMe")
	public Result selectPrdememMe(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
								  @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
								  String proId, String prdememId,HttpServletRequest request){

		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer != null) {
				String prdememState = request.getParameter("prdememState");

				Prodetamem prodetamem=new Prodetamem();
				prodetamem.setProId(proId);
				if (prdememId!=null) {
					Studiomem studiomem = studiomemService.selectStudiomem2(prdememId, developer.getDevId());
					if (studiomem!=null && studiomem.getStumemIs()==1) {
						prodetamem.setPrdememId(prdememId);
					}else {
						return ResultUtil.error("你不是这工作室的成员无法查看");
					}
				}else {
					prodetamem.setPrdememId(developer.getDevId());
				}
				if (prdememState != null) {
					int i = Integer.parseInt(prdememState);
					if (i == 1 || i==2 || i==0) {
						prodetamem.setPrdememState(i);
					}else {
						return ResultUtil.error("状态有误");
					}
				}
				return prodetamemService.selectProdetamem(prodetamem,fenye, pageSize);
		}
		return ResultUtil.error("你还没登录,请登录再试");
	}
}
*/

package com.gdpi.maker.controller.adminController;

import com.gdpi.maker.pojo.*;
import com.gdpi.maker.service.ProdetaService;
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
@RequestMapping(value = "/admin/prodeta")
public class AdminPrdateController {
	@Resource(name="AdminProdetaServiceImpl")
	private ProdetaService prodetaService;
	@Resource(name="AdminProdetamemServiceImpl")
	private ProdetamemService prodetamemService;
	@Resource(name="AdminStudiomemServiceImpl")
	private StudiomemService studiomemService;
	@Resource(name="AdminProjectServiceImpl")
	private ProjectService projectService;
	*/
/**
	 * 添加用户或工作室开发开发这个项目
	 * @param proId 项目id
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value = "/insertPrde")
	public Result insertPrde(String stuId,String proId,HttpServletRequest request) {
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer!=null){
			Project project1 = projectService.selectProjectById(proId);
			Prodetamem prodetamem;
			//发布者
			if(stuId!=null && project1.getProPublisher().equals(stuId)){
				Studiomem studiomem = studiomemService.selectStudiomem2(stuId, developer.getDevId());
				if (studiomem !=null && studiomem.getStumemPower()>1 && studiomem.getStumemIs()==2) {
					prodetamem = prodetamemService.selectProdetamem2(proId, stuId);
				}else{
					return ResultUtil.error("你没权限");
				}
			}else{
				if (!project1.getProPublisher().equals(developer.getDevId())) {
					return ResultUtil.error("你没权限2");
				}
				prodetamem = prodetamemService.selectProdetamem2(proId, developer.getDevId());
			}
			if (prodetamem!=null && prodetamem.getPrdememState()==1){
				return prodetaService.insertPrde(proId, prodetamem.getPrdememId());
			}
			return ResultUtil.error("此申请人已退出申请");
		}
		return ResultUtil.error("你还没登录,请登录再试");
	}
	*/
/**
	 * 删除用户或工作室开发开发这个项目
	 * @param proId 项目id
	 * @param prdeIswin 用户id或工作室id
	 * @return
	 *//*

	*/
/*@ResponseBody
	@RequestMapping(value = "/deletePrde")
	public Result deletePrde(String proId, String prdeIswin) {
		return prodetaService.deletePrde(proId, prdeIswin);
	}*//*

	*/
/**
	 * 根据项目id和用户id或工作室id更新项目的状态码
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value = "/updatePrde")
	public Result updatePrde(String stuId,String proId,HttpServletRequest request) {
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer!=null){
			String prdeState = request.getParameter("prdeState");
			if (prdeState!=null){
				int i = Integer.parseInt(prdeState);
				if (i!=1 || i!=2){
					return ResultUtil.error("状态有误");
				}

				Project project1 = projectService.selectProjectById(proId);
				Prodeta prodeta=new Prodeta();
				//发布者
				if(stuId!=null && project1.getProPublisher().equals(stuId)){
					Studiomem studiomem = studiomemService.selectStudiomem2(stuId, developer.getDevId());
					if (studiomem !=null && studiomem.getStumemPower()>1 && studiomem.getStumemIs()==2) {
						prodeta.setPrdeIswin(stuId);
					}else{
						return ResultUtil.error("你没权限");
					}
				}else{
					if (!project1.getProPublisher().equals(developer.getDevId())) {
						return ResultUtil.error("你没权限2");
					}
					prodeta.setPrdeIswin(developer.getDevId());
				}


				prodeta.setPrdeState(i);
				return prodetaService.updatePrde(prodeta);
			}
			return ResultUtil.error("状态有误");
		}
		return ResultUtil.error("你还没登录,请登录再试");
	}
	*/
/**
	 * 查询
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value = "/selectPrdeAll")
	public Result selectPrdeAll(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
								@RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
								HttpServletRequest request) {
		String prdeState = request.getParameter("prdeState");
		String proId = request.getParameter("proId");
		String prdeIswin = request.getParameter("prdeIswin");

		Prodeta prodeta=new Prodeta();
		if (prdeState!=null) {
			int i = Integer.parseInt(prdeState);
			if (i != 1 || i != 2 || i!=3) {
				return ResultUtil.error("状态有误");
			}
			prodeta.setPrdeState(i);
		}
		prodeta.setPrdeIswin(prdeIswin);
		prodeta.setProId(proId);
		return prodetaService.selectPrde(prodeta,fenye,pageSize);
	}
}
*/

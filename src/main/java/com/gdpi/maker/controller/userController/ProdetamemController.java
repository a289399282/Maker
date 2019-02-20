package com.gdpi.maker.controller.userController;

import com.gdpi.maker.pojo.*;
import com.gdpi.maker.service.ProjectService;
import com.gdpi.maker.service.StudiomemService;
import com.gdpi.maker.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdpi.maker.service.ProdetamemService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("Duplicates")
@Controller
@RequestMapping(value="/prodetamem")
public class ProdetamemController {
	//@Qualifier("DaoImpl")        //实现类1的类名。注意区分与@Resource(name="dogImpl") 的区别。
	//@Autowired @Autowired 的注入方式是 byType 注入， 当要注入的类型在容器中存在多个时，Spring是不知道要引入哪个实现类的，所以会报错。

	@Resource(name="ProdetamemServiceImpl")        //实现类1中 @Service注解中标定的名称
	private ProdetamemService prodetamemService;
	@Resource(name="ProjectServiceImpl")
	private ProjectService projectService;
	@Resource(name="StudiomemServiceImpl")
	private StudiomemService studiomemService;

	/**
	 * 参加项目竞标
	 * @param proId 项目id
	 * @param prdememId 用户id或工作室id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insertPrdemem")
	public Result insertPrdemem(String proId, String prdememId, HttpServletRequest request){
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer != null) {
			if (proId != null ) {
				//以工作室参加
				if (prdememId == null || "null".equals(prdememId)) {
					//个人参加
					return prodetamemService.insertProdetamem(proId, developer.getDevId());

				}else{
					//发布者
					Studiomem studiomem = studiomemService.selectStudiomem2(prdememId, developer.getDevId());
					if (studiomem.getStumemPower()>1) {
						return prodetamemService.insertProdetamem(proId, prdememId);
					}
					return ResultUtil.error("你没权限参加");
				}
			}
			return ResultUtil.error("项目Id为空");
		}
		return ResultUtil.error("你还没登录,请登录再试");
	}
	/**
	 * 删除项目竞标信息
	 * @param proId 项目id
	 * @param prdememId 用户id或工作室id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deletePrdemem")
	public Result deletePrdemem(@RequestParam(required = false,defaultValue = "0",value = "prdememSum")Integer prdememSum,
								String proId, String prdememId){
		Prodetamem prodetamem=new Prodetamem();
		prodetamem.setPrdememId(proId);
		prodetamem.setPrdememSum(prdememSum);
		prodetamem.setPrdememId(prdememId);
		prodetamem.setPrdememState(4);
		return prodetamemService.deleteProdetamem(prodetamem);
		}
	/**
	 * 审核竞标项目的状态码(2成功)
	 * @param proId 项目id
	 * @param prdememId 用户id或工作室id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updatePrdemem")
	public Result updatePrdemem(@RequestParam(required = false,defaultValue = "0",value = "prdememSum")Integer prdememSum,
								String proId, String prdememId, HttpServletRequest request){
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer != null) {
			if (proId != null ) {
				Prodetamem prodetamem=new Prodetamem();
				String prdememState = request.getParameter("prdememState");
				if (prdememState != null ) {
					int i = Integer.parseInt(prdememState);
					if (i == 2) {
						if (prdememId != null) {
							Studiomem studiomem = studiomemService.selectStudiomem2(prdememId, developer.getDevId());
							if (studiomem !=null && studiomem.getStumemPower()>1) {
								prodetamem.setPrdememId(prdememId);
							}else{
								return ResultUtil.error("你没权限修改");
							}
						}else{
							prodetamem.setPrdememId(developer.getDevId());
						}

						prodetamem.setPrdememSum(prdememSum);
						prodetamem.setPrdememState(i);
						prodetamem.setProId(proId);

						return prodetamemService.updateProdetamem(prodetamem);
					}
				}
				return ResultUtil.error("状态有误");
			}
			return ResultUtil.error("项目Id为空");
		}
		return ResultUtil.error("你还没登录,请登录再试");
	}
	/**
	 * 更新竞标项目的状态码(0退出竞标)
	 * @param proId 项目id
	 * @param prdememId 用户id或工作室id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updatePrdememMe")
	public Result updatePrdememMe(@RequestParam(required = false,defaultValue = "0",value = "prdememSum")Integer prdememSum,
								  String proId, String prdememId, HttpServletRequest request){
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer != null) {
			if (proId != null ) {
				Prodetamem prodetamem=new Prodetamem();
				String prdememState = request.getParameter("prdememState");
				//String prdememSum = request.getParameter("prdememSum");

				if (prdememState != null ) {
					int i = Integer.parseInt(prdememState);
					if (i==0) {
						if (prdememId != null) {
							Studiomem studiomem = studiomemService.selectStudiomem2(prdememId, developer.getDevId());
							if (studiomem !=null && studiomem.getStumemPower()>1) {
								prodetamem.setPrdememId(prdememId);
							}else{
								return ResultUtil.error("你没权限修改");
							}
						}else{
							prodetamem.setPrdememId(developer.getDevId());
						}

						prodetamem.setPrdememSum(prdememSum);
						prodetamem.setPrdememState(i);
						prodetamem.setProId(proId);
						return prodetamemService.updateProdetamem(prodetamem);
					}
				}
				return ResultUtil.error("状态有误");
			}
			return ResultUtil.error("项目Id为空");
		}
		return ResultUtil.error("你还没登录,请登录再试");
	}
	/**
	 * 查询竞标项目信息
	 * @param proId
	 * @param prdememId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectPrdememAll")
	public Result selectPrdememAll(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
								   @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
								   Integer OrderByClause,String proId, String prdememId,HttpServletRequest request){

		String prdememState = request.getParameter("prdememState");
		String prdememSum = request.getParameter("prdememSum");


		if (prdememState != null) {
			int i = Integer.parseInt(prdememState);
			if (i == 1 || i==2) {
				Prodetamem prodetamem=new Prodetamem();

				//标识码
				if (prdememSum != null) {
					int i1 = Integer.parseInt(prdememSum);
					prodetamem.setPrdememSum(i1);
				}
				prodetamem.setProId(proId);
				prodetamem.setPrdememId(prdememId);
				prodetamem.setPrdememState(i);
				prodetamem.setOrderByClause(OrderByClause);
				return prodetamemService.selectProdetamem(prodetamem,fenye,pageSize);
			}
		}
		return ResultUtil.error("状态有误");
	}
	/**
	 * 查询竞标项目信息
	 * @param proId
	 * @param prdememId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectPrdememMe")
	public Result selectPrdememMe(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
								  @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
								  Integer OrderByClause,String proId, String prdememId,HttpServletRequest request){

		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer != null) {
			String prdememState = request.getParameter("prdememState");
			String prdememSum = request.getParameter("prdememSum");

				if (prdememState != null) {
					int i = Integer.parseInt(prdememState);
					if (i == 1 || i==2 || i==0) {
						Prodetamem prodetamem=new Prodetamem();
						prodetamem.setProId(proId);
						if (prdememId!=null) {
							Studiomem studiomem = studiomemService.selectStudiomem2(prdememId, developer.getDevId());
							if (studiomem!=null) {
								prodetamem.setPrdememId(prdememId);
							}else {
								return ResultUtil.error("你不是这工作室的成员无法查看");
							}
						}else {
							prodetamem.setPrdememId(developer.getDevId());
						}
						//标识码
						if (prdememSum != null) {
							int i1 = Integer.parseInt(prdememSum);
							prodetamem.setPrdememSum(i1);
						}
						prodetamem.setPrdememState(i);
						prodetamem.setOrderByClause(OrderByClause);
						return prodetamemService.selectProdetamem(prodetamem,fenye, pageSize);
					}
				}
			return ResultUtil.error("状态有误");
		}
		return ResultUtil.error("你还没登录,请登录再试");
	}
}

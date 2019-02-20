package com.gdpi.maker.controller.userController;

import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.pojo.Project;
import com.gdpi.maker.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.pojo.Studiomem;
import com.gdpi.maker.service.StudiomemService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("Duplicates")
@Controller
@RequestMapping(value="/studiomem")
public class StudiomemController {

	@Resource(name="StudiomemServiceImpl")
	private StudiomemService studiomemService;

	/**
	 * 申请加入工作室
	 * @param stuId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insertStumem")
	public Result insertStumem(String stuId,HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			if (stuId != null) {
				return studiomemService.insertStudiomem(stuId, developer.getDevId());
			}
			return ResultUtil.error("工作室的不能Id为空");
		}
		return ResultUtil.error("你没有登录,请登录再试");
	}
	
	/*@ResponseBody
	@RequestMapping(value="/deleteStumem")
	public Result deleteStumem(String stuId,String devId){
		return studiomemService.deleteStudiomem(stuId, devId);
	}*/

	/**
	 * 修改私人的申请记录
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateStumemMe")
	public Result updateStumemMe(Integer stumemSum,HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			String stumemIs = request.getParameter("stumemIs");
			String stuId = request.getParameter("stuId");
			//查询记录
			Studiomem studiomem=new Studiomem();
			if (stumemSum != null && stumemSum!=0) {
				studiomem.setStumemSum(stumemSum);
			}
			studiomem.setDevId(developer.getDevId());
			studiomem.setStuId(stuId);

			//Studiomem studiomem1 = studiomemService.selectOneStudiomem(studiomem);
			//判定状态
			//if (studiomem1!=null) {

			if (stumemIs != null) {
				int i = Integer.parseInt(stumemIs);
				if (i == 0 || i==4 || i==5) {
					studiomem.setStumemIs(i);
					return studiomemService.updateStudiomem(studiomem);
				}
			}
			return ResultUtil.error("状态码有误");

			//}
			//return ResultUtil.error("此记录有误");
		}
		return ResultUtil.error("你没有登录,请登录再试");
	}

	/**
	 * 工作室负责人审核
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateStumem")
	public Result updateStumem(Integer stumemSum,HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			//接收数据
			String stuId = request.getParameter("stuId");
			String stumemIs = request.getParameter("stumemIs");
			String devId = request.getParameter("devId");
			//
			if (stumemIs!=null){
				int i = Integer.parseInt(stumemIs);
				if (i>1 && i<7){
					//Studiomem studiomem1 = studiomemService.selectStudiomem3(stuId, devId);
					//if (studiomem1.getStumemIs()!=0){
						//发布者
						if(stuId!=null){
							//判断是否有权限
							Studiomem studiomem2 = studiomemService.selectStudiomem2(stuId, developer.getDevId());
							if (studiomem2 !=null && studiomem2.getStumemPower()>1) {
								//if (studiomem1 != null) {
								Studiomem studiomem=new Studiomem();
								studiomem.setStumemSum(stumemSum);
								studiomem.setDevId(devId);
								studiomem.setStuId(stuId);
								studiomem.setStumemIs(i);
								return studiomemService.updateStudiomem(studiomem);
								//}
								//return ResultUtil.error("状态不对,请重新刷新");
							}else {
								return ResultUtil.error("你没权限修改2");
							}
						}
						return ResultUtil.error("工作室Id为空");
					//}
					//return ResultUtil.error("此记录不存在");
				}
				return ResultUtil.error("修改状态有误");
			}
		}
		return ResultUtil.error("你没有登录,请登录再试");
	}


	@ResponseBody
	@RequestMapping(value="/updateStumemPorwer")
	public Result updateStumemPorwer(HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			String stuId = request.getParameter("stuId");
			//String stumemIs = request.getParameter("stumemIs");
			String devId = request.getParameter("devId");

			//发布者
			if(stuId!=null){
				Studiomem studiomem1 = studiomemService.selectStudiomem2(stuId, devId);
				if (studiomem1!=null){
					Studiomem studiomem2 = studiomemService.selectStudiomem2(stuId, developer.getDevId());
					if (studiomem2 !=null && studiomem2.getStumemPower()>2) {
						//if (studiomem1.getStumemIs() == 2) {
							Studiomem studiomem=new Studiomem();
							studiomem.setDevId(devId);
							studiomem.setStuId(stuId);
							studiomem.setStumemPower(2);
							return studiomemService.updateStudiomem(studiomem);
						//}
						//return ResultUtil.error("状态不对,请重新刷新");
					}else {
						return ResultUtil.error("你没权限修改");
					}
				}
				return ResultUtil.error("此人不是工作室成员");
			}
			return ResultUtil.error("工作室Id为空");
		}
		return ResultUtil.error("你没有登录,请登录再试");
	}

	/**
	 * 查看自己的申请工作室记录
	 * @param fenye
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectStumemMe")
	public Result selectStumemMe(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							   @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
								Integer OrderByClause,Integer stumemPower, HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			String stuId = request.getParameter("stuId");
			String stumemIs = request.getParameter("stumemIs");

			Studiomem studiomem=new Studiomem();
			if (stumemIs != null) {
				int i = Integer.parseInt(stumemIs);
				if (0<=i && i<4) {
					studiomem.setStumemIs(i);
				}else {
					return ResultUtil.error("查询状态不对");
				}
			}
			studiomem.setDevId(stuId);
			if (stumemPower != null && stumemPower != 0 ) {
				studiomem.setStumemPower(stumemPower);
			}
			studiomem.setOrderByClause(OrderByClause);
			studiomem.setDevId(developer.getDevId());
			return studiomemService.selectStudiomem2(studiomem,fenye,pageSize);
		}
		return ResultUtil.error("你没有登录,请登录再试");
	}

	/**
	 * 查看工作室成员
	 * @param fenye
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectStumem")
	public Result selectStumem(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
								 @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
								 Integer OrderByClause,HttpServletRequest request){
		String stuId = request.getParameter("stuId");
		//String stumemIs = request.getParameter("stumemIs");
		Studiomem studiomem=new Studiomem();
		studiomem.setStuId(stuId);

		studiomem.setStumemIs(2);
		studiomem.setOrderByClause(OrderByClause);
		return studiomemService.selectStudiomem(studiomem,fenye,pageSize);
	}

	/*@ResponseBody
	@RequestMapping(value="/selectStumemMe2")
	public Result selectOneStumem(HttpServletRequest request){
		*//*Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){*//*
			String devId = request.getParameter("devId");
			String stuId = request.getParameter("stuId");
			Studiomem studiomem = studiomemService.selectStudiomem2(stuId, devId);
			return ResultUtil.success(studiomem,"工作室");
		*//*}
		return ResultUtil.error("你没有登录,请登录再试");*//*
	}*/
}

package com.gdpi.maker.controller.userController;


import com.gdpi.maker.pojo.*;
import com.gdpi.maker.service.PositionService;
import com.gdpi.maker.service.PositionmemService;
import com.gdpi.maker.service.StudiomemService;
import com.gdpi.maker.utils.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@SuppressWarnings("Duplicates")
@Controller
@RequestMapping(value="/positionmem")
public class PositionmemController {
	//@Qualifier("DaoImpl")        //实现类1的类名。注意区分与@Resource(name="dogImpl") 的区别。
	//@Autowired @Autowired 的注入方式是 byType 注入， 当要注入的类型在容器中存在多个时，Spring是不知道要引入哪个实现类的，所以会报错。

	@Resource(name="PositionmemServiceImpl")        //实现类1中 @Service注解中标定的名称
	private PositionmemService positionmemService;
	@Resource(name="PositionServiceImpl")
	private PositionService positionService;
	@Resource(name = "StudiomemServiceImpl")
	private StudiomemService studiomemService;

	/**
	 * 申请职位
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/insertPosmem")
	public Result insertPos(HttpServletRequest request) {
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer!=null) {
			String positionId = request.getParameter("positionId");
			if (positionId != null) {
				//String positionmemId = request.getParameter("positionmemId");
				return positionmemService.insertPositionmem(positionId,developer.getDevId());
			}
			return ResultUtil.error("职位Id为空!");
		}
		return ResultUtil.error("你还没登录,请登录再试!");
	}

	@ResponseBody
	@RequestMapping(value="/deletePosmem")
	public Result deletePosmem(@RequestParam(required = false,defaultValue = "0",value = "positionmenSum")Integer positionmenSum,
							   HttpServletRequest request) {
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer!=null) {

			String positionId = request.getParameter("positionId");
			String positionmemId = request.getParameter("positionmemId");

			Positionmem positionmem=new Positionmem();
			//申请人该改状态(只能撤销)
			if (positionmemId == null || positionmemId.equals("null")) {
				positionmem.setPositionmemId(developer.getDevId());
				//发布人审核
			}else {
				//判断工作室权限
				Position position2=positionService.selectPositionById2(positionId);
				String positionmemId1 = position2.getPositionmemId();
				Studiomem studiomem = studiomemService.selectStudiomem2(positionmemId1, developer.getDevId());
				if (studiomem != null && studiomem.getStumemPower()>1) {
					positionmem.setPositionmemId(positionmemId);
				}else {
					return ResultUtil.error("你没有权限!");
				}
			}

			positionmem.setPositionmemState(4);
			positionmem.setPositionmenSum(positionmenSum);
			positionmem.setPositionId(positionId);
			return positionmemService.updatePositionmem(positionmem);

		}
		return ResultUtil.error("你还没登录,请登录再试!");
	}
	
	@ResponseBody
	@RequestMapping(value="/updatePosmemStart")
	public Result updatePosmemStart(@RequestParam(required = false,defaultValue = "0",value = "positionmenSum")Integer positionmenSum,
									HttpServletRequest request) {
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer!=null) {

			String positionId = request.getParameter("positionId");
			String positionmemId = request.getParameter("positionmemId");
			String positionmemState = request.getParameter("positionmemState");

			Positionmem positionmem=new Positionmem();
			if (positionmemState != null) {
				int i = Integer.parseInt(positionmemState);
				//申请人该改状态(只能撤销)
				if (positionmemId == null || positionmemId.equals("null")) {
					switch (i){
						case 0:
							positionmem.setPositionmemState(0);
							break;
						case 3:
							positionmem.setPositionmemState(3);
							break;
						case 4:
							positionmem.setPositionmemState(4);
							break;
						default:
							return ResultUtil.error("职位状态有误!");
					}
					positionmem.setPositionmemId(developer.getDevId());
					//发布人审核
				}else {
					//判断工作室权限
					Position position2=positionService.selectPositionById2(positionId);
					String positionmemId1 = position2.getPositionmemId();
					Studiomem studiomem = studiomemService.selectStudiomem2(positionmemId1, developer.getDevId());
					if (studiomem != null && studiomem.getStumemPower()>1) {
						//只能修改录取成功
						switch (i){
							case 2:
								positionmem.setPositionmemState(2);
								break;
							default:
								return ResultUtil.error("职位状态有误!");
						}
						positionmem.setPositionmemId(positionmemId);
					}else {
						return ResultUtil.error("你没有权限!");
					}
				}
				positionmem.setPositionmenSum(positionmenSum);
				positionmem.setPositionId(positionId);
				return positionmemService.updatePositionmem(positionmem);
			}
			return ResultUtil.error("职位状态有误!");
		}
		return ResultUtil.error("你还没登录,请登录再试!");
	}
	
	@ResponseBody
	@RequestMapping(value="/selectPosmem")
	public Result selectPosmem(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							@RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							Integer forumWithBLOBs,HttpServletRequest request) {
		String positionId = request.getParameter("positionId");
		String positionmemId = request.getParameter("positionmemId");
		String positionmemState = request.getParameter("positionmemState");

		Positionmem positionmem=new Positionmem();
		if (positionmemState != null) {
			int i = Integer.parseInt(positionmemState);
			if (i == 2 || i==1) {
				positionmem.setPositionmemState(i);
			}else{
				return ResultUtil.error("职位状态有误!");
			}

		}
		positionmem.setOrderByClause(forumWithBLOBs);
		positionmem.setPositionmemId(positionmemId);
		positionmem.setPositionId(positionId);
		return positionmemService.selectPositionmem(positionmem,fenye,pageSize);
	}
	
	@ResponseBody
	@RequestMapping(value="/selectPosmemMe")
	public Result selectPosmemMe(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							   @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
								Integer forumWithBLOBs,HttpServletRequest request) {
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer != null) {

			String positionId = request.getParameter("positionId");
			//String positionmemId = request.getParameter("positionmemId");
			String positionmemState = request.getParameter("positionmemState");

			Positionmem positionmem=new Positionmem();
			if (positionmemState != null) {
				int i = Integer.parseInt(positionmemState);
				if (i < 4 && i >= 0) {
					positionmem.setPositionmemState(i);
				}else{
					return ResultUtil.error("状态码有误!");
				}
			}
			positionmem.setOrderByClause(forumWithBLOBs);
			positionmem.setPositionmemId(developer.getDevId());
			positionmem.setPositionId(positionId);
			return positionmemService.selectPositionmem(positionmem,fenye,pageSize);
		}
		return ResultUtil.error("你还没登录,请登录再试!");
	}
	

}

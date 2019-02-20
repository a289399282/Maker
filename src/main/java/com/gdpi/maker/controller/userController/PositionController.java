package com.gdpi.maker.controller.userController;


import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.pojo.Position;
import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.pojo.Studiomem;
import com.gdpi.maker.service.PositionService;
import com.gdpi.maker.service.StudiomemService;
import com.gdpi.maker.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@SuppressWarnings("Duplicates")
@Controller
@RequestMapping(value="/position")
public class PositionController {
	//@Qualifier("DaoImpl")        //实现类1的类名。注意区分与@Resource(name="dogImpl") 的区别。
	//@Autowired @Autowired 的注入方式是 byType 注入， 当要注入的类型在容器中存在多个时，Spring是不知道要引入哪个实现类的，所以会报错。

	@Resource(name="PositionServiceImpl")        //实现类1中 @Service注解中标定的名称
	private PositionService positionService;
	@Resource(name="StudiomemServiceImpl")
	private StudiomemService studiomemService;

	@ResponseBody
	@RequestMapping(value="/insertPos")
	public Result insertPos(@RequestParam(required = false,value="positionType")String[]  positionType,
							Integer positionState,Integer positionAmount,Date posEndtime, HttpServletRequest request) {
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer!=null) {
			Position position=new Position();
			String positionName = request.getParameter("posName");
			String positionmemId = request.getParameter("posMemId");
			//String positionAmount = request.getParameter("posAmount");
			String positionInfo = request.getParameter("posInfo");
			//String positionState = request.getParameter("posState");

			//结束时间
			if (posEndtime!=null) {
				position.setPositionEndtime(posEndtime);
			}
			//招聘人数
			if (positionAmount!=null) {
				position.setPositionAmount(positionAmount);
			}else {
				return ResultUtil.error("招聘人数错误");
			}
			//个人发布
			if (positionmemId==null || positionmemId.equals("null")) {
				position.setPositionmemId(developer.getDevId());
			}else {
				Studiomem studiomem = studiomemService.selectStudiomem2(positionmemId, developer.getDevId());
				if (studiomem!=null && studiomem.getStumemPower()>1) {
					//工作室发布
					position.setPositionmemId(positionmemId);
				}
				return ResultUtil.error("你不是负责人,没有权限!");
			}
			//状态
			if (positionState!=null) {
				position.setPositionState(positionState);
			}
			//类型
			String positionType2="";
			if (positionType != null) {
				for (String s: positionType) {
					positionType2+=s+"、";
				}
			}

			position.setPositionInfo(positionInfo);
			position.setPositionName(positionName);
			position.setPositionType(positionType2);
			return positionService.insertPosition(position);
		}
		return ResultUtil.error("你还没登录,请登录再试!");
	}
	
	@ResponseBody
	@RequestMapping(value="/updatePosStart")
	public Result updatePosStart(String positionId,HttpServletRequest request) {
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer!=null) {
			if (positionId!=null) {
				Position position = new Position();
				position.setPositionId(positionId);

				String positionmemId = request.getParameter("posMemId");
				String positionState = request.getParameter("posState");

				//个人发布
				if (positionmemId==null) {
					position.setPositionmemId(developer.getDevId());
				}else {
					Studiomem studiomem = studiomemService.selectStudiomem2(positionmemId, developer.getDevId());
					if (studiomem!=null && studiomem.getStumemPower()>1) {
						//工作室发布
						position.setPositionmemId(positionmemId);

					}else{
						return ResultUtil.error("你不是负责人,没有权限!");
					}
				}

				if (positionState!=null) {
					int positionstate2 = Integer.parseInt(positionState);
					position.setPositionState(positionstate2);

				}
				return positionService.updatePosition(position);
			}
			return ResultUtil.error("职位Id为空!");
		}
		return ResultUtil.error("你还没登录,请登录再试!");
	}
	
	@ResponseBody
	@RequestMapping(value="/updatePos")
	public Result updatePos(Date posEndtime,HttpServletRequest request) {
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer!=null) {
			Position position=new Position();
			
			String positionmemId = request.getParameter("posMemId");
			String positionName = request.getParameter("posName");
			String positionAmount = request.getParameter("posAmount");
			String positionInfo = request.getParameter("posInfo");
			String positionState = request.getParameter("posState");
			String positionId = request.getParameter("positionId");

			position.setPositionId(positionId);
			//招聘人数
			if (positionAmount!=null) {
				position.setPositionAmount(Integer.parseInt(positionAmount));
			}
			//招聘结束时间
			if (posEndtime!=null) {
				position.setPositionEndtime(posEndtime);
			}
			
			//个人发布
			if (positionmemId==null || positionmemId.equals("null")) {
				position.setPositionmemId(developer.getDevId());
			}else {
				Studiomem studiomem = studiomemService.selectStudiomem2(positionmemId, developer.getDevId());
				if (studiomem!=null && studiomem.getStumemPower()>1) {
					//工作室发布
					position.setPositionmemId(positionmemId);
				}else {
					return ResultUtil.error("你不是负责人,没有权限!");
				}
			}
			//状态码
			if (positionState!=null) {
				int positionstate2 = Integer.parseInt(positionState);
				position.setPositionState(positionstate2);

			}
			position.setPositionInfo(positionInfo);
			position.setPositionName(positionName);
			return positionService.updatePosition(position);
		}
		return ResultUtil.error("你还没登录,请登录再试!");
	}
	
	@ResponseBody
	@RequestMapping(value="/selectPos")
	public Result selectPos(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							@RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							Integer OrderByClause,HttpServletRequest request, Date posEndtime, Date posReltime) {
		Position position=new Position();
		
		String positionmemId = request.getParameter("posMemId");
		String positionName = request.getParameter("posName");
		//String positionAmount = request.getParameter("posAmount");
		String posType = request.getParameter("posType");
		String positionState = request.getParameter("posState");
		
		//招聘人数
		/*if (positionAmount!=null) {
			position.setPositionAmount(Integer.parseInt(positionAmount));
		}*/
		//招聘结束时间
		if (posEndtime!=null) {
			position.setPositionEndtime(posEndtime);
		}
		//招聘开始时间
		if (posReltime!=null) {
			position.setPositionReltime(posReltime);
		}
		
		//职位状态
		if (positionState!=null) {
			int positionstate2 = Integer.parseInt(positionState);
			if (positionstate2 == 2 ||positionstate2==3) {
				position.setPositionState(positionstate2);
			}
			return ResultUtil.error("查询职位状态有误");
		}
		position.setPositionType(posType);
		position.setOrderByClause(OrderByClause);
		position.setPositionmemId(positionmemId);
		//position.setPositionInfo(positionInfo);
		position.setPositionName(positionName);
		return positionService.selectPosition(position,fenye,pageSize);
	}
	
	@ResponseBody
	@RequestMapping(value="/selectPosMe")
	public Result selectOnePos(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							   @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							   Integer OrderByClause,HttpServletRequest request, Date posEndtime, Date posReltime) {
		Position position=new Position();
		
		String positionmemId = request.getParameter("posmemId");
		String positionName = request.getParameter("posName");
		//String positionAmount = request.getParameter("posAmount");
		//String positionInfo = request.getParameter("posInfo");
		String positionState = request.getParameter("posState");
		String posType = request.getParameter("posType");

		//招聘人数
		/*if (positionAmount!=null) {
			position.setPositionAmount(Integer.parseInt(positionAmount));
		}*/
		//招聘结束时间
		if (posEndtime!=null) {
			position.setPositionEndtime(posEndtime);
		}
		//招聘开始时间
		if (posReltime!=null) {
			position.setPositionReltime(posReltime);
		}
		
		//职位状态
		if (positionState!=null) {
			int positionstate2 = Integer.parseInt(positionState);
			if (positionstate2==1|| positionstate2==2 || positionstate2==3) {
				position.setPositionState(positionstate2);
			}
			return ResultUtil.error("状态码有误");
		}
		position.setOrderByClause(OrderByClause);
		position.setPositionType(posType);
		position.setPositionmemId(positionmemId);
		//position.setPositionInfo(positionInfo);
		position.setPositionName(positionName);
		return positionService.selectPosition(position,fenye,pageSize);
	}
	
	@ResponseBody
	@RequestMapping(value="/selectPosById")
	public Result selectPosById(String positionId) {
		return positionService.selectPositionById(positionId);
	}

	@ResponseBody
	@RequestMapping(value="/rankingsPos")
	public Result rankingsPos(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							  @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							  Integer OrderByClause,HttpServletRequest request) {

		Position position=new Position();
		position.setOrderByClause(OrderByClause);

		return positionService.rankingsPos(position,fenye,pageSize);
	}
}

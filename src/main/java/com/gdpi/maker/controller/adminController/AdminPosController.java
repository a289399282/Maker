package com.gdpi.maker.controller.adminController;

/*

import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.pojo.Position;
import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.pojo.Studiomem;
import com.gdpi.maker.service.PositionService;
import com.gdpi.maker.service.StudiomemService;
import com.gdpi.maker.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value="/admin/position")
public class AdminPosController {
	@Resource(name="AdminPositionServiceImpl")
	private PositionService positionService;
	@Resource(name="AdminStudiomemServiceImpl")
	private StudiomemService studiomemService;

	@ResponseBody
	@RequestMapping(value="/insertPos")
	public Result insertPos(Date posEndtime, HttpServletRequest request) {
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer!=null) {
			Position position=new Position();
			String positionName = request.getParameter("posName");
			String positionmemId = request.getParameter("posMemId");
			String positionAmount = request.getParameter("posAmount");
			String positionInfo = request.getParameter("posInfo");
			String positionState = request.getParameter("posState");

			//结束时间
			if (posEndtime!=null) {
				position.setPositionEndtime(posEndtime);
			}
			//招聘人数
			if (positionAmount==null) {
				return ResultUtil.error("招聘人数错误");
			}
			position.setPositionAmount(Integer.parseInt(positionAmount));

			//个人发布
			if (positionmemId==null) {
				position.setPositionmemId(developer.getDevId());
			}else {
				Studiomem studiomem = studiomemService.selectStudiomem2(positionmemId, developer.getDevId());
				if (studiomem!=null && studiomem.getStumemPower()>1) {
					//工作室发布
					position.setPositionmemId(positionmemId);

				}
				return ResultUtil.error("你不是负责人,没有权限!");
			}


			if (positionState!=null) {
				int positionstate2 = Integer.parseInt(positionState);
				position.setPositionState(positionstate2);

			}
			position.setPositionInfo(positionInfo);
			position.setPositionName(positionName);
			
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
			if (positionmemId==null) {
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
							HttpServletRequest request, Date posEndtime, Date posReltime) {
		Position position=new Position();
		
		String positionmemId = request.getParameter("posMemId");
		String positionName = request.getParameter("posName");
		//String positionAmount = request.getParameter("posAmount");
		String positionInfo = request.getParameter("posInfo");
		String positionState = request.getParameter("posState");
		
		//招聘人数
		*/
/*if (positionAmount!=null) {
			position.setPositionAmount(Integer.parseInt(positionAmount));
		}*//*

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
			position.setPositionState(positionstate2);
			
		}
		position.setPositionmemId(positionmemId);
		position.setPositionInfo(positionInfo);
		position.setPositionName(positionName);
		return positionService.selectPosition(position,fenye,pageSize);
	}
	
	@ResponseBody
	@RequestMapping(value="/selectOnePos")
	public Result selectOnePos(HttpServletRequest request, Date posEndtime, Date posReltime) {
		Position position=new Position();
		
		String positionmemId = request.getParameter("posmemId");
		String positionName = request.getParameter("posName");
		String positionAmount = request.getParameter("posAmount");
		String positionInfo = request.getParameter("posInfo");
		String positionState = request.getParameter("posState");
		
		//招聘人数
		if (positionAmount!=null) {
			position.setPositionAmount(Integer.parseInt(positionAmount));
		}
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
			if (positionstate2==1| positionstate2==2 | positionstate2==3) {
				position.setPositionState(positionstate2);
			}
			return ResultUtil.error("状态码有误");
		}
		position.setPositionmemId(positionmemId);
		position.setPositionInfo(positionInfo);
		position.setPositionName(positionName);
		return positionService.selectOnePosition(position);
	}
	
	@ResponseBody
	@RequestMapping(value="/selectPosById")
	public Result selectPosById(String positionId) {
		return positionService.selectPositionById(positionId);
	}
}
*/

package com.gdpi.maker.controller.adminController;
/*

import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.pojo.Type;
import com.gdpi.maker.service.TypeService;
import com.gdpi.maker.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/admin/type")
public class AdminTypeController {
	@Resource(name="AdminTypeServiceImpl")
	private TypeService typeService;
	*/
/**
	 * 添加
	 * @param request
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value = "/insertType")
	public Result insertPrde(HttpServletRequest request) {
		Type type=new Type();
		
		String tpName = request.getParameter("tpName");
		String tpCareer = request.getParameter("tpCareer");
		String tpStyle = request.getParameter("tpStyle");
		
		type.setTpCareer(tpCareer);
		type.setTpName(tpName);
		type.setTpStyle(tpStyle);
		
		return typeService.insertType(type);
	}
	*/
/**
	 * 删除
	 * @param typeId
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value = "/deleteType")
	public Result deletePrde(String typeId) {
		if (typeId!=null) {
			return typeService.deleteType(typeId);
		}
		return ResultUtil.error("typeId不能为空");
	}
	
	*/
/**
	 * 修改
	 * @param request
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value = "/updateType")
	public Result updatePrde(HttpServletRequest request) {
		Type type=new Type();
		
		String tpName = request.getParameter("tpName");
		String tpCareer = request.getParameter("tpCareer");
		String tpStyle = request.getParameter("tpStyle");
		String tpId = request.getParameter("tpId");

		type.setTpId(tpId);
		type.setTpCareer(tpCareer);
		type.setTpName(tpName);
		type.setTpStyle(tpStyle);
		
		return typeService.updateType(type);
	}
	*/
/**
	 * 查询
	 * @param
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value = "/selectType")
	public Result selectType(@RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,HttpServletRequest request) {
		Type type=new Type();
		
		String tpName = request.getParameter("tpName");
		String tpCareer = request.getParameter("tpCareer");
		String tpStyle = request.getParameter("tpStyle");
		String tpId = request.getParameter("tpId");

		type.setTpId(tpId);
		type.setTpCareer(tpCareer);
		type.setTpName(tpName);
		type.setTpStyle(tpStyle);
		
		//PageHelper.startPage(fy,5);
		return typeService.selectType(type,fenye);
		//PageInfo pageInfo = new PageInfo<>(result.getData(),5);
		//result.getData();
	}
	*/
/**
	 * 查询
	 * @param
	 * @return
	 *//*

	@ResponseBody
	@RequestMapping(value = "/countType")
	public Result countByExample(HttpServletRequest request) {
		Type type=new Type();

		String tpName = request.getParameter("tpName");
		String tpCareer = request.getParameter("tpCareer");
		String tpStyle = request.getParameter("tpStyle");
		String tpId = request.getParameter("tpId");

		type.setTpId(tpId);
		type.setTpCareer(tpCareer);
		type.setTpName(tpName);
		type.setTpStyle(tpStyle);

		return typeService.countByExample(type);
	}
}
*/

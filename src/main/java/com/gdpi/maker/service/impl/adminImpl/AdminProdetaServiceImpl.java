/*
package com.gdpi.maker.service.impl.adminImpl;

import com.gdpi.maker.dao.DeveloperDao;
import com.gdpi.maker.dao.ProdetaDao;
import com.gdpi.maker.dao.ProjectDao;
import com.gdpi.maker.pojo.*;
import com.gdpi.maker.service.ProdetaService;
import com.gdpi.maker.service.StudioService;
import com.gdpi.maker.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service("AdminProdetaServiceImpl")
public class AdminProdetaServiceImpl implements ProdetaService {
	@Autowired
	private ProdetaDao prodetaDao;
	@Autowired
	private DeveloperDao developerDao;
	@Resource(name="AdminStudioServiceImpl")
	private StudioService studioService;
	@Autowired
	private ProjectDao projectDao;

	@Override
	public Result insertPrde(String proId, String prdeIswin) {
		Prodeta prodeta=new Prodeta();
		prodeta.setProId(proId);
		prodeta.setPrdeIswin(prdeIswin);
		Prodeta prodeta1 = prodetaDao.selectOneProdeta(prodeta);
		if (prodeta1==null) {
			String substring = prdeIswin.substring(0, 3);
			if ("Stu".equals(substring)) {
				Studio studio = studioService.selectStudioByIdExist(prdeIswin);
				if (studio==null){
					return ResultUtil.error("此申请的工作室不存在");
				}
			}else if ("Dev".equals(substring)){
				Developer developer = developerDao.selectDevByIdExist(prdeIswin);
				if (developer==null){
					return ResultUtil.error("此申请开发者不存在");
				}
			}else {
				return ResultUtil.error("错误");
			}
			Project project = projectDao.selectByPrimaryKey(proId);
			if (project != null) {
				if (project.getProState() == 1) {
					int i = prodetaDao.insertPrde(proId, prdeIswin);
					if (i == 1) {
						return ResultUtil.success(null, "添加成功");
					}
					return ResultUtil.error("添加失败");
				}
				return ResultUtil.error("项目已结束");
			}
			return ResultUtil.error("项目不存在");
		}
		return ResultUtil.error("此申请已同意");
	}

	@Override
	public Result deletePrde(String proId, String prdeIswin) {
		int i = prodetaDao.deletePrde(proId, prdeIswin);
		if (i!=1) {
			return ResultUtil.error("删除失败");
		}
		return ResultUtil.success(null, "删除成功");
	}

	@Override
	public Result updatePrde(Prodeta prodeta) {
		int i = prodetaDao.updatePrde(prodeta);
		if (i!=1) {
			return ResultUtil.error("修改失败");
		}
		return ResultUtil.success(null, "修改成功");
	}

	@Override
	public Result selectPrde(Prodeta prodeta, Integer fenye, Integer pageSize) {
		PageHelper.startPage(fenye,pageSize);
		List<Prodeta> list = prodetaDao.selectPrde(prodeta);
		PageInfo pageInfo = new PageInfo<>(list,0);
		int size = pageInfo.getSize();
		if(size!=0){
			List<ProdetaCut> listCut=new ArrayList<ProdetaCut>();
			ProdetaCut prodetaOne;
			Prodeta prodeta2;
			try {
				List list1 = pageInfo.getList();
				for (int i=0;i<size;i++) {
					prodetaOne=new ProdetaCut();
					prodeta2=new Prodeta();
					prodeta2  = (Prodeta) list1.get(i);
					BeanUtils.copyProperties(prodetaOne, prodeta2);
					Developer developer = developerDao.selectDeveloperById(prodeta2.getPrdeIswin());
					prodetaOne.setPrdeIswinName(developer.getDevTruename());
					listCut.add(prodetaOne);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return ResultUtil.success(listCut, "查询成功",pageInfo.getTotal());
		}
		return ResultUtil.success(null, "没有数据");
	}

}
*/

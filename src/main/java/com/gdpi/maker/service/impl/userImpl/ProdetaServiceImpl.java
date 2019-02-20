package com.gdpi.maker.service.impl.userImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.maker.dao.*;
import com.gdpi.maker.pojo.*;
import com.gdpi.maker.service.StudioService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdpi.maker.service.ProdetaService;
import com.gdpi.maker.utils.ResultUtil;

import javax.annotation.Resource;

@SuppressWarnings("Duplicates")
@Service("ProdetaServiceImpl")
public class ProdetaServiceImpl implements ProdetaService {
	@Autowired
	private ProdetaDao prodetaDao;
	@Autowired
	private DeveloperDao developerDao;
	@Resource(name="StudioServiceImpl")
	private StudioService studioService;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private StudioDao studioDao;
	@Autowired
	private ProdetamemDao prodetamemDao;

	@Override
	public Result insertPrde(String proId, String prdeIswin) {

		Prodeta prodeta=new Prodeta();
		prodeta.setProId(proId);
		prodeta.setPrdeIswin(prdeIswin);
		Prodeta prodeta1 = prodetaDao.selectOneProdeta(prodeta);
		//判断有记录,如有记录说明已经同意
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
			if (project != null && project.getProState() == 1) {
					int i = prodetaDao.insertPrde(proId, prdeIswin);
					if (i == 1) {
						//把Prodetamem表里状态修改成功
						Prodetamem prodetamem1=new Prodetamem();
						prodetamem1.setPrdememState(2);
						prodetamem1.setProId(proId);
						prodetamem1.setPrdememId(prdeIswin);
						prodetamem1.setPrdememSum(0);
						i = prodetamemDao.updateProdetamem(prodetamem1);
						if (i == 1) {
							return ResultUtil.success(null, "添加成功");
						}
						return ResultUtil.error("添加失败");
					}
					return ResultUtil.error("添加失败");
				}
			return ResultUtil.error("项目不存在或项目已结束");
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
		if (i==1) {
			if (prodeta.getPrdeState() == 2) {
				String prdeIswin = prodeta.getPrdeIswin();
				String substring = prdeIswin.substring(0, 3);
				i=0;
				if ("Dev".equals(substring)) {
					Developer developer = developerDao.selectDeveloperById(prdeIswin);
					Developer developer1=new Developer();
					developer1.setDevId(developer.getDevId());
					developer1.setDevPraise(developer.getDevPraise()+1);
					i = developerDao.updateDeveloper(developer1);
				}else if ("Stu".equals(substring)) {
					Studio studio1 = studioDao.selectStudioById(prdeIswin);
					Studio studio=new Studio();
					studio.setStuId(studio1.getStuId());
					studio.setStuPraise(studio1.getStuPraise()+1);
					i = studioDao.updateStudio(studio);
				}
				if (i != 1) {
					return ResultUtil.error("修改失败");
				}
			}
			return ResultUtil.success(null, "修改成功");
		}
		return ResultUtil.error("修改失败");
	}

	@Override
	public Result selectPrde(Prodeta prodeta, Integer fenye, Integer pageSize) {
		PageHelper.startPage(fenye,pageSize);
		List<Prodeta> list = prodetaDao.selectPrde(prodeta);
		PageInfo pageInfo = new PageInfo<>(list,0);
		int size = pageInfo.getSize();
		if(size!=0){
			List<ProdetaCut> listCut=new ArrayList<ProdetaCut>();
			ProdetaCut prodetaCut;
			Prodeta prodeta2;
			try {
				List list1 = pageInfo.getList();
				for (int i=0;i<size;i++) {
					prodetaCut=new ProdetaCut();
					prodeta2  = (Prodeta) list1.get(i);
					BeanUtils.copyProperties(prodetaCut, prodeta2);
					String prdeIswinId =prodeta2.getPrdeIswin();
					String substring = prdeIswinId.substring(0,3);
					if (substring.equals("Dev")) {
						Developer developer = developerDao.selectDeveloperById(prdeIswinId);
						prodetaCut.setPrdeIswinName(developer.getDevTruename());
					}else{
						Studio studio = studioDao.selectStudioById(prdeIswinId);
						prodetaCut.setPrdeIswinName(studio.getStuName());
					}
					Project project = projectDao.selectByPrimaryKey(prodetaCut.getProId());
					prodetaCut.setProName(project.getProName());
					listCut.add(prodetaCut);
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

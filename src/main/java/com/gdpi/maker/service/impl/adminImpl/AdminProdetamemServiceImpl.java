/*
package com.gdpi.maker.service.impl.adminImpl;

import com.gdpi.maker.dao.DeveloperDao;
import com.gdpi.maker.dao.ProdetamemDao;
import com.gdpi.maker.dao.ProjectDao;
import com.gdpi.maker.dao.StudioDao;
import com.gdpi.maker.pojo.*;
import com.gdpi.maker.service.ProdetamemService;
import com.gdpi.maker.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("Duplicates")
@Service("AdminProdetamemServiceImpl")
public class AdminProdetamemServiceImpl implements ProdetamemService {
	@Autowired
	private ProdetamemDao prodetamemDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private StudioDao studioDao;
	@Autowired
	private DeveloperDao developerDao;

	@Override
	public Result insertProdetamem(String proId, String prdememId) {
		Project project = projectDao.selectByPrimaryKey(proId);
		if (project != null && project.getProState()==1) {
			//判断是否是发布人自己申请
			if (!project.getProPublisher().equals(prdememId)) {
				Prodetamem prodetamem=new Prodetamem();
				prodetamem.setProId(proId);
				prodetamem.setPrdememId(prdememId);

				//查询记录
				List<Prodetamem> prodetamems = prodetamemDao.selectProdetamem(prodetamem);
				if (prodetamems.size() != 0) {
					for (Prodetamem prodetamem2: prodetamems ) {
						Integer prdememState = prodetamem2.getPrdememState();
						if (prdememState==1) {
							return ResultUtil.error("已经参加,请不要重复参加");
						}
						if (prdememState==2) {
							return ResultUtil.error("已经成功被录用,请不要重复参加");
						}
					}
				}
				//设置标识码
				prodetamem.setPrdememSum(prodetamems.size()+1);
				int i = prodetamemDao.insertProdetamem(prodetamem);
				if(i==1){
					return ResultUtil.success(null, "参加成功");
				}
				return ResultUtil.error("参加失败");
			}
			return ResultUtil.error("项目发布人自己不能申请");
		}
		return ResultUtil.error("此项目已结束申请或项目不存在");
	}

	@Override
	public Result deleteProdetamem(Prodetamem prodetamem) {
		*/
/*Prodetamem prodetamem=new Prodetamem();
		prodetamem.setProId(proId);
		prodetamem.setPrdememId(prdememId);
		Prodetamem prodetamem2 = prodetamemDao.selectOneProdetamem(prodetamem);
		if(prodetamem2==null){
			return ResultUtil.error("此记录不存在");
		}
		int i = prodetamemDao.deleteProdetamem(proId, prdememId);
		if(i!=1){
			return ResultUtil.error("删除失败");
		}
		return ResultUtil.success(null, "删除成功");*//*

		return null;
	}

	@Override
	public Result updateProdetamem(Prodetamem prodetamem) {
		if (prodetamem.getPrdememSum() != null) {
			//查询记录,判断是否有申请记录
			Prodetamem prodetamem2 = new Prodetamem();
			prodetamem2.setPrdememId(prodetamem.getPrdememId());
			prodetamem2.setProId(prodetamem.getProId());

			Prodetamem prodetamem1 = prodetamemDao.selectOneProdetamem(prodetamem2);
			if(prodetamem1!=null){
				int i = prodetamemDao.updateProdetamem(prodetamem);
				if(i==1){
					return ResultUtil.success(null, "修改成功");
				}
				return ResultUtil.error("修改失败");
			}
			return ResultUtil.error("此记录不存在");
		}
		return ResultUtil.error("标识码为空");
	}

	@Override
	public Result selectProdetamem(Prodetamem prodetamem, Integer fenye, Integer pageSize) {
		//分页
		PageHelper.startPage(fenye,pageSize);
		List<Prodetamem> list = prodetamemDao.selectProdetamem(prodetamem);
		PageInfo pageInfo = new PageInfo<>(list);
		int size = pageInfo.getSize();
		if(size!=0){
			List<ProdetamemCut> listCut=new ArrayList<ProdetamemCut>();
			ProdetamemCut prodetamemCut;
			Prodetamem prodetamem2;
			try {
				List list1 = pageInfo.getList();
				for (int i=0;i<size;i++) {
					//prodetamem2=new Prodetamem();
					prodetamemCut=new ProdetamemCut();
					prodetamem2= (Prodetamem) list1.get(i);
					BeanUtils.copyProperties(prodetamemCut, prodetamem2);
					//设置项目名
					Project project = projectDao.selectByPrimaryKey(prodetamemCut.getProId());
					prodetamemCut.setProName(project.getProName());
					//设置竞标成功人的名称
					String prdememId = prodetamem2.getPrdememId();
					String substring = prdememId.substring(0, 3);
					if (substring.equals("Dev")) {
						Developer developer = developerDao.selectDeveloperById(prdememId);
						prodetamemCut.setPrdeIswinName(developer.getDevName());
					}else if (substring.equals("Stu")){
						Studio studio = studioDao.selectStudioById(prdememId);
						prodetamemCut.setPrdeIswinName(studio.getStuName());
					}
					listCut.add(prodetamemCut);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			return ResultUtil.success(listCut, "查询成功",pageInfo.getTotal());
		}
		return ResultUtil.success(null, "查无此数据");
	}

	*/
/**
	 * 按条件查询一条记录
	 * @param proId
	 * @param prdememId
	 * @return
	 *//*

	@Override
	public Prodetamem selectProdetamem2(String proId, String prdememId) {
		Prodetamem prodetamem=new Prodetamem();
		prodetamem.setPrdememId(prdememId);
		prodetamem.setProId(proId);
		prodetamem.setPrdememState(1);
		return prodetamemDao.selectOneProdetamem(prodetamem);
	}
}
*/

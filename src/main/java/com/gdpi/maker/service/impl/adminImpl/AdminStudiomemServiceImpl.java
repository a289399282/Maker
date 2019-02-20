/*
package com.gdpi.maker.service.impl.adminImpl;

import com.gdpi.maker.dao.DeveloperDao;
import com.gdpi.maker.dao.StudioDao;
import com.gdpi.maker.dao.StudiomemDao;
import com.gdpi.maker.pojo.*;
import com.gdpi.maker.service.StudiomemService;
import com.gdpi.maker.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
@Service("AdminStudiomemServiceImpl")
public class AdminStudiomemServiceImpl implements StudiomemService {
	@Autowired
	private StudiomemDao studiomemDao;
	@Autowired
	private StudioDao studioDao;
	@Autowired
	private DeveloperDao developerDao;

	@Override
	public Result insertStudiomem(String stuId, String devId) {
		*/
/*Developer developer = developerDao.selectDevByIdExist(devId);
		if (developer != null) {*//*

		Studio studio = studioDao.selectStuByIdExist(stuId);
		if (studio != null) {
			//查询记录
			Studiomem studiomem=new Studiomem();
			studiomem.setDevId(devId);
			studiomem.setStuId(stuId);
			List<Studiomem> studiomems = studiomemDao.selectStudiomemAll(studiomem);
			//判断是否有拉黑,重复申请的情况
			for (Studiomem studiomem2: studiomems) {
				if(studiomem2.getStumemIs()==1){
					return ResultUtil.error("你已提交申请,请不要重复申请");
				}else if(studiomem2.getStumemIs()==2){
					return ResultUtil.error("你已是工作室成员,请不要申请");
				}else if (studiomem2.getStumemIs()==6) {
					return ResultUtil.error("对不起,这个工作室你申请失败");
				}
			}
//				if (studiomem==null) {
			studiomem.setStumemSum((studiomems.size()+1));
			int i = studiomemDao.insertStudiomem(studiomem);
			if (i==1) {
				return ResultUtil.success(null, "申请成功");
			}
			return ResultUtil.error("申请失败");
//				}
//				return ResultUtil.error("你已提交申请,请不要重复申请");
		}
		return ResultUtil.error("工作室不存在");
		*/
/*}
		return ResultUtil.error("申请人状态有误");*//*

	}

	@Override
	public Result deleteStudiomem(String stuId, String devId) {
		*/
/*Developer developer = developerDao.selectDevByIdExist(devId);
		if (developer != null) {
			Studio studio = studioDao.selectStuByIdExist(stuId);
			if (studio != null) {*//*

				*/
/*Studiomem studiomem=new Studiomem();
				studiomem.setDevId(devId);
				studiomem.setStuId(stuId);
				studiomem = studiomemDao.selectOneStudiomem(studiomem);
				if (studiomem!=null) {
					int i = studiomemDao.deleteStudiomem(stuId, devId);
					if (i!=1) {
						return ResultUtil.error("删除失败");
					}
					return ResultUtil.success(null, "删除成功");
				}
				return ResultUtil.error("没有此记录");*//*

			*/
/*}
			return ResultUtil.error("工作室不存在");
		}
		return ResultUtil.error("申请人状态有误");*//*

		return null;
	}

	@Override
	public Result updateStudiomem(Studiomem studiomem) {
		//查找是否已经成为工作室成员
		*/
/*Studiomem studiomem2=new Studiomem();
		studiomem2.setDevId(studiomem.getDevId());
		studiomem2.setStuId(studiomem.getStuId());
		List<Studiomem> studiomems = studiomemDao.selectStudiomem(studiomem2);*//*

		Studiomem studiomem2 = studiomemDao.selectOneStudiomem(studiomem);
		if (studiomem2!=null) {
			*/
/*for (Studiomem studiomem1:studiomems) {
				//如果已经是返回信息
				if (studiomem1.getStumemIs()==2) {
					return ResultUtil.error("此人已是工作室成员");
				}
			}*//*

			//判断地否是修改成同样的状态
			if (!studiomem2.getStumemIs().equals(studiomem.getStumemIs())) {
				//如果是同意,把power码改成1
				if (studiomem.getStumemIs() == 2) {
					studiomem.setStumemPower(1);
				}
				int i = studiomemDao.updateStudiomem(studiomem);
				if (i==1) {
					return ResultUtil.success(null, "修改成功");
				}
				return ResultUtil.error("修改失败");
			}
			return ResultUtil.error("已是这种状态");
		}
		return ResultUtil.error("没有此记录");
	}

	@Override
	public Result selectStudiomem(Studiomem studiomem,Integer fenye,Integer pageSize) {
		//分页
		PageHelper.startPage(fenye,pageSize);
		List<Studiomem> list = studiomemDao.selectStudiomemAll(studiomem);
		PageInfo pageInfo = new PageInfo<>(list);
		int size = pageInfo.getSize();
		if (size!=0) {
			//封装数据
			List<StudiomemCut> stuCutlist=new ArrayList<StudiomemCut>();
			StudiomemCut studiomemCut;
			Studiomem studiomem1;
			Studio studio;
			Developer developer;
			try {
				List list1 = pageInfo.getList();
				for (int i=0;i<size;i++) {
					studiomemCut=new StudiomemCut();
					//studiomem1=new Studiomem();
					studiomem1= (Studiomem) list1.get(i);
					BeanUtils.copyProperties(studiomemCut, studiomem1);
					//设置工作室名
					studio = studioDao.selectStudioById(studiomem1.getStuId());
					//设置用户名
					developer = developerDao.selectDeveloperById(studiomem1.getDevId());

					studiomemCut.setDevName(developer.getDevName());
					studiomemCut.setStuName(studio.getStuName());
					stuCutlist.add(studiomemCut);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			return ResultUtil.success(stuCutlist, "查询成功",pageInfo.getTotal());
		}
		return ResultUtil.success(null,"无数据");
	}
	@Override
	public Result selectStudiomem2(Studiomem studiomem,Integer fenye,Integer pageSize) {
		//分页
		PageHelper.startPage(fenye,10);
		List<Studiomem> list = studiomemDao.selectStudiomemMe(studiomem);
		PageInfo pageInfo = new PageInfo<>(list,0);
		int size = pageInfo.getSize();
		if (size!=0) {

			List<StudiomemCut> stuCutlist=new ArrayList<StudiomemCut>();
			StudiomemCut studiomemCut;
			Studiomem studiomem1;
			Studio studio;
			Developer developer;
			try {
				List list1 = pageInfo.getList();
				for (int i=0;i<size;i++) {
					studiomemCut=new StudiomemCut();
					studiomem1= (Studiomem) list1.get(i);
					BeanUtils.copyProperties(studiomemCut, studiomem1);
					//设置工作室名
					studio = studioDao.selectStudioById(studiomem1.getStuId());
					//设置用户名
					developer = developerDao.selectDeveloperById(studiomem1.getDevId());

					studiomemCut.setDevName(developer.getDevName());
					studiomemCut.setStuName(studio.getStuName());
					stuCutlist.add(studiomemCut);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			return ResultUtil.success(stuCutlist, "查询成功",pageInfo.getTotal());
		}
		return ResultUtil.error("无数据");
	}

	*/
/**
	 * Id查找已经成为工作室成员的人员
	 * @param stuId 工作室Id
	 * @param devId 申请人Id
	 * @return
	 *//*

	@Override
	public Studiomem selectStudiomem2(String stuId, String devId) {
		Studiomem studiomem=new Studiomem();
		studiomem.setDevId(devId);
		studiomem.setStuId(stuId);
		studiomem.setStumemIs(2);
		Studiomem studiomem1 = studiomemDao.selectOneStudiomem(studiomem);
		return studiomem1;
	}
	*/
/**
	 * Id查找未成为工作室成员的人员
	 * @param stuId 工作室Id
	 * @param devId 申请人Id
	 * @return
	 *//*

	@Override
	public Studiomem selectStudiomem3(String stuId, String devId) {
		Studiomem studiomem=new Studiomem();
		studiomem.setDevId(devId);
		studiomem.setStuId(stuId);
		studiomem.setStumemIs(1);
		Studiomem studiomem1 = studiomemDao.selectOneStudiomem(studiomem);
		return studiomem1;
	}

	@Override
	public Studiomem selectOneStudiomem(Studiomem studiomem) {
		Studiomem studiomem1 = studiomemDao.selectOneStudiomem(studiomem);
		return studiomem1;
	}

	@Override
	public List<Studiomem> selectStudiomem(Studiomem studiomem) {
		//List<Studiomem> studiomems = studiomemDao.selectStudiomemAll(studiomem);
		return null;
	}
}
*/

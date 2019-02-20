package com.gdpi.maker.service.impl.userImpl;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.gdpi.maker.dao.DeveloperDao;
import com.gdpi.maker.dao.StudiomemDao;
import com.gdpi.maker.pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdpi.maker.dao.StudioDao;
import com.gdpi.maker.service.StudioService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.StringUtils;

@SuppressWarnings("Duplicates")
@Service("StudioServiceImpl")
public class StudioServiceImpl implements StudioService {
	@Autowired
	private StudioDao studioDao;
	@Autowired
	private DeveloperDao developerDao;
	@Autowired
	private StudiomemDao studiomemDao;

	@Override
	public Result insertStudio(Studio studio) throws ParseException {
		//判断申请人是否存在
		Developer developer = developerDao.selectDevByIdExist(studio.getDevId());
		if (developer != null) {
			//判断申请人是否有创建的工作室在运行,如没有就让创建
			Studio studio1=new Studio();
			studio1.setDevId(studio.getDevId());
			studio1.setStuStart(1);
			List<Studio> studios = studioDao.selectStudio(studio1);
			if (studios.size() == 0) {
				//定义ID
				Studio studio2;
				String string;
				do {
					string=StringUtils.studioString();
					studio2 = studioDao.selectStudioById(studio.getStuId());
				} while (studio2!=null);

				studio.setStuId(string);
				int i = studioDao.insertStudio(studio);
				//如果成功就到studiomem表中添加负责人信息
				if (i==1) {
					Studiomem studiomem=new Studiomem();
					studiomem.setStuId(string);
					studiomem.setDevId(studio.getDevId());
					studiomem.setStumemPower(3);
					studiomem.setStumemIs(2);
					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					studiomem.setStumemTime(date.parse(date.format(new Date())));
					int a = studiomemDao.insertStudiomem(studiomem);
					if (a == 1) {
						return ResultUtil.success(null, "添加成功");
					}
					return ResultUtil.error("添加失败");
				}
				return ResultUtil.error("添加失败");
			}
			return ResultUtil.error("你已经创建有一个工作室,请注销再来创建!");
		}
		return ResultUtil.error("发布人账号状态有误!");
	}

	@Override
	public Result deleteStudio(String stuId) {
		/*Studio studio = studioDao.selectStudioById(stuId);
		if(studio==null){
			int i = studioDao.deleteStudio(stuId);
			if (i==1) {
				return ResultUtil.success(null, "删除成功");
			}
			return ResultUtil.error("删除失败");
		}
		return ResultUtil.error("此数据不存在");*/
		return null;
	}

	@Override
	public Result updateStudio(Studio studio) {
		//判断工作室是否存在
		Studio studio2 = studioDao.selectStudioById(studio.getStuId());
		if(studio2!=null && studio2.getStuStart() != 0){
			//if (studio2.getDevId().equals(studio.getDevId())) {
				int i = studioDao.updateStudio(studio);
				if (i==1) {
					return ResultUtil.success(null, "修改成功");
				}
				return ResultUtil.error("修改失败");
			//}
			//return ResultUtil.error("你不是此工作室负责人");
		}
		return ResultUtil.error("此工作室不存在");
	}

	@Override
	public Result selectStudio(Studio studio,Integer fenye,Integer pageSize) {
		//分页
		PageHelper.startPage(fenye,pageSize);
		List<Studio> list = studioDao.selectStudio(studio);
		PageInfo pageInfo = new PageInfo<>(list);
		int size = pageInfo.getSize();
		if (size!=0) {
			//封装数据
			List<StudioCut> liststuCut=new ArrayList<StudioCut>();
			StudioCut studioCut;
			Studio studio2;
			try {
				List list1 = pageInfo.getList();
				for (int i=0;i<size;i++) {
					//studio2=new Studio();
					studioCut=new StudioCut();
					studio2= (Studio) list1.get(i);
					BeanUtils.copyProperties(studioCut, studio2);
					//设置负责人名字
					Developer developer = developerDao.selectDeveloperById(studioCut.getDevId());
					studioCut.setDevIdName(developer.getDevName());
					liststuCut.add(studioCut);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return ResultUtil.success(liststuCut, "查询成功",pageInfo.getTotal());
		}
		return ResultUtil.success(null, "无数据");
	}

	@Override
	public Result RankingsStu(Studio studio,Integer fenye,Integer pageSize) {
		//分页
		PageHelper.startPage(fenye,pageSize);
		List<Studio> list = studioDao.selectStudio(studio);
		PageInfo pageInfo = new PageInfo<>(list);
		int size = pageInfo.getSize();
		if (size!=0) {
			//封装数据
			List<StudioRankings> studioRankings=new ArrayList<StudioRankings>();
			StudioRankings rankings;
			Studio studio2;
			try {
				List list1 = pageInfo.getList();
				for (int i=0;i<size;i++) {
					//studio2=new Studio();
					rankings=new StudioRankings();
					studio2= (Studio) list1.get(i);
					BeanUtils.copyProperties(rankings, studio2);
					//设置负责人名字
					/*Developer developer = developerDao.selectDeveloperById(rankings.getDevId());
					rankings.setDevIdName(developer.getDevName());*/
					studioRankings.add(rankings);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return ResultUtil.success(studioRankings, "查询成功",pageInfo.getTotal());
		}
		return ResultUtil.success(null, "无数据");



		/*List<Studio> list = studioDao.selectStudio(studio);
		Map<String,Integer> map=new HashMap<>();
		int size = list.size();
		//判断是否空
		if (size!=0) {
			//封装数据
			Studio studio2;
			for (int i=0;i<size;i++) {
				studio2= list.get(i);
				map.put(studio2.getStuId(),studio2.getStuPraise());
			}
			//调用方法排序
			Map<String, Integer> sortMapByValueDesc = MyUtil.getSortMapByValueDesc(map);
			List<StudioRankings> list1=new ArrayList<>();
			StudioRankings studioRankings;
			try {
				for (String string : sortMapByValueDesc.keySet()) {
					Studio studio1 = studioDao.selectStudioById(string);
					studioRankings=new StudioRankings();
					BeanUtils.copyProperties(studioRankings, studio1);
					list1.add(studioRankings);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return ResultUtil.success(list1, "查询成功",size);
		}
		return ResultUtil.success(null, "无数据");*/
	}

	@Override
	public Studio selectStudioByIdExist(String stuId) {
		return studioDao.selectStuByIdExist(stuId);
	}
	@Override
	public Studio selectStudioById(String stuId) {
		return studioDao.selectStudioById(stuId);
	}
}

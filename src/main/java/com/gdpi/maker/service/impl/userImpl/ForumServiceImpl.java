package com.gdpi.maker.service.impl.userImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.maker.dao.DeveloperDao;
import com.gdpi.maker.dao.StudioDao;
import com.gdpi.maker.pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdpi.maker.dao.ForumDao;
import com.gdpi.maker.service.ForumService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.StringUtils;

@SuppressWarnings("Duplicates")
@Service("ForumServiceImpl")
public class ForumServiceImpl implements ForumService {
	@Autowired
	private ForumDao forumDao;
	@Autowired
	private DeveloperDao developerDao;
	@Autowired
	private StudioDao studioDao;
	
	@Override
	public Result addForum(ForumWithBLOBs forumWithBLOBs) {
		
		//转发作品
		if (forumWithBLOBs.getForumForid()!=null) {
			//查询存不存在
			ForumWithBLOBs forumWithBLOBs3 = forumDao.selectByPrimaryKey(forumWithBLOBs.getForumForid());
			if (forumWithBLOBs3!=null && forumWithBLOBs3.getForumStart()==1) {
				//如果是转发别人转发的,先查询别人转发的作品Id,再把原创的作品Id放到ForumForid()里
				if (forumWithBLOBs3.getForumForid()!=null) {
					forumWithBLOBs.setForumForid(forumWithBLOBs3.getForumForid());
				}

				//先查询你是否有转发过
				ForumWithBLOBs forumWithBLOBs4=new ForumWithBLOBs();
				forumWithBLOBs4.setForummemId(forumWithBLOBs.getForummemId());
				//发布状态
				forumWithBLOBs4.setForumStart(1);
				forumWithBLOBs4.setForumForid(forumWithBLOBs.getForumForid());
				List<ForumWithBLOBs> list = forumDao.selectForum(forumWithBLOBs4);

				if (list.size()!=0) {
					String forumForid2 = forumWithBLOBs.getForumForid();

					for (ForumWithBLOBs forumWithBLOBs2 : list) {
						String forumForid = forumWithBLOBs2.getForumForid();
						String forummemId = forumWithBLOBs2.getForumId();
						if (forumForid!=null) {
							if (forumForid2.equals(forumForid)) {
								return ResultUtil.error("你已转发");
							}
						}

						if (forumForid2.equals(forummemId)) {
							return ResultUtil.error("自己不能转发自己的作品");
						}
					}
				}
			}else
			return ResultUtil.error("你所转发的作品不存在");
		} else
		//原创文字作品,判定状态是否有误
		if (forumWithBLOBs.getForumStart()==null || forumWithBLOBs.getForumStart()==1 || forumWithBLOBs.getForumStart()==0) {
			//检查属性内容是否为空
			if (forumWithBLOBs.getForumText()==null || forumWithBLOBs.getForumText()=="" ||
					forumWithBLOBs.getForumName()==null || forumWithBLOBs.getForumName()=="" || 
					forumWithBLOBs.getForumInfo()==null || forumWithBLOBs.getForumInfo()==""
						) {
					return ResultUtil.error("文本字段内容不能为空");
				}
				//设置文字作品的标识
				forumWithBLOBs.setForumWhat(2);
		}else {
			return ResultUtil.error("作品状态有误");
		}

		//设置作品Id
		ForumWithBLOBs forumWithBLOBs2;
		String forumId;
		do {
			forumId=StringUtils.forumString();
			forumWithBLOBs2=forumDao.selectByPrimaryKey(forumId);
		} while (forumWithBLOBs2!=null);
		forumWithBLOBs.setForumId(forumId);
		
		int i = forumDao.addForum(forumWithBLOBs);
		if(i==1){
			return ResultUtil.success(null, "添加成功");
		}
		return ResultUtil.error("添加失败");
	}

	@Override
	public Result addForumVideo(ForumWithBLOBs forumWithBLOBs) {
			//判断作品的状态
			if (forumWithBLOBs.getForumStart()==null || forumWithBLOBs.getForumStart()==1 || forumWithBLOBs.getForumStart()==0) {
				//检查属性内容是否为空
				if (forumWithBLOBs.getForumName()==null || forumWithBLOBs.getForumName()=="" ||
						forumWithBLOBs.getForumInfo()==null || forumWithBLOBs.getForumInfo()==""
				) {
					return ResultUtil.error("文本字段内容不能为空");
				}

				forumWithBLOBs.setForumWhat(1);
				int i = forumDao.addForum(forumWithBLOBs);
				if(i==1){
					return ResultUtil.success(null, "添加成功");
				}
				return ResultUtil.error("添加失败");
			}
			return ResultUtil.error("作品状态有误");
	}

	@Override
	public Result deleteForum(String forumId) {
		/*ForumWithBLOBs forumWithBLOBs = forumDao.selectByPrimaryKey(forumId);
		if(forumWithBLOBs==null){
			return ResultUtil.error("此作品不存在");
		}
		int i = forumDao.deleteForum(forumId);
		if(i!=1){
			return ResultUtil.error("删除失败");
		}
		return ResultUtil.success(null, "删除成功");*/
		return null;
	}

	@Override
	public Result updateForum(ForumWithBLOBs forumWithBLOBs) {
		ForumWithBLOBs forumWithBLOBs2 = forumDao.selectByPrimaryKey(forumWithBLOBs.getForumId());
		if (forumWithBLOBs2!=null) {
			//判断是否是转发作品
			if (forumWithBLOBs2.getForumForid()==null) {
				if (forumWithBLOBs2.getForummemId().equals(forumWithBLOBs.getForummemId())) {
					//判断发布状态 null不更改状态,1已发布,2已删除
					if (forumWithBLOBs.getForumStart()==null|| forumWithBLOBs.getForumStart()==1 || forumWithBLOBs.getForumStart()==2) {
						if (forumWithBLOBs.getForumName()!=null) {
							//判断是视频
							if (forumWithBLOBs2.getForumWhat()==1) {
								forumWithBLOBs.setForumText(null);
							//判断是文字
							} else if (forumWithBLOBs2.getForumWhat()==2){
								//不知道写啥
							}else{
								return ResultUtil.error("作品类型有误");
							}
							
							int i = forumDao.updateForum(forumWithBLOBs);
							if(i!=1){
								return ResultUtil.error("修改失败");
							}
							return ResultUtil.success(null, "修改成功");
						}
						return ResultUtil.error("作品名称不能为空");
					}
					return ResultUtil.error("作品状态有误");
				}
				return ResultUtil.error("这不是你的作品");
			}
			return ResultUtil.error("此作品不支持修改");
		}
		return ResultUtil.error("作品不存在");
	}
	
	@Override
	public Result updateForumStart(ForumWithBLOBs forumWithBLOBs) {
		ForumWithBLOBs forumWithBLOBs2 = forumDao.selectByPrimaryKey(forumWithBLOBs.getForumId());
		if (forumWithBLOBs2!=null && forumWithBLOBs2.getForumStart()!=2) {
			//判断是否是转发作品
			//if (forumWithBLOBs2.getForumForid()==null) {

				if (forumWithBLOBs2.getForummemId().equals(forumWithBLOBs.getForummemId())) {
					//判断发布状态 null不更改状态,1已发布,2已删除
					if (forumWithBLOBs.getForumStart()==null || forumWithBLOBs.getForumStart()==1 || forumWithBLOBs.getForumStart()==2) {
						int i = forumDao.updateForum(forumWithBLOBs);
						if(i!=1){
							return ResultUtil.error("修改失败");
						}
						return ResultUtil.success(null, "修改成功");
					}
					return ResultUtil.error("作品状态有误");

				//}
				//return ResultUtil.error("这不是你的作品");

			}
			return ResultUtil.error("此作品不支持修改");
		}
		return ResultUtil.error("作品不存在");
	}

	@Override
	public Result updateForumListStart(String[] forumIdList, String devId) {
		ForumWithBLOBs forumWithBLOBs=new ForumWithBLOBs();
		forumWithBLOBs.setForummemId(devId);
		Result result2=new Result();
		int i=0;
		for (String forumId: forumIdList) {
			forumWithBLOBs.setForumId(forumId);
			forumWithBLOBs.setForumStart(2);
			Result result = updateForumStart(forumWithBLOBs);
			if (result.getCode() == 1) {
				i=i+1;
			}
		}
		result2.setCode(1);
		result2.setMsg("已成功删除"+i+"条,失败"+(forumIdList.length-i)+"条");
		return result2;
	}

	@Override
	public Result selectForum(ForumWithBLOBs  forumWithBLOBs,Integer fenye,Integer pageSize) {
		if (forumWithBLOBs.getForumStart()==null || forumWithBLOBs.getForumStart() >0 || forumWithBLOBs.getForumStart()<3) {
			PageHelper.startPage(fenye,pageSize);
			List<ForumWithBLOBs> list = forumDao.selectForum(forumWithBLOBs);
			PageInfo pageInfo = new PageInfo<>(list);
			int size = pageInfo.getSize();
			if (size != 0) {
				ForumWithBLOBsCut forumWithBLOBsCut;
				ForumWithBLOBs forumWithBLOBs1;
				List<ForumWithBLOBsCut> cutList=new ArrayList<>();
				List list1 = pageInfo.getList();
				try {
					for (int i = 0; i < size; i++) {
						forumWithBLOBs1 = (ForumWithBLOBs) list1.get(i);
						//不是删除状态的
						if (forumWithBLOBs1.getForumStart() != 2) {
							forumWithBLOBsCut=new ForumWithBLOBsCut();
							BeanUtils.copyProperties(forumWithBLOBsCut,forumWithBLOBs1);
							String forummemId = forumWithBLOBs1.getForummemId();
							String substring = forummemId.substring(0, 3);
							if (substring.equals("Dev")) {
								Developer developer = developerDao.selectDeveloperById(forummemId);
								forumWithBLOBsCut.setForummemIdName(developer.getDevName());
							}else if (substring.equals("Stu")){
								Studio studio = studioDao.selectStudioById(forummemId);
								forumWithBLOBsCut.setForummemIdName(studio.getStuName());
							}
							cutList.add(forumWithBLOBsCut);
						}
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				return ResultUtil.success(cutList, "查询成功",pageInfo.getTotal());
			}
			return ResultUtil.success(null,"无数据");
		}
		return ResultUtil.error("查询状态有误");
	}

	@Override
	public Result selectByPrimaryKey(String forumId) {
		ForumWithBLOBs forumWithBLOBs = forumDao.selectByPrimaryKey(forumId);
		if (forumWithBLOBs != null) {
			ForumWithBLOBsCut forumWithBLOBsCut=new ForumWithBLOBsCut();
			try {
				BeanUtils.copyProperties(forumWithBLOBsCut,forumWithBLOBs);
				String forummemId = forumWithBLOBs.getForummemId();
				String substring = forummemId.substring(0, 3);
				if (substring.equals("Dev")) {
					Developer developer = developerDao.selectDeveloperById(forummemId);
					forumWithBLOBsCut.setForummemIdName(developer.getDevName());
				}else if (substring.equals("Stu")){
					Studio studio = studioDao.selectStudioById(forummemId);
					forumWithBLOBsCut.setForummemIdName(studio.getStuName());
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			//加1热度
			ForumWithBLOBs forumWithBLOBs1=new ForumWithBLOBs();
			forumWithBLOBs1.setForumId(forumId);
			forumWithBLOBs1.setForumHeat(forumWithBLOBs.getForumHeat()+1);
			forumDao.updateForum(forumWithBLOBs1);

			return ResultUtil.success(forumWithBLOBsCut, "查询成功");
		}
		return ResultUtil.success(null,"无数据");
	}

	@Override
	public ForumWithBLOBs selectForumById(String forumId) {
		return forumDao.selectByPrimaryKey(forumId);
	}

	@Override
	public Result ranKingsForum(ForumWithBLOBs forumWithBLOBs,Integer fenye,Integer pageSize) {
		PageHelper.startPage(fenye,pageSize);
		List<ForumWithBLOBs> list = forumDao.selectForum(forumWithBLOBs);
		PageInfo pageInfo = new PageInfo<>(list);
		int size = pageInfo.getSize();
		if (size != 0) {
			ForumWithBLOBsRankings forumWithBLOBsRankings;
			List<ForumWithBLOBsRankings> rankingsList = new ArrayList<>();
			List list1 = pageInfo.getList();
			ForumWithBLOBs forumWithBLOBs1;
			try {
				for (int i = 0; i < size; i++) {
					forumWithBLOBs1 = (ForumWithBLOBs) list1.get(i);
					forumWithBLOBsRankings=new ForumWithBLOBsRankings();
					BeanUtils.copyProperties(forumWithBLOBsRankings,forumWithBLOBs1);
					String forummemId = forumWithBLOBs1.getForummemId();
					String substring = forummemId.substring(0, 3);
					if (substring.equals("Dev")) {
						Developer developer = developerDao.selectDeveloperById(forummemId);
						forumWithBLOBsRankings.setForummemIdName(developer.getDevName());
					}else if (substring.equals("Stu")){
						Studio studio = studioDao.selectStudioById(forummemId);
						forumWithBLOBsRankings.setForummemIdName(studio.getStuName());
					}
					rankingsList.add(forumWithBLOBsRankings);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return ResultUtil.success(rankingsList, "查询成功",size);
		}
		return ResultUtil.success(null,"无数据");
	}







	/*@Override
	public Result countByExample(Forum forum) {
		int i = forumDao.countByExample(forum);
		if(i==0){
			return ResultUtil.error("删除失败");
		}
		return null;
	}*/

	
	/*@Override
	public Result selectOneForum(Forum forum) {
		ForumWithBLOBs forumWithBLOBs = forumDao.selectOneForum(forum);
		return ResultUtil.success(forumWithBLOBs, "查询成功");
	}*/
}

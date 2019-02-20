/*
package com.gdpi.maker.service.impl.adminImpl;

import com.gdpi.maker.dao.ForumDao;
import com.gdpi.maker.pojo.ForumWithBLOBs;
import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.service.ForumService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AdminForumServiceImpl")
public class AdminForumServiceImpl implements ForumService {
	@Autowired
	private ForumDao forumDao;
	
	@Override
	public Result addForum(ForumWithBLOBs forumWithBLOBs) {
		
		//转发
		if (forumWithBLOBs.getForumForid()!=null) {
			ForumWithBLOBs forumWithBLOBs3 = forumDao.selectByPrimaryKey(forumWithBLOBs.getForumForid());
			if (forumWithBLOBs3==null || forumWithBLOBs3.getForumStart()==0 || forumWithBLOBs3.getForumStart()==2) {
				return ResultUtil.error("你所转发的作品不存在");
			}
			//如果是转发别人转发的,先查询别人转发的作品Id,再把原创的作品Id放到ForumForid()里
			if (forumWithBLOBs3.getForumForid()!=null) {
				forumWithBLOBs.setForumForid(forumWithBLOBs3.getForumForid());
			}
			
			ForumWithBLOBs forumWithBLOBs4=new ForumWithBLOBs();
			forumWithBLOBs4.setForummemId(forumWithBLOBs.getForummemId());
			//发布状态
			forumWithBLOBs4.setForumStart(1);
			List<ForumWithBLOBs> list = forumDao.selectForum(forumWithBLOBs4);
			if (list.size()==0) {
				return ResultUtil.error("转发失败,此作品不存在");
			}
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
		} else
		//原创文字作品
		if (forumWithBLOBs.getForumStart()==null || forumWithBLOBs.getForumStart()==1 || forumWithBLOBs.getForumStart()==0) {
			
			if (forumWithBLOBs.getForumText()==null || forumWithBLOBs.getForumText()=="" ||
					forumWithBLOBs.getForumName()==null || forumWithBLOBs.getForumName()=="" || 
					forumWithBLOBs.getForumInfo()==null || forumWithBLOBs.getForumInfo()==""
						) {
					return ResultUtil.error("字段内容不能为空");
				}

				forumWithBLOBs.setForumWhat(2);
		}else {
			return ResultUtil.error("作品状态有误");
		}
		
		ForumWithBLOBs forumWithBLOBs2=new ForumWithBLOBs();
		String forumId=null;
		do {
			forumId=StringUtils.forumString();
			forumWithBLOBs2=forumDao.selectByPrimaryKey(forumId);
		} while (forumWithBLOBs2!=null);
		
		forumWithBLOBs.setForumId(forumId);
		
		int i = forumDao.addForum(forumWithBLOBs);
		if(i!=1){
			return ResultUtil.error("添加失败");
		}
		return ResultUtil.success(null, "添加成功");
		
	}
	
	
	@Override
	public Result addForumVideo(ForumWithBLOBs forumWithBLOBs) {
		//if (video!=null) {
			if (forumWithBLOBs.getForumStart()==null || forumWithBLOBs.getForumStart()==1 || forumWithBLOBs.getForumStart()==0) {
				
				//ForumWithBLOBs forumWithBLOBs2=new ForumWithBLOBs();
				*/
/*String forumId;
				do {
					forumId=StringUtils.forumString();
					forumWithBLOBs2=forumDao.selectByPrimaryKey(forumId);
				} while (forumWithBLOBs2!=null);*//*

				
				*/
/*String string = uploadFileUtils.videoBuilder(video, forumId);
				
				if (string!=null) {
					forumWithBLOBs.setForumId(forumId);
				} else {
					return ResultUtil.error("上传失败");
				}*//*

				forumWithBLOBs.setForumWhat(1);
				int i = forumDao.addForum(forumWithBLOBs);
				if(i!=1){
					return ResultUtil.error("添加失败");
				}
				return ResultUtil.success(null, "添加成功");
			}
			return ResultUtil.error("作品状态有误");
		//}
		//return ResultUtil.error("上传失败");
	}

	@Override
	public Result deleteForum(String forumId) {
		ForumWithBLOBs forumWithBLOBs = forumDao.selectByPrimaryKey(forumId);
		if(forumWithBLOBs==null){
			return ResultUtil.error("此作品不存在");
		}
		int i = forumDao.deleteForum(forumId);
		if(i!=1){
			return ResultUtil.error("删除失败");
		}
		return ResultUtil.success(null, "删除成功");
	}

	@Override
	public Result updateForum(ForumWithBLOBs forumWithBLOBs) {
		ForumWithBLOBs forumWithBLOBs2 = forumDao.selectByPrimaryKey(forumWithBLOBs.getForumId());
		if (forumWithBLOBs2!=null) {
			//判断是否是转发作品
			if (forumWithBLOBs2.getForumForid()!=null) {
				if (forumWithBLOBs2.getForummemId().equals(forumWithBLOBs.getForummemId())) {
					//判断发布状态 null不更改状态,1已发布,2已删除
					//if (forumWithBLOBs.getForumStart()==1 || forumWithBLOBs.getForumStart()==2 || forumWithBLOBs.getForumStart()==null) {
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
					//}
					//return ResultUtil.error("作品状态有误");
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
		if (forumWithBLOBs2==null) {
			return ResultUtil.error("作品不存在");
		}
		//判断是否是转发作品
		if (forumWithBLOBs2.getForumForid()==null) {
			
			if (!forumWithBLOBs2.getForummemId().equals(forumWithBLOBs.getForummemId())) {
				return ResultUtil.error("这不是你的作品");
			}
			
			//判断发布状态 null不更改状态,1已发布,2已删除
			if (forumWithBLOBs.getForumStart()!=1 || forumWithBLOBs.getForumStart()!=2 || forumWithBLOBs.getForumStart()!=null) {
				return ResultUtil.error("作品状态有误");
			}
	
			int i = forumDao.updateForum(forumWithBLOBs);
			if(i!=1){
				return ResultUtil.error("修改失败");
			}
			return ResultUtil.success(null, "修改成功");
		}
		return ResultUtil.error("此作品不支持修改");
	}

	@Override
	public Result updateForumListStart(String[] forumIdList, String devId) {
		ForumWithBLOBs forumWithBLOBs=new ForumWithBLOBs();
		Result result=null;
		for (String forumId: forumIdList) {
			forumWithBLOBs.setForumId(forumId);
			forumWithBLOBs.setForumStart(2);
			result = updateForumStart(forumWithBLOBs);
		}
		return result;
	}
	
	@Override
	public ForumWithBLOBs selectForumById(String forumId) {
		return forumDao.selectByPrimaryKey(forumId);
	}

	@Override
	public Result selectForum(ForumWithBLOBs  forumWithBLOBs,Integer fenye,Integer pageSize) {
		if (forumWithBLOBs.getForumStart()==null) {
			forumWithBLOBs.setForumStart(1);
		}
		PageHelper.startPage(fenye,pageSize);
		List<ForumWithBLOBs> list = forumDao.selectForum(forumWithBLOBs);
		PageInfo pageInfo = new PageInfo<>(list,0);
		int size = pageInfo.getSize();
		if (size != 0) {
			List list1 = pageInfo.getList();
			return ResultUtil.success(list1, "查询成功",pageInfo.getTotal());
		}
		return ResultUtil.success(null,"无数据");
	}

	@Override
	public Result selectByPrimaryKey(String forumId) {
		ForumWithBLOBs forumWithBLOBs = forumDao.selectByPrimaryKey(forumId);
		return ResultUtil.success(forumWithBLOBs, "查询成功");
	}

	*/
/*@Override
	public Result countByExample(Forum forum) {
		int i = forumDao.countByExample(forum);
		if(i==0){
			return ResultUtil.error("删除失败");
		}
		return null;
	}*//*


	
	*/
/*@Override
	public Result selectOneForum(Forum forum) {
		ForumWithBLOBs forumWithBLOBs = forumDao.selectOneForum(forum);
		return ResultUtil.success(forumWithBLOBs, "查询成功");
	}*//*

}
*/

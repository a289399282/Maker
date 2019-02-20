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
import org.springframework.stereotype.Repository;

import com.gdpi.maker.dao.ProjectDao;
import com.gdpi.maker.service.ProjectService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.StringUtils;
import org.springframework.stereotype.Service;

@SuppressWarnings("Duplicates")
@Service("ProjectServiceImpl")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private DeveloperDao developerDao;
	@Autowired
	private StudioDao studioDao;

	@Override
	public Result insertProject(Project project) {
		//定义Id
		String string;
		Project project2;
		do {
			string = StringUtils.projectString();
			project2 = projectDao.selectByPrimaryKey(string);
		} while (project2!=null);
		
		project.setProId(string);
		int i = projectDao.insertProject(project);
		if (i==1) {
			return ResultUtil.success(null, "添加成功");
		}
		return ResultUtil.error("添加失败");
	}

	@Override
	public Result deleteProject(String proId) {
		Project project = projectDao.selectByPrimaryKey(proId);
		if(project==null){
			return ResultUtil.error("此项目不存在");
		}
		int i = projectDao.deleteProject(proId);
		if (i!=1) {
			return ResultUtil.error("删除失败");
		}
		return ResultUtil.success(null, "删除成功");
	}

	@Override
	public Result updateProject(Project project) {
		Project project2 = projectDao.selectByPrimaryKey(project.getProId());
		if(project2!=null){
            if (project2.getProState()!=6) {
                if (project2.getProPublisher().equals(project.getProPublisher())) {
                    int i = projectDao.updateProject(project);
                    if (i==1) {
                        return ResultUtil.success(null, "修改成功");
                    }
                    return ResultUtil.error("修改失败");
                }
                return ResultUtil.error("你不是此项目发布人,没权限修改");
            }
            return ResultUtil.error("项目不存在");
		}
        return ResultUtil.error("此项目不存在");

	}

    @Override
    public Result updateProjectListStart(String[] proIdList, String proPublisher) {
	    Project project=new Project();
        Result result2=new Result();
        int i=0;
        for (String proId: proIdList) {
            project.setProId(proId);
            project.setProPublisher(proPublisher);
            Result result = updateProject(project);
            if (result.getCode() == 1) {
                i=i+1;
            }
        }
        result2.setCode(1);
        result2.setMsg("已成功删除"+i+"条,失败"+(proIdList.length-i)+"条");
        return result2;
    }

    @Override
	public Result selectProjectMe(Project project, Double money1, Double money2,Integer fenye,Integer pageSize) {
		PageHelper.startPage(fenye,pageSize);
		List<Project> list = projectDao.selectProjectMe(project, money1, money2);
		PageInfo pageInfo = new PageInfo<>(list);
		int size = pageInfo.getSize();
		if (size != 0) {
			List<ProjectCut> listCut=new ArrayList<ProjectCut>();
			ProjectCut projectCut;
			Project project2;
			try {
				List list1 = pageInfo.getList();
				for (int i=0;i<size;i++) {
					projectCut=new ProjectCut();
					//project2=new Project();
					project2 = (Project) list1.get(i);
					BeanUtils.copyProperties(projectCut, project2);
					//设置发布人的名称
					String proPublisher = projectCut.getProPublisher();
					String substring = proPublisher.substring(0, 3);
					if ("Dev".equals(substring)){
						Developer developer = developerDao.selectDeveloperById(proPublisher);
						projectCut.setProPubname(developer.getDevName());
					}else if ("Stu".equals(substring)) {
						Studio studio = studioDao.selectStudioById(proPublisher);
						projectCut.setProPubname(studio.getStuName());
					}

					listCut.add(projectCut);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			return ResultUtil.success(listCut, "查询成功",pageInfo.getTotal());
		}
		return ResultUtil.success(null,"无数据");
	}

	@Override
	public Result selectProjectAll(Project project, Double money1, Double money2, Integer fenye, Integer pageSize) {
		PageHelper.startPage(fenye,pageSize);
		List<Project> list = projectDao.selectProjectAll(project, money1, money2);
		PageInfo pageInfo = new PageInfo<>(list,0);
		int size = pageInfo.getSize();
		if (size != 0) {
			List<ProjectCut> listCut=new ArrayList<ProjectCut>();
			ProjectCut projectCut;
			Project project2;
			try {
				List list1 = pageInfo.getList();
				for (int i=0;i<size;i++) {
					projectCut=new ProjectCut();
					//project2=new Project();
					project2 = (Project) list1.get(i);
					BeanUtils.copyProperties(projectCut, project2);
					//设置发布人的名称
					String proPublisher = projectCut.getProPublisher();
					String substring = proPublisher.substring(0, 3);
					if ("Dev".equals(substring)){
						Developer developer = developerDao.selectDeveloperById(proPublisher);
						projectCut.setProPubname(developer.getDevName());
					}else if ("Stu".equals(substring)) {
						Studio studio = studioDao.selectStudioById(proPublisher);
						projectCut.setProPubname(studio.getStuName());
					}
					listCut.add(projectCut);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			return ResultUtil.success(listCut, "查询成功",pageInfo.getTotal());
		}
		return ResultUtil.success(null,"无数据");
	}
	@Override
	public Project selectProjectById(String proId) {
		return projectDao.selectByPrimaryKey(proId);
	}
	@Override
	public int updateProjectHeat(String proId,Integer heat) {
		Project project=new Project();
		project.setProHeat(heat);
		project.setProId(proId);
		return projectDao.updateProject(project);
	}

}

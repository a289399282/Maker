package com.gdpi.maker.service.impl.userImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.gdpi.maker.pojo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdpi.maker.dao.DeveloperDao;
import com.gdpi.maker.dao.PositionDao;
import com.gdpi.maker.dao.StudioDao;
import com.gdpi.maker.service.PositionService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.StringUtils;

@SuppressWarnings("Duplicates")
@Service("PositionServiceImpl")
public class PositionServiceImpl implements PositionService {
	@Autowired
	private PositionDao positionDao;
	@Autowired
	private DeveloperDao developerDao;
	@Autowired
	private StudioDao studioDao;
	
	@Override
	public Result insertPosition(Position position) {
		String positionmemId = position.getPositionmemId();
		
		if (positionmemId!=null) {
			//截取字符串
			String substring = positionmemId.substring(0, 3);
			Studio studio=null;
			Developer developer =null;

			//检验是个人发布还是工作室发布
			if (substring.equals("Dev")) {
				developer = developerDao.selectDevByIdExist(positionmemId);
			}else if (substring.equals("Stu")) {
				studio = studioDao.selectStuByIdExist(positionmemId);
			}else {
				return ResultUtil.error("发布人有误");
			}

			if (studio!=null || developer!=null) {
				//判定状态
				if (position.getPositionState()==null || position.getPositionState()==2 || position.getPositionState()==1) {
					//定义ID
					String string;
					Position position2;
					do {
						string = StringUtils.positionString();
						position2 = positionDao.selectPosByIdExist(position.getPositionId());
					} while (position2 != null);

					position.setPositionId(string);
					int i = positionDao.insertPosition(position);
					if (i == 1) {
						return ResultUtil.success(null, "添加成功");
					}
					return ResultUtil.error("添加失败");
				}
				return ResultUtil.error("状态码有误");
			}
			return ResultUtil.error("发布人有误");
		}
		return ResultUtil.error("发布人Id为空");
	}

	@Override
	public Result deletePosition(String positionId) {
		/*Position position = positionDao.selectPositionById(positionId);
		if (position==null) {
			return ResultUtil.error("此数据不存在");
		}
		int i = positionDao.deletePosition(positionId);
		if (i!=1) {
			return ResultUtil.error("删除失败");
		}
		return ResultUtil.success(null, "删除成功");*/
		return null;
	}

	@Override
	public Result updatePosition(Position position) {
		//检查职位是否存在
		Position position2 = positionDao.selectPosByIdExist(position.getPositionId());
		if (position2!=null) {
			//是否结束
			if (position2.getPositionState()!=3) {
					//判断状态是否相同
					if (!position.getPositionState().equals(position2.getPositionState())) {
						//判断发布人
						String positionmemId = position.getPositionmemId();
						if (position2.getPositionmemId().equals(positionmemId)) {

							String substring = positionmemId.substring(0, 3);
							Developer developer = null;
							Studio studio = null;

							//检验个人,工作室是否存在
							if (substring.equals("Dev")) {
								developer = developerDao.selectDevByIdExist(positionmemId);
							} else if (substring.equals("Stu")) {
								studio = studioDao.selectStuByIdExist(positionmemId);
							} else {
								return ResultUtil.error("发布人有误");
							}
							if (developer != null || studio != null) {
								//判断接收的状态码
								if (position.getPositionState() == 2 || position.getPositionState() == 3 || position.getPositionState() == 1) {
									int i = positionDao.updatePosition(position);
									if (i == 1) {
										return ResultUtil.success(null, "修改成功");
									}
									return ResultUtil.error("修改失败");
								}
								return ResultUtil.error("发布状态码有误");
							}
							return ResultUtil.error("发布人有误");
						}
						return ResultUtil.error("发布人有误");
					}
				return ResultUtil.error("此职位已是你所修改的状态,请不要重复修改");
			}
			return ResultUtil.error("此职位招聘已结束");
		}
		return ResultUtil.error("此数据不存在");
	}

	@Override
	public Result selectPosition(Position position, Integer fenye,Integer pageSize) {
		//分页
		PageHelper.startPage(fenye,pageSize);
		List<Position> list = positionDao.selectPosition(position);
		PageInfo pageInfo = new PageInfo<>(list);
        int size = pageInfo.getSize();

        if (size!=0) {
        	//封装数据
            List<PositionCut> posCutlist =new ArrayList<PositionCut>();
            PositionCut positionCut;
            Position position3;
            try {
                List list1 = pageInfo.getList();
                for (int i = 0; i <size ; i++) {
                    positionCut=new PositionCut();
                    //position3 = new Position();
                    position3 = (Position) list1.get(i);
                    BeanUtils.copyProperties(positionCut, position3);
                    //获取发布人Id
					String positionmemId = positionCut.getPositionmemId();
					String substring = positionmemId.substring(0, 3);
					//判断是用户还是工作室,然后设置名字
					if (substring.equals("Dev")) {
						Developer developer = developerDao.selectDeveloperById(positionmemId);
						positionCut.setPositionmemIdName(developer.getDevName());
					}else if (substring.equals("Stu")){
						Studio studio = studioDao.selectStudioById(positionmemId);
						positionCut.setPositionmemIdName(studio.getStuName());
					}
                    posCutlist.add(positionCut);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return ResultUtil.success(posCutlist, "查询成功",pageInfo.getTotal());
        }
        return ResultUtil.success(null, "无数据");

	}

	@Override
	public Result selectOnePosition(Position position2) {
		Position position = positionDao.selectOnePosition(position2);
		if (position!=null) {
			//封装数据
			PositionCut positionCut=new PositionCut();
			try {
				BeanUtils.copyProperties(positionCut,position);
				//判断是用户还是工作室,然后设置名字
				String positionmemId = position.getPositionmemId();
				String substring = positionmemId.substring(0, 3);
				if (substring.equals("Dev")) {
					Developer developer = developerDao.selectDeveloperById(positionmemId);
					positionCut.setPositionmemIdName(developer.getDevName());
				}else if (substring.equals("Stu")){
					Studio studio = studioDao.selectStudioById(positionmemId);
					positionCut.setPositionmemIdName(studio.getStuName());
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return ResultUtil.success(positionCut, "查询成功");
		}
		return ResultUtil.success(null, "无数据");
	}

	@Override
	public Result selectPositionById(String positionId) {
		Position position = positionDao.selectPositionById(positionId);
		if (position!=null) {
			//封装数据
			PositionCut positionCut=new PositionCut();
			try {
				BeanUtils.copyProperties(positionCut,position);
				//判断是用户还是工作室,然后设置名字
				String positionmemId = position.getPositionmemId();
				String substring = positionmemId.substring(0, 3);
				if (substring.equals("Dev")) {
					Developer developer = developerDao.selectDeveloperById(positionmemId);
					positionCut.setPositionmemIdName(developer.getDevName());
				}else if (substring.equals("Stu")){
					Studio studio = studioDao.selectStudioById(positionmemId);
					positionCut.setPositionmemIdName(studio.getStuName());
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			//加1热度
			Position position1=new Position();
			position1.setPositionId(positionId);
			position1.setPositionHeat(position.getPositionHeat()+1);
			positionDao.updatePosition(position1);

			return ResultUtil.success(positionCut, "查询成功");
		}
		return ResultUtil.success(null, "无数据");
	}

	@Override
	public Position selectPositionById2(String positionId) {
		return positionDao.selectPositionById(positionId);
	}

	@Override
	public Result rankingsPos(Position position, Integer fenye, Integer pageSize) {
		//分页
		PageHelper.startPage(fenye,pageSize);
		List<Position> list = positionDao.selectPosition(position);
		PageInfo pageInfo = new PageInfo<>(list);
		int size = pageInfo.getSize();

		if (size!=0) {
			//封装数据
			List<PositionRankings> posCutlist =new ArrayList<PositionRankings>();
			PositionRankings positionRankings;
			Position position3;
			try {
				List list1 = pageInfo.getList();
				for (int i = 0; i <size ; i++) {
					positionRankings=new PositionRankings();
					//position3 = new Position();
					position3 = (Position) list1.get(i);
					BeanUtils.copyProperties(positionRankings, position3);
					//获取发布人Id
					// String positionmemId = positionRankings.getPositionmemId();
					//String substring = positionmemId.substring(0, 3);
					//判断是用户还是工作室,然后设置名字
					/*if (substring.equals("Dev")) {
						Developer developer = developerDao.selectDeveloperById(positionmemId);
						positionRankings.setPositionmemIdName(developer.getDevName());
					}else if (substring.equals("Stu")){
						Studio studio = studioDao.selectStudioById(positionmemId);
						positionRankings.setPositionmemIdName(studio.getStuName());
					}*/
					posCutlist.add(positionRankings);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return ResultUtil.success(posCutlist, "查询成功",pageInfo.getTotal());
		}
		return ResultUtil.success(null, "无数据");
	}

	/*@Override
	public Position selectPositionById2(String positionId) {
		return null;
	}*/

}

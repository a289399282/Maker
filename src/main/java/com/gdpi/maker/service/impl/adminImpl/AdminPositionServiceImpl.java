/*
package com.gdpi.maker.service.impl.adminImpl;

import com.gdpi.maker.dao.DeveloperDao;
import com.gdpi.maker.dao.PositionDao;
import com.gdpi.maker.dao.StudioDao;
import com.gdpi.maker.pojo.*;
import com.gdpi.maker.service.PositionService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service("AdminPositionServiceImpl")
public class AdminPositionServiceImpl implements PositionService {
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

			if (studio!=null | developer!=null) {
				if (position.getPositionState()==null || position.getPositionState()==2 || position.getPositionState()==1) {
					String string;
					Position position2;
					do {
						string = StringUtils.positionString();
						position2 = positionDao.selectPosByIdExist(position.getPositionId());
					} while (position2 != null);
					position.setPositionId(string);
					int i = positionDao.insertPosition(position);
					if (i != 1) {
						return ResultUtil.error("添加失败");
					}
					return ResultUtil.success(null, "添加成功");
				}
				return ResultUtil.error("状态码有误");
			}
			return ResultUtil.error("发布人有误");
		}
		return ResultUtil.error("发布人Id为空");
	}

	@Override
	public Result deletePosition(String positionId) {
		Position position = positionDao.selectPositionById(positionId);
		if (position==null) {
			return ResultUtil.error("此数据不存在");
		}
		int i = positionDao.deletePosition(positionId);
		if (i!=1) {
			return ResultUtil.error("删除失败");
		}
		return ResultUtil.success(null, "删除成功");
	}

	@Override
	public Result updatePosition(Position position) {
		Position position2 = positionDao.selectPosByIdExist(position.getPositionId());
		if (position2!=null) {
			if (position2.getPositionState()!=3) {
					if (!position.getPositionState().equals(position2.getPositionState())) {
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
							if (developer != null | studio != null) {
								if (position.getPositionState() == 2 | position.getPositionState() == 3) {
									int i = positionDao.updatePosition(position);
									if (i != 1) {
										return ResultUtil.error("修改失败");
									}
									return ResultUtil.success(null, "修改成功");
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
		PageHelper.startPage(fenye,pageSize);
		List<Position> list = positionDao.selectPosition(position);
		PageInfo pageInfo = new PageInfo<>(list,0);
        int size = pageInfo.getSize();
        if (size!=0) {
            List<PositionCut> posCutlist =new ArrayList<PositionCut>();
            PositionCut positionCut;
            Position position3;
            try {
                List list1 = pageInfo.getList();
                for (int i = 0; i <size ; i++) {
                    positionCut=new PositionCut();
                    position3 = new Position();
                    position3 = (Position) list1.get(i);
                    BeanUtils.copyProperties(positionCut, position3);
                    posCutlist.add(positionCut);
                }
			*/
/*for (Position position2 : list) {
				positionCut=new PositionCut();
				BeanUtils.copyProperties(positionCut, position2);
				posCutlist.add(positionCut);
			}*//*

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            */
/*Map<String, List<PositionCut>> map=new HashMap<String, List<PositionCut>>();
            map.put("posCutlist", posCutlist);*//*

            return ResultUtil.success(posCutlist, "查询成功",pageInfo.getTotal());
        }
        return ResultUtil.success(null, "无数据");

	}

	@Override
	public Result selectOnePosition(Position position) {

		Position position2 = positionDao.selectOnePosition(position);
		if (position2!=null) {
			return ResultUtil.success(position2, "查询成功");
		}
		return ResultUtil.success(null, "无数据");
	}

	@Override
	public Result selectPositionById(String positionId) {
		Position position = positionDao.selectPositionById(positionId);
		if (position!=null) {
			return ResultUtil.success(position, "查询成功");
		}
		return ResultUtil.success(null, "无数据");
	}

	@Override
	public Position selectPositionById2(String positionId) {
		return null;
	}

	*/
/*@Override
	public Position selectPositionById2(String positionId) {
		return null;
	}*//*


}
*/

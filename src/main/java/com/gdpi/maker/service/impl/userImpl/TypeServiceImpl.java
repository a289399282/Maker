package com.gdpi.maker.service.impl.userImpl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdpi.maker.dao.TypeDao;
import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.pojo.Type;
import com.gdpi.maker.service.TypeService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.StringUtils;

@SuppressWarnings("Duplicates")
@Service("TypeServiceImpl")
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeDao typeDao;
	
	@Override
	public Result insertType(Type type) {
		String stingId;
		Type type2=null;
		do {
			//内部随机生成字符串
			stingId=StringUtils.typeString();
			type2 = typeDao.selectTypeById(stingId);
			//当type2为null时,说明数据库里没有这个Id存在,可以作为新Id注册
		} while (type2!=null);
		type.setTpId(stingId);
		int i = typeDao.insertType(type);
		if(i == 1){
			return ResultUtil.success(null, "添加成功");
		}
		return ResultUtil.error(-1, "添加失败!");
	}

	@Override
	public Result deleteType(String typeId) {
		if (typeId!=null) {
			Type type = typeDao.selectTypeById(typeId);
			if (type!=null) {
				int i = typeDao.deleteType(typeId);
				if(i != 1){
					return ResultUtil.error("删除失败!");
				}
				return ResultUtil.success(null, "删除成功");
			}
			return ResultUtil.error(-1, "此类型不存在!");
		}
		return ResultUtil.error("typeId错误!");
	}

	@Override
	public Result updateType(Type type) {
		if (type.getTpId()!=null) {
			Type type2 = typeDao.selectTypeById(type.getTpId());
			if (type2!=null) {
				int i = typeDao.updateType(type);
				if(i == 1){
					return ResultUtil.success(null, "修改成功");
				}
				return ResultUtil.error("修改失败!");
			}
			return ResultUtil.error("此类型不存在!");
		}
		return ResultUtil.error("没有类型Id!");
	}

	@Override
	public Result selectType(Type type,int fenye) {

       // PageHelper.startPage(fenye,10);
		List<Type> list = typeDao.selectType(type);
        //PageInfo pageInfo = new PageInfo<>(list);
        /*int size = pageInfo.getSize();
        int pages = pageInfo.getPages();
        long total = pageInfo.getTotal();
		int pageNum = pageInfo.getPageNum();
		int nextPage = pageInfo.getNextPage();
		int startRow = pageInfo.getStartRow();
		int pageSize = pageInfo.getPageSize();
		int[] navigatepageNums = pageInfo.getNavigatepageNums();
		int navigateFirstPage = pageInfo.getNavigateFirstPage();
		int navigateLastPage = pageInfo.getNavigateLastPage();
		int endRow = pageInfo.getEndRow();
		List list1 = pageInfo.getList();*/


        if (list.size()!=0) {
			/*Map<String, List<Type>> map=new HashMap<String, List<Type>>();
			map.put("typeList", list);*/
			return ResultUtil.success(list, "查询成功",list.size());
		}
		return ResultUtil.error("查无此数据!");
	}

	@Override
	public Type selectTypeById(String typeId) {
		return typeDao.selectTypeById(typeId);
	}

	@Override
	public Result countByExample(Type type) {
        int i = typeDao.countByExample(type);
        return ResultUtil.success(i,"查询成功");
    }

	
}

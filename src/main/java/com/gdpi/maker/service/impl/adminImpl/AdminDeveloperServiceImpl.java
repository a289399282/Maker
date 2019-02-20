/*
package com.gdpi.maker.service.impl.adminImpl;

import com.gdpi.maker.dao.DeveloperDao;
import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.pojo.DeveloperCut;
import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.service.DeveloperService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.MD5Utils;
import com.gdpi.maker.utilsmy.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("Duplicates")
@Service("AdminDeveloperServiceImpl")
public class AdminDeveloperServiceImpl implements DeveloperService {
	@Autowired
	private DeveloperDao developerDao;

	@Override
	public Result insertDeveloper(Developer developer){
		//先去数据库用手机号码查询是否存在一样数据
		Developer developer2=new Developer();
		developer2.setDevPhone(developer.getDevPhone());
		int i = developerDao.countDevelpor(developer2);
		//0,说明没有数据
		if(i == 0){
			//先定义用户Id
			String stingId;
			do {
				//内部随机生成字符串
				stingId=StringUtils.developerString();
				developer2 = developerDao.selectDeveloperById(stingId);
				//当developer2为null时,说明数据库里没有这个Id存在,可以作为新Id注册
			} while (developer2!=null);

			//把随机生成的字符串设置developer的id
			developer.setDevId(stingId);
			i = developerDao.insertDeveloper(developer);
			//等于一说明注册成功
			if(i == 1){
				return ResultUtil.success(null, "注册成功,请去登录页面登录");
			}
			return ResultUtil.error(-1, "注册失败,请重新注册!");
		}
		return ResultUtil.error(-1, "此号码已被注册!");
	}

	@Override
	public Result deleteDeveloper(String devId) {
		*/
/*if(devId!=null && devId.length()!=0){
			//先去数据库查询是否存在
			Developer developer = developerDao.selectDeveloperById(devId);
			if(developer==null){
				return ResultUtil.error(-1, "此用户不存在!");
			}
			//调用方法注销
			int i = developerDao.deleteDeveloper(devId);
			if(i!=1){
				return ResultUtil.error(-1, "删除失败,请重试!");
			}
		}
		return ResultUtil.success(null, "删除成功!");*//*

		return null;
	}

	@Override
	public Result cantDev(String devId,String devPassword) {
		if(devId!=null && devId.length()!=0){
			//先去数据库查询是否存在
			Developer developer2 = developerDao.selectDeveloperById(devId);
			if(developer2!=null){
				//验证账号状态
				if(developer2.getDevCancellation()!=1){
					//验证密码
					if (MD5Utils.md5(devPassword).equals(developer2.getDevPasswordmd5())) {
						Developer developer=new Developer();
						developer.setDevId(devId);
						//设置注销状态"1"
						developer.setDevCancellation(1);
						//注销时间
						SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
						try {
							developer.setDevCancellationtime(date.parse(date.format(new Date())));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						int i = developerDao.updateDeveloper(developer);
						if(i==1){
							return ResultUtil.success(null, "注销成功");
						}
						return ResultUtil.error("注销失败");
					}
					return ResultUtil.error("密码不正确");
				}
				return ResultUtil.error("注销失败,此号已注销!");
			}
			return ResultUtil.error("此用户不存在!");
		}
		return ResultUtil.error("用户Id为空");
	}

	@Override
	public Result updateDeveloper(Developer developer) {
		if(developer.getDevId()!=null && developer.getDevId().length()!=0){
			//先去数据库查询用户是否存在
			Developer developer2 = developerDao.selectDeveloperById(developer.getDevId());
			if(developer2.getDevId()!=null){
				if(developer.getDevIdcard()!=null && developer.getDevIdcard().length()==18 && developer.getDevTruename()!=null && developer.getDevTruename().length()!=0){
					//标志已实名
					developer.setDevTrue(1);
				}
				//调用方法修改
				int i = developerDao.updateDeveloper(developer);
				if(i==1){
					return ResultUtil.success(null,"修改成功");
				}
				return ResultUtil.error(-1, "修改失败,请重试!");
			}
			return ResultUtil.error("此用户不存在!");
		}
		return ResultUtil.error("用户Id没有");
	}

	@Override
	public Result updateDeveloperId(Developer developer, String developerId) {
		//判断用户是否存在
		Developer developer2 = developerDao.selectDeveloperById(developerId);
		if (developer2==null) {
			//检查用户是否改过Id
			if (developer2.getDevIdchange()!=1) {
				//用新Id查询数据库里是否有一样的
				developer2 = developerDao.selectDeveloperById(developer.getDevId());
				if (developer2==null) {
					//设置修改过Id的标记
					developer.setDevIdchange(1);
					int i = developerDao.updateByExampleSelective(developer, developerId);
					if(i==1){
						return ResultUtil.success(null, "修改成功!");
					}
					return ResultUtil.error(-1, "修改失败,请重试!");
				}
				return ResultUtil.error("此Id已存在");
			}
			return ResultUtil.error("你已经修改过一次,不可再修改");
		}
		return ResultUtil.error("此用户不存在");

	}

	@Override
	public Result loginDev(Developer developer){
		//判断是否注销
		Developer developer3=new Developer();
		if (developer.getDevId()!=null) {
			developer3.setDevId(developer.getDevId());
		}
		if (developer.getDevPhone()!=null) {
			developer3.setDevPhone(developer.getDevPhone());
		}
		Developer developer2 = developerDao.selectOneDeveloper(developer3);
		//判断账号是否注销
		if(developer2==null || developer2.getDevCancellation()==1){
			return ResultUtil.error(-1, "账号不存在");
		}
		//验证密码
		if (!developer2.getDevPasswordmd5().equals(developer.getDevPasswordmd5())) {
			return ResultUtil.error(-1, "账号或密码不正确");
		}
		DeveloperCut developerCut=new DeveloperCut();

		try {
			//把developer2和developerOne相同的属性复制到developerOne中
			BeanUtils.copyProperties(developerCut, developer2);
			return ResultUtil.success(developerCut, "登陆成功");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return ResultUtil.error(-1, "登录失败");
	}

	@Override
	public Result rankingsDev(Developer developer) {
		return null;
	}

	@Override
	public Result selectDeveloper(Developer developer, Integer fenye,Integer pageSize) {
		//分页,fenye:页码数,pageSize:每页显示多少条数据
		PageHelper.startPage(fenye,pageSize);
		List<Developer> list = developerDao.selectDeveloper(developer);
		PageInfo pageInfo = new PageInfo<>(list);
		//这个页面有多少条数据
		int size = pageInfo.getSize();
		//判断是否空
		if(size!=0){
			//定义要在页面显示的的删减版的用户类List
			List<DeveloperCut> listCut=new ArrayList<DeveloperCut>();
			Developer developer3;
			DeveloperCut developerCut;
			try {
				//从pageInfo拿出查询的信息
				List list1 = pageInfo.getList();
				//遍历
				for (int i=0;i<size;i++) {
					developerCut=new DeveloperCut();
					//developer3=new Developer();
					developer3= (Developer) list1.get(i);
					//复制信息到删减版的用户类(自动匹配相同的参数)
					BeanUtils.copyProperties(developerCut, developer3);
					listCut.add(developerCut);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return ResultUtil.success(listCut, "查询成功",pageInfo.getTotal());
		}
		return ResultUtil.success(null, "无数据");
	}

	@Override
	public Result selectDeveloperById(String devId) {
		Developer developer = developerDao.selectDeveloperById(devId);
		if (developer != null) {
			DeveloperCut developerCut=new DeveloperCut();
			try {
				//复制信息到删减版的用户类(自动匹配相同的参数)
				BeanUtils.copyProperties(developerCut, developer);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			return ResultUtil.success(developerCut, "查询成功");
		}
		return ResultUtil.success(null,"无数据");
	}

	@Override
	public Developer selectDevById(String devId) {
		return developerDao.selectDeveloperById(devId);
	}

	@Override
	public Developer selectOneDeveloper(Developer developer) {
		return developerDao.selectOneDeveloper(developer);
	}

}
*/

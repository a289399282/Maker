package com.gdpi.maker.controller.userController;

import com.gdpi.maker.pojo.*;
import com.gdpi.maker.service.DeveloperService;
import com.gdpi.maker.service.StudioService;
import com.gdpi.maker.service.StudiomemService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.MD5Utils;
import com.gdpi.maker.utilsmy.StringUtils;
import com.gdpi.maker.utilsmy.uploadFileUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;

@SuppressWarnings("Duplicates")
@Controller
@RequestMapping(value="/devstu")
public class DevStuController {
	//@Qualifier("DaoImpl")        //实现类1的类名。注意区分与@Resource(name="dogImpl") 的区别。
	//@Autowired @Autowired 的注入方式是 byType 注入， 当要注入的类型在容器中存在多个时，Spring是不知道要引入哪个实现类的，所以会报错。

	@Resource(name="DeveloperServiceImpl")        //实现类1中 @Service注解中标定的名称
	private DeveloperService developerService;
	@Resource(name = "StudioServiceImpl")
	private StudioService studioService;

	/**
	 * 登录后查询自己的信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectDevStuById")
	public Result selectDeveloperById(String zhanghao,HttpServletRequest request){
		if (zhanghao != null) {
			//获取Id
			String substring = zhanghao.substring(0, 3);
			//判断是用户还是工作室,然后设置名字
			if (substring.equals("Dev")) {
				return developerService.selectDeveloperById(zhanghao);
			}else if (substring.equals("Stu")){
				Studio studio = studioService.selectStudioById(zhanghao);
				StudioCut studioCut=new StudioCut();
				try {
					BeanUtils.copyProperties(studioCut,studio);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				if (studio != null) {
					return ResultUtil.success(studioCut,"查询成功");
				}
				return ResultUtil.error("查询失败");
			}
			return ResultUtil.error("id有误");
		}
		return ResultUtil.error("id为空");
	}

}

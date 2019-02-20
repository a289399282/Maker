package com.gdpi.maker.controller.userController;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdpi.maker.pojo.DeveloperCut;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.service.DeveloperService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.uploadFileUtils;
import com.gdpi.maker.utilsmy.MD5Utils;
import com.gdpi.maker.utilsmy.StringUtils;

@SuppressWarnings("Duplicates")
@Controller
@RequestMapping(value="/developer")
public class DeveloperController {
	//@Qualifier("DaoImpl")        //实现类1的类名。注意区分与@Resource(name="dogImpl") 的区别。
	//@Autowired @Autowired 的注入方式是 byType 注入， 当要注入的类型在容器中存在多个时，Spring是不知道要引入哪个实现类的，所以会报错。

	@Resource(name="DeveloperServiceImpl")        //实现类1中 @Service注解中标定的名称
	private DeveloperService developerService;
	
	/**
	 * 注册	
	 * @param devPhone 电话号码
	 * @param devPassword 密码
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value="/insertDev")
	public Result insertDev(String devPhone,String devPassword){
		//电话密码校验是否为空
		if (devPhone !=null && devPhone.length()==11 && devPassword !=null && devPassword.length()!=0) {
			Developer developer=new Developer();
			//加密密码
			developer.setDevPasswordmd5(MD5Utils.md5(devPassword));
			developer.setDevPassword(devPassword);
			developer.setDevPhone(devPhone);
			//调用方法添加开发人员的信息
			return developerService.insertDeveloper(developer);
		}
		return ResultUtil.error("电话号码或密码格式有误,请重新注册!");
	}
	
	/**
	 * 从数据库中删除
	 * @param devId 需要真正删除的开发人员id
	 * @return
	 */
	/*@ResponseBody
	@RequestMapping(value="/deleteDev")
	public Result deleteDev(String devId,HttpServletRequest request){
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if (developer!=null) {
		//调用方法删除开发人员的信息
			return developerService.deleteDeveloper(devId);
		}
		return null;
	}*/

	/**
	 * 注销账户
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/cantDev")
	public Result cantDev(String devPassword,HttpServletRequest request,HttpServletResponse response){
		if (devPassword !=null && devPassword.length()!=0) {
			Developer developer=(Developer) request.getSession().getAttribute("developer");
			if(developer!=null){
				//调用方法注销开发人员
				Result result = developerService.cantDev(developer.getDevId(),devPassword);
				if (result.getCode()==1) {
					if(request.getSession(false)!=null){
						//清除session信息
						request.getSession().invalidate();
						//删除自动登陆cookie
						Cookie autologinC = new Cookie("autologin","");
						autologinC.setPath("/");
						autologinC.setMaxAge(0);
						response.addCookie(autologinC);
					}
				}
				return result;
			}
			return ResultUtil.error("你没有登录,请登录再试!");
		}
		return ResultUtil.error("密码有误");
	}

	/**
	 * 登录
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/loginDev")
	public Result loginDev(String zhanghao,String devPassword,HttpServletRequest request,HttpServletResponse response){
		//验证码
		String checkImg = (String) request.getSession().getAttribute("checkImg");
		String code = request.getParameter("code");

		/*if(checkImg==null){
			return ResultUtil.error(-1, "验证码无法加载,请刷新验证码");
		}
		if(!checkImg.equals(code)){
			return ResultUtil.error(-1, "验证码错误,请重新输入");
		}*/

		//调用方法查询开发人员的信息
		Developer developer=new Developer();
		if (zhanghao!=null && zhanghao.length()!=0) {
			//账号登录
			if("Dev".equals(zhanghao.substring(0, 3))){
				developer.setDevId(zhanghao);
			}else 
			//电话登录
			if(StringUtils.isNum(zhanghao)){
				developer.setDevPhone(zhanghao);
			}

			//密码
			developer.setDevPasswordmd5(MD5Utils.md5(devPassword));
			//developer.setDevPassword(devPassword);

			//存进Session
			Result result = developerService.loginDev(developer);

			//等于一说明登录成功
			if (result.getCode()==1) {
				developer=developerService.selectOneDeveloper(developer);
				request.getSession().setAttribute("developer", developer);

				//记住密码
				if("true".equals(request.getParameter("remPassword"))){
					try {
						Cookie autologinC = new Cookie("remPassword",URLEncoder.encode(zhanghao+":"+developer.getDevPasswordmd5(),"utf-8"));
						autologinC.setPath("/");
						autologinC.setMaxAge(3600*24*30);
						response.addCookie(autologinC);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}

				//--处理30天内自动登陆
				if("true".equals(request.getParameter("autologin"))){
					try {
						Cookie autologinC = new Cookie("autologin",URLEncoder.encode(zhanghao+":"+developer.getDevPasswordmd5(),"utf-8"));
						autologinC.setPath("/");
						autologinC.setMaxAge(3600*24*30);
						response.addCookie(autologinC);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}

			//--处理记住用户名
			try {
				Cookie remnameC = new Cookie("remname",URLEncoder.encode(zhanghao,"utf-8"));
				remnameC.setPath("/");
				remnameC.setMaxAge(3600*24*30);
				response.addCookie(remnameC);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			return result;
		}
		return ResultUtil.error("账号格式有误,请重新输入!");
	}
	
	
	/**
	 * 退出登录
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/logoutDev")
	public Result logoutDev(HttpServletRequest request,HttpServletResponse response){
		Developer developer = (Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			//清除session信息
			request.getSession().invalidate();
			//删除自动登陆cookie
			Cookie autologinC = new Cookie("autologin","");
			autologinC.setPath("/");
			autologinC.setMaxAge(0);
			response.addCookie(autologinC);
			return ResultUtil.success(null,"注销成功");
		}
		return ResultUtil.success(null,"你还没登录!");
	}
	
	
	/**
	 * 实名
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/realnameDev")
	public Result realnameDev(HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			Developer developer2 = developerService.selectDevById(developer.getDevId());
			if (developer2.getDevTrue()!=1) {
				developer2=new Developer();
				//接收身份证Id和姓名
				String devIdcard=request.getParameter("devIdcard");
				String devTruename = request.getParameter("devTruename");
				if(devIdcard==null || devIdcard.length()!=18 || devTruename==null || devTruename.length()==0){
					return ResultUtil.error("实名信息有误,请重新输入");
				}

				developer2.setDevTruename(devTruename);
				developer2.setDevIdcard(devIdcard);
				developer2.setDevId(developer.getDevId());

				Result result = developerService.updateDeveloper(developer2);
				/*if (result.getCode()==1) {
					developer = developerService.selectDevById(developer.getDevId());
					request.getSession().setAttribute("developer", developer);
					result.setMsg("验证成功");
				}*/
				return result;
			}
			return ResultUtil.error("你已实名验证");
		}
		return ResultUtil.error("你没有登录,请登录再试");
	}
	
	@ResponseBody
	@RequestMapping(value="/updateDevImg")
	public Result updateDevImg(MultipartFile devPic,HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			Developer developer2=new Developer();
		    //判断是否上传图片
			if(devPic !=null){
				if (devPic.getSize()>1572864) {
					return ResultUtil.error("图片大于1.5M");
				}
				//调用方法上传图片到服务器上
				String imgDeveloper = uploadFileUtils.thumbnailUploadImage(devPic, developer.getDevId(),request);
				if(imgDeveloper !=null){
					//设置图片名到developer对象里
					developer2.setDevImg(imgDeveloper);
					developer2.setDevId(developer.getDevId());

					//调用方法更新开发人员的信息
					Result result = developerService.updateDeveloper(developer2);
					//如果登录用户是修改用户,就更新session,
					/*if(developer.getDevId()==developer2.getDevId()){
						developer = developerService.selectDevById(developer2.getDevId());
						request.getSession().setAttribute("developer", developer);
					}*/
					return result;
				}
				//提示信息
				return ResultUtil.error("图片上传失败");
			}
			return ResultUtil.error("图片上传失败!");
		}
		return ResultUtil.error("你还没登录,请你登录再试");
	}
	/**
	 * 修改普通信息
	 * @param
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateDev")
	public Result updateDev(HttpServletRequest request){
		Developer developer2=(Developer) request.getSession().getAttribute("developer");
		if(developer2!=null){
			//接受信息
		    String devName=request.getParameter("devName");
		    String devNumber=request.getParameter("devNumber");
		    String devSchool=request.getParameter("devSchool");
		    String devLocation=request.getParameter("devLocation");
		    String devSpeciality=request.getParameter("devSpeciality");
		    String devInfo=request.getParameter("devInfo");
			//接收身份证Id和姓名
			String devIdcard=request.getParameter("devIdcard");
			String devTruename = request.getParameter("devTruename");


			if (devTruename != null || devIdcard != null) {
				boolean num = StringUtils.isNum(devIdcard);
				if (num) {
					if ((devIdcard != null && devIdcard.length()!=18) || devIdcard ==null) {
						return ResultUtil.error("身份证信息有误");
					}
					if (devTruename == null || devTruename=="") {
						return ResultUtil.error("名字信息有误");
					}
				}else {
					return ResultUtil.error("身份证信息有误");
				}
			}

			String devEmail=request.getParameter("devEmail");
			if (devEmail != null) {
				boolean b = StringUtils.checkEmail(devEmail);
				if (!b) {
					return ResultUtil.error("邮箱格式有误");
				}
			}
		    Developer developer=new Developer();
		    //判断用户名
		    if (devName!=null && !"".equals(devName)) {

				developer.setDevName(devName);
				developer.setDevNumber(devNumber);
				developer.setDevSchool(devSchool);
				developer.setDevLocation(devLocation);
				developer.setDevSpeciality(devSpeciality);
				developer.setDevInfo(devInfo);
				developer.setDevId(developer2.getDevId());


				developer.setDevIdcard(devIdcard);
				developer.setDevTruename(devTruename);
				developer.setDevEmail(devEmail);
				//调用方法更新开发人员的信息
				Result result = developerService.updateDeveloper(developer);

				//如果登录用户是修改用户,就更新session,
				if(developer2.getDevId()==developer.getDevId()){
					developer2 = developerService.selectDevById(developer.getDevId());
					request.getSession().setAttribute("developer", developer2);
				}
				return result;
			}
			return ResultUtil.error("用户名称有误");
		}
		return ResultUtil.error("你没有登录,请登录再试!");
	}
	
	
	/**
	 * 改用户Id
	 * @param
	 * @return
	 */
	/*@ResponseBody
	@RequestMapping(value="/updateDevId")
	public Result updateDevId(HttpServletRequest request,String newDevId,String DevPassword){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			//判断用户新Id和密码
			if (newDevId!=null && newDevId.length()!=0 && DevPassword!=null && DevPassword.length()!=0) {
				//合成创建新密码
				newDevId="Dev_"+newDevId;
				Developer developer1 = developerService.selectDevById(developer.getDevId());
				//验证密码是否正确
				if (developer1.getDevPasswordmd5().equals(MD5Utils.md5(DevPassword))) {
					Developer developer2 = new Developer();
					developer2.setDevId(newDevId);
					Result result = developerService.updateDeveloperId(developer2,developer.getDevId());
					if (result.getCode()==1) {
						developer = developerService.selectDevById(newDevId);
						request.getSession().setAttribute("developer", developer);
					}
					return result;
				}
				return ResultUtil.error("密码输入有误,请重试!");
			}
			return ResultUtil.error("Id输入有误,请重试!");
		}
		return ResultUtil.error("你没有登录,请登录再试!");
	}*/
	
	
	
	/**
	 * 改用户密码
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updatePWDev")
	public Result updatePWDev(HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			String devPassWord=request.getParameter("devPassWord");
			Developer developer2 = developerService.selectDevById(developer.getDevId());
			if (developer2.getDevPasswordmd5().equals(MD5Utils.md5(devPassWord))) {
				String devPassWordOne=request.getParameter("devPassWordOne");
				String devPassWordTwo=request.getParameter("devPassWordTwo");
				if (devPassWordOne!=null && devPassWordOne.length()!=0 && devPassWordTwo!=null && devPassWordTwo.length()!=0) {
					if (devPassWordOne.equals(devPassWordTwo)) {
						Developer developer3=new Developer();
						developer3.setDevId(developer2.getDevId());
						developer3.setDevPassword(devPassWordOne);
						developer3.setDevPasswordmd5(MD5Utils.md5(devPassWordOne));

						Result result = developerService.updateDeveloper(developer3);
						if (result.getCode()==1) {
							developer = developerService.selectDevById(developer.getDevId());
							request.getSession().setAttribute("developer", developer);
						}
						return result;
					}
					return ResultUtil.error("两次密码输入不一致");
				}
				return ResultUtil.error("新密码不能为空");
			}
			return ResultUtil.error("旧密码有误,请重新输入");
		}
		return ResultUtil.error("你没有登录,请登录再试");
	}
	
	/**
	 * 改用户电话号码
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updaPhoneDev")
	public Result updaPhoneDev(HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			//接收电话号码
			String devPhone=request.getParameter("devPhone");
			if (devPhone!=null && devPhone.length()==11 ) {
				//接收和验证密码
				String devPassWord=request.getParameter("devPassWord");
				if (devPassWord != null) {
					Developer developer2 = developerService.selectDevById(developer.getDevId());
					if (developer2 != null) {
						if (MD5Utils.md5(devPassWord).equals(developer2.getDevPasswordmd5())) {
							developer2.setDevPhone(devPhone);
							developer2.setDevId(developer.getDevId());
							Result result = developerService.updateDeveloper(developer2);
							if (result.getCode()==1) {
								developer = developerService.selectDevById(developer.getDevId());
								request.getSession().setAttribute("developer", developer);
							}
							return result;
						}
						return ResultUtil.error("密码错误");
					}
					return ResultUtil.error("此用户不存在");
				}
				return ResultUtil.error("密码有误,请重新输入");
			}
			return ResultUtil.error("电话格式有误,请重新输入");
		}
		return ResultUtil.error("你没有登录,请登录再试");
	}
	
	/**
	 * 改用户邮箱
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updaEmailDev", method = RequestMethod.POST)
	public Result updaEmailDev(HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			//String devPassWord=(String) request.getParameter("devPassWord");
			//Developer developer2 = developerService.selectDevById(developer.getDevId());
			/*if (!developer2.getDevPasswordmd5().equals(MD5Utils.md5(devPassWord))) {
				return ResultUtil.error("密码错误");
			}*/

			String devEmail=request.getParameter("devEmail");
			if (devEmail!=null && devEmail.length()!=0 ) {
				boolean b = StringUtils.checkEmail(devEmail);
				if (!b) {
					return ResultUtil.error("邮箱格式有误");
				}

				developer=new Developer();
				//developer2.setDevPhone(devPhone);
				developer.setDevId(developer.getDevId());
				Result result = developerService.updateDeveloper(developer);
				/*if (result.getCode()==1) {
					developer = developerService.selectDevById(developer.getDevId());
					request.getSession().setAttribute("developer", developer);
				}*/
				return result;
			}
			return ResultUtil.error("邮箱格式有误,请重新输入");
		}
		return ResultUtil.error("你没有登录,请登录再试");
	}
	
	
	
	/**
	 * 查询全部信息
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectDev")
	public Result selectDev(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							@RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							Integer OrderByClause,HttpServletRequest request){

		if (OrderByClause !=null || OrderByClause>4 || OrderByClause <1) {
			return ResultUtil.error("OrderByClause有误");
		}

	    String devName=request.getParameter("devName");
	    String devNumber=request.getParameter("devNumber");
	    String devSchool=request.getParameter("devSchool");
	    String devLocation=request.getParameter("devLocation");
	    String devSpeciality=request.getParameter("devSpeciality");
	    
	    Developer developer=new Developer();
	    developer.setDevName(devName);
	    developer.setDevNumber(devNumber);
	    developer.setDevSchool(devSchool);
	    developer.setDevLocation(devLocation);
	    developer.setDevSpeciality(devSpeciality);
	    developer.setOrderByClause(OrderByClause);

		//调用方法查询开发人员的信息
		return developerService.selectDeveloper(developer,fenye,pageSize);
	}
	
	/**
	 * 根据Id或手机号码查询一个人的信息
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectDevByIdPhone")
	public Result selectDeveloperById(String zhanghao, HttpServletRequest request){
		if (zhanghao !=null && zhanghao.length()>0) {
			//Developer developer=(Developer) request.getSession().getAttribute("developer");
			//if(developer!=null){
				Developer developer2=new Developer();
				//电话查询
				if(StringUtils.isNum(zhanghao)){
					developer2.setDevPhone(zhanghao);
				}else 
				//账号查询
				if("Dev".equals(zhanghao.substring(0, 3))){
					developer2.setDevId(zhanghao);
				}else {
					return ResultUtil.error("查询数据有误");
				}

				//调用方法查询开发人员的信息
				Developer developer = developerService.selectOneDeveloper(developer2);
				if (developer != null) {
					DeveloperCut developerCut=new DeveloperCut();
					try {
						BeanUtils.copyProperties(developerCut, developer);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}

					return ResultUtil.success(developerCut,"查询成功");
				}
				return ResultUtil.success(null,"无数据");

			//}
			//return ResultUtil.error("你没有登录,请登录再试");
		}
		return ResultUtil.error("查询格式有误,请重新输入!");
	}

	/**
	 * 登录后查询自己的信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/selectDevById2")
	public Result selectDeveloperById(HttpServletRequest request){
		Developer developer=(Developer) request.getSession().getAttribute("developer");
		if(developer!=null){
			//调用方法查询开发人员的信息
			return developerService.selectDeveloperById(developer.getDevId());
		}
		return ResultUtil.error("你没有登录,请登录再试");
	}

	/**
	 * 按好评数排行版1
	 * @param
	 * @return
	 */
	/*@ResponseBody
	@RequestMapping(value="/rankingsDev")
	public Result rankingsDev(){

		Developer developer=new Developer();
		//调用方法查询开发人员的信息
		return developerService.rankingsDev(developer);

	}*/
	/**
	 * 排行版2
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/rankingsDev2")
	public Result rankingsDev2(@RequestParam(required = false,defaultValue = "10",value = "pageSize")Integer pageSize,
							   @RequestParam(required = false,defaultValue = "1",value = "fenye")Integer fenye,
							   @RequestParam(required = false,defaultValue = "2",value = "OrderByClause")Integer OrderByClause){
		if (OrderByClause !=null && (OrderByClause==2 || OrderByClause ==1)) {
			Developer developer=new Developer();
			developer.setOrderByClause(OrderByClause);
			//调用方法查询开发人员的信息
			return developerService.rankingsDev2(developer,fenye,pageSize);
		}
		return ResultUtil.error("OrderByClause有误");


	}

}

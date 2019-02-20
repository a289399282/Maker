package com.gdpi.maker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转controller
 * @author craly
 * @date 2018年6月9日
 */
@Controller
public class PageController {

	/**
	 * 跳转首页
	 * @return 逻辑视图
	 */
	@RequestMapping("/")
	public String showIndex() {
		return "LookProject";
	}

	/**
	 * 打开对应的jsp
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	/**
	 * 打开对应的jsp
	 * @return
	 */
	@RequestMapping("/test/{page}")
	public String showPages(@PathVariable String page) {
		return "test/"+page;
	}

}

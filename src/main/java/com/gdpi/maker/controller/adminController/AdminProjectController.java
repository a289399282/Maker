package com.gdpi.maker.controller.adminController;

import com.gdpi.maker.pojo.*;
import com.gdpi.maker.service.ProjectService;
import com.gdpi.maker.service.StudioService;
import com.gdpi.maker.service.StudiomemService;
import com.gdpi.maker.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*@Controller
@RequestMapping(value="/admin/project")
public class AdminProjectController {

	@Resource(name="AdminProjectServiceImpl")
	private ProjectService projectService;
	@Resource(name="AdminStudioServiceImpl")
	private StudioService studioService;
	@Resource(name="AdminStudiomemServiceImpl")
	private StudiomemService studiomemService;
	

}*/

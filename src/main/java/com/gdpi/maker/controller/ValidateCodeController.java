package com.gdpi.maker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gdpi.maker.utils.ValidateCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author luojianhui
 * @date 2018/6/21
 */
@Controller
@RequestMapping("")
public class ValidateCodeController {
	@RequestMapping("/checkImg")
    public void getImg(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 从请求中获得 URI ( 统一资源标识符 )
//        String uri = request.getRequestURI();
//        System.out.println("hello : " + uri);
        response.setHeader("content-type", "text/html;charset=UTF-8");
        // 图片宽度
        final int width = 118;
        // 图片高度
        final int height = 45;
        // 指定图片格式 (不是指MIME类型)
        final String imgType = "jpeg";
        // 获得可以向客户端返回图片的输出流
        final OutputStream output = response.getOutputStream();
        // 创建验证码图片并返回图片上的字符串
        String code = ValidateCode.create(width, height, imgType, output);
        // 建立 uri 和 相应的 验证码 的关联 ( 存储到当前会话对象的属性中 )
        System.out.println(code);
        session.setAttribute("checkImg", code);
    }
}

package cn.ekgc.dkscm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.ekgc.dkscm.controller.base.BaseController;
import cn.ekgc.dkscm.pojo.entity.User;
import cn.ekgc.dkscm.service.UserService;
import cn.ekgc.dkscm.util.MD5Util;

@Controller("userController")
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource(name = "userService")
	private UserService userService;
	
	/**
	 * <b>转发到登录界面</b>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String forwardLoginForm() throws Exception {
		// 转发到登录界面
		return "user/login";
	}
	
	/**
	 * <b>进行用户登录</b>
	 * @param cellphone
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginError() throws Exception {
		// 如果一旦集成了Shiro的安全认证机制，那么此时的post请求，
		// 将会变为当Shiro认证失败之后所调用的请求
		// 如果登陆失败，则可以进行退出操作
		return "redirect:logout";
	}
}

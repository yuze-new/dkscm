package cn.ekgc.dkscm.util.filter;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ekgc.dkscm.pojo.entity.User;
import cn.ekgc.dkscm.service.UserService;
import cn.ekgc.dkscm.util.MD5Util;

@Component("shiroDBRealm")
public class ShiroDBRealm extends AuthorizingRealm  {
	@Resource(name = "userService")
	private UserService userService;
	@Autowired
	private HttpSession session;

	/**
	 * <b>当使用Shiro进行授权的时候，会调用的方法</b>
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	/**
	 * <b>当Shiro进行用户身份认证的时候，所调用的方法</b>
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) 
			throws AuthenticationException {
		// 对于Shiro来说，该方法将会具体处理登陆过程
		// Shiro会将用户登录的所有数据封装到AuthenticationToken
		// 由于我们登录使用的是用户名密码，因此需要对AuthenticationToken进行强制类型转换
		// Shiro会调用request.getParameter("username")，request.getParameter("password")
		UsernamePasswordToken userToken = (UsernamePasswordToken) token;
		String cellphone = userToken.getUsername();
		char[] password = userToken.getPassword();
		
		if(cellphone != null && !"".equals(cellphone) && password != null
				&& !"".equals(password)) {
			// 用户填写的是有效的登录信息
			// 对于此时的用户名进行加密处理
			String passwords = MD5Util.encrypt(new String(password));
			userToken.setPassword(passwords.toCharArray());
			try {
				User user = userService.findUserBy(cellphone);
				if(user != null) {
					SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
							user.getCellphone(), user.getPassword(), getName());
					session.setAttribute("user", user);
					return info;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	

}

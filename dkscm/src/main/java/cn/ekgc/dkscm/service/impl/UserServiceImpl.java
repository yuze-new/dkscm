package cn.ekgc.dkscm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ekgc.dkscm.dao.UserDao;
import cn.ekgc.dkscm.pojo.entity.User;
import cn.ekgc.dkscm.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	public User findUserBy(String cellphone) throws Exception {
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("cellphone", cellphone);
		try {
			List<User> list = userDao.findUserBy(userMap);
			if(list != null && list.size() > 0) {
				return list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

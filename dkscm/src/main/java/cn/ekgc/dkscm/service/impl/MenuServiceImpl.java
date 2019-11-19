package cn.ekgc.dkscm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ekgc.dkscm.dao.MenuDao;
import cn.ekgc.dkscm.pojo.entity.Menu;
import cn.ekgc.dkscm.pojo.entity.Role;
import cn.ekgc.dkscm.service.MenuService;

@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;

	
	public List<Menu> findMenuBy(Role role) throws Exception {
		Map<String, Object> menuMap = new HashMap<String, Object>();
		menuMap.put("roleId", role.getRoleId());
		menuMap.put("parentId", 0L);
		menuMap.put("statusCode", "ENABLE");
		List<Menu> menuList = menuDao.findMenuBy(menuMap);
		if(menuList != null && menuList.size() > 0) {
			for (Menu menu : menuList) {
				menuMap.put("parentId", menu.getMenuId());
				List<Menu> list = menuDao.findMenuBy(menuMap);
				menu.setChildList(list);
			}
		}
		return menuList;
	}

}

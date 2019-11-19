package cn.ekgc.dkscm.service;

import java.util.List;

import cn.ekgc.dkscm.pojo.entity.Menu;
import cn.ekgc.dkscm.pojo.entity.Role;

public interface MenuService {

	List<Menu> findMenuBy(Role role) throws Exception;

}

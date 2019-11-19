package cn.ekgc.dkscm.service;

import java.util.Map;

import cn.ekgc.dkscm.pojo.entity.User;

public interface UserService {

	User findUserBy(String cellphone) throws Exception;

}

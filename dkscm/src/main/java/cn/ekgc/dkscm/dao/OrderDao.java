package cn.ekgc.dkscm.dao;

import java.util.List;
import java.util.Map;

import cn.ekgc.dkscm.pojo.entity.Purchase;

public interface OrderDao {

	List<Purchase> getFindBy(Map<String, Object> map) throws Exception;

}

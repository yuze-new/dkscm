package cn.ekgc.dkscm.service;

import cn.ekgc.dkscm.pojo.entity.Purchase;
import cn.ekgc.dkscm.pojo.vo.Page;

public interface OrderService {

	Page<Purchase> getPurchase(String context, Page<Purchase> page) throws Exception;

}

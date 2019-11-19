package cn.ekgc.dkscm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ekgc.dkscm.dao.OrderDao;
import cn.ekgc.dkscm.pojo.entity.Purchase;
import cn.ekgc.dkscm.pojo.vo.Page;
import cn.ekgc.dkscm.service.OrderService;
import cn.ekgc.dkscm.util.ConstantUtil;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDao orderDao;

	public Page<Purchase> getPurchase(String context, Page<Purchase> page) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNum", ConstantUtil.PAGE_NUM);
		map.put("pageSize", ConstantUtil.PAGE_SIZE);
		map.put("statusCode", context);
		
		List<Purchase> list = orderDao.getFindBy(map);
		map.remove("pageNum");
		map.remove("pageSize");
		Long totalSize = (long) orderDao.getFindBy(map).size();
		Long totalPage = (totalSize % page.getPageSize() == 0) ? (totalSize / page.getPageSize()) : (totalSize / page.getPageSize()) + 1;
		
		page.setList(list);
		page.setTotalSize(totalSize);
		page.setTotalPage(totalPage);
		return page;
	}

}

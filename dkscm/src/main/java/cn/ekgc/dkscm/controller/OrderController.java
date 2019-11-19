package cn.ekgc.dkscm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ekgc.dkscm.controller.base.BaseController;
import cn.ekgc.dkscm.pojo.entity.Purchase;
import cn.ekgc.dkscm.pojo.vo.Page;
import cn.ekgc.dkscm.service.OrderService;
import cn.ekgc.dkscm.util.ConstantUtil;

@Controller("orderController")
@RequestMapping("/order")
public class OrderController extends BaseController {
	@Resource(name = "orderService")
	private OrderService orderService;
	
	@RequestMapping(value = "/{context}/index", method = RequestMethod.GET)
	public String orderIndex(@PathVariable("context") String context, ModelMap map) 
			throws Exception{
		map.put("context", context);
		if (ConstantUtil.STATUS_APPLY.equals(context)) {
			return "purchase/purchase_apply";
		} else if (ConstantUtil.STATUS_REVIEW.equals(context)) {
			return "purchase/purchase_review";
		} else if (ConstantUtil.STATUS_PURCHASE.equals(context)) {
			return "purchase/purchase_purchase";
		} else if (ConstantUtil.STATUS_REPO_REVIEW.equals(context)) {
			return "purchase/purchase_repo_review";
		} else if (ConstantUtil.STATUS_REPO.equals(context)) {
			return "purchase/purchase_repo";
		} else if (ConstantUtil.STATUS_RECEIVE.equals(context)) {
			return "purchase/purchase_receive";
		} else if (ConstantUtil.STATUS_REVIEW_BACK.equals(context)) {
			return "purchase/purchase_review_back";
		} else if (ConstantUtil.STATUS_REPO_BACK.equals(context)) {
			return "purchase/purchase_repo_back";
		}
		return "";
	}
	
	@RequestMapping(value = "/{context}/list", method = RequestMethod.POST)
	@ResponseBody
	public Page<Purchase> orderList(@PathVariable("context") String context, Integer pageNum, 
			Integer pageSize, Integer draw) throws Exception {
		Page<Purchase> page = new Page<Purchase>(pageNum, pageSize, draw);
		page = orderService.getPurchase(context, page);
		return page;
	}
}

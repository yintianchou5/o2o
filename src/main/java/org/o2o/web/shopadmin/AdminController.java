package org.o2o.web.shopadmin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.o2o.entity.Shop;
import org.o2o.util.HttpServletRequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "shopadmin", method = { RequestMethod.GET,
		RequestMethod.POST })
public class AdminController {
	
	@RequestMapping(value = "/shopedit")
	private String shopEdit() {
		return "shop/shopedit";
	}
	
	@RequestMapping(value = "/shoplist")
	private String shopList() {
		return "shop/shoplist";
	}
	
	@RequestMapping(value = "/shopmanage")
	private String shopManage() {
		return "shop/shopmanage";
	}
	
	@RequestMapping(value = "/productcategorymanage")
	private String productCategorymanage() {
		return "shop/productcategorymanage";
	}
	
	@RequestMapping(value = "/productedit")
	private String productEdit() {
		return "shop/productedit";
	}
	@RequestMapping(value = "/productmanage")
	private String productManage() {
		return "shop/productmanage";
	}
}

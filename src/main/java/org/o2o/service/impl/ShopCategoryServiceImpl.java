package org.o2o.service.impl;

import java.util.List;

import org.o2o.dao.ShopCategoryDao;
import org.o2o.entity.ShopCategory;
import org.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService{
	@Autowired
	private ShopCategoryDao shopCategoryDao;
	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		return shopCategoryDao.queryShopCategory(shopCategoryCondition);
	}

}

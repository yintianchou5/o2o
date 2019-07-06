package org.o2o.service;

import java.util.List;

import org.o2o.entity.ShopCategory;

public interface ShopCategoryService {
	/**
	 * 根据查询条件获取ShopCategory
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}

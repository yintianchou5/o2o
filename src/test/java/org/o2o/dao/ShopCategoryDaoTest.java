package org.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.o2o.BaseTest;
import org.o2o.entity.ShopCategory;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopCategoryDaoTest extends BaseTest{
	@Autowired
	private ShopCategoryDao shopCategoryDao;
	@Test
	public void testQueryShopCategory() {
		List<ShopCategory> shopCategoryList=shopCategoryDao.queryShopCategory(null);
		System.out.println(shopCategoryList.size());
//		assertEquals(2, shopCategoryList.size()); 
//		ShopCategory testCategory=new ShopCategory();
//		ShopCategory parentCategory=new ShopCategory();
//		parentCategory.setShopCategoryId(1l);
//		testCategory.setParent(parentCategory);
//		shopCategoryList=shopCategoryDao.queryShopCategory(testCategory);
//		assertEquals(1, shopCategoryList.size()); 
	}
}

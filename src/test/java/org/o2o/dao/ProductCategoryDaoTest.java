package org.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.o2o.BaseTest;
import org.o2o.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
//test执行顺序是不确定的，下面的注解能实现方法根据名字（根据名字去排序）去执行，如果方法名为A、B、C  ，则先执行方法A在执行方法B在执行方法C
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCategoryDaoTest extends BaseTest{
	@Autowired
	private ProductCategoryDao productCategoryDao;
	
	
	@Test
	public void testQueryByShopId() {
		long shopId=1;
		List<ProductCategory> ProductCategoryList = productCategoryDao.queryProductCategoryList(shopId);
		System.out.println("该店铺商品种类数为："+ProductCategoryList.size());
	}
	
	@Test
	public void testBatchInsertProductCategory() {
		ProductCategory productCategory=new ProductCategory();
		productCategory.setProductCategoryName("商品类别1");
		productCategory.setPriority(1);
		productCategory.setCreateTime(new Date());
		productCategory.setShopId(1l);
		ProductCategory productCategory2=new ProductCategory();
		productCategory2.setProductCategoryName("商品类别2");
		productCategory2.setPriority(2);
		productCategory2.setCreateTime(new Date());
		productCategory2.setShopId(1l);
		List<ProductCategory> productCategoryList=new ArrayList<ProductCategory>();
		productCategoryList.add(productCategory);
		productCategoryList.add(productCategory2);
		int effectedNum = productCategoryDao.batchInsetProductCategory(productCategoryList);
		assertEquals(2,effectedNum);
	}
	@Test
	public void testDeleteProductCategory()throws Exception{
		long shopId=1;
		List<ProductCategory> productCategoryList=productCategoryDao.queryProductCategoryList(shopId);
		for(ProductCategory productCategory:productCategoryList) {
			if("商品类别1".equals(productCategory.getProductCategoryName())||"商品类别2".equals(productCategory.getProductCategoryName())) {
				int effectedNum = productCategoryDao.deleteProductCategory(productCategory.getProductCategoryId(), shopId);
				assertEquals(1, effectedNum);
			}
		}
	}
}

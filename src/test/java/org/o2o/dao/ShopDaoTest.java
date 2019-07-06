package org.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.o2o.BaseTest;
import org.o2o.entity.Area;
import org.o2o.entity.PersonInfo;
import org.o2o.entity.Shop;
import org.o2o.entity.ShopCategory;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopDaoTest extends BaseTest{
	@Autowired
	private ShopDao shopDao;
	
	@Test
	public void testQueryShopListAndCount() {
		Shop shopCondition =new Shop();
		ShopCategory childCategory=new ShopCategory();
		ShopCategory parentCategory=new ShopCategory();
		parentCategory.setShopCategoryId(3L);
		childCategory.setParent(parentCategory);
		shopCondition.setShopCategory(childCategory);
		List<Shop> shopList=shopDao.queryShopList(shopCondition, 0, 6);
		int count=shopDao.queryShopCount(shopCondition);
		System.out.println("店铺列表大小："+shopList.size());
		System.out.println("店铺总数："+count);
//		ShopCategory sc=new ShopCategory();
//		sc.setShopCategoryId(2l);
//		shopCondition.setShopCategory(sc);
//		shopList=shopDao.queryShopList(shopCondition, 0, 3);
//		count=shopDao.queryShopCount(shopCondition);
//		System.out.println("new店铺列表大小："+shopList.size());
//		System.out.println("new店铺总数："+count);
	}
	
	@Test
	@Ignore
	public void testQueryByShopId() {
		long shopId=1;
		Shop shop=shopDao.queryByShopId(shopId);
		System.out.println("areaId:"+shop.getArea().getAreaId());
		System.out.println("areaName:"+shop.getArea().getAreaName());
	}
	@Test
	@Ignore
	public void testInsertShop() {
		Shop shop=new Shop();
		PersonInfo owner=new PersonInfo();
		Area area=new Area();
		ShopCategory shopCategory=new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(1);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("大台北");
		shop.setShopDesc("奶茶专卖");
		shop.setShopAddr("农大专卖店");
		shop.setShopImg("还未拥有");
		shop.setEnableStatus(1);//可用
		shop.setAdvice("审核中");
		shop.setCreateTime(new Date());
		shop.setPhone("15070450050");
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}
	@Test
	@Ignore
	public void testUpdateShop() {
		Shop shop=new Shop();
		shop.setShopId(2L);
		shop.setShopName("大台南");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}
}

package org.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.o2o.BaseTest;
import org.o2o.dto.ImageHolder;
import org.o2o.dto.ShopExecution;
import org.o2o.entity.Area;
import org.o2o.entity.PersonInfo;
import org.o2o.entity.Shop;
import org.o2o.entity.ShopCategory;
import org.o2o.enums.ShopStateEnum;
import org.o2o.exception.ShopOperationException;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopServiceTest extends BaseTest{
	@Autowired
	private ShopService shopService;
	
	
	@Test
	public void testGetShopList() {
		Shop shopCondition=new Shop();
		ShopCategory sc=new ShopCategory();
		sc.setShopCategoryId(2l);
		shopCondition.setShopCategory(sc);
		ShopExecution se = shopService.getShopList(shopCondition, 2, 3);
		System.out.println("店铺列表数为："+se.getShopList().size());
		System.out.println("店铺总数为："+se.getCount());
	}
	
	@Test
	@Ignore
	public void testModifyShop() throws ShopOperationException,FileNotFoundException {
		Shop shop=new Shop();
		shop.setShopId(19l);
		shop.setShopName("农大专卖店1");
		File shopImg=new File("C:\\Users\\xxx-d2q\\Desktop\\测试文件夹\\图片\\2.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder=new ImageHolder(shopImg.getName(),is);
		ShopExecution shopExecution = shopService.modifyShop(shop, imageHolder);
		System.out.println("新的图片地址为："+shopExecution.getShop().getShopImg());
	}
	@Test
	@Ignore
	public void testAddShop() throws ShopOperationException,FileNotFoundException {
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
		shop.setShopName("大台狗");
		shop.setShopDesc("奶茶专卖狗");
		shop.setShopAddr("农大专卖店狗");
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		shop.setCreateTime(new Date());
		shop.setPhone("15070450052");
		shop.setPriority(1);
		File shopImg=new File("C:\\Users\\xxx-d2q\\Desktop\\测试文件夹\\图片\\3.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder=new ImageHolder(shopImg.getName(),is);
		ShopExecution se = shopService.addShop(shop,imageHolder);
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}
}

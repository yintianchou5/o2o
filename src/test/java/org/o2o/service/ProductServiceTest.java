package org.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.o2o.BaseTest;
import org.o2o.dto.ImageHolder;
import org.o2o.dto.ProductExecution;
import org.o2o.entity.Product;
import org.o2o.entity.ProductCategory;
import org.o2o.entity.Shop;
import org.o2o.enums.ProductStateEnum;
import org.o2o.exception.ShopOperationException;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceTest extends BaseTest{
	@Autowired
	private ProductService productService;
	
	@Test
	@Ignore
	public void testAddProduct() throws ShopOperationException,FileNotFoundException{
		//创建shopId为1且productCategoryId为1的商品实例并给其他成员变量赋值
		Product product=new Product();
		Shop shop=new Shop();
		shop.setShopId(4L);
		ProductCategory pc=new ProductCategory();
		pc.setProductCategoryId(1L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("测试商品1");
		product.setProductDesc("测试");
		product.setCreateTime(new Date());
		product.setPriority(15);
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
		//创建缩略图文件流
		File thumbnailFile=new File("C:\\Users\\xxx-d2q\\Desktop\\测试文件夹\\图片\\1.jpg");
		InputStream is=new FileInputStream(thumbnailFile);
		ImageHolder thumbnail=new ImageHolder(thumbnailFile.getName(), is);
		//创建两个商品详情图片文件流并将他们添加到详情图列表
		File productImg1=new File("C:\\Users\\xxx-d2q\\Desktop\\测试文件夹\\图片\\2.jpg");
		InputStream is1=new FileInputStream(productImg1);
		File productImg2=new File("C:\\Users\\xxx-d2q\\Desktop\\测试文件夹\\图片\\3.jpg");
		InputStream is2=new FileInputStream(productImg2);
		List<ImageHolder> productImgList=new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
		//添加商品并验证
		ProductExecution pe = productService.addProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}
	@Test
	public void testModifyProduct() throws ShopOperationException,FileNotFoundException{
		//创建shopId为1且productCategoryId为1的商品实例并给其他成员变量赋值
		Product product=new Product();
		Shop shop=new Shop();
		shop.setShopId(1L);
		ProductCategory pc=new ProductCategory();
		pc.setProductCategoryId(1L);
		product.setProductId(3l);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("正式商品1");
		product.setProductDesc("我很正");
		//创建缩略图文件流
		File thumbnailFile=new File("C:\\Users\\xxx-d2q\\Desktop\\测试文件夹\\图片\\4.jpg");
		InputStream is=new FileInputStream(thumbnailFile);
		ImageHolder thumbnail=new ImageHolder(thumbnailFile.getName(), is);
		//创建两个商品详情图片文件流并将他们添加到详情图列表
		File productImg1=new File("C:\\Users\\xxx-d2q\\Desktop\\测试文件夹\\图片\\5.jpg");
		InputStream is1=new FileInputStream(productImg1);
		File productImg2=new File("C:\\Users\\xxx-d2q\\Desktop\\测试文件夹\\图片\\6.jpg");
		InputStream is2=new FileInputStream(productImg2);
		List<ImageHolder> productImgList=new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
		//添加商品并验证
		ProductExecution pe = productService.modifyProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}
	
}

package org.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.o2o.BaseTest;
import org.o2o.entity.Product;
import org.o2o.entity.ProductCategory;
import org.o2o.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest{
	@Autowired
	private ProductImgDao productImgDao;
	@Autowired
	private ProductDao productDao;
	
	@Test
	@Ignore
	public void testAQueryProductByProductId() throws Exception{
		long productId=2;
		Product product = productDao.queryProductById(productId);
		assertEquals(2, product.getProductImgList().size());
	}
	@Test
	@Ignore
	public void testBUpdateProduct()throws Exception{
		Product product=new Product();
		ProductCategory pc=new ProductCategory();
		Shop shop=new Shop();
		shop.setShopId(1l);
		pc.setProductCategoryId(2l);
		product.setProductId(1l);
		product.setShop(shop);
		product.setProductName("我是小绿");
		product.setProductCategory(pc);
		int effectedNum = productDao.updateProduct(product);
		assertEquals(1, effectedNum);
	}
	@Test
	@Ignore
	public void testBQueryProductList()throws Exception{
		Product productCondition=new Product();
		List<Product> productList = productDao.queryProductList(productCondition, 0, 3);
		assertEquals(3, productList.size());
		int count = productDao.queryProductCount(productCondition);
		assertEquals(8, count);
		productCondition.setProductName("小");
		productList=productDao.queryProductList(productCondition, 0, 3);
		assertEquals(3, productList.size());
		count = productDao.queryProductCount(productCondition);
		assertEquals(4, count);
	}
	@Test
	@Ignore
	public void testUpdateProductCategoryToNull() {
		int effectedNum = productDao.updateProductCategoryToNull(6L);
		assertEquals(2,effectedNum);
	}
	@Test
	public void testDeleteProduct() {
		int effectedNum = productDao.deleteProduct(8, 1);
		assertEquals(1,effectedNum);
	}
	
	
}

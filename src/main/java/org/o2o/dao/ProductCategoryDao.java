package org.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.o2o.entity.ProductCategory;

public interface ProductCategoryDao {
	/**
	 * 查询所有商品种类
	 * @param shopId
	 * @return
	 */
	List<ProductCategory> queryProductCategoryList(long shopId);
	
	/**
	 * 批量新增商品类别
	 * @param productCategoryList
	 * @return
	 */
	int batchInsetProductCategory(List<ProductCategory> productCategoryList);
	/**
	 * 根据店铺ID和商品种类ID删除该店铺的该商品类别
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 */
	int deleteProductCategory(@Param("productCategoryId")long productCategoryId,@Param("shopId")long shopId) ;
}

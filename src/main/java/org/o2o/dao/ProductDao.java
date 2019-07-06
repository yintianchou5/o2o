package org.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.o2o.entity.Product;

public interface ProductDao {
	/**
	 * 查询商品列表并分页，可输入的条件有：商品名，商品状态，商品Id，商品类别
	 * @param productCondition
	 * @param rowIndex
	 * @param pageSize
	 * @return
	 */
	List<Product> queryProductList(@Param("productCondition")Product productCondition,@Param("rowIndex") int rowIndex,@Param("pageSize")int pageSize);
	/**
	 *查询对应的商品总数 
	 * @param productCondition
	 * @return
	 */
	int queryProductCount(@Param("productCondition")Product productCondition);
	/**
	 * 添加商品
	 * @param product
	 * @return
	 */
	int insertProduct(Product product);
	/**
	 * 通过productId查询唯一的商品信息
	 * @param productId
	 * @return
	 */
	Product queryProductById(long productId);
	/**
	 * 更新商品信息
	 * @param product
	 * @return
	 */
	int updateProduct(Product product);
	/**
	 * 删除商品类别之前，将商品类别ID置空
	 * @param productCategory
	 * @return
	 */
	int updateProductCategoryToNull(long productCategoryId);
	/**
	 * 删除商品
	 * @param productId
	 * @param shopId
	 * @return
	 */
	int deleteProduct(@Param("productId") long productId,@Param("shopId") long shopId);
}

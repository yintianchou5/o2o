package org.o2o.service;

import java.util.List;

import org.o2o.dto.ProductCategoryExecution;
import org.o2o.entity.ProductCategory;
import org.o2o.exception.ProductCategoryOperationException;

public interface ProductCategoryService {
	/**
	 * 查询某个店铺的所有的商品类别信息
	 * @param shopId
	 * @return
	 */
	List<ProductCategory> getProductCategoryList(long shopId);
	/**
	 * 批量增加商品类别
	 * @param productCategoryList
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws ProductCategoryOperationException;
	/**
	 * 将此类别的下的商品id置为null
	 * 然后根据店铺ID和商品种类ID删除该店铺的该商品类别
	 * @param ProductCategoryId
	 * @param shopId
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId,long shopId)throws ProductCategoryOperationException;
}

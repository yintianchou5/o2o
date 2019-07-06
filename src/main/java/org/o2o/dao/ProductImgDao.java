package org.o2o.dao;

import java.util.List;

import org.o2o.entity.ProductImg;

public interface ProductImgDao {
	/**
	 * 根据商品ID查询他的所有详情图
	 * @param productId
	 * @return
	 */
	List<ProductImg> queryProductImgList(long productId);
	/**
	 * 批量添加商品详情图
	 * @param ProductImgList
	 * @return
	 */
	int batchInsertProductImg(List<ProductImg> productImgList);
	/**
	 * 通过商品ID删除商品详情图片
	 * @param productId
	 * @return
	 */
	int deleteProductImgByProductId(long productId);
}

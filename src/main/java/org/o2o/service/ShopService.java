package org.o2o.service;

import org.o2o.dto.ImageHolder;
import org.o2o.dto.ShopExecution;
import org.o2o.entity.Shop;
import org.o2o.exception.ShopOperationException;

public interface ShopService {
	/**
	 * 根据shopCondition分页返回相应店铺列表
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);
	/**
	 * 通过店铺ID获取店铺信息
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);
	/**
	 * 修改店铺信息
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 */
	ShopExecution modifyShop(Shop shop,ImageHolder thumbnail) throws ShopOperationException;
	/**
	 * 注册店铺
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 */
	ShopExecution addShop(Shop shop,ImageHolder thumbnail) throws ShopOperationException;
}

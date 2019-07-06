 package org.o2o.service.impl;

import java.util.List;

import org.o2o.dao.ProductCategoryDao;
import org.o2o.dao.ProductDao;
import org.o2o.dto.ProductCategoryExecution;
import org.o2o.entity.ProductCategory;
import org.o2o.enums.ProductCategoryStateEnum;
import org.o2o.exception.ProductCategoryOperationException;
import org.o2o.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{
	@Autowired
	private ProductCategoryDao productCategoryDao;
	@Autowired
	private ProductDao productDao;
	@Override
	public List<ProductCategory> getProductCategoryList(long shopId) {
		return productCategoryDao.queryProductCategoryList(shopId);
	}
	@Override
	public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException {
		if(productCategoryList!=null&&productCategoryList.size()>0) {
			try {
				int effectedNum = productCategoryDao.batchInsetProductCategory(productCategoryList);
				if(effectedNum<=0) {
					throw new ProductCategoryOperationException("店铺类别创建失败！");
				}else {
					return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
				}
			}catch(Exception e) {
				throw new ProductCategoryOperationException("batchAddProductCategory error:"+e.getMessage());
			}
		}else {
			return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
		}
	}
	@Override
	@Transactional
	public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException {
		//解除tb_product里的商品与该productcategoryId的关联
		try {
			int effectedNum = productDao.updateProductCategoryToNull(productCategoryId);
			if(effectedNum<0) {
				throw new ProductCategoryOperationException("商品类别更新失败");
			}
		}catch(Exception e) {
			throw new ProductCategoryOperationException("deleteProductCategory error:"+e.getMessage());
		}
		//删除该productCategory
		try {
			int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
			if(effectedNum<=0) {
				throw new ProductCategoryOperationException("商品删除失败!");
			}else {
				return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
			}
		}catch(Exception e) {
			throw new ProductCategoryOperationException("deleteProductCategory error:"+e.getMessage());  
		}
	}

}
